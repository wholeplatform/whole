package org.whole.lang.text.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.text.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TextIdentityUnaryVisitor<V extends IVisitor> extends AbstractUnaryVisitor<V> implements ITextVisitor {
	public TextIdentityUnaryVisitor() {
		super(null);
	}

	public TextIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

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
