package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

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

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LabeledStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.LabeledStatement;
	}

	public SimpleName getLabel() {
		return wGet(JavaFeatureDescriptorEnum.label).wGetAdapter(
				JavaEntityDescriptorEnum.SimpleName);
	}

	public void setLabel(SimpleName label) {
		wSet(JavaFeatureDescriptorEnum.label, label);
	}

	public Statement getBody() {
		return wGet(JavaFeatureDescriptorEnum.body).wGetAdapter(
				JavaEntityDescriptorEnum.Statement);
	}

	public void setBody(Statement body) {
		wSet(JavaFeatureDescriptorEnum.body, body);
	}
}
