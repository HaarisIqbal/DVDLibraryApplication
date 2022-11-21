/**
 * Wiley Edge Project 2, November 2022.
 * View class, to handle user interaction generally.
 *
 * @author Haaris Iqbal
 */

package ui;

import java.util.HashMap;
import java.util.HashSet;

public class View {
  // Variables.
  private UserIO userIO = new UserIO();
  private String[] possibleAttributes = {"Title", "Release Date", "MPAA Rating", "Director Name", "Studio", "Additional Info"};

  /**
   * Introduction to the program.
   *
   * @param commands the commands available to the user.
   */
  public void introduction(HashMap<String, String> commands) {
    userIO.outln("*** Welcome to the DVD Library Program! ***\n");

    displayCommands(commands); // Initial display of the available commands.

    userIO.outln("\nPlease type a command, or type 'help' for a list of commands.");
  }

  /**
   * The available commands in this program.
   *
   * @param commands the commands available to the user.
   */
  public void displayCommands(HashMap<String, String> commands) {
    userIO.outln("These are all of the available commands:");

    for (String key : commands.keySet()) {
      userIO.outln("-> " + key + " - " + commands.get(key));
    }
  }

  /**
   * Getting command input during the loop.
   *
   * @return the input
   */
  public String getInput() {
    userIO.out(">>> ");
    String input = userIO.input();
    userIO.outln("");

    return input;
  }

  /**
   * To display a list of all possible commands.
   *
   * @param commands the commands available to the user.
   */
  public void help(HashMap<String, String> commands) {
    displayCommands(commands);
    userIO.outln("");
  }

  /**
   * To display add DVD functionality.
   *
   * @return a String array of parameters collected to create a new DVD.
   */
  public String[] add() {
    String[] parameters = new String[6];

    userIO.outln("Please input the following information for the DVD you would like to add to the library.");

    // Getting all parameters.
    for (int i = 0; i < 6; i++) {
      userIO.out(possibleAttributes[i] + ": ");
      parameters[i] = userIO.inputCaseSensitive();

      // Default for blank information.
      if (parameters[i] == "") {
        parameters[i] = "n/a";
      }
    }

    userIO.outln("\nAdding the DVD to the library. Await confirmation...\n");

    return parameters;
  }

  /**
   * To display failure to add a DVD to the library.
   */
  public void addFail() {
    userIO.outln("Unfortunately, this DVD could not be added to the Library - there is a DVD with the same name!\n");
  }

  /**
   * To display successful addition of a DVD to the library.
   *
   * @param title the title of the new DVD, now present in the library.
   */
  public void addSuccess(String title) {
    userIO.outln("The new DVD '" + title + "' has been added to the library!\n");
  }

  /**
   * To display remove DVD functionality.
   *
   * @return the string
   */
  public String remove() {
    userIO.outln("Please type in the title of the DVD you would like to remove.");
    userIO.out("=> ");
    String removeTitle = userIO.input();
    userIO.outln("");
    return removeTitle;
  }

  /**
   * Confirming that removal has been successful.
   *
   * @param title the title of the now-removed DVD, formally in the library.
   */
  public void removeConfirm(String title) {
    userIO.outln("The DVD '" + title + "' has been removed from the library!");
    userIO.outln("");
  }

  /**
   * Displaying functionality to edit a DVD in the library.
   *
   * @return the title of the DVD to be edited.
   */
  public String edit() {
    userIO.outln("Please type in the title of the DVD you would like edit.");
    userIO.out("=> ");
    String editTitle = userIO.inputCaseSensitive();
    userIO.outln("");
    return editTitle;
  }

  /**
   * Collecting edited parameters of a DVD.
   *
   * @param title the title of the DVD being edited.
   * @return a String array of parameters collected to edit the DVD.
   */
  public String[] editParameters(String title) {
    String[] parameters = new String[6];

    userIO.outln("You are editing the DVD '" + title + "'\n");
    userIO.outln("Please input the new information for this DVD.");

    // Getting all parameters.
    for (int i = 0; i < 6; i++) {
      userIO.out(possibleAttributes[i] + ": ");
      parameters[i] = userIO.inputCaseSensitive();

      // Default for blank information.
      if (parameters[i] == "") {
        parameters[i] = "n/a";
      }
    }

    userIO.outln("\nChanges are being made. Await confirmation...\n");

    return parameters;
  }

  /**
   * To confirm a successful edit.
   *
   * @param title the original title of the DVD that has been edited.
   */
  public void editSuccess(String title) {
    userIO.outln("The DVD with the original title of '" + title + "' has successfully been edited!");
    userIO.outln("Use the 'display' command to view information on the edited DVD!\n");
  }

  /**
   * To display a list of all the available DVDs in the library.
   *
   * @param titles a full list of DVD titles in the library.
   */
  public void list(HashSet<String> titles) {
    // List titles.
    userIO.outln("This is the full list of DVDs in the library:");

    for (String title : titles) {
      userIO.outln("--> " + title);
    }

    userIO.outln("");
  }

  /**
   * To get the title of a DVD to display attributes for.
   *
   * @return the title of the DVD to view.
   */
  public String displayGet() {
    userIO.outln("Please enter the title of the DVD you would like information on.");
    userIO.out("=> ");
    String displayTitle = userIO.input();
    userIO.outln("");

    return displayTitle;
  }

  /**
   * To display all the attributes of a DVD.
   *
   * @param allAttributes a String array of attributes related to the DVD.
   */
  public void display(String[] allAttributes) {
    userIO.outln("Here is all the information present on this DVD: ");

    for (int i = 0; i < 6; i++) {
      userIO.outln(possibleAttributes[i] + ":\t" + allAttributes[i]);
    }

    userIO.outln("");
  }

  /**
   * To get the title of a DVD to search for.
   *
   * @return the title of the DVD to search for.
   */
  public String search() {
    userIO.outln("Please type in the title of the DVD you would like to search for.");
    userIO.out("=> ");
    String searchTitle = userIO.input();
    userIO.outln("");
    return searchTitle;
  }

  /**
   * Error for displaying an unknown command.
   *
   * @param input the unknown command that was typed.
   */
  public void unknown(String input) {
    userIO.outln("'" + input + "' is not a valid command!");
    userIO.outln("");
  }

  /**
   * Error for when a given title does not exist in the library.
   *
   * @param title the missing title.
   */
  public void notFound(String title) {
    userIO.outln("There is no DVD with the title '" + title + "'!");
    userIO.outln("");
  }

  /**
   * For when a given title has been found in the library.
   *
   * @param title the present title.
   */
  public void found(String title) {
    userIO.outln("The DVD '" + title + "' exists in the library!");
    userIO.outln("Use the display command to get more details.");
    userIO.outln("");
  }

  /**
   * To end the program.
   */
  public void end() {
    userIO.outln("Shutting program now!\n");
    userIO.close();
  }
}
