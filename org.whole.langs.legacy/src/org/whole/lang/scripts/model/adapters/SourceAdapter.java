package org.whole.lang.scripts.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.scripts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.scripts.visitors.IScriptsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scripts.reflect.ScriptsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SourceAdapter extends AbstractEntityAdapter implements Source {
	private static final long serialVersionUID = 1;

	public SourceAdapter(IEntity implementor) {
		super(implementor);
	}

	public SourceAdapter() {
	}

	public void accept(IScriptsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Source> wGetEntityDescriptor() {
		return ScriptsEntityDescriptorEnum.Source;
	}
}
