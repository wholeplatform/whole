package org.whole.lang.sql.visitors;

import org.whole.lang.sql.model.*;

/** 
 * @generator Whole
 */
public class SQLForwardStagedVisitor extends SQLIdentityVisitor {
	public void visit(SQLStatements entity) {
		stagedVisit(entity);
	}

	public void visit(Select entity) {
		stagedVisit(entity);
	}

	public void visit(UnionSelect entity) {
		stagedVisit(entity);
	}

	public void visit(Insert entity) {
		stagedVisit(entity);
	}

	public void visit(InsertFromSelect entity) {
		stagedVisit(entity);
	}

	public void visit(Update entity) {
		stagedVisit(entity);
	}

	public void visit(Create entity) {
		stagedVisit(entity);
	}

	public void visit(Delete entity) {
		stagedVisit(entity);
	}

	public void visit(Drop entity) {
		stagedVisit(entity);
	}

	public void visit(Truncate entity) {
		stagedVisit(entity);
	}

	public void visit(AlterTable entity) {
		stagedVisit(entity);
	}

	public void visit(CreateIndex entity) {
		stagedVisit(entity);
	}

	public void visit(UniqueIndex entity) {
		stagedVisit(entity);
	}

	public void visit(IndexDeclarations entity) {
		stagedVisit(entity);
	}

	public void visit(IndexDeclaration entity) {
		stagedVisit(entity);
	}

	public void visit(NullOrderType entity) {
		stagedVisit(entity);
	}

	public void visit(DropIndex entity) {
		stagedVisit(entity);
	}

	public void visit(Foreach entity) {
		stagedVisit(entity);
	}

	public void visit(AddAction entity) {
		stagedVisit(entity);
	}

	public void visit(SelectType entity) {
		stagedVisit(entity);
	}

	public void visit(ColumnNames entity) {
		stagedVisit(entity);
	}

	public void visit(ColumnExpressions entity) {
		stagedVisit(entity);
	}

	public void visit(ColumnExpression entity) {
		stagedVisit(entity);
	}

	public void visit(Alias entity) {
		stagedVisit(entity);
	}

	public void visit(FromClauses entity) {
		stagedVisit(entity);
	}

	public void visit(SimpleFromClause entity) {
		stagedVisit(entity);
	}

	public void visit(InnerJoinFromClause entity) {
		stagedVisit(entity);
	}

	public void visit(LeftOuterJoinFromClause entity) {
		stagedVisit(entity);
	}

	public void visit(RightOuterJoinFromClause entity) {
		stagedVisit(entity);
	}

	public void visit(Between entity) {
		stagedVisit(entity);
	}

	public void visit(NotBetween entity) {
		stagedVisit(entity);
	}

	public void visit(Is entity) {
		stagedVisit(entity);
	}

	public void visit(IsType entity) {
		stagedVisit(entity);
	}

	public void visit(Values entity) {
		stagedVisit(entity);
	}

	public void visit(ParenthesizedExpression entity) {
		stagedVisit(entity);
	}

	public void visit(SQLExpressions entity) {
		stagedVisit(entity);
	}

	public void visit(NullValue entity) {
		stagedVisit(entity);
	}

	public void visit(ArrayValue entity) {
		stagedVisit(entity);
	}

	public void visit(BooleanValue entity) {
		stagedVisit(entity);
	}

	public void visit(TinyIntValue entity) {
		stagedVisit(entity);
	}

	public void visit(SmallIntValue entity) {
		stagedVisit(entity);
	}

	public void visit(IntValue entity) {
		stagedVisit(entity);
	}

	public void visit(BigIntValue entity) {
		stagedVisit(entity);
	}

	public void visit(DoubleValue entity) {
		stagedVisit(entity);
	}

	public void visit(RealValue entity) {
		stagedVisit(entity);
	}

	public void visit(DecimalValue entity) {
		stagedVisit(entity);
	}

	public void visit(StringValue entity) {
		stagedVisit(entity);
	}

	public void visit(BinaryValue entity) {
		stagedVisit(entity);
	}

	public void visit(DateValue entity) {
		stagedVisit(entity);
	}

