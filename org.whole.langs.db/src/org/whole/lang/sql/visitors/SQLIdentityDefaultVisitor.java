package org.whole.lang.sql.visitors;

import org.whole.lang.sql.model.*;

/** 
 * @generator Whole
 */
public class SQLIdentityDefaultVisitor extends SQLIdentityVisitor {
	public void visit(ISQLEntity entity) {
	}

	public void visit(SQLStatements entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(SQLStatement entity) {
	}

	public void visit(SelectSQLStatement entity) {
		visit((SQLStatement) entity);
	}

	public void visit(Select entity) {
		visit((ISQLEntity) entity);
		visit((SelectSQLStatement) entity);
	}

	public void visit(UnionSelect entity) {
		visit((ISQLEntity) entity);
		visit((SelectSQLStatement) entity);
	}

	public void visit(Insert entity) {
		visit((ISQLEntity) entity);
		visit((SQLStatement) entity);
	}

	public void visit(InsertFromSelect entity) {
		visit((ISQLEntity) entity);
		visit((SQLStatement) entity);
	}

	public void visit(Update entity) {
		visit((ISQLEntity) entity);
		visit((SQLStatement) entity);
	}

	public void visit(Create entity) {
		visit((ISQLEntity) entity);
		visit((SQLStatement) entity);
	}

	public void visit(Delete entity) {
		visit((ISQLEntity) entity);
		visit((SQLStatement) entity);
	}

	public void visit(Drop entity) {
		visit((ISQLEntity) entity);
		visit((SQLStatement) entity);
	}

	public void visit(Truncate entity) {
		visit((ISQLEntity) entity);
		visit((SQLStatement) entity);
	}

	public void visit(AlterTable entity) {
		visit((ISQLEntity) entity);
		visit((SQLStatement) entity);
	}

	public void visit(CreateIndex entity) {
		visit((ISQLEntity) entity);
		visit((SQLStatement) entity);
	}

	public void visit(UniqueIndex entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(IndexDeclarations entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(IndexDeclaration entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(NullOrderType entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(DropIndex entity) {
		visit((ISQLEntity) entity);
		visit((SQLStatement) entity);
	}

	public void visit(Foreach entity) {
		visit((ISQLEntity) entity);
		visit((SQLStatement) entity);
	}

	public void visit(AlterAction entity) {
	}

	public void visit(AddAction entity) {
		visit((ISQLEntity) entity);
		visit((AlterAction) entity);
	}

	public void visit(SelectType entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(ColumnNames entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(ColumnExpressions entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(ColumnExpression entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(Alias entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(FromClauses entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(FromClause entity) {
	}

	public void visit(SimpleFromClause entity) {
		visit((ISQLEntity) entity);
		visit((FromClause) entity);
	}

	public void visit(InnerJoinFromClause entity) {
		visit((ISQLEntity) entity);
		visit((FromClause) entity);
	}

	public void visit(LeftOuterJoinFromClause entity) {
		visit((ISQLEntity) entity);
		visit((FromClause) entity);
	}

	public void visit(RightOuterJoinFromClause entity) {
		visit((ISQLEntity) entity);
		visit((FromClause) entity);
	}

	public void visit(BooleanExpression entity) {
		visit((SQLExpression) entity);
	}

	public void visit(Between entity) {
		visit((ISQLEntity) entity);
		visit((BooleanExpression) entity);
	}

	public void visit(NotBetween entity) {
		visit((ISQLEntity) entity);
		visit((BooleanExpression) entity);
	}

	public void visit(Is entity) {
		visit((ISQLEntity) entity);
		visit((BooleanExpression) entity);
	}

	public void visit(IsType entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(Values entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(SQLExpression entity) {
	}

	public void visit(ParenthesizedExpression entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(SQLExpressions entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(NullValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(ArrayValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(BooleanValue entity) {
		visit((ISQLEntity) entity);
		visit((BooleanExpression) entity);
	}

	public void visit(TinyIntValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(SmallIntValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(IntValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(BigIntValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(DoubleValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(RealValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(DecimalValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(StringValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(BinaryValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(DateValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(TimeValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(TimestampValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(BlobValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(ClobValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(RawValue entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(TableName entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(ColumnName entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(IndexName entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(ConstraintName entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(CaseExpression entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(InPredicate entity) {
		visit((SQLExpression) entity);
	}

	public void visit(WhenClauses entity) {
		visit((ISQLEntity) entity);
		visit((InPredicate) entity);
	}

	public void visit(WhenClause entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(In entity) {
		visit((ISQLEntity) entity);
		visit((BooleanExpression) entity);
	}

	public void visit(NotIn entity) {
		visit((ISQLEntity) entity);
		visit((BooleanExpression) entity);
	}

	public void visit(Subquery entity) {
		visit((ISQLEntity) entity);
		visit((InPredicate) entity);
	}

	public void visit(InValueList entity) {
		visit((ISQLEntity) entity);
		visit((InPredicate) entity);
	}

	public void visit(BinaryExpression entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(BinaryOperator entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(BooleanBinaryExpression entity) {
		visit((ISQLEntity) entity);
		visit((BooleanExpression) entity);
	}

	public void visit(BooleanOperator entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(FunctionExpression entity) {
		visit((ISQLEntity) entity);
		visit((SQLExpression) entity);
	}

	public void visit(FunctionName entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(OrderByColumnExpressions entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(OrderByColumnExpression entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(OrderType entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(SetClauses entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(SetClause entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(DeclarationOrConstraints entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(DeclarationOrConstraint entity) {
	}

	public void visit(ColumnDeclaration entity) {
		visit((ISQLEntity) entity);
		visit((DeclarationOrConstraint) entity);
	}

	public void visit(ColumnType entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(Type entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(ColumnConstraints entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(SimpleColumnConstraint entity) {
		visit((ISQLEntity) entity);
		visit((ColumnConstraint) entity);
	}

	public void visit(ColumnConstraint entity) {
	}

	public void visit(ForeignKeyColumnConstraint entity) {
		visit((ISQLEntity) entity);
		visit((ColumnConstraint) entity);
	}

	public void visit(TableConstraint entity) {
		visit((DeclarationOrConstraint) entity);
	}

	public void visit(UniqueTableConstraint entity) {
		visit((ISQLEntity) entity);
		visit((TableConstraint) entity);
	}

	public void visit(PrimaryKeyTableConstraint entity) {
		visit((ISQLEntity) entity);
		visit((TableConstraint) entity);
	}

	public void visit(ForeignKeyTableConstraint entity) {
		visit((ISQLEntity) entity);
		visit((TableConstraint) entity);
	}

	public void visit(Match entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(Action entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(Deferrable entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(DeferCheck entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(StoredProcedures entity) {
		visit((ISQLEntity) entity);
		visit((SQLStatement) entity);
	}

	public void visit(StoredProcedure entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(ProcedureDeclarations entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(ProcedureStatements entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(ProcedureDeclaration entity) {
	}

	public void visit(DeclareCursor entity) {
		visit((ISQLEntity) entity);
		visit((ProcedureDeclaration) entity);
	}

	public void visit(SimpleVariableDeclaration entity) {
		visit((ISQLEntity) entity);
		visit((ProcedureDeclaration) entity);
	}

	public void visit(VariableDeclaration entity) {
		visit((ISQLEntity) entity);
		visit((ProcedureDeclaration) entity);
	}

	public void visit(Reference entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(ReferenceType entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(ArrayExpr entity) {
		visit((ISQLEntity) entity);
	}

	public void visit(Name entity) {
		visit((ISQLEntity) entity);
	}
}
