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
public class ForeachStatementAdapter extends AbstractEntityAdapter implements ForeachStatement {
	private static final long serialVersionUID = 1;

	public ForeachStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public ForeachStatementAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ForeachStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.ForeachStatement;
	}

	public Name getName() {
		return wGet(ImpFeatureDescriptorEnum.name).wGetAdapter(ImpEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(ImpFeatureDescriptorEnum.name, name);
	}

	public Expression getArrayExp() {
		return wGet(ImpFeatureDescriptorEnum.arrayExp).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setArrayExp(Expression arrayExp) {
		wSet(ImpFeatureDescriptorEnum.arrayExp, arrayExp);
	}

	public Statement getTrueBody() {
		return wGet(ImpFeatureDescriptorEnum.trueBody).wGetAdapter(ImpEntityDescriptorEnum.Statement);
	}

	public void setTrueBody(Statement trueBody) {
		wSet(ImpFeatureDescriptorEnum.trueBody, trueBody);
	}
}
