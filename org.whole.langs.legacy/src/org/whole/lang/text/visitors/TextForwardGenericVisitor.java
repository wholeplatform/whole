package org.whole.lang.text.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.text.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TextForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor>
		implements ITextVisitor {
	public TextForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Document entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Indent entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(RowSeparator entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TextSeparator entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Row entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Text entity) {
		wGetVisitor1().visit(entity);
	}
}
