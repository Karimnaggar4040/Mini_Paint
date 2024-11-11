package miniPaint;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Map;

public class Rectangle extends GeometricShape {
    private double width;
    private double height;
    public Rectangle(Point2D position, Map<String, Double> properties, Color color, Color fillColor, double width, double height) {
        super(position, properties, color, fillColor);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.setStroke(getColor());
        gc.fillRect(getPosition().getX(),MiniPaint.getCanvas().getHeight() - getPosition().getY(), width, height);
        gc.strokeRect(getPosition().getX(), MiniPaint.getCanvas().getHeight() - getPosition().getY(), width, height);
    }
}
