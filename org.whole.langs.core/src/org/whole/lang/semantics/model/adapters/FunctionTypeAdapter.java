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
public class FunctionTypeAdapter extends AbstractEntityAdapter implements
		FunctionType {
	private static final long serialVersionUID = 1;

	public FunctionTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public FunctionTypeAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FunctionType> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.FunctionType;
	}

	public SignatureOrSequence getSource() {
		return wGet(SemanticsFeatureDescriptorEnum.source).wGetAdapter(
				SemanticsEntityDescriptorEnum.SignatureOrSequence);
	}

	public void setSource(SignatureOrSequence source) {
		wSet(SemanticsFeatureDescriptorEnum.source, source);
	}

	public SignatureOrSequence getTarget() {
		return wGet(SemanticsFeatureDescriptorEnum.target).wGetAdapter(
				SemanticsEntityDescriptorEnum.SignatureOrSequence);
	}

	public void setTarget(SignatureOrSequence target) {
		wSet(SemanticsFeatureDescriptorEnum.target, target);
	}
}
