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
public class FeatureTableTypeAdapter extends AbstractEntityAdapter implements
		FeatureTableType {
	private static final long serialVersionUID = 1;

	public FeatureTableTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public FeatureTableTypeAdapter() {
	}

	public void accept(ITypesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FeatureTableType> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.FeatureTableType;
	}

	public Arguments getArguments() {
		return wGet(TypesFeatureDescriptorEnum.arguments).wGetAdapter(
				TypesEntityDescriptorEnum.Arguments);
	}

	public void setArguments(Arguments arguments) {
		wSet(TypesFeatureDescriptorEnum.arguments, arguments);
	}

	public Cases getCases() {
		return wGet(TypesFeatureDescriptorEnum.cases).wGetAdapter(
				TypesEntityDescriptorEnum.Cases);
	}

	public void setCases(Cases cases) {
		wSet(TypesFeatureDescriptorEnum.cases, cases);
	}
}
