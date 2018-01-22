package net.lavox.libedax4j;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

/**
 * Line class.
 * 
 * @author lavox
 */
public class Line extends Structure {
	/**
	 * array of a suite of moves. (0-63 for A1-H8, 64 for PASS, 65 for NOMOVE)
	 */
	public byte[] move = new byte[80];
	
	/**
	 * number of moves.
	 */
	public int n_moves;
	
	/**
	 * color of the first player of the sequence.
	 */
	public int color;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList(new String[] { "move", "n_moves", "color" });
	}
	
	/**
	 * clear object properties.
	 * 
	 * When you reuse object for out parameter, you should clear object before calling library function.
	 */
	public void clear() {
		Arrays.fill(move, (byte)0);
		n_moves = 0;
		color = 0;
	}
}
