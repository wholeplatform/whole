package org.whole.lang.xsd.mapping.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.xsd.mapping.reflect.MappingFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class UnionMappingImpl extends AbstractSimpleEntity implements
		UnionMapping {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<UnionMapping> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.UnionMapping;
	}

	public int wGetEntityOrd() {
		return MappingEntityDescriptorEnum.UnionMapping_ord;
	}

	public void accept(IMappingVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private URI contextEntityType;

	public URI getContextEntityType() {
		return notifyRequested(MappingFeatureDescriptorEnum.contextEntityType,
				contextEntityType);
	}

	public void setContextEntityType(URI contextEntityType) {
		notifyChanged(MappingFeatureDescriptorEnum.contextEntityType,
				this.contextEntityType,
				this.contextEntityType = contextEntityType);
	}

	private Types unionTypes;

	public Types getUnionTypes() {
		return notifyRequested(MappingFeatureDescriptorEnum.unionTypes,
				unionTypes);
	}

	public void setUnionTypes(Types unionTypes) {
		notifyChanged(MappingFeatureDescriptorEnum.unionTypes, this.unionTypes,
				this.unionTypes = unionTypes);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getContextEntityType().wGetAdaptee(false);
		case 1:
			return getUnionTypes().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setContextEntityType(value
					.wGetAdapter(MappingEntityDescriptorEnum.URI));
			break;
		case 1:
			setUnionTypes(value.wGetAdapter(MappingEntityDescriptorEnum.Types));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
