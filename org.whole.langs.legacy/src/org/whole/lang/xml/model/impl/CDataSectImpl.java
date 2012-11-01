package org.whole.lang.xml.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.xml.model.*;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class CDataSectImpl extends AbstractListCompositeEntity<CDataSectData>
		implements CDataSect {
	private static final long serialVersionUID = 1;

	public void accept(IXmlVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return XmlEntityDescriptorEnum.CDataSect_ord;
	}

	public EntityDescriptor<CDataSect> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.CDataSect;
	}
}
