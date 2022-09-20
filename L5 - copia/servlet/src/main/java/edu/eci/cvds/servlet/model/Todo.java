package edu.eci.cvds.servlet.model;

public class Todo {
	
	private int userId;
	private int id;
	private String title;
	private boolean completed;
	
	public Todo(int userId, int id, String title, boolean completed) {
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.completed = completed;
	}

	public int getUserId() {
		return this.userId;
	}

	public int getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public boolean getCompleted() {
		return this.completed;
	}

	public String get(){
		return "{\"userId\": " + String.valueOf(userId) + ", \"id\":"  + String.valueOf(userId) + ", \"title\": \"" +
		 String.valueOf(title) + "\", \"completed\":"  + String.valueOf(completed) + "}";
	}
}
