package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class SupertypeTypeAdapter extends AbstractEntityAdapter implements
		SupertypeType {
	private static final long serialVersionUID = 1;

	public SupertypeTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public SupertypeTypeAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SupertypeType> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.SupertypeType;
	}

	public Category getCategory() {
		return wGet(SemanticsFeatureDescriptorEnum.category).wGetAdapter(
				SemanticsEntityDescriptorEnum.Category);
	}

	public void setCategory(Category category) {
		wSet(SemanticsFeatureDescriptorEnum.category, category);
	}
}
