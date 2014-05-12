package com.londroidapps.passwordmanager.persistence.domain;

public class Word {
	
	private Integer id;
	private String word;
	private String translation;
	private String tag;
	
	public Word(String word, String translation, String tag) {
		this.word = word;
		this.translation = translation;
		this.tag = tag;
	}
	
	public Word() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
}
