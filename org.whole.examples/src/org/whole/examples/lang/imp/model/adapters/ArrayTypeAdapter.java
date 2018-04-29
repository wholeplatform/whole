package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ArrayTypeAdapter extends AbstractEntityAdapter implements ArrayType {
	private static final long serialVersionUID = 1;

	public ArrayTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArrayTypeAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArrayType> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.ArrayType;
	}

	public Type getContentType() {
		return wGet(ImpFeatureDescriptorEnum.contentType).wGetAdapter(ImpEntityDescriptorEnum.Type);
	}

	public void setContentType(Type contentType) {
		wSet(ImpFeatureDescriptorEnum.contentType, contentType);
	}

	public PrimitiveType getIndexType() {
		return wGet(ImpFeatureDescriptorEnum.indexType).wGetAdapter(ImpEntityDescriptorEnum.PrimitiveType);
	}

	public void setIndexType(PrimitiveType indexType) {
		wSet(ImpFeatureDescriptorEnum.indexType, indexType);
	}
}
