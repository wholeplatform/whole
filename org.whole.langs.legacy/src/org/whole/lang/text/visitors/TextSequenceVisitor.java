package org.whole.lang.text.visitors;

import org.whole.lang.visitors.AbstractBinaryVisitor;
import org.whole.lang.text.visitors.ITextVisitor;
import org.whole.lang.text.model.*;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TextSequenceVisitor extends AbstractBinaryVisitor<ITextVisitor>
		implements ITextVisitor {
	public TextSequenceVisitor(IVisitor visitor1, IVisitor visitor2) {
		super(visitor1, visitor2);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Document entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Indent entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(RowSeparator entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(TextSeparator entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Row entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Text entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}
}
