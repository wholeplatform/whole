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
public class TryStatementAdapter extends AbstractEntityAdapter implements
		TryStatement {
	private static final long serialVersionUID = 1;

	public TryStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public TryStatementAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TryStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.TryStatement;
	}

	public Block getBody() {
		return wGet(JavaFeatureDescriptorEnum.body).wGetAdapter(
				JavaEntityDescriptorEnum.Block);
	}

	public void setBody(Block body) {
		wSet(JavaFeatureDescriptorEnum.body, body);
	}

	public CatchClauses getCatchClauses() {
		return wGet(JavaFeatureDescriptorEnum.catchClauses).wGetAdapter(
				JavaEntityDescriptorEnum.CatchClauses);
	}

	public void setCatchClauses(CatchClauses catchClauses) {
		wSet(JavaFeatureDescriptorEnum.catchClauses, catchClauses);
	}

	public Block getFinally() {
		return wGet(JavaFeatureDescriptorEnum._finally).wGetAdapter(
				JavaEntityDescriptorEnum.Block);
	}

	public void setFinally(Block _finally) {
		wSet(JavaFeatureDescriptorEnum._finally, _finally);
	}
}
