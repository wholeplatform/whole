package org.whole.lang.rdb.visitors;

import org.whole.lang.rdb.visitors.RDBIdentityUnaryVisitor;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class RDBTraverseAllVisitor extends RDBIdentityUnaryVisitor<IRDBVisitor> {
	public RDBTraverseAllVisitor() {
		wSetVisitor1(this);
	}

	public RDBTraverseAllVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Database entity) {
		entity.getUri().accept(wGetVisitor1());
		entity.getNamespace().accept(wGetVisitor1());
		entity.getSchemas().accept(wGetVisitor1());
	}

	public void visit(Schemas entity) {
		for (Schema child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(Schema entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getModelName().accept(wGetVisitor1());
		entity.getTables().accept(wGetVisitor1());
	}

	public void visit(Tables entity) {
		for (Table child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(Table entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getEntityName().accept(wGetVisitor1());
		entity.getColumns().accept(wGetVisitor1());
		entity.getPrimaryKey().accept(wGetVisitor1());
		entity.getForeignKeys().accept(wGetVisitor1());
		entity.getIndices().accept(wGetVisitor1());
		entity.getRemarks().accept(wGetVisitor1());
	}

	public void visit(Columns entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Column entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getFeatureName().accept(wGetVisitor1());
		entity.getFeatureType().accept(wGetVisitor1());
		entity.getType().accept(wGetVisitor1());
		entity.getSize().accept(wGetVisitor1());
		entity.getDecimals().accept(wGetVisitor1());
		entity.getNullable().accept(wGetVisitor1());
		entity.getDefaultValue().accept(wGetVisitor1());
		entity.getRemarks().accept(wGetVisitor1());
	}

	public void visit(PrimaryKey entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getIdMethod().accept(wGetVisitor1());
		entity.getColumnNames().accept(wGetVisitor1());
	}

	public void visit(ColumnNames entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ForeignKeys entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ForeignKey entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getTargetTable().accept(wGetVisitor1());
		entity.getUpdateAction().accept(wGetVisitor1());
		entity.getDeleteAction().accept(wGetVisitor1());
		entity.getDeferrability().accept(wGetVisitor1());
		entity.getColumnReferences().accept(wGetVisitor1());
	}

	public void visit(ColumnReferences entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ColumnReference entity) {
		entity.getSource().accept(wGetVisitor1());
		entity.getTarget().accept(wGetVisitor1());
	}

	public void visit(Indices entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Index entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getQualifier().accept(wGetVisitor1());
		entity.getUnique().accept(wGetVisitor1());
		entity.getType().accept(wGetVisitor1());
		entity.getColumnIndices().accept(wGetVisitor1());
	}

	public void visit(ColumnIndices entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ColumnIndex entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getOrder().accept(wGetVisitor1());
	}
}
