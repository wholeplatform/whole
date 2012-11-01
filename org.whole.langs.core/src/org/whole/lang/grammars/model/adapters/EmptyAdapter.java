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
public class EmptyAdapter extends AbstractEntityAdapter implements Empty {
	private static final long serialVersionUID = 1;

	public EmptyAdapter(IEntity implementor) {
		super(implementor);
	}

	public EmptyAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Empty> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Empty;
	}

	public Literal getLiteral() {
		return wGet(GrammarsFeatureDescriptorEnum.literal).wGetAdapter(
				GrammarsEntityDescriptorEnum.Literal);
	}

	public void setLiteral(Literal literal) {
		wSet(GrammarsFeatureDescriptorEnum.literal, literal);
	}
}
