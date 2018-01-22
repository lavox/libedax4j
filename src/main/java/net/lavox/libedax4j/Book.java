package net.lavox.libedax4j;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * Book class.
 * 
 * @author lavox
 */
public class Book extends Structure {
	/**
	 * Date class.
	 */
	public static class Date extends Structure {
		/**
		 * year.
		 */
		public short year;

		/**
		 * month.
		 */
		public byte month;

		/**
		 * day.
		 */
		public byte day;

		/**
		 * hour.
		 */
		public byte hour;

		/**
		 * minute.
		 */
		public byte minute;

		/**
		 * second.
		 */
		public byte second;

		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[] { "year", "month", "day", "hour",
					"minute", "second" });
		}
	}

	/**
	 * Options class.
	 */
	public static class Options extends Structure {
		/**
		 * level.
		 */
		public int level;

		/**
		 * empties. (61 - depth)
		 */
		public int n_empties;

		/**
		 * midgame error.
		 */
		public int midgame_error;

		/**
		 * endcut error.
		 */
		public int endcut_error;

		/**
		 * verbosity.
		 */
		public int verbosity;

		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[] { "level", "n_empties",
					"midgame_error", "endcut_error",
					"verbosity" });
		}
	}

	/**
	 * Stats class.
	 */
	public static class Stats extends Structure {
		/**
		 * number of nodes.
		 */
		public int n_nodes;

		/**
		 * number of links.
		 */
		public int n_links;

		/**
		 * number of todo.
		 */
		public int n_todo;

		@Override
		protected List<String> getFieldOrder() {
			return Arrays
					.asList(new String[] { "n_nodes", "n_links", "n_todo" });
		}
	}

	/**
	 * Random class. (for internal use)
	 */
	public static class Random extends Structure {
		/**
		 * x.
		 */
		public long x;

		@Override
		protected List<String> getFieldOrder() {
			return Arrays
					.asList(new String[] { "x" });
		}
	}

	/**
	 * date.
	 */
	public Date date;

	/**
	 * options.
	 */
	public Options options;

	/**
	 * stats.
	 */
	public Stats stats;

	/**
	 * array(for internal use).
	 */
	public Pointer array;

	/**
	 * stack(for internal use).
	 */
	public Pointer stack;

	/**
	 * number of arrays(for internal use).
	 */
	public int n;

	/**
	 * number of nodes.
	 */
	public int n_nodes;

	/**
	 * need saving(for internal use).
	 */
	public boolean need_saving;

	/**
	 * random(for internal use).
	 */
	public Random[] random = (Random[]) (new Random()).toArray(1);

	/**
	 * search(for internal use).
	 */
	public Pointer search;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList(new String[] { "date", "options", "stats", "array",
				"stack", "n", "n_nodes", "need_saving", "random", "search" });
	}
	
	/**
	 * clear object properties.
	 * 
	 * When you reuse object for out parameter, you should clear object before calling library function.
	 */
	public void clear() {
		date.year = 0;
		date.month = 0;
		date.day = 0;
		date.hour = 0;
		date.minute = 0;
		date.second = 0;
		
		options.level = 0;
		options.n_empties = 0;
		options.midgame_error = 0;
		options.endcut_error = 0;
		options.verbosity = 0;

		stats.n_nodes = 0;
		stats.n_links = 0;
		stats.n_todo = 0;

		array = Pointer.NULL;
		stack = Pointer.NULL;

		n = 0;
		n_nodes = 0;
		need_saving = false;
		random[0].x = 0;
		
		search = Pointer.NULL;
	}
}
