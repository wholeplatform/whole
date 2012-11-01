package org.whole.lang.types.visitors;

import org.whole.lang.types.visitors.TypesIdentityUnaryVisitor;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.types.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class TypesTraverseAllVisitor extends
		TypesIdentityUnaryVisitor<ITypesVisitor> {
	public TypesTraverseAllVisitor() {
		wSetVisitor1(this);
	}

	public TypesTraverseAllVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(TypeSystem entity) {
		entity.getCheckBefore().accept(wGetVisitor1());
		entity.getRules().accept(wGetVisitor1());
	}

	public void visit(TypeRules entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(TypeRule entity) {
		entity.getDomain().accept(wGetVisitor1());
		entity.getType().accept(wGetVisitor1());
	}

	public void visit(UnionType entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(FeatureTableType entity) {
		entity.getArguments().accept(wGetVisitor1());
		entity.getCases().accept(wGetVisitor1());
	}

	public void visit(Arguments entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Cases entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Case entity) {
		entity.getType().accept(wGetVisitor1());
		entity.getExpressions().accept(wGetVisitor1());
	}

	public void visit(OrExpressions entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(TypeExpressions entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Subtype entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getType().accept(wGetVisitor1());
	}

	public void visit(Supertype entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getType().accept(wGetVisitor1());
	}
}
