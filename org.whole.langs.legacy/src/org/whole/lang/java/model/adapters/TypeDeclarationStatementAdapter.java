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
public class TypeDeclarationStatementAdapter extends AbstractEntityAdapter
		implements TypeDeclarationStatement {
	private static final long serialVersionUID = 1;

	public TypeDeclarationStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public TypeDeclarationStatementAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TypeDeclarationStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.TypeDeclarationStatement;
	}

	public TypeDeclaration getTypeDeclaration() {
		return wGet(JavaFeatureDescriptorEnum.typeDeclaration).wGetAdapter(
				JavaEntityDescriptorEnum.TypeDeclaration);
	}

	public void setTypeDeclaration(TypeDeclaration typeDeclaration) {
		wSet(JavaFeatureDescriptorEnum.typeDeclaration, typeDeclaration);
	}
}