	public void visit(TimeValue entity) {
		stagedVisit(entity);
	}

	public void visit(TimestampValue entity) {
		stagedVisit(entity);
	}

	public void visit(BlobValue entity) {
		stagedVisit(entity);
	}

	public void visit(ClobValue entity) {
		stagedVisit(entity);
	}

	public void visit(RawValue entity) {
		stagedVisit(entity);
	}

	public void visit(TableName entity) {
		stagedVisit(entity);
	}

	public void visit(ColumnName entity) {
		stagedVisit(entity);
	}

	public void visit(IndexName entity) {
		stagedVisit(entity);
	}

	public void visit(CaseExpression entity) {
		stagedVisit(entity);
	}

	public void visit(WhenClauses entity) {
		stagedVisit(entity);
	}

	public void visit(WhenClause entity) {
		stagedVisit(entity);
	}

	public void visit(In entity) {
		stagedVisit(entity);
	}

	public void visit(NotIn entity) {
		stagedVisit(entity);
	}

	public void visit(Subquery entity) {
		stagedVisit(entity);
	}

	public void visit(InValueList entity) {
		stagedVisit(entity);
	}

	public void visit(BinaryExpression entity) {
		stagedVisit(entity);
	}

	public void visit(BinaryOperator entity) {
		stagedVisit(entity);
	}

	public void visit(BooleanBinaryExpression entity) {
		stagedVisit(entity);
	}

	public void visit(BooleanOperator entity) {
		stagedVisit(entity);
	}

	public void visit(FunctionExpression entity) {
		stagedVisit(entity);
	}

	public void visit(FunctionName entity) {
		stagedVisit(entity);
	}

	public void visit(OrderByColumnExpressions entity) {
		stagedVisit(entity);
	}

	public void visit(OrderByColumnExpression entity) {
		stagedVisit(entity);
	}

	public void visit(OrderType entity) {
		stagedVisit(entity);
	}

	public void visit(SetClauses entity) {
		stagedVisit(entity);
	}

	public void visit(SetClause entity) {
		stagedVisit(entity);
	}

	public void visit(DeclarationOrConstraints entity) {
		stagedVisit(entity);
	}

	public void visit(ColumnDeclaration entity) {
		stagedVisit(entity);
	}

	public void visit(ColumnType entity) {
		stagedVisit(entity);
	}

	public void visit(Type entity) {
		stagedVisit(entity);
	}

	public void visit(ColumnConstraints entity) {
		stagedVisit(entity);
	}

	public void visit(SimpleColumnConstraint entity) {
		stagedVisit(entity);
	}

	public void visit(ForeignKeyColumnConstraint entity) {
		stagedVisit(entity);
	}

	public void visit(UniqueTableConstraint entity) {
		stagedVisit(entity);
	}

	public void visit(PrimaryKeyTableConstraint entity) {
		stagedVisit(entity);
	}

	public void visit(ForeignKeyTableConstraint entity) {
		stagedVisit(entity);
	}

	public void visit(Match entity) {
		stagedVisit(entity);
	}

	public void visit(Action entity) {
		stagedVisit(entity);
	}

	public void visit(Deferrable entity) {
		stagedVisit(entity);
	}

	public void visit(DeferCheck entity) {
		stagedVisit(entity);
	}

	public void visit(StoredProcedures entity) {
		stagedVisit(entity);
	}

	public void visit(StoredProcedure entity) {
		stagedVisit(entity);
	}

	public void visit(ProcedureDeclarations entity) {
		stagedVisit(entity);
	}

	public void visit(ProcedureStatements entity) {
		stagedVisit(entity);
	}

	public void visit(DeclareCursor entity) {
		stagedVisit(entity);
	}

	public void visit(SimpleVariableDeclaration entity) {
		stagedVisit(entity);
	}

	public void visit(VariableDeclaration entity) {
		stagedVisit(entity);
	}

	public void visit(Reference entity) {
		stagedVisit(entity);
	}

	public void visit(ReferenceType entity) {
		stagedVisit(entity);
	}

	public void visit(ArrayExpr entity) {
		stagedVisit(entity);
	}

	public void visit(Name entity) {
		stagedVisit(entity);
	}
}
