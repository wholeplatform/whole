package org.whole.lang.misc.visitors;

import org.whole.lang.misc.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class MiscFailureVisitor extends MiscIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Misc entity) {
		throw new VisitException();
	}
}
