package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import java.util.regex.Pattern;

/** 
 * @generator Whole
 */
public class CompiledPatternAdapter extends AbstractEntityAdapter implements
		CompiledPattern {
	private static final long serialVersionUID = 1;

	public CompiledPatternAdapter(IEntity implementor) {
		super(implementor);
	}

	public CompiledPatternAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CompiledPattern> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.CompiledPattern;
	}

	public Pattern getValue() {
		return (Pattern) wGetValue();
	}

	public void setValue(Pattern value) {
		wSetValue((Object) value);
	}
}
