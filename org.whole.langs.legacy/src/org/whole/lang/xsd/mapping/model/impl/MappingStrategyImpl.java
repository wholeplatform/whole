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
public class MappingStrategyImpl extends AbstractSimpleEntity implements
		MappingStrategy {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<MappingStrategy> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.MappingStrategy;
	}

	public int wGetEntityOrd() {
		return MappingEntityDescriptorEnum.MappingStrategy_ord;
	}

	public void accept(IMappingVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private URI namespace;

	public URI getNamespace() {
		return notifyRequested(MappingFeatureDescriptorEnum.namespace,
				namespace);
	}

	public void setNamespace(URI namespace) {
		notifyChanged(MappingFeatureDescriptorEnum.namespace, this.namespace,
				this.namespace = namespace);
	}

	private URI schemaLocation;

	public URI getSchemaLocation() {
		return notifyRequested(MappingFeatureDescriptorEnum.schemaLocation,
				schemaLocation);
	}

	public void setSchemaLocation(URI schemaLocation) {
		notifyChanged(MappingFeatureDescriptorEnum.schemaLocation,
				this.schemaLocation, this.schemaLocation = schemaLocation);
	}

	private BooleanType synthesized;

	public BooleanType getSynthesized() {
		return notifyRequested(MappingFeatureDescriptorEnum.synthesized,
				synthesized);
	}

	public void setSynthesized(BooleanType synthesized) {
		notifyChanged(MappingFeatureDescriptorEnum.synthesized,
				this.synthesized, this.synthesized = synthesized);
	}

	private BooleanType elementsFormQualified;

	public BooleanType getElementsFormQualified() {
		return notifyRequested(
				MappingFeatureDescriptorEnum.elementsFormQualified,
				elementsFormQualified);
	}

	public void setElementsFormQualified(BooleanType elementsFormQualified) {
		notifyChanged(MappingFeatureDescriptorEnum.elementsFormQualified,
				this.elementsFormQualified,
				this.elementsFormQualified = elementsFormQualified);
	}

	private BooleanType attributesFormQualified;

	public BooleanType getAttributesFormQualified() {
		return notifyRequested(
				MappingFeatureDescriptorEnum.attributesFormQualified,
				attributesFormQualified);
	}

	public void setAttributesFormQualified(BooleanType attributesFormQualified) {
		notifyChanged(MappingFeatureDescriptorEnum.attributesFormQualified,
				this.attributesFormQualified,
				this.attributesFormQualified = attributesFormQualified);
	}

	private URI mixedDataType;

	public URI getMixedDataType() {
		return notifyRequested(MappingFeatureDescriptorEnum.mixedDataType,
				mixedDataType);
	}

	public void setMixedDataType(URI mixedDataType) {
		notifyChanged(MappingFeatureDescriptorEnum.mixedDataType,
				this.mixedDataType, this.mixedDataType = mixedDataType);
	}

	private Types mixedTypes;

	public Types getMixedTypes() {
		return notifyRequested(MappingFeatureDescriptorEnum.mixedTypes,
				mixedTypes);
	}

	public void setMixedTypes(Types mixedTypes) {
		notifyChanged(MappingFeatureDescriptorEnum.mixedTypes, this.mixedTypes,
				this.mixedTypes = mixedTypes);
	}

	private Mappings mappings;

	public Mappings getMappings() {
		return notifyRequested(MappingFeatureDescriptorEnum.mappings, mappings);
	}

	public void setMappings(Mappings mappings) {
		notifyChanged(MappingFeatureDescriptorEnum.mappings, this.mappings,
				this.mappings = mappings);
	}

	private DataTypes dataTypes;

	public DataTypes getDataTypes() {
		return notifyRequested(MappingFeatureDescriptorEnum.dataTypes,
				dataTypes);
	}

	public void setDataTypes(DataTypes dataTypes) {
		notifyChanged(MappingFeatureDescriptorEnum.dataTypes, this.dataTypes,
				this.dataTypes = dataTypes);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getNamespace().wGetAdaptee(false);
		case 1:
			return getSchemaLocation().wGetAdaptee(false);
		case 2:
			return getSynthesized().wGetAdaptee(false);
		case 3:
			return getElementsFormQualified().wGetAdaptee(false);
		case 4:
			return getAttributesFormQualified().wGetAdaptee(false);
		case 5:
			return getMixedDataType().wGetAdaptee(false);
		case 6:
			return getMixedTypes().wGetAdaptee(false);
		case 7:
			return getMappings().wGetAdaptee(false);
		case 8:
			return getDataTypes().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setNamespace(value.wGetAdapter(MappingEntityDescriptorEnum.URI));
			break;
		case 1:
			setSchemaLocation(value
					.wGetAdapter(MappingEntityDescriptorEnum.URI));
			break;
		case 2:
			setSynthesized(value
					.wGetAdapter(MappingEntityDescriptorEnum.BooleanType));
			break;
		case 3:
			setElementsFormQualified(value
					.wGetAdapter(MappingEntityDescriptorEnum.BooleanType));
			break;
		case 4:
			setAttributesFormQualified(value
					.wGetAdapter(MappingEntityDescriptorEnum.BooleanType));
			break;
		case 5:
			setMixedDataType(value.wGetAdapter(MappingEntityDescriptorEnum.URI));
			break;
		case 6:
			setMixedTypes(value.wGetAdapter(MappingEntityDescriptorEnum.Types));
			break;
		case 7:
			setMappings(value.wGetAdapter(MappingEntityDescriptorEnum.Mappings));
			break;
		case 8:
			setDataTypes(value
					.wGetAdapter(MappingEntityDescriptorEnum.DataTypes));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 9;
	}
}
