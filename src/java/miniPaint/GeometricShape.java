package miniPaint;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.util.Map;

public abstract class GeometricShape implements Shape {
    private Point2D position;
    private Map<String,Double> properties;
    private Color color;
    private Color fillColor;
    private String name;

    public GeometricShape(Point2D position, Map<String, Double> properties, Color color, Color fillColor) {
        this.position = position;
        this.properties = properties;
        this.color = color;
        this.fillColor = fillColor;
    }

    @Override
    public void setPosition(Point2D position) {
        this.position = position;
    }

    @Override
    public Point2D getPosition() {
        return this.position;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        this.properties = properties;
    }

    @Override
    public Map<String, Double> getProperties() {
        return this.properties;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
