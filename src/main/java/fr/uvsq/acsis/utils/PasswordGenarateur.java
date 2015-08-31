package fr.uvsq.acsis.utils;

import java.util.Date;
import java.util.Random;
/**
 * 
 * @author amine
 * class de creation de mot de pass aleatoir
 */
public abstract class PasswordGenarateur {
	/**
	 * creation d'un générateur ayant comme grainne le temp actuel
	 */
	private static final Random RANDOM = new Random(new Date().getTime());
	/**
	 * majuscule possible
	 */
	private static final String STR_MAJ = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
	/**
	 * miniscule possible
	 */
	private static final String STR_MIN = "abcdefghigklmnopqrstuvwxyz";
	/**
	 * langeur minimal et maximal du mot de pass
	 */
	private static final int INF_PASSWORD_LONG = 6;
	private static final int SUP_PASSWORD_LONG = 12;
	
	/**
	 * le rang maximal (nomber de caractére)
	 * en génére un nombre entre 0 et 25 puis en prend le caractére qui 
	 * se trouve a ce rang
	 */
	private static final int ALPHABET_BORN = 26;

	
	/**
	 * 
	 * @return
	 * methode de génération
	 */
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
				password.append(STR_MAJ.charAt(RANDOM.nextInt(ALPHABET_BORN )));
				break;
			case 1:
				password.append(STR_MIN.charAt(RANDOM.nextInt(ALPHABET_BORN )));
				break;

			default:
				break;
			}
		}

		return password.toString();

	}

}
