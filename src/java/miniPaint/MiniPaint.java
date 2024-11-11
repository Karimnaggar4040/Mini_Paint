package miniPaint;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.util.Objects;

public class MiniPaint extends Application {

    private final DrawingEngineImplementation engine = new DrawingEngineImplementation();
    private final AddCircle addCircle = new AddCircle();
    private final AddLineSegment addLineSegment = new AddLineSegment();
    private final AddRectangle addRectangle = new AddRectangle();
    private final AddSquare addSquare = new AddSquare();

    public static Canvas getCanvas() {
        return canvas;
    }

    private static Canvas canvas;

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10, 10, 10, 10));

        // Create the canvas and add it in the container
        canvas = new Canvas(500, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Pane canvasContainer = new Pane();
        canvasContainer.setMaxSize(canvas.getWidth(), canvas.getHeight());
        canvasContainer.setMinSize(canvas.getWidth(), canvas.getHeight());
        canvasContainer.getChildren().add(canvas);
        canvasContainer.setStyle("-fx-background-color: #e0e0e0;");

        // Container to contain the canvas's container
        VBox vbox = new VBox();
        vbox.getChildren().add(canvasContainer);
        vbox.setPadding(new Insets(10, 10, 10, 55));

        // Container to contain the shapes buttons
        HBox hbox = new HBox();
        hbox.setSpacing(40);
        hbox.setPadding(new Insets(10, 10, 10, 240));

        // New Vbox to store the elements of the left border of the page
        VBox vboxLeft = new VBox();
        vboxLeft.setSpacing(9);
        ComboBox<Shape> shapeComboBox = new ComboBox<>(engine.getShapes()); // Because it is now an Observable list, this way the comboBox and the ObservableList are now combined
        shapeComboBox.setMinWidth(100);
        shapeComboBox.setMaxWidth(100);

        shapeComboBox.setPromptText("Shape");
        MiniPaint.namingConvertor(shapeComboBox);

        vboxLeft.setPadding(new Insets(100, 0, 0, 10));
        root.setLeft(vboxLeft);
        Label selectShapeLabel = new Label("Select Shape");
        selectShapeLabel.getStyleClass().add("selectShapeLabel");
        //Shape selectedShape = shapeComboBox.getSelectionModel().getSelectedItem(); // The shape the user chose
        vboxLeft.getChildren().add(selectShapeLabel);
        vboxLeft.getChildren().add(shapeComboBox);

        // Shapes Buttons
        Button circleButton = new Button("Circle");
        hbox.getChildren().add(circleButton);
        Button squareButton = new Button("Square");
        hbox.getChildren().add(squareButton);
        Button rectangleButton = new Button("Rectangle");
        hbox.getChildren().add(rectangleButton);
        Button lineSegmentButton = new Button("Line Segment");
        hbox.getChildren().add(lineSegmentButton);
        root.setTop(hbox);
        root.setCenter(vbox);

        // Add shapes Buttons Actions
        circleButton.setOnAction(e -> {
            addCircle.display();
            engine.refresh(gc);
        });
        squareButton.setOnAction(e -> {
            addSquare.display();
            engine.refresh(gc);
        });
        rectangleButton.setOnAction(e -> {
            addRectangle.display();
            engine.refresh(gc);
        });
        lineSegmentButton.setOnAction(e -> {
            addLineSegment.display();
            engine.refresh(gc);
        });


        // Colorize and delete buttons
        HBox shapeButtonsLayout = new HBox();
        shapeButtonsLayout.setSpacing(18);
        Button colorizeButton = new Button("Colorize");
        shapeButtonsLayout.getChildren().add(colorizeButton);
        Button deleteButton = new Button("Delete");
        shapeButtonsLayout.getChildren().add(deleteButton);
        vboxLeft.getChildren().add(shapeButtonsLayout);

        // Colorize and delete buttons actions
        colorizeButton.setOnAction(e -> {
            Shape selectedShape = shapeComboBox.getSelectionModel().getSelectedItem();
            Colorize.colorize(selectedShape);
            engine.refresh(gc);
        });

        deleteButton.setOnAction(e -> {
            Shape selectedShape = shapeComboBox.getSelectionModel().getSelectedItem();
            engine.removeShape(selectedShape);
            engine.refresh(gc);
        });
        // Add Icon for the stage
        Image logo = new Image(String.valueOf(getClass().getResource("brush.png")));
        stage.getIcons().add(logo);
        // Scene and show stage
        stage.setResizable(false);
        Scene scene = new Scene(root, 720, 350);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.setTitle("MiniPaint");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static HBox buttonsLayout() {
        HBox hbox = new HBox();
        hbox.setSpacing(25);
        hbox.setPadding(new Insets(10, 10, 10, 40));
        return hbox;
    }

    private static ComboBox<Shape> shapeComboBox() {
        ComboBox<Shape> shapeComboBox = new ComboBox<>();
        shapeComboBox.setPromptText("Shape");
        return shapeComboBox;
    }

    private static void namingConvertor(ComboBox<Shape> shapeComboBox) {
        shapeComboBox.setConverter(new StringConverter<Shape>() {
            @Override
            public String toString(Shape shape) {
                return shape.getName(); // This should return the name of the shape as a string
            }

            @Override
            public Shape fromString(String s) {
                return null;
            }
        }); // Naming the shapes
    }

}