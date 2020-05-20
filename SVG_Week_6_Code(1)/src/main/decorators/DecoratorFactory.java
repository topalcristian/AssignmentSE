package main.decorators;

import java.awt.Graphics2D;

import main.decorators.shapes.DecoratorGraphics2DCircle;
import main.decorators.shapes.DecoratorGraphics2DEllipse;
import main.decorators.shapes.DecoratorGraphics2DLine;
import main.decorators.shapes.DecoratorGraphics2DPath;
import main.decorators.shapes.DecoratorGraphics2DPolygon;
import main.decorators.shapes.DecoratorGraphics2DPolyline;
import main.decorators.shapes.DecoratorGraphics2DRect;

import svg.element.Element;
import svg.element.ElementFactory;
import svg.element.shape.Circle;
import svg.element.shape.Rect;
import svg.element.shape.Shape;
import svg.element.shape.Line;
import svg.element.shape.Ellipse;
import svg.element.shape.Polyline;
import svg.element.shape.Polygon;
import svg.element.shape.path.Path;

public class DecoratorFactory {

    // Singleton occurrence of this class
    private static DecoratorFactory singleton = null;

    /**
     * Private constructor: only this class can construct itself.
     */
    private DecoratorFactory() {

    }

    public static DecoratorFactory get() {
        if (singleton == null)
            singleton = new DecoratorFactory();
        return singleton;
    }

    public Decorator create(Shape shape,String label, Graphics2D g2dImage) {


        Decorator decorator = null;
        switch (label) {
            case "circle":
                decorator = new DecoratorGraphics2DCircle((Circle) shape, g2dImage);
                break;
            case "ellipse":
                decorator = new DecoratorGraphics2DEllipse((Ellipse) shape, g2dImage);
                break;
            case "line":
                decorator = new DecoratorGraphics2DLine((Line) shape, g2dImage);
                break;
            case "path":
                decorator = new DecoratorGraphics2DPath((Path) shape, g2dImage);
                break;
            case "polygon":
                decorator = new DecoratorGraphics2DPolygon((Polygon) shape, g2dImage);
                break;
            case "polyline":
                decorator = new DecoratorGraphics2DPolyline((Polyline) shape, g2dImage);
                break;
            case "rect":
                decorator = new DecoratorGraphics2DRect((Rect) shape, g2dImage);
                break;

        }
        return decorator;
    }
}