package org.whole.lang.xsd.mapping.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;
import org.whole.lang.xsd.mapping.reflect.MappingFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class MappingStrategyAdapter extends AbstractEntityAdapter implements
		MappingStrategy {
	private static final long serialVersionUID = 1;

	public MappingStrategyAdapter(IEntity implementor) {
		super(implementor);
	}

	public MappingStrategyAdapter() {
	}

	public void accept(IMappingVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<MappingStrategy> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.MappingStrategy;
	}

	public URI getNamespace() {
		return wGet(MappingFeatureDescriptorEnum.namespace).wGetAdapter(
				MappingEntityDescriptorEnum.URI);
	}

	public void setNamespace(URI namespace) {
		wSet(MappingFeatureDescriptorEnum.namespace, namespace);
	}

	public URI getSchemaLocation() {
		return wGet(MappingFeatureDescriptorEnum.schemaLocation).wGetAdapter(
				MappingEntityDescriptorEnum.URI);
	}

	public void setSchemaLocation(URI schemaLocation) {
		wSet(MappingFeatureDescriptorEnum.schemaLocation, schemaLocation);
	}

	public BooleanType getSynthesized() {
		return wGet(MappingFeatureDescriptorEnum.synthesized).wGetAdapter(
				MappingEntityDescriptorEnum.BooleanType);
	}

	public void setSynthesized(BooleanType synthesized) {
		wSet(MappingFeatureDescriptorEnum.synthesized, synthesized);
	}

	public BooleanType getElementsFormQualified() {
		return wGet(MappingFeatureDescriptorEnum.elementsFormQualified)
				.wGetAdapter(MappingEntityDescriptorEnum.BooleanType);
	}

	public void setElementsFormQualified(BooleanType elementsFormQualified) {
		wSet(MappingFeatureDescriptorEnum.elementsFormQualified,
				elementsFormQualified);
	}

	public BooleanType getAttributesFormQualified() {
		return wGet(MappingFeatureDescriptorEnum.attributesFormQualified)
				.wGetAdapter(MappingEntityDescriptorEnum.BooleanType);
	}

	public void setAttributesFormQualified(BooleanType attributesFormQualified) {
		wSet(MappingFeatureDescriptorEnum.attributesFormQualified,
				attributesFormQualified);
	}

	public URI getMixedDataType() {
		return wGet(MappingFeatureDescriptorEnum.mixedDataType).wGetAdapter(
				MappingEntityDescriptorEnum.URI);
	}

	public void setMixedDataType(URI mixedDataType) {
		wSet(MappingFeatureDescriptorEnum.mixedDataType, mixedDataType);
	}

	public Types getMixedTypes() {
		return wGet(MappingFeatureDescriptorEnum.mixedTypes).wGetAdapter(
				MappingEntityDescriptorEnum.Types);
	}

	public void setMixedTypes(Types mixedTypes) {
		wSet(MappingFeatureDescriptorEnum.mixedTypes, mixedTypes);
	}

	public Mappings getMappings() {
		return wGet(MappingFeatureDescriptorEnum.mappings).wGetAdapter(
				MappingEntityDescriptorEnum.Mappings);
	}

	public void setMappings(Mappings mappings) {
		wSet(MappingFeatureDescriptorEnum.mappings, mappings);
	}

	public DataTypes getDataTypes() {
		return wGet(MappingFeatureDescriptorEnum.dataTypes).wGetAdapter(
				MappingEntityDescriptorEnum.DataTypes);
	}

	public void setDataTypes(DataTypes dataTypes) {
		wSet(MappingFeatureDescriptorEnum.dataTypes, dataTypes);
	}
}
