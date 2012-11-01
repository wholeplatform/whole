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
public class FigureNameAdapter extends AbstractEntityAdapter implements
		FigureName {
	private static final long serialVersionUID = 1;

	public FigureNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public FigureNameAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FigureName> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.FigureName;
	}
}
