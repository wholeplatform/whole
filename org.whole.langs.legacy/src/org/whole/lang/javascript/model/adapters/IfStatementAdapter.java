package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class IfStatementAdapter extends AbstractEntityAdapter implements
		IfStatement {
	private static final long serialVersionUID = 1;

	public IfStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public IfStatementAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IfStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.IfStatement;
	}

	public Expression getTest() {
		return wGet(JavaScriptFeatureDescriptorEnum.test).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setTest(Expression test) {
		wSet(JavaScriptFeatureDescriptorEnum.test, test);
	}

	public Statement getConsequent() {
		return wGet(JavaScriptFeatureDescriptorEnum.consequent).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Statement);
	}

	public void setConsequent(Statement consequent) {
		wSet(JavaScriptFeatureDescriptorEnum.consequent, consequent);
	}

	public Statement getAlternate() {
		return wGet(JavaScriptFeatureDescriptorEnum.alternate).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Statement);
	}

	public void setAlternate(Statement alternate) {
		wSet(JavaScriptFeatureDescriptorEnum.alternate, alternate);
	}
}
