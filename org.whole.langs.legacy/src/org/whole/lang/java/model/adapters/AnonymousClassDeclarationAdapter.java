package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AnonymousClassDeclarationAdapter extends
		AbstractListEntityAdapter<BodyDeclaration> implements
		AnonymousClassDeclaration {
	private static final long serialVersionUID = 1;

	public AnonymousClassDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public AnonymousClassDeclarationAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AnonymousClassDeclaration> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.AnonymousClassDeclaration;
	}
}
