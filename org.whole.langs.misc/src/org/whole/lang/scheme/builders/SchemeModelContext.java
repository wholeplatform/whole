package org.whole.lang.scheme.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.scheme.reflect.SchemeFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class SchemeModelContext extends EntityContext {
	public SchemeModelContext(IEntity root) {
		super(root);
	}

	public SchemeModelContext getName() {
		return (SchemeModelContext) wGet(SchemeFeatureDescriptorEnum.name);
	}

	public void setName(SchemeModelContext name) {
		wSet(SchemeFeatureDescriptorEnum.name, name);
	}

	public SchemeModelContext getExpression() {
		return (SchemeModelContext) wGet(SchemeFeatureDescriptorEnum.expression);
	}

	public void setExpression(SchemeModelContext expression) {
		wSet(SchemeFeatureDescriptorEnum.expression, expression);
	}

	public SchemeModelContext getTest() {
		return (SchemeModelContext) wGet(SchemeFeatureDescriptorEnum.test);
	}

	public void setTest(SchemeModelContext test) {
		wSet(SchemeFeatureDescriptorEnum.test, test);
	}

	public SchemeModelContext getBody() {
		return (SchemeModelContext) wGet(SchemeFeatureDescriptorEnum.body);
	}

	public void setBody(SchemeModelContext body) {
		wSet(SchemeFeatureDescriptorEnum.body, body);
	}

	public SchemeModelContext getExpressions() {
		return (SchemeModelContext) wGet(SchemeFeatureDescriptorEnum.expressions);
	}

	public void setExpressions(SchemeModelContext expressions) {
		wSet(SchemeFeatureDescriptorEnum.expressions, expressions);
	}

	public SchemeModelContext getArgs() {
		return (SchemeModelContext) wGet(SchemeFeatureDescriptorEnum.args);
	}

	public void setArgs(SchemeModelContext args) {
		wSet(SchemeFeatureDescriptorEnum.args, args);
	}

	public SchemeModelContext getBranches() {
		return (SchemeModelContext) wGet(SchemeFeatureDescriptorEnum.branches);
	}

	public void setBranches(SchemeModelContext branches) {
		wSet(SchemeFeatureDescriptorEnum.branches, branches);
	}

	public SchemeModelContext getElseBody() {
		return (SchemeModelContext) wGet(SchemeFeatureDescriptorEnum.elseBody);
	}

	public void setElseBody(SchemeModelContext elseBody) {
		wSet(SchemeFeatureDescriptorEnum.elseBody, elseBody);
	}

	public SchemeModelContext getDefinitions() {
		return (SchemeModelContext) wGet(SchemeFeatureDescriptorEnum.definitions);
	}

	public void setDefinitions(SchemeModelContext definitions) {
		wSet(SchemeFeatureDescriptorEnum.definitions, definitions);
	}

	public SchemeModelContext getEnv() {
		return (SchemeModelContext) wGet(SchemeFeatureDescriptorEnum.env);
	}

	public void setEnv(SchemeModelContext env) {
		wSet(SchemeFeatureDescriptorEnum.env, env);
	}

	public SchemeModelContext getCar() {
		return (SchemeModelContext) wGet(SchemeFeatureDescriptorEnum.car);
	}

	public void setCar(SchemeModelContext car) {
		wSet(SchemeFeatureDescriptorEnum.car, car);
	}

	public SchemeModelContext getCdr() {
		return (SchemeModelContext) wGet(SchemeFeatureDescriptorEnum.cdr);
	}

	public void setCdr(SchemeModelContext cdr) {
		wSet(SchemeFeatureDescriptorEnum.cdr, cdr);
	}
}
