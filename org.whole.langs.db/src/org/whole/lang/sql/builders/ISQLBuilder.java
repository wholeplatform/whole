package org.whole.lang.sql.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.sql.model.NullOrderTypeEnum;
import org.whole.lang.sql.model.SelectTypeEnum;
import org.whole.lang.sql.model.IsTypeEnum;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Blob;
import java.sql.Clob;
import org.whole.lang.sql.model.BinaryOperatorEnum;
import org.whole.lang.sql.model.BooleanOperatorEnum;
import org.whole.lang.sql.model.OrderTypeEnum;
import org.whole.lang.sql.model.SimpleColumnConstraintEnum;
import org.whole.lang.sql.model.MatchEnum;
import org.whole.lang.sql.model.ActionEnum;
import org.whole.lang.sql.model.DeferrableEnum;
import org.whole.lang.sql.model.DeferCheckEnum;
import org.whole.lang.sql.model.ReferenceTypeEnum;

/** 
 * @generator Whole
 */
public interface ISQLBuilder extends IBuilder {
	public void visit();

	public void referenceType();

	public void reference();

	public void sqlStatement();

	public void procedureStatements();

	public void procedureDeclarations();

	public void deferCheck();

	public void deferrable();

	public void onUpdate();

	public void onDelete();

	public void match();

	public void foreignColumnNames();

	public void foreignColumnName();

	public void foreignTableName();

	public void precision();

	public void size();

	public void columnConstraints();

	public void columnType();

	public void params();

	public void functionName();

	public void rightExpr();

	public void operator();

	public void query();

	public void inPredicate();

	public void leftExpr();

	public void result();

	public void condition();

	public void elseClause();

	public void whenClauses();

	public void type();

	public void upperExpression();

	public void lowerExpression();

	public void outerTable();

	public void onExpression();

	public void innerTable();

	public void alias();

	public void expression();

	public void declarationOrConstraint();

	public void trueBody();

	public void arrayExp();

	public void name();

	public void nullOrderType();

	public void orderType();

	public void columnName();

	public void indexDeclarations();

	public void indexName();

	public void unique();

	public void action();

	public void declarationOrConstraints();

	public void limit();

	public void setClauses();

	public void select();

	public void values();

	public void columnNames();

	public void tableName();

	public void unionSelectStatement();

	public void simpleSelect();

	public void orderByColumnExprs();

	public void havingExpr();

	public void groupByExprs();

	public void whereExpr();

	public void fromClauses();

	public void columnExprs();

	public void selectType();

	public void SQLStatements();

	public void SQLStatements_();

	public void SQLStatements_(int initialCapacity);

	public void _SQLStatements();

	public void Select();

	public void Select_();

	public void _Select();

	public void UnionSelect();

	public void UnionSelect_();

	public void _UnionSelect();

	public void Insert();

	public void Insert_();

	public void _Insert();

	public void InsertFromSelect();

	public void InsertFromSelect_();

	public void _InsertFromSelect();

	public void Update();

	public void Update_();

	public void _Update();

	public void Create();

	public void Create_();

	public void _Create();

	public void Delete();

	public void Delete_();

	public void _Delete();

	public void Drop();

	public void Drop_();

	public void _Drop();

	public void Truncate();

	public void Truncate_();

	public void _Truncate();

	public void AlterTable();

	public void AlterTable_();

	public void _AlterTable();

	public void CreateIndex();

	public void CreateIndex_();

	public void _CreateIndex();

	public void UniqueIndex();

	public void UniqueIndex_();

	public void _UniqueIndex();

	public void IndexDeclarations();

	public void IndexDeclarations_();

	public void IndexDeclarations_(int initialCapacity);

	public void _IndexDeclarations();

	public void IndexDeclaration();

	public void IndexDeclaration_();

	public void _IndexDeclaration();

	public void NullOrderType();

	public void NullOrderType(NullOrderTypeEnum.Value value);

	public void NullOrderType(String value);

	public void DropIndex();

	public void DropIndex_();

	public void _DropIndex();

	public void Foreach();

	public void Foreach_();

	public void _Foreach();

	public void AddAction();

	public void AddAction_();

