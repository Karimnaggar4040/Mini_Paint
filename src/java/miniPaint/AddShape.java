package miniPaint;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public abstract class AddShape {
    private Stage stage;
    private GridPane grid;
    private HBox buttonsLayout;
    private VBox vbox;

    private Label positionXLabel;
    private Label positionYLabel;
    private Spinner<Integer> positionXSpinner;
    private Spinner<Integer> positionYSpinner;

    private Label strokeColorLabel;
    private Label fillColorLabel;
    private ColorPicker strokeColorPicker;
    private ColorPicker fillColorPicker;

    private Button drawButton;
    private Button backButton;


    // Methods
    public void stageAndLayoutOrganizer() {
        stage = new Stage();
        grid = new GridPane();
        buttonsLayout = buttonsLayout();
        vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(10);
        vbox.getChildren().addAll(grid, buttonsLayout);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);
    }


    // method to set and initialize the elements
    public void initializeElements() {
        positionXLabel = new Label("Position on X");
        positionYLabel = new Label("Position on Y");
        positionXLabel.getStyleClass().add("add-label");
        positionYLabel.getStyleClass().add("add-label");

        positionXSpinner = new Spinner<>();
        positionYSpinner = new Spinner<>();
        positionXSpinner.getStyleClass().add("add-spinner");
        positionYSpinner.getStyleClass().add("add-spinner");
        positionYSpinner.setEditable(true);
        positionXSpinner.setEditable(true);
        positionXSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, (int) MiniPaint.getCanvas().getWidth(), 0, 10));
        positionYSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, (int) MiniPaint.getCanvas().getHeight(), 0, 10));

        strokeColorLabel = new Label("Stroke Color");
        strokeColorLabel.getStyleClass().add("add-label");
        strokeColorPicker = new ColorPicker();
        strokeColorPicker.setValue(Color.BLACK);

        fillColorLabel = new Label("Fill Color");
        fillColorLabel.getStyleClass().add("add-label");
        fillColorPicker = new ColorPicker();
        fillColorPicker.setValue(Color.TRANSPARENT);

        setBackButton();
        setDrawButton();
    }

    // Method to add all the elements on the grid and add the buttons on its layout
    public void layoutsOrganizer() {
        grid.add(positionXLabel, 0, 0);
        grid.add(positionXSpinner, 1, 0);
        grid.add(positionYLabel, 0, 1);
        grid.add(positionYSpinner, 1, 1);
        grid.add(strokeColorLabel, 0, 2);
        grid.add(strokeColorPicker, 1, 2);
        grid.add(fillColorLabel, 0, 3);
        grid.add(fillColorPicker, 1, 3);

        buttonsLayout.getChildren().addAll(backButton, drawButton);
    }

    public HBox buttonsLayout() {
        HBox hbox = new HBox();
        hbox.setSpacing(25);
        hbox.setPadding(new Insets(10, 10, 10, 40));
        return hbox;
    }

    public void setDrawButton() {
        drawButton = new Button("Draw");
        drawButton.getStyleClass().add("add-button");
        drawButton.setOnAction(e -> drawButtonHandler());
    }

    public void setBackButton() {
        backButton = new Button("Back");
        backButton.getStyleClass().add("add-button");
        backButton.setOnAction(e -> stage.close());
    }

    public Spinner<Integer> setSpinner() {
        Spinner<Integer> spinner = new Spinner<>();
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 300, 0, 10));
        spinner.setEditable(true);
        spinner.getStyleClass().add("add-spinner");
        return spinner;
    }

    public void display() {
        // Load all the data and display
        stageAndLayoutOrganizer();
        Scene scene = new Scene(vbox);
        scene.getStylesheets().add(String.valueOf(AddRectangle.class.getResource("styles.css")));
        stage.setScene(scene);
        initializeElements();
        layoutsOrganizer();
        setStageTitle();
        initializeSpecificElements();
        addSpecificElementsToLayout();

        // Icon for Stages
        Image logo = new Image(String.valueOf(getClass().getResource("brush.png")));
        stage.getIcons().add(logo);

        stage.showAndWait();
    }

    abstract void initializeSpecificElements();

    abstract void addSpecificElementsToLayout();

    abstract void drawButtonHandler();

    abstract void setStageTitle();


    // Getters
    public Stage getStage() {
        return stage;
    }

    public GridPane getGrid() {
        return grid;
    }

    public Spinner<Integer> getPositionXSpinner() {
        return positionXSpinner;
    }

    public Spinner<Integer> getPositionYSpinner() {
        return positionYSpinner;
    }

    public ColorPicker getStrokeColorPicker() {
        return strokeColorPicker;
    }

    public ColorPicker getFillColorPicker() {
        return fillColorPicker;
    }


}
