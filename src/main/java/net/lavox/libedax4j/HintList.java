package net.lavox.libedax4j;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

/**
 * HintList class.
 * 
 * @author lavox
 */
public class HintList extends Structure {
	/**
	 * array of hints.
	 * 
	 * Note that index of array begins with 1.
	 */
	public Hint[] hint = (Hint[]) (new Hint()).toArray(34);

	/**
	 * number of hints.
	 */
	public int n_hints;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList(new String[] { "hint", "n_hints" });
	}
	
	
	/**
	 * clear object properties.
	 * 
	 * When you reuse object for out parameter, you should clear object before calling library function.
	 */
	public void clear() {
		for ( int i = 0 ; i < hint.length ; i++ ) {
			hint[i].clear();
		}
		n_hints = 0;
	}
}
