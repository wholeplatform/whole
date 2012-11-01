package org.whole.lang.frames.visitors;

import org.whole.lang.frames.visitors.FramesIdentityUnaryVisitor;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class FramesTraverseAllAdjacentsVisitor extends
		FramesIdentityUnaryVisitor<IFramesVisitor> {
	public FramesTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public FramesTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
