package miniPaint;

import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

import java.util.HashMap;
import java.util.Map;

public class AddLineSegment extends AddShape{

    private Label lengthLabel;
    private Spinner<Integer> lengthSpinner;


    @Override
    void initializeSpecificElements() {
        lengthLabel = new Label("Length");
        lengthLabel.getStyleClass().add("add-label");
        lengthSpinner = setSpinner();
    }

    @Override
    void addSpecificElementsToLayout() {
        getGrid().add(lengthLabel, 0, 4);
        getGrid().add(lengthSpinner, 1, 4);
    }

    @Override
    void drawButtonHandler() {
        double length = lengthSpinner.getValue();
        double positionX = getPositionXSpinner().getValue();
        double positionY = getPositionYSpinner().getValue();
        Map<String, Double> properties = new HashMap<>();
        properties.put("length", length);
        properties.put("positionX", positionX);
        properties.put("positionY", positionY);
        Point2D point2D = new Point2D(getPositionXSpinner().getValue(), getPositionYSpinner().getValue());
        LineSegment line = new LineSegment(point2D, properties, getStrokeColorPicker().getValue(), getFillColorPicker().getValue(), lengthSpinner.getValue());
        DrawingEngineImplementation engine = new DrawingEngineImplementation();
        engine.addShape(line);
        getStage().close();
    }

    @Override
    void setStageTitle() {
        getStage().setTitle("Add Line Segment");
    }
}


