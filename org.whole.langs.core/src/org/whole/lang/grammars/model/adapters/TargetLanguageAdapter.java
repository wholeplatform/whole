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
public class TargetLanguageAdapter extends AbstractEntityAdapter implements
		TargetLanguage {
	private static final long serialVersionUID = 1;

	public TargetLanguageAdapter(IEntity implementor) {
		super(implementor);
	}

	public TargetLanguageAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TargetLanguage> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.TargetLanguage;
	}
}
