package org.whole.lang.rdb.visitors;

import org.whole.lang.rdb.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class RDBFailureVisitor extends RDBIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Database entity) {
		throw new VisitException();
	}

	public void visit(Schemas entity) {
		throw new VisitException();
	}

	public void visit(Schema entity) {
		throw new VisitException();
	}

	public void visit(Tables entity) {
		throw new VisitException();
	}

	public void visit(Table entity) {
		throw new VisitException();
	}

	public void visit(Columns entity) {
		throw new VisitException();
	}

	public void visit(Column entity) {
		throw new VisitException();
	}

	public void visit(PrimaryKey entity) {
		throw new VisitException();
	}

	public void visit(ColumnNames entity) {
		throw new VisitException();
	}

	public void visit(ForeignKeys entity) {
		throw new VisitException();
	}

	public void visit(ForeignKey entity) {
		throw new VisitException();
	}

	public void visit(ColumnReferences entity) {
		throw new VisitException();
	}

	public void visit(ColumnReference entity) {
		throw new VisitException();
	}

	public void visit(Indices entity) {
		throw new VisitException();
	}

	public void visit(Index entity) {
		throw new VisitException();
	}

	public void visit(ColumnIndices entity) {
		throw new VisitException();
	}

	public void visit(ColumnIndex entity) {
		throw new VisitException();
	}

	public void visit(Type entity) {
		throw new VisitException();
	}

	public void visit(IndexType entity) {
		throw new VisitException();
	}

	public void visit(Order entity) {
		throw new VisitException();
	}

	public void visit(IdMethod entity) {
		throw new VisitException();
	}

	public void visit(Action entity) {
		throw new VisitException();
	}

	public void visit(Deferrability entity) {
		throw new VisitException();
	}

	public void visit(URI entity) {
		throw new VisitException();
	}

	public void visit(Namespace entity) {
		throw new VisitException();
	}

	public void visit(Name entity) {
		throw new VisitException();
	}

	public void visit(StringData entity) {
		throw new VisitException();
	}

	public void visit(IntData entity) {
		throw new VisitException();
	}

	public void visit(BooleanData entity) {
		throw new VisitException();
	}
}
