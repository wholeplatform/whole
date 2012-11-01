package org.whole.lang.editors.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.editors.model.*;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class RowImpl extends AbstractCollectionCompositeEntity<RowElement>
		implements Row {
	private static final long serialVersionUID = 1;

	public void accept(IEditorsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return EditorsEntityDescriptorEnum.Row_ord;
	}

	public EntityDescriptor<Row> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.Row;
	}
}
