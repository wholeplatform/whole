package org.whole.lang.rdb.visitors;

import org.whole.lang.rdb.visitors.RDBIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.rdb.model.*;

/** 
 * @generator Whole
 */
public class RDBTraverseAllSwitchVisitor extends
		RDBIdentityUnaryVisitor<IVisitor> {
	public RDBTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Database entity) {
		wGetVisitor1().visit(entity.getUri());
		wGetVisitor1().visit(entity.getNamespace());
		wGetVisitor1().visit(entity.getSchemas());
	}

	public void visit(Schemas entity) {
		for (Schema child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(Schema entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getModelName());
		wGetVisitor1().visit(entity.getTables());
	}

	public void visit(Tables entity) {
		for (Table child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(Table entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getEntityName());
		wGetVisitor1().visit(entity.getColumns());
		wGetVisitor1().visit(entity.getPrimaryKey());
		wGetVisitor1().visit(entity.getForeignKeys());
		wGetVisitor1().visit(entity.getIndices());
		wGetVisitor1().visit(entity.getRemarks());
	}

	public void visit(Columns entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Column entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getFeatureName());
		wGetVisitor1().visit(entity.getFeatureType());
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getSize());
		wGetVisitor1().visit(entity.getDecimals());
		wGetVisitor1().visit(entity.getNullable());
		wGetVisitor1().visit(entity.getDefaultValue());
		wGetVisitor1().visit(entity.getRemarks());
	}

	public void visit(PrimaryKey entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getIdMethod());
		wGetVisitor1().visit(entity.getColumnNames());
	}

	public void visit(ColumnNames entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ForeignKeys entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ForeignKey entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTargetTable());
		wGetVisitor1().visit(entity.getUpdateAction());
		wGetVisitor1().visit(entity.getDeleteAction());
		wGetVisitor1().visit(entity.getDeferrability());
		wGetVisitor1().visit(entity.getColumnReferences());
	}

	public void visit(ColumnReferences entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ColumnReference entity) {
		wGetVisitor1().visit(entity.getSource());
		wGetVisitor1().visit(entity.getTarget());
	}

	public void visit(Indices entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Index entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getQualifier());
		wGetVisitor1().visit(entity.getUnique());
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getColumnIndices());
	}

	public void visit(ColumnIndices entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ColumnIndex entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getOrder());
	}
}
