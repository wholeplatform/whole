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
public class CatchClauseAdapter extends AbstractEntityAdapter implements
		CatchClause {
	private static final long serialVersionUID = 1;

	public CatchClauseAdapter(IEntity implementor) {
		super(implementor);
	}

	public CatchClauseAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CatchClause> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.CatchClause;
	}

	public SingleVariableDeclaration getException() {
		return wGet(JavaFeatureDescriptorEnum.exception).wGetAdapter(
				JavaEntityDescriptorEnum.SingleVariableDeclaration);
	}

	public void setException(SingleVariableDeclaration exception) {
		wSet(JavaFeatureDescriptorEnum.exception, exception);
	}

	public Block getBody() {
		return wGet(JavaFeatureDescriptorEnum.body).wGetAdapter(
				JavaEntityDescriptorEnum.Block);
	}

	public void setBody(Block body) {
		wSet(JavaFeatureDescriptorEnum.body, body);
	}
}
