package org.whole.lang.sql.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SQLForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<ISQLVisitor> implements ISQLVisitor {
	public SQLForwardStrategyVisitor() {
		this(new SQLIdentityVisitor());
	}

	public SQLForwardStrategyVisitor(ISQLVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((ISQLEntity) entity).accept(this);
	}

	public void visit(SQLStatements entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Select entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(UnionSelect entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Insert entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(InsertFromSelect entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Update entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Create entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Delete entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Drop entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Truncate entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AlterTable entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CreateIndex entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(UniqueIndex entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IndexDeclarations entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IndexDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NullOrderType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DropIndex entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Foreach entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AddAction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SelectType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ColumnNames entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ColumnExpressions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ColumnExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Alias entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FromClauses entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleFromClause entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(InnerJoinFromClause entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LeftOuterJoinFromClause entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(RightOuterJoinFromClause entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Between entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NotBetween entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Is entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IsType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Values entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ParenthesizedExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SQLExpressions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NullValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ArrayValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BooleanValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TinyIntValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SmallIntValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IntValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BigIntValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DoubleValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(RealValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DecimalValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StringValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BinaryValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DateValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TimeValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TimestampValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BlobValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ClobValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(RawValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TableName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ColumnName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IndexName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CaseExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(WhenClauses entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(WhenClause entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(In entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NotIn entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Subquery entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(InValueList entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BinaryExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BinaryOperator entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BooleanBinaryExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BooleanOperator entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FunctionExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FunctionName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(OrderByColumnExpressions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(OrderByColumnExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(OrderType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SetClauses entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SetClause entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DeclarationOrConstraints entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ColumnDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ColumnType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Type entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ColumnConstraints entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleColumnConstraint entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ForeignKeyColumnConstraint entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(UniqueTableConstraint entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PrimaryKeyTableConstraint entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ForeignKeyTableConstraint entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Match entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Action entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Deferrable entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DeferCheck entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StoredProcedures entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StoredProcedure entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ProcedureDeclarations entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ProcedureStatements entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DeclareCursor entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleVariableDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VariableDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Reference entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ReferenceType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ArrayExpr entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Name entity) {
		wGetStrategy().visit(entity);
	}
}
