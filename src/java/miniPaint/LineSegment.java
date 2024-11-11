package miniPaint;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Map;

public class LineSegment extends GeometricShape {
    private double length;
    public LineSegment(Point2D position, Map<String, Double> properties, Color color, Color fillColor, double length) {
        super(position, properties, color, fillColor);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(getColor());
        gc.strokeLine(getPosition().getX(),MiniPaint.getCanvas().getHeight() - getPosition().getY(), getPosition().getX()+length, MiniPaint.getCanvas().getHeight() - getPosition().getY());
    }
}
