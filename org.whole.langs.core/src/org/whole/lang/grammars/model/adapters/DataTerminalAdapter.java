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
public class DataTerminalAdapter extends AbstractEntityAdapter implements
		DataTerminal {
	private static final long serialVersionUID = 1;

	public DataTerminalAdapter(IEntity implementor) {
		super(implementor);
	}

	public DataTerminalAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DataTerminal> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.DataTerminal;
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

	public Format getFormat() {
		return wGet(GrammarsFeatureDescriptorEnum.format).wGetAdapter(
				GrammarsEntityDescriptorEnum.Format);
	}

	public void setFormat(Format format) {
		wSet(GrammarsFeatureDescriptorEnum.format, format);
	}
}
