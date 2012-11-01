package org.whole.lang.frames.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FramesModelContext extends EntityContext {
	public FramesModelContext(IEntity root) {
		super(root);
	}

	public FramesModelContext getUri() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.uri);
	}

	public void setUri(FramesModelContext uri) {
		wSet(FramesFeatureDescriptorEnum.uri, uri);
	}

	public FramesModelContext getNamespace() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.namespace);
	}

	public void setNamespace(FramesModelContext namespace) {
		wSet(FramesFeatureDescriptorEnum.namespace, namespace);
	}

	public FramesModelContext getName() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.name);
	}

	public void setName(FramesModelContext name) {
		wSet(FramesFeatureDescriptorEnum.name, name);
	}

	public FramesModelContext getVersion() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.version);
	}

	public void setVersion(FramesModelContext version) {
		wSet(FramesFeatureDescriptorEnum.version, version);
	}

	public FramesModelContext getImports() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.imports);
	}

	public void setImports(FramesModelContext imports) {
		wSet(FramesFeatureDescriptorEnum.imports, imports);
	}

	public FramesModelContext getVariability() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.variability);
	}

	public void setVariability(FramesModelContext variability) {
		wSet(FramesFeatureDescriptorEnum.variability, variability);
	}

	public FramesModelContext getRelations() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.relations);
	}

	public void setRelations(FramesModelContext relations) {
		wSet(FramesFeatureDescriptorEnum.relations, relations);
	}

	public FramesModelContext getContent() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.content);
	}

	public void setContent(FramesModelContext content) {
		wSet(FramesFeatureDescriptorEnum.content, content);
	}

	public FramesModelContext getJoinpoints() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.joinpoints);
	}

	public void setJoinpoints(FramesModelContext joinpoints) {
		wSet(FramesFeatureDescriptorEnum.joinpoints, joinpoints);
	}

	public FramesModelContext getEnabler() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.enabler);
	}

	public void setEnabler(FramesModelContext enabler) {
		wSet(FramesFeatureDescriptorEnum.enabler, enabler);
	}

	public FramesModelContext getIterator() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.iterator);
	}

	public void setIterator(FramesModelContext iterator) {
		wSet(FramesFeatureDescriptorEnum.iterator, iterator);
	}

	public FramesModelContext getSelector() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.selector);
	}

	public void setSelector(FramesModelContext selector) {
		wSet(FramesFeatureDescriptorEnum.selector, selector);
	}

	public FramesModelContext getVariants() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.variants);
	}

	public void setVariants(FramesModelContext variants) {
		wSet(FramesFeatureDescriptorEnum.variants, variants);
	}

	public FramesModelContext getFrame() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.frame);
	}

	public void setFrame(FramesModelContext frame) {
		wSet(FramesFeatureDescriptorEnum.frame, frame);
	}

	public FramesModelContext getConfiguration() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.configuration);
	}

	public void setConfiguration(FramesModelContext configuration) {
		wSet(FramesFeatureDescriptorEnum.configuration, configuration);
	}

	public FramesModelContext getAdvices() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.advices);
	}

	public void setAdvices(FramesModelContext advices) {
		wSet(FramesFeatureDescriptorEnum.advices, advices);
	}

	public FramesModelContext getResource() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.resource);
	}

	public void setResource(FramesModelContext resource) {
		wSet(FramesFeatureDescriptorEnum.resource, resource);
	}

	public FramesModelContext getFeature() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.feature);
	}

	public void setFeature(FramesModelContext feature) {
		wSet(FramesFeatureDescriptorEnum.feature, feature);
	}

	public FramesModelContext getRequiredFeatures() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.requiredFeatures);
	}

	public void setRequiredFeatures(FramesModelContext requiredFeatures) {
		wSet(FramesFeatureDescriptorEnum.requiredFeatures, requiredFeatures);
	}

	public FramesModelContext getExcludedFeatures() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.excludedFeatures);
	}

	public void setExcludedFeatures(FramesModelContext excludedFeatures) {
		wSet(FramesFeatureDescriptorEnum.excludedFeatures, excludedFeatures);
	}

	public FramesModelContext getCardinality() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.cardinality);
	}

	public void setCardinality(FramesModelContext cardinality) {
		wSet(FramesFeatureDescriptorEnum.cardinality, cardinality);
	}

	public FramesModelContext getFeatures() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.features);
	}

	public void setFeatures(FramesModelContext features) {
		wSet(FramesFeatureDescriptorEnum.features, features);
	}

	public FramesModelContext getValue() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.value);
	}

	public void setValue(FramesModelContext value) {
		wSet(FramesFeatureDescriptorEnum.value, value);
	}

	public FramesModelContext getAnnotations() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.annotations);
	}

	public void setAnnotations(FramesModelContext annotations) {
		wSet(FramesFeatureDescriptorEnum.annotations, annotations);
	}

	public FramesModelContext getType() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.type);
	}

	public void setType(FramesModelContext type) {
		wSet(FramesFeatureDescriptorEnum.type, type);
	}

	public FramesModelContext getNewName() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.newName);
	}

	public void setNewName(FramesModelContext newName) {
		wSet(FramesFeatureDescriptorEnum.newName, newName);
	}

	public FramesModelContext getLocation() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.location);
	}

	public void setLocation(FramesModelContext location) {
		wSet(FramesFeatureDescriptorEnum.location, location);
	}

	public FramesModelContext getPersistence() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.persistence);
	}

	public void setPersistence(FramesModelContext persistence) {
		wSet(FramesFeatureDescriptorEnum.persistence, persistence);
	}

	public FramesModelContext getMin() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.min);
	}

	public void setMin(FramesModelContext min) {
		wSet(FramesFeatureDescriptorEnum.min, min);
	}

	public FramesModelContext getMax() {
		return (FramesModelContext) wGet(FramesFeatureDescriptorEnum.max);
	}

	public void setMax(FramesModelContext max) {
		wSet(FramesFeatureDescriptorEnum.max, max);
	}
}
