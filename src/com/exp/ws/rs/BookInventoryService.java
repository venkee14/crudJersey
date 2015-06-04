package com.exp.ws.rs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/booksinventoryservice")
public class BookInventoryService implements BooksInventoryInterface {

 private static Map<String, Book> booksinventory = new HashMap<String, Book>();

 static {
  booksinventory.put("1-a", new Book("1-a", "MyBook"));
 }

 @GET 

 @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
 @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON }) 

 @Path("/get")
 @Override
 public Book getBook(@QueryParam("isbn") String isbn) {
  System.out.println("Called get book " + isbn);
  return booksinventory.get(isbn);
 }

 @POST
 @Consumes(MediaType.APPLICATION_JSON)
 @Path("/post")
 @Override
 public void postBook(Book book) {
  System.out.println("Called post book " + book);
  booksinventory.put(book.getIsbn(), book);
 }

 @PUT
 @Consumes(MediaType.APPLICATION_JSON)
 @Path("/put")
 @Override
 public void putBook(Book book) {
  System.out.println("Called put book " + book);

  booksinventory.put(book.getIsbn(), book);
 }

 @DELETE
 @Consumes(MediaType.APPLICATION_JSON)
 @Path("/delete")
 @Override
 public void deleteBook(@QueryParam("isbn") String isbn) {
  System.out.println("Called delete book " + isbn);
  booksinventory.remove(isbn);
 }

}
