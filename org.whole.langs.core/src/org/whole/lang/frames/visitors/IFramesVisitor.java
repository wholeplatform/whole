package org.whole.lang.frames.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.frames.model.*;

/** 
 * @generator Whole
 */
public interface IFramesVisitor extends IVisitor {
	public void visit(Frame entity);

	public void visit(Variants entity);

	public void visit(Empty entity);

	public void visit(Proceed entity);

	public void visit(InlineContent entity);

	public void visit(JoinPoint entity);

	public void visit(ConditionPoint entity);

	public void visit(IterationPoint entity);

	public void visit(SelectionPoint entity);

	public void visit(ReusePoint entity);

	public void visit(IncludePoint entity);

	public void visit(Relations entity);

	public void visit(Pointcut entity);

	public void visit(Require entity);

	public void visit(Exclude entity);

	public void visit(MutuallyRequire entity);

	public void visit(MutuallyExclude entity);

	public void visit(FeatureNames entity);

	public void visit(Advices entity);

	public void visit(Before entity);

	public void visit(After entity);

	public void visit(Into entity);

	public void visit(Around entity);

	public void visit(Features entity);

	public void visit(Subfeatures entity);

	public void visit(VariableFeatures entity);

	public void visit(SolitaryFeatures entity);

	public void visit(SubsetGroup entity);

	public void visit(CloneGroup entity);

	public void visit(VariableFeature entity);

	public void visit(Feature entity);

	public void visit(Attribute entity);

	public void visit(FeatureReference entity);

	public void visit(FeatureRename entity);

	public void visit(EntityType entity);

	public void visit(Domain entity);

	public void visit(VariableValue entity);

	public void visit(Resources entity);

	public void visit(Resource entity);

	public void visit(WorkspacePath entity);

	public void visit(FileSystemPath entity);

	public void visit(URL entity);

	public void visit(PersistenceId entity);

	public void visit(BooleanValue entity);

	public void visit(ByteValue entity);

	public void visit(ShortValue entity);

	public void visit(IntValue entity);

	public void visit(LongValue entity);

	public void visit(FloatValue entity);

	public void visit(DoubleValue entity);

	public void visit(CharValue entity);

	public void visit(StringValue entity);

	public void visit(FeatureName entity);

	public void visit(FeatureValue entity);

	public void visit(URI entity);

	public void visit(Namespace entity);

	public void visit(Name entity);

	public void visit(Version entity);

	public void visit(Cardinality entity);

	public void visit(Annotations entity);

	public void visit(Description entity);

	public void visit(Categories entity);

	public void visit(Stakeholders entity);

	public void visit(Priority entity);

	public void visit(BindingTime entity);

	public void visit(CustomAnnotation entity);
}
