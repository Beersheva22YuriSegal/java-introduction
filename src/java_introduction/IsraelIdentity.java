package java_introduction;

public class IsraelIdentity {
/**
 * 
 * @param id
 * @return true for right id otherwise false
 * number 
 * control sum should be multiple of 10 (sum % 10 == 0)
 * for even indexes (0, 2, 4, 6, 8) digits as is
 * for odd indexes (1, 3, 5, 7, 9) digit = digit * 2, if > 9 the sum of inner digits is taken
 * example, 123456782 => 1+4(2*2)+3+8(4*2)+5+3(6*2=12=>1+2)+7+7(8*2=16=>1+6)+2
 */
	public static boolean verifyId(int id) {
		boolean res = false;
		if (Numbers.getNdigits(id) == 9) {
			res =getSumNumbersId(id) % 10 == 0;
		}
		return res;
	}
	
/**
 * 
 * @return random number of 9 digits matching right Israel ID
 * cycle not more than 9 iterations
 */
	
	public static int generateRandomId() {
		int res = 0;
		for (int i = 0; i <= 7; i++) {
			if (i == 0) {
				res = res * 10 + SportLotoAppl.getRandomInt(1,9);
			} else {
				res = res * 10 + SportLotoAppl.getRandomInt(0, 9);
			}
		}
		int sumDig = getSumNumbersId(res);
		int lastDig = (100 - sumDig) % 10;
		res = res * 10 + lastDig;
		return res;
	}
	
	public static int getSumNumbersId(int id) {
		int arrId[] = Numbers.getDigits(id);
		int res = 0;
		for (int i=0; i < arrId.length; i++) {
			if (i % 2 == 1) {
				int dig = arrId[i] * 2;
				if (dig > 9) {
					dig = Numbers.getSumDigits(dig);
				}
				res += dig;
			} else {
				res += arrId[i];
			}
		}
	return res;
	}
}