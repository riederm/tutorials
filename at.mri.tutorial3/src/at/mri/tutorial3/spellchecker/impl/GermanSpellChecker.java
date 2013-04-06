package at.mri.tutorial3.spellchecker.impl;

import at.mri.tutorial3.spellchecker.SpellChecker;


public class GermanSpellChecker implements SpellChecker {

	@Override
	public String check(String message) {
		String checkedMessage = message;
		checkedMessage = checkedMessage.replace("hello", "hallo");
		checkedMessage = checkedMessage.replace("world", "welt");
		return checkedMessage;
	}

}
