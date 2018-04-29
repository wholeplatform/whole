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
public class DoWhileStatementAdapter extends AbstractEntityAdapter implements DoWhileStatement {
	private static final long serialVersionUID = 1;

	public DoWhileStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public DoWhileStatementAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DoWhileStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.DoWhileStatement;
	}

	public Statement getTrueBody() {
		return wGet(ImpFeatureDescriptorEnum.trueBody).wGetAdapter(ImpEntityDescriptorEnum.Statement);
	}

	public void setTrueBody(Statement trueBody) {
		wSet(ImpFeatureDescriptorEnum.trueBody, trueBody);
	}

	public Expression getCondition() {
		return wGet(ImpFeatureDescriptorEnum.condition).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setCondition(Expression condition) {
		wSet(ImpFeatureDescriptorEnum.condition, condition);
	}
}
