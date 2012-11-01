package org.whole.lang.environment.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.environment.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.model.Void;

/** 
 * @generator Whole
 */
public class EnvironmentForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IEnvironmentVisitor> implements
		IEnvironmentVisitor {
	public EnvironmentForwardStrategyVisitor() {
		this(new EnvironmentIdentityVisitor());
	}

	public EnvironmentForwardStrategyVisitor(
			IEnvironmentVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IEnvironmentEntity) entity).accept(this);
	}

	public void visit(BooleanData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ByteData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CharData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DoubleData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FloatData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IntData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LongData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ShortData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StringData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DateData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ObjectData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Tuple entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ContainmentTuple entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Void entity) {
		wGetStrategy().visit(entity);
	}
}