	public void _AddAction();

	public void SelectType();

	public void SelectType(SelectTypeEnum.Value value);

	public void SelectType(String value);

	public void ColumnNames();

	public void ColumnNames_();

	public void ColumnNames_(int initialCapacity);

	public void _ColumnNames();

	public void ColumnExpressions();

	public void ColumnExpressions_();

	public void ColumnExpressions_(int initialCapacity);

	public void _ColumnExpressions();

	public void ColumnExpression();

	public void ColumnExpression_();

	public void _ColumnExpression();

	public void Alias();

	public void Alias(String value);

	public void FromClauses();

	public void FromClauses_();

	public void FromClauses_(int initialCapacity);

	public void _FromClauses();

	public void SimpleFromClause();

	public void SimpleFromClause(String value);

	public void InnerJoinFromClause();

	public void InnerJoinFromClause_();

	public void _InnerJoinFromClause();

	public void LeftOuterJoinFromClause();

	public void LeftOuterJoinFromClause_();

	public void _LeftOuterJoinFromClause();

	public void RightOuterJoinFromClause();

	public void RightOuterJoinFromClause_();

	public void _RightOuterJoinFromClause();

	public void Between();

	public void Between_();

	public void _Between();

	public void NotBetween();

	public void NotBetween_();

	public void _NotBetween();

	public void Is();

	public void Is_();

	public void _Is();

	public void IsType();

	public void IsType(IsTypeEnum.Value value);

	public void IsType(String value);

	public void Values();

	public void Values_();

	public void Values_(int initialCapacity);

	public void _Values();

	public void ParenthesizedExpression();

	public void ParenthesizedExpression_();

	public void _ParenthesizedExpression();

	public void SQLExpressions();

	public void SQLExpressions_();

	public void SQLExpressions_(int initialCapacity);

	public void _SQLExpressions();

	public void NullValue();

	public void NullValue_();

	public void _NullValue();

	public void ArrayValue();

	public void ArrayValue(Object value);

	public void ArrayValue(String value);

	public void BooleanValue();

	public void BooleanValue(boolean value);

	public void TinyIntValue();

	public void TinyIntValue(byte value);

	public void SmallIntValue();

	public void SmallIntValue(short value);

	public void IntValue();

	public void IntValue(int value);

	public void BigIntValue();

	public void BigIntValue(long value);

	public void DoubleValue();

	public void DoubleValue(double value);

	public void RealValue();

	public void RealValue(float value);

	public void DecimalValue();

	public void DecimalValue(BigDecimal value);

	public void DecimalValue(String value);

	public void StringValue();

	public void StringValue(String value);

	public void BinaryValue();

	public void BinaryValue(Object value);

	public void BinaryValue(String value);

	public void DateValue();

	public void DateValue(Date value);

	public void DateValue(String value);

	public void TimeValue();

	public void TimeValue(Time value);

	public void TimeValue(String value);

	public void TimestampValue();

	public void TimestampValue(Timestamp value);

	public void TimestampValue(String value);

	public void BlobValue();

	public void BlobValue(Blob value);

	public void BlobValue(String value);

	public void ClobValue();

	public void ClobValue(Clob value);

	public void ClobValue(String value);

	public void RawValue();

	public void RawValue(Object value);

	public void RawValue(String value);

	public void TableName();

	public void TableName(String value);

	public void ColumnName();

	public void ColumnName(String value);

	public void IndexName();

	public void IndexName(String value);

	public void CaseExpression();

	public void CaseExpression_();

	public void _CaseExpression();

	public void WhenClauses();

	public void WhenClauses_();

	public void WhenClauses_(int initialCapacity);

	public void _WhenClauses();

	public void WhenClause();

	public void WhenClause_();

	public void _WhenClause();

	public void In();

	public void In_();

	public void _In();

	public void NotIn();

	public void NotIn_();

	public void _NotIn();

	public void Subquery();

	public void Subquery_();

	public void _Subquery();

	public void InValueList();

	public void InValueList_();

	public void InValueList_(int initialCapacity);

	public void _InValueList();

	public void BinaryExpression();

	public void BinaryExpression_();

