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
public class LanguageNameAdapter extends AbstractEntityAdapter implements
		LanguageName {
	private static final long serialVersionUID = 1;

	public LanguageNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public LanguageNameAdapter() {
	}

	public void accept(IScriptsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LanguageName> wGetEntityDescriptor() {
		return ScriptsEntityDescriptorEnum.LanguageName;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
