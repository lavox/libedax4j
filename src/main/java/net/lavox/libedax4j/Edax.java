package net.lavox.libedax4j;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * libedax wrapper interface for Java.
 * 
 * @author lavox
 */
public interface Edax extends Library {

	/**
	 * The instance of libedax wrapper.
	 */
	Edax INSTANCE = (Edax) Native.loadLibrary(Util.getLibraryName(), Edax.class);
	
	/**
	 * Black.
	 */
	public static final int BLACK = 0;
	
	/**
	 * White.
	 */
	public static final int WHITE = 1;
	
	/**
	 * Pass.
	 */
	public static final int PASS = 64;
	
	/**
	 * No Move.
	 */
	public static final int NOMOVE = 65;

	/**
	 * edax init function for library use.
	 *
	 * @param argc
	 *            Number of arguments.
	 * @param argv
	 *            Command line arguments. The first(0-th) value is ignored.
	 */
	public void libedax_initialize(int argc, String[] argv);

	/**
	 * edax terminate function for library use.
	 */
	public void libedax_terminate();

	/**
	 * init command.
	 */
	public void edax_init();

	/**
	 * new command.
	 */
	public void edax_new();

	/**
	 * load command.
	 * 
	 * @param file
	 *            file name to open
	 */
	public void edax_load(String file);

	/**
	 * save command.
	 * 
	 * @param file
	 *            file name to save
	 */
	public void edax_save(String file);

	/**
	 * undo command.
	 */
	public void edax_undo();

	/**
	 * redo command.
	 */
	public void edax_redo();

	/**
	 * mode command.
	 * 
	 * @param mode
	 *            mode to set
	 */
	public void edax_mode(int mode);

	/**
	 * setboard command.
	 * 
	 * @param board
	 *            board to set
	 */
	public void edax_setboard(String board);

	/**
	 * setboard command with board object.
	 * 
	 * @param board
	 *            board to set
	 * @param turn
	 *            player to play
	 */
	public void edax_setboard_from_obj(Board board, int turn);

	/**
	 * vmirror command.
	 */
	public void edax_vmirror();

	/**
	 * hmirror command.
	 */
	public void edax_hmirror();

	/**
	 * rotate command.
	 * 
	 * @param angle
	 *            angle for rotation
	 */
	public void edax_rotate(int angle);

	/**
	 * symetry command.
	 * 
	 * @param sym
	 *            symetry.
	 */
	public void edax_symetry(int sym);

	/**
	 * play command.
	 * 
	 * @param moves
	 *            moves.
	 */
	public void edax_play(String moves);

	/**
	 * force command.
	 * 
	 * @param moves
	 *            moves.
	 */
	public void edax_force(String moves);

	/**
	 * go command.
	 */
	public void edax_go();

	/**
	 * hint command.
	 * 
	 * @param n
	 *            number of hints.
	 * @param hintlist
	 *            result (out parameter).
	 */
	public void edax_hint(int n, HintList hintlist);

	/**
	 * hint command.
	 * Call edax_hint_next after calling this function.
	 */
	public void edax_hint_prepare();

	/**
	 * hint command.
	 * Gets hint one by one. If there are no more hints, hint will be
	 * NOMOVE.
	 * Call edax_hint_prepare before calling this function.
	 * 
	 * @param hint
	 *            result (out parameter).
	 */
	public void edax_hint_next(Hint hint);

	/**
	 * stop command.
	 */
	public void edax_stop();

	/**
	 * user move command.
	 * 
	 * @param move
	 *            user move.
	 * @return true if the move has been legally played, otherwise false.
	 */
	public boolean edax_move(String move);

	/**
	 * opening command.
	 * 
	 * @return opening name.
	 */
	public String edax_opening();

	/**
	 * ouverture command.
	 * 
	 * @return opening name in french.
	 */
	public String edax_ouverture();

	/**
	 * book store command.
	 */
	public void edax_book_store();

	/**
	 * book on command.
	 */
	public void edax_book_on();

	/**
	 * book off command.
	 */
	public void edax_book_off();

	/**
	 * book randomness command.
	 * 
	 * @param randomness
	 *            randomness.
	 */
	public void edax_book_randomness(int randomness);

	/**
	 * book depth command.
	 * 
	 * @param depth
	 *            depth.
	 */
	public void edax_book_depth(int depth);

	/**
	 * book new command.
	 * 
	 * @param level
	 *            level.
	 * @param depth
	 *            depth.
	 */
	public void edax_book_new(int level, int depth);

	/**
	 * book load command.
	 * 
	 * @param book_file
	 *            book file name to load.
	 */
	public void edax_book_load(String book_file);

	/**
	 * book save command.
	 * 
	 * @param book_file
	 *            book file name to save.
	 */
	public void edax_book_save(String book_file);

	/**
	 * book import command.
	 * 
	 * @param import_file
	 *            file name to import.
	 */
	public void edax_book_import(String import_file);

	/**
	 * book export command.
	 * 
	 * @param export_file
	 *            file name to export.
	 */
	public void edax_book_export(String export_file);

	/**
	 * book merge command.
	 * 
	 * @param book_file
	 *            file name to merge.
	 */
	public void edax_book_merge(String book_file);

	/**
	 * book fix command.
	 */
	public void edax_book_fix();

	/**
	 * book negamax command.
	 */
	public void edax_book_negamax();

	/**
	 * book correct command.
	 */
	public void edax_book_correct();

	/**
	 * book prune command.
	 */
	public void edax_book_prune();

	/**
	 * book subtree command.
	 */
	public void edax_book_subtree();

	/**
	 * book show command.
	 * 
	 * @param position
	 *            position information(out parameter).
	 */
	public void edax_book_show(Position position);

