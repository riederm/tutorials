package at.mri.tutorial4.spellchecker.impl;

import org.eclipse.e4.core.di.annotations.Creatable;

import at.mri.tutorial4.spellchecker.SpellChecker;

@Creatable
public class GermanSpellChecker implements SpellChecker {

	@Override
	public String check(String message) {
		String checkedMessage = message;
		checkedMessage = checkedMessage.replace("hello", "hallo");
		checkedMessage = checkedMessage.replace("world", "welt");
		return checkedMessage;
	}

}
