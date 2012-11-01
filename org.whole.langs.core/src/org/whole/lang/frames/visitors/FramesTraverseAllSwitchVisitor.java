package org.whole.lang.frames.visitors;

import org.whole.lang.frames.visitors.FramesIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.frames.model.*;

/** 
 * @generator Whole
 */
public class FramesTraverseAllSwitchVisitor extends
		FramesIdentityUnaryVisitor<IVisitor> {
	public FramesTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Frame entity) {
		wGetVisitor1().visit(entity.getUri());
		wGetVisitor1().visit(entity.getNamespace());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getVersion());
		wGetVisitor1().visit(entity.getImports());
		wGetVisitor1().visit(entity.getVariability());
		wGetVisitor1().visit(entity.getRelations());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(Variants entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Proceed entity) {
		wGetVisitor1().visit(entity.getJoinpoints());
	}

	public void visit(InlineContent entity) {
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(JoinPoint entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(ConditionPoint entity) {
		wGetVisitor1().visit(entity.getEnabler());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(IterationPoint entity) {
		wGetVisitor1().visit(entity.getIterator());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(SelectionPoint entity) {
		wGetVisitor1().visit(entity.getSelector());
		wGetVisitor1().visit(entity.getVariants());
	}

	public void visit(ReusePoint entity) {
		wGetVisitor1().visit(entity.getFrame());
		wGetVisitor1().visit(entity.getConfiguration());
		wGetVisitor1().visit(entity.getRelations());
		wGetVisitor1().visit(entity.getAdvices());
	}

	public void visit(IncludePoint entity) {
		wGetVisitor1().visit(entity.getResource());
	}

	public void visit(Relations entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Pointcut entity) {
		wGetVisitor1().visit(entity.getFeature());
		wGetVisitor1().visit(entity.getJoinpoints());
	}

	public void visit(Require entity) {
		wGetVisitor1().visit(entity.getFeature());
		wGetVisitor1().visit(entity.getRequiredFeatures());
	}

	public void visit(Exclude entity) {
		wGetVisitor1().visit(entity.getFeature());
		wGetVisitor1().visit(entity.getExcludedFeatures());
	}

	public void visit(MutuallyRequire entity) {
		for (FeatureName child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(MutuallyExclude entity) {
		for (FeatureName child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(FeatureNames entity) {
		for (FeatureName child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(Advices entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Advice entity) {
		wGetVisitor1().visit(entity.getJoinpoints());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(Before entity) {
		wGetVisitor1().visit(entity.getJoinpoints());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(After entity) {
		wGetVisitor1().visit(entity.getJoinpoints());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(Into entity) {
		wGetVisitor1().visit(entity.getJoinpoints());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(Around entity) {
		wGetVisitor1().visit(entity.getJoinpoints());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(Features entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Subfeatures entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(VariableFeatures entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(SolitaryFeatures entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(SubsetGroup entity) {
		wGetVisitor1().visit(entity.getCardinality());
		wGetVisitor1().visit(entity.getFeatures());
	}

	public void visit(CloneGroup entity) {
		wGetVisitor1().visit(entity.getCardinality());
		wGetVisitor1().visit(entity.getFeatures());
	}

	public void visit(VariableFeature entity) {
		wGetVisitor1().visit(entity.getFeature());
		wGetVisitor1().visit(entity.getValue());
	}

	public void visit(SolitaryFeature entity) {
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(Feature entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getAnnotations());
		wGetVisitor1().visit(entity.getFeatures());
	}

	public void visit(Attribute entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getValue());
	}

	public void visit(FeatureReference entity) {
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(FeatureRename entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getNewName());
	}

	public void visit(Resources entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Resource entity) {
		wGetVisitor1().visit(entity.getUri());
		wGetVisitor1().visit(entity.getLocation());
		wGetVisitor1().visit(entity.getPersistence());
	}

	public void visit(Cardinality entity) {
		wGetVisitor1().visit(entity.getMin());
		wGetVisitor1().visit(entity.getMax());
	}

	public void visit(Annotations entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Categories entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Stakeholders entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(CustomAnnotation entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getValue());
	}
}
