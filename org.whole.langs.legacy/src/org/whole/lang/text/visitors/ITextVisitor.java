package org.whole.lang.text.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.text.model.*;

/** 
 * @generator Whole
 */
public interface ITextVisitor extends IVisitor {
	public void visit(Document entity);

	public void visit(Indent entity);

	public void visit(RowSeparator entity);

	public void visit(TextSeparator entity);

	public void visit(Row entity);

	public void visit(Text entity);
}
