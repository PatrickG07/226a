package ch.P2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/** @Autor Patrick Gartenmann
* @Version 4.4
*/
public class Minesweeper extends Application {
	private static final int TILE_SIZE = 40;
	private static final int W = 800;
	private static final int H = 600;
	private static final int X_TILES = W / TILE_SIZE;
	private static final int Y_TILES = H / TILE_SIZE;
	private Tile[][] grid = new Tile[X_TILES][Y_TILES];
	private Scene scene;
	/** @Autor Patrick Gartenmann
	*
	* Creates the content with height and width
	*/
	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(W, H);
		for (int y = 0; y < Y_TILES; y++) {
			for (int x = 0; x < X_TILES; x++) {
				Tile tile = new Tile(x, y, Math.random() < 0.2);
				grid[x][y] = tile;
				root.getChildren().add(tile);
			}
		}
		for (int y = 0; y < Y_TILES; y++) {
			for (int x = 0; x < X_TILES; x++) {
				Tile tile = grid[x][y];
				if (tile.hasBomb)
					continue;
				long bombs = getNeighbors(tile).stream().filter(t -> t.hasBomb).count();
				if (bombs > 0)
					tile.text.setText(String.valueOf(bombs));
			}
		}
		return root;
	}
	/** @Autor Patrick Gartenmann
	*
	* checks if a around button are empty or contains something
	*/
	private List<Tile> getNeighbors(Tile tile) {
		List<Tile> neighbors = new ArrayList<>();
		// ttt
		// tXt
		// ttt
		int[] points = new int[] { -1, -1, -1, 0, -1, 1, 0, -1, 0, 1, 1, -1, 1, 0, 1, 1 };
		for (int i = 0; i < points.length; i++) {
			int dx = points[i];
			int dy = points[++i];
			int newX = tile.x + dx;
			int newY = tile.y + dy;
			if (newX >= 0 && newX < X_TILES && newY >= 0 && newY < Y_TILES) {
				neighbors.add(grid[newX][newY]);
			}
		}
		return neighbors;
	}
	/** @Autor Patrick Gartenmann
	*
	* creates the visual show
	* 
	* checks what is on the button
	*/
	private class Tile extends StackPane {
		private int x, y;
		private boolean hasBomb;
		private boolean isOpen = false;
		private Rectangle border = new Rectangle(TILE_SIZE - 2, TILE_SIZE - 2);
		private Text text = new Text();
		public Tile(int x, int y, boolean hasBomb) {
			this.x = x;
			this.y = y;
			this.hasBomb = hasBomb;
			border.setStroke(Color.LIGHTGRAY);
			text.setFont(Font.font(18));
			text.setText(hasBomb ? "X" : "");
			text.setVisible(false);
//			text.setVisible(true);
//			border.setFill(null);
			border.setFill(Color.GRAY);
			getChildren().addAll(border, text);
			setTranslateX(x * TILE_SIZE);
			setTranslateY(y * TILE_SIZE);
			setOnMouseClicked(e -> open());
		}
		public void open() {
			if (isOpen)
				return;
			if (hasBomb) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Restart");
				alert.setHeaderText("Do you want to Restart?");
				alert.setContentText("Choose your option.");

				ButtonType buttonTypeOne = new ButtonType("YES");
				ButtonType buttonTypeTwo = new ButtonType("NO");

				alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == buttonTypeOne){
				    scene.setRoot(createContent());
				    return;
				} else if (result.get() == buttonTypeTwo) {
					System.exit(0);
				}
			}
			isOpen = true;
			text.setVisible(true);
			border.setFill(null);
			if (text.getText().isEmpty()) {
				getNeighbors(this).forEach(Tile::open);
			}
		}
	}
	/** @Autor Patrick Gartenmann
	 * restarts the project
	 */
	@Override
	public void start(Stage stage) throws Exception {
		scene = new Scene(createContent());

		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}