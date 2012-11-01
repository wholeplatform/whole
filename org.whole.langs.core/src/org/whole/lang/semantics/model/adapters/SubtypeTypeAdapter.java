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
public class SubtypeTypeAdapter extends AbstractEntityAdapter implements
		SubtypeType {
	private static final long serialVersionUID = 1;

	public SubtypeTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public SubtypeTypeAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SubtypeType> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.SubtypeType;
	}

	public EntityType getCategory() {
		return wGet(SemanticsFeatureDescriptorEnum.category).wGetAdapter(
				SemanticsEntityDescriptorEnum.EntityType);
	}

	public void setCategory(EntityType category) {
		wSet(SemanticsFeatureDescriptorEnum.category, category);
	}
}
