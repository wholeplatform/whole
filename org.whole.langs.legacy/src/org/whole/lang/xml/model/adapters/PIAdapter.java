package org.whole.lang.xml.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class PIAdapter extends AbstractEntityAdapter implements PI {
	private static final long serialVersionUID = 1;

	public PIAdapter(IEntity implementor) {
		super(implementor);
	}

	public PIAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PI> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.PI;
	}

	public IName getName() {
		return wGet(XmlFeatureDescriptorEnum.name).wGetAdapter(
				XmlEntityDescriptorEnum.IName);
	}

	public void setName(IName name) {
		wSet(XmlFeatureDescriptorEnum.name, name);
	}

	public Instruction getInstruction() {
		return wGet(XmlFeatureDescriptorEnum.instruction).wGetAdapter(
				XmlEntityDescriptorEnum.Instruction);
	}

	public void setInstruction(Instruction instruction) {
		wSet(XmlFeatureDescriptorEnum.instruction, instruction);
	}
}
