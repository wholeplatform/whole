package org.whole.lang.editors.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.editors.model.*;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class TextualFigureImpl extends AbstractListCompositeEntity<Row>
		implements TextualFigure {
	private static final long serialVersionUID = 1;

	public void accept(IEditorsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return EditorsEntityDescriptorEnum.TextualFigure_ord;
	}

	public EntityDescriptor<TextualFigure> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.TextualFigure;
	}
}
