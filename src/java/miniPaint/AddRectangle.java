package miniPaint;

import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

import java.util.HashMap;
import java.util.Map;

public class AddRectangle extends AddShape {
    private Label widthLabel;
    private Label heightLabel;

    private Spinner<Integer> widthSpinner;
    private Spinner<Integer> heightSpinner;

    @Override
    void initializeSpecificElements() {
        widthLabel = new Label("Width");
        heightLabel = new Label("Height");
        widthLabel.getStyleClass().add("add-label");
        heightLabel.getStyleClass().add("add-label");
        widthSpinner = setSpinner();
        heightSpinner = setSpinner();
    }

    @Override
    void addSpecificElementsToLayout() {
        getGrid().add(widthLabel, 0, 4);
        getGrid().add(widthSpinner, 1, 4);
        getGrid().add(heightLabel, 0, 5);
        getGrid().add(heightSpinner, 1, 5);
    }

    @Override
    void drawButtonHandler() {
        Map<String, Double> properties = new HashMap<>();
        double width = widthSpinner.getValue();
        double height = heightSpinner.getValue();
        double positionX = getPositionXSpinner().getValue();
        double positionY = getPositionYSpinner().getValue();
        properties.put("width", width);
        properties.put("height", height);
        properties.put("positionX", positionX);
        properties.put("positionY", positionY);
        Point2D point2D = new Point2D(getPositionXSpinner().getValue(), getPositionYSpinner().getValue());
        DrawingEngineImplementation engine = new DrawingEngineImplementation();
        Rectangle rectangle = new Rectangle(point2D, properties, getStrokeColorPicker().getValue(), getFillColorPicker().getValue(), widthSpinner.getValue(), heightSpinner.getValue());
        engine.addShape(rectangle);
        getStage().close();
    }

    @Override
    void setStageTitle() {
        getStage().setTitle("Add Rectangle");
    }
}


