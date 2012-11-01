package org.whole.lang.unifiedlambdadelta.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaModelContext extends EntityContext {
	public UnifiedLambdaDeltaModelContext(IEntity root) {
		super(root);
	}

	public UnifiedLambdaDeltaModelContext getName() {
		return (UnifiedLambdaDeltaModelContext) wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.name);
	}

	public void setName(UnifiedLambdaDeltaModelContext name) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.name, name);
	}

	public UnifiedLambdaDeltaModelContext getPolarity() {
		return (UnifiedLambdaDeltaModelContext) wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity);
	}

	public void setPolarity(UnifiedLambdaDeltaModelContext polarity) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity, polarity);
	}

	public UnifiedLambdaDeltaModelContext getFront() {
		return (UnifiedLambdaDeltaModelContext) wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.front);
	}

	public void setFront(UnifiedLambdaDeltaModelContext front) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.front, front);
	}

	public UnifiedLambdaDeltaModelContext getBack() {
		return (UnifiedLambdaDeltaModelContext) wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.back);
	}

	public void setBack(UnifiedLambdaDeltaModelContext back) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.back, back);
	}

	public UnifiedLambdaDeltaModelContext getIndex() {
		return (UnifiedLambdaDeltaModelContext) wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.index);
	}

	public void setIndex(UnifiedLambdaDeltaModelContext index) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.index, index);
	}

	public UnifiedLambdaDeltaModelContext getLevel() {
		return (UnifiedLambdaDeltaModelContext) wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.level);
	}

	public void setLevel(UnifiedLambdaDeltaModelContext level) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.level, level);
	}

	public UnifiedLambdaDeltaModelContext getAccess() {
		return (UnifiedLambdaDeltaModelContext) wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.access);
	}

	public void setAccess(UnifiedLambdaDeltaModelContext access) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.access, access);
	}

	public UnifiedLambdaDeltaModelContext getPrefix() {
		return (UnifiedLambdaDeltaModelContext) wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.prefix);
	}

	public void setPrefix(UnifiedLambdaDeltaModelContext prefix) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.prefix, prefix);
	}

	public UnifiedLambdaDeltaModelContext getPostfix() {
		return (UnifiedLambdaDeltaModelContext) wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.postfix);
	}

	public void setPostfix(UnifiedLambdaDeltaModelContext postfix) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.postfix, postfix);
	}
}
