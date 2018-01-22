import net.lavox.libedax4j.Edax;

public class Example3 {

	public static void main(String[] args) {
		// obtain Edax object
		Edax edax = Edax.INSTANCE;

		// you can use board.c/bit.c functions without initialize libedax
		long p = 0x0000000810000000L;
		long o = 0x0000001008000000L;
		
		System.out.println("can_move = " + edax.can_move(p, o));
		System.out.println("get_moves = " + Long.toHexString(edax.get_moves(p, o)));
		
		System.out.println("first_bit = " + edax.first_bit(p));
		System.out.println("last_bit = " + edax.last_bit(p));
	}
}
