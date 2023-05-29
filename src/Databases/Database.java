package Databases;

import java.util.ArrayList;

public abstract class Database<T> {
    private ArrayList<T> database = new ArrayList<>();

    public ArrayList<T> getDatabase() {
        return database;
    }

    public void add(T value) {
        database.add(value);
    }

    public void showDatabase() {
        for (T value:database) {
            System.out.println(value.toString());
        }
    }
}
