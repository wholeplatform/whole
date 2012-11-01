package org.whole.lang.sql.visitors;

import org.whole.lang.sql.visitors.SQLIdentityUnaryVisitor;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class SQLTraverseAllChildrenVisitor extends
		SQLIdentityUnaryVisitor<ISQLVisitor> {
	public SQLTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public SQLTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(SQLStatements entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Select entity) {
		entity.getSelectType().accept(wGetVisitor1());
		entity.getColumnExprs().accept(wGetVisitor1());
		entity.getFromClauses().accept(wGetVisitor1());
		entity.getWhereExpr().accept(wGetVisitor1());
		entity.getGroupByExprs().accept(wGetVisitor1());
		entity.getHavingExpr().accept(wGetVisitor1());
		entity.getOrderByColumnExprs().accept(wGetVisitor1());
	}

	public void visit(UnionSelect entity) {
		entity.getSimpleSelect().accept(wGetVisitor1());
		entity.getUnionSelectStatement().accept(wGetVisitor1());
	}

	public void visit(Insert entity) {
		entity.getTableName().accept(wGetVisitor1());
		entity.getColumnNames().accept(wGetVisitor1());
		entity.getValues().accept(wGetVisitor1());
	}

	public void visit(InsertFromSelect entity) {
		entity.getTableName().accept(wGetVisitor1());
		entity.getColumnNames().accept(wGetVisitor1());
		entity.getSelect().accept(wGetVisitor1());
	}

	public void visit(Update entity) {
		entity.getTableName().accept(wGetVisitor1());
		entity.getSetClauses().accept(wGetVisitor1());
		entity.getFromClauses().accept(wGetVisitor1());
		entity.getWhereExpr().accept(wGetVisitor1());
		entity.getLimit().accept(wGetVisitor1());
	}

	public void visit(Create entity) {
		entity.getTableName().accept(wGetVisitor1());
		entity.getDeclarationOrConstraints().accept(wGetVisitor1());
	}

	public void visit(Delete entity) {
		entity.getTableName().accept(wGetVisitor1());
		entity.getWhereExpr().accept(wGetVisitor1());
		entity.getLimit().accept(wGetVisitor1());
	}

	public void visit(Drop entity) {
		entity.getTableName().accept(wGetVisitor1());
	}

	public void visit(Truncate entity) {
		entity.getTableName().accept(wGetVisitor1());
	}

	public void visit(AlterTable entity) {
		entity.getTableName().accept(wGetVisitor1());
		entity.getAction().accept(wGetVisitor1());
	}

	public void visit(CreateIndex entity) {
		entity.getUnique().accept(wGetVisitor1());
		entity.getIndexName().accept(wGetVisitor1());
		entity.getTableName().accept(wGetVisitor1());
		entity.getIndexDeclarations().accept(wGetVisitor1());
	}

	public void visit(IndexDeclarations entity) {
		for (IndexDeclaration child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(IndexDeclaration entity) {
		entity.getColumnName().accept(wGetVisitor1());
		entity.getOrderType().accept(wGetVisitor1());
		entity.getNullOrderType().accept(wGetVisitor1());
	}

	public void visit(DropIndex entity) {
		entity.getIndexName().accept(wGetVisitor1());
	}

	public void visit(Foreach entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getArrayExp().accept(wGetVisitor1());
		entity.getTrueBody().accept(wGetVisitor1());
	}

	public void visit(AddAction entity) {
		entity.getDeclarationOrConstraint().accept(wGetVisitor1());
	}

	public void visit(ColumnNames entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ColumnExpressions entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ColumnExpression entity) {
		entity.getExpression().accept(wGetVisitor1());
		entity.getAlias().accept(wGetVisitor1());
	}

	public void visit(FromClauses entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(InnerJoinFromClause entity) {
		entity.getTableName().accept(wGetVisitor1());
		entity.getInnerTable().accept(wGetVisitor1());
		entity.getOnExpression().accept(wGetVisitor1());
	}

	public void visit(LeftOuterJoinFromClause entity) {
		entity.getTableName().accept(wGetVisitor1());
		entity.getOuterTable().accept(wGetVisitor1());
		entity.getOnExpression().accept(wGetVisitor1());
	}

	public void visit(RightOuterJoinFromClause entity) {
		entity.getTableName().accept(wGetVisitor1());
		entity.getOuterTable().accept(wGetVisitor1());
		entity.getOnExpression().accept(wGetVisitor1());
	}

	public void visit(Between entity) {
		entity.getExpression().accept(wGetVisitor1());
		entity.getLowerExpression().accept(wGetVisitor1());
		entity.getUpperExpression().accept(wGetVisitor1());
	}

	public void visit(NotBetween entity) {
		entity.getExpression().accept(wGetVisitor1());
		entity.getLowerExpression().accept(wGetVisitor1());
		entity.getUpperExpression().accept(wGetVisitor1());
	}

	public void visit(Is entity) {
		entity.getExpression().accept(wGetVisitor1());
		entity.getType().accept(wGetVisitor1());
	}

	public void visit(Values entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ParenthesizedExpression entity) {
		entity.getExpression().accept(wGetVisitor1());
	}

	public void visit(SQLExpressions entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(CaseExpression entity) {
		entity.getWhenClauses().accept(wGetVisitor1());
		entity.getElseClause().accept(wGetVisitor1());
	}

	public void visit(WhenClauses entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(WhenClause entity) {
		entity.getCondition().accept(wGetVisitor1());
		entity.getResult().accept(wGetVisitor1());
	}

	public void visit(In entity) {
		entity.getLeftExpr().accept(wGetVisitor1());
		entity.getInPredicate().accept(wGetVisitor1());
	}

	public void visit(NotIn entity) {
		entity.getLeftExpr().accept(wGetVisitor1());
		entity.getInPredicate().accept(wGetVisitor1());
	}

	public void visit(Subquery entity) {
		entity.getQuery().accept(wGetVisitor1());
	}

	public void visit(InValueList entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(BinaryExpression entity) {
		entity.getLeftExpr().accept(wGetVisitor1());
		entity.getOperator().accept(wGetVisitor1());
		entity.getRightExpr().accept(wGetVisitor1());
	}

	public void visit(BooleanBinaryExpression entity) {
		entity.getLeftExpr().accept(wGetVisitor1());
		entity.getOperator().accept(wGetVisitor1());
		entity.getRightExpr().accept(wGetVisitor1());
	}

	public void visit(FunctionExpression entity) {
		entity.getFunctionName().accept(wGetVisitor1());
		entity.getParams().accept(wGetVisitor1());
	}

	public void visit(OrderByColumnExpressions entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(OrderByColumnExpression entity) {
		entity.getExpression().accept(wGetVisitor1());
		entity.getOrderType().accept(wGetVisitor1());
	}

	public void visit(SetClauses entity) {
		for (SetClause child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(SetClause entity) {
		entity.getColumnName().accept(wGetVisitor1());
		entity.getExpression().accept(wGetVisitor1());
	}

	public void visit(DeclarationOrConstraints entity) {
		for (DeclarationOrConstraint child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(ColumnDeclaration entity) {
		entity.getColumnName().accept(wGetVisitor1());
		entity.getColumnType().accept(wGetVisitor1());
		entity.getColumnConstraints().accept(wGetVisitor1());
	}

	public void visit(ColumnType entity) {
		entity.getType().accept(wGetVisitor1());
		entity.getSize().accept(wGetVisitor1());
		entity.getPrecision().accept(wGetVisitor1());
	}

	public void visit(ColumnConstraints entity) {
		for (ColumnConstraint child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(ForeignKeyColumnConstraint entity) {
		entity.getForeignTableName().accept(wGetVisitor1());
		entity.getForeignColumnName().accept(wGetVisitor1());
	}

	public void visit(UniqueTableConstraint entity) {
		entity.getColumnNames().accept(wGetVisitor1());
	}

	public void visit(PrimaryKeyTableConstraint entity) {
		entity.getColumnNames().accept(wGetVisitor1());
	}

	public void visit(ForeignKeyTableConstraint entity) {
		entity.getColumnNames().accept(wGetVisitor1());
		entity.getForeignTableName().accept(wGetVisitor1());
		entity.getForeignColumnNames().accept(wGetVisitor1());
		entity.getMatch().accept(wGetVisitor1());
		entity.getOnDelete().accept(wGetVisitor1());
		entity.getOnUpdate().accept(wGetVisitor1());
		entity.getDeferrable().accept(wGetVisitor1());
		entity.getDeferCheck().accept(wGetVisitor1());
	}

	public void visit(StoredProcedures entity) {
		for (StoredProcedure child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(StoredProcedure entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getProcedureDeclarations().accept(wGetVisitor1());
		entity.getProcedureStatements().accept(wGetVisitor1());
	}

	public void visit(ProcedureDeclarations entity) {
		for (ProcedureDeclaration child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(ProcedureStatements entity) {
		for (SQLStatement child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(DeclareCursor entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getSqlStatement().accept(wGetVisitor1());
	}

	public void visit(SimpleVariableDeclaration entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getType().accept(wGetVisitor1());
	}

	public void visit(VariableDeclaration entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getReference().accept(wGetVisitor1());
		entity.getReferenceType().accept(wGetVisitor1());
	}
}
