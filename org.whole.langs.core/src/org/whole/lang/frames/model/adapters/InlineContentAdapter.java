package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class InlineContentAdapter extends AbstractEntityAdapter implements
		InlineContent {
	private static final long serialVersionUID = 1;

	public InlineContentAdapter(IEntity implementor) {
		super(implementor);
	}

	public InlineContentAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InlineContent> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.InlineContent;
	}

	public Content getContent() {
		return wGet(FramesFeatureDescriptorEnum.content).wGetAdapter(
				FramesEntityDescriptorEnum.Content);
	}

	public void setContent(Content content) {
		wSet(FramesFeatureDescriptorEnum.content, content);
	}
}
