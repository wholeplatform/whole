package org.whole.examples.datatypes.redblacktree.visitors;

import org.whole.examples.datatypes.redblacktree.model.*;

/** 
 * @generator Whole
 */
public class RedBlackTreeIdentityDefaultVisitor extends
		RedBlackTreeIdentityVisitor {
	public void visit(IRedBlackTreeEntity entity) {
	}

	public void visit(RBNode entity) {
		visit((IRedBlackTreeEntity) entity);
	}

	public void visit(Value entity) {
		visit((IRedBlackTreeEntity) entity);
	}

	public void visit(Color entity) {
		visit((IRedBlackTreeEntity) entity);
	}
}
