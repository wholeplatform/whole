package org.whole.lang.testevents.model;

/** 
 * @generator Whole
 */
public interface Rectangle extends ITestEventsEntity, Shape {
	public Val getBase();

	public void setBase(Val base);

	public Val getHeight();

	public void setHeight(Val height);

	public Val getArea();

	public void setArea(Val area);

	public Val getPerimeter();

	public void setPerimeter(Val perimeter);
}
