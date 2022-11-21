/**
 * Wiley Edge Project 2, November 2022.
 * UserIO class, used by View class to handle raw interaction with the console.
 *
 * @author Haaris Iqbal
 */

package ui;

import java.util.Scanner;

public class UserIO {
  // Variables for input.
  private String line;
  private Scanner scanner = new Scanner(System.in);


  /**
   * To obtain the input.
   *
   * @return the input String as lower-case.
   */
  public String input() {
    line = scanner.nextLine();

    return line.toLowerCase(); // Commands are always treated as being in lower case.
  }

  /**
   * To obtain input without altering its case sensitivity.
   *
   * @return the unaltered input String.
   */
  public String inputCaseSensitive() {
    line = scanner.nextLine();

    return line;
  }

  /**
   * To display output without creating a new line.
   *
   * @param out the output to be displayed.
   */
  public void out(String out) {
    System.out.print(out);
  }

  /**
   * To display output while also creating a new line.
   *
   * @param out the output to be displayed.
   */
  public void outln(String out) {
    System.out.println(out);
  }

  /**
   * To close the scanner upon quitting the program.
   */
  public void close() {
    scanner.close();
  }
}
