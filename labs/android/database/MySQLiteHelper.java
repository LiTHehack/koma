package com.example.mytodolist;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

  public static final String TABLE_TODOS = "todos";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_TODO = "todo";

  private static final String DATABASE_NAME = "todos.db";
  private static final int DATABASE_VERSION = 1;

  // Database creation sql statement
  private static final String DATABASE_CREATE = "create table "
      + TABLE_TODOS + "(" + COLUMN_ID
      + " integer primary key autoincrement, " + COLUMN_TODO
      + " text not null);";

  public MySQLiteHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database) {
    database.execSQL(DATABASE_CREATE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.w(MySQLiteHelper.class.getName(),
        "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODOS);
    onCreate(db);
  }

} 