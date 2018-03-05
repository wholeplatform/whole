package org.whole.lang.text.visitors;

import org.whole.lang.text.model.*;

/** 
 * @generator Whole
 */
public class TextIdentityDefaultVisitor extends TextIdentityVisitor {
	public void visit(ITextEntity entity) {
	}

	public void visit(IRow entity) {
	}

	public void visit(Document entity) {
		visit((ITextEntity) entity);
		visit((IRow) entity);
		visit((IText) entity);
	}

	public void visit(IText entity) {
	}

	public void visit(Indent entity) {
		visit((ITextEntity) entity);
		visit((IRow) entity);
	}

	public void visit(RowSeparator entity) {
		visit((ITextEntity) entity);
		visit((IRow) entity);
	}

	public void visit(TextSeparator entity) {
		visit((ITextEntity) entity);
		visit((IRow) entity);
		visit((IText) entity);
	}

	public void visit(Row entity) {
		visit((ITextEntity) entity);
		visit((IRow) entity);
		visit((IText) entity);
	}

	public void visit(Text entity) {
		visit((ITextEntity) entity);
		visit((IText) entity);
	}
}
