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
public class ForStatementAdapter extends AbstractEntityAdapter implements
		ForStatement {
	private static final long serialVersionUID = 1;

	public ForStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public ForStatementAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ForStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ForStatement;
	}

	public Expressions getInitializers() {
		return wGet(JavaFeatureDescriptorEnum.initializers).wGetAdapter(
				JavaEntityDescriptorEnum.Expressions);
	}

	public void setInitializers(Expressions initializers) {
		wSet(JavaFeatureDescriptorEnum.initializers, initializers);
	}

	public Expression getExpression() {
		return wGet(JavaFeatureDescriptorEnum.expression).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(JavaFeatureDescriptorEnum.expression, expression);
	}

	public Expressions getUpdaters() {
		return wGet(JavaFeatureDescriptorEnum.updaters).wGetAdapter(
				JavaEntityDescriptorEnum.Expressions);
	}

	public void setUpdaters(Expressions updaters) {
		wSet(JavaFeatureDescriptorEnum.updaters, updaters);
	}

	public Statement getBody() {
		return wGet(JavaFeatureDescriptorEnum.body).wGetAdapter(
				JavaEntityDescriptorEnum.Statement);
	}

	public void setBody(Statement body) {
		wSet(JavaFeatureDescriptorEnum.body, body);
	}
}
