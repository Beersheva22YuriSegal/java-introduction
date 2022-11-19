package java_introduction;

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
		//length 
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
}
