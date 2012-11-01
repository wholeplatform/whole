package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TypeDeclarationStatementImpl extends AbstractSimpleEntity
		implements TypeDeclarationStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TypeDeclarationStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.TypeDeclarationStatement;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.TypeDeclarationStatement_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private TypeDeclaration typeDeclaration;

	public TypeDeclaration getTypeDeclaration() {
		return notifyRequested(JavaFeatureDescriptorEnum.typeDeclaration,
				typeDeclaration);
	}

	public void setTypeDeclaration(TypeDeclaration typeDeclaration) {
		notifyChanged(JavaFeatureDescriptorEnum.typeDeclaration,
				this.typeDeclaration, this.typeDeclaration = typeDeclaration);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTypeDeclaration().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTypeDeclaration(value
					.wGetAdapter(JavaEntityDescriptorEnum.TypeDeclaration));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
