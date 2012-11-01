package org.whole.lang.rdb.visitors;

import org.whole.lang.rdb.model.*;

/** 
 * @generator Whole
 */
public class RDBForwardStagedVisitor extends RDBIdentityVisitor {
	public void visit(Database entity) {
		stagedVisit(entity);
	}

	public void visit(Schemas entity) {
		stagedVisit(entity);
	}

	public void visit(Schema entity) {
		stagedVisit(entity);
	}

	public void visit(Tables entity) {
		stagedVisit(entity);
	}

	public void visit(Table entity) {
		stagedVisit(entity);
	}

	public void visit(Columns entity) {
		stagedVisit(entity);
	}

	public void visit(Column entity) {
		stagedVisit(entity);
	}

	public void visit(PrimaryKey entity) {
		stagedVisit(entity);
	}

	public void visit(ColumnNames entity) {
		stagedVisit(entity);
	}

	public void visit(ForeignKeys entity) {
		stagedVisit(entity);
	}

	public void visit(ForeignKey entity) {
		stagedVisit(entity);
	}

	public void visit(ColumnReferences entity) {
		stagedVisit(entity);
	}

	public void visit(ColumnReference entity) {
		stagedVisit(entity);
	}

	public void visit(Indices entity) {
		stagedVisit(entity);
	}

	public void visit(Index entity) {
		stagedVisit(entity);
	}

	public void visit(ColumnIndices entity) {
		stagedVisit(entity);
	}

	public void visit(ColumnIndex entity) {
		stagedVisit(entity);
	}

	public void visit(Type entity) {
		stagedVisit(entity);
	}

	public void visit(IndexType entity) {
		stagedVisit(entity);
	}

	public void visit(Order entity) {
		stagedVisit(entity);
	}

	public void visit(IdMethod entity) {
		stagedVisit(entity);
	}

	public void visit(Action entity) {
		stagedVisit(entity);
	}

	public void visit(Deferrability entity) {
		stagedVisit(entity);
	}

	public void visit(URI entity) {
		stagedVisit(entity);
	}

	public void visit(Namespace entity) {
		stagedVisit(entity);
	}

	public void visit(Name entity) {
		stagedVisit(entity);
	}

	public void visit(StringData entity) {
		stagedVisit(entity);
	}

	public void visit(IntData entity) {
		stagedVisit(entity);
	}

	public void visit(BooleanData entity) {
		stagedVisit(entity);
	}
}
