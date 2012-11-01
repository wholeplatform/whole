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
public class EntityNameAdapter extends AbstractEntityAdapter implements
		EntityName {
	private static final long serialVersionUID = 1;

	public EntityNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public EntityNameAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EntityName> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.EntityName;
	}

	public LanguageName getLanguage() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.language).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.LanguageName);
	}

	public void setLanguage(LanguageName language) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.language, language);
	}

	public Name getEntityName() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.entityName)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void setEntityName(Name entityName) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.entityName, entityName);
	}
}
