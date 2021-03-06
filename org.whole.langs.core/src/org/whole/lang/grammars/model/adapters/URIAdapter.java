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
public class URIAdapter extends AbstractEntityAdapter implements URI {
	private static final long serialVersionUID = 1;

	public URIAdapter(IEntity implementor) {
		super(implementor);
	}

	public URIAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<URI> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.URI;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
