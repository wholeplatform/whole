package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class JoinPointDeclarationAdapter extends AbstractEntityAdapter
		implements JoinPointDeclaration {
	private static final long serialVersionUID = 1;

	public JoinPointDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public JoinPointDeclarationAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<JoinPointDeclaration> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.JoinPointDeclaration;
	}

	public Name getName() {
		return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(
				PatternsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(PatternsFeatureDescriptorEnum.name, name);
	}

	public Expression getExpression() {
		return wGet(PatternsFeatureDescriptorEnum.expression).wGetAdapter(
				PatternsEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(PatternsFeatureDescriptorEnum.expression, expression);
	}
}
