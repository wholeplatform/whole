package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class BlockCommentImpl extends AbstractSimpleEntity implements
		BlockComment {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<BlockComment> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.BlockComment;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.BlockComment_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private DocElements docElements;

	public DocElements getDocElements() {
		return notifyRequested(JavaFeatureDescriptorEnum.docElements,
				docElements);
	}

	public void setDocElements(DocElements docElements) {
		notifyChanged(JavaFeatureDescriptorEnum.docElements, this.docElements,
				this.docElements = docElements);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getDocElements().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setDocElements(value
					.wGetAdapter(JavaEntityDescriptorEnum.DocElements));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
