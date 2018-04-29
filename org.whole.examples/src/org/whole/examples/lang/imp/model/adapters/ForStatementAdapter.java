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
public class ForStatementAdapter extends AbstractEntityAdapter implements ForStatement {
	private static final long serialVersionUID = 1;

	public ForStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public ForStatementAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ForStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.ForStatement;
	}

	public VariableDeclaration getInitializer() {
		return wGet(ImpFeatureDescriptorEnum.initializer).wGetAdapter(ImpEntityDescriptorEnum.VariableDeclaration);
	}

	public void setInitializer(VariableDeclaration initializer) {
		wSet(ImpFeatureDescriptorEnum.initializer, initializer);
	}

	public Expression getCondition() {
		return wGet(ImpFeatureDescriptorEnum.condition).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setCondition(Expression condition) {
		wSet(ImpFeatureDescriptorEnum.condition, condition);
	}

	public Expression getUpdater() {
		return wGet(ImpFeatureDescriptorEnum.updater).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setUpdater(Expression updater) {
		wSet(ImpFeatureDescriptorEnum.updater, updater);
	}

	public Statement getTrueBody() {
		return wGet(ImpFeatureDescriptorEnum.trueBody).wGetAdapter(ImpEntityDescriptorEnum.Statement);
	}

	public void setTrueBody(Statement trueBody) {
		wSet(ImpFeatureDescriptorEnum.trueBody, trueBody);
	}
}
