package com.example.datastorageproject.package_sqlitedatabase;

public class Temp {//This is the class to store info of db.
    public static DbHelper dbHelper;

    public static DbHelper getDbHelper() {
        return dbHelper;
    }

    public static void setDbHelper(DbHelper dbHelper) {
        Temp.dbHelper = dbHelper;
    }
}
