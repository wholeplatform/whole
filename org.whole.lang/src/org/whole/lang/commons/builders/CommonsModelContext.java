package org.whole.lang.commons.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class CommonsModelContext extends EntityContext {
	public CommonsModelContext(IEntity root) {
		super(root);
	}

	public CommonsModelContext getRootEntity() {
		return (CommonsModelContext) wGet(CommonsFeatureDescriptorEnum.rootEntity);
	}

	public void setRootEntity(CommonsModelContext rootEntity) {
		wSet(CommonsFeatureDescriptorEnum.rootEntity, rootEntity);
	}

	public CommonsModelContext getPhase() {
		return (CommonsModelContext) wGet(CommonsFeatureDescriptorEnum.phase);
	}

	public void setPhase(CommonsModelContext phase) {
		wSet(CommonsFeatureDescriptorEnum.phase, phase);
	}

	public CommonsModelContext getVarType() {
		return (CommonsModelContext) wGet(CommonsFeatureDescriptorEnum.varType);
	}

	public void setVarType(CommonsModelContext varType) {
		wSet(CommonsFeatureDescriptorEnum.varType, varType);
	}

	public CommonsModelContext getVarName() {
		return (CommonsModelContext) wGet(CommonsFeatureDescriptorEnum.varName);
	}

	public void setVarName(CommonsModelContext varName) {
		wSet(CommonsFeatureDescriptorEnum.varName, varName);
	}

	public CommonsModelContext getQuantifier() {
		return (CommonsModelContext) wGet(CommonsFeatureDescriptorEnum.quantifier);
	}

	public void setQuantifier(CommonsModelContext quantifier) {
		wSet(CommonsFeatureDescriptorEnum.quantifier, quantifier);
	}
}
