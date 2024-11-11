package miniPaint;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Map;

public class Circle extends GeometricShape {
    private double radius;

    public Circle(Point2D position, Map<String, Double> properties, Color color, Color fillColor,double radius) {
        super(position, properties, color, fillColor);
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.setStroke(getColor());
        gc.fillOval(getPosition().getX(), MiniPaint.getCanvas().getHeight() - getPosition().getY(), radius*2, radius*2);
        gc.strokeOval(getPosition().getX(), MiniPaint.getCanvas().getHeight() - getPosition().getY(), radius*2, radius*2);
    }

}
