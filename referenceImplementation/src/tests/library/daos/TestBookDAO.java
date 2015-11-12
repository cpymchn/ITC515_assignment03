package tests.library.daos;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import library.daos.BookMapDAO;
import library.entities.Book;
import library.interfaces.daos.IBookDAO;
import library.interfaces.daos.IBookHelper;
import library.interfaces.entities.IBook;
import static org.mockito.Mockito.*;

public class TestBookDAO
{
  private IBookHelper bookHelper;
  private BookMapDAO bookMapDAO;
//"Author", "Title", "CallNumber", 7
  
  @Before
  public void setUp() throws Exception
  {
  }



  @After
  public void tearDown() throws Exception
  {
  }



  @Test
  public void testBookMapDAOIBookHelper()
  {
    //setup
    bookHelper = mock(IBookHelper.class);
    BookMapDAO book = new BookMapDAO(bookHelper);
    //test
    
    //assert
    assertNotNull(book);
  }



  @Test
  public void testAddBook()
  {
    //setup
    IBook testBook = mock(IBook.class);
    when(bookHelper.makeBook("Author", "Title", "CallNumber", 7)).thenReturn(testBook);
    
    IBook book = bookMapDAO.addBook("Author", "Title", "CallNumber");
    verify(bookHelper).makeBook("Author", "Title", "CallNumber", 7);
    
    //assert
    assertEquals(book,testBook);
  }



  @Test
  public void testGetBookByID()
  {
    fail("Not yet implemented");
  }



  @Test
  public void testListBooks()
  {
    fail("Not yet implemented");
  }



  @Test
  public void testFindBooksByAuthor()
  {
    fail("Not yet implemented");
  }



  @Test
  public void testFindBooksByTitle()
  {
    fail("Not yet implemented");
  }



  @Test
  public void testFindBooksByAuthorTitle()
  {
    fail("Not yet implemented");
  }
}
