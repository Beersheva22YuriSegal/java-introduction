package telran.digital.numbers;

public class DigitalNumbersPrinting {
	private static final String SYMBOL = "*";
	private static final int INTERVAL_BETWEEN_LETTERS = 2;

	public static void displayDigitalNumber(int number, int offset, int width, int height) {
		int[] digits = getDigits(number);
		String[] res = getDigitString(digits[0], offset, width, height);
		for (int i = 1; i < digits.length; i++) {
			res = addDigit(res, digits[i], INTERVAL_BETWEEN_LETTERS, width, height);
			}
		displayStrings(res);
		}
		
	
	private static String[] addDigit(String[] res, int digits, int offset, int width, int height) {
		String[] strDigit = getDigitString(digits, offset, width, height);
		for (int j = 0; j < res.length; j++) {
			res[j] += strDigit[j];
		}
		return res;
	}


	public static int getNdigits(long number) {
		int result = 0;
		do {
			number /= 10;
			result++;
		} while (number != 0);
		return result;
	}
	
	private static int[] getDigits(int number) {
		int result[] = new int[getNdigits(number)];
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = number % 10;
			number /= 10;
		}
		return result;
	}
	
	private static String[] getDigitString(int digit, int offset, int width, int height) {
		String[] res = new String[height];
		switch (digit) {
		case 0:
			res = zero(offset, width, height);
			break;
		case 1:
			res = one(offset, width, height);
			break;
		case 2:
			res = two(offset, width, height);
			break;
		case 3:
			res = three(offset, width, height);
			break;
		case 4:
			res = four(offset, width, height);
			break;
		case 5:
			res = five(offset, width, height);
			break;
		case 6:
			res = six(offset, width, height);
			break;
		case 7:
			res = seven(offset, width, height);
			break;
		case 8:
			res = eight(offset, width, height);
			break;
		case 9:
			res = nine(offset, width, height);
			break;
		}
		
		return res;
	}


	public static String line(int offset, int length) {
		return " ".repeat(offset) + SYMBOL.repeat(length);
	}

	public static String[] verticalLine(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width);
		}
		return res;
	}

	public static String[] twoVerticalLines(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}

	public static String[] zero(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = twoVerticalLines(offset, width, height - 2);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] one(int offset, int width, int height) {
		return verticalLine(offset + width - 1, width, height);
	}

	public static String[] two(int offset, int width, int height) {
		String[] res = new String[height];
		int middle = getVerticalMiddle(height);
		res[0] = line(offset, width);
		String[] rightVerticalLine = verticalLine(offset + width - 1, width, middle);
		System.arraycopy(rightVerticalLine, 0, res, 1, middle - 1);
		res[middle] = line(offset, width);
		String[] leftVerticalLine = verticalLine(offset, width, middle);
		System.arraycopy(leftVerticalLine, 0, res, middle + 1, middle);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] three(int offset, int width, int height) {
		String[] res = new String[height];
		int middle = getVerticalMiddle(height);
		res = verticalLine(offset + width - 1, width, height);
		res[0] = line(offset, width);
		res[middle] = line(offset, width);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] four(int offset, int width, int height) {
		String[] res = new String[height];
		int middle = getVerticalMiddle(height);
		String[] twoVerticalLines = twoVerticalLines(offset, width, middle);
		System.arraycopy(twoVerticalLines, 0, res, 0, middle);
		String[] botVerticaRightlLine = verticalLine(offset + width - 1, width, height - middle);
		System.arraycopy(botVerticaRightlLine, 0, res, middle, height - middle);
		res[middle] = line(offset, width);
		return res;
	}

	public static String[] five(int offset, int width, int height) {
		String[] res = new String[height];
		int middle = getVerticalMiddle(height);
		res[0] = line(offset, width);
		String[] leftTopVerticalLine = verticalLine(offset, width, middle);
		System.arraycopy(leftTopVerticalLine, 0, res, 1, middle);
		res[middle] = line(offset, width);
		String[] rightBotVerticalLine = verticalLine(offset + width - 1, width, height - middle);
		System.arraycopy(rightBotVerticalLine, 0, res, middle + 1, height - middle - 1);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] six(int offset, int width, int height) {
		String[] res = new String[height];
		int middle = getVerticalMiddle(height);
		res = verticalLine(offset, width, height);
		res[0] = line(offset, width);
		String[] rightBotVerticalLine = twoVerticalLines(offset, width, middle);
		System.arraycopy(rightBotVerticalLine, 0, res, middle, middle);
		res[middle] = line(offset, width);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] seven(int offset, int width, int height) {
		String[] res = new String[height];
		res = verticalLine(offset + width - 1, width, height);
		res[0] = line(offset, width);
		return res;
	}

	public static String[] eight(int offset, int width, int height) {
		String[] res = new String[height];
		int middle = getVerticalMiddle(height);
		res[0] = line(offset, width);
		String[] topVerticalLines = twoVerticalLines(offset, width, middle - 1);
		System.arraycopy(topVerticalLines, 0, res, 1, topVerticalLines.length);
		res[middle] = line(offset, width);
		String[] botVerticalLines = twoVerticalLines(offset, width, height - middle);
		System.arraycopy(botVerticalLines, 0, res, middle + 1, middle);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] nine(int offset, int width, int height) {
		String[] res = new String[height];
		int middle = getVerticalMiddle(height);
		res[0] = line(offset, width);
		String[] topVerticalLines = twoVerticalLines(offset, width, middle - 1);
		System.arraycopy(topVerticalLines, 0, res, 1, topVerticalLines.length);
		res[middle] = line(offset, width);
		String[] rightBotVerticalLine = verticalLine(offset + width - 1, width, height - middle);
		System.arraycopy(rightBotVerticalLine, 0, res, middle + 1, height - middle - 1);
		res[height - 1] = line(offset, width);
		return res;
	}

	private static int getVerticalMiddle(int height) {
		return (height - 1) / 2;
	}

	public static void displayStrings(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}

	}
}