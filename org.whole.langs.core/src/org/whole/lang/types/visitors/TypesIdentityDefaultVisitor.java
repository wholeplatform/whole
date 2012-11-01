package org.whole.lang.types.visitors;

import org.whole.lang.types.model.*;

/** 
 * @generator Whole
 */
public class TypesIdentityDefaultVisitor extends TypesIdentityVisitor {
	public void visit(ITypesEntity entity) {
	}

	public void visit(TypeSystem entity) {
		visit((ITypesEntity) entity);
	}

	public void visit(TypeRules entity) {
		visit((ITypesEntity) entity);
	}

	public void visit(TypeRule entity) {
		visit((ITypesEntity) entity);
	}

	public void visit(Type entity) {
	}

	public void visit(ArgumentType entity) {
		visit((Type) entity);
	}

	public void visit(BasicType entity) {
		visit((Type) entity);
		visit((TypeExpression) entity);
	}

	public void visit(TypeExpression entity) {
	}

	public void visit(AnyType entity) {
		visit((ITypesEntity) entity);
		visit((Type) entity);
		visit((BasicType) entity);
	}

	public void visit(LegacyType entity) {
		visit((ITypesEntity) entity);
		visit((Type) entity);
		visit((BasicType) entity);
	}

	public void visit(VariableType entity) {
		visit((ITypesEntity) entity);
		visit((Type) entity);
		visit((BasicType) entity);
	}

	public void visit(DomainType entity) {
		visit((Type) entity);
	}

	public void visit(EntityType entity) {
		visit((ITypesEntity) entity);
		visit((DomainType) entity);
	}

	public void visit(UnionType entity) {
		visit((ITypesEntity) entity);
		visit((DomainType) entity);
	}

	public void visit(FeatureType entity) {
		visit((ITypesEntity) entity);
		visit((ArgumentType) entity);
	}

	public void visit(FeatureTableType entity) {
		visit((ITypesEntity) entity);
		visit((Type) entity);
	}

	public void visit(Arguments entity) {
		visit((ITypesEntity) entity);
	}

	public void visit(Cases entity) {
		visit((ITypesEntity) entity);
	}

	public void visit(Case entity) {
		visit((ITypesEntity) entity);
	}

	public void visit(Expressions entity) {
	}

	public void visit(OrExpressions entity) {
		visit((ITypesEntity) entity);
		visit((Expressions) entity);
	}

	public void visit(TypeExpressions entity) {
		visit((ITypesEntity) entity);
		visit((Expressions) entity);
	}

	public void visit(Subtype entity) {
		visit((ITypesEntity) entity);
		visit((TypeExpression) entity);
	}

	public void visit(Supertype entity) {
		visit((ITypesEntity) entity);
		visit((TypeExpression) entity);
	}
}
