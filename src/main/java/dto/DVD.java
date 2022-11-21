/**
 * Wiley Edge Project 2, November 2022.
 * DVD class, to represent DVDs (data transfer object).
 *
 * @author Haaris Iqbal
 */

package dto;

public class DVD {
  // Key attributes of DVD.
  private String title;
  private String releaseDate;
  private String mpaaRating;
  private String directorName;
  private String studio;
  private String additionalInfo;

  /**
   * Constructor method: Instantiates a new DVD with all attributes.
   *
   * @param title          the title of the DVD.
   * @param releaseDate    the release date of the DVD.
   * @param mpaaRating     the MPAA rating.
   * @param directorName   the directors name.
   * @param studio         the studio that produced the DVD.
   * @param additionalInfo any additional information related to the DVD.
   */
  public DVD(String title, String releaseDate, String mpaaRating, String directorName, String studio, String additionalInfo) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.mpaaRating = mpaaRating;
    this.directorName = directorName;
    this.studio = studio;
    this.additionalInfo = additionalInfo;
  }

  // Getter methods.

  /**
   * Gets title.
   *
   * @return the title of the DVD.
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Gets release date.
   *
   * @return the release date of the DVD.
   */
  public String getReleaseDate() {
    return this.releaseDate;
  }

  /**
   * Gets MPAA rating.
   *
   * @return the mpaa rating of the DVD.
   */
  public String getMPAARating() {
    return this.mpaaRating;
  }

  /**
   * Gets Director name.
   *
   * @return the director's name.
   */
  public String getDirectorName() {
    return this.directorName;
  }

  /**
   * Gets Studio name.
   *
   * @return the studio that produced the DVD.
   */
  public String getStudio() {
    return this.studio;
  }

  /**
   * Gets additional info.
   *
   * @return any additional info on the DVD.
   */
  public String getAdditionalInfo() {
    return this.additionalInfo;
  }

  /**
   * Get all attributes of the DVD.
   *
   * @return a String array of all attributes of the DVD.
   */
  public String[] getAllAttributes() {
    String[] allAttributes = new String[6];

    // Prepare array will all attributes.
    allAttributes[0] = this.title;
    allAttributes[1] = this.releaseDate;
    allAttributes[2] = this.mpaaRating;
    allAttributes[3] = this.directorName;
    allAttributes[4] = this.studio;
    allAttributes[5] = this.additionalInfo;

    return allAttributes;
  }

  // Setters methods.

  /**
   * Sets title.
   *
   * @param title the title of the DVD.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Sets release date.
   *
   * @param releaseDate the release date of the DVD.
   */
  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  /**
   * Sets MPAA rating.
   *
   * @param mpaaRating the MPAA rating of the DVD.
   */
  public void setMpaaRating(String mpaaRating) {
    this.mpaaRating = mpaaRating;
  }

  /**
   * Sets Director name.
   *
   * @param directorName the Director's name.
   */
  public void setDirectorName(String directorName) {
    this.directorName = directorName;
  }

  /**
   * Sets Studio name.
   *
   * @param studio the studio that produced the DVD.
   */
  public void setStudio(String studio) {
    this.studio = studio;
  }

  /**
   * Sets additional info.
   *
   * @param additionalInfo any additional info related to the DVD.
   */
  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }
}
