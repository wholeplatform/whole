package org.whole.examples.datatypes.redblacktree.visitors;

import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class RedBlackTreeFailureVisitor extends RedBlackTreeIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(RBNode entity) {
		throw new VisitException();
	}

	public void visit(Value entity) {
		throw new VisitException();
	}

	public void visit(Color entity) {
		throw new VisitException();
	}
}
