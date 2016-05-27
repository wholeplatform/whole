package org.whole.lang.commons.model.adapters;

import org.whole.lang.model.adapters.AbstractCollectionEntityAdapter;
import org.whole.lang.commons.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class MultiplexerAdapter extends AbstractCollectionEntityAdapter<Any> implements Multiplexer {
	private static final long serialVersionUID = 1;

	public MultiplexerAdapter(IEntity implementor) {
		super(implementor);
	}

	public MultiplexerAdapter() {
	}

	public void accept(ICommonsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Multiplexer> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.Multiplexer;
	}
}
