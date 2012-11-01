package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class BindingsScopeImpl extends AbstractSimpleEntity implements
		BindingsScope {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<BindingsScope> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.BindingsScope;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.BindingsScope_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private LocalIdentifier identifier;

	public LocalIdentifier getIdentifier() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.identifier,
				identifier);
	}

	public void setIdentifier(LocalIdentifier identifier) {
		notifyChanged(SemanticsFeatureDescriptorEnum.identifier,
				this.identifier, this.identifier = identifier);
	}

	private LocalBindings bindings;

	public LocalBindings getBindings() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.bindings,
				bindings);
	}

	public void setBindings(LocalBindings bindings) {
		notifyChanged(SemanticsFeatureDescriptorEnum.bindings, this.bindings,
				this.bindings = bindings);
	}

	private BindingsScope nestedScope;

	public BindingsScope getNestedScope() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.nestedScope,
				nestedScope);
	}

	public void setNestedScope(BindingsScope nestedScope) {
		notifyChanged(SemanticsFeatureDescriptorEnum.nestedScope,
				this.nestedScope, this.nestedScope = nestedScope);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getIdentifier().wGetAdaptee(false);
		case 1:
			return getBindings().wGetAdaptee(false);
		case 2:
			return getNestedScope().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setIdentifier(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.LocalIdentifier));
			break;
		case 1:
			setBindings(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.LocalBindings));
			break;
		case 2:
			setNestedScope(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.BindingsScope));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
