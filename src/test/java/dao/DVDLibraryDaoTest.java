package dao;

import dto.DVD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DVDLibraryDaoTest {
  // Key variables.
  private DVDLibraryDao library = new DVDLibraryDao();;
  private DVD dvdOne;
  private DVD dvdTwo;
  private HashSet<DVD> mockLibrary = new HashSet<DVD>();

  // Before each test.
  @BeforeEach
  void beforeEach() {
    dvdOne = new DVD("Jaws", "1975", "12","Steven Spielberg", "Universal Pictures", " ");
    dvdTwo = new DVD("Jaws 2", "1978", "12", "Steven Spielberg", "Universal Pictures", " ");

    library.eraseLibrary(); // to give all tests a fresh DVDLibraryDao to work with.
  }

  // Test 1.
  // Testing getting library.
  @Test
  void testGetLibrary() {
    assertEquals(mockLibrary, library.getLibrary());

    // Update and check against mock library.
    mockLibrary.add(dvdOne);
    assertNotEquals(mockLibrary, library.getLibrary());
  }

  // Test 2.
  // Testing add to library.
  @Test
  void testAdd() {
    assertNotEquals(1, library.getLibrary().size());

    library.addDVD(dvdOne);
    mockLibrary.add(dvdOne);

    assertEquals(1, library.getLibrary().size());
  }

  // Test 3.
  // Testing removal from library.
  @Test
  void testRemove() {
    library.addDVD(dvdOne);

    assertEquals(false, library.getLibrary().isEmpty());

    library.removeDVD(dvdOne);

    assertEquals(true, library.getLibrary().isEmpty());
  }

  // Test 4.
  // Testing empty removal from library throwing error.
  @Test
  void testEmptyRemoveError() {
    assertThrows(EmptyStackException.class, () -> library.removeDVD(dvdOne));
  }

  // Test 5.
  // Testing false removal from library throwing error.
  @Test
  void testFalseRemoveError() {
    library.addDVD(dvdTwo);

    assertThrows(IllegalArgumentException.class, () -> library.removeDVD(dvdOne));
  }

  // Test 6.
  // Testing getting a particular DVD.
  @Test
  void testGet() {
    assertEquals(null, library.get("Jaws"));
    assertEquals(null, library.get("Jaws 2"));

    library.addDVD(dvdOne); // Titled "Jaws".
    library.addDVD(dvdTwo); // Titled "Jaws 2".

    assertEquals(dvdOne.getReleaseDate(), library.get("Jaws").getReleaseDate());
    assertEquals(dvdTwo.getReleaseDate(), library.get("Jaws 2").getReleaseDate());
    assertEquals(null, library.get("Jaws 3"));
  }

  // Test 7
  // Testing adding many DVDs to the file database - Also leaves good DVD example data.
  @Test
  void testAddMany() {
    library.eraseLibrary();

    library.addDVD(new DVD("Jaws", "1975", "12","Steven Spielberg", "Universal Pictures", " "));
    library.addDVD(new DVD("Arrival","1092016","12","Dennis Villeneuve","FilmNation Entertainment","94% Approval rating on Rotten Tomatoes"));
    library.addDVD(new DVD("Jaws 2", "1978", "12", "Steven Spielberg", "Universal Pictures", " "));
    library.addDVD(new DVD("One","12121999","18","Terry","HBO","Yuck"));
    library.addDVD(new DVD("Gladiator", "1052000", "15", "Ridley Scott", "DreamWorks", "Ridley Scott's Gladiator is an epic film with quotes to match."));
    library.addDVD(new DVD("Valhalla Rising", "10102016", "21", "Thorsen", "Norway Films", "Good."));
    library.addDVD(new DVD("The Proposition","1042015","18","N. Cave","AMG","Excellent"));
    library.addDVD(new DVD("The Lord of the Rings: The Fellowship of the Ring","10122001","13","Peter Jackson","New Line Cinema","10/10"));

    assertEquals(8, library.getLibrary().size());
  }
}