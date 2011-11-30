package cse551.Passwordgenerator;

public class GeneratePassword {
	private String[] alpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i",
			"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z" };
	private String[] alphaNum = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i",
			"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9" };
	private String[] alphaNumSpec = { "A", "B", "C", "D", "E", "F", "G", "H",
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
			"V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h",
			"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
			"v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-",
			"+" };

	public String generateAlphaPassword(String passphrase) {
		StringBuffer password = new StringBuffer();

		int previous = 3;

		for (int i = 0; i < 16; i++) {
			int j = i;

			if (i > passphrase.length()) {
				j = i - passphrase.length();
			}

			int index = findIndex(((Character) passphrase.charAt(j)).toString());

			index = (index + previous) * 13;

			while (index > alpha.length) {
				index = index - alpha.length;
			}
			password.append(alpha[index]);

			previous = index;
		}
		return password.toString();
	}

	public String generateAlphaNumPassword(String passphrase) {
		StringBuffer password = new StringBuffer();

		int previous = 3;

		for (int i = 0; i < 16; i++) {
			int j = i;

			if (i > passphrase.length()) {
				j = i - passphrase.length();
			}

			int index = findIndex(((Character) passphrase.charAt(j)).toString());

			index = (index + previous) * 13;

			while (index > alphaNum.length) {
				index = index - alphaNum.length;
			}
			password.append(alphaNum[index]);

			previous = index;
		}
		return password.toString();
	}

	public String generateAlphaNumSpecPassword(String passphrase) {
		StringBuffer password = new StringBuffer();

		int previous = 3;
		for (int i = 0; i < 16; i++) {
			int j = i;

			if (i > passphrase.length()) {
				j = i - passphrase.length();
			}

			int index = findIndex(((Character) passphrase.charAt(j)).toString());

			index = (index + previous) * 13;

			while (index > alphaNumSpec.length) {
				index = index - alphaNumSpec.length;
			}
			password.append(alphaNumSpec[index]);
			previous = index;
		}
		return password.toString();
	}

	private int findIndex(String ch) {
		for (int i = 0; i < alphaNumSpec.length; i++) {
			if (alphaNumSpec[i].equals(ch)) {
				return i;
			}
		}
		return 0;
	}
}
