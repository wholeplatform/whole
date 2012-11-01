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
public class LocalExpressionAdapter extends AbstractEntityAdapter implements
		LocalExpression {
	private static final long serialVersionUID = 1;

	public LocalExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public LocalExpressionAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LocalExpression> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.LocalExpression;
	}

	public Definitions getDefinitions() {
		return wGet(SchemeFeatureDescriptorEnum.definitions).wGetAdapter(
				SchemeEntityDescriptorEnum.Definitions);
	}

	public void setDefinitions(Definitions definitions) {
		wSet(SchemeFeatureDescriptorEnum.definitions, definitions);
	}

	public SchemeExpression getBody() {
		return wGet(SchemeFeatureDescriptorEnum.body).wGetAdapter(
				SchemeEntityDescriptorEnum.SchemeExpression);
	}

	public void setBody(SchemeExpression body) {
		wSet(SchemeFeatureDescriptorEnum.body, body);
	}
}
