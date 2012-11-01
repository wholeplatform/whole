package org.whole.lang.rdb.visitors;

import org.whole.lang.rdb.model.*;

/** 
 * @generator Whole
 */
public class RDBIdentityDefaultVisitor extends RDBIdentityVisitor {
	public void visit(IRDBEntity entity) {
	}

	public void visit(Database entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(Schemas entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(Schema entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(Tables entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(Table entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(Columns entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(Column entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(PrimaryKey entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(ColumnNames entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(ForeignKeys entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(ForeignKey entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(ColumnReferences entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(ColumnReference entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(Indices entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(Index entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(ColumnIndices entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(ColumnIndex entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(Type entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(IndexType entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(Order entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(IdMethod entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(Action entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(Deferrability entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(URI entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(Namespace entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(Name entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(StringData entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(IntData entity) {
		visit((IRDBEntity) entity);
	}

	public void visit(BooleanData entity) {
		visit((IRDBEntity) entity);
	}
}
