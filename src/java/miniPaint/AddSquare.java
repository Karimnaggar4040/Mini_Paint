package miniPaint;


import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

import java.util.HashMap;
import java.util.Map;

public class AddSquare extends AddShape {
    private Label widthAndHeightLabel;
    private Spinner<Integer> widthAndHeightSpinner;

    @Override
    void initializeSpecificElements() {
        widthAndHeightLabel = new Label("Width and Height");
        widthAndHeightLabel.getStyleClass().add("add-label");
        widthAndHeightSpinner = setSpinner();
    }

    @Override
    void addSpecificElementsToLayout() {
        getGrid().add(widthAndHeightLabel, 0, 4);
        getGrid().add(widthAndHeightSpinner, 1, 4);
    }

    @Override
    void drawButtonHandler() {
        double widthAndHeight = widthAndHeightSpinner.getValue();
        double positionX = getPositionXSpinner().getValue();
        double positionY = getPositionYSpinner().getValue();
        Map<String, Double> properties = new HashMap<>();
        properties.put("widthAndHeight", widthAndHeight);
        properties.put("positionX", positionX);
        properties.put("positionY", positionY);
        Point2D point2D = new Point2D(getPositionXSpinner().getValue(), getPositionYSpinner().getValue());
        DrawingEngineImplementation engine = new DrawingEngineImplementation();
        Square square = new Square(point2D, properties, getStrokeColorPicker().getValue(), getFillColorPicker().getValue(), widthAndHeightSpinner.getValue(),widthAndHeightSpinner.getValue());
        engine.addShape(square);
        getStage().close();
    }

    @Override
    void setStageTitle() {
        getStage().setTitle("Add Square");
    }
}
