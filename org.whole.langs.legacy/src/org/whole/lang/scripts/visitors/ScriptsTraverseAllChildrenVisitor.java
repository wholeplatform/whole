package org.whole.lang.scripts.visitors;

import org.whole.lang.scripts.visitors.ScriptsIdentityUnaryVisitor;
import org.whole.lang.scripts.visitors.IScriptsVisitor;
import org.whole.lang.scripts.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class ScriptsTraverseAllChildrenVisitor extends
		ScriptsIdentityUnaryVisitor<IScriptsVisitor> {
	public ScriptsTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public ScriptsTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Script entity) {
		entity.getLanguageName().accept(wGetVisitor1());
		entity.getSource().accept(wGetVisitor1());
	}
}
