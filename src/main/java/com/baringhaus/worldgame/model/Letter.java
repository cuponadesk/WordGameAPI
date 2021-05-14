package com.baringhaus.worldgame.model;

import java.util.ArrayList;
import java.util.List;

public class Letter {


	private List<String> letters = new ArrayList<>();
	private String required;
	private List<String> words = new ArrayList<>();

	public List<String> getLetters() {
		return letters;
	}

	public void setLetters(List<String> letters) {
		this.letters = letters;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}
}
