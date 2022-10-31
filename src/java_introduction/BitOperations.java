package java_introduction;

/**
 * right nBit value [0, 63]
 * All methods will return -1 in the case of wrong nBit value
 *
 */
public class BitOperations {
/**
 * 
 * @param number any number
 * @param nBit - number of bit
 * @return value of bit with number nBit 
 */
	static public int getBitValue(long number, int nBit) {
		int res = -1;
	if (checkNbit(nBit)) {
		long mask = getMask(nBit); //all bits are 0 except bit with number nBit
		if ((number & mask) != 0) {
			res = 1;
		} else {
			res = 0;
		}
	}
		return res;
}
	private static boolean checkNbit(int nBit) {
		return nBit < 64 && nBit >= 0;
}
	private static long getMask(int n) {
		return 1L << n;
	}
/**
 * 
 * @param number - any number
 * @param nBit - 	num of bit which will be changed
 * @param value - true/false (0 or 1) of bit above ^
 * @return value = changed number with nBit
 */
	static public long setBitValue(long number, int nBit, boolean value) {
		long res = -1;
			if (checkNbit(nBit)) {
				long mask = getMask(nBit); // all bits are 0 except bit number nBit
				if (value) {
					res = number | mask;
				} else {
					res = number & ~mask;
			}
	}
	return res;
}
/**
 * 
 * @param number - any number
 * @param nBit - bit number
 * @return new number in which nBit will be inverted (old value - 1, new value - 0)
 */
	static public long invertBitValue(long number, int nBit) {
		long res = -1;
		if (checkNbit(nBit)) {
			long mask = getMask(nBit); // all bits are 0 except bit number nBit
			res = number ^ mask;
		}
		return res;
	}
}