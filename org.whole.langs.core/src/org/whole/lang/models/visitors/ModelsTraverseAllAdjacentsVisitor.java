package org.whole.lang.models.visitors;

import org.whole.lang.models.visitors.ModelsIdentityUnaryVisitor;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.models.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class ModelsTraverseAllAdjacentsVisitor extends
		ModelsIdentityUnaryVisitor<IModelsVisitor> {
	public ModelsTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public ModelsTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
