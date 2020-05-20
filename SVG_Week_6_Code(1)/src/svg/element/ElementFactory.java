package svg.element;

import java.util.ArrayList;
import java.util.List;

import svg.element.shape.Circle;
import svg.element.shape.Ellipse;
import svg.element.shape.Line;
import svg.element.shape.Polygon;
import svg.element.shape.Polyline;
import svg.element.shape.Rect;
import svg.element.shape.path.Path;
import svg.element.text.Text;

//-----------------------------------------------------------------------------

/**
 * Singleton class that holds a factory method for creating new SVG elements. 
 * @author cambolbro
 */
public class ElementFactory
{
	// List of concrete classes to be instantiated
	private final static List<Element> prototypes = new ArrayList<Element>();
	{
		// Shape prototypes
		prototypes.add(new Circle());
		prototypes.add(new Ellipse());
		prototypes.add(new Line());
		prototypes.add(new Polygon());
		prototypes.add(new Polyline());
		prototypes.add(new Rect());
		prototypes.add(new Path());
		
		// Text prototype
		prototypes.add(new Text());
	}
	
	// Singleton occurrence of this class
	private static ElementFactory singleton = null;
	
	//-------------------------------------------------------------------------

	/**
	 * Private constructor: only this class can construct itself.
	 */
	private ElementFactory() 
	{
		// Nothing to do...
	}
	
	//-------------------------------------------------------------------------

	public static ElementFactory get()
	{
		if (singleton == null)
			singleton = new ElementFactory();  // lazy initialisation
		return singleton;
	}
	
	public List<Element> prototypes()
	{
		return prototypes;
	}
	
	//-------------------------------------------------------------------------

	/**
	 * @param label Element type to make.
	 * @return New element of specified type, with fields unset.
	 */
	public Element makeElement(final String label)
	{
		for (Element prototype : prototypes)
			if (prototype.label().equals(label))
				return prototype.newInstance();  // return an unset clone
		
		System.out.println("* Failed to find prototype for Element " + label + ".");
		return null;
	}
	
	//-------------------------------------------------------------------------

}
