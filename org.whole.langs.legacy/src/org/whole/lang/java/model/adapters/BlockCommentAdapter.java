package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class BlockCommentAdapter extends AbstractEntityAdapter implements
		BlockComment {
	private static final long serialVersionUID = 1;

	public BlockCommentAdapter(IEntity implementor) {
		super(implementor);
	}

	public BlockCommentAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BlockComment> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.BlockComment;
	}

	public DocElements getDocElements() {
		return wGet(JavaFeatureDescriptorEnum.docElements).wGetAdapter(
				JavaEntityDescriptorEnum.DocElements);
	}

	public void setDocElements(DocElements docElements) {
		wSet(JavaFeatureDescriptorEnum.docElements, docElements);
	}
}
