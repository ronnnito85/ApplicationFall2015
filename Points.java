package wordGame;


public class Points {
	public static void main(String[] args) {

		int X = 0;
		int Y = 0;

		String symbols = ">>><<<~>>>~^^^";

		char right = '>';
		char down = 'v';
		char left = '<';
		char up = '^';
		char symbol = '~';
		int count = 0;

		for (int i = 0; i < symbols.length(); i++) {
			if (symbols.charAt(i) == symbol) {
				count++;
			}
			boolean conditon = (count % 2 == 0);

			if (conditon) {
				if (symbols.charAt(i) == right) {
					X++;
				}
				if (symbols.charAt(i) == down) {
					Y++;
				}
				if (symbols.charAt(i) == left) {
					X--;
				}
				if (symbols.charAt(i) == up) {
					Y--;
				}
			} else {

				if (symbols.charAt(i) == right) {
					X--;
				}
				if (symbols.charAt(i) == down) {
					Y--;
				}
				if (symbols.charAt(i) == left) {
					X++;
				}
				if (symbols.charAt(i) == up) {
					Y++;
				}

			}
		}

		System.out.println(X + " " + Y);

	}
}
