package org.whole.lang.text.visitors;

import org.whole.lang.text.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class TextFailureVisitor extends TextIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Document entity) {
		throw new VisitException();
	}

	public void visit(Indent entity) {
		throw new VisitException();
	}

	public void visit(RowSeparator entity) {
		throw new VisitException();
	}

	public void visit(TextSeparator entity) {
		throw new VisitException();
	}

	public void visit(Row entity) {
		throw new VisitException();
	}

	public void visit(Text entity) {
		throw new VisitException();
	}
}
