package fr.uvsq.acsis.metier;

import java.util.Date;
import java.util.Random;

public abstract class PasswordGenarator {
	private static final Random RANDOM = new Random(new Date().getTime());
	private static final String STR_MAJ = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
	private static final String STR_MIN = "abcdefghigklmnopqrstuvwxyz";
	private static final int INF_PASSWORD_LONG = 6;
	private static final int SUP_PASSWORD_LONG = 12;
	private static final int ALPHABET_BORN = 26;

	public static String generate() {
		int passwordLenght = 0;
		StringBuilder password = new StringBuilder();
		int typeOfChar;
		while (passwordLenght < INF_PASSWORD_LONG) {
			passwordLenght = RANDOM.nextInt(SUP_PASSWORD_LONG);
		}
		for (int i = 0; i < passwordLenght; i++) {
			typeOfChar = RANDOM.nextInt(2);
			
			switch (typeOfChar) {
			case 0:
				password.append(STR_MAJ.charAt(RANDOM.nextInt(ALPHABET_BORN + 1)));
				break;
			case 1:
				password.append(STR_MIN.charAt(RANDOM.nextInt(ALPHABET_BORN + 1)));
				break;

			default:
				break;
			}
		}

		return password.toString();

	}

	public static void main(String[] args) {
		System.out.println(PasswordGenarator.generate());
	}
}
