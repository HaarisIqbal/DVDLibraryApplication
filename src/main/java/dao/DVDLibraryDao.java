/**
 * Wiley Edge Project 2, November 2022.
 * DVDLibraryDao class, to access DVD objects (data access object).
 *
 * @author Haaris Iqbal
 */

package dao;

import dto.DVD;

import java.io.*;
import java.util.EmptyStackException;
import java.util.HashSet;

public class DVDLibraryDao {
  // Variables.
  private HashSet<DVD> dvds = new HashSet<DVD>(); // HashSet acting as mirror to the file database, to hold DVDs from Library.
  private File dvdLibrary = new File("src/main/java/dao/DVDLibrary.txt"); // Location of the "Library" (the file database).

  /**
   * Private method to get all DVDs from the Library.
   */
  private void readLibrary() {
    try {
      FileReader fileReader = new FileReader(dvdLibrary); // Read the file itself.
      BufferedReader bufferedReader = new BufferedReader(fileReader); // Line per line reading.

      // Clear HashSet of current DVDs
      dvds.clear();

      // Variables to process data in Library.
      String lineFromFile = "";
      String[] att;
      DVD dvd;

      // Iterating though each DVD in Library.
      lineFromFile = bufferedReader.readLine();
      while (lineFromFile != null) {
        att = lineFromFile.split(",");

        // Using raw data to construct a DVD.
        dvd = new DVD(att[0], att[1], att[2], att[3], att[4], att[5]);

        // Adding to HashSet.
        dvds.add(dvd);

        // Move to next iteration.
        lineFromFile = bufferedReader.readLine();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Private method to add a new DVD to the Library.
   *
   * @param dvd the DVD to be added to the Library.
   */
  private void writeLibrary(DVD dvd) {
    readLibrary(); // to get HashSet of current DVDs.

    String dvdString = "";

    for (String attribute : dvd.getAllAttributes()) {
      dvdString += attribute + ",";
    }
    dvdString = dvdString.substring(0, dvdString.length()-1); // to remove last comma.

    // Add dvd to file database.
    try {
      FileWriter fileWriter = new FileWriter(dvdLibrary, true);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      if (!dvds.isEmpty()) {
        bufferedWriter.newLine();
      }
      bufferedWriter.write(dvdString);

      // Close.
      bufferedWriter.flush();
      bufferedWriter.close();

      // Finally, add new dvd to HashSet
      dvds.add(dvd);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * To remove all DVDs from the current DVD Library.
   */
  public void eraseLibrary() {
    // Erase all in file database.
    try {
      FileWriter fileWriter = new FileWriter(dvdLibrary, false);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      // Since append is set to false, this will erase text file of all information.
      bufferedWriter.write("");

      // Close.
      bufferedWriter.flush();
      bufferedWriter.close();

      // Finally, erase HashSet.
      dvds.clear();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets the current DVD Library.
   *
   * @return the dvds HashSet containing all dvds held.
   */
  public HashSet<DVD> getLibrary() {
    readLibrary();

    return this.dvds; // Returning HashSet.
  }

  /**
   * Add DVD to the collection.
   *
   * @param dvd the DVD to be added to the library.
   */
  public void addDVD(DVD dvd) {
    writeLibrary(dvd);
  }

  /**
   * Remove DVD from the collection.
   *
   * @param dvd the DVD to be removed.
   */
  public void removeDVD(DVD dvd) {
    readLibrary(); // to get up-to-date HashSet before removal.

    // Throw empty stack exception if empty.
    if (this.dvds.isEmpty()) {
      throw new EmptyStackException();
    }

    // HashSet of current DVDs in Library, to overwrite in file database.
    HashSet<DVD> overWrite = new HashSet<DVD>();

    // Duplication without pointers.
    for (DVD cDVD : this.dvds) {
      overWrite.add(cDVD);
    }

    // Variables for comparison and removal.
    boolean notFound = true; // By default, assuming not in Library.
    String[] libDVDAtt;
    String[] dvdAtt = dvd.getAllAttributes();
    DVD toRemove = null;

    // Compare attributes of DVD to ensure it is in library.
    for (DVD libDVD : overWrite) {
      if (
              libDVD.getTitle().equals(dvd.getTitle())
              && libDVD.getReleaseDate().equals(dvd.getReleaseDate())
              &&  libDVD.getDirectorName().equals(dvd.getDirectorName())
      ) {
        notFound = false; // As key attributes match, the DVD has been found in the HashSet.
        toRemove = libDVD;
      }
    }

    // Throw exception if not found.
    if (notFound) {
      throw new IllegalArgumentException();
    }

    // Remove the DVD from the overWrite HashSet.
    overWrite.remove(toRemove); // remove the DVD to be deleted from the overwrite HashSet.

    // Finally, rewrite into file database using overwrite hashset.
    eraseLibrary();

    for (DVD nDVD : overWrite) {
      writeLibrary(nDVD);
    }
  }

  /**
   * Get DVD from Library with title.
   *
   * @param title the title of the DVD to search for
   * @return the DVD with the corresponding title, or null if not present.
   */
  public DVD get(String title) {
    readLibrary(); // to get up-to-date collection.

    // Check all dvd titles in Library - ignore case sensitivity.
    for (DVD dvd : dvds) {
      if (dvd.getTitle().equalsIgnoreCase(title)) {
        return dvd;
      }
    }

    // Return null if not found.
    return null;
  }

}
