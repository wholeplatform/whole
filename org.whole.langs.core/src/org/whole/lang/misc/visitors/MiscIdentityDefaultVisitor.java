package org.whole.lang.misc.visitors;

import org.whole.lang.misc.model.*;

/** 
 * @generator Whole
 */
public class MiscIdentityDefaultVisitor extends MiscIdentityVisitor {
	public void visit(IMiscEntity entity) {
	}

	public void visit(Misc entity) {
		visit((IMiscEntity) entity);
	}
}
