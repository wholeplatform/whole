package org.whole.lang.frames.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FramesAdaptersEntityRegistry extends AbstractEntityRegistry {
	public FramesAdaptersEntityRegistry() {
		super(FramesEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new FrameAdapter());
		put(new VariantsAdapter());
		put(new ContentAdapter());
		put(new EmptyAdapter());
		put(new ProceedAdapter());
		put(new InlineContentAdapter());
		put(new VariationPointAdapter());
		put(new JoinPointAdapter());
		put(new ConditionPointAdapter());
		put(new IterationPointAdapter());
		put(new SelectionPointAdapter());
		put(new ReusePointAdapter());
		put(new IncludePointAdapter());
		put(new RelationsAdapter());
		put(new RelationAdapter());
		put(new PointcutAdapter());
		put(new JoinpointExpressionAdapter());
		put(new RequireAdapter());
		put(new ExcludeAdapter());
		put(new MutuallyRequireAdapter());
		put(new MutuallyExcludeAdapter());
		put(new FeatureNamesAdapter());
		put(new AdvicesAdapter());
		put(new AdviceAdapter());
		put(new BeforeAdapter());
		put(new AfterAdapter());
		put(new IntoAdapter());
		put(new AroundAdapter());
		put(new FeaturesAdapter());
		put(new SubfeaturesAdapter());
		put(new VariableFeaturesAdapter());
		put(new SolitaryFeaturesAdapter());
		put(new SubfeatureAdapter());
		put(new SubsetGroupAdapter());
		put(new CloneGroupAdapter());
		put(new VariableFeatureAdapter());
		put(new SolitaryFeatureAdapter());
		put(new FeatureAdapter());
		put(new AttributeAdapter());
		put(new FeatureReferenceAdapter());
		put(new SolitaryFeatureNameAdapter());
		put(new FeatureRenameAdapter());
		put(new TypeAdapter());
		put(new EntityTypeAdapter());
		put(new DomainAdapter());
		put(new VariableValueAdapter());
		put(new ResourcesAdapter());
		put(new ResourceIdentifierAdapter());
		put(new ResourceAdapter());
		put(new LocationAdapter());
		put(new WorkspacePathAdapter());
		put(new FileSystemPathAdapter());
		put(new URLAdapter());
		put(new PersistenceAdapter());
		put(new PersistenceIdAdapter());
		put(new ExpressionAdapter());
		put(new BooleanValueAdapter());
		put(new ByteValueAdapter());
		put(new ShortValueAdapter());
		put(new IntValueAdapter());
		put(new LongValueAdapter());
		put(new FloatValueAdapter());
		put(new DoubleValueAdapter());
		put(new CharValueAdapter());
		put(new StringValueAdapter());
		put(new FeatureNameAdapter());
		put(new FeatureValueAdapter());
		put(new URIAdapter());
		put(new NamespaceAdapter());
		put(new NameAdapter());
		put(new VersionAdapter());
		put(new CardinalityAdapter());
		put(new AnnotationsAdapter());
		put(new AnnotationAdapter());
		put(new DescriptionAdapter());
		put(new CategoriesAdapter());
		put(new StakeholdersAdapter());
		put(new PriorityAdapter());
		put(new BindingTimeAdapter());
		put(new CustomAnnotationAdapter());
	}
}
