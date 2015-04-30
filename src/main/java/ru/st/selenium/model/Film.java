package ru.st.selenium.model;

public class Film {

	private String id;
	private String duration;
	private String knownAs;
	private String imdb;
	private String title;
	private String year;
	private String notes;
	
	public String getDuration() {
		return duration;
	}
	public Film setDuration(String duration) {
		this.duration = duration;
		return this;
	}
	
	public String getKnownAs() {
		return knownAs;
	}
	public Film setKnownAs(String knownAs) {
		this.knownAs = knownAs;
		return this;
	}
	
	public String getId() {
		return id;
	}
	public Film setId(String id) {
		this.id = id;
		return this;
	}
	public String getImdb() {
		return imdb;
	}
	public Film setImdb(String imdb) {
		this.imdb = imdb;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Film setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getYear() {
		return year;
	}
	public Film setYear(String year) {
		this.year = year;
		return this;
	}
	public String getNotes() {
		return notes;
	}
	public Film setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	
}
