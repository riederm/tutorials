package at.mri.tutorial4.spellchecker.impl;

import org.eclipse.e4.core.di.annotations.Creatable;

import at.mri.tutorial4.spellchecker.SpellChecker;

@Creatable
public class EnglishSpellChecker implements SpellChecker {

	@Override
	public String check(String message) {
		String checkedMessage = message;
		checkedMessage = checkedMessage.replace("hallo", "hello");
		checkedMessage = checkedMessage.replace("welt", "world");
		return checkedMessage;
	}

}
