package org.whole.lang.sql.visitors;

import org.whole.lang.sql.visitors.SQLIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.sql.model.*;

/** 
 * @generator Whole
 */
public class SQLTraverseAllSwitchVisitor extends
		SQLIdentityUnaryVisitor<IVisitor> {
	public SQLTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(SQLStatements entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Select entity) {
		wGetVisitor1().visit(entity.getSelectType());
		wGetVisitor1().visit(entity.getColumnExprs());
		wGetVisitor1().visit(entity.getFromClauses());
		wGetVisitor1().visit(entity.getWhereExpr());
		wGetVisitor1().visit(entity.getGroupByExprs());
		wGetVisitor1().visit(entity.getHavingExpr());
		wGetVisitor1().visit(entity.getOrderByColumnExprs());
	}

	public void visit(UnionSelect entity) {
		wGetVisitor1().visit(entity.getSimpleSelect());
		wGetVisitor1().visit(entity.getUnionSelectStatement());
	}

	public void visit(Insert entity) {
		wGetVisitor1().visit(entity.getTableName());
		wGetVisitor1().visit(entity.getColumnNames());
		wGetVisitor1().visit(entity.getValues());
	}

	public void visit(InsertFromSelect entity) {
		wGetVisitor1().visit(entity.getTableName());
		wGetVisitor1().visit(entity.getColumnNames());
		wGetVisitor1().visit(entity.getSelect());
	}

	public void visit(Update entity) {
		wGetVisitor1().visit(entity.getTableName());
		wGetVisitor1().visit(entity.getSetClauses());
		wGetVisitor1().visit(entity.getFromClauses());
		wGetVisitor1().visit(entity.getWhereExpr());
		wGetVisitor1().visit(entity.getLimit());
	}

	public void visit(Create entity) {
		wGetVisitor1().visit(entity.getTableName());
		wGetVisitor1().visit(entity.getDeclarationOrConstraints());
	}

	public void visit(Delete entity) {
		wGetVisitor1().visit(entity.getTableName());
		wGetVisitor1().visit(entity.getWhereExpr());
		wGetVisitor1().visit(entity.getLimit());
	}

	public void visit(Drop entity) {
		wGetVisitor1().visit(entity.getTableName());
	}

	public void visit(Truncate entity) {
		wGetVisitor1().visit(entity.getTableName());
	}

	public void visit(AlterTable entity) {
		wGetVisitor1().visit(entity.getTableName());
		wGetVisitor1().visit(entity.getAction());
	}

	public void visit(CreateIndex entity) {
		wGetVisitor1().visit(entity.getUnique());
		wGetVisitor1().visit(entity.getIndexName());
		wGetVisitor1().visit(entity.getTableName());
		wGetVisitor1().visit(entity.getIndexDeclarations());
	}

	public void visit(IndexDeclarations entity) {
		for (IndexDeclaration child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(IndexDeclaration entity) {
		wGetVisitor1().visit(entity.getColumnName());
		wGetVisitor1().visit(entity.getOrderType());
		wGetVisitor1().visit(entity.getNullOrderType());
	}

	public void visit(DropIndex entity) {
		wGetVisitor1().visit(entity.getIndexName());
	}

	public void visit(Foreach entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getArrayExp());
		wGetVisitor1().visit(entity.getTrueBody());
	}

	public void visit(AddAction entity) {
		wGetVisitor1().visit(entity.getDeclarationOrConstraint());
	}

	public void visit(ColumnNames entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ColumnExpressions entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ColumnExpression entity) {
		wGetVisitor1().visit(entity.getExpression());
		wGetVisitor1().visit(entity.getAlias());
	}

	public void visit(FromClauses entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(InnerJoinFromClause entity) {
		wGetVisitor1().visit(entity.getTableName());
		wGetVisitor1().visit(entity.getInnerTable());
		wGetVisitor1().visit(entity.getOnExpression());
	}

	public void visit(LeftOuterJoinFromClause entity) {
		wGetVisitor1().visit(entity.getTableName());
		wGetVisitor1().visit(entity.getOuterTable());
		wGetVisitor1().visit(entity.getOnExpression());
	}

	public void visit(RightOuterJoinFromClause entity) {
		wGetVisitor1().visit(entity.getTableName());
		wGetVisitor1().visit(entity.getOuterTable());
		wGetVisitor1().visit(entity.getOnExpression());
	}

	public void visit(Between entity) {
		wGetVisitor1().visit(entity.getExpression());
		wGetVisitor1().visit(entity.getLowerExpression());
		wGetVisitor1().visit(entity.getUpperExpression());
	}

	public void visit(NotBetween entity) {
		wGetVisitor1().visit(entity.getExpression());
		wGetVisitor1().visit(entity.getLowerExpression());
		wGetVisitor1().visit(entity.getUpperExpression());
	}

	public void visit(Is entity) {
		wGetVisitor1().visit(entity.getExpression());
		wGetVisitor1().visit(entity.getType());
	}

	public void visit(Values entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ParenthesizedExpression entity) {
		wGetVisitor1().visit(entity.getExpression());
	}

	public void visit(SQLExpressions entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(CaseExpression entity) {
		wGetVisitor1().visit(entity.getWhenClauses());
		wGetVisitor1().visit(entity.getElseClause());
	}

	public void visit(WhenClauses entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(WhenClause entity) {
		wGetVisitor1().visit(entity.getCondition());
		wGetVisitor1().visit(entity.getResult());
	}

	public void visit(In entity) {
		wGetVisitor1().visit(entity.getLeftExpr());
		wGetVisitor1().visit(entity.getInPredicate());
	}

	public void visit(NotIn entity) {
		wGetVisitor1().visit(entity.getLeftExpr());
		wGetVisitor1().visit(entity.getInPredicate());
	}

	public void visit(Subquery entity) {
		wGetVisitor1().visit(entity.getQuery());
	}

	public void visit(InValueList entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(BinaryExpression entity) {
		wGetVisitor1().visit(entity.getLeftExpr());
		wGetVisitor1().visit(entity.getOperator());
		wGetVisitor1().visit(entity.getRightExpr());
	}

	public void visit(BooleanBinaryExpression entity) {
		wGetVisitor1().visit(entity.getLeftExpr());
		wGetVisitor1().visit(entity.getOperator());
		wGetVisitor1().visit(entity.getRightExpr());
	}

	public void visit(FunctionExpression entity) {
		wGetVisitor1().visit(entity.getFunctionName());
		wGetVisitor1().visit(entity.getParams());
	}

	public void visit(OrderByColumnExpressions entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(OrderByColumnExpression entity) {
		wGetVisitor1().visit(entity.getExpression());
		wGetVisitor1().visit(entity.getOrderType());
	}

	public void visit(SetClauses entity) {
		for (SetClause child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(SetClause entity) {
		wGetVisitor1().visit(entity.getColumnName());
		wGetVisitor1().visit(entity.getExpression());
	}

	public void visit(DeclarationOrConstraints entity) {
		for (DeclarationOrConstraint child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(ColumnDeclaration entity) {
		wGetVisitor1().visit(entity.getColumnName());
		wGetVisitor1().visit(entity.getColumnType());
		wGetVisitor1().visit(entity.getColumnConstraints());
	}

	public void visit(ColumnType entity) {
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getSize());
		wGetVisitor1().visit(entity.getPrecision());
	}

	public void visit(ColumnConstraints entity) {
		for (ColumnConstraint child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(ForeignKeyColumnConstraint entity) {
		wGetVisitor1().visit(entity.getForeignTableName());
		wGetVisitor1().visit(entity.getForeignColumnName());
	}

	public void visit(UniqueTableConstraint entity) {
		wGetVisitor1().visit(entity.getColumnNames());
	}

	public void visit(PrimaryKeyTableConstraint entity) {
		wGetVisitor1().visit(entity.getColumnNames());
	}

	public void visit(ForeignKeyTableConstraint entity) {
		wGetVisitor1().visit(entity.getColumnNames());
		wGetVisitor1().visit(entity.getForeignTableName());
		wGetVisitor1().visit(entity.getForeignColumnNames());
		wGetVisitor1().visit(entity.getMatch());
		wGetVisitor1().visit(entity.getOnDelete());
		wGetVisitor1().visit(entity.getOnUpdate());
		wGetVisitor1().visit(entity.getDeferrable());
		wGetVisitor1().visit(entity.getDeferCheck());
	}

	public void visit(StoredProcedures entity) {
		for (StoredProcedure child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(StoredProcedure entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getProcedureDeclarations());
		wGetVisitor1().visit(entity.getProcedureStatements());
	}

	public void visit(ProcedureDeclarations entity) {
		for (ProcedureDeclaration child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(ProcedureStatements entity) {
		for (SQLStatement child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(DeclareCursor entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getSqlStatement());
	}

	public void visit(SimpleVariableDeclaration entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getType());
	}

	public void visit(VariableDeclaration entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getReference());
		wGetVisitor1().visit(entity.getReferenceType());
	}
}
