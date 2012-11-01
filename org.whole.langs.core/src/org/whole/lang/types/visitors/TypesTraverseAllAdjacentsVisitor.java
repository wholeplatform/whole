package org.whole.lang.types.visitors;

import org.whole.lang.types.visitors.TypesIdentityUnaryVisitor;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.types.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class TypesTraverseAllAdjacentsVisitor extends
		TypesIdentityUnaryVisitor<ITypesVisitor> {
	public TypesTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public TypesTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
