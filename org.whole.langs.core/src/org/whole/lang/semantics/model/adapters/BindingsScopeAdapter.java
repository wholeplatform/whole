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
public class BindingsScopeAdapter extends AbstractEntityAdapter implements
		BindingsScope {
	private static final long serialVersionUID = 1;

	public BindingsScopeAdapter(IEntity implementor) {
		super(implementor);
	}

	public BindingsScopeAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BindingsScope> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.BindingsScope;
	}

	public LocalIdentifier getIdentifier() {
		return wGet(SemanticsFeatureDescriptorEnum.identifier).wGetAdapter(
				SemanticsEntityDescriptorEnum.LocalIdentifier);
	}

	public void setIdentifier(LocalIdentifier identifier) {
		wSet(SemanticsFeatureDescriptorEnum.identifier, identifier);
	}

	public LocalBindings getBindings() {
		return wGet(SemanticsFeatureDescriptorEnum.bindings).wGetAdapter(
				SemanticsEntityDescriptorEnum.LocalBindings);
	}

	public void setBindings(LocalBindings bindings) {
		wSet(SemanticsFeatureDescriptorEnum.bindings, bindings);
	}

	public BindingsScope getNestedScope() {
		return wGet(SemanticsFeatureDescriptorEnum.nestedScope).wGetAdapter(
				SemanticsEntityDescriptorEnum.BindingsScope);
	}

	public void setNestedScope(BindingsScope nestedScope) {
		wSet(SemanticsFeatureDescriptorEnum.nestedScope, nestedScope);
	}
}
