package wordGame;

import java.util.Scanner;

public class WordGame {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the find word:");
		String word = input.nextLine();

		int count = 0;
		String word1 = "";
		String word2 = "";
		String word3 = "";
		String word4 = "";
		String word5 = "";
		String word6 = "";
		String word7 = "";
		String word8 = "";

		char[][] crossWord = { { 'r', 'i', 'i', 'i' }, { 'g', 'p', 'i', 'o' },
				{ 'g', 'o', 'g', 'o' }, { 'n', 'i', 'v', 'a' },
				{ 'i', 'g', 'o', 'r' }, { 'o', 'i', 'i', 'g' },
				{ 'n', 'a', 'v', 'i' } };

		for (int i = 0; i < crossWord.length; i++) {
			for (int j = 0; j < crossWord[i].length; j++) {
				for (int k = 0; k < word.length(); k++) {

					boolean limit1 = j + k >= 0 && j + k < crossWord[i].length;
					boolean limit2 = j - k >= 0 && j - k < crossWord[i].length;
					boolean limit3 = i + k >= 0 && i + k < crossWord.length;
					boolean limit4 = i - k >= 0 && i - k < crossWord.length;

					if (limit1 && crossWord[i][j + k] == word.charAt(k)) {
						word1 += word.charAt(k);
						if (k == word.length() - 1) {

							if (word1.equals(word)) {
								count++;
							}
							word1 = "";
						}

					} else {
						word1 = "";
					}

					if (limit2 && crossWord[i][j - k] == word.charAt(k)) {
						word2 += word.charAt(k);
						if (k == word.length() - 1) {
							if (word2.equals(word)) {
								count++;
							}
							word2 = "";
						}
					} else {
						word2 = "";
					}

					if (limit3 && crossWord[i + k][j] == word.charAt(k)) {
						word3 += word.charAt(k);
						if (k == word.length() - 1) {
							if (word3.equals(word)) {
								count++;
							}
							word3 = "";
						}
					} else {
						word3 = "";
					}

					if (limit4 && crossWord[i - k][j] == word.charAt(k)) {
						word4 += word.charAt(k);
						if (k == word.length() - 1) {
							if (word4.equals(word)) {
								count++;
							}
							word4 = "";
						}
					} else {
						word4 = "";
					}

					if (limit1 && limit3
							&& crossWord[i + k][j + k] == word.charAt(k)) {
						word5 += word.charAt(k);
						if (k == word.length() - 1) {
							if (word5.equals(word)) {
								count++;
							}
							word5 = "";

						}
					} else {
						word5 = "";
					}
					if (limit2 && limit4
							&& crossWord[i - k][j - k] == word.charAt(k)) {
						word6 += word.charAt(k);
						if (k == word.length() - 1) {
							if (word6.equals(word)) {
								count++;
							}
							word6 = "";

						}
					} else {
						word6 = "";
					}
					if (limit2 && limit3
							&& crossWord[i + k][j - k] == word.charAt(k)) {
						word7 += word.charAt(k);
						if (k == word.length() - 1) {
							if (word7.equals(word)) {
								count++;
							}
							word7 = "";

						}
					} else {
						word7 = "";
					}
					if (limit1 && limit4
							&& crossWord[i - k][j + k] == word.charAt(k)) {
						word8 += word.charAt(k);
						if (k == word.length() - 1) {
							if (word8.equals(word)) {
								count++;
							}
							word8 = "";

						}
					} else {
						word8 = "";
					}
				}

			}
		}

		System.out.println(count);
	}

}
