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
public class SequenceTypeAdapter extends AbstractEntityAdapter implements
		SequenceType {
	private static final long serialVersionUID = 1;

	public SequenceTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public SequenceTypeAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SequenceType> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.SequenceType;
	}

	public Signature getSignature() {
		return wGet(SemanticsFeatureDescriptorEnum.signature).wGetAdapter(
				SemanticsEntityDescriptorEnum.Signature);
	}

	public void setSignature(Signature signature) {
		wSet(SemanticsFeatureDescriptorEnum.signature, signature);
	}
}
