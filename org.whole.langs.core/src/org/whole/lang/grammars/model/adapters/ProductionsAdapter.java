package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ProductionsAdapter extends AbstractListEntityAdapter<Production>
		implements Productions {
	private static final long serialVersionUID = 1;

	public ProductionsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ProductionsAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Productions> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Productions;
	}
}
