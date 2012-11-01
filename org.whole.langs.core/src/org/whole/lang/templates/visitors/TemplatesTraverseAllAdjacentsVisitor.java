package org.whole.lang.templates.visitors;

import org.whole.lang.templates.visitors.TemplatesIdentityUnaryVisitor;
import org.whole.lang.templates.visitors.ITemplatesVisitor;
import org.whole.lang.templates.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class TemplatesTraverseAllAdjacentsVisitor extends
		TemplatesIdentityUnaryVisitor<ITemplatesVisitor> {
	public TemplatesTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public TemplatesTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
