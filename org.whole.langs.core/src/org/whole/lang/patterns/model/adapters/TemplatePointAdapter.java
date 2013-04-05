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
public class TemplatePointAdapter extends AbstractEntityAdapter implements
		TemplatePoint {
	private static final long serialVersionUID = 1;

	public TemplatePointAdapter(IEntity implementor) {
		super(implementor);
	}

	public TemplatePointAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TemplatePoint> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.TemplatePoint;
	}

	public Template getTemplate() {
		return wGet(PatternsFeatureDescriptorEnum.template).wGetAdapter(
				PatternsEntityDescriptorEnum.Template);
	}

	public void setTemplate(Template template) {
		wSet(PatternsFeatureDescriptorEnum.template, template);
	}
}
