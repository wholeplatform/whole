package org.whole.lang.editors.visitors;

import org.whole.lang.editors.visitors.EditorsIdentityUnaryVisitor;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.editors.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class EditorsTraverseAllAdjacentsVisitor extends
		EditorsIdentityUnaryVisitor<IEditorsVisitor> {
	public EditorsTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public EditorsTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
