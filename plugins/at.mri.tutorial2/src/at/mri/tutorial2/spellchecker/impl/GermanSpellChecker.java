package at.mri.tutorial2.spellchecker.impl;

import at.mri.tutorial2.spellchecker.SpellChecker;


public class GermanSpellChecker implements SpellChecker {

	@Override
	public String check(String message) {
		String checkedMessage = message;
		checkedMessage = checkedMessage.replace("hello", "hallo");
		checkedMessage = checkedMessage.replace("world", "welt");
		return checkedMessage;
	}

}
