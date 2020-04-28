package application;

import javafx.event.ActionEvent;
import java.io.FileInputStream;
import java.util.List;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application  {
	// store any command-line arguments that were entered.
	// NOTE: this.getParameters().getRaw() will get these also
	private List<String> args;

	private static final int WINDOW_WIDTH = 650;
	private static final int WINDOW_HEIGHT = 650;
	private static final String APP_TITLE = "Milk Reports";
	
	@Override
	public void start(Stage primaryStage)  {
		 
        // Main layout is Border Pane
        BorderPane root = new BorderPane();
        VBox farm = new VBox();
        //creating all the anchorpanes/imagviews
        AnchorPane report = new AnchorPane();
        
        HBox reportOptions = new HBox();
        reportOptions.setMaxSize(650,50);
        
        // goes to add data file window
        Button addData = new Button("Add/Remove Data");
        
        //displays the type of report specified
        Button farmReport = new Button("Farm Report"); 
        Button annualReport = new Button("Annual Report");
        Button monthlyReport = new Button("Monthly Report");
        Button dataRangeReport = new Button("Data Range Report");
        
        //adds buttons to top box and aligns with page
        reportOptions.getChildren().add(addData);
        reportOptions.getChildren().add(farmReport);
        reportOptions.getChildren().add(annualReport);
        reportOptions.getChildren().add(monthlyReport);
        reportOptions.getChildren().add(dataRangeReport);
        farm.getChildren().add(reportOptions);
        
        
        Label typeOf = new Label("");
        report.getChildren().add(new Label("Example Report"));
        farm.getChildren().add(report);
        // action event 
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
        		
        		//Creating a GridPane container
        		GridPane datafile = new GridPane();
        		datafile.setPadding(new Insets(10, 10, 10, 10));
        		datafile.setVgap(5);
        		datafile.setHgap(5);
        		//Defining the Name text field
        		final TextField name = new TextField();
        		name.setPromptText("Enter your first file: ");
        		name.setPrefColumnCount(20);
        		name.getText();
        		GridPane.setConstraints(name, 0, 0);
        		datafile.getChildren().add(name);
        		//Defining the Submit button
        		Button add = new Button("Add");
        		GridPane.setConstraints(add, 1, 0);
        		datafile.getChildren().add(add);
        		//Defining the Clear button
        		Button remove = new Button("Remove");
        		GridPane.setConstraints(remove, 1, 1);
        		datafile.getChildren().add(remove);
        		
        		
        		Stage newStage = new Stage();
        		// positions all the panels
        		Scene scene = new Scene(datafile);
        		newStage.setScene(scene);

        		// change the width and height of scene
        		newStage.setWidth(400);
        		newStage.setHeight(400);
        		newStage.setTitle("Add Data File");
        		
        		newStage.show(); 
            } 
        }; 
  
        // when button is pressed 
        addData.setOnAction(event); 
        	
        
    
        
       // positions all the panels
        root.setTop(new Label(APP_TITLE)); 
        root.setCenter(farm);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        
        // change the width and height of scene
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);
        primaryStage.setTitle(APP_TITLE);
        primaryStage.show();
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   launch(args);
	}
}