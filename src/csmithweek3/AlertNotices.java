package csmithweek3;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Craig Smith
 * @Assignment Name: csmith_week4 - week8
 * @Date: Sep 27, 2020, Updated 10/9/20
 * @Subclass AlertNotices Description: Class to display popup window alerts
 * @Description: 10/9/20 Added empty form alert, removed unused Font method
 */
//Imports
import javafx.scene.control.Alert;

//Begin Subclass AlertNotices
public class AlertNotices {

    /**
     * Method to generate an alert box for invalid integer entry
     *
     * @param content String message to display
     */
    public static void invalidIntegerAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Invalid Integer Input");
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Method to generate an alert box for invalid Double entry
     *
     * @param content String message to display
     */
    public static void invalidDoubleAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Invalid Double Input");
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Method to generate an alert box for invalid integer entry
     *
     * @param content String message to display
     */
    public static void emptyFormAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Empty Form Submission Error");
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Method to generate an alert box for invalid integer entry
     *
     * @param content String message to display
     */
    public static void fileCouldNotBeCreatedAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("File I/O Error");
        alert.setHeaderText("File Could Not Be Created or Accessed");
        alert.setContentText(content);
        alert.setResizable(true);
        alert.showAndWait();
    }

    /**
     * Method to generate an alert box for the inability to open the files
     *
     * @param content String message to display
     */
    public static void fileCouldNotBeOpened(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("File I/O Error");
        alert.setHeaderText("File Access Failure");
        alert.setContentText(content);
        alert.setResizable(true);
        alert.showAndWait();
    }

    /**
     * Method to generate an alert box for the inability to read an open file
     *
     * @param content String message to display
     */
    public static void fileCouldNotBeRead(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("File I/O Error");
        alert.setHeaderText("File Could Not Be Read");
        alert.setContentText(content);
        alert.setResizable(true);
        alert.showAndWait();
    }

    /**
     * Method to generate an alert box for the inability to write to a file
     *
     * @param content String message to display
     */
    public static void fileCouldNotBeWritten(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("File I/O Error");
        alert.setHeaderText("File Could Not Be Written To");
        alert.setContentText(content);
        alert.setResizable(true);
        alert.showAndWait();
    }

    /**
     * Method to generate an alert box for a key not contained in a map
     *
     * @param content String message to display
     */
    public static void keyNotFoundInMap(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Key Lookup");
        alert.setHeaderText("Key could not be located");
        alert.setContentText(content);
        alert.setResizable(true);
        alert.showAndWait();
    }

    /**
     * Method to generate an Information Notice to advise file has no contents
     *
     * @param content String message to display
     */
    public static void fileIsEmpty(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("File Information Notice");
        alert.setHeaderText("The file contains no contents");
        alert.setContentText(content);
        alert.setResizable(true);
        alert.showAndWait();
    }

    /**
     * Method to generate an Information Notice to advise a file was not
     * selected
     *
     * @param content String message to display
     */
    public static void fileNotChosen(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("File Information Notice");
        alert.setHeaderText("No File Chosen");
        alert.setContentText(content);
        alert.setResizable(true);
        alert.showAndWait();
    }

    /**
     * Method to generate an Information Notice to advise an input violation
     * occurred
     *
     * @param content String message to display
     */
    public static void inputViolation(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invald Input Notice");
        alert.setHeaderText("Input Violation");
        alert.setContentText(content);
        alert.setResizable(true);
        alert.showAndWait();
    }

} //End Subclass AlertNotices
