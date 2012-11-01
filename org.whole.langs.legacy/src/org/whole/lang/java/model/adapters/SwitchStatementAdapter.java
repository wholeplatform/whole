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
public class SwitchStatementAdapter extends AbstractEntityAdapter implements
		SwitchStatement {
	private static final long serialVersionUID = 1;

	public SwitchStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public SwitchStatementAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SwitchStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.SwitchStatement;
	}

	public Expression getExpression() {
		return wGet(JavaFeatureDescriptorEnum.expression).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(JavaFeatureDescriptorEnum.expression, expression);
	}

	public Statements getStatements() {
		return wGet(JavaFeatureDescriptorEnum.statements).wGetAdapter(
				JavaEntityDescriptorEnum.Statements);
	}

	public void setStatements(Statements statements) {
		wSet(JavaFeatureDescriptorEnum.statements, statements);
	}
}
