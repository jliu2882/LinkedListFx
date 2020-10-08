import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
public class LinkedListFX extends Application {
	public void start(Stage primaryStage) {
		MyLinkedList<Integer> linked = new MyLinkedList<>(); // Create a tree
		BorderPane pane = new BorderPane();
		BTView view = new BTView(linked); // Create a View
		pane.setCenter(view);
		TextField tfKey = new TextField();
		tfKey.setPrefColumnCount(3);
		tfKey.setAlignment(Pos.BASELINE_RIGHT);
		Button btInsert = new Button("Insert");
		Button btDelete = new Button("Delete");
		HBox hBox = new HBox(5);
		hBox.getChildren().addAll(new Label("Enter a key: "),
		tfKey, btInsert, btDelete);
		hBox.setAlignment(Pos.CENTER);
		pane.setBottom(hBox);
		btInsert.setOnAction(e -> {
			int key = Integer.parseInt(tfKey.getText());
			if (linked.indexOf(key)>=0) { // key is in the tree already
				view.displayTree();
				view.setStatus(key + " is already in the tree");
			} else {
				linked.add(key); // Insert a new key
				view.displayTree();
				view.setStatus(key + " is inserted in the tree");
		}});
		btDelete.setOnAction(e -> {
			int key = Integer.parseInt(tfKey.getText());
			if (linked.indexOf(key)<0) { // key is not in the tree
				view.displayTree();
				view.setStatus(key + " is not in the tree");
			} else {
				linked.remove(linked.indexOf(key)); // Delete a key
				view.displayTree();
				view.setStatus(key + " is deleted from the tree");
		}});
		// Create a scene and place the pane in the stage
		Scene scene = new Scene(pane, 450, 250);
		primaryStage.setTitle("BSTAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	public static void main(String[] args) {
		launch(args);
	}
}