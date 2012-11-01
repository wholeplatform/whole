package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.reflect.MathFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class StreamAdapter extends AbstractEntityAdapter implements Stream {
	private static final long serialVersionUID = 1;

	public StreamAdapter(IEntity implementor) {
		super(implementor);
	}

	public StreamAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Stream> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Stream;
	}

	public Constructor getElements() {
		return wGet(MathFeatureDescriptorEnum.elements).wGetAdapter(
				MathEntityDescriptorEnum.Constructor);
	}

	public void setElements(Constructor elements) {
		wSet(MathFeatureDescriptorEnum.elements, elements);
	}
}
