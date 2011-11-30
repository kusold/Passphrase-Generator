package cse551.Passwordgenerator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class GeneratorActivity extends ApplicationActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.generator);

		Button generate = (Button) findViewById(R.id.Button_Yes);
		Button cancel = (Button) findViewById(R.id.Button_No);

		// Event Listeners
		//

		generate.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Read the check radio button to set algorithm strength
				RadioButton strong = (RadioButton) findViewById(R.id.radio0);
				RadioButton medium = (RadioButton) findViewById(R.id.radio1);
				RadioButton weak = (RadioButton) findViewById(R.id.radio2);
				EditText passphraseBox = (EditText) findViewById(R.id.editText1);
				EditText genpasswordBox = (EditText) findViewById(R.id.editText2);
				String genPassword = "";
				String passPhrase = "";
				// Get the string value from text view
				passPhrase = passphraseBox.getText().toString();
				// Call the algorithm
				// Log.d("GeneratorActivityButton", passPhrase);
				if (strong.isChecked() == true) {
					Log.d("GETS IN STRONG", "true");
					genPassword = generateAlphaNumSpecPassword(passPhrase);
				} else if (medium.isChecked() == true) {
					Log.d("GETS IN MEDIUM", "true");
					genPassword = generateAlphaNumPassword(passPhrase);
				} else if (weak.isChecked() == true) {
					genPassword = generateAlphaPassword(passPhrase);
					Log.d("GETS IN WEAK", "true");
				}
				// Display result
				genpasswordBox.setText(genPassword);
			}
		});

		cancel.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Read the check radio button to set algorithm strength

				EditText passphraseBox = (EditText) findViewById(R.id.editText1);
				EditText genpasswordBox = (EditText) findViewById(R.id.editText2);
				String genPassword = "";
				String passPhrase = "";

				// Clear Text fields
				passphraseBox.setText(passPhrase);
				genpasswordBox.setText(genPassword);
			}
		});

	}

	// Helper classes
	private final String[] alpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i",
			"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z" };
	private final String[] alphaNum = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i",
			"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9" };
	private final String[] alphaNumSpec = { "A", "B", "C", "D", "E", "F", "G", "H",
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
			"V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h",
			"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
			"v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-",
			"+" };

	private String generateAlphaPassword(String passphrase) {
		StringBuffer password = new StringBuffer();
		
		Log.d("PASSPHRASE LENGTH", Integer.toString(passphrase.length()));
		int previous = 3;

		for (int i = 0; i < 16; i++) {
			int j = i;

			while (j >= passphrase.length()) {
				j = j - passphrase.length();
			}

			int index = findIndex(((Character) passphrase.charAt(j)).toString());

			index = (index + previous) * 17;

			while (index >= alpha.length) {
				index = index - alpha.length;
			}
			Log.d("INDEX LENGTH", Integer.toString(index));
			password.append(alpha[index]);

			previous = index;
		}
		Log.d("GETS TO THE END OF HERE", "TRUE");
		return password.toString();
	}

	private String generateAlphaNumPassword(String passphrase) {
		StringBuffer password = new StringBuffer();

		int previous = 3;

		for (int i = 0; i < 16; i++) {
			int j = i;

			while (j >= passphrase.length()) {
				j = j - passphrase.length();
			}

			int index = findIndex(((Character) passphrase.charAt(j)).toString());

			index = (index + previous) * 17;

			while (index >= alphaNum.length) {
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

			while (j >= passphrase.length()) {
				j = j - passphrase.length();
			}

			int index = findIndex(((Character) passphrase.charAt(j)).toString());

			index = (index + previous) * 17;

			while (index >= alphaNumSpec.length) {
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
