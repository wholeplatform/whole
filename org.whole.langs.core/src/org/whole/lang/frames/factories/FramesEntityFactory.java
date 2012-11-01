package org.whole.lang.frames.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.frames.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FramesEntityFactory extends GenericEntityFactory {
	public static final FramesEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static FramesEntityFactory instance(IEntityRegistryProvider provider) {
		return new FramesEntityFactory(provider);
	}

	protected FramesEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Frame createFrame() {
		return create(FramesEntityDescriptorEnum.Frame);
	}

	public Frame createFrame(URI uri, Namespace namespace, Name name,
			Version version, Resources imports, Features variability,
			Relations relations, Content content) {
		return create(FramesEntityDescriptorEnum.Frame, uri, namespace, name,
				version, imports, variability, relations, content);
	}

	public IEntityBuilder<Frame> buildFrame() {
		return new EntityBuilder<Frame>(
				create(FramesEntityDescriptorEnum.Frame));
	}

	public Variants createVariants() {
		return create(FramesEntityDescriptorEnum.Variants);
	}

	public Variants createVariants(VariationPoint... entities) {
		return create(FramesEntityDescriptorEnum.Variants, (IEntity[]) entities);
	}

	public Variants createVariants(int initialSize) {
		return clone(FramesEntityDescriptorEnum.Variants, initialSize);
	}

	public Empty createEmpty() {
		return create(FramesEntityDescriptorEnum.Empty);
	}

	public Proceed createProceed() {
		return create(FramesEntityDescriptorEnum.Proceed);
	}

	public Proceed createProceed(Feature joinpoints) {
		return create(FramesEntityDescriptorEnum.Proceed, joinpoints);
	}

	public InlineContent createInlineContent() {
		return create(FramesEntityDescriptorEnum.InlineContent);
	}

	public InlineContent createInlineContent(Content content) {
		return create(FramesEntityDescriptorEnum.InlineContent, content);
	}

	public JoinPoint createJoinPoint() {
		return create(FramesEntityDescriptorEnum.JoinPoint);
	}

	public JoinPoint createJoinPoint(FeatureName name, Content content) {
		return create(FramesEntityDescriptorEnum.JoinPoint, name, content);
	}

	public IEntityBuilder<JoinPoint> buildJoinPoint() {
		return new EntityBuilder<JoinPoint>(
				create(FramesEntityDescriptorEnum.JoinPoint));
	}

	public ConditionPoint createConditionPoint() {
		return create(FramesEntityDescriptorEnum.ConditionPoint);
	}

	public ConditionPoint createConditionPoint(FeatureName enabler,
			Content content) {
		return create(FramesEntityDescriptorEnum.ConditionPoint, enabler,
				content);
	}

	public IEntityBuilder<ConditionPoint> buildConditionPoint() {
		return new EntityBuilder<ConditionPoint>(
				create(FramesEntityDescriptorEnum.ConditionPoint));
	}

	public IterationPoint createIterationPoint() {
		return create(FramesEntityDescriptorEnum.IterationPoint);
	}

	public IterationPoint createIterationPoint(FeatureName iterator,
			Content content) {
		return create(FramesEntityDescriptorEnum.IterationPoint, iterator,
				content);
	}

	public IEntityBuilder<IterationPoint> buildIterationPoint() {
		return new EntityBuilder<IterationPoint>(
				create(FramesEntityDescriptorEnum.IterationPoint));
	}

	public SelectionPoint createSelectionPoint() {
		return create(FramesEntityDescriptorEnum.SelectionPoint);
	}

	public SelectionPoint createSelectionPoint(FeatureName selector,
			Variants variants) {
		return create(FramesEntityDescriptorEnum.SelectionPoint, selector,
				variants);
	}

	public IEntityBuilder<SelectionPoint> buildSelectionPoint() {
		return new EntityBuilder<SelectionPoint>(
				create(FramesEntityDescriptorEnum.SelectionPoint));
	}

	public ReusePoint createReusePoint() {
		return create(FramesEntityDescriptorEnum.ReusePoint);
	}

	public ReusePoint createReusePoint(ResourceIdentifier frame,
			Features configuration, Relations relations, Advices advices) {
		return create(FramesEntityDescriptorEnum.ReusePoint, frame,
				configuration, relations, advices);
	}

	public IEntityBuilder<ReusePoint> buildReusePoint() {
		return new EntityBuilder<ReusePoint>(
				create(FramesEntityDescriptorEnum.ReusePoint));
	}

	public IncludePoint createIncludePoint() {
		return create(FramesEntityDescriptorEnum.IncludePoint);
	}

	public IncludePoint createIncludePoint(ResourceIdentifier resource) {
		return create(FramesEntityDescriptorEnum.IncludePoint, resource);
	}

	public Relations createRelations() {
		return create(FramesEntityDescriptorEnum.Relations);
	}

	public Relations createRelations(Relation... entities) {
		return create(FramesEntityDescriptorEnum.Relations,
				(IEntity[]) entities);
	}

	public Relations createRelations(int initialSize) {
		return clone(FramesEntityDescriptorEnum.Relations, initialSize);
	}

	public Pointcut createPointcut() {
		return create(FramesEntityDescriptorEnum.Pointcut);
	}

	public Pointcut createPointcut(Feature feature,
			JoinpointExpression joinpoints) {
		return create(FramesEntityDescriptorEnum.Pointcut, feature, joinpoints);
	}

	public IEntityBuilder<Pointcut> buildPointcut() {
		return new EntityBuilder<Pointcut>(
				create(FramesEntityDescriptorEnum.Pointcut));
	}

	public Require createRequire() {
		return create(FramesEntityDescriptorEnum.Require);
	}

	public Require createRequire(FeatureName feature,
			FeatureNames requiredFeatures) {
		return create(FramesEntityDescriptorEnum.Require, feature,
				requiredFeatures);
	}

	public IEntityBuilder<Require> buildRequire() {
		return new EntityBuilder<Require>(
				create(FramesEntityDescriptorEnum.Require));
	}

	public Exclude createExclude() {
		return create(FramesEntityDescriptorEnum.Exclude);
	}

	public Exclude createExclude(FeatureName feature,
			FeatureNames excludedFeatures) {
		return create(FramesEntityDescriptorEnum.Exclude, feature,
				excludedFeatures);
	}

	public IEntityBuilder<Exclude> buildExclude() {
		return new EntityBuilder<Exclude>(
				create(FramesEntityDescriptorEnum.Exclude));
	}

	public MutuallyRequire createMutuallyRequire() {
		return create(FramesEntityDescriptorEnum.MutuallyRequire);
	}

	public MutuallyRequire createMutuallyRequire(FeatureName... entities) {
		return create(FramesEntityDescriptorEnum.MutuallyRequire,
				(IEntity[]) entities);
	}

	public MutuallyRequire createMutuallyRequire(int initialSize) {
		return clone(FramesEntityDescriptorEnum.MutuallyRequire, initialSize);
	}

	public MutuallyExclude createMutuallyExclude() {
		return create(FramesEntityDescriptorEnum.MutuallyExclude);
	}

	public MutuallyExclude createMutuallyExclude(FeatureName... entities) {
		return create(FramesEntityDescriptorEnum.MutuallyExclude,
				(IEntity[]) entities);
	}

	public MutuallyExclude createMutuallyExclude(int initialSize) {
		return clone(FramesEntityDescriptorEnum.MutuallyExclude, initialSize);
	}

	public FeatureNames createFeatureNames() {
		return create(FramesEntityDescriptorEnum.FeatureNames);
	}

	public FeatureNames createFeatureNames(FeatureName... entities) {
		return create(FramesEntityDescriptorEnum.FeatureNames,
				(IEntity[]) entities);
	}

	public FeatureNames createFeatureNames(int initialSize) {
		return clone(FramesEntityDescriptorEnum.FeatureNames, initialSize);
	}

	public Advices createAdvices() {
		return create(FramesEntityDescriptorEnum.Advices);
	}

	public Advices createAdvices(Advice... entities) {
		return create(FramesEntityDescriptorEnum.Advices, (IEntity[]) entities);
	}

	public Advices createAdvices(int initialSize) {
		return clone(FramesEntityDescriptorEnum.Advices, initialSize);
	}

	public Before createBefore() {
		return create(FramesEntityDescriptorEnum.Before);
	}

	public Before createBefore(JoinpointExpression joinpoints, Content content) {
		return create(FramesEntityDescriptorEnum.Before, joinpoints, content);
	}

	public IEntityBuilder<Before> buildBefore() {
		return new EntityBuilder<Before>(
				create(FramesEntityDescriptorEnum.Before));
	}

	public After createAfter() {
		return create(FramesEntityDescriptorEnum.After);
	}

	public After createAfter(JoinpointExpression joinpoints, Content content) {
		return create(FramesEntityDescriptorEnum.After, joinpoints, content);
	}

	public IEntityBuilder<After> buildAfter() {
		return new EntityBuilder<After>(
				create(FramesEntityDescriptorEnum.After));
	}

	public Into createInto() {
		return create(FramesEntityDescriptorEnum.Into);
	}

	public Into createInto(JoinpointExpression joinpoints, Content content) {
		return create(FramesEntityDescriptorEnum.Into, joinpoints, content);
	}

	public IEntityBuilder<Into> buildInto() {
		return new EntityBuilder<Into>(create(FramesEntityDescriptorEnum.Into));
	}

	public Around createAround() {
		return create(FramesEntityDescriptorEnum.Around);
	}

	public Around createAround(JoinpointExpression joinpoints, Content content) {
		return create(FramesEntityDescriptorEnum.Around, joinpoints, content);
	}

	public IEntityBuilder<Around> buildAround() {
		return new EntityBuilder<Around>(
				create(FramesEntityDescriptorEnum.Around));
	}

	public Features createFeatures() {
		return create(FramesEntityDescriptorEnum.Features);
	}

	public Features createFeatures(Feature... entities) {
		return create(FramesEntityDescriptorEnum.Features, (IEntity[]) entities);
	}

	public Features createFeatures(int initialSize) {
		return clone(FramesEntityDescriptorEnum.Features, initialSize);
	}

	public Subfeatures createSubfeatures() {
		return create(FramesEntityDescriptorEnum.Subfeatures);
	}

	public Subfeatures createSubfeatures(Subfeature... entities) {
		return create(FramesEntityDescriptorEnum.Subfeatures,
				(IEntity[]) entities);
	}

	public Subfeatures createSubfeatures(int initialSize) {
		return clone(FramesEntityDescriptorEnum.Subfeatures, initialSize);
	}

	public VariableFeatures createVariableFeatures() {
		return create(FramesEntityDescriptorEnum.VariableFeatures);
	}

	public VariableFeatures createVariableFeatures(VariableFeature... entities) {
		return create(FramesEntityDescriptorEnum.VariableFeatures,
				(IEntity[]) entities);
	}

	public VariableFeatures createVariableFeatures(int initialSize) {
		return clone(FramesEntityDescriptorEnum.VariableFeatures, initialSize);
	}

	public SolitaryFeatures createSolitaryFeatures() {
		return create(FramesEntityDescriptorEnum.SolitaryFeatures);
	}

	public SolitaryFeatures createSolitaryFeatures(SolitaryFeature... entities) {
		return create(FramesEntityDescriptorEnum.SolitaryFeatures,
				(IEntity[]) entities);
	}

	public SolitaryFeatures createSolitaryFeatures(int initialSize) {
		return clone(FramesEntityDescriptorEnum.SolitaryFeatures, initialSize);
	}

	public SubsetGroup createSubsetGroup() {
		return create(FramesEntityDescriptorEnum.SubsetGroup);
	}

	public SubsetGroup createSubsetGroup(Cardinality cardinality,
			VariableFeatures features) {
		return create(FramesEntityDescriptorEnum.SubsetGroup, cardinality,
				features);
	}

	public IEntityBuilder<SubsetGroup> buildSubsetGroup() {
		return new EntityBuilder<SubsetGroup>(
				create(FramesEntityDescriptorEnum.SubsetGroup));
	}

	public CloneGroup createCloneGroup() {
		return create(FramesEntityDescriptorEnum.CloneGroup);
	}

	public CloneGroup createCloneGroup(Cardinality cardinality,
			SolitaryFeatures features) {
		return create(FramesEntityDescriptorEnum.CloneGroup, cardinality,
				features);
	}

	public IEntityBuilder<CloneGroup> buildCloneGroup() {
		return new EntityBuilder<CloneGroup>(
				create(FramesEntityDescriptorEnum.CloneGroup));
	}

	public VariableFeature createVariableFeature() {
		return create(FramesEntityDescriptorEnum.VariableFeature);
	}

	public VariableFeature createVariableFeature(SolitaryFeature feature,
			VariableValue value) {
		return create(FramesEntityDescriptorEnum.VariableFeature, feature,
				value);
	}

	public IEntityBuilder<VariableFeature> buildVariableFeature() {
		return new EntityBuilder<VariableFeature>(
				create(FramesEntityDescriptorEnum.VariableFeature));
	}

	public Feature createFeature() {
		return create(FramesEntityDescriptorEnum.Feature);
	}

	public Feature createFeature(SolitaryFeatureName name,
			Annotations annotations, Subfeatures features) {
		return create(FramesEntityDescriptorEnum.Feature, name, annotations,
				features);
	}

	public IEntityBuilder<Feature> buildFeature() {
		return new EntityBuilder<Feature>(
				create(FramesEntityDescriptorEnum.Feature));
	}

	public Attribute createAttribute() {
		return create(FramesEntityDescriptorEnum.Attribute);
	}

	public Attribute createAttribute(SolitaryFeatureName name, Type type,
			Expression value) {
		return create(FramesEntityDescriptorEnum.Attribute, name, type, value);
	}

	public IEntityBuilder<Attribute> buildAttribute() {
		return new EntityBuilder<Attribute>(
				create(FramesEntityDescriptorEnum.Attribute));
	}

	public FeatureReference createFeatureReference() {
		return create(FramesEntityDescriptorEnum.FeatureReference);
	}

	public FeatureReference createFeatureReference(SolitaryFeatureName name) {
		return create(FramesEntityDescriptorEnum.FeatureReference, name);
	}

	public FeatureRename createFeatureRename() {
		return create(FramesEntityDescriptorEnum.FeatureRename);
	}

	public FeatureRename createFeatureRename(FeatureName name,
			FeatureName newName) {
		return create(FramesEntityDescriptorEnum.FeatureRename, name, newName);
	}

	public IEntityBuilder<FeatureRename> buildFeatureRename() {
		return new EntityBuilder<FeatureRename>(
				create(FramesEntityDescriptorEnum.FeatureRename));
	}

	public EntityType createEntityType() {
		return create(FramesEntityDescriptorEnum.EntityType);
	}

	public EntityType createEntityType(String value) {
		return create(FramesEntityDescriptorEnum.EntityType, value);
	}

	public Domain createDomain() {
		return create(FramesEntityDescriptorEnum.Domain);
	}

	public Domain createDomain(DomainEnum.Value value) {
		return create(FramesEntityDescriptorEnum.Domain, value);
	}

	public VariableValue createVariableValue() {
		return create(FramesEntityDescriptorEnum.VariableValue);
	}

	public VariableValue createVariableValue(VariableValueEnum.Value value) {
		return create(FramesEntityDescriptorEnum.VariableValue, value);
	}

	public Resources createResources() {
		return create(FramesEntityDescriptorEnum.Resources);
	}

	public Resources createResources(Resource... entities) {
		return create(FramesEntityDescriptorEnum.Resources,
				(IEntity[]) entities);
	}

	public Resources createResources(int initialSize) {
		return clone(FramesEntityDescriptorEnum.Resources, initialSize);
	}

	public Resource createResource() {
		return create(FramesEntityDescriptorEnum.Resource);
	}

	public Resource createResource(URI uri, Location location,
			Persistence persistence) {
		return create(FramesEntityDescriptorEnum.Resource, uri, location,
				persistence);
	}

	public IEntityBuilder<Resource> buildResource() {
		return new EntityBuilder<Resource>(
				create(FramesEntityDescriptorEnum.Resource));
	}

	public WorkspacePath createWorkspacePath() {
		return create(FramesEntityDescriptorEnum.WorkspacePath);
	}

	public WorkspacePath createWorkspacePath(String value) {
		return create(FramesEntityDescriptorEnum.WorkspacePath, value);
	}

	public FileSystemPath createFileSystemPath() {
		return create(FramesEntityDescriptorEnum.FileSystemPath);
	}

	public FileSystemPath createFileSystemPath(String value) {
		return create(FramesEntityDescriptorEnum.FileSystemPath, value);
	}

	public URL createURL() {
		return create(FramesEntityDescriptorEnum.URL);
	}

	public URL createURL(String value) {
		return create(FramesEntityDescriptorEnum.URL, value);
	}

	public PersistenceId createPersistenceId() {
		return create(FramesEntityDescriptorEnum.PersistenceId);
	}

	public PersistenceId createPersistenceId(String value) {
		return create(FramesEntityDescriptorEnum.PersistenceId, value);
	}

	public BooleanValue createBooleanValue() {
		return create(FramesEntityDescriptorEnum.BooleanValue);
	}

	public BooleanValue createBooleanValue(boolean value) {
		return create(FramesEntityDescriptorEnum.BooleanValue, value);
	}

	public ByteValue createByteValue() {
		return create(FramesEntityDescriptorEnum.ByteValue);
	}

	public ByteValue createByteValue(byte value) {
		return create(FramesEntityDescriptorEnum.ByteValue, value);
	}

	public ShortValue createShortValue() {
		return create(FramesEntityDescriptorEnum.ShortValue);
	}

	public ShortValue createShortValue(short value) {
		return create(FramesEntityDescriptorEnum.ShortValue, value);
	}

	public IntValue createIntValue() {
		return create(FramesEntityDescriptorEnum.IntValue);
	}

	public IntValue createIntValue(int value) {
		return create(FramesEntityDescriptorEnum.IntValue, value);
	}

	public LongValue createLongValue() {
		return create(FramesEntityDescriptorEnum.LongValue);
	}

	public LongValue createLongValue(long value) {
		return create(FramesEntityDescriptorEnum.LongValue, value);
	}

	public FloatValue createFloatValue() {
		return create(FramesEntityDescriptorEnum.FloatValue);
	}

	public FloatValue createFloatValue(float value) {
		return create(FramesEntityDescriptorEnum.FloatValue, value);
	}

	public DoubleValue createDoubleValue() {
		return create(FramesEntityDescriptorEnum.DoubleValue);
	}

	public DoubleValue createDoubleValue(double value) {
		return create(FramesEntityDescriptorEnum.DoubleValue, value);
	}

	public CharValue createCharValue() {
		return create(FramesEntityDescriptorEnum.CharValue);
	}

	public CharValue createCharValue(char value) {
		return create(FramesEntityDescriptorEnum.CharValue, value);
	}

	public StringValue createStringValue() {
		return create(FramesEntityDescriptorEnum.StringValue);
	}

	public StringValue createStringValue(String value) {
		return create(FramesEntityDescriptorEnum.StringValue, value);
	}

	public FeatureName createFeatureName() {
		return create(FramesEntityDescriptorEnum.FeatureName);
	}

	public FeatureName createFeatureName(String value) {
		return create(FramesEntityDescriptorEnum.FeatureName, value);
	}

	public FeatureValue createFeatureValue() {
		return create(FramesEntityDescriptorEnum.FeatureValue);
	}

	public FeatureValue createFeatureValue(String value) {
		return create(FramesEntityDescriptorEnum.FeatureValue, value);
	}

	public URI createURI() {
		return create(FramesEntityDescriptorEnum.URI);
	}

	public URI createURI(String value) {
		return create(FramesEntityDescriptorEnum.URI, value);
	}

	public Namespace createNamespace() {
		return create(FramesEntityDescriptorEnum.Namespace);
	}

	public Namespace createNamespace(String value) {
		return create(FramesEntityDescriptorEnum.Namespace, value);
	}

	public Name createName() {
		return create(FramesEntityDescriptorEnum.Name);
	}

	public Name createName(String value) {
		return create(FramesEntityDescriptorEnum.Name, value);
	}

	public Version createVersion() {
		return create(FramesEntityDescriptorEnum.Version);
	}

	public Version createVersion(String value) {
		return create(FramesEntityDescriptorEnum.Version, value);
	}

	public Cardinality createCardinality() {
		return create(FramesEntityDescriptorEnum.Cardinality);
	}

	public Cardinality createCardinality(IntValue min, IntValue max) {
		return create(FramesEntityDescriptorEnum.Cardinality, min, max);
	}

	public IEntityBuilder<Cardinality> buildCardinality() {
		return new EntityBuilder<Cardinality>(
				create(FramesEntityDescriptorEnum.Cardinality));
	}

	public Annotations createAnnotations() {
		return create(FramesEntityDescriptorEnum.Annotations);
	}

	public Annotations createAnnotations(Annotation... entities) {
		return create(FramesEntityDescriptorEnum.Annotations,
				(IEntity[]) entities);
	}

	public Annotations createAnnotations(int initialSize) {
		return clone(FramesEntityDescriptorEnum.Annotations, initialSize);
	}

	public Description createDescription() {
		return create(FramesEntityDescriptorEnum.Description);
	}

	public Description createDescription(String value) {
		return create(FramesEntityDescriptorEnum.Description, value);
	}

	public Categories createCategories() {
		return create(FramesEntityDescriptorEnum.Categories);
	}

	public Categories createCategories(Name... entities) {
		return create(FramesEntityDescriptorEnum.Categories,
				(IEntity[]) entities);
	}

	public Categories createCategories(int initialSize) {
		return clone(FramesEntityDescriptorEnum.Categories, initialSize);
	}

	public Stakeholders createStakeholders() {
		return create(FramesEntityDescriptorEnum.Stakeholders);
	}

	public Stakeholders createStakeholders(Name... entities) {
		return create(FramesEntityDescriptorEnum.Stakeholders,
				(IEntity[]) entities);
	}

	public Stakeholders createStakeholders(int initialSize) {
		return clone(FramesEntityDescriptorEnum.Stakeholders, initialSize);
	}

	public Priority createPriority() {
		return create(FramesEntityDescriptorEnum.Priority);
	}

	public Priority createPriority(int value) {
		return create(FramesEntityDescriptorEnum.Priority, value);
	}

	public BindingTime createBindingTime() {
		return create(FramesEntityDescriptorEnum.BindingTime);
	}

	public BindingTime createBindingTime(BindingTimeEnum.Value value) {
		return create(FramesEntityDescriptorEnum.BindingTime, value);
	}

	public CustomAnnotation createCustomAnnotation() {
		return create(FramesEntityDescriptorEnum.CustomAnnotation);
	}

	public CustomAnnotation createCustomAnnotation(Name name, Expression value) {
		return create(FramesEntityDescriptorEnum.CustomAnnotation, name, value);
	}

	public IEntityBuilder<CustomAnnotation> buildCustomAnnotation() {
		return new EntityBuilder<CustomAnnotation>(
				create(FramesEntityDescriptorEnum.CustomAnnotation));
	}
}
