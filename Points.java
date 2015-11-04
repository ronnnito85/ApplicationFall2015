package wordGame;

import java.util.Scanner;

public class Points {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter current points: ");

		String input = in.nextLine();
		Scanner s = new Scanner(input);

		s.skip("\\(");

		int X = 0;
		X = Integer.parseInt(s.findInLine("\\d*"));
		s.skip(",");
		int Y = 0;
		Y = Integer.parseInt(s.findInLine("\\d*"));

		System.out.print("Enter symbols: ");
		String symbols = in.next();

		char symbol = '~';
		int count = 0;

		for (int i = 0; i < symbols.length(); i++) {
			if (symbols.charAt(i) == symbol) {
				count++;
			}
			boolean conditon = (count % 2 == 0);

			X = resultX(X, symbols.charAt(i), conditon);
			Y = resultY(Y, symbols.charAt(i), conditon);

		}
		System.out.println(X + " " + Y);

	}

	public static int resultX(int X, char symbol, boolean count) {

		char right = '>';
		char left = '<';

		if (symbol == right) {
			if (count) {
				X--;
			} else {
				X++;
			}
		}
		if (symbol == left) {

			if (!count) {
				X++;
			} else {
				X--;
			}
		}

		return X;
	}

	public static int resultY(int Y, char symbol, boolean count) {

		char down = 'v';
		char up = '^';

		if (symbol == down) {
			if (count) {
				Y--;
			} else {
				Y++;
			}

		}
		if (symbol == up) {
			if (!count) {
				Y++;
			} else {
				Y--;
			}
		}

		return Y;
	}

}
