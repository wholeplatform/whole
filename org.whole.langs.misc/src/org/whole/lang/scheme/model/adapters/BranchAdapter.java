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
public class BranchAdapter extends AbstractEntityAdapter implements Branch {
	private static final long serialVersionUID = 1;

	public BranchAdapter(IEntity implementor) {
		super(implementor);
	}

	public BranchAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Branch> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.Branch;
	}

	public SchemeExpression getTest() {
		return wGet(SchemeFeatureDescriptorEnum.test).wGetAdapter(
				SchemeEntityDescriptorEnum.SchemeExpression);
	}

	public void setTest(SchemeExpression test) {
		wSet(SchemeFeatureDescriptorEnum.test, test);
	}

	public SchemeExpression getBody() {
		return wGet(SchemeFeatureDescriptorEnum.body).wGetAdapter(
				SchemeEntityDescriptorEnum.SchemeExpression);
	}

	public void setBody(SchemeExpression body) {
		wSet(SchemeFeatureDescriptorEnum.body, body);
	}
}
