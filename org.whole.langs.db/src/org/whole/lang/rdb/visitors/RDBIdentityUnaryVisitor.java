package org.whole.lang.rdb.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class RDBIdentityUnaryVisitor<V extends IVisitor> extends
		AbstractUnaryVisitor<V> implements IRDBVisitor {
	public RDBIdentityUnaryVisitor() {
		super(null);
	}

	public RDBIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		((IRDBEntity) entity).accept(this);
	}

	public void visit(Database entity) {
	}

	public void visit(Schemas entity) {
	}

	public void visit(Schema entity) {
	}

	public void visit(Tables entity) {
	}

	public void visit(Table entity) {
	}

	public void visit(Columns entity) {
	}

	public void visit(Column entity) {
	}

	public void visit(PrimaryKey entity) {
	}

	public void visit(ColumnNames entity) {
	}

	public void visit(ForeignKeys entity) {
	}

	public void visit(ForeignKey entity) {
	}

	public void visit(ColumnReferences entity) {
	}

	public void visit(ColumnReference entity) {
	}

	public void visit(Indices entity) {
	}

	public void visit(Index entity) {
	}

	public void visit(ColumnIndices entity) {
	}

	public void visit(ColumnIndex entity) {
	}

	public void visit(Type entity) {
	}

	public void visit(IndexType entity) {
	}

	public void visit(Order entity) {
	}

	public void visit(IdMethod entity) {
	}

	public void visit(Action entity) {
	}

	public void visit(Deferrability entity) {
	}

	public void visit(URI entity) {
	}

	public void visit(Namespace entity) {
	}

	public void visit(Name entity) {
	}

	public void visit(StringData entity) {
	}

	public void visit(IntData entity) {
	}

	public void visit(BooleanData entity) {
	}
}
