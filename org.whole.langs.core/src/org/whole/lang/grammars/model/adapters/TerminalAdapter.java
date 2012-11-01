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
public class TerminalAdapter extends AbstractEntityAdapter implements Terminal {
	private static final long serialVersionUID = 1;

	public TerminalAdapter(IEntity implementor) {
		super(implementor);
	}

	public TerminalAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Terminal> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Terminal;
	}

	public Pattern getPattern() {
		return wGet(GrammarsFeatureDescriptorEnum.pattern).wGetAdapter(
				GrammarsEntityDescriptorEnum.Pattern);
	}

	public void setPattern(Pattern pattern) {
		wSet(GrammarsFeatureDescriptorEnum.pattern, pattern);
	}

	public Category getCategory() {
		return wGet(GrammarsFeatureDescriptorEnum.category).wGetAdapter(
				GrammarsEntityDescriptorEnum.Category);
	}

	public void setCategory(Category category) {
		wSet(GrammarsFeatureDescriptorEnum.category, category);
	}
}
