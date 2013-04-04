package at.mri.tutorial2.spellchecker.impl;

import at.mri.tutorial2.spellchecker.SpellChecker;

public class EnglishSpellChecker implements SpellChecker {

	@Override
	public String check(String message) {
		String checkedMessage = message;
		checkedMessage = checkedMessage.replace("hallo", "hello");
		checkedMessage = checkedMessage.replace("welt", "world");
		return checkedMessage;
	}

}
