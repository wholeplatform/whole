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
public class VariableDeclarationAdapter extends AbstractEntityAdapter implements VariableDeclaration {
	private static final long serialVersionUID = 1;

	public VariableDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableDeclarationAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableDeclaration> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.VariableDeclaration;
	}

	public Name getName() {
		return wGet(SQLFeatureDescriptorEnum.name).wGetAdapter(SQLEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(SQLFeatureDescriptorEnum.name, name);
	}

	public Reference getReference() {
		return wGet(SQLFeatureDescriptorEnum.reference).wGetAdapter(SQLEntityDescriptorEnum.Reference);
	}

	public void setReference(Reference reference) {
		wSet(SQLFeatureDescriptorEnum.reference, reference);
	}

	public ReferenceType getReferenceType() {
		return wGet(SQLFeatureDescriptorEnum.referenceType).wGetAdapter(SQLEntityDescriptorEnum.ReferenceType);
	}

	public void setReferenceType(ReferenceType referenceType) {
		wSet(SQLFeatureDescriptorEnum.referenceType, referenceType);
	}
}
