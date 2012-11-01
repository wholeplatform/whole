package org.whole.lang.editors.model.adapters;

import org.whole.lang.model.adapters.AbstractCollectionEntityAdapter;
import org.whole.lang.editors.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ControllerDeclarationsAdapter extends
		AbstractCollectionEntityAdapter<ControllerDeclaration> implements
		ControllerDeclarations {
	private static final long serialVersionUID = 1;

	public ControllerDeclarationsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ControllerDeclarationsAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ControllerDeclarations> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.ControllerDeclarations;
	}
}
