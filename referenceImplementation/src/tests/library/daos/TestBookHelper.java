package tests.library.daos;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import library.interfaces.daos.IBookHelper;
import library.interfaces.entities.IBook;
import static org.mockito.Mockito.*;

public class TestBookHelper
{
  @Before
  public void setUp() throws Exception
  {
  }



  @After
  public void tearDown() throws Exception
  {
  }



  @Test
  public void testMakeBook()
  {
    String author = "Author";
    String title = "Title";
    String callNo = "CallNumber";
    int id = 1;
    
    IBookHelper bookHelper;
    bookHelper = mock(IBookHelper.class);
    
    IBook testBook;
    testBook = mock(IBook.class);
    
    when(bookHelper.makeBook(author, title, callNo, id)).thenReturn(testBook);
    IBook book = bookHelper.makeBook(author, title, callNo, id);
    assertEquals(book, testBook);
  }
}
