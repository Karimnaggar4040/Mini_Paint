package miniPaint;

import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

import java.util.HashMap;
import java.util.Map;

public class AddCircle extends AddShape {
    private Label radiusLabel;
    private Spinner<Integer> radiusSpinner;

    @Override
    void initializeSpecificElements() {
        radiusLabel = new Label("Radius");
        radiusLabel.getStyleClass().add("add-label");
        radiusSpinner = setSpinner();
        radiusSpinner.getStyleClass().add("add-spinner");
    }

    @Override
    void addSpecificElementsToLayout() {
        getGrid().add(radiusLabel, 0, 4);
        getGrid().add(radiusSpinner, 1, 4);
    }

    @Override
    void drawButtonHandler() {
        double radius = radiusSpinner.getValue();
        double positionX = getPositionXSpinner().getValue();
        double positionY = getPositionYSpinner().getValue();
        Map<String,Double> properties = new HashMap<>();
        properties.put("radius", radius);
        properties.put("positionX", positionX);
        properties.put("positionY", positionY);
        Point2D point2D = new Point2D(getPositionXSpinner().getValue(), getPositionYSpinner().getValue());
        Circle circle = new Circle(point2D,properties,getStrokeColorPicker().getValue(),getFillColorPicker().getValue(),radiusSpinner.getValue());
        DrawingEngineImplementation engine = new DrawingEngineImplementation();
        engine.addShape(circle);
        getStage().close();
    }

    @Override
    void setStageTitle() {
        getStage().setTitle("Add Circle");
    }
}
