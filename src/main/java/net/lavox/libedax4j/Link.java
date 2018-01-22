package net.lavox.libedax4j;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

/**
 * Link class.
 * 
 * @author lavox
 */
public class Link extends Structure {
	public static class ByReference extends Link implements Structure.ByReference{}
	
	/**
	 * move score.
	 */
	public byte score;
	
	/**
	 * move coordinate.
	 */
	public byte move;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList(new String[] { "score", "move" });
	}
	
	/**
	 * clear object properties.
	 * 
	 * When you reuse object for out parameter, you should clear object before calling library function.
	 */
	public void clear() {
		score = 0;
		move = 0;
	}
}
