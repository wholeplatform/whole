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
public class NotAdapter extends AbstractEntityAdapter implements Not {
	private static final long serialVersionUID = 1;

	public NotAdapter(IEntity implementor) {
		super(implementor);
	}

	public NotAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Not> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Not;
	}

	public Predicate getPredicate() {
		return wGet(GrammarsFeatureDescriptorEnum.predicate).wGetAdapter(
				GrammarsEntityDescriptorEnum.Predicate);
	}

	public void setPredicate(Predicate predicate) {
		wSet(GrammarsFeatureDescriptorEnum.predicate, predicate);
	}
}
