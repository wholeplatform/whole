package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class InferenceRulesAdapter extends
		AbstractListEntityAdapter<InferenceRule> implements InferenceRules {
	private static final long serialVersionUID = 1;

	public InferenceRulesAdapter(IEntity implementor) {
		super(implementor);
	}

	public InferenceRulesAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InferenceRules> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.InferenceRules;
	}
}
