package org.whole.lang.types.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TypesForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<ITypesVisitor> implements ITypesVisitor {
	public TypesForwardStrategyVisitor() {
		this(new TypesIdentityVisitor());
	}

	public TypesForwardStrategyVisitor(ITypesVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((ITypesEntity) entity).accept(this);
	}

	public void visit(TypeSystem entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TypeRules entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TypeRule entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AnyType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LegacyType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VariableType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EntityType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(UnionType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FeatureType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FeatureTableType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Arguments entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Cases entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Case entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(OrExpressions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TypeExpressions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Subtype entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Supertype entity) {
		wGetStrategy().visit(entity);
	}
}
