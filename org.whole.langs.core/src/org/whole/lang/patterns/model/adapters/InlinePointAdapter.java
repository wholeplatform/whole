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
public class InlinePointAdapter extends AbstractEntityAdapter implements
		InlinePoint {
	private static final long serialVersionUID = 1;

	public InlinePointAdapter(IEntity implementor) {
		super(implementor);
	}

	public InlinePointAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InlinePoint> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.InlinePoint;
	}

	public Template getTemplate() {
		return wGet(PatternsFeatureDescriptorEnum.template).wGetAdapter(
				PatternsEntityDescriptorEnum.Template);
	}

	public void setTemplate(Template template) {
		wSet(PatternsFeatureDescriptorEnum.template, template);
	}
}
