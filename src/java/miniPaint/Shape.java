package miniPaint;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Map;

public interface Shape {
    // Set Position
    void setPosition(Point2D position);
    Point2D getPosition();

    //Update shape specifications properties
    void setProperties(Map<String,Double> properties);
    Map<String,Double> getProperties();

    // Colorize
    void setColor(Color color);
    Color getColor();
    void setFillColor(Color color);
    Color getFillColor();

    // redraw the shape on the canvas
    void draw(GraphicsContext canvas);

    // For naming them
    void setName(String name);
    String getName();
}
