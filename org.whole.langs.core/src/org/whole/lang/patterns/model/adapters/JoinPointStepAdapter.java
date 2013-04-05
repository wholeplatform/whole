package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class JoinPointStepAdapter extends AbstractEntityAdapter implements
		JoinPointStep {
	private static final long serialVersionUID = 1;

	public JoinPointStepAdapter(IEntity implementor) {
		super(implementor);
	}

	public JoinPointStepAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<JoinPointStep> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.JoinPointStep;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
