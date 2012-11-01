package org.whole.lang.xml.visitors;

import org.whole.lang.xml.visitors.XmlIdentityUnaryVisitor;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.xml.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class XmlTraverseAllAdjacentsVisitor extends
		XmlIdentityUnaryVisitor<IXmlVisitor> {
	public XmlTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public XmlTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
