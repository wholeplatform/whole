package org.whole.lang.xml.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xml.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PIImpl extends AbstractSimpleEntity implements PI {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PI> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.PI;
	}

	public int wGetEntityOrd() {
		return XmlEntityDescriptorEnum.PI_ord;
	}

	public void accept(IXmlVisitor visitor) {
		visitor.visit(this);
	}

	private IName name;

	public IName getName() {
		return notifyRequested(XmlFeatureDescriptorEnum.name, name);
	}

	public void setName(IName name) {
		notifyChanged(XmlFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Instruction instruction;

	public Instruction getInstruction() {
		return notifyRequested(XmlFeatureDescriptorEnum.instruction,
				instruction);
	}

	public void setInstruction(Instruction instruction) {
		notifyChanged(XmlFeatureDescriptorEnum.instruction, this.instruction,
				this.instruction = instruction);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getInstruction().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(XmlEntityDescriptorEnum.IName));
			break;
		case 1:
			setInstruction(value
					.wGetAdapter(XmlEntityDescriptorEnum.Instruction));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
