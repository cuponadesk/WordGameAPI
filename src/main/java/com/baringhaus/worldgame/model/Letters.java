package com.baringhaus.worldgame.model;

import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letters {

	@Id
	private String id;
	private String letters;
	private Map<String, List<String>> characters = new HashMap<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLetters() {
		return letters;
	}

	public void setLetters(String letters) {
		this.letters = letters;
	}

	public Map<String, List<String>> getCharacters() {
		return characters;
	}

	public void setCharacters(Map<String, List<String>> characters) {
		this.characters = characters;
	}
}
