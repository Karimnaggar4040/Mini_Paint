package miniPaint;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Colorize {
    public static void colorize(Shape shape) {
        Stage stage = new Stage();
        // Icon for Stages
        Image logo = new Image(String.valueOf(Colorize.class.getResource("brush.png")));
        stage.getIcons().add(logo);
        VBox vBox = new VBox();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // Labels and Color Pickers
        // Stroke Color
        Label strokeColorLabel = new Label("Stroke Color");
        ColorPicker strokeColorPicker = new ColorPicker();
        strokeColorPicker.setValue(Color.BLACK);

        // Fill Color
        Label fillColorLabel = new Label("Fill Color");
        ColorPicker fillColorPicker = new ColorPicker();
        fillColorPicker.setValue(Color.TRANSPARENT);

        Button drawButton = new Button("Draw");
        Button backButton = new Button("Back");
        drawButton.setOnAction(e -> {
            shape.setFillColor(fillColorPicker.getValue());
            shape.setColor(strokeColorPicker.getValue());
            stage.close();
        });
        backButton.setOnAction(e -> {
            stage.close();
        });

        grid.add(strokeColorLabel, 0, 0);
        grid.add(strokeColorPicker, 1, 0);
        grid.add(fillColorLabel, 0, 2);
        grid.add(fillColorPicker, 1, 2);
        HBox buttonsLayout = MiniPaint.buttonsLayout();
        buttonsLayout.getChildren().add(backButton);
        buttonsLayout.getChildren().add(drawButton);
        vBox.getChildren().addAll(grid, buttonsLayout);

        Scene scene = new Scene(vBox);
        scene.getStylesheets().add(String.valueOf(Colorize.class.getResource("styles.css")));
        stage.setScene(scene);
        stage.setTitle("Colorize");
        stage.showAndWait();
    }
}
