package edu.course.lab04;

public class Book {
    private final String isbn;
    private final String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    @Override 
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Book)){
            return false;
        }
        Book book = (Book) obj;
        return this.isbn.equals(book.isbn);

    }

    @Override 
    public int hashCode(){
        return isbn.hashCode();
    }

}