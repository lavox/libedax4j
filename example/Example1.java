import net.lavox.libedax4j.Board;
import net.lavox.libedax4j.Edax;
import net.lavox.libedax4j.Hint;
import net.lavox.libedax4j.HintList;
import net.lavox.libedax4j.Move;
import net.lavox.libedax4j.Util;

public class Example1 {

	public static void main(String[] args) {
		// obtain Edax object
		Edax edax = Edax.INSTANCE;
		
		// initialize parameter. The first(0-th) value is ignored.
		String[] arg = new String[] { "", "-book-file", "data/book.dat",
				"-eval-file", "data/eval.dat", "-level", "17" };

		// initialize edax
		edax.libedax_initialize(arg.length, arg);
		
		// init command
		edax.edax_init();

		// play command
		edax.edax_play("f5d6c3d3c4f4f6");

		printBoard(edax);
		
		// current discs & mobility
		System.out.print("BLACK: " + edax.edax_get_disc(Edax.BLACK) + "discs ");
		System.out.print(edax.edax_get_mobility_count(Edax.BLACK) + "moves, ");
		System.out.print("WHITE: " + edax.edax_get_disc(Edax.WHITE) + "discs ");
		System.out.print(edax.edax_get_mobility_count(Edax.WHITE) + "moves");
		System.out.println();
		System.out.println();

		// hint command
		HintList hintlist = new HintList();
		edax.edax_hint(10, hintlist);
		System.out.println("Hint result;");
		for (int i = 1; i <= hintlist.n_hints; i++) {
			printHint(hintlist.hint[i]);
		}
		System.out.println();

		// set level
		edax.edax_set_option("-level", "18");
		
		// You can also obtain hint one by one.
		System.out.println("Hint result (one by one) ;");
		edax.edax_hint_prepare();
		Hint hint = new Hint();
		while (true) {
			hint.clear(); // clear object when reusing object.
			edax.edax_hint_next(hint);
			if (hint.move != Edax.NOMOVE) {
				printHint(hint);
			} else {
				break;
			}
		}
		System.out.println();
		
		// check if current player can move
		System.out.println("can move = " + edax.edax_can_move());
		
		// check if the game is over
		System.out.println("is game over = " + edax.edax_is_game_over());
		
		// print moves
		printMoveString(edax);
		System.out.println();
		
		// undo
		edax.edax_undo();
		System.out.println("Undo!");
		printBoard(edax);
		
		printMoveString(edax);
		System.out.println();

		// move c5
		edax.edax_move("c5");
		System.out.println("Move c5!");
		printBoard(edax);
		
		printMoveString(edax);
		System.out.println();

		// go command
		edax.edax_go();
		Move move = new Move();
		edax.edax_get_last_move(move);
		System.out.println("Edax plays " + Util.moveToString(move.x));
		printBoard(edax);
		
		printMoveString(edax);
		System.out.println();

		// set level
		edax.edax_set_option("-level", "7");

		// mode command
		System.out.println("mode changes to 1");
		edax.edax_mode(1);
		move.clear();
		edax.edax_get_last_move(move);
		System.out.println("Edax plays " + Util.moveToString(move.x));
		printBoard(edax);
		
		printMoveString(edax);
		System.out.println();

		// mode command
		System.out.println("mode changes to 2");
		edax.edax_mode(2); // edax_mode runs until game is over
		printBoard(edax);
		
		printMoveString(edax);
		System.out.println();

		edax.libedax_terminate();
	}

	public static void printBoard(Edax edax) {
		// current board & player
		Board board = new Board();
		edax.edax_get_board(board);
		int currentPlayer = edax.edax_get_current_player();

		String playerStone = (currentPlayer == Edax.BLACK) ? "X" : "O";
		String opponentStone = (currentPlayer == Edax.BLACK) ? "O" : "X";

		System.out.println("  a b c d e f g h");
		for (int i = 0; i < 8; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < 8; j++) {
				if ((board.player & (1L << (j + 8 * i))) != 0) {
					System.out.print(playerStone);
				} else if ((board.opponent & (1L << (j + 8 * i))) != 0) {
					System.out.print(opponentStone);
				} else {
					System.out.print(".");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printHint(Hint hint) {
		System.out.print(" " + Util.moveToString(hint.move) + ":");
		System.out.print(" score = " + hint.score);
		if (hint.book_move) {
			System.out.print(", book");
		} else {
			System.out.print("(" + hint.lower + "," + hint.upper + "), ");

			System.out.print(
					hint.depth + "@" + Hint.SELECTIVITY_TABLE[hint.selectivity] + "%, ");
			System.out.print(hint.time + "ms, ");
			System.out.print(hint.n_nodes + "nodes, ");
			System.out.print("pv=");
			for (int i = 0; i < hint.pv[0].n_moves; i++) {
				System.out.print(Util.moveToString(hint.pv[0].move[i]));
			}
		}
		System.out.println();
	}

	public static void printMoveString(Edax edax) {
		System.out.println("moves = "
				+ edax.edax_get_moves(Util.createBuffer(80 * 2 + 1)));
	}
}
