package org.whole.lang.types.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TypesForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor>
		implements ITypesVisitor {
	public TypesForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TypeSystem entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TypeRules entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TypeRule entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AnyType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LegacyType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VariableType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EntityType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(UnionType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FeatureType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FeatureTableType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Arguments entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Cases entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Case entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(OrExpressions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TypeExpressions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Subtype entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Supertype entity) {
		wGetVisitor1().visit(entity);
	}
}
