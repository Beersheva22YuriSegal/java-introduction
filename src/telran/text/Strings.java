package telran.text;


public class Strings {
	
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if str2 is an anagram of str1 complexity O[N] two passes only
	 *         one additional array only symbols or English letters 1. the same
	 *         length 2. the same symbols just in different order
	 */
	public static boolean isAnagram(String str1, String str2) {
		// maxChar - constant of all possible values in range [0, ..., 127]
		int maxChar = 128;
		int[] helper = new int[maxChar];
		int str1Length = str1.length();
		int str2Length = str2.length();
		int index = 0;
		if (str1Length == str2Length) {
			for (int i = 0; i < str1Length; i++) {
				helper[(int)str1.charAt(i)]++;
				helper[(int)str2.charAt(i)]--;
			}
				while(index < helper.length && helper[index] == 0) {
					index++;
				}
		}
		return index == helper.length;
	}
	
	public static void sortStringNumbers(String[] arr) {
		int[] helper = new int[Byte.MAX_VALUE - Byte.MIN_VALUE + 1];
		int j = 0;
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			Integer number = Integer.parseInt(arr[i]);
			helper[number + 128]++;
		}
		while (j < helper.length) {
			if (helper[j] == 0) {
				j++;
			} else {
				Integer number = j - 128;
				arr[k] = number.toString();
				k++;
				helper[j]--;
			}
		}
	}
	
	public static String javaNameExp() {
		
		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	}
	
	public static String ipV4Octet() {
		//options here: for 1 and 2 digits; for 3 digits there is few groups with max value: 099, 199, 249, 255
		return "([01]?\\d\\d?|2([0-4]\\d|5[0-5]))";
	}
	
	public static String ipV4() {
		String octetExp = ipV4Octet();
		return String.format("(%1$s\\.){3}%1$s", octetExp);
	}
	
}
