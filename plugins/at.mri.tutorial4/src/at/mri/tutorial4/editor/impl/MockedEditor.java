package at.mri.tutorial4.editor.impl;

import at.mri.tutorial4.editor.TextEditor;

public class MockedEditor implements TextEditor {

	private String text;
	
	public MockedEditor(String text) {
		super();
		this.text = text;
	}

	@Override
	public String getText() {
		return text;
	}

}
