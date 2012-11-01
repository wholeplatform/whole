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
public class LiteralTerminalAdapter extends AbstractEntityAdapter implements
		LiteralTerminal {
	private static final long serialVersionUID = 1;

	public LiteralTerminalAdapter(IEntity implementor) {
		super(implementor);
	}

	public LiteralTerminalAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LiteralTerminal> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.LiteralTerminal;
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

	public Literal getLiteral() {
		return wGet(GrammarsFeatureDescriptorEnum.literal).wGetAdapter(
				GrammarsEntityDescriptorEnum.Literal);
	}

	public void setLiteral(Literal literal) {
		wSet(GrammarsFeatureDescriptorEnum.literal, literal);
	}
}
