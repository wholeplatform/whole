package org.whole.lang.firstorderlogic.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class TheoryAdapter extends AbstractEntityAdapter implements Theory {
	private static final long serialVersionUID = 1;

	public TheoryAdapter(IEntity implementor) {
		super(implementor);
	}

	public TheoryAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Theory> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.Theory;
	}

	public Name getName() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.name).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.name, name);
	}

	public ImportTheories getImports() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.imports).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.ImportTheories);
	}

	public void setImports(ImportTheories imports) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.imports, imports);
	}

	public Declarations getDeclarations() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.declarations)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Declarations);
	}

	public void setDeclarations(Declarations declarations) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.declarations, declarations);
	}

	public Assertions getAssertions() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.assertions)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Assertions);
	}

	public void setAssertions(Assertions assertions) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.assertions, assertions);
	}
}
