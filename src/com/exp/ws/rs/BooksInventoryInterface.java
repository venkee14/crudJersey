package com.exp.ws.rs;

public interface BooksInventoryInterface {
	 public Book getBook(String isbn);

	 public void postBook(Book book);

	 public void putBook(Book book);

	 public void deleteBook(String isbn);

}
