package org.whole.lang.types.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TypesIdentityVisitor extends AbstractVisitor implements
		ITypesVisitor {
	public void visit(IEntity entity) {
		((ITypesEntity) entity).accept(this);
	}

	public void visit(TypeSystem entity) {
	}

	public void visit(TypeRules entity) {
	}

	public void visit(TypeRule entity) {
	}

	public void visit(AnyType entity) {
	}

	public void visit(LegacyType entity) {
	}

	public void visit(VariableType entity) {
	}

	public void visit(EntityType entity) {
	}

	public void visit(UnionType entity) {
	}

	public void visit(FeatureType entity) {
	}

	public void visit(FeatureTableType entity) {
	}

	public void visit(Arguments entity) {
	}

	public void visit(Cases entity) {
	}

	public void visit(Case entity) {
	}

	public void visit(OrExpressions entity) {
	}

	public void visit(TypeExpressions entity) {
	}

	public void visit(Subtype entity) {
	}

	public void visit(Supertype entity) {
	}
}
