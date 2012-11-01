package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class SemanticFunctionAdapter extends AbstractEntityAdapter implements
		SemanticFunction {
	private static final long serialVersionUID = 1;

	public SemanticFunctionAdapter(IEntity implementor) {
		super(implementor);
	}

	public SemanticFunctionAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SemanticFunction> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.SemanticFunction;
	}

	public Name getName() {
		return wGet(SemanticsFeatureDescriptorEnum.name).wGetAdapter(
				SemanticsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(SemanticsFeatureDescriptorEnum.name, name);
	}

	public FunctionType getSignature() {
		return wGet(SemanticsFeatureDescriptorEnum.signature).wGetAdapter(
				SemanticsEntityDescriptorEnum.FunctionType);
	}

	public void setSignature(FunctionType signature) {
		wSet(SemanticsFeatureDescriptorEnum.signature, signature);
	}

	public FunctionBody getRules() {
		return wGet(SemanticsFeatureDescriptorEnum.rules).wGetAdapter(
				SemanticsEntityDescriptorEnum.FunctionBody);
	}

	public void setRules(FunctionBody rules) {
		wSet(SemanticsFeatureDescriptorEnum.rules, rules);
	}
}
