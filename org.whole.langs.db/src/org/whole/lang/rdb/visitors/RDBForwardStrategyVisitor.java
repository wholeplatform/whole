package org.whole.lang.rdb.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class RDBForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IRDBVisitor> implements IRDBVisitor {
	public RDBForwardStrategyVisitor() {
		this(new RDBIdentityVisitor());
	}

	public RDBForwardStrategyVisitor(IRDBVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IRDBEntity) entity).accept(this);
	}

	public void visit(Database entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Schemas entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Schema entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Tables entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Table entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Columns entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Column entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PrimaryKey entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ColumnNames entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ForeignKeys entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ForeignKey entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ColumnReferences entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ColumnReference entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Indices entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Index entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ColumnIndices entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ColumnIndex entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Type entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IndexType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Order entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IdMethod entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Action entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Deferrability entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(URI entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Namespace entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Name entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StringData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IntData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BooleanData entity) {
		wGetStrategy().visit(entity);
	}
}
