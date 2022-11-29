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
				helper[(int) str1.charAt(i)]++;
				helper[(int) str2.charAt(i)]--;
			}
			while (index < helper.length && helper[index] == 0) {
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

	public static String ipV4Octet() {
		// options here: for 1 and 2 digits; for 3 digits there is few groups with max
		// value: 099, 199, 249, 255
		return "([01]?\\d\\d?|2([0-4]\\d|5[0-5]))";
	}

	public static String ipV4() {
		String octetExp = ipV4Octet();
		return String.format("(%1$s\\.){3}%1$s", octetExp);
	}

	private static String arithmeticExpression() {
		String operatorExp = operator();
		String operandExp = operand();
		return String.format("\\(*%1$s(%2$s\\(*%1$s\\)*)*", operandExp, operatorExp);
	}

	public static String javaNameExp() {
		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	}
	
	private static String numExp() {
		return "(\\d+\\.?\\d*|\\.\\d+)";
	}

	private static String operand() {
		return String.format("(%s|%s)", numExp(), javaNameExp());
	}

	private static String operator() {
		return "([-+*/])";
	}

	public static boolean isArithmeticExpression(String expression) {
		expression = expression.replaceAll("\\s+", "");
		return expression.matches(arithmeticExpression());
	}

	public static Double computeArithmeticExpression(String expression, double[] values, String[] names) {
		Double res = Double.NaN;
		if (isArithmeticExpression(expression) && checkBraces(expression)) {
			expression = expression.replaceAll("[\\s()]+", "");
			String[] operands = expression.split(operator());
			String[] operators = expression.split(operand());
			res = getOperandValue(operands[0], values, names);
			int index = 1;
			while (index < operands.length && !res.isNaN()) {
				double operandValue = getOperandValue(operands[0], values, names);
				res = computeOperation(res, operandValue, operators[index]);
				index++;
			}
		}
		return res;
	}

	private static Double computeOperation(Double operand1, double operand2, String operator) {
		Double res = Double.NaN;
		if (Double.isNaN(operand2)) {
			switch (operator) {
			case "+":
				res = operand1 + operand2;
				break;
			case "-":
				res = operand1 - operand2;
				break;
			case "/":
				res = operand1 / operand2;
				break;
			case "*":
				res = operand1 * operand2;
				break;
			default:
				res = Double.NaN;
			}
		}

		return res;
	}

	private static Double getOperandValue(String operand, double[] values, String[] names) {
		//TODO
		Double res = Double.NaN;
		if (operand.matches(numExp())) {
		}
		
		return res;
	}

	public static boolean checkBraces(String expression) {
		int count = 0;
		int length = expression.length();
		for (int i = 0; i < length; i++) {
			char symbol = expression.charAt(i);
			if (symbol == '(') {
				count++;
			} else if (symbol == ')') {
				count--;
			}
		}
		return count == 0;
	}
}
