package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookMenuTest {

  private BookMenu bookMenu;
  private ByteArrayOutputStream outContent = new ByteArrayOutputStream();


  @Before
  public void setup() {
    bookMenu = new BookMenu();
    System.setOut(new PrintStream(outContent));
  }

  private String systemOut() {
    return outContent.toString();
  }

  @Test
  public void should_return_book_details() {
    bookMenu.displayBookDetails();

    assertThat(systemOut()).isEqualTo(
        "Book{name=\'The Old Man and the Sea\', author=\'Hemingway\', yearPublished=\'1952\'}\n"
            + "Book{name=\'Jean Christophe\', author=\'Romain Rolland\', yearPublished=\'1912\'}\n"
            + "Book{name=\'Blowing in The Wind\', author=\'Bob Dylan\', yearPublished=\'1960\'}\n"
            + "Book{name=\'Saint Joan\', author=\'George Bernard Shaw\', yearPublished=\'1923\'}\n");
  }

  @Test
  public void should_return_successful_message_when_checked_out_book_success() {
    Book book = new Book("Saint Joan", "George Bernard Shaw", "1923");
    bookMenu.checkOutBook(book.getName());
    assertThat(systemOut().contains("Thank you! Enjoy the book")).isTrue();
  }
}