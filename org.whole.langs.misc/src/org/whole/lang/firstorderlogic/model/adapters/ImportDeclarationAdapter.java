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
public class ImportDeclarationAdapter extends AbstractEntityAdapter implements
		ImportDeclaration {
	private static final long serialVersionUID = 1;

	public ImportDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public ImportDeclarationAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ImportDeclaration> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.ImportDeclaration;
	}

	public TheoryName getLanguage() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.language).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.TheoryName);
	}

	public void setLanguage(TheoryName language) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.language, language);
	}

	public Name getAlias() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.alias).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void setAlias(Name alias) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.alias, alias);
	}
}
