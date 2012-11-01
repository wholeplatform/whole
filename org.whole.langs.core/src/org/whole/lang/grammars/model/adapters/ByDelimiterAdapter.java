package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ByDelimiterAdapter extends AbstractEntityAdapter implements
		ByDelimiter {
	private static final long serialVersionUID = 1;

	public ByDelimiterAdapter(IEntity implementor) {
		super(implementor);
	}

	public ByDelimiterAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ByDelimiter> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.ByDelimiter;
	}

	public Pattern getDelimiter() {
		return wGet(GrammarsFeatureDescriptorEnum.delimiter).wGetAdapter(
				GrammarsEntityDescriptorEnum.Pattern);
	}

	public void setDelimiter(Pattern delimiter) {
		wSet(GrammarsFeatureDescriptorEnum.delimiter, delimiter);
	}
}
