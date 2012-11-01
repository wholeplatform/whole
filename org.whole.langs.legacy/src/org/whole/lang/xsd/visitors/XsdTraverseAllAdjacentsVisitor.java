package org.whole.lang.xsd.visitors;

import org.whole.lang.xsd.visitors.XsdIdentityUnaryVisitor;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.xsd.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class XsdTraverseAllAdjacentsVisitor extends
		XsdIdentityUnaryVisitor<IXsdVisitor> {
	public XsdTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public XsdTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
