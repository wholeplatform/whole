package org.whole.examples.lang.imp.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ImpModelContext extends EntityContext {
	public ImpModelContext(IEntity root) {
		super(root);
	}

	public ImpModelContext getType() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.type);
	}

	public void setType(ImpModelContext type) {
		wSet(ImpFeatureDescriptorEnum.type, type);
	}

	public ImpModelContext getName() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.name);
	}

	public void setName(ImpModelContext name) {
		wSet(ImpFeatureDescriptorEnum.name, name);
	}

	public ImpModelContext getParameters() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.parameters);
	}

	public void setParameters(ImpModelContext parameters) {
		wSet(ImpFeatureDescriptorEnum.parameters, parameters);
	}

	public ImpModelContext getBody() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.body);
	}

	public void setBody(ImpModelContext body) {
		wSet(ImpFeatureDescriptorEnum.body, body);
	}

	public ImpModelContext getInitializer() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.initializer);
	}

	public void setInitializer(ImpModelContext initializer) {
		wSet(ImpFeatureDescriptorEnum.initializer, initializer);
	}

	public ImpModelContext getExp() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.exp);
	}

	public void setExp(ImpModelContext exp) {
		wSet(ImpFeatureDescriptorEnum.exp, exp);
	}

	public ImpModelContext getCondition() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.condition);
	}

	public void setCondition(ImpModelContext condition) {
		wSet(ImpFeatureDescriptorEnum.condition, condition);
	}

	public ImpModelContext getTrueBody() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.trueBody);
	}

	public void setTrueBody(ImpModelContext trueBody) {
		wSet(ImpFeatureDescriptorEnum.trueBody, trueBody);
	}

	public ImpModelContext getFalseBody() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.falseBody);
	}

	public void setFalseBody(ImpModelContext falseBody) {
		wSet(ImpFeatureDescriptorEnum.falseBody, falseBody);
	}

	public ImpModelContext getUpdater() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.updater);
	}

	public void setUpdater(ImpModelContext updater) {
		wSet(ImpFeatureDescriptorEnum.updater, updater);
	}

	public ImpModelContext getArrayExp() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.arrayExp);
	}

	public void setArrayExp(ImpModelContext arrayExp) {
		wSet(ImpFeatureDescriptorEnum.arrayExp, arrayExp);
	}

	public ImpModelContext getFileName() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.fileName);
	}

	public void setFileName(ImpModelContext fileName) {
		wSet(ImpFeatureDescriptorEnum.fileName, fileName);
	}

	public ImpModelContext getLanguage() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.language);
	}

	public void setLanguage(ImpModelContext language) {
		wSet(ImpFeatureDescriptorEnum.language, language);
	}

	public ImpModelContext getArguments() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.arguments);
	}

	public void setArguments(ImpModelContext arguments) {
		wSet(ImpFeatureDescriptorEnum.arguments, arguments);
	}

	public ImpModelContext getLowerBound() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.lowerBound);
	}

	public void setLowerBound(ImpModelContext lowerBound) {
		wSet(ImpFeatureDescriptorEnum.lowerBound, lowerBound);
	}

	public ImpModelContext getUpperBound() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.upperBound);
	}

	public void setUpperBound(ImpModelContext upperBound) {
		wSet(ImpFeatureDescriptorEnum.upperBound, upperBound);
	}

	public ImpModelContext getContentType() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.contentType);
	}

	public void setContentType(ImpModelContext contentType) {
		wSet(ImpFeatureDescriptorEnum.contentType, contentType);
	}

	public ImpModelContext getIndexType() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.indexType);
	}

	public void setIndexType(ImpModelContext indexType) {
		wSet(ImpFeatureDescriptorEnum.indexType, indexType);
	}

	public ImpModelContext getArray() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.array);
	}

	public void setArray(ImpModelContext array) {
		wSet(ImpFeatureDescriptorEnum.array, array);
	}

	public ImpModelContext getIndex() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.index);
	}

	public void setIndex(ImpModelContext index) {
		wSet(ImpFeatureDescriptorEnum.index, index);
	}

	public ImpModelContext getExp1() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.exp1);
	}

	public void setExp1(ImpModelContext exp1) {
		wSet(ImpFeatureDescriptorEnum.exp1, exp1);
	}

	public ImpModelContext getExp2() {
		return (ImpModelContext) wGet(ImpFeatureDescriptorEnum.exp2);
	}

	public void setExp2(ImpModelContext exp2) {
		wSet(ImpFeatureDescriptorEnum.exp2, exp2);
	}
}
