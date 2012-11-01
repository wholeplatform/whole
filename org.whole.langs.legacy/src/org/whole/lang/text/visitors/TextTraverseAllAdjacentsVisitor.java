package org.whole.lang.text.visitors;

import org.whole.lang.text.visitors.TextIdentityUnaryVisitor;
import org.whole.lang.text.visitors.ITextVisitor;
import org.whole.lang.text.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class TextTraverseAllAdjacentsVisitor extends
		TextIdentityUnaryVisitor<ITextVisitor> {
	public TextTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public TextTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