	/**
	 * book info command.
	 * 
	 * @param book
	 *            book information(out parameter).
	 */
	public void edax_book_info(Book book);

	/**
	 * book verbose command.
	 * 
	 * @param book_verbosity
	 *            book verbosity.
	 */
	public void edax_book_verbose(int book_verbosity);

	/**
	 * book add command.
	 * 
	 * @param base_file
	 *            base file to add.
	 */
	public void edax_book_add(String base_file);

	/**
	 * book check command.
	 * 
	 * @param base_file
	 *            base file to check.
	 */
	public void edax_book_check(String base_file);

	/**
	 * book extract command.
	 * 
	 * @param base_file
	 *            base file to extract.
	 */
	public void edax_book_extract(String base_file);

	/**
	 * book deviate command.
	 * 
	 * @param relative_error
	 *            relative error.
	 * @param absolute_error
	 *            absolute error.
	 */
	public void edax_book_deviate(int relative_error, int absolute_error);

	/**
	 * book enhance command.
	 * 
	 * @param midgame_error
	 *            midgame error.
	 * @param endcut_error
	 *            endcut error.
	 */
	public void edax_book_enhance(int midgame_error, int endcut_error);

	/**
	 * book fill command.
	 * 
	 * @param fill_depth
	 *            fill depth.
	 */
	public void edax_book_fill(int fill_depth);

	/**
	 * book play command.
	 */
	public void edax_book_play();

	/**
	 * book deepen command.
	 * caution: Currently, this function does not work correctly.
	 */
	public void edax_book_deepen();

	/**
	 * book feed-hash command.
	 */
	public void edax_book_feed_hash();

	/**
	 * base problem command.
	 * 
	 * @param base_file
	 *            game database file.
	 * @param n_empties
	 *            number of empties.
	 * @param problem_file
	 *            problem_file to save.
	 */
	public void edax_base_problem(String base_file, int n_empties,
			String problem_file);

	/**
	 * base tofen command.
	 * 
	 * @param base_file
	 *            game database file.
	 * @param n_empties
	 *            number of empties.
	 * @param problem_file
	 *            problem_file to save.
	 */
	public void edax_base_tofen(String base_file, int n_empties, String problem_file);

	/**
	 * base correct command.
	 * 
	 * @param base_file
	 *            game database file.
	 * @param n_empties
	 *            number of empties.
	 */
	public void edax_base_correct(String base_file, int n_empties);

	/**
	 * base complete command.
	 * 
	 * @param base_file
	 *            game database file.
	 */
	public void edax_base_complete(String base_file);

	/**
	 * base convert command.
	 * 
	 * @param base_file_from
	 *            input game database file.
	 * @param base_file_to
	 *            output game database file.
	 */
	public void edax_base_convert(String base_file_from, String base_file_to);

	/**
	 * base unique command.
	 * 
	 * @param base_file_from
	 *            input game database file.
	 * @param base_file_to
	 *            output game database file.
	 */
	public void edax_base_unique(String base_file_from, String base_file_to);

	/**
	 * set (option) command.
	 * 
	 * @param option_name
	 *            name of option.
	 * @param val
	 *            value to set.
	 */
	public void edax_set_option(String option_name, String val);

	/**
	 * get moves of the current game.
	 * 
	 * @param str
	 *            buffer of length 160 + 1 or more (out parameter).
	 * @return moves(equals to str. This is for Java, as Java String is
	 *         immutable).
	 */
	public String edax_get_moves(String str);

	/**
	 * check if the current game is over.
	 * 
	 * @return true if game is over, otherwise false.
	 */
	public boolean edax_is_game_over();

	/**
	 * check if the current player can move.
	 * 
	 * @return true if the current player can move, otherwise false.
	 */
	public boolean edax_can_move();

	/**
	 * get last move.
	 * 
	 * @param move
	 *            last move(out parameter).
	 */
	public void edax_get_last_move(Move move);

	/**
	 * get current board.
	 * 
	 * @param board
	 *            current board(out parameter).
	 */
	public void edax_get_board(Board board);

	/**
	 * get current player.
	 * 
	 * @return current player(0:BLACK, 1:WHITE).
	 */
	public int edax_get_current_player();

	/**
	 * get current number of discs.
	 * 
	 * @param color
	 *            player's color(0:BLACK, 1:WHITE).
	 * @return number of discs.
	 */
	public int edax_get_disc(int color);

	/**
	 * get current number of legal moves.
	 * 
	 * @param color
	 *            player's color(0:BLACK, 1:WHITE).
	 * @return number of legal moves.
	 */
	int edax_get_mobility_count(int color);
	
	// board.c function

	/**
	 * Get legal moves.
	 *
	 * Compute a bitboard where each coordinate with a legal move is set to one.
	 *
	 * @param P bitboard with player's discs.
	 * @param O bitboard with opponent's discs.
	 * @return all legal moves in a 64-bit integer.
	 */
	long get_moves(long P, long O);

	/**
	 * Check if a player can move.
	 *
	 * @param P bitboard with player's discs.
	 * @param O bitboard with opponent's discs.
	 * @return true or false.
	 */
	boolean can_move(long P, long O);

	// bit.c function
	
	/**
	 * Count the number of bits set to one in an long.
	 *
	 * @param b 64-bit integer to count bits of.
	 * @return the number of bits set.
	 */
	int bit_count(long b);
	
	/**
	 * Search the first bit set.
	 *
	 * @param b 64-bit integer.
	 * @return the index of the first bit set.
	 */
	int first_bit(long b);
	
	/**
	 * Search the last bit set.
	 *
	 * @param b 64-bit integer.
	 * @return the index of the last bit set.
	 */
	int last_bit(long b);
}
