package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.model.CategoryEnum.Value;

/** 
 * @generator Whole
 */
public class CategoryAdapter extends AbstractEntityAdapter implements Category {
	private static final long serialVersionUID = 1;

	public CategoryAdapter(IEntity implementor) {
		super(implementor);
	}

	public CategoryAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Category> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Category;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
