package org.unict.model;

import org.unict.exception.UnfeasableOperationException;

import java.util.LinkedList;
import java.util.List;

public class BookShelf {

    private final List<Book> shelf;

    public BookShelf(List<Book> shelf) {
        this.shelf = shelf;
    }

    public BookShelf() {
        shelf = new LinkedList<>();
    }

    public void addBook(Book book) throws UnfeasableOperationException {
        if (shelf.contains(book)) {
            System.out.println("Book" + book.getIsbn() + "already present in the shelf");
            throw new UnfeasableOperationException("Book already present in the shelf");
        }
        shelf.add(book);
    }

    public void removeBook(Book book) throws UnfeasableOperationException {
        if (!shelf.remove(book)) {
            String msg = "Book" + book.getIsbn() + "not present in the shelf";
            throw new UnfeasableOperationException(msg);
        }
    }

    public List<Book> findAllByAuthor(String author){
        List<Book> foundBook = new LinkedList<>();
        for (Book book: shelf)
            if (book.getAuthor().equals(author))
                foundBook.add(book);
        return foundBook;
    }

    public List<Book> findAllByTitle(String title){
        List<Book> foundBook= new LinkedList<>();
        for (Book book: shelf)
            if (book.getTitle().equals(title))
                foundBook.add(book);
        return foundBook;
    }

    public Book findOneByTitle(String title){
        if (title==null) throw new NullPointerException();
        for (Book book: shelf)
            if (book.getTitle().equals(title))
                return book;
        return null;
    }

    public Book findOneByAuthor(String author){
        if (author==null) throw new NullPointerException();
        for (Book book: shelf)
            if (book.getAuthor().equals(author))
                return book;
        return null;
    }

    public int search(Book book){
        return shelf.indexOf(book); // in List returns the index of the first occurrence of the specified book in this list,
        //or -1 if this list does not contain the book.
        // nel nostro caso se c'è book è unico
    }


}
