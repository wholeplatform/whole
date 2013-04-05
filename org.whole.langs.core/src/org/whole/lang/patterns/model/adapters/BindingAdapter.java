package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class BindingAdapter extends AbstractEntityAdapter implements Binding {
	private static final long serialVersionUID = 1;

	public BindingAdapter(IEntity implementor) {
		super(implementor);
	}

	public BindingAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Binding> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.Binding;
	}

	public Name getName() {
		return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(
				PatternsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(PatternsFeatureDescriptorEnum.name, name);
	}

	public Template getTemplate() {
		return wGet(PatternsFeatureDescriptorEnum.template).wGetAdapter(
				PatternsEntityDescriptorEnum.Template);
	}

	public void setTemplate(Template template) {
		wSet(PatternsFeatureDescriptorEnum.template, template);
	}
}
