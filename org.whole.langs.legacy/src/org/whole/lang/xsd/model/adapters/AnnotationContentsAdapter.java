package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractCollectionEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AnnotationContentsAdapter extends
		AbstractCollectionEntityAdapter<AnnotationContent> implements
		AnnotationContents {
	private static final long serialVersionUID = 1;

	public AnnotationContentsAdapter(IEntity implementor) {
		super(implementor);
	}

	public AnnotationContentsAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AnnotationContents> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.AnnotationContents;
	}
}
