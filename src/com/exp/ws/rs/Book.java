package com.exp.ws.rs;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement

 public class Book {

 private String isbn;
 private String title;

 public Book() {
  // TODO Auto-generated constructor stub
 }

 public Book(String isbn, String title) {
  this.isbn = isbn;
  this.title = title;
 }

 public String getIsbn() {
  return isbn;
 }

 public void setIsbn(String isbn) {
  this.isbn = isbn;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 @Override
 public String toString() {
  // TODO Auto-generated method stub
  return (new StringBuffer().append("isbn ").append(isbn)
    .append(" title ").append(title)).toString();
 }

}
