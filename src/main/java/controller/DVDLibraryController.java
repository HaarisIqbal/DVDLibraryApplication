/**
 * Wiley Edge Project 2, November 2022.
 * Controller class, to act as the interface between the UI, the DOA and the DTO.
 *
 * @author Haaris Iqbal
 */

package controller;

import dao.DVDLibraryDao;
import dto.DVD;
import ui.View;

import java.util.HashMap;
import java.util.HashSet;

public class DVDLibraryController {
  // Controller variables.
  private View view = new View();
  private DVDLibraryDao library = new DVDLibraryDao();

  // Key variables.
  private boolean programLoop = true;
  private HashMap<String, String> commands = new HashMap<String, String>();
  String input;
  HashSet<String> titles = new HashSet<String>();

  /**
   * Main loop of the program.
   */
  public void startProgram() {
    initializeCommands();

    view.introduction(commands);

    while (programLoop) {
      input = view.getInput();
      commandCase(input);
    }
  }

  /**
   * Private method making decisions based on given command.
   *
   * @param input the input from the UI.
   */
  private void commandCase(String input) {
    switch (input) {
      case "help":
        view.help(commands);
        break;
      case "add":
        add();
        break;
      case "remove":
        remove();
        break;
      case "edit":
        edit();
        break;
      case "list":
        listTitles();
        break;
      case "display":
        display();
        break;
      case "search":
        search();
        break;
      case "quit":
        endProgram();
        break;
      default:
        view.unknown(input);
    }
  }

  /**
   * Private method to end the program.
   */
  private void endProgram() {
    view.end();
    programLoop = false; // Ending loop after output message.
  }

  /**
   * Private method to list titles.
   */
  private void listTitles() {
    titles.clear(); // Must clear the HashSet to reflect updates in the file database.

    for (DVD dvd : library.getLibrary()) {
      titles.add(dvd.getTitle());
    }

    view.list(titles);
  }

  /**
   * Private method to display information on a particular DVD.
   */
  private void display() {
    listTitles();
    String displayTitle = view.displayGet();

    if (library.get(displayTitle) == null) {
      view.notFound(displayTitle);
    } else {
      view.display(library.get(displayTitle).getAllAttributes());
    }
  }

  /**
   * Private method to remove a DVD from the library.
   */
  private void remove() {
    listTitles();
    String removeTitle = view.remove();

    DVD toRemove = library.get(removeTitle);

    if (toRemove == null) {
      view.notFound(removeTitle);
    } else {
      library.removeDVD(toRemove);
      view.removeConfirm(removeTitle);
    }
  }

  /**
   * Private method to search for a DVD in the library.
   */
  private void search() {
    String searchTitle = view.search();
    DVD searchResult = library.get(searchTitle);

    if (searchResult == null) {
      view.notFound(searchTitle);
    } else {
      view.found(searchTitle);
    }
  }

  /**
   * Private method to add a DVD to the library.
   */
  private void add() {
    String[] parameters = view.add();
    DVD newDVD = new DVD(parameters[0], parameters[1], parameters[2], parameters[3], parameters[4], parameters[5]);

    // Add to library on the condition that there are no conflicting titles.
    if (library.get(newDVD.getTitle()) != null) {
      view.addFail();
    } else {
      library.addDVD(newDVD);
      view.addSuccess(newDVD.getTitle());
    }
  }

  /**
   * Private method to edit a DVD in the library.
   */
  private void edit() {
    listTitles();
    String editTitle = view.edit();

    if (library.get(editTitle) == null) {
      view.notFound(editTitle);
    } else {
      String[] parameters = view.editParameters(editTitle);
      DVD editedDVD = new DVD(parameters[0], parameters[1], parameters[2], parameters[3], parameters[4], parameters[5]);

      // Remove old version of DVD.
      library.removeDVD(library.get(editTitle));

      // Add new version of DVD.
      library.addDVD(editedDVD);

      // Confirm success.
      view.editSuccess(editTitle);
    }
  }

  /**
   * Private method to initialize a HashSet of valid commands.
   */
  private void initializeCommands() {
    commands.put("help", "To display all commands.");
    commands.put("add", "to add a new DVD to the library.");
    commands.put("remove", "to remove a DVD from the library.");
    commands.put("edit", "to edit a DVD in the Library.");
    commands.put("list", "to list all DVDs in the library");
    commands.put("display", "to display information on a particular DVD.");
    commands.put("search", "to search for a DVD.");
    commands.put("quit", "to quit the program.");
  }

}
