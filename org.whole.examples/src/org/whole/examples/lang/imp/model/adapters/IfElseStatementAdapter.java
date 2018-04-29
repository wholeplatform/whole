package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class IfElseStatementAdapter extends AbstractEntityAdapter implements IfElseStatement {
	private static final long serialVersionUID = 1;

	public IfElseStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public IfElseStatementAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IfElseStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.IfElseStatement;
	}

	public Expression getCondition() {
		return wGet(ImpFeatureDescriptorEnum.condition).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setCondition(Expression condition) {
		wSet(ImpFeatureDescriptorEnum.condition, condition);
	}

	public Statement getTrueBody() {
		return wGet(ImpFeatureDescriptorEnum.trueBody).wGetAdapter(ImpEntityDescriptorEnum.Statement);
	}

	public void setTrueBody(Statement trueBody) {
		wSet(ImpFeatureDescriptorEnum.trueBody, trueBody);
	}

	public Statement getFalseBody() {
		return wGet(ImpFeatureDescriptorEnum.falseBody).wGetAdapter(ImpEntityDescriptorEnum.Statement);
	}

	public void setFalseBody(Statement falseBody) {
		wSet(ImpFeatureDescriptorEnum.falseBody, falseBody);
	}
}
