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
	 boolean isHappy = false;
	 if (getNdigits(number) == 6) {
		 int firstThree = 0; //sum of XXXxxx in number
		 int lastThree = 0; //sum of xxXXX in number
		 for (int n = 1; n <= 100000; n = n*10) {
			 if (n <= 100) {
				 lastThree += number / n % 10;
			 } else {
				 firstThree += number / n % 10;
			 }
		 }
		 if (lastThree == firstThree) {
			 isHappy = true;
		 }
	 }
	return isHappy;
}
}