package at.mri.tutorial3.editor.impl;

import at.mri.tutorial3.editor.TextEditor;

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
