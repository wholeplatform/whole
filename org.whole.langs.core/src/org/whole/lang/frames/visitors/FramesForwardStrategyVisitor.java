package org.whole.lang.frames.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FramesForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IFramesVisitor> implements IFramesVisitor {
	public FramesForwardStrategyVisitor() {
		this(new FramesIdentityVisitor());
	}

	public FramesForwardStrategyVisitor(IFramesVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IFramesEntity) entity).accept(this);
	}

	public void visit(Frame entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Variants entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Empty entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Proceed entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(InlineContent entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(JoinPoint entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ConditionPoint entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IterationPoint entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SelectionPoint entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ReusePoint entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IncludePoint entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Relations entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Pointcut entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Require entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Exclude entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MutuallyRequire entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MutuallyExclude entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FeatureNames entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Advices entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Before entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(After entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Into entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Around entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Features entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Subfeatures entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VariableFeatures entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SolitaryFeatures entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SubsetGroup entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CloneGroup entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VariableFeature entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Feature entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Attribute entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FeatureReference entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FeatureRename entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EntityType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Domain entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VariableValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Resources entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Resource entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(WorkspacePath entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FileSystemPath entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(URL entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PersistenceId entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BooleanValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ByteValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ShortValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IntValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LongValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FloatValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DoubleValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CharValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StringValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FeatureName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FeatureValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(URI entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Namespace entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Name entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Version entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Cardinality entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Annotations entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Description entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Categories entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Stakeholders entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Priority entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BindingTime entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CustomAnnotation entity) {
		wGetStrategy().visit(entity);
	}
}
