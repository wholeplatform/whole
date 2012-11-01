package org.whole.lang.text.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.text.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TextIdentityVisitor extends AbstractVisitor implements
		ITextVisitor {
	public void visit(IEntity entity) {
		((ITextEntity) entity).accept(this);
	}

	public void visit(Document entity) {
	}

	public void visit(Indent entity) {
	}

	public void visit(RowSeparator entity) {
	}

	public void visit(TextSeparator entity) {
	}

	public void visit(Row entity) {
	}

	public void visit(Text entity) {
	}
}
