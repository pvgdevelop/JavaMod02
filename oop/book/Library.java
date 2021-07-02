package by.jonline.modx.oop.book;

import java.util.ArrayList;

public class Library {
	private ArrayList<Book> books;
	
	public Library() {
		books = new ArrayList<Book>();
	}
	
	public Library(ArrayList<Book> books) {
		this.books = books;
	}

	public ArrayList<Book> getBooks(){
		return books;
	}
	
	public void setBooks(ArrayList<Book> books){
		this.books = books;
	}
	
	public void add(Book book) {
		books.add(book);
	}

	@Override
	public String toString() {
		return "Library [books=" + books + "]";
	}
}
