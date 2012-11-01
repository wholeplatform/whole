package org.whole.lang.unifiedlambdadelta.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.unifiedlambdadelta.visitors.IUnifiedLambdaDeltaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class DefinitionAdapter extends AbstractEntityAdapter implements
		Definition {
	private static final long serialVersionUID = 1;

	public DefinitionAdapter(IEntity implementor) {
		super(implementor);
	}

	public DefinitionAdapter() {
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Definition> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Definition;
	}

	public Polarity getPolarity() {
		return wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity)
				.wGetAdapter(UnifiedLambdaDeltaEntityDescriptorEnum.Polarity);
	}

	public void setPolarity(Polarity polarity) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity, polarity);
	}

	public Term getFront() {
		return wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.front).wGetAdapter(
				UnifiedLambdaDeltaEntityDescriptorEnum.Term);
	}

	public void setFront(Term front) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.front, front);
	}

	public Name getName() {
		return wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.name).wGetAdapter(
				UnifiedLambdaDeltaEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.name, name);
	}

	public Context getBack() {
		return wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.back).wGetAdapter(
				UnifiedLambdaDeltaEntityDescriptorEnum.Context);
	}

	public void setBack(Context back) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.back, back);
	}
}
