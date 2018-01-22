package net.lavox.libedax4j;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * MoveList class.
 * 
 * @author lavox
 */
public class MoveList extends Structure {
	/**
	 * array of legal moves.
	 * 
	 * Note that index of array begins with 1.
	 */
	public Move[] move = (Move[]) (new Move()).toArray(34);

	/**
	 * number of moves.
	 */
	public int n_moves;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList(new String[] { "move", "n_moves" });
	}
	
	/**
	 * clear object properties.
	 * 
	 * When you reuse object for out parameter, you should clear object before calling library function.
	 */
	public void clear() {
		for ( int i = 0 ; i < move.length ; i++ ) {
			move[i].clear();
		}
		n_moves = 0;
	}
}
