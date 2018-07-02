package com.twu.biblioteca;


import java.util.Arrays;
import java.util.List;

public class BookMenu {

  private List<Book> bookList;

  public BookMenu() {
    this.bookList = Arrays.asList(
        new Book("The Old Man and the Sea", "Hemingway", "1952"),
        new Book("Jean Christophe", "Romain Rolland", "1912"),
        new Book("Blowing in The Wind", "Bob Dylan", "1960"),
        new Book("Saint Joan", "George Bernard Shaw", "1923")
    );
  }

  public void displayBookDetails() {
    for (Book book : bookList) {
      if (!book.isCheckOut()) {
        System.out.print(book + "\n");
      }
    }
  }

  public void checkOutBook(String bookName) {
    while (true) {
      //System.out.println("Input book name want to check out:");
      if (isBookCheckedOut(bookName)) {
        System.out.println("Thank you! Enjoy the book");
        break;
      } else {
        System.out.print("That book is not available.\n");
      }
    }
  }

  public boolean isBookCheckedOut(String bookName) {
    Book checkOutBook = new Book(bookName, "", "");
    boolean checkOut = false;
    for (Book book : bookList) {
      if (checkOutBook.equals(book) && book.isCheckOut() == false) {
        book.setCheckOut(true);
        //bookList.remove(book);
        checkOut = true;
      } else {
        checkOut = false;
      }
    }
    return checkOut;
  }
}

