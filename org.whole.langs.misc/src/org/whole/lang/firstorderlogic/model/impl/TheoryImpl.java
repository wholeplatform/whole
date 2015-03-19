package org.whole.lang.firstorderlogic.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TheoryImpl extends AbstractSimpleEntity implements Theory {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Theory> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.Theory;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.Theory_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Name name;

	public Name getName() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private ImportTheories imports;

	public ImportTheories getImports() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.imports,
				imports);
	}

	public void setImports(ImportTheories imports) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.imports,
				this.imports, this.imports = imports);
	}

	private Declarations declarations;

	public Declarations getDeclarations() {
		return notifyRequested(
				FirstOrderLogicFeatureDescriptorEnum.declarations, declarations);
	}

	public void setDeclarations(Declarations declarations) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.declarations,
				this.declarations, this.declarations = declarations);
	}

	private Assertions assertions;

	public Assertions getAssertions() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.assertions,
				assertions);
	}

	public void setAssertions(Assertions assertions) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.assertions,
				this.assertions, this.assertions = assertions);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getImports().wGetAdaptee(false);
		case 2:
			return getDeclarations().wGetAdaptee(false);
		case 3:
			return getAssertions().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name));
			break;
		case 1:
			setImports(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.ImportTheories));
			break;
		case 2:
			setDeclarations(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Declarations));
			break;
		case 3:
			setAssertions(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Assertions));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
