package dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DVDTest {

  private DVD dvd; // DVD object to use throughout tests.

  @BeforeEach
  void beforeEach() {
    dvd = new DVD("Jaws", "1975", null,"Steven Spielberg", null, null);
  }

  // Test 1.
  // Testing return of getTitle.
  @Test
  void testGetTitle() {
    assertEquals("Jaws", dvd.getTitle());
  }

  // Test 2.
  // Testing return of getReleaseDate.
  @Test
  void testGetReleaseDate() {
    assertEquals("1975", dvd.getReleaseDate());
  }

  // Test 3.
  // Testing return of getDirectorName.
  @Test
  void testGetDirectorName() {
    assertEquals("Steven Spielberg", dvd.getDirectorName());
  }

  // Test 4.
  // Testing return of null getters.
  @Test
  void testGetNulls() {
    assertEquals(null, dvd.getStudio());
    assertEquals(null, dvd.getMPAARating());
    assertEquals(null, dvd.getAdditionalInfo());
  }

  // Test 5.
  // Testing adding new information.
  @Test
  void testSetStudio() {
    dvd.setStudio("Universal Pictures"); // Setting new Studio name.
    assertEquals("Universal Pictures", dvd.getStudio()); // Getting new Studio name.
  }

  // Test 6.
  // Testing modification of existing information.
  @Test
  void testChange() {
    assertEquals("Steven Spielberg", dvd.getDirectorName());

    dvd.setDirectorName("Haaris Iqbal"); // Changing .
    assertEquals("Haaris Iqbal", dvd.getDirectorName());
  }
}
