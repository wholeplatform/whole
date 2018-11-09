package org.whole.lang.sql.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SQLIdentityUnaryVisitor<V extends IVisitor> extends AbstractUnaryVisitor<V> implements ISQLVisitor {
	public SQLIdentityUnaryVisitor() {
		super(null);
	}

	public SQLIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		((ISQLEntity) entity).accept(this);
	}

	public void visit(SQLStatements entity) {
	}

	public void visit(Select entity) {
	}

	public void visit(UnionSelect entity) {
	}

	public void visit(Insert entity) {
	}

	public void visit(InsertFromSelect entity) {
	}

	public void visit(Update entity) {
	}

	public void visit(Create entity) {
	}

	public void visit(Delete entity) {
	}

	public void visit(Drop entity) {
	}

	public void visit(Truncate entity) {
	}

	public void visit(AlterTable entity) {
	}

	public void visit(CreateIndex entity) {
	}

	public void visit(UniqueIndex entity) {
	}

	public void visit(IndexDeclarations entity) {
	}

	public void visit(IndexDeclaration entity) {
	}

	public void visit(NullOrderType entity) {
	}

	public void visit(DropIndex entity) {
	}

	public void visit(Foreach entity) {
	}

	public void visit(AddAction entity) {
	}

	public void visit(SelectType entity) {
	}

	public void visit(ColumnNames entity) {
	}

	public void visit(ColumnExpressions entity) {
	}

	public void visit(ColumnExpression entity) {
	}

	public void visit(Alias entity) {
	}

	public void visit(FromClauses entity) {
	}

	public void visit(SimpleFromClause entity) {
	}

	public void visit(InnerJoinFromClause entity) {
	}

	public void visit(LeftOuterJoinFromClause entity) {
	}

	public void visit(RightOuterJoinFromClause entity) {
	}

	public void visit(Between entity) {
	}

	public void visit(NotBetween entity) {
	}

	public void visit(Is entity) {
	}

	public void visit(IsType entity) {
	}

	public void visit(Values entity) {
	}

	public void visit(ParenthesizedExpression entity) {
	}

	public void visit(SQLExpressions entity) {
	}

	public void visit(NullValue entity) {
	}

	public void visit(ArrayValue entity) {
	}

	public void visit(BooleanValue entity) {
	}

	public void visit(TinyIntValue entity) {
	}

	public void visit(SmallIntValue entity) {
	}

	public void visit(IntValue entity) {
	}

	public void visit(BigIntValue entity) {
	}

	public void visit(DoubleValue entity) {
	}

	public void visit(RealValue entity) {
	}

	public void visit(DecimalValue entity) {
	}

	public void visit(StringValue entity) {
	}

	public void visit(BinaryValue entity) {
	}

	public void visit(DateValue entity) {
	}

	public void visit(TimeValue entity) {
	}

	public void visit(TimestampValue entity) {
	}

	public void visit(BlobValue entity) {
	}

	public void visit(ClobValue entity) {
	}

	public void visit(RawValue entity) {
	}

	public void visit(TableName entity) {
	}

	public void visit(ColumnName entity) {
	}

	public void visit(IndexName entity) {
	}

	public void visit(ConstraintName entity) {
	}

	public void visit(CaseExpression entity) {
	}

	public void visit(WhenClauses entity) {
	}

	public void visit(WhenClause entity) {
	}

	public void visit(In entity) {
	}

	public void visit(NotIn entity) {
	}

	public void visit(Subquery entity) {
	}

	public void visit(InValueList entity) {
	}

	public void visit(BinaryExpression entity) {
	}

	public void visit(BinaryOperator entity) {
	}

	public void visit(BooleanBinaryExpression entity) {
	}

	public void visit(BooleanOperator entity) {
	}

	public void visit(FunctionExpression entity) {
	}

	public void visit(FunctionName entity) {
	}

	public void visit(OrderByColumnExpressions entity) {
	}

	public void visit(OrderByColumnExpression entity) {
	}

	public void visit(OrderType entity) {
	}

	public void visit(SetClauses entity) {
	}

	public void visit(SetClause entity) {
	}

	public void visit(DeclarationOrConstraints entity) {
	}

	public void visit(ColumnDeclaration entity) {
	}

	public void visit(ColumnType entity) {
	}

	public void visit(Type entity) {
	}

	public void visit(ColumnConstraints entity) {
	}

	public void visit(SimpleColumnConstraint entity) {
	}

	public void visit(ForeignKeyColumnConstraint entity) {
	}

	public void visit(UniqueTableConstraint entity) {
	}

	public void visit(PrimaryKeyTableConstraint entity) {
	}

	public void visit(ForeignKeyTableConstraint entity) {
	}

	public void visit(Match entity) {
	}

	public void visit(Action entity) {
	}

	public void visit(Deferrable entity) {
	}

	public void visit(DeferCheck entity) {
	}

	public void visit(StoredProcedures entity) {
	}

	public void visit(StoredProcedure entity) {
	}

	public void visit(ProcedureDeclarations entity) {
	}

	public void visit(ProcedureStatements entity) {
	}

	public void visit(DeclareCursor entity) {
	}

	public void visit(SimpleVariableDeclaration entity) {
	}

	public void visit(VariableDeclaration entity) {
	}

	public void visit(Reference entity) {
	}

	public void visit(ReferenceType entity) {
	}

	public void visit(ArrayExpr entity) {
	}

	public void visit(Name entity) {
	}
}
