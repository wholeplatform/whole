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
public class SwitchCaseAdapter extends AbstractEntityAdapter implements
		SwitchCase {
	private static final long serialVersionUID = 1;

	public SwitchCaseAdapter(IEntity implementor) {
		super(implementor);
	}

	public SwitchCaseAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SwitchCase> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.SwitchCase;
	}

	public Expression getTest() {
		return wGet(JavaScriptFeatureDescriptorEnum.test).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setTest(Expression test) {
		wSet(JavaScriptFeatureDescriptorEnum.test, test);
	}

	public Statements getStatements() {
		return wGet(JavaScriptFeatureDescriptorEnum.statements).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Statements);
	}

	public void setStatements(Statements statements) {
		wSet(JavaScriptFeatureDescriptorEnum.statements, statements);
	}
}
