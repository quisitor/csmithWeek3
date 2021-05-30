package csmithweek3;

/**
 * @Course: SDEV-450-81 ~ Java Programming III EE
 * @Author Name: Craig Smith
 * @Assignment Name: csmithweek3
 * @Date: May 27, 2021
 * @Description:
 */

//Imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Pos;

//Begin Class JavaFXHashMaps
public class JavaFXHashMaps extends Application {

    /*Window components*/
    private final TextField tfName = new TextField();
    private final TextField tfAge = new TextField();
    private final TextArea taInput = new TextArea();
    private final TextArea taOutput = new TextArea();
    private final Button btFind = new Button("Find");
    private final Button btRemove = new Button("Remove");
    private final Button btClear = new Button("Clear");
    private final Label lbName = new Label("Name:");
    private final Label lbAge = new Label("Age:");
    private final Button btEnter = new Button("Enter");
    private final Button btExit = new Button("Exit");
    
    /*Object to store the user input values*/
    private final MyHashMap hMapDataStore = new MyHashMap();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
       
        /*Main Structure*/
        GridPane gpMain = new GridPane();
        VBox vbLeftMain = new VBox();
        HBox hbLeftMain = new HBox();
        GridPane gpLeftMain = new GridPane();
        Pane pnRightMain = new Pane();
        
        pnRightMain.getChildren().add(taOutput);
        hbLeftMain.getChildren().addAll(lbName, tfName, lbAge, tfAge);
        gpLeftMain.add(btEnter, 0, 0);
        gpLeftMain.add(btClear, 0, 1);
        gpLeftMain.add(btFind, 1, 0);
        gpLeftMain.add(btExit, 1, 1);
        gpLeftMain.add(btRemove, 2, 0);
        vbLeftMain.getChildren().addAll(hbLeftMain, gpLeftMain, taInput);
        gpMain.add(vbLeftMain, 0, 0);
        gpMain.add(pnRightMain, 1, 0);
       
        /*Fine Tune Main Structure*/
        hbLeftMain.getStyleClass().add("hbox");
        gpMain.getStyleClass().add("grid-pane");
        vbLeftMain.getStyleClass().add("vbox");
        tfName.setId("name-field");
        tfAge.setId("age-field");
        taInput.setId("input-area");
        taOutput.setId("output-area");
        gpLeftMain.setAlignment(Pos.CENTER);
        gpLeftMain.setHgap(40);
        gpLeftMain.setVgap(10);
        hbLeftMain.setAlignment(Pos.CENTER_LEFT);
        vbLeftMain.setSpacing(20);
        gpMain.setHgap(20);
        gpMain.setVgap(20);
        gpMain.setAlignment(Pos.CENTER);
        
        /* Event Handlers */
        btExit.setOnAction(e -> System.exit(0));
        btEnter.setOnAction(e -> {
            boolean ageError = false;
            if (!tfAge.getText().trim().isEmpty()){
                if (Validator.isPositiveInteger(tfAge.getText().trim())) {
                    Integer age = new Integer(tfAge.getText().trim());
                    if (age > 969 || age < 0) {
                        ageError = true;
                    }
                } else {
                    ageError = true;
                }               
            } else {
                ageError = true;
            }
            
            if (tfName.getText().trim().isEmpty() || ageError) {
                AlertNotices.inputViolation("Input Error!" + 
                        "\n Please enter both a valid Name and a valid integer Age" +
                        " between 0 and 969 Years");
                tfName.clear();
                tfAge.clear();
                tfName.requestFocus();
            } else {
                hMapDataStore.put(tfName.getText().trim(), tfAge.getText().trim());
                taInput.setText(String.format("%s was entered into the table.\n",
                        tfName.getText().trim()));
                displayOutput();
                tfAge.clear();
                tfName.clear();
                tfName.requestFocus();
                btFind.setDisable(false);
                btRemove.setDisable(false);
            }
        });
        btClear.setOnAction(e -> {initGUI();
            taInput.setText("The HashMap is now empty.");
        });
        btFind.setOnAction(e -> {
            if(tfName.getText().trim().isEmpty() || !tfAge.getText().trim().isEmpty()){
                AlertNotices.inputViolation("The Find function currently only supports" +
                         " a Name lookup.\n Please enter a Name, and a name only.");
                tfName.clear();
                tfAge.clear();
                tfName.requestFocus();
            } else {
                boolean hasNameKey = hMapDataStore.containsKey(tfName.getText());
                if (hasNameKey) {
                    taInput.clear();
                    taInput.setText(String.format(
                            "%s is in the database and %s is %s years old.", 
                            tfName.getText(),
                            tfName.getText(),
                            hMapDataStore.get(tfName.getText())));
                }
            }
        });
        btRemove.setOnAction(e -> {
            if(tfName.getText().trim().isEmpty() || !tfAge.getText().trim().isEmpty()){
                AlertNotices.inputViolation("The Remove function currently only supports" +
                         " a Name removal.\n Please enter a Name, and a name only.");
                tfName.clear();
                tfAge.clear();
                tfName.requestFocus();
            } else {
                boolean hasNameKey = hMapDataStore.containsKey(tfName.getText());
                if (hasNameKey) {
                    hMapDataStore.remove(tfName.getText());
                    taInput.clear();
                    taInput.setText(String.format("%s has been removed from the database.",tfName.getText()));
                    displayOutput();
                    tfName.clear();
                    tfAge.clear();
                    tfName.requestFocus();
                    if (hMapDataStore.isEmpty()) {
                        initGUI();
                        taInput.setText("The HashMap is now empty.");
                    }
                }
            }
        });
        
        
        /*Set and Paint Main Window*/    
        initGUI();
        Scene sceneMain = new Scene(gpMain);
        sceneMain.getStylesheets().add("csmithweek3/javaFXHashMapGuiCSS.css");
        primaryStage.setScene(sceneMain);
        primaryStage.setTitle("Hash Maps");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    /**
     * Method to Initialize and/or Reset the GUI
     */
    private void initGUI() {
        hMapDataStore.clear();
        tfName.clear();
        tfAge.clear();
        taInput.clear();
        taOutput.clear();
        tfName.requestFocus(); 
        taOutput.setEditable(false);
        taInput.setEditable(false);
        btFind.setDisable(true);
        btRemove.setDisable(true);
    }
    
    /**
     * Method to display the list to the user via the right text area
     */
    private void displayOutput() {
        taOutput.clear();
        StringBuilder outputListView = new StringBuilder();
        hMapDataStore.keySet().forEach((key) -> {
            outputListView.append(String.format("%s is %s years old.\n", key,
                    hMapDataStore.get(key)));
        });
        taOutput.setText(outputListView.toString());
        }
    
} //End Class JavaFXHashMaps

