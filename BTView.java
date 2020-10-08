
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BTView extends Pane {
	private MyLinkedList<Integer> list = new MyLinkedList<>();
	private double radius = 15; // Tree node radius
	private double vGap = 50; // Gap between two levels in a tree
		BTView(MyLinkedList<Integer> list) {
		this.list = list;
		setStatus("Tree is empty");
	}
	public void setStatus(String msg) {
		getChildren().add(new Text(20, 20, msg));
	}
	public void displayTree() {
		this.getChildren().clear(); // Clear the pane
		if (list.getFirstNode() != null) {
			// Display tree recursively
			displayTree(list.getFirstNode(), getWidth() / 100 + 25, vGap, getWidth() / 10);
		}
	}
	/** Display a subtree rooted at position (x, y) */
	private void displayTree(MyLinkedList.Node<Integer> root, double x, double y,double hGap) {
		if (root.next != null) {
			// Draw a line to the left node
			getChildren().add(new Line(x + hGap, y, x, y));
			// Draw the left subtree recursively
			displayTree(root.next, x + hGap, y, hGap);
		}
		// Display a node
		Circle circle = new Circle(x, y, radius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		getChildren().addAll(circle, new Text(x - 4, y + 4, root.element + ""));
	}
}