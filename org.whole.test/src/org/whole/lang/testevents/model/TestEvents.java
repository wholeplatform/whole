package org.whole.lang.testevents.model;

/** 
 * @generator Whole
 */
public interface TestEvents extends ITestEventsEntity {
	public Val getMaxBase();

	public void setMaxBase(Val maxBase);

	public Val getMaxHeight();

	public void setMaxHeight(Val maxHeight);

	public Val getNumShapes();

	public void setNumShapes(Val numShapes);

	public Shape getShape();

	public void setShape(Shape shape);
}