	public void _BinaryExpression();

	public void BinaryOperator();

	public void BinaryOperator(BinaryOperatorEnum.Value value);

	public void BinaryOperator(String value);

	public void BooleanBinaryExpression();

	public void BooleanBinaryExpression_();

	public void _BooleanBinaryExpression();

	public void BooleanOperator();

	public void BooleanOperator(BooleanOperatorEnum.Value value);

	public void BooleanOperator(String value);

	public void FunctionExpression();

	public void FunctionExpression_();

	public void _FunctionExpression();

	public void FunctionName();

	public void FunctionName(String value);

	public void OrderByColumnExpressions();

	public void OrderByColumnExpressions_();

	public void OrderByColumnExpressions_(int initialCapacity);

	public void _OrderByColumnExpressions();

	public void OrderByColumnExpression();

	public void OrderByColumnExpression_();

	public void _OrderByColumnExpression();

	public void OrderType();

	public void OrderType(OrderTypeEnum.Value value);

	public void OrderType(String value);

	public void SetClauses();

	public void SetClauses_();

	public void SetClauses_(int initialCapacity);

	public void _SetClauses();

	public void SetClause();

	public void SetClause_();

	public void _SetClause();

	public void DeclarationOrConstraints();

	public void DeclarationOrConstraints_();

	public void DeclarationOrConstraints_(int initialCapacity);

	public void _DeclarationOrConstraints();

	public void ColumnDeclaration();

	public void ColumnDeclaration_();

	public void _ColumnDeclaration();

	public void ColumnType();

	public void ColumnType_();

	public void _ColumnType();

	public void Type();

	public void Type(String value);

	public void ColumnConstraints();

	public void ColumnConstraints_();

	public void ColumnConstraints_(int initialCapacity);

	public void _ColumnConstraints();

	public void SimpleColumnConstraint();

	public void SimpleColumnConstraint(SimpleColumnConstraintEnum.Value value);

	public void SimpleColumnConstraint(String value);

	public void ForeignKeyColumnConstraint();

	public void ForeignKeyColumnConstraint_();

	public void _ForeignKeyColumnConstraint();

	public void UniqueTableConstraint();

	public void UniqueTableConstraint_();

	public void _UniqueTableConstraint();

	public void PrimaryKeyTableConstraint();

	public void PrimaryKeyTableConstraint_();

	public void _PrimaryKeyTableConstraint();

	public void ForeignKeyTableConstraint();

	public void ForeignKeyTableConstraint_();

	public void _ForeignKeyTableConstraint();

	public void Match();

	public void Match(MatchEnum.Value value);

	public void Match(String value);

	public void Action();

	public void Action(ActionEnum.Value value);

	public void Action(String value);

	public void Deferrable();

	public void Deferrable(DeferrableEnum.Value value);

	public void Deferrable(String value);

	public void DeferCheck();

	public void DeferCheck(DeferCheckEnum.Value value);

	public void DeferCheck(String value);

	public void StoredProcedures();

	public void StoredProcedures_();

	public void StoredProcedures_(int initialCapacity);

	public void _StoredProcedures();

	public void StoredProcedure();

	public void StoredProcedure_();

	public void _StoredProcedure();

	public void ProcedureDeclarations();

	public void ProcedureDeclarations_();

	public void ProcedureDeclarations_(int initialCapacity);

	public void _ProcedureDeclarations();

	public void ProcedureStatements();

	public void ProcedureStatements_();

	public void ProcedureStatements_(int initialCapacity);

	public void _ProcedureStatements();

	public void DeclareCursor();

	public void DeclareCursor_();

	public void _DeclareCursor();

	public void SimpleVariableDeclaration();

	public void SimpleVariableDeclaration_();

	public void _SimpleVariableDeclaration();

	public void VariableDeclaration();

	public void VariableDeclaration_();

	public void _VariableDeclaration();

	public void Reference();

	public void Reference(String value);

	public void ReferenceType();

	public void ReferenceType(ReferenceTypeEnum.Value value);

	public void ReferenceType(String value);

	public void ArrayExpr();

	public void ArrayExpr(String value);

	public void Name();

	public void Name(String value);
}
