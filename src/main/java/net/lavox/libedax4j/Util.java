package net.lavox.libedax4j;

/**
 * Utility class.
 * 
 * @author lavox
 */
public class Util {
	/**
	 * Convert table.
	 */
	private static final String[] CONVERT_TABLE = new String[66];
	static {
		for (int i = 0; i < 64; i++) {
			CONVERT_TABLE[i] = "" + (char) ('a' + (char) (i % 8))
					+ (char) ('1' + (char) (i / 8));
		}
		CONVERT_TABLE[64] = "pa";
		CONVERT_TABLE[65] = "--";
	}

	/**
	 * Convert move coordinate to string.
	 * 
	 * @param x
	 *            move coordinate(0-63,64,65)
	 * @return move string(a1-h8,pa,--)
	 */
	public static String moveToString(int x) {
		if (x >= 0 && x <= 65) {
			return CONVERT_TABLE[x];
		} else {
			return "??";
		}
	}

	/**
	 * Create String buffer for out parameter.
	 * 
	 * @param len
	 *            length of buffer.
	 * @return String of length len.
	 */
	public static String createBuffer(int len) {
		return new String(new char[len]);
	}

	/**
	 * Get library name.
	 */
	static String getLibraryName() {
		String libraryName = "edax";
		String osName = System.getProperty("os.name");
		if (osName != null && osName.startsWith("Windows")) {
			String arch = System.getProperty("os.arch");
			if (arch != null && (arch.equals("x86") || arch.equals("i386")
					|| arch.equals("i486") || arch.equals("i586")
					|| arch.equals("i686"))) {
				libraryName = "libedax-x86.dll";
			} else {
				libraryName = "libedax-x64.dll";
			}
		}
		return libraryName;
	}
}
