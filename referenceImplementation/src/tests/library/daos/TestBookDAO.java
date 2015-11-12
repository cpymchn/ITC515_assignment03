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
  IBook testBook;
  private IBookHelper bookHelper;
  private BookMapDAO bookMapDAO;
  private int id = 1;
  private String author = "Author";
  private String title = "Title";
  private String callNumber = "CallNumber";
  
  @Before
  public void setUp() throws Exception
  {
    bookHelper = mock(IBookHelper.class);
    testBook = mock(IBook.class);
    when(testBook.getID()).thenReturn(1);
    when(testBook.getTitle()).thenReturn("Title");
    when(testBook.getAuthor()).thenReturn("Author");
    when(bookHelper.makeBook(author, title, callNumber, id)).thenReturn(testBook);
  }



  @After
  public void tearDown() throws Exception
  {
  }



  @Test
  public void testBookMapDAOIBookHelper()
  {
    //setup
    bookMapDAO = new BookMapDAO(bookHelper);
    //test
    
    //assert
    assertNotNull(bookMapDAO);
  }



  @Test
  public void testAddBook()
  {
    //setup
    IBook book = bookMapDAO.addBook("Author", "Title", "CallNumber");
    verify(bookHelper).makeBook("Author", "Title", "CallNumber", 1);
    
    //assert
    assertEquals(book,testBook);
  }



  @Test
  public void testGetBookByID()
  {
    //setup
    
    IBook book = bookMapDAO.addBook(author, title, callNumber);
    book = bookMapDAO.getBookByID(id);
    
    
    //assert
    assertEquals(book, testBook);
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
