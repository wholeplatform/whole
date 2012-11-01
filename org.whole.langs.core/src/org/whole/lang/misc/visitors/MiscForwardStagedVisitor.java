package org.whole.lang.misc.visitors;

import org.whole.lang.misc.model.*;

/** 
 * @generator Whole
 */
public class MiscForwardStagedVisitor extends MiscIdentityVisitor {
	public void visit(Misc entity) {
		stagedVisit(entity);
	}
}
