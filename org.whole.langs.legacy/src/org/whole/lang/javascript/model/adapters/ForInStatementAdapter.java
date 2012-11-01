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
public class ForInStatementAdapter extends AbstractEntityAdapter implements
		ForInStatement {
	private static final long serialVersionUID = 1;

	public ForInStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public ForInStatementAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ForInStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ForInStatement;
	}

	public VariableDeclarationOrExpression getIterator() {
		return wGet(JavaScriptFeatureDescriptorEnum.iterator).wGetAdapter(
				JavaScriptEntityDescriptorEnum.VariableDeclarationOrExpression);
	}

	public void setIterator(VariableDeclarationOrExpression iterator) {
		wSet(JavaScriptFeatureDescriptorEnum.iterator, iterator);
	}

	public Expression getIterated() {
		return wGet(JavaScriptFeatureDescriptorEnum.iterated).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setIterated(Expression iterated) {
		wSet(JavaScriptFeatureDescriptorEnum.iterated, iterated);
	}

	public Statement getBody() {
		return wGet(JavaScriptFeatureDescriptorEnum.body).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Statement);
	}

	public void setBody(Statement body) {
		wSet(JavaScriptFeatureDescriptorEnum.body, body);
	}
}
