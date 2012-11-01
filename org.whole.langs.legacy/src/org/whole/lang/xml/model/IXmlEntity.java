package org.whole.lang.xml.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.xml.visitors.IXmlVisitor;

/** 
 * @generator Whole
 */
public interface IXmlEntity extends IEntity {
	public void accept(IXmlVisitor visitor);
}
