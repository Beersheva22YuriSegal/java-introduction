package java_introduction;

public class Number {
static public int getNdigits(long number) {
	int res = 0;
	do {
		number /= 10;
		res ++;
	} while(number != 0);
	return res;
}
/**
 * 
 * @param number
 * @return true only if number comprises of 6 digits
 * and sum of first three digits equals the sum of last three digits
 */
static public boolean isHappyNumber(int number) {
	 
	return false;
}
}

// Print 6 unique random numbers from 1 to 49