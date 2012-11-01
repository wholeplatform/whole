package org.whole.lang.types.visitors;

import org.whole.lang.types.visitors.TypesIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.types.model.*;

/** 
 * @generator Whole
 */
public class TypesTraverseAllSwitchVisitor extends
		TypesIdentityUnaryVisitor<IVisitor> {
	public TypesTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(TypeSystem entity) {
		wGetVisitor1().visit(entity.getCheckBefore());
		wGetVisitor1().visit(entity.getRules());
	}

	public void visit(TypeRules entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(TypeRule entity) {
		wGetVisitor1().visit(entity.getDomain());
		wGetVisitor1().visit(entity.getType());
	}

	public void visit(UnionType entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(FeatureTableType entity) {
		wGetVisitor1().visit(entity.getArguments());
		wGetVisitor1().visit(entity.getCases());
	}

	public void visit(Arguments entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Cases entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Case entity) {
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getExpressions());
	}

	public void visit(OrExpressions entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(TypeExpressions entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Subtype entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getType());
	}

	public void visit(Supertype entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getType());
	}
}
