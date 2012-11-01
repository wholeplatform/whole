package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class WildcardAdapter extends AbstractEntityAdapter implements Wildcard {
	private static final long serialVersionUID = 1;

	public WildcardAdapter(IEntity implementor) {
		super(implementor);
	}

	public WildcardAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Wildcard> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Wildcard;
	}

	public NamespaceSpecs getNamespaceSpecs() {
		return wGet(XsdFeatureDescriptorEnum.namespaceSpecs).wGetAdapter(
				XsdEntityDescriptorEnum.NamespaceSpecs);
	}

	public void setNamespaceSpecs(NamespaceSpecs namespaceSpecs) {
		wSet(XsdFeatureDescriptorEnum.namespaceSpecs, namespaceSpecs);
	}

	public ProcessContents getProcessContents() {
		return wGet(XsdFeatureDescriptorEnum.processContents).wGetAdapter(
				XsdEntityDescriptorEnum.ProcessContents);
	}

	public void setProcessContents(ProcessContents processContents) {
		wSet(XsdFeatureDescriptorEnum.processContents, processContents);
	}
}
