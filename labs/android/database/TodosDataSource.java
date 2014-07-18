package com.example.mytodolist;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class TodosDataSource {

  // Database fields
  private SQLiteDatabase database;
  private MySQLiteHelper dbHelper;
  private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
      MySQLiteHelper.COLUMN_TODO };

  public TodosDataSource(Context context) {
    dbHelper = new MySQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }

  public Todo createTodo(String todo) {
    ContentValues values = new ContentValues();
    values.put(MySQLiteHelper.COLUMN_TODO, todo);
    long insertId = database.insert(MySQLiteHelper.TABLE_TODOS, null,
        values);
    Cursor cursor = database.query(MySQLiteHelper.TABLE_TODOS,
        allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
        null, null, null);
    cursor.moveToFirst();
    Todo newTodo = cursorToTodo(cursor);
    cursor.close();
    return newTodo;
  }

  public void deleteTodo(Todo todo) {
    long id = todo.getId();
    System.out.println("Todo deleted with id: " + id);
    database.delete(MySQLiteHelper.TABLE_TODOS, MySQLiteHelper.COLUMN_ID
        + " = " + id, null);
  }

  public ArrayList<Todo> getAllTodos() {
    ArrayList<Todo> todos = new ArrayList<Todo>();

    Cursor cursor = database.query(MySQLiteHelper.TABLE_TODOS,
        allColumns, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      Todo todo = cursorToTodo(cursor);
      todos.add(todo);
      cursor.moveToNext();
    }
    // Make sure to close the cursor
    cursor.close();
    return todos;
  }

  private Todo cursorToTodo(Cursor cursor) {
    Todo todo = new Todo();
    todo.setId(cursor.getLong(0));
    todo.setTodo(cursor.getString(1));
    return todo;
  }
} 