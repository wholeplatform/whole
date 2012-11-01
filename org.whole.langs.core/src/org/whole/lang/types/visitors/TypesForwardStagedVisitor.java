package org.whole.lang.types.visitors;

import org.whole.lang.types.model.*;

/** 
 * @generator Whole
 */
public class TypesForwardStagedVisitor extends TypesIdentityVisitor {
	public void visit(TypeSystem entity) {
		stagedVisit(entity);
	}

	public void visit(TypeRules entity) {
		stagedVisit(entity);
	}

	public void visit(TypeRule entity) {
		stagedVisit(entity);
	}

	public void visit(AnyType entity) {
		stagedVisit(entity);
	}

	public void visit(LegacyType entity) {
		stagedVisit(entity);
	}

	public void visit(VariableType entity) {
		stagedVisit(entity);
	}

	public void visit(EntityType entity) {
		stagedVisit(entity);
	}

	public void visit(UnionType entity) {
		stagedVisit(entity);
	}

	public void visit(FeatureType entity) {
		stagedVisit(entity);
	}

	public void visit(FeatureTableType entity) {
		stagedVisit(entity);
	}

	public void visit(Arguments entity) {
		stagedVisit(entity);
	}

	public void visit(Cases entity) {
		stagedVisit(entity);
	}

	public void visit(Case entity) {
		stagedVisit(entity);
	}

	public void visit(OrExpressions entity) {
		stagedVisit(entity);
	}

	public void visit(TypeExpressions entity) {
		stagedVisit(entity);
	}

	public void visit(Subtype entity) {
		stagedVisit(entity);
	}

	public void visit(Supertype entity) {
		stagedVisit(entity);
	}
}
