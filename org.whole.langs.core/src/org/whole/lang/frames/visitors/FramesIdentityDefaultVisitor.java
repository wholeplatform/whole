package org.whole.lang.frames.visitors;

import org.whole.lang.frames.model.*;

/** 
 * @generator Whole
 */
public class FramesIdentityDefaultVisitor extends FramesIdentityVisitor {
	public void visit(IFramesEntity entity) {
	}

	public void visit(Frame entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(Variants entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(Content entity) {
	}

	public void visit(Empty entity) {
		visit((IFramesEntity) entity);
		visit((Content) entity);
	}

	public void visit(Proceed entity) {
		visit((IFramesEntity) entity);
		visit((Content) entity);
	}

	public void visit(InlineContent entity) {
		visit((IFramesEntity) entity);
		visit((Content) entity);
	}

	public void visit(VariationPoint entity) {
		visit((Content) entity);
	}

	public void visit(JoinPoint entity) {
		visit((IFramesEntity) entity);
		visit((VariationPoint) entity);
	}

	public void visit(ConditionPoint entity) {
		visit((IFramesEntity) entity);
		visit((VariationPoint) entity);
	}

	public void visit(IterationPoint entity) {
		visit((IFramesEntity) entity);
		visit((VariationPoint) entity);
	}

	public void visit(SelectionPoint entity) {
		visit((IFramesEntity) entity);
		visit((VariationPoint) entity);
	}

	public void visit(ReusePoint entity) {
		visit((IFramesEntity) entity);
		visit((VariationPoint) entity);
	}

	public void visit(IncludePoint entity) {
		visit((IFramesEntity) entity);
		visit((VariationPoint) entity);
	}

	public void visit(Relations entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(Relation entity) {
	}

	public void visit(Pointcut entity) {
		visit((IFramesEntity) entity);
		visit((Relation) entity);
	}

	public void visit(Require entity) {
		visit((IFramesEntity) entity);
		visit((Relation) entity);
	}

	public void visit(Exclude entity) {
		visit((IFramesEntity) entity);
		visit((Relation) entity);
	}

	public void visit(MutuallyRequire entity) {
		visit((IFramesEntity) entity);
		visit((Relation) entity);
	}

	public void visit(MutuallyExclude entity) {
		visit((IFramesEntity) entity);
		visit((Relation) entity);
	}

	public void visit(FeatureNames entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(Advices entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(Advice entity) {
	}

	public void visit(Before entity) {
		visit((IFramesEntity) entity);
		visit((Advice) entity);
	}

	public void visit(After entity) {
		visit((IFramesEntity) entity);
		visit((Advice) entity);
	}

	public void visit(Into entity) {
		visit((IFramesEntity) entity);
		visit((Advice) entity);
	}

	public void visit(Around entity) {
		visit((IFramesEntity) entity);
		visit((Advice) entity);
	}

	public void visit(Features entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(Subfeatures entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(VariableFeatures entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(SolitaryFeatures entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(Subfeature entity) {
	}

	public void visit(SubsetGroup entity) {
		visit((IFramesEntity) entity);
		visit((Subfeature) entity);
	}

	public void visit(CloneGroup entity) {
		visit((IFramesEntity) entity);
		visit((Subfeature) entity);
	}

	public void visit(VariableFeature entity) {
		visit((IFramesEntity) entity);
		visit((Subfeature) entity);
	}

	public void visit(SolitaryFeature entity) {
		visit((Subfeature) entity);
	}

	public void visit(Feature entity) {
		visit((IFramesEntity) entity);
		visit((SolitaryFeature) entity);
		visit((JoinpointExpression) entity);
	}

	public void visit(JoinpointExpression entity) {
	}

	public void visit(Attribute entity) {
		visit((IFramesEntity) entity);
		visit((SolitaryFeature) entity);
	}

	public void visit(FeatureReference entity) {
		visit((IFramesEntity) entity);
		visit((SolitaryFeature) entity);
	}

	public void visit(SolitaryFeatureName entity) {
	}

	public void visit(FeatureRename entity) {
		visit((IFramesEntity) entity);
		visit((SolitaryFeatureName) entity);
	}

	public void visit(Type entity) {
	}

	public void visit(EntityType entity) {
		visit((IFramesEntity) entity);
		visit((Type) entity);
	}

	public void visit(Domain entity) {
		visit((IFramesEntity) entity);
		visit((Type) entity);
	}

	public void visit(VariableValue entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(Resources entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(ResourceIdentifier entity) {
	}

	public void visit(Resource entity) {
		visit((IFramesEntity) entity);
		visit((ResourceIdentifier) entity);
	}

	public void visit(Location entity) {
	}

	public void visit(WorkspacePath entity) {
		visit((IFramesEntity) entity);
		visit((Location) entity);
	}

	public void visit(FileSystemPath entity) {
		visit((IFramesEntity) entity);
		visit((Location) entity);
	}

	public void visit(URL entity) {
		visit((IFramesEntity) entity);
		visit((Location) entity);
	}

	public void visit(Persistence entity) {
	}

	public void visit(PersistenceId entity) {
		visit((IFramesEntity) entity);
		visit((Persistence) entity);
	}

	public void visit(Expression entity) {
	}

	public void visit(BooleanValue entity) {
		visit((IFramesEntity) entity);
		visit((Expression) entity);
	}

	public void visit(ByteValue entity) {
		visit((IFramesEntity) entity);
		visit((Expression) entity);
	}

	public void visit(ShortValue entity) {
		visit((IFramesEntity) entity);
		visit((Expression) entity);
	}

	public void visit(IntValue entity) {
		visit((IFramesEntity) entity);
		visit((Expression) entity);
	}

	public void visit(LongValue entity) {
		visit((IFramesEntity) entity);
		visit((Expression) entity);
	}

	public void visit(FloatValue entity) {
		visit((IFramesEntity) entity);
		visit((Expression) entity);
	}

	public void visit(DoubleValue entity) {
		visit((IFramesEntity) entity);
		visit((Expression) entity);
	}

	public void visit(CharValue entity) {
		visit((IFramesEntity) entity);
		visit((Expression) entity);
	}

	public void visit(StringValue entity) {
		visit((IFramesEntity) entity);
		visit((Expression) entity);
	}

	public void visit(FeatureName entity) {
		visit((IFramesEntity) entity);
		visit((Expression) entity);
		visit((SolitaryFeatureName) entity);
	}

	public void visit(FeatureValue entity) {
		visit((IFramesEntity) entity);
		visit((Expression) entity);
	}

	public void visit(URI entity) {
		visit((IFramesEntity) entity);
		visit((ResourceIdentifier) entity);
	}

	public void visit(Namespace entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(Name entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(Version entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(Cardinality entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(Annotations entity) {
		visit((IFramesEntity) entity);
	}

	public void visit(Annotation entity) {
	}

	public void visit(Description entity) {
		visit((IFramesEntity) entity);
		visit((Annotation) entity);
	}

	public void visit(Categories entity) {
		visit((IFramesEntity) entity);
		visit((Annotation) entity);
	}

	public void visit(Stakeholders entity) {
		visit((IFramesEntity) entity);
		visit((Annotation) entity);
	}

	public void visit(Priority entity) {
		visit((IFramesEntity) entity);
		visit((Annotation) entity);
	}

	public void visit(BindingTime entity) {
		visit((IFramesEntity) entity);
		visit((Annotation) entity);
	}

	public void visit(CustomAnnotation entity) {
		visit((IFramesEntity) entity);
		visit((Annotation) entity);
	}
}
