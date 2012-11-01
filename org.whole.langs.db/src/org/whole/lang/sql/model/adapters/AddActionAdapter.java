package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class AddActionAdapter extends AbstractEntityAdapter implements
		AddAction {
	private static final long serialVersionUID = 1;

	public AddActionAdapter(IEntity implementor) {
		super(implementor);
	}

	public AddActionAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AddAction> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.AddAction;
	}

	public DeclarationOrConstraint getDeclarationOrConstraint() {
		return wGet(SQLFeatureDescriptorEnum.declarationOrConstraint)
				.wGetAdapter(SQLEntityDescriptorEnum.DeclarationOrConstraint);
	}

	public void setDeclarationOrConstraint(
			DeclarationOrConstraint declarationOrConstraint) {
		wSet(SQLFeatureDescriptorEnum.declarationOrConstraint,
				declarationOrConstraint);
	}
}
