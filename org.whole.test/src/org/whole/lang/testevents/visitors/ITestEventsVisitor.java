package org.whole.lang.testevents.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.testevents.model.*;

/** 
 * @generator Whole
 */
public interface ITestEventsVisitor extends IVisitor {
	public void visit(TestEvents entity);

	public void visit(CompositeShape entity);

	public void visit(Rectangle entity);

	public void visit(Labels entity);

	public void visit(Val entity);

	public void visit(Label entity);
}
