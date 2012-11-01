package org.whole.lang.scheme.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.scheme.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.scheme.reflect.SchemeFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class DefinitionAdapter extends AbstractEntityAdapter implements
		Definition {
	private static final long serialVersionUID = 1;

	public DefinitionAdapter(IEntity implementor) {
		super(implementor);
	}

	public DefinitionAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Definition> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.Definition;
	}

	public Name getName() {
		return wGet(SchemeFeatureDescriptorEnum.name).wGetAdapter(
				SchemeEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(SchemeFeatureDescriptorEnum.name, name);
	}

	public SchemeExpression getExpression() {
		return wGet(SchemeFeatureDescriptorEnum.expression).wGetAdapter(
				SchemeEntityDescriptorEnum.SchemeExpression);
	}

	public void setExpression(SchemeExpression expression) {
		wSet(SchemeFeatureDescriptorEnum.expression, expression);
	}
}
