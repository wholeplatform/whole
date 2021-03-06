package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class NamespaceAdapter extends AbstractEntityAdapter implements
		Namespace {
	private static final long serialVersionUID = 1;

	public NamespaceAdapter(IEntity implementor) {
		super(implementor);
	}

	public NamespaceAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Namespace> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Namespace;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
