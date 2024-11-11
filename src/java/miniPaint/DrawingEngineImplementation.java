package miniPaint;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;

public class DrawingEngineImplementation implements DrawingEngine {
    private static final ObservableList<Shape> shapes = FXCollections.observableArrayList();
    private static int circleNameCounter = 1;
    private static int rectangleNameCounter = 1;
    private static int squareNameCounter = 1;
    private static int lineSegmentNameCounter = 1;

    public DrawingEngineImplementation() {
    }

    @Override
    public void addShape(Shape shape) {
        if (shape instanceof Circle) {
            shape.setName("Circle" + circleNameCounter);
            circleNameCounter++;
            shapes.add(shape);
        }
        else if (shape instanceof Square) {
            shape.setName("Square" + squareNameCounter);
            squareNameCounter++;
            shapes.add(shape);}
        else if (shape instanceof Rectangle) {
            shape.setName("Rectangle" + rectangleNameCounter);
            rectangleNameCounter++;
            shapes.add(shape);
        }
        else if (shape instanceof LineSegment) {
            shape.setName("LineSegment" + lineSegmentNameCounter);
            lineSegmentNameCounter++;
            shapes.add(shape);
        }
    }

    @Override
    public void removeShape(Shape shape) {
        shapes.remove(shape); // TODO: Add validations if needed.
    }

    @Override
    public ObservableList<Shape> getShapes() {
        return shapes;
    }

    @Override
    public void refresh(GraphicsContext gc) {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        for (Shape shape : shapes) {
            shape.draw(gc);
        }
    }
}
