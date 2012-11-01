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
public class OrAdapter extends AbstractEntityAdapter implements Or {
	private static final long serialVersionUID = 1;

	public OrAdapter(IEntity implementor) {
		super(implementor);
	}

	public OrAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Or> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Or;
	}

	public Predicate getPredicate1() {
		return wGet(GrammarsFeatureDescriptorEnum.predicate1).wGetAdapter(
				GrammarsEntityDescriptorEnum.Predicate);
	}

	public void setPredicate1(Predicate predicate1) {
		wSet(GrammarsFeatureDescriptorEnum.predicate1, predicate1);
	}

	public Predicate getPredicate2() {
		return wGet(GrammarsFeatureDescriptorEnum.predicate2).wGetAdapter(
				GrammarsEntityDescriptorEnum.Predicate);
	}

	public void setPredicate2(Predicate predicate2) {
		wSet(GrammarsFeatureDescriptorEnum.predicate2, predicate2);
	}
}
