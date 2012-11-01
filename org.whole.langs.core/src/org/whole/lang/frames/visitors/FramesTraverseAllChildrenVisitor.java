package org.whole.lang.frames.visitors;

import org.whole.lang.frames.visitors.FramesIdentityUnaryVisitor;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class FramesTraverseAllChildrenVisitor extends
		FramesIdentityUnaryVisitor<IFramesVisitor> {
	public FramesTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public FramesTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Frame entity) {
		entity.getUri().accept(wGetVisitor1());
		entity.getNamespace().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getVersion().accept(wGetVisitor1());
		entity.getImports().accept(wGetVisitor1());
		entity.getVariability().accept(wGetVisitor1());
		entity.getRelations().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(Variants entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Proceed entity) {
		entity.getJoinpoints().accept(wGetVisitor1());
	}

	public void visit(InlineContent entity) {
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(JoinPoint entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(ConditionPoint entity) {
		entity.getEnabler().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(IterationPoint entity) {
		entity.getIterator().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(SelectionPoint entity) {
		entity.getSelector().accept(wGetVisitor1());
		entity.getVariants().accept(wGetVisitor1());
	}

	public void visit(ReusePoint entity) {
		entity.getFrame().accept(wGetVisitor1());
		entity.getConfiguration().accept(wGetVisitor1());
		entity.getRelations().accept(wGetVisitor1());
		entity.getAdvices().accept(wGetVisitor1());
	}

	public void visit(IncludePoint entity) {
		entity.getResource().accept(wGetVisitor1());
	}

	public void visit(Relations entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Pointcut entity) {
		entity.getFeature().accept(wGetVisitor1());
		entity.getJoinpoints().accept(wGetVisitor1());
	}

	public void visit(Require entity) {
		entity.getFeature().accept(wGetVisitor1());
		entity.getRequiredFeatures().accept(wGetVisitor1());
	}

	public void visit(Exclude entity) {
		entity.getFeature().accept(wGetVisitor1());
		entity.getExcludedFeatures().accept(wGetVisitor1());
	}

	public void visit(MutuallyRequire entity) {
		for (FeatureName child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(MutuallyExclude entity) {
		for (FeatureName child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(FeatureNames entity) {
		for (FeatureName child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(Advices entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Advice entity) {
		entity.getJoinpoints().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(Before entity) {
		entity.getJoinpoints().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(After entity) {
		entity.getJoinpoints().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(Into entity) {
		entity.getJoinpoints().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(Around entity) {
		entity.getJoinpoints().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(Features entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Subfeatures entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(VariableFeatures entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(SolitaryFeatures entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(SubsetGroup entity) {
		entity.getCardinality().accept(wGetVisitor1());
		entity.getFeatures().accept(wGetVisitor1());
	}

	public void visit(CloneGroup entity) {
		entity.getCardinality().accept(wGetVisitor1());
		entity.getFeatures().accept(wGetVisitor1());
	}

	public void visit(VariableFeature entity) {
		entity.getFeature().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
	}

	public void visit(SolitaryFeature entity) {
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(Feature entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getAnnotations().accept(wGetVisitor1());
		entity.getFeatures().accept(wGetVisitor1());
	}

	public void visit(Attribute entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getType().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
	}

	public void visit(FeatureReference entity) {
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(FeatureRename entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getNewName().accept(wGetVisitor1());
	}

	public void visit(Resources entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Resource entity) {
		entity.getUri().accept(wGetVisitor1());
		entity.getLocation().accept(wGetVisitor1());
		entity.getPersistence().accept(wGetVisitor1());
	}

	public void visit(Cardinality entity) {
		entity.getMin().accept(wGetVisitor1());
		entity.getMax().accept(wGetVisitor1());
	}

	public void visit(Annotations entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Categories entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Stakeholders entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(CustomAnnotation entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
	}
}
