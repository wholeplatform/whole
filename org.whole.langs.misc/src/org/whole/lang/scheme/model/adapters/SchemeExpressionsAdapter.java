package org.whole.lang.scheme.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.scheme.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SchemeExpressionsAdapter extends
		AbstractListEntityAdapter<SchemeExpression> implements
		SchemeExpressions {
	private static final long serialVersionUID = 1;

	public SchemeExpressionsAdapter(IEntity implementor) {
		super(implementor);
	}

	public SchemeExpressionsAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SchemeExpressions> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.SchemeExpressions;
	}
}
