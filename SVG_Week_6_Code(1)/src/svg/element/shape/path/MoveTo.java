package svg.element.shape.path;

import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import svg.SVGParser;

//-----------------------------------------------------------------------------

/**
 * SVG path move to operation.
 * @author cambolbro
 */
public class MoveTo extends PathOp
{
	// Format: 
	//   M 100 100	
    //   m 100 100
	
	private double x = 0;
	private double y = 0;

	//-------------------------------------------------------------------------
	
	public MoveTo()
	{
		super('M');
	}
	
	//-------------------------------------------------------------------------

	public double x()
	{
		return x;
	}

	public double y()
	{
		return y;
	}

	//-------------------------------------------------------------------------

	@Override
	public PathOp newInstance()
	{
		return new MoveTo();
	}
	
	//-------------------------------------------------------------------------

	@Override
	public Rectangle2D.Double bounds()
	{
		return new Rectangle2D.Double(x, y, 0, 0);
	}

	//-------------------------------------------------------------------------

	@Override
	public boolean load(final String expr)
	{
//		System.out.println("+ Loading " + label + ": " + expr + "...");
		
		// Is absolute if label is upper case
		label = expr.charAt(0); 
		absolute = (label == Character.toUpperCase(label));

		int c = 1;
		
		final Double resultX = SVGParser.extractDoubleAt(expr, c);
		if (resultX == null)
		{
			System.out.println("* Failed to read X from " + expr + ".");
			return false;
		}
		x = resultX.doubleValue();
			
		while (c < expr.length() && SVGParser.isNumeric(expr.charAt(c)))
			c++;
			
		while (c < expr.length() && !SVGParser.isNumeric(expr.charAt(c)))
			c++;
			
		final Double resultY = SVGParser.extractDoubleAt(expr, c);
		if (resultY == null)
		{
			System.out.println("* Failed to read Y from " + expr + ".");
			return false;
		}
		y = resultY.doubleValue();
		
		return true;
	}
	
	//-------------------------------------------------------------------------

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder();
		
		sb.append(label + ": x=" + x + ", y=" + y);
				
		return sb.toString();

	}
	
	//-------------------------------------------------------------------------

	@Override
	public void apply(final GeneralPath path)
	{
		path.moveTo(x, y);
	}
	
	//-------------------------------------------------------------------------

}
