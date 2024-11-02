package org.unict.model;

public class User {
    private final String name;
    private final int id;
    private final BookShelf shelf;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        shelf= new BookShelf();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public BookShelf getShelf() {
        return shelf;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", id=" + id + ", "
                + "shelf=\n\t" + shelf + '}';
    }

}