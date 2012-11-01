package org.whole.lang.artifacts.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AuthorAdapter extends AbstractEntityAdapter implements Author {
	private static final long serialVersionUID = 1;

	public AuthorAdapter(IEntity implementor) {
		super(implementor);
	}

	public AuthorAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Author> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Author;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
