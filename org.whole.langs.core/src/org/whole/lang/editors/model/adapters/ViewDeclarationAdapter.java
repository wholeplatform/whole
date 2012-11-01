package org.whole.lang.editors.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.editors.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ViewDeclarationAdapter extends AbstractEntityAdapter implements
		ViewDeclaration {
	private static final long serialVersionUID = 1;

	public ViewDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public ViewDeclarationAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ViewDeclaration> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.ViewDeclaration;
	}
}
