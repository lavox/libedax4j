import net.lavox.libedax4j.Book;
import net.lavox.libedax4j.Edax;
import net.lavox.libedax4j.Link;
import net.lavox.libedax4j.Position;
import net.lavox.libedax4j.Util;

public class Example2 {

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

		// book new command
		System.out.println("book new 15 30 command.");
		edax.edax_book_new(15, 30);

		// set book-file option
		System.out.println("set -book-file data/book_example.dat command.");
		edax.edax_set_option("-book-file", "data/book_example.dat");

		// play command
		System.out.println("play f5d6c5f4e3c6d3f6e6d7 command.");
		edax.edax_play("f5d6c5f4e3c6d3f6e6d7");

		// book store command
		System.out.println("book store command.");
		edax.edax_book_store();

		// init command
		System.out.println("init command.");
		edax.edax_init();

		// play command
		System.out.println("play f5d6c3d3 command.");
		edax.edax_play("f5d6c3d3");

		// book store command
		System.out.println("book store command.");
		edax.edax_book_store();

		// book save command
		System.out.println("book save data/book_example.dat command.");
		edax.edax_book_save("data/book_example.dat");

		// init command
		System.out.println("init command.");
		edax.edax_init();

		// play command
		System.out.println("play f5d6 command.");
		edax.edax_play("f5d6");
		System.out.println();

		// book show command
		Position position = new Position();
		edax.edax_book_show(position);

		System.out.println("Position information:");
		System.out.println(" score : " + position.score.value + " ("
				+ position.score.lower + "," + position.score.upper + ")");
		System.out.print(" link  : ");
		Link[] links = (Link[]) position.link.toArray(position.n_link);
		for (Link link : links) {
			System.out.print(
					Util.moveToString(link.move) + "=" + link.score + ", ");
		}
		System.out.println();
		System.out.println(" leaf  : " + Util.moveToString(position.leaf.move)
				+ "=" + position.leaf.score);
		System.out.println(" wins  : " + position.n_wins);
		System.out.println(" draws : " + position.n_draws);
		System.out.println(" losses: " + position.n_losses);
		System.out.println(" lines : " + position.n_lines);
		System.out.println(" level : " + position.level);
		System.out.println();

		// book info command
		Book book = new Book();
		edax.edax_book_info(book);
		System.out.println("Book information:");
		System.out.println(" date   : " + book.date.year + "/" + book.date.month
				+ "/" + book.date.day + " " + book.date.hour + ":"
				+ book.date.minute + ":" + book.date.second);
		System.out.println(" options:");
		System.out.println("   level : " + book.options.level);
		System.out.println("   depth : " + (61 - book.options.n_empties));
		System.out.println("   error : midgame=" + book.options.midgame_error
				+ ", endcut=" + book.options.endcut_error);
		System.out.println(" nodes : " + book.n_nodes);

		edax.libedax_terminate();
	}
}
