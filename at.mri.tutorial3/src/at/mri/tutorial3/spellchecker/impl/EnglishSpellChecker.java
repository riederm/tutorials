package at.mri.tutorial3.spellchecker.impl;

import at.mri.tutorial3.spellchecker.SpellChecker;

public class EnglishSpellChecker implements SpellChecker {

	@Override
	public String check(String message) {
		String checkedMessage = message;
		checkedMessage = checkedMessage.replace("hallo", "hello");
		checkedMessage = checkedMessage.replace("welt", "world");
		return checkedMessage;
	}

}
