package miniPaint;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.util.Map;

public class Square extends Rectangle {

    public Square(Point2D position, Map<String, Double> properties, Color color, Color fillColor, double width, double height) {
        super(position, properties, color, fillColor, width, height);
    }
}

