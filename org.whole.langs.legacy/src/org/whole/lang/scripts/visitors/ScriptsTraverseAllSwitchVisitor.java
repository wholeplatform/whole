package org.whole.lang.scripts.visitors;

import org.whole.lang.scripts.visitors.ScriptsIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.scripts.model.*;

/** 
 * @generator Whole
 */
public class ScriptsTraverseAllSwitchVisitor extends
		ScriptsIdentityUnaryVisitor<IVisitor> {
	public ScriptsTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Script entity) {
		wGetVisitor1().visit(entity.getLanguageName());
		wGetVisitor1().visit(entity.getSource());
	}
}
