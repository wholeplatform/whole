package org.whole.lang.scripts.visitors;

import org.whole.lang.scripts.visitors.ScriptsIdentityUnaryVisitor;
import org.whole.lang.scripts.visitors.IScriptsVisitor;
import org.whole.lang.scripts.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class ScriptsTraverseAllAdjacentsVisitor extends
		ScriptsIdentityUnaryVisitor<IScriptsVisitor> {
	public ScriptsTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public ScriptsTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
