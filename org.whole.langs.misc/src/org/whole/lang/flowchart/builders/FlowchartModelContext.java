package org.whole.lang.flowchart.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.flowchart.reflect.FlowchartFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FlowchartModelContext extends EntityContext {
	public FlowchartModelContext(IEntity root) {
		super(root);
	}

	public FlowchartModelContext getNodes() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.nodes);
	}

	public void setNodes(FlowchartModelContext nodes) {
		wSet(FlowchartFeatureDescriptorEnum.nodes, nodes);
	}

	public FlowchartModelContext getTransitions() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.transitions);
	}

	public void setTransitions(FlowchartModelContext transitions) {
		wSet(FlowchartFeatureDescriptorEnum.transitions, transitions);
	}

	public FlowchartModelContext getSource() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.source);
	}

	public void setSource(FlowchartModelContext source) {
		wSet(FlowchartFeatureDescriptorEnum.source, source);
	}

	public FlowchartModelContext getTarget() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.target);
	}

	public void setTarget(FlowchartModelContext target) {
		wSet(FlowchartFeatureDescriptorEnum.target, target);
	}

	public FlowchartModelContext getLabel() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.label);
	}

	public void setLabel(FlowchartModelContext label) {
		wSet(FlowchartFeatureDescriptorEnum.label, label);
	}

	public FlowchartModelContext getX() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.x);
	}

	public void setX(FlowchartModelContext x) {
		wSet(FlowchartFeatureDescriptorEnum.x, x);
	}

	public FlowchartModelContext getY() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.y);
	}

	public void setY(FlowchartModelContext y) {
		wSet(FlowchartFeatureDescriptorEnum.y, y);
	}

	public FlowchartModelContext getWidth() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.width);
	}

	public void setWidth(FlowchartModelContext width) {
		wSet(FlowchartFeatureDescriptorEnum.width, width);
	}

	public FlowchartModelContext getHeight() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.height);
	}

	public void setHeight(FlowchartModelContext height) {
		wSet(FlowchartFeatureDescriptorEnum.height, height);
	}

	public FlowchartModelContext getDescription() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.description);
	}

	public void setDescription(FlowchartModelContext description) {
		wSet(FlowchartFeatureDescriptorEnum.description, description);
	}

	public FlowchartModelContext getSourceTransition() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.sourceTransition);
	}

	public void setSourceTransition(FlowchartModelContext sourceTransition) {
		wSet(FlowchartFeatureDescriptorEnum.sourceTransition, sourceTransition);
	}

	public FlowchartModelContext getTargetTransition() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.targetTransition);
	}

	public void setTargetTransition(FlowchartModelContext targetTransition) {
		wSet(FlowchartFeatureDescriptorEnum.targetTransition, targetTransition);
	}

	public FlowchartModelContext getTrueSourceTransition() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.trueSourceTransition);
	}

	public void setTrueSourceTransition(
			FlowchartModelContext trueSourceTransition) {
		wSet(FlowchartFeatureDescriptorEnum.trueSourceTransition,
				trueSourceTransition);
	}

	public FlowchartModelContext getFalseSourceTransition() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.falseSourceTransition);
	}

	public void setFalseSourceTransition(
			FlowchartModelContext falseSourceTransition) {
		wSet(FlowchartFeatureDescriptorEnum.falseSourceTransition,
				falseSourceTransition);
	}

	public FlowchartModelContext getTargetTransitions() {
		return (FlowchartModelContext) wGet(FlowchartFeatureDescriptorEnum.targetTransitions);
	}

	public void setTargetTransitions(FlowchartModelContext targetTransitions) {
		wSet(FlowchartFeatureDescriptorEnum.targetTransitions,
				targetTransitions);
	}
}
