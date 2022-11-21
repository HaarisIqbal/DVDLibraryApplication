/**
 * Wiley Edge Project 2, November 2022.
 * App class, to call execute method and start program.
 *
 * @author Haaris Iqbal
 */

package controller;

public class App {
  // Key variable - a new DVD Library controller.
  private static DVDLibraryController controller = new DVDLibraryController();

  /**
   * Private method to start the program.
   */
  private static void execute() {
    controller.startProgram();
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments.
   */
  public static void main(String[] args) {
    execute();
  }
}
