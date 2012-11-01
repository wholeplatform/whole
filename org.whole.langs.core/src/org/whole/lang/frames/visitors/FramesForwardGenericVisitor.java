package org.whole.lang.frames.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FramesForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor>
		implements IFramesVisitor {
	public FramesForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Frame entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Variants entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Empty entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Proceed entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InlineContent entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(JoinPoint entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ConditionPoint entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IterationPoint entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SelectionPoint entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ReusePoint entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IncludePoint entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Relations entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Pointcut entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Require entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Exclude entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MutuallyRequire entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MutuallyExclude entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FeatureNames entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Advices entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Before entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(After entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Into entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Around entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Features entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Subfeatures entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VariableFeatures entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SolitaryFeatures entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SubsetGroup entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CloneGroup entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VariableFeature entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Feature entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Attribute entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FeatureReference entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FeatureRename entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EntityType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Domain entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VariableValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Resources entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Resource entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(WorkspacePath entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FileSystemPath entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(URL entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PersistenceId entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BooleanValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ByteValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ShortValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IntValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LongValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FloatValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DoubleValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CharValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StringValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FeatureName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FeatureValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(URI entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Namespace entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Name entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Version entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Cardinality entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Annotations entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Description entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Categories entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Stakeholders entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Priority entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BindingTime entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CustomAnnotation entity) {
		wGetVisitor1().visit(entity);
	}
}
