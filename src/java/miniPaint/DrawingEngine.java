package miniPaint;

import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;

public interface DrawingEngine {
    // Manage shapes objects
    void addShape(Shape shape);
    void removeShape(Shape shape);

    // return the created shape objects
    ObservableList<Shape> getShapes();

    // redraw all the shapes on the canvas
    void refresh (GraphicsContext canvas);
}
