package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class JoinpointExpressionAdapter extends AbstractEntityAdapter implements
		JoinpointExpression {
	private static final long serialVersionUID = 1;

	public JoinpointExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public JoinpointExpressionAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<JoinpointExpression> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.JoinpointExpression;
	}
}
