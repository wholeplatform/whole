package org.whole.lang.xsd.mapping.visitors;

import org.whole.lang.xsd.mapping.visitors.MappingIdentityUnaryVisitor;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class MappingTraverseAllAdjacentsVisitor extends
		MappingIdentityUnaryVisitor<IMappingVisitor> {
	public MappingTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public MappingTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
