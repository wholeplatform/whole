package org.whole.lang.text.visitors;

import org.whole.lang.text.model.*;

/** 
 * @generator Whole
 */
public class TextForwardStagedVisitor extends TextIdentityVisitor {
	public void visit(Document entity) {
		stagedVisit(entity);
	}

	public void visit(Indent entity) {
		stagedVisit(entity);
	}

	public void visit(RowSeparator entity) {
		stagedVisit(entity);
	}

	public void visit(TextSeparator entity) {
		stagedVisit(entity);
	}

	public void visit(Row entity) {
		stagedVisit(entity);
	}

	public void visit(Text entity) {
		stagedVisit(entity);
	}
}
