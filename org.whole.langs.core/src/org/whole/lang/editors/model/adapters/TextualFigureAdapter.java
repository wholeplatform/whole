package org.whole.lang.editors.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.editors.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TextualFigureAdapter extends AbstractListEntityAdapter<Row>
		implements TextualFigure {
	private static final long serialVersionUID = 1;

	public TextualFigureAdapter(IEntity implementor) {
		super(implementor);
	}

	public TextualFigureAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TextualFigure> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.TextualFigure;
	}
}
