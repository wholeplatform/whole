package org.whole.lang.sql.visitors;

import org.whole.lang.sql.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class SQLFailureVisitor extends SQLIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(SQLStatements entity) {
		throw new VisitException();
	}

	public void visit(Select entity) {
		throw new VisitException();
	}

	public void visit(UnionSelect entity) {
		throw new VisitException();
	}

	public void visit(Insert entity) {
		throw new VisitException();
	}

	public void visit(InsertFromSelect entity) {
		throw new VisitException();
	}

	public void visit(Update entity) {
		throw new VisitException();
	}

	public void visit(Create entity) {
		throw new VisitException();
	}

	public void visit(Delete entity) {
		throw new VisitException();
	}

	public void visit(Drop entity) {
		throw new VisitException();
	}

	public void visit(Truncate entity) {
		throw new VisitException();
	}

	public void visit(AlterTable entity) {
		throw new VisitException();
	}

	public void visit(CreateIndex entity) {
		throw new VisitException();
	}

	public void visit(UniqueIndex entity) {
		throw new VisitException();
	}

	public void visit(IndexDeclarations entity) {
		throw new VisitException();
	}

	public void visit(IndexDeclaration entity) {
		throw new VisitException();
	}

	public void visit(NullOrderType entity) {
		throw new VisitException();
	}

	public void visit(DropIndex entity) {
		throw new VisitException();
	}

	public void visit(Foreach entity) {
		throw new VisitException();
	}

	public void visit(AddAction entity) {
		throw new VisitException();
	}

	public void visit(SelectType entity) {
		throw new VisitException();
	}

	public void visit(ColumnNames entity) {
		throw new VisitException();
	}

	public void visit(ColumnExpressions entity) {
		throw new VisitException();
	}

	public void visit(ColumnExpression entity) {
		throw new VisitException();
	}

	public void visit(Alias entity) {
		throw new VisitException();
	}

	public void visit(FromClauses entity) {
		throw new VisitException();
	}

	public void visit(SimpleFromClause entity) {
		throw new VisitException();
	}

	public void visit(InnerJoinFromClause entity) {
		throw new VisitException();
	}

	public void visit(LeftOuterJoinFromClause entity) {
		throw new VisitException();
	}

	public void visit(RightOuterJoinFromClause entity) {
		throw new VisitException();
	}

	public void visit(Between entity) {
		throw new VisitException();
	}

	public void visit(NotBetween entity) {
		throw new VisitException();
	}

	public void visit(Is entity) {
		throw new VisitException();
	}

	public void visit(IsType entity) {
		throw new VisitException();
	}

	public void visit(Values entity) {
		throw new VisitException();
	}

	public void visit(ParenthesizedExpression entity) {
		throw new VisitException();
	}

	public void visit(SQLExpressions entity) {
		throw new VisitException();
	}

	public void visit(NullValue entity) {
		throw new VisitException();
	}

	public void visit(ArrayValue entity) {
		throw new VisitException();
	}

	public void visit(BooleanValue entity) {
		throw new VisitException();
	}

	public void visit(TinyIntValue entity) {
		throw new VisitException();
	}

	public void visit(SmallIntValue entity) {
		throw new VisitException();
	}

	public void visit(IntValue entity) {
		throw new VisitException();
	}

	public void visit(BigIntValue entity) {
		throw new VisitException();
	}

	public void visit(DoubleValue entity) {
		throw new VisitException();
	}

	public void visit(RealValue entity) {
		throw new VisitException();
	}

	public void visit(DecimalValue entity) {
		throw new VisitException();
	}

	public void visit(StringValue entity) {
		throw new VisitException();
	}

	public void visit(BinaryValue entity) {
		throw new VisitException();
	}

	public void visit(DateValue entity) {
		throw new VisitException();
	}

	public void visit(TimeValue entity) {
		throw new VisitException();
	}

	public void visit(TimestampValue entity) {
		throw new VisitException();
	}

	public void visit(BlobValue entity) {
		throw new VisitException();
	}

	public void visit(ClobValue entity) {
		throw new VisitException();
	}

	public void visit(RawValue entity) {
		throw new VisitException();
	}

	public void visit(TableName entity) {
		throw new VisitException();
	}

	public void visit(ColumnName entity) {
		throw new VisitException();
	}

	public void visit(IndexName entity) {
		throw new VisitException();
	}

	public void visit(ConstraintName entity) {
		throw new VisitException();
	}

	public void visit(CaseExpression entity) {
		throw new VisitException();
	}

	public void visit(WhenClauses entity) {
		throw new VisitException();
	}

	public void visit(WhenClause entity) {
		throw new VisitException();
	}

	public void visit(In entity) {
		throw new VisitException();
	}

	public void visit(NotIn entity) {
		throw new VisitException();
	}

	public void visit(Subquery entity) {
		throw new VisitException();
	}

	public void visit(InValueList entity) {
		throw new VisitException();
	}

	public void visit(BinaryExpression entity) {
		throw new VisitException();
	}

	public void visit(BinaryOperator entity) {
		throw new VisitException();
	}

	public void visit(BooleanBinaryExpression entity) {
		throw new VisitException();
	}

	public void visit(BooleanOperator entity) {
		throw new VisitException();
	}

	public void visit(FunctionExpression entity) {
		throw new VisitException();
	}

	public void visit(FunctionName entity) {
		throw new VisitException();
	}

	public void visit(OrderByColumnExpressions entity) {
		throw new VisitException();
	}

	public void visit(OrderByColumnExpression entity) {
		throw new VisitException();
	}

	public void visit(OrderType entity) {
		throw new VisitException();
	}

	public void visit(SetClauses entity) {
		throw new VisitException();
	}

	public void visit(SetClause entity) {
		throw new VisitException();
	}

	public void visit(DeclarationOrConstraints entity) {
		throw new VisitException();
	}

	public void visit(ColumnDeclaration entity) {
		throw new VisitException();
	}

	public void visit(ColumnType entity) {
		throw new VisitException();
	}

	public void visit(Type entity) {
		throw new VisitException();
	}

	public void visit(ColumnConstraints entity) {
		throw new VisitException();
	}

	public void visit(SimpleColumnConstraint entity) {
		throw new VisitException();
	}

	public void visit(ForeignKeyColumnConstraint entity) {
		throw new VisitException();
	}

	public void visit(UniqueTableConstraint entity) {
		throw new VisitException();
	}

	public void visit(PrimaryKeyTableConstraint entity) {
		throw new VisitException();
	}

	public void visit(ForeignKeyTableConstraint entity) {
		throw new VisitException();
	}

	public void visit(Match entity) {
		throw new VisitException();
	}

	public void visit(Action entity) {
		throw new VisitException();
	}

	public void visit(Deferrable entity) {
		throw new VisitException();
	}

	public void visit(DeferCheck entity) {
		throw new VisitException();
	}

	public void visit(StoredProcedures entity) {
		throw new VisitException();
	}

	public void visit(StoredProcedure entity) {
		throw new VisitException();
	}

	public void visit(ProcedureDeclarations entity) {
		throw new VisitException();
	}

	public void visit(ProcedureStatements entity) {
		throw new VisitException();
	}

	public void visit(DeclareCursor entity) {
		throw new VisitException();
	}

	public void visit(SimpleVariableDeclaration entity) {
		throw new VisitException();
	}

	public void visit(VariableDeclaration entity) {
		throw new VisitException();
	}

	public void visit(Reference entity) {
		throw new VisitException();
	}

	public void visit(ReferenceType entity) {
		throw new VisitException();
	}

	public void visit(ArrayExpr entity) {
		throw new VisitException();
	}

	public void visit(Name entity) {
		throw new VisitException();
	}
}
