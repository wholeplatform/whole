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
public class TryStatementAdapter extends AbstractEntityAdapter implements
		TryStatement {
	private static final long serialVersionUID = 1;

	public TryStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public TryStatementAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TryStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.TryStatement;
	}

	public Statements getTry() {
		return wGet(JavaScriptFeatureDescriptorEnum._try).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Statements);
	}

	public void setTry(Statements _try) {
		wSet(JavaScriptFeatureDescriptorEnum._try, _try);
	}

	public CatchClauses getHandlers() {
		return wGet(JavaScriptFeatureDescriptorEnum.handlers).wGetAdapter(
				JavaScriptEntityDescriptorEnum.CatchClauses);
	}

	public void setHandlers(CatchClauses handlers) {
		wSet(JavaScriptFeatureDescriptorEnum.handlers, handlers);
	}

	public Statements getFinally() {
		return wGet(JavaScriptFeatureDescriptorEnum._finally).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Statements);
	}

	public void setFinally(Statements _finally) {
		wSet(JavaScriptFeatureDescriptorEnum._finally, _finally);
	}
}
