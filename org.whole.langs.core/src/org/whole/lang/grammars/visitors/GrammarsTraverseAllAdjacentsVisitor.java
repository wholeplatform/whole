package org.whole.lang.grammars.visitors;

import org.whole.lang.grammars.visitors.GrammarsIdentityUnaryVisitor;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.grammars.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class GrammarsTraverseAllAdjacentsVisitor extends
		GrammarsIdentityUnaryVisitor<IGrammarsVisitor> {
	public GrammarsTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public GrammarsTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
