package net.lavox.libedax4j;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

/**
 * Position class.
 * 
 * @author lavox
 */
public class Position extends Structure {
	/**
	 * Score class.
	 */
	public static class Score extends Structure {

		/**
		 * score value.
		 */
		public short value;

		/**
		 * score value.
		 */
		public short lower;

		/**
		 * score value.
		 */
		public short upper;

		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[] { "value", "lower", "upper" });
		}
	}

	/**
	 * (unique) board.
	 */
	public Board[] board = (Board[]) (new Board()).toArray(1);

	/**
	 * best remaining move.
	 */
	public Link leaf;

	/**
	 * linking moves.
	 * 
	 * Array of links is obtained as follows;
	 * 
	 * <pre>
	 * {@code
	 * Position pos = ...
	 * Link[] link = (Link[])pos.link.toArray(pos.n_link);
	 * }
	 * </pre>
	 */
	public Link.ByReference link;

	/**
	 * game win count.
	 */
	public int n_wins;

	/**
	 * game draw count.
	 */
	public int n_draws;

	/**
	 * game loss count.
	 */
	public int n_losses;

	/**
	 * unterminated line count.
	 */
	public int n_lines;

	/**
	 * Position value and bounds.
	 */
	public Score score;

	/**
	 * linking moves number.
	 */
	public byte n_link;

	/**
	 * search level.
	 */
	public byte level;

	/**
	 * done/undone flag.(for internal use)
	 */
	public byte done;

	/**
	 * todo flag.(for internal use)
	 */
	public byte todo;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList(new String[] { "board", "leaf", "link", "n_wins",
				"n_draws", "n_losses", "n_lines", "score", "n_link", "level",
				"done", "todo" });
	}

	/**
	 * clear object properties.
	 * 
	 * When you reuse object for out parameter, you should clear object before
	 * calling library function.
	 */
	public void clear() {
		board[0].clear();
		leaf.clear();
		link = null;
		n_wins = 0;
		n_draws = 0;
		n_losses = 0;
		n_lines = 0;
		score.value = 0;
		score.upper = 0;
		score.lower = 0;
		n_link = 0;
		level = 0;
		done = 0;
		todo = 0;
	}
}
