package org.whole.lang.environment.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.environment.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.model.Void;

/** 
 * @generator Whole
 */
public class EnvironmentForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements IEnvironmentVisitor {
	public EnvironmentForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BooleanData entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ByteData entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CharData entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DoubleData entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FloatData entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IntData entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LongData entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ShortData entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StringData entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DateData entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ObjectData entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Tuple entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ContainmentTuple entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Void entity) {
		wGetVisitor1().visit(entity);
	}
}
