package org.whole.lang.types.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.types.reflect.TypesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class CaseAdapter extends AbstractEntityAdapter implements Case {
	private static final long serialVersionUID = 1;

	public CaseAdapter(IEntity implementor) {
		super(implementor);
	}

	public CaseAdapter() {
	}

	public void accept(ITypesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Case> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.Case;
	}

	public BasicType getType() {
		return wGet(TypesFeatureDescriptorEnum.type).wGetAdapter(
				TypesEntityDescriptorEnum.BasicType);
	}

	public void setType(BasicType type) {
		wSet(TypesFeatureDescriptorEnum.type, type);
	}

	public Expressions getExpressions() {
		return wGet(TypesFeatureDescriptorEnum.expressions).wGetAdapter(
				TypesEntityDescriptorEnum.Expressions);
	}

	public void setExpressions(Expressions expressions) {
		wSet(TypesFeatureDescriptorEnum.expressions, expressions);
	}
}
