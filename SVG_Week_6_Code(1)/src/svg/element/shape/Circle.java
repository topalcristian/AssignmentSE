package svg.element.shape;

import svg.SVGParser;
import svg.element.Element;

//-----------------------------------------------------------------------------

/**
 * SVG circle shape.
 * @author cambolbro
 */
public class Circle extends Shape
{
	// Format: <circle cx="50" cy="50" r="25" />	

	private double cx = 0;
	private double cy = 0;
	private double r = 0;

	//-------------------------------------------------------------------------
	
	public Circle()
	{
		super("circle");
	}
	
	//-------------------------------------------------------------------------

	public double cx()
	{
		return cx;
	}

	public double cy()
	{
		return cy;
	}

	public double r()
	{
		return r;
	}
	
	//-------------------------------------------------------------------------

	@Override
	public Element newInstance()
	{
		return new Circle();
	}
	
	//-------------------------------------------------------------------------

	@Override
	public void setBounds()
	{
		final double x = cx - r;
		final double y = cy - r;
		final double width  = 2 * r;
		final double height = 2 * r;
		
		bounds.setRect(x, y, width, height);
	}
	
	//-------------------------------------------------------------------------

	@Override
	public boolean load(final String expr)
	{
		boolean okay = true;
	
		if (!super.load(expr))
			return false;

		if (expr.contains(" cx="))
		{
			final Double result = SVGParser.extractDouble(expr, " cx=");
			if (result == null)
				return false;
			cx = result.doubleValue();
		}

		if (expr.contains(" cy="))
		{
			final Double result = SVGParser.extractDouble(expr, " cy=");
			if (result == null)
				return false;
			cy = result.doubleValue();
		}

		if (expr.contains(" r="))
		{
			final Double result = SVGParser.extractDouble(expr, " r=");
			if (result == null)
				return false;
			r = result.doubleValue();
		}
		
		return okay;
	}
	
	//-------------------------------------------------------------------------

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder();
		
		sb.append(label() + ": cx=" + cx + ", cy=" + cy + ", r=" + r);
		
		return sb.toString();

	}
	
	//-------------------------------------------------------------------------

	@Override
	public void render()
	{
		// ...
	}

	//-------------------------------------------------------------------------

}
