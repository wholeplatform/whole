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
public class LabeledStatementAdapter extends AbstractEntityAdapter implements
		LabeledStatement {
	private static final long serialVersionUID = 1;

	public LabeledStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public LabeledStatementAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LabeledStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.LabeledStatement;
	}

	public Labels getLabels() {
		return wGet(JavaScriptFeatureDescriptorEnum.labels).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Labels);
	}

	public void setLabels(Labels labels) {
		wSet(JavaScriptFeatureDescriptorEnum.labels, labels);
	}

	public Statement getBody() {
		return wGet(JavaScriptFeatureDescriptorEnum.body).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Statement);
	}

	public void setBody(Statement body) {
		wSet(JavaScriptFeatureDescriptorEnum.body, body);
	}
}
