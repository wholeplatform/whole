package org.whole.lang.sql.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
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
public class SQLSpecificBuilderAdapter extends GenericBuilderContext implements
		ISQLBuilder {
	public SQLSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public SQLSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void referenceType() {
		wFeature(SQLFeatureDescriptorEnum.referenceType);
	}

	public void reference() {
		wFeature(SQLFeatureDescriptorEnum.reference);
	}

	public void sqlStatement() {
		wFeature(SQLFeatureDescriptorEnum.sqlStatement);
	}

	public void procedureStatements() {
		wFeature(SQLFeatureDescriptorEnum.procedureStatements);
	}

	public void procedureDeclarations() {
		wFeature(SQLFeatureDescriptorEnum.procedureDeclarations);
	}

	public void deferCheck() {
		wFeature(SQLFeatureDescriptorEnum.deferCheck);
	}

	public void deferrable() {
		wFeature(SQLFeatureDescriptorEnum.deferrable);
	}

	public void onUpdate() {
		wFeature(SQLFeatureDescriptorEnum.onUpdate);
	}

	public void onDelete() {
		wFeature(SQLFeatureDescriptorEnum.onDelete);
	}

	public void match() {
		wFeature(SQLFeatureDescriptorEnum.match);
	}

	public void foreignColumnNames() {
		wFeature(SQLFeatureDescriptorEnum.foreignColumnNames);
	}

	public void foreignColumnName() {
		wFeature(SQLFeatureDescriptorEnum.foreignColumnName);
	}

	public void foreignTableName() {
		wFeature(SQLFeatureDescriptorEnum.foreignTableName);
	}

	public void precision() {
		wFeature(SQLFeatureDescriptorEnum.precision);
	}

	public void size() {
		wFeature(SQLFeatureDescriptorEnum.size);
	}

	public void columnConstraints() {
		wFeature(SQLFeatureDescriptorEnum.columnConstraints);
	}

	public void columnType() {
		wFeature(SQLFeatureDescriptorEnum.columnType);
	}

	public void params() {
		wFeature(SQLFeatureDescriptorEnum.params);
	}

	public void functionName() {
		wFeature(SQLFeatureDescriptorEnum.functionName);
	}

	public void rightExpr() {
		wFeature(SQLFeatureDescriptorEnum.rightExpr);
	}

	public void operator() {
		wFeature(SQLFeatureDescriptorEnum.operator);
	}

	public void query() {
		wFeature(SQLFeatureDescriptorEnum.query);
	}

	public void inPredicate() {
		wFeature(SQLFeatureDescriptorEnum.inPredicate);
	}

	public void leftExpr() {
		wFeature(SQLFeatureDescriptorEnum.leftExpr);
	}

	public void result() {
		wFeature(SQLFeatureDescriptorEnum.result);
	}

	public void condition() {
		wFeature(SQLFeatureDescriptorEnum.condition);
	}

	public void elseClause() {
		wFeature(SQLFeatureDescriptorEnum.elseClause);
	}

	public void whenClauses() {
		wFeature(SQLFeatureDescriptorEnum.whenClauses);
	}

	public void type() {
		wFeature(SQLFeatureDescriptorEnum.type);
	}

	public void upperExpression() {
		wFeature(SQLFeatureDescriptorEnum.upperExpression);
	}

	public void lowerExpression() {
		wFeature(SQLFeatureDescriptorEnum.lowerExpression);
	}

	public void outerTable() {
		wFeature(SQLFeatureDescriptorEnum.outerTable);
	}

	public void onExpression() {
		wFeature(SQLFeatureDescriptorEnum.onExpression);
	}

	public void innerTable() {
		wFeature(SQLFeatureDescriptorEnum.innerTable);
	}

	public void alias() {
		wFeature(SQLFeatureDescriptorEnum.alias);
	}

	public void expression() {
		wFeature(SQLFeatureDescriptorEnum.expression);
	}

	public void declarationOrConstraint() {
		wFeature(SQLFeatureDescriptorEnum.declarationOrConstraint);
	}

	public void trueBody() {
		wFeature(SQLFeatureDescriptorEnum.trueBody);
	}

	public void arrayExp() {
		wFeature(SQLFeatureDescriptorEnum.arrayExp);
	}

	public void name() {
		wFeature(SQLFeatureDescriptorEnum.name);
	}

	public void nullOrderType() {
		wFeature(SQLFeatureDescriptorEnum.nullOrderType);
	}

	public void orderType() {
		wFeature(SQLFeatureDescriptorEnum.orderType);
	}

	public void columnName() {
		wFeature(SQLFeatureDescriptorEnum.columnName);
	}

	public void indexDeclarations() {
		wFeature(SQLFeatureDescriptorEnum.indexDeclarations);
	}

	public void indexName() {
		wFeature(SQLFeatureDescriptorEnum.indexName);
	}

	public void unique() {
		wFeature(SQLFeatureDescriptorEnum.unique);
	}

	public void action() {
		wFeature(SQLFeatureDescriptorEnum.action);
	}

	public void declarationOrConstraints() {
		wFeature(SQLFeatureDescriptorEnum.declarationOrConstraints);
	}

	public void limit() {
		wFeature(SQLFeatureDescriptorEnum.limit);
	}

	public void setClauses() {
		wFeature(SQLFeatureDescriptorEnum.setClauses);
	}

	public void select() {
		wFeature(SQLFeatureDescriptorEnum.select);
	}

	public void values() {
		wFeature(SQLFeatureDescriptorEnum.values);
	}

	public void columnNames() {
		wFeature(SQLFeatureDescriptorEnum.columnNames);
	}

	public void tableName() {
		wFeature(SQLFeatureDescriptorEnum.tableName);
	}

	public void unionSelectStatement() {
		wFeature(SQLFeatureDescriptorEnum.unionSelectStatement);
	}

	public void simpleSelect() {
		wFeature(SQLFeatureDescriptorEnum.simpleSelect);
	}

	public void orderByColumnExprs() {
		wFeature(SQLFeatureDescriptorEnum.orderByColumnExprs);
	}

	public void havingExpr() {
		wFeature(SQLFeatureDescriptorEnum.havingExpr);
	}

	public void groupByExprs() {
		wFeature(SQLFeatureDescriptorEnum.groupByExprs);
	}

	public void whereExpr() {
		wFeature(SQLFeatureDescriptorEnum.whereExpr);
	}

	public void fromClauses() {
		wFeature(SQLFeatureDescriptorEnum.fromClauses);
	}

	public void columnExprs() {
		wFeature(SQLFeatureDescriptorEnum.columnExprs);
	}

	public void selectType() {
		wFeature(SQLFeatureDescriptorEnum.selectType);
	}

	public void visit() {
	}

	public void SQLStatements() {
		wEntity(SQLEntityDescriptorEnum.SQLStatements);
	}

	public void SQLStatements_() {
		wEntity_(SQLEntityDescriptorEnum.SQLStatements);
	}

	public void SQLStatements_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.SQLStatements, initialCapacity);
	}

	public void _SQLStatements() {
		_wEntity(SQLEntityDescriptorEnum.SQLStatements);
	}

	public void Select() {
		wEntity(SQLEntityDescriptorEnum.Select);
	}

	public void Select_() {
		wEntity_(SQLEntityDescriptorEnum.Select);
	}

	public void _Select() {
		_wEntity(SQLEntityDescriptorEnum.Select);
	}

	public void UnionSelect() {
		wEntity(SQLEntityDescriptorEnum.UnionSelect);
	}

	public void UnionSelect_() {
		wEntity_(SQLEntityDescriptorEnum.UnionSelect);
	}

	public void _UnionSelect() {
		_wEntity(SQLEntityDescriptorEnum.UnionSelect);
	}

	public void Insert() {
		wEntity(SQLEntityDescriptorEnum.Insert);
	}

	public void Insert_() {
		wEntity_(SQLEntityDescriptorEnum.Insert);
	}

	public void _Insert() {
		_wEntity(SQLEntityDescriptorEnum.Insert);
	}

	public void InsertFromSelect() {
		wEntity(SQLEntityDescriptorEnum.InsertFromSelect);
	}

	public void InsertFromSelect_() {
		wEntity_(SQLEntityDescriptorEnum.InsertFromSelect);
	}

	public void _InsertFromSelect() {
		_wEntity(SQLEntityDescriptorEnum.InsertFromSelect);
	}

	public void Update() {
		wEntity(SQLEntityDescriptorEnum.Update);
	}

	public void Update_() {
		wEntity_(SQLEntityDescriptorEnum.Update);
	}

	public void _Update() {
		_wEntity(SQLEntityDescriptorEnum.Update);
	}

	public void Create() {
		wEntity(SQLEntityDescriptorEnum.Create);
	}

	public void Create_() {
		wEntity_(SQLEntityDescriptorEnum.Create);
	}

	public void _Create() {
		_wEntity(SQLEntityDescriptorEnum.Create);
	}

	public void Delete() {
		wEntity(SQLEntityDescriptorEnum.Delete);
	}

	public void Delete_() {
		wEntity_(SQLEntityDescriptorEnum.Delete);
	}

	public void _Delete() {
		_wEntity(SQLEntityDescriptorEnum.Delete);
	}

	public void Drop() {
		wEntity(SQLEntityDescriptorEnum.Drop);
	}

	public void Drop_() {
		wEntity_(SQLEntityDescriptorEnum.Drop);
	}

	public void _Drop() {
		_wEntity(SQLEntityDescriptorEnum.Drop);
	}

	public void Truncate() {
		wEntity(SQLEntityDescriptorEnum.Truncate);
	}

	public void Truncate_() {
		wEntity_(SQLEntityDescriptorEnum.Truncate);
	}

	public void _Truncate() {
		_wEntity(SQLEntityDescriptorEnum.Truncate);
	}

	public void AlterTable() {
		wEntity(SQLEntityDescriptorEnum.AlterTable);
	}

	public void AlterTable_() {
		wEntity_(SQLEntityDescriptorEnum.AlterTable);
	}

	public void _AlterTable() {
		_wEntity(SQLEntityDescriptorEnum.AlterTable);
	}

	public void CreateIndex() {
		wEntity(SQLEntityDescriptorEnum.CreateIndex);
	}

	public void CreateIndex_() {
		wEntity_(SQLEntityDescriptorEnum.CreateIndex);
	}

	public void _CreateIndex() {
		_wEntity(SQLEntityDescriptorEnum.CreateIndex);
	}

	public void UniqueIndex() {
		wEntity(SQLEntityDescriptorEnum.UniqueIndex);
	}

	public void UniqueIndex_() {
		wEntity_(SQLEntityDescriptorEnum.UniqueIndex);
	}

	public void _UniqueIndex() {
		_wEntity(SQLEntityDescriptorEnum.UniqueIndex);
	}

	public void IndexDeclarations() {
		wEntity(SQLEntityDescriptorEnum.IndexDeclarations);
	}

	public void IndexDeclarations_() {
		wEntity_(SQLEntityDescriptorEnum.IndexDeclarations);
	}

	public void IndexDeclarations_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.IndexDeclarations, initialCapacity);
	}

	public void _IndexDeclarations() {
		_wEntity(SQLEntityDescriptorEnum.IndexDeclarations);
	}

	public void IndexDeclaration() {
		wEntity(SQLEntityDescriptorEnum.IndexDeclaration);
	}

	public void IndexDeclaration_() {
		wEntity_(SQLEntityDescriptorEnum.IndexDeclaration);
	}

	public void _IndexDeclaration() {
		_wEntity(SQLEntityDescriptorEnum.IndexDeclaration);
	}

	public void NullOrderType() {
		wEntity(SQLEntityDescriptorEnum.NullOrderType);
	}

	public void NullOrderType(NullOrderTypeEnum.Value value) {
		wEntity(SQLEntityDescriptorEnum.NullOrderType, value);
	}

	public void NullOrderType(String value) {
		wEntity(SQLEntityDescriptorEnum.NullOrderType, value);
	}

	public void DropIndex() {
		wEntity(SQLEntityDescriptorEnum.DropIndex);
	}

	public void DropIndex_() {
		wEntity_(SQLEntityDescriptorEnum.DropIndex);
	}

	public void _DropIndex() {
		_wEntity(SQLEntityDescriptorEnum.DropIndex);
	}

	public void Foreach() {
		wEntity(SQLEntityDescriptorEnum.Foreach);
	}

	public void Foreach_() {
		wEntity_(SQLEntityDescriptorEnum.Foreach);
	}

	public void _Foreach() {
		_wEntity(SQLEntityDescriptorEnum.Foreach);
	}

	public void AddAction() {
		wEntity(SQLEntityDescriptorEnum.AddAction);
	}

	public void AddAction_() {
		wEntity_(SQLEntityDescriptorEnum.AddAction);
	}

	public void _AddAction() {
		_wEntity(SQLEntityDescriptorEnum.AddAction);
	}

	public void SelectType() {
		wEntity(SQLEntityDescriptorEnum.SelectType);
	}

	public void SelectType(SelectTypeEnum.Value value) {
		wEntity(SQLEntityDescriptorEnum.SelectType, value);
	}

	public void SelectType(String value) {
		wEntity(SQLEntityDescriptorEnum.SelectType, value);
	}

	public void ColumnNames() {
		wEntity(SQLEntityDescriptorEnum.ColumnNames);
	}

	public void ColumnNames_() {
		wEntity_(SQLEntityDescriptorEnum.ColumnNames);
	}

	public void ColumnNames_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.ColumnNames, initialCapacity);
	}

	public void _ColumnNames() {
		_wEntity(SQLEntityDescriptorEnum.ColumnNames);
	}

	public void ColumnExpressions() {
		wEntity(SQLEntityDescriptorEnum.ColumnExpressions);
	}

	public void ColumnExpressions_() {
		wEntity_(SQLEntityDescriptorEnum.ColumnExpressions);
	}

	public void ColumnExpressions_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.ColumnExpressions, initialCapacity);
	}

	public void _ColumnExpressions() {
		_wEntity(SQLEntityDescriptorEnum.ColumnExpressions);
	}

	public void ColumnExpression() {
		wEntity(SQLEntityDescriptorEnum.ColumnExpression);
	}

	public void ColumnExpression_() {
		wEntity_(SQLEntityDescriptorEnum.ColumnExpression);
	}

	public void _ColumnExpression() {
		_wEntity(SQLEntityDescriptorEnum.ColumnExpression);
	}

	public void Alias() {
		wEntity(SQLEntityDescriptorEnum.Alias);
	}

	public void Alias(String value) {
		wEntity(SQLEntityDescriptorEnum.Alias, value);
	}

	public void FromClauses() {
		wEntity(SQLEntityDescriptorEnum.FromClauses);
	}

	public void FromClauses_() {
		wEntity_(SQLEntityDescriptorEnum.FromClauses);
	}

	public void FromClauses_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.FromClauses, initialCapacity);
	}

	public void _FromClauses() {
		_wEntity(SQLEntityDescriptorEnum.FromClauses);
	}

	public void SimpleFromClause() {
		wEntity(SQLEntityDescriptorEnum.SimpleFromClause);
	}

	public void SimpleFromClause(String value) {
		wEntity(SQLEntityDescriptorEnum.SimpleFromClause, value);
	}

	public void InnerJoinFromClause() {
		wEntity(SQLEntityDescriptorEnum.InnerJoinFromClause);
	}

	public void InnerJoinFromClause_() {
		wEntity_(SQLEntityDescriptorEnum.InnerJoinFromClause);
	}

	public void _InnerJoinFromClause() {
		_wEntity(SQLEntityDescriptorEnum.InnerJoinFromClause);
	}

	public void LeftOuterJoinFromClause() {
		wEntity(SQLEntityDescriptorEnum.LeftOuterJoinFromClause);
	}

	public void LeftOuterJoinFromClause_() {
		wEntity_(SQLEntityDescriptorEnum.LeftOuterJoinFromClause);
	}

	public void _LeftOuterJoinFromClause() {
		_wEntity(SQLEntityDescriptorEnum.LeftOuterJoinFromClause);
	}

	public void RightOuterJoinFromClause() {
		wEntity(SQLEntityDescriptorEnum.RightOuterJoinFromClause);
	}

	public void RightOuterJoinFromClause_() {
		wEntity_(SQLEntityDescriptorEnum.RightOuterJoinFromClause);
	}

	public void _RightOuterJoinFromClause() {
		_wEntity(SQLEntityDescriptorEnum.RightOuterJoinFromClause);
	}

	public void Between() {
		wEntity(SQLEntityDescriptorEnum.Between);
	}

	public void Between_() {
		wEntity_(SQLEntityDescriptorEnum.Between);
	}

	public void _Between() {
		_wEntity(SQLEntityDescriptorEnum.Between);
	}

	public void NotBetween() {
		wEntity(SQLEntityDescriptorEnum.NotBetween);
	}

	public void NotBetween_() {
		wEntity_(SQLEntityDescriptorEnum.NotBetween);
	}

	public void _NotBetween() {
		_wEntity(SQLEntityDescriptorEnum.NotBetween);
	}

	public void Is() {
		wEntity(SQLEntityDescriptorEnum.Is);
	}

	public void Is_() {
		wEntity_(SQLEntityDescriptorEnum.Is);
	}

	public void _Is() {
		_wEntity(SQLEntityDescriptorEnum.Is);
	}

	public void IsType() {
		wEntity(SQLEntityDescriptorEnum.IsType);
	}

	public void IsType(IsTypeEnum.Value value) {
		wEntity(SQLEntityDescriptorEnum.IsType, value);
	}

	public void IsType(String value) {
		wEntity(SQLEntityDescriptorEnum.IsType, value);
	}

	public void Values() {
		wEntity(SQLEntityDescriptorEnum.Values);
	}

	public void Values_() {
		wEntity_(SQLEntityDescriptorEnum.Values);
	}

	public void Values_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.Values, initialCapacity);
	}

	public void _Values() {
		_wEntity(SQLEntityDescriptorEnum.Values);
	}

	public void ParenthesizedExpression() {
		wEntity(SQLEntityDescriptorEnum.ParenthesizedExpression);
	}

	public void ParenthesizedExpression_() {
		wEntity_(SQLEntityDescriptorEnum.ParenthesizedExpression);
	}

	public void _ParenthesizedExpression() {
		_wEntity(SQLEntityDescriptorEnum.ParenthesizedExpression);
	}

	public void SQLExpressions() {
		wEntity(SQLEntityDescriptorEnum.SQLExpressions);
	}

	public void SQLExpressions_() {
		wEntity_(SQLEntityDescriptorEnum.SQLExpressions);
	}

	public void SQLExpressions_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.SQLExpressions, initialCapacity);
	}

	public void _SQLExpressions() {
		_wEntity(SQLEntityDescriptorEnum.SQLExpressions);
	}

	public void NullValue() {
		wEntity(SQLEntityDescriptorEnum.NullValue);
	}

	public void NullValue_() {
		wEntity_(SQLEntityDescriptorEnum.NullValue);
	}

	public void _NullValue() {
		_wEntity(SQLEntityDescriptorEnum.NullValue);
	}

	public void ArrayValue() {
		wEntity(SQLEntityDescriptorEnum.ArrayValue);
	}

	public void ArrayValue(Object value) {
		wEntity(SQLEntityDescriptorEnum.ArrayValue, value);
	}

	public void ArrayValue(String value) {
		wEntity(SQLEntityDescriptorEnum.ArrayValue, value);
	}

	public void BooleanValue() {
		wEntity(SQLEntityDescriptorEnum.BooleanValue);
	}

	public void BooleanValue(boolean value) {
		wEntity(SQLEntityDescriptorEnum.BooleanValue, value);
	}

	public void TinyIntValue() {
		wEntity(SQLEntityDescriptorEnum.TinyIntValue);
	}

	public void TinyIntValue(byte value) {
		wEntity(SQLEntityDescriptorEnum.TinyIntValue, value);
	}

	public void SmallIntValue() {
		wEntity(SQLEntityDescriptorEnum.SmallIntValue);
	}

	public void SmallIntValue(short value) {
		wEntity(SQLEntityDescriptorEnum.SmallIntValue, value);
	}

	public void IntValue() {
		wEntity(SQLEntityDescriptorEnum.IntValue);
	}

	public void IntValue(int value) {
		wEntity(SQLEntityDescriptorEnum.IntValue, value);
	}

	public void BigIntValue() {
		wEntity(SQLEntityDescriptorEnum.BigIntValue);
	}

	public void BigIntValue(long value) {
		wEntity(SQLEntityDescriptorEnum.BigIntValue, value);
	}

	public void DoubleValue() {
		wEntity(SQLEntityDescriptorEnum.DoubleValue);
	}

	public void DoubleValue(double value) {
		wEntity(SQLEntityDescriptorEnum.DoubleValue, value);
	}

	public void RealValue() {
		wEntity(SQLEntityDescriptorEnum.RealValue);
	}

	public void RealValue(float value) {
		wEntity(SQLEntityDescriptorEnum.RealValue, value);
	}

	public void DecimalValue() {
		wEntity(SQLEntityDescriptorEnum.DecimalValue);
	}

	public void DecimalValue(BigDecimal value) {
		wEntity(SQLEntityDescriptorEnum.DecimalValue, value);
	}

	public void DecimalValue(String value) {
		wEntity(SQLEntityDescriptorEnum.DecimalValue, value);
	}

	public void StringValue() {
		wEntity(SQLEntityDescriptorEnum.StringValue);
	}

	public void StringValue(String value) {
		wEntity(SQLEntityDescriptorEnum.StringValue, value);
	}

	public void BinaryValue() {
		wEntity(SQLEntityDescriptorEnum.BinaryValue);
	}

	public void BinaryValue(Object value) {
		wEntity(SQLEntityDescriptorEnum.BinaryValue, value);
	}

	public void BinaryValue(String value) {
		wEntity(SQLEntityDescriptorEnum.BinaryValue, value);
	}

	public void DateValue() {
		wEntity(SQLEntityDescriptorEnum.DateValue);
	}

	public void DateValue(Date value) {
		wEntity(SQLEntityDescriptorEnum.DateValue, value);
	}

	public void DateValue(String value) {
		wEntity(SQLEntityDescriptorEnum.DateValue, value);
	}

	public void TimeValue() {
		wEntity(SQLEntityDescriptorEnum.TimeValue);
	}

	public void TimeValue(Time value) {
		wEntity(SQLEntityDescriptorEnum.TimeValue, value);
	}

	public void TimeValue(String value) {
		wEntity(SQLEntityDescriptorEnum.TimeValue, value);
	}

	public void TimestampValue() {
		wEntity(SQLEntityDescriptorEnum.TimestampValue);
	}

	public void TimestampValue(Timestamp value) {
		wEntity(SQLEntityDescriptorEnum.TimestampValue, value);
	}

	public void TimestampValue(String value) {
		wEntity(SQLEntityDescriptorEnum.TimestampValue, value);
	}

	public void BlobValue() {
		wEntity(SQLEntityDescriptorEnum.BlobValue);
	}

	public void BlobValue(Blob value) {
		wEntity(SQLEntityDescriptorEnum.BlobValue, value);
	}

	public void BlobValue(String value) {
		wEntity(SQLEntityDescriptorEnum.BlobValue, value);
	}

	public void ClobValue() {
		wEntity(SQLEntityDescriptorEnum.ClobValue);
	}

	public void ClobValue(Clob value) {
		wEntity(SQLEntityDescriptorEnum.ClobValue, value);
	}

	public void ClobValue(String value) {
		wEntity(SQLEntityDescriptorEnum.ClobValue, value);
	}

	public void RawValue() {
		wEntity(SQLEntityDescriptorEnum.RawValue);
	}

	public void RawValue(Object value) {
		wEntity(SQLEntityDescriptorEnum.RawValue, value);
	}

	public void RawValue(String value) {
		wEntity(SQLEntityDescriptorEnum.RawValue, value);
	}

	public void TableName() {
		wEntity(SQLEntityDescriptorEnum.TableName);
	}

	public void TableName(String value) {
		wEntity(SQLEntityDescriptorEnum.TableName, value);
	}

	public void ColumnName() {
		wEntity(SQLEntityDescriptorEnum.ColumnName);
	}

	public void ColumnName(String value) {
		wEntity(SQLEntityDescriptorEnum.ColumnName, value);
	}

	public void IndexName() {
		wEntity(SQLEntityDescriptorEnum.IndexName);
	}

	public void IndexName(String value) {
		wEntity(SQLEntityDescriptorEnum.IndexName, value);
	}

	public void CaseExpression() {
		wEntity(SQLEntityDescriptorEnum.CaseExpression);
	}

	public void CaseExpression_() {
		wEntity_(SQLEntityDescriptorEnum.CaseExpression);
	}

	public void _CaseExpression() {
		_wEntity(SQLEntityDescriptorEnum.CaseExpression);
	}

	public void WhenClauses() {
		wEntity(SQLEntityDescriptorEnum.WhenClauses);
	}

	public void WhenClauses_() {
		wEntity_(SQLEntityDescriptorEnum.WhenClauses);
	}

	public void WhenClauses_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.WhenClauses, initialCapacity);
	}

	public void _WhenClauses() {
		_wEntity(SQLEntityDescriptorEnum.WhenClauses);
	}

	public void WhenClause() {
		wEntity(SQLEntityDescriptorEnum.WhenClause);
	}

	public void WhenClause_() {
		wEntity_(SQLEntityDescriptorEnum.WhenClause);
	}

	public void _WhenClause() {
		_wEntity(SQLEntityDescriptorEnum.WhenClause);
	}

	public void In() {
		wEntity(SQLEntityDescriptorEnum.In);
	}

	public void In_() {
		wEntity_(SQLEntityDescriptorEnum.In);
	}

	public void _In() {
		_wEntity(SQLEntityDescriptorEnum.In);
	}

	public void NotIn() {
		wEntity(SQLEntityDescriptorEnum.NotIn);
	}

	public void NotIn_() {
		wEntity_(SQLEntityDescriptorEnum.NotIn);
	}

	public void _NotIn() {
		_wEntity(SQLEntityDescriptorEnum.NotIn);
	}

	public void Subquery() {
		wEntity(SQLEntityDescriptorEnum.Subquery);
	}

	public void Subquery_() {
		wEntity_(SQLEntityDescriptorEnum.Subquery);
	}

	public void _Subquery() {
		_wEntity(SQLEntityDescriptorEnum.Subquery);
	}

	public void InValueList() {
		wEntity(SQLEntityDescriptorEnum.InValueList);
	}

	public void InValueList_() {
		wEntity_(SQLEntityDescriptorEnum.InValueList);
	}

	public void InValueList_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.InValueList, initialCapacity);
	}

	public void _InValueList() {
		_wEntity(SQLEntityDescriptorEnum.InValueList);
	}

	public void BinaryExpression() {
		wEntity(SQLEntityDescriptorEnum.BinaryExpression);
	}

	public void BinaryExpression_() {
		wEntity_(SQLEntityDescriptorEnum.BinaryExpression);
	}

	public void _BinaryExpression() {
		_wEntity(SQLEntityDescriptorEnum.BinaryExpression);
	}

	public void BinaryOperator() {
		wEntity(SQLEntityDescriptorEnum.BinaryOperator);
	}

	public void BinaryOperator(BinaryOperatorEnum.Value value) {
		wEntity(SQLEntityDescriptorEnum.BinaryOperator, value);
	}

	public void BinaryOperator(String value) {
		wEntity(SQLEntityDescriptorEnum.BinaryOperator, value);
	}

	public void BooleanBinaryExpression() {
		wEntity(SQLEntityDescriptorEnum.BooleanBinaryExpression);
	}

	public void BooleanBinaryExpression_() {
		wEntity_(SQLEntityDescriptorEnum.BooleanBinaryExpression);
	}

	public void _BooleanBinaryExpression() {
		_wEntity(SQLEntityDescriptorEnum.BooleanBinaryExpression);
	}

	public void BooleanOperator() {
		wEntity(SQLEntityDescriptorEnum.BooleanOperator);
	}

	public void BooleanOperator(BooleanOperatorEnum.Value value) {
		wEntity(SQLEntityDescriptorEnum.BooleanOperator, value);
	}

	public void BooleanOperator(String value) {
		wEntity(SQLEntityDescriptorEnum.BooleanOperator, value);
	}

	public void FunctionExpression() {
		wEntity(SQLEntityDescriptorEnum.FunctionExpression);
	}

	public void FunctionExpression_() {
		wEntity_(SQLEntityDescriptorEnum.FunctionExpression);
	}

	public void _FunctionExpression() {
		_wEntity(SQLEntityDescriptorEnum.FunctionExpression);
	}

	public void FunctionName() {
		wEntity(SQLEntityDescriptorEnum.FunctionName);
	}

	public void FunctionName(String value) {
		wEntity(SQLEntityDescriptorEnum.FunctionName, value);
	}

	public void OrderByColumnExpressions() {
		wEntity(SQLEntityDescriptorEnum.OrderByColumnExpressions);
	}

	public void OrderByColumnExpressions_() {
		wEntity_(SQLEntityDescriptorEnum.OrderByColumnExpressions);
	}

	public void OrderByColumnExpressions_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.OrderByColumnExpressions,
				initialCapacity);
	}

	public void _OrderByColumnExpressions() {
		_wEntity(SQLEntityDescriptorEnum.OrderByColumnExpressions);
	}

	public void OrderByColumnExpression() {
		wEntity(SQLEntityDescriptorEnum.OrderByColumnExpression);
	}

	public void OrderByColumnExpression_() {
		wEntity_(SQLEntityDescriptorEnum.OrderByColumnExpression);
	}

	public void _OrderByColumnExpression() {
		_wEntity(SQLEntityDescriptorEnum.OrderByColumnExpression);
	}

	public void OrderType() {
		wEntity(SQLEntityDescriptorEnum.OrderType);
	}

	public void OrderType(OrderTypeEnum.Value value) {
		wEntity(SQLEntityDescriptorEnum.OrderType, value);
	}

	public void OrderType(String value) {
		wEntity(SQLEntityDescriptorEnum.OrderType, value);
	}

	public void SetClauses() {
		wEntity(SQLEntityDescriptorEnum.SetClauses);
	}

	public void SetClauses_() {
		wEntity_(SQLEntityDescriptorEnum.SetClauses);
	}

	public void SetClauses_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.SetClauses, initialCapacity);
	}

	public void _SetClauses() {
		_wEntity(SQLEntityDescriptorEnum.SetClauses);
	}

	public void SetClause() {
		wEntity(SQLEntityDescriptorEnum.SetClause);
	}

	public void SetClause_() {
		wEntity_(SQLEntityDescriptorEnum.SetClause);
	}

	public void _SetClause() {
		_wEntity(SQLEntityDescriptorEnum.SetClause);
	}

	public void DeclarationOrConstraints() {
		wEntity(SQLEntityDescriptorEnum.DeclarationOrConstraints);
	}

	public void DeclarationOrConstraints_() {
		wEntity_(SQLEntityDescriptorEnum.DeclarationOrConstraints);
	}

	public void DeclarationOrConstraints_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.DeclarationOrConstraints,
				initialCapacity);
	}

	public void _DeclarationOrConstraints() {
		_wEntity(SQLEntityDescriptorEnum.DeclarationOrConstraints);
	}

	public void ColumnDeclaration() {
		wEntity(SQLEntityDescriptorEnum.ColumnDeclaration);
	}

	public void ColumnDeclaration_() {
		wEntity_(SQLEntityDescriptorEnum.ColumnDeclaration);
	}

	public void _ColumnDeclaration() {
		_wEntity(SQLEntityDescriptorEnum.ColumnDeclaration);
	}

	public void ColumnType() {
		wEntity(SQLEntityDescriptorEnum.ColumnType);
	}

	public void ColumnType_() {
		wEntity_(SQLEntityDescriptorEnum.ColumnType);
	}

	public void _ColumnType() {
		_wEntity(SQLEntityDescriptorEnum.ColumnType);
	}

	public void Type() {
		wEntity(SQLEntityDescriptorEnum.Type);
	}

	public void Type(String value) {
		wEntity(SQLEntityDescriptorEnum.Type, value);
	}

	public void ColumnConstraints() {
		wEntity(SQLEntityDescriptorEnum.ColumnConstraints);
	}

	public void ColumnConstraints_() {
		wEntity_(SQLEntityDescriptorEnum.ColumnConstraints);
	}

	public void ColumnConstraints_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.ColumnConstraints, initialCapacity);
	}

	public void _ColumnConstraints() {
		_wEntity(SQLEntityDescriptorEnum.ColumnConstraints);
	}

	public void SimpleColumnConstraint() {
		wEntity(SQLEntityDescriptorEnum.SimpleColumnConstraint);
	}

	public void SimpleColumnConstraint(SimpleColumnConstraintEnum.Value value) {
		wEntity(SQLEntityDescriptorEnum.SimpleColumnConstraint, value);
	}

	public void SimpleColumnConstraint(String value) {
		wEntity(SQLEntityDescriptorEnum.SimpleColumnConstraint, value);
	}

	public void ForeignKeyColumnConstraint() {
		wEntity(SQLEntityDescriptorEnum.ForeignKeyColumnConstraint);
	}

	public void ForeignKeyColumnConstraint_() {
		wEntity_(SQLEntityDescriptorEnum.ForeignKeyColumnConstraint);
	}

	public void _ForeignKeyColumnConstraint() {
		_wEntity(SQLEntityDescriptorEnum.ForeignKeyColumnConstraint);
	}

	public void UniqueTableConstraint() {
		wEntity(SQLEntityDescriptorEnum.UniqueTableConstraint);
	}

	public void UniqueTableConstraint_() {
		wEntity_(SQLEntityDescriptorEnum.UniqueTableConstraint);
	}

	public void _UniqueTableConstraint() {
		_wEntity(SQLEntityDescriptorEnum.UniqueTableConstraint);
	}

	public void PrimaryKeyTableConstraint() {
		wEntity(SQLEntityDescriptorEnum.PrimaryKeyTableConstraint);
	}

	public void PrimaryKeyTableConstraint_() {
		wEntity_(SQLEntityDescriptorEnum.PrimaryKeyTableConstraint);
	}

	public void _PrimaryKeyTableConstraint() {
		_wEntity(SQLEntityDescriptorEnum.PrimaryKeyTableConstraint);
	}

	public void ForeignKeyTableConstraint() {
		wEntity(SQLEntityDescriptorEnum.ForeignKeyTableConstraint);
	}

	public void ForeignKeyTableConstraint_() {
		wEntity_(SQLEntityDescriptorEnum.ForeignKeyTableConstraint);
	}

	public void _ForeignKeyTableConstraint() {
		_wEntity(SQLEntityDescriptorEnum.ForeignKeyTableConstraint);
	}

	public void Match() {
		wEntity(SQLEntityDescriptorEnum.Match);
	}

	public void Match(MatchEnum.Value value) {
		wEntity(SQLEntityDescriptorEnum.Match, value);
	}

	public void Match(String value) {
		wEntity(SQLEntityDescriptorEnum.Match, value);
	}

	public void Action() {
		wEntity(SQLEntityDescriptorEnum.Action);
	}

	public void Action(ActionEnum.Value value) {
		wEntity(SQLEntityDescriptorEnum.Action, value);
	}

	public void Action(String value) {
		wEntity(SQLEntityDescriptorEnum.Action, value);
	}

	public void Deferrable() {
		wEntity(SQLEntityDescriptorEnum.Deferrable);
	}

	public void Deferrable(DeferrableEnum.Value value) {
		wEntity(SQLEntityDescriptorEnum.Deferrable, value);
	}

	public void Deferrable(String value) {
		wEntity(SQLEntityDescriptorEnum.Deferrable, value);
	}

	public void DeferCheck() {
		wEntity(SQLEntityDescriptorEnum.DeferCheck);
	}

	public void DeferCheck(DeferCheckEnum.Value value) {
		wEntity(SQLEntityDescriptorEnum.DeferCheck, value);
	}

	public void DeferCheck(String value) {
		wEntity(SQLEntityDescriptorEnum.DeferCheck, value);
	}

	public void StoredProcedures() {
		wEntity(SQLEntityDescriptorEnum.StoredProcedures);
	}

	public void StoredProcedures_() {
		wEntity_(SQLEntityDescriptorEnum.StoredProcedures);
	}

	public void StoredProcedures_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.StoredProcedures, initialCapacity);
	}

	public void _StoredProcedures() {
		_wEntity(SQLEntityDescriptorEnum.StoredProcedures);
	}

	public void StoredProcedure() {
		wEntity(SQLEntityDescriptorEnum.StoredProcedure);
	}

	public void StoredProcedure_() {
		wEntity_(SQLEntityDescriptorEnum.StoredProcedure);
	}

	public void _StoredProcedure() {
		_wEntity(SQLEntityDescriptorEnum.StoredProcedure);
	}

	public void ProcedureDeclarations() {
		wEntity(SQLEntityDescriptorEnum.ProcedureDeclarations);
	}

	public void ProcedureDeclarations_() {
		wEntity_(SQLEntityDescriptorEnum.ProcedureDeclarations);
	}

	public void ProcedureDeclarations_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.ProcedureDeclarations, initialCapacity);
	}

	public void _ProcedureDeclarations() {
		_wEntity(SQLEntityDescriptorEnum.ProcedureDeclarations);
	}

	public void ProcedureStatements() {
		wEntity(SQLEntityDescriptorEnum.ProcedureStatements);
	}

	public void ProcedureStatements_() {
		wEntity_(SQLEntityDescriptorEnum.ProcedureStatements);
	}

	public void ProcedureStatements_(int initialCapacity) {
		wEntity_(SQLEntityDescriptorEnum.ProcedureStatements, initialCapacity);
	}

	public void _ProcedureStatements() {
		_wEntity(SQLEntityDescriptorEnum.ProcedureStatements);
	}

	public void DeclareCursor() {
		wEntity(SQLEntityDescriptorEnum.DeclareCursor);
	}

	public void DeclareCursor_() {
		wEntity_(SQLEntityDescriptorEnum.DeclareCursor);
	}

	public void _DeclareCursor() {
		_wEntity(SQLEntityDescriptorEnum.DeclareCursor);
	}

	public void SimpleVariableDeclaration() {
		wEntity(SQLEntityDescriptorEnum.SimpleVariableDeclaration);
	}

	public void SimpleVariableDeclaration_() {
		wEntity_(SQLEntityDescriptorEnum.SimpleVariableDeclaration);
	}

	public void _SimpleVariableDeclaration() {
		_wEntity(SQLEntityDescriptorEnum.SimpleVariableDeclaration);
	}

	public void VariableDeclaration() {
		wEntity(SQLEntityDescriptorEnum.VariableDeclaration);
	}

	public void VariableDeclaration_() {
		wEntity_(SQLEntityDescriptorEnum.VariableDeclaration);
	}

	public void _VariableDeclaration() {
		_wEntity(SQLEntityDescriptorEnum.VariableDeclaration);
	}

	public void Reference() {
		wEntity(SQLEntityDescriptorEnum.Reference);
	}

	public void Reference(String value) {
		wEntity(SQLEntityDescriptorEnum.Reference, value);
	}

	public void ReferenceType() {
		wEntity(SQLEntityDescriptorEnum.ReferenceType);
	}

	public void ReferenceType(ReferenceTypeEnum.Value value) {
		wEntity(SQLEntityDescriptorEnum.ReferenceType, value);
	}

	public void ReferenceType(String value) {
		wEntity(SQLEntityDescriptorEnum.ReferenceType, value);
	}

	public void ArrayExpr() {
		wEntity(SQLEntityDescriptorEnum.ArrayExpr);
	}

	public void ArrayExpr(String value) {
		wEntity(SQLEntityDescriptorEnum.ArrayExpr, value);
	}

	public void Name() {
		wEntity(SQLEntityDescriptorEnum.Name);
	}

	public void Name(String value) {
		wEntity(SQLEntityDescriptorEnum.Name, value);
	}
}
