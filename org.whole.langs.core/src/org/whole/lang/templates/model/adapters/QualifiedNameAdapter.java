package org.whole.lang.templates.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.templates.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.templates.visitors.ITemplatesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;
import org.whole.lang.templates.reflect.TemplatesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class QualifiedNameAdapter extends AbstractEntityAdapter implements
		QualifiedName {
	private static final long serialVersionUID = 1;

	public QualifiedNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public QualifiedNameAdapter() {
	}

	public void accept(ITemplatesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<QualifiedName> wGetEntityDescriptor() {
		return TemplatesEntityDescriptorEnum.QualifiedName;
	}

	public SimpleName getQualifier() {
		return wGet(TemplatesFeatureDescriptorEnum.qualifier).wGetAdapter(
				TemplatesEntityDescriptorEnum.SimpleName);
	}

	public void setQualifier(SimpleName qualifier) {
		wSet(TemplatesFeatureDescriptorEnum.qualifier, qualifier);
	}

	public Name getName() {
		return wGet(TemplatesFeatureDescriptorEnum.name).wGetAdapter(
				TemplatesEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(TemplatesFeatureDescriptorEnum.name, name);
	}
}
