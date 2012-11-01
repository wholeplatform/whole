package org.whole.lang.frames.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FramesImplEntityRegistry extends AbstractEntityRegistry {
	public FramesImplEntityRegistry() {
		super(FramesEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new FrameImpl());
		put(new VariantsImpl());
		put(new EmptyImpl());
		put(new ProceedImpl());
		put(new InlineContentImpl());
		put(new JoinPointImpl());
		put(new ConditionPointImpl());
		put(new IterationPointImpl());
		put(new SelectionPointImpl());
		put(new ReusePointImpl());
		put(new IncludePointImpl());
		put(new RelationsImpl());
		put(new PointcutImpl());
		put(new RequireImpl());
		put(new ExcludeImpl());
		put(new MutuallyRequireImpl());
		put(new MutuallyExcludeImpl());
		put(new FeatureNamesImpl());
		put(new AdvicesImpl());
		put(new BeforeImpl());
		put(new AfterImpl());
		put(new IntoImpl());
		put(new AroundImpl());
		put(new FeaturesImpl());
		put(new SubfeaturesImpl());
		put(new VariableFeaturesImpl());
		put(new SolitaryFeaturesImpl());
		put(new SubsetGroupImpl());
		put(new CloneGroupImpl());
		put(new VariableFeatureImpl());
		put(new FeatureImpl());
		put(new AttributeImpl());
		put(new FeatureReferenceImpl());
		put(new FeatureRenameImpl());
		put(new EntityTypeImpl());
		put(new DomainImpl());
		put(new VariableValueImpl());
		put(new ResourcesImpl());
		put(new ResourceImpl());
		put(new WorkspacePathImpl());
		put(new FileSystemPathImpl());
		put(new URLImpl());
		put(new PersistenceIdImpl());
		put(new BooleanValueImpl());
		put(new ByteValueImpl());
		put(new ShortValueImpl());
		put(new IntValueImpl());
		put(new LongValueImpl());
		put(new FloatValueImpl());
		put(new DoubleValueImpl());
		put(new CharValueImpl());
		put(new StringValueImpl());
		put(new FeatureNameImpl());
		put(new FeatureValueImpl());
		put(new URIImpl());
		put(new NamespaceImpl());
		put(new NameImpl());
		put(new VersionImpl());
		put(new CardinalityImpl());
		put(new AnnotationsImpl());
		put(new DescriptionImpl());
		put(new CategoriesImpl());
		put(new StakeholdersImpl());
		put(new PriorityImpl());
		put(new BindingTimeImpl());
		put(new CustomAnnotationImpl());
	}
}
