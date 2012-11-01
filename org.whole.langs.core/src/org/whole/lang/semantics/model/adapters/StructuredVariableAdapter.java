package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class StructuredVariableAdapter extends AbstractEntityAdapter implements
		StructuredVariable {
	private static final long serialVersionUID = 1;

	public StructuredVariableAdapter(IEntity implementor) {
		super(implementor);
	}

	public StructuredVariableAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StructuredVariable> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.StructuredVariable;
	}

	public Variable getVariable() {
		return wGet(SemanticsFeatureDescriptorEnum.variable).wGetAdapter(
				SemanticsEntityDescriptorEnum.Variable);
	}

	public void setVariable(Variable variable) {
		wSet(SemanticsFeatureDescriptorEnum.variable, variable);
	}

	public Num getIndex() {
		return wGet(SemanticsFeatureDescriptorEnum.index).wGetAdapter(
				SemanticsEntityDescriptorEnum.Num);
	}

	public void setIndex(Num index) {
		wSet(SemanticsFeatureDescriptorEnum.index, index);
	}

	public Num getTime() {
		return wGet(SemanticsFeatureDescriptorEnum.time).wGetAdapter(
				SemanticsEntityDescriptorEnum.Num);
	}

	public void setTime(Num time) {
		wSet(SemanticsFeatureDescriptorEnum.time, time);
	}
}
