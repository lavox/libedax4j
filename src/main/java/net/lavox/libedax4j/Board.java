package net.lavox.libedax4j;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

/**
 * Board class.
 * 
 * @author lavox
 */
public class Board extends Structure {
	/**
	 * bitboard representation of current player's stones.
	 */
	public long player;
	
	/**
	 * bitboard representation of opponent player's stones.
	 */
	public long opponent;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList(new String[] { "player", "opponent" });
	}
	
	/**
	 * clear object properties.
	 * 
	 * When you reuse object for out parameter, you should clear object before calling library function.
	 */
	public void clear() {
		player = 0;
		opponent = 0;
	}
}
