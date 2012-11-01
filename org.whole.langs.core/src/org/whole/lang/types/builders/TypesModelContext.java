package org.whole.lang.types.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.reflect.TypesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class TypesModelContext extends EntityContext {
	public TypesModelContext(IEntity root) {
		super(root);
	}

	public TypesModelContext getCheckBefore() {
		return (TypesModelContext) wGet(TypesFeatureDescriptorEnum.checkBefore);
	}

	public void setCheckBefore(TypesModelContext checkBefore) {
		wSet(TypesFeatureDescriptorEnum.checkBefore, checkBefore);
	}

	public TypesModelContext getRules() {
		return (TypesModelContext) wGet(TypesFeatureDescriptorEnum.rules);
	}

	public void setRules(TypesModelContext rules) {
		wSet(TypesFeatureDescriptorEnum.rules, rules);
	}

	public TypesModelContext getDomain() {
		return (TypesModelContext) wGet(TypesFeatureDescriptorEnum.domain);
	}

	public void setDomain(TypesModelContext domain) {
		wSet(TypesFeatureDescriptorEnum.domain, domain);
	}

	public TypesModelContext getType() {
		return (TypesModelContext) wGet(TypesFeatureDescriptorEnum.type);
	}

	public void setType(TypesModelContext type) {
		wSet(TypesFeatureDescriptorEnum.type, type);
	}

	public TypesModelContext getArguments() {
		return (TypesModelContext) wGet(TypesFeatureDescriptorEnum.arguments);
	}

	public void setArguments(TypesModelContext arguments) {
		wSet(TypesFeatureDescriptorEnum.arguments, arguments);
	}

	public TypesModelContext getCases() {
		return (TypesModelContext) wGet(TypesFeatureDescriptorEnum.cases);
	}

	public void setCases(TypesModelContext cases) {
		wSet(TypesFeatureDescriptorEnum.cases, cases);
	}

	public TypesModelContext getExpressions() {
		return (TypesModelContext) wGet(TypesFeatureDescriptorEnum.expressions);
	}

	public void setExpressions(TypesModelContext expressions) {
		wSet(TypesFeatureDescriptorEnum.expressions, expressions);
	}

	public TypesModelContext getName() {
		return (TypesModelContext) wGet(TypesFeatureDescriptorEnum.name);
	}

	public void setName(TypesModelContext name) {
		wSet(TypesFeatureDescriptorEnum.name, name);
	}
}
