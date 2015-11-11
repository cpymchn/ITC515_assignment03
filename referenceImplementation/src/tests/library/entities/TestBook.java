package tests.library.entities;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import library.interfaces.entities.EBookState;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

import library.entities.Book;

public class TestBook
{
  ILoan mLoan = mock(ILoan.class);

  @Test
  public void testBook()
  {
    fail("Not yet implemented");
  }



  @Test
  public void testBorrow()
  {
    //setup
    Book book = new Book("Author", "Title", "CallNumber", 7);
    //test
    when(mLoan.getBook()).thenReturn(book);
    when(mLoan.isOverDue()).thenReturn(false);
    //assert
    assertEquals(mLoan.getBook(), book);
  }



  @Test
  public void testGetLoan()
  {
    //setup
    Book book = new Book("Author", "Title", "CallNumber", 7);
    //test
    book.borrow(mLoan);
    //assert
    assertEquals(mLoan, book.getLoan());
   }



  @Test
  public void testReturnBook()
  {
    //setup
    Book book = new Book("Author", "Title", "CallNumber", 7);
    //test
    book.borrow(mLoan);
    book.returnBook(false);
    //assert
    assertEquals(book.getState(), EBookState.ON_LOAN);
  }



  @Test
  public void testLose()
  {
    //setup
    Book book = new Book("Author", "Title", "CallNumber", 7);
    //test
    book.borrow(mLoan);
    book.lose();
    //assert
    assertEquals(book.getState(), EBookState.LOST);
  }



  @Test
  public void testRepair()
  {
    //setup
    Book book = new Book("Author", "Title", "CallNumber", 7);
    //test

    //assert
    assertEquals(book.getState(), EBookState.AVAILABLE);
  }



  @Test
  public void testDispose()
  {
    //setup
    Book book = new Book("Author", "Title", "CallNumber", 7);
    //test
    book.dispose();
    //assert
    assertEquals(book.getState(), EBookState.DISPOSED);
  }



  @Test
  public void testGetState()
  {
    //setup
    Book book = new Book("Author", "Title", "CallNumber", 7);
    //test
    book.borrow(mLoan);
    //assert
    assertEquals(book.getState(), EBookState.ON_LOAN);
  }



  @Test
  public void testGetAuthor()
  {
    //setup
    Book book = new Book("Author", "Title", "CallNumber", 7);
    //test
    //assert
    assertEquals(book.getAuthor(), "Author");
  }



  @Test
  public void testGetTitle()
  {
    //setup
    Book book = new Book("Author", "Title", "CallNumber", 7);
    //test

    //assert
    assertEquals(book.getTitle(), "Title");
  }



  @Test
  public void testGetCallNumber()
  {
    //setup
    Book book = new Book("Author", "Title", "CallNumber", 7);
    //test

    //assert
    assertEquals(book.getCallNumber(), "CallNumber");
  }



  @Test
  public void testGetID()
  {
    //setup
    Book book = new Book("Author", "Title", "CallNumber", 7);
    //test

    //assert
    assertEquals(book.getID(), 7);
  }

}
