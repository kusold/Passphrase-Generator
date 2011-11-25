package cse551.Passwordgenerator;

public class GeneratePassword {
	private String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
	                          "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	private String[] alphaNum = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
								 "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
								 "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	private String[] alphaNumSpec = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
			 				 "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
			 				 "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!","@","#","$","%","^","&", "*", "(", ")", "-", "+"};
	
	public String generateAlphaPassword(String passphrase){
		StringBuffer password = new StringBuffer();
		
		for(int i = 0; i < 16; i++) {
			//TODO: Find index of alpha[passphrase[i].index]
			int j = i;
			if(i > passphrase.length()) {
				j = i - passphrase.length();
			}
			j = j * 13;
			while(j > alpha.length) {
				j = j - alpha.length;
			}
			password.append(alpha[j]);
		}
		return password.toString();	
	}
	
	public String generateAlphaNumPassword(String passphrase){
		StringBuffer password = new StringBuffer();
		
		for(int i = 0; i < 16; i++) {
			//TODO: Find index of alpha[passphrase[i].index]
			int j = i;
			if(i > passphrase.length()) {
				j = i - passphrase.length();
			}
			j = j * 13;
			while(j > alphaNum.length) {
				j = j - alphaNum.length;
			}
			password.append(alphaNum[j]);
		}
		return password.toString();	
	}
	
	public String generateAlphaNumSpecPassword(String passphrase){
		StringBuffer password = new StringBuffer();
		
		for(int i = 0; i < 16; i++) {
			//TODO: Find index of alpha[passphrase[i].index]
			int j = i;
			if(i > passphrase.length()) {
				j = i - passphrase.length();
			}
			j = j * 13;
			while(j > alphaNumSpec.length) {
				j = j - alphaNumSpec.length;
			}
			password.append(alphaNumSpec[j]);
		}
		return password.toString();	
	}
}
