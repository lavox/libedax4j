package net.lavox.libedax4j;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

/**
 * Hint class.
 * 
 * @author lavox
 */
public class Hint extends Structure {
	/**
	 * selectivity table.
	 */
	public static final int[] SELECTIVITY_TABLE = { 73, 87, 95, 98, 99, 100 };

	/**
	 * searched depth(except book moves)
	 */
	public int depth;

	/**
	 * searched selectivity(except book moves)
	 * 
	 * Selectivity percentage is SELECTIVITY_TABLE[selectivity]%.
	 */
	public int selectivity;

	/**
	 * best move found
	 */
	public int move;

	/**
	 * best score
	 */
	public int score;

	/**
	 * upper score(except book moves)
	 */
	public int upper;

	/**
	 * lower score(except book moves)
	 */
	public int lower;

	/**
	 * principal variation
	 */
	public Line[] pv = (Line[]) (new Line()).toArray(1);

	/**
	 * searched time(except book moves)
	 */
	public long time;

	/**
	 * searched node count(except book moves)
	 */
	public long n_nodes;

	/**
	 * book move origin
	 */
	public boolean book_move;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList(new String[] { "depth", "selectivity", "move",
				"score", "upper", "lower", "pv", "time", "n_nodes",
				"book_move" });
	}
	
	/**
	 * clear object properties.
	 * 
	 * When you reuse object for out parameter, you should clear object before calling library function.
	 */
	public void clear() {
		depth = 0;
		selectivity = 0;
		move = 0;
		score = 0;
		upper = 0;
		lower = 0;
		pv[0].clear();
		time = 0;
		n_nodes = 0;
		book_move = false;
	}
}
