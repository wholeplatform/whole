package org.whole.lang.text.visitors;

import org.whole.lang.text.visitors.TextIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.text.model.*;

/** 
 * @generator Whole
 */
public class TextTraverseAllSwitchVisitor extends TextIdentityUnaryVisitor<IVisitor> {
	public TextTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Document entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Row entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}
}
