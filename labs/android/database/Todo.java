package com.example.mytodolist;

public class Todo {
	  private long id;
	  private String todo;
	  
	  public Todo(){
		  
	  }

	  public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }

	  public String getTodo() {
	    return todo;
	  }

	  public void setTodo(String todo) {
	    this.todo = todo;
	  }

	  // Will be used by the ArrayAdapter in the ListView
	  @Override
	  public String toString() {
	    return todo;
	  }
} 
