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
import java.util.List;

public class TestBookDAO
{
  private IBook testBook;
  private IBookHelper bookHelper;
  private BookMapDAO bookMapDAO;
  private int id = 1;
  private String author = "Author";
  private String title = "Title";
  private String callNo = "callNo";
  
  @Before
  public void setUp() throws Exception
  {
    bookHelper = mock(IBookHelper.class);
    testBook = mock(IBook.class);
    when(testBook.getID()).thenReturn(1);
    when(testBook.getTitle()).thenReturn("Title");
    when(testBook.getAuthor()).thenReturn("Author");
    when(bookHelper.makeBook(author, title, callNo, 1)).thenReturn(testBook);
    bookMapDAO = new BookMapDAO(bookHelper);
  }



  @After
  public void tearDown() throws Exception
  {
    bookHelper = null;
    testBook = null;
    bookMapDAO = null;
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
    when(bookHelper.makeBook(author, title, callNo, 1)).thenReturn(testBook);
    IBook book = bookMapDAO.addBook(author, title, callNo);

    //assert
    assertEquals(book,testBook);
  }



  @Test
  public void testGetBookByID()
  {
    //setup
    when(bookHelper.makeBook(author, title, callNo, 1)).thenReturn(testBook);
    when(testBook.getID()).thenReturn(id);
    IBook book = bookMapDAO.addBook(author, title, callNo);
    book = bookMapDAO.getBookByID(id);

    //assert
    assertEquals(book,testBook);
  }



  @Test
  public void testListBooks()
  {
    //setup
    bookMapDAO.addBook(author, title, callNo);
    List<IBook> listBooks = bookMapDAO.listBooks();

   //assert
    assertTrue(listBooks.contains(testBook));
  }



  @Test
  public void testFindBooksByAuthor()
  {
    //setup
    bookMapDAO.addBook(author, title, callNo);
    List<IBook> listBooks = bookMapDAO.findBooksByAuthor("Author");
    IBook listTest = listBooks.get(0);
    //assert
    assertEquals("Author", listTest.getAuthor());
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
