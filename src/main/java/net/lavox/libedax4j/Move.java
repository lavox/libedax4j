package net.lavox.libedax4j;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * Move class.
 * 
 * @author lavox
 */
public class Move extends Structure {
	/**
	 * bitboard representation of flipped squares.
	 */
	public long flipped;
	
	/**
	 * square played.
	 */
	public int x;
	
	/**
	 * score for this move.
	 */
	public int score;
	
	/**
	 * move cost.
	 */
	public int cost;
	
	/**
	 * next move in a MoveList.
	 */
	public Pointer next;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList(new String[] { "flipped", "x", "score", "cost", "next" });
	}
	
	/**
	 * clear object properties.
	 * 
	 * When you reuse object for out parameter, you should clear object before calling library function.
	 */
	public void clear() {
		flipped = 0;
		x = 0;
		score = 0;
		cost = 0;
		next = Pointer.NULL;
	}
}
