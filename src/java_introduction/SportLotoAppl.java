package java_introduction;

public class SportLotoAppl {

	/**
	 * Application displays out 6 random numbers from 1 to 49
	 * numbers can not be repeated in a sequnce of 6 random numbers
	 * no additional collections / arrays
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		long mask = 0;
		for (int i = 0; i < 6; i++) {
			num = getRandomInt(1, 49);
			if (BitOperations.getBitValue(mask, num) == 0) {
			 // mask = BitOperations.setBitValue(mask, num, true);
				mask = BitOperations.invertBitValue(mask, num);
				System.out.println(num + " ");
			}
		}
	}
	
	public static int getRandomInt(int min, int max) {
		return (int)(min + (max - min + 1) * Math.random());
	}
}
