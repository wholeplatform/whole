package org.whole.lang.unifiedlambdadelta.visitors;

import org.whole.lang.unifiedlambdadelta.visitors.UnifiedLambdaDeltaIdentityUnaryVisitor;
import org.whole.lang.unifiedlambdadelta.visitors.IUnifiedLambdaDeltaVisitor;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaTraverseAllChildrenVisitor extends
		UnifiedLambdaDeltaIdentityUnaryVisitor<IUnifiedLambdaDeltaVisitor> {
	public UnifiedLambdaDeltaTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public UnifiedLambdaDeltaTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Binder entity) {
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(BinaryItem entity) {
		entity.getPolarity().accept(wGetVisitor1());
		entity.getFront().accept(wGetVisitor1());
	}

	public void visit(BinaryContextBinder entity) {
		entity.getPolarity().accept(wGetVisitor1());
		entity.getFront().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getBack().accept(wGetVisitor1());
	}

	public void visit(Declaration entity) {
		entity.getPolarity().accept(wGetVisitor1());
		entity.getFront().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getBack().accept(wGetVisitor1());
	}

	public void visit(Definition entity) {
		entity.getPolarity().accept(wGetVisitor1());
		entity.getFront().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getBack().accept(wGetVisitor1());
	}

	public void visit(BinaryTerm entity) {
		entity.getPolarity().accept(wGetVisitor1());
		entity.getFront().accept(wGetVisitor1());
		entity.getBack().accept(wGetVisitor1());
	}

	public void visit(Application entity) {
		entity.getPolarity().accept(wGetVisitor1());
		entity.getFront().accept(wGetVisitor1());
		entity.getBack().accept(wGetVisitor1());
	}

	public void visit(Cast entity) {
		entity.getPolarity().accept(wGetVisitor1());
		entity.getFront().accept(wGetVisitor1());
		entity.getBack().accept(wGetVisitor1());
	}

	public void visit(BinaryTermBinder entity) {
		entity.getPolarity().accept(wGetVisitor1());
		entity.getFront().accept(wGetVisitor1());
		entity.getBack().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(Abstraction entity) {
		entity.getPolarity().accept(wGetVisitor1());
		entity.getFront().accept(wGetVisitor1());
		entity.getBack().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(Abbreviation entity) {
		entity.getPolarity().accept(wGetVisitor1());
		entity.getFront().accept(wGetVisitor1());
		entity.getBack().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(Local entity) {
		entity.getIndex().accept(wGetVisitor1());
	}

	public void visit(Sort entity) {
		entity.getLevel().accept(wGetVisitor1());
	}

	public void visit(Name entity) {
		entity.getAccess().accept(wGetVisitor1());
		entity.getPrefix().accept(wGetVisitor1());
		entity.getPostfix().accept(wGetVisitor1());
	}
}
