package wordGame;

import java.util.Scanner;

public class WordGame {

	public static void main(String[] args) {

		String word = "go";
		int count = 0;
		String word1 = "";
		String word2 = "";
		String word3 = "";
		String word4 = "";
		String word5 = "";
		String word6 = "";
		String word7 = "";
		String word8 = "";

		char[][] crossWord = { { 'r', 'v', 'i', 'i' }, { 'n', 'n', 'v', 'n' },
				{ 'g', 'o', 'g', 'o' }, { 'n', 'v', 'v', 'a' },
				{ 'i', 'g', 'o', 'r' }, { 'q', 'i', 'i', 'n' },
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
							 } word1 = "";
							  
							  } 
						} 
						wordCount(word,crossWord[i][j+k]);
					}
					/*
					 * if (limit2 && crossWord[i][j - k] == word.charAt(k)) {
					 * word2 += word.charAt(k); if (k == word.length() - 1) { if
					 * (word2.equals(word)) { count++; } word2 = "";
					 * 
					 * } } 
					 * if (limit3 && crossWord[i + k][j] == word.charAt(k))
					 * { word3 += word.charAt(k); if (k == word.length() - 1) {
					 * if (word3.equals(word)) { count++; } word3 = "";
					 * 
					 * } }
					 * 
					 * if (limit4 && crossWord[i - k][j] == word.charAt(k)) {
					 * word4 += word.charAt(k); if (k == word.length() - 1) { if
					 * (word4.equals(word)) { count++; } word4 = "";
					 * 
					 * } }
					 * 
					 * /* || (limit1 && limit3 && crossWord[i + k][j + k] ==
					 * word.charAt(k)) || (limit2 && limit4 && crossWord[i -
					 * k][j - k] == word.charAt(k)) || (limit2 && limit3 &&
					 * crossWord[i + k][j - k] == word.charAt(k)) || (limit1 &&
					 * limit4 && crossWord[i - k][j + k] == word.charAt(k))
					 */

				}
			}

		}

		System.out.println(count);
	}

	private static int wordCount(String wordIN,String crossWord[i][j]) {
		int wordCount = 0;
		int index = 0;
		String wordOut = "";
		for (index = 0; index < wordIN.length(); index++) {
			wordOut += wordIN.charAt(index);
			//System.out.println(" " + wordOut);

			if (index == wordIN.length() - 1) {
				if (wordOut.equals(wordIN)) {
					wordCount++;
					//System.out.println(wordCount);
				}
				
				wordOut = "";

			}
		}
		return wordCount;
	}

}
