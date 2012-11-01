package org.whole.lang.sql.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.sql.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;

/** 
 * @generator Whole
 */
public class SQLEntityFactory extends GenericEntityFactory {
	public static final SQLEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static SQLEntityFactory instance(IEntityRegistryProvider provider) {
		return new SQLEntityFactory(provider);
	}

	protected SQLEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public SQLStatements createSQLStatements() {
		return create(SQLEntityDescriptorEnum.SQLStatements);
	}

	public SQLStatements createSQLStatements(SQLStatement... entities) {
		return create(SQLEntityDescriptorEnum.SQLStatements,
				(IEntity[]) entities);
	}

	public SQLStatements createSQLStatements(int initialSize) {
		return clone(SQLEntityDescriptorEnum.SQLStatements, initialSize);
	}

	public Select createSelect() {
		return create(SQLEntityDescriptorEnum.Select);
	}

	public Select createSelect(SelectType selectType,
			ColumnExpressions columnExprs, FromClauses fromClauses,
			SQLExpression whereExpr, SQLExpressions groupByExprs,
			SQLExpression havingExpr,
			OrderByColumnExpressions orderByColumnExprs) {
		return create(SQLEntityDescriptorEnum.Select, selectType, columnExprs,
				fromClauses, whereExpr, groupByExprs, havingExpr,
				orderByColumnExprs);
	}

	public IEntityBuilder<Select> buildSelect() {
		return new EntityBuilder<Select>(create(SQLEntityDescriptorEnum.Select));
	}

	public UnionSelect createUnionSelect() {
		return create(SQLEntityDescriptorEnum.UnionSelect);
	}

	public UnionSelect createUnionSelect(Select simpleSelect,
			SelectSQLStatement unionSelectStatement) {
		return create(SQLEntityDescriptorEnum.UnionSelect, simpleSelect,
				unionSelectStatement);
	}

	public IEntityBuilder<UnionSelect> buildUnionSelect() {
		return new EntityBuilder<UnionSelect>(
				create(SQLEntityDescriptorEnum.UnionSelect));
	}

	public Insert createInsert() {
		return create(SQLEntityDescriptorEnum.Insert);
	}

	public Insert createInsert(TableName tableName, ColumnNames columnNames,
			Values values) {
		return create(SQLEntityDescriptorEnum.Insert, tableName, columnNames,
				values);
	}

	public IEntityBuilder<Insert> buildInsert() {
		return new EntityBuilder<Insert>(create(SQLEntityDescriptorEnum.Insert));
	}

	public InsertFromSelect createInsertFromSelect() {
		return create(SQLEntityDescriptorEnum.InsertFromSelect);
	}

	public InsertFromSelect createInsertFromSelect(TableName tableName,
			ColumnNames columnNames, SelectSQLStatement select) {
		return create(SQLEntityDescriptorEnum.InsertFromSelect, tableName,
				columnNames, select);
	}

	public IEntityBuilder<InsertFromSelect> buildInsertFromSelect() {
		return new EntityBuilder<InsertFromSelect>(
				create(SQLEntityDescriptorEnum.InsertFromSelect));
	}

	public Update createUpdate() {
		return create(SQLEntityDescriptorEnum.Update);
	}

	public Update createUpdate(TableName tableName, SetClauses setClauses,
			FromClauses fromClauses, SQLExpression whereExpr, IntValue limit) {
		return create(SQLEntityDescriptorEnum.Update, tableName, setClauses,
				fromClauses, whereExpr, limit);
	}

	public IEntityBuilder<Update> buildUpdate() {
		return new EntityBuilder<Update>(create(SQLEntityDescriptorEnum.Update));
	}

	public Create createCreate() {
		return create(SQLEntityDescriptorEnum.Create);
	}

	public Create createCreate(TableName tableName,
			DeclarationOrConstraints declarationOrConstraints) {
		return create(SQLEntityDescriptorEnum.Create, tableName,
				declarationOrConstraints);
	}

	public IEntityBuilder<Create> buildCreate() {
		return new EntityBuilder<Create>(create(SQLEntityDescriptorEnum.Create));
	}

	public Delete createDelete() {
		return create(SQLEntityDescriptorEnum.Delete);
	}

	public Delete createDelete(TableName tableName, SQLExpression whereExpr,
			IntValue limit) {
		return create(SQLEntityDescriptorEnum.Delete, tableName, whereExpr,
				limit);
	}

	public IEntityBuilder<Delete> buildDelete() {
		return new EntityBuilder<Delete>(create(SQLEntityDescriptorEnum.Delete));
	}

	public Drop createDrop() {
		return create(SQLEntityDescriptorEnum.Drop);
	}

	public Drop createDrop(TableName tableName) {
		return create(SQLEntityDescriptorEnum.Drop, tableName);
	}

	public Truncate createTruncate() {
		return create(SQLEntityDescriptorEnum.Truncate);
	}

	public Truncate createTruncate(TableName tableName) {
		return create(SQLEntityDescriptorEnum.Truncate, tableName);
	}

	public AlterTable createAlterTable() {
		return create(SQLEntityDescriptorEnum.AlterTable);
	}

	public AlterTable createAlterTable(TableName tableName, AlterAction action) {
		return create(SQLEntityDescriptorEnum.AlterTable, tableName, action);
	}

	public IEntityBuilder<AlterTable> buildAlterTable() {
		return new EntityBuilder<AlterTable>(
				create(SQLEntityDescriptorEnum.AlterTable));
	}

	public CreateIndex createCreateIndex() {
		return create(SQLEntityDescriptorEnum.CreateIndex);
	}

	public CreateIndex createCreateIndex(UniqueIndex unique,
			IndexName indexName, TableName tableName,
			IndexDeclarations indexDeclarations) {
		return create(SQLEntityDescriptorEnum.CreateIndex, unique, indexName,
				tableName, indexDeclarations);
	}

	public IEntityBuilder<CreateIndex> buildCreateIndex() {
		return new EntityBuilder<CreateIndex>(
				create(SQLEntityDescriptorEnum.CreateIndex));
	}

	public UniqueIndex createUniqueIndex() {
		return create(SQLEntityDescriptorEnum.UniqueIndex);
	}

	public IndexDeclarations createIndexDeclarations() {
		return create(SQLEntityDescriptorEnum.IndexDeclarations);
	}

	public IndexDeclarations createIndexDeclarations(
			IndexDeclaration... entities) {
		return create(SQLEntityDescriptorEnum.IndexDeclarations,
				(IEntity[]) entities);
	}

	public IndexDeclarations createIndexDeclarations(int initialSize) {
		return clone(SQLEntityDescriptorEnum.IndexDeclarations, initialSize);
	}

	public IndexDeclaration createIndexDeclaration() {
		return create(SQLEntityDescriptorEnum.IndexDeclaration);
	}

	public IndexDeclaration createIndexDeclaration(ColumnName columnName,
			OrderType orderType, NullOrderType nullOrderType) {
		return create(SQLEntityDescriptorEnum.IndexDeclaration, columnName,
				orderType, nullOrderType);
	}

	public IEntityBuilder<IndexDeclaration> buildIndexDeclaration() {
		return new EntityBuilder<IndexDeclaration>(
				create(SQLEntityDescriptorEnum.IndexDeclaration));
	}

	public NullOrderType createNullOrderType() {
		return create(SQLEntityDescriptorEnum.NullOrderType);
	}

	public NullOrderType createNullOrderType(NullOrderTypeEnum.Value value) {
		return create(SQLEntityDescriptorEnum.NullOrderType, value);
	}

	public DropIndex createDropIndex() {
		return create(SQLEntityDescriptorEnum.DropIndex);
	}

	public DropIndex createDropIndex(IndexName indexName) {
		return create(SQLEntityDescriptorEnum.DropIndex, indexName);
	}

	public Foreach createForeach() {
		return create(SQLEntityDescriptorEnum.Foreach);
	}

	public Foreach createForeach(Name name, ArrayExpr arrayExp,
			SQLStatement trueBody) {
		return create(SQLEntityDescriptorEnum.Foreach, name, arrayExp, trueBody);
	}

	public IEntityBuilder<Foreach> buildForeach() {
		return new EntityBuilder<Foreach>(
				create(SQLEntityDescriptorEnum.Foreach));
	}

	public AddAction createAddAction() {
		return create(SQLEntityDescriptorEnum.AddAction);
	}

	public AddAction createAddAction(
			DeclarationOrConstraint declarationOrConstraint) {
		return create(SQLEntityDescriptorEnum.AddAction,
				declarationOrConstraint);
	}

	public SelectType createSelectType() {
		return create(SQLEntityDescriptorEnum.SelectType);
	}

	public SelectType createSelectType(SelectTypeEnum.Value value) {
		return create(SQLEntityDescriptorEnum.SelectType, value);
	}

	public ColumnNames createColumnNames() {
		return create(SQLEntityDescriptorEnum.ColumnNames);
	}

	public ColumnNames createColumnNames(ColumnName... entities) {
		return create(SQLEntityDescriptorEnum.ColumnNames, (IEntity[]) entities);
	}

	public ColumnNames createColumnNames(int initialSize) {
		return clone(SQLEntityDescriptorEnum.ColumnNames, initialSize);
	}

	public ColumnExpressions createColumnExpressions() {
		return create(SQLEntityDescriptorEnum.ColumnExpressions);
	}

	public ColumnExpressions createColumnExpressions(
			ColumnExpression... entities) {
		return create(SQLEntityDescriptorEnum.ColumnExpressions,
				(IEntity[]) entities);
	}

	public ColumnExpressions createColumnExpressions(int initialSize) {
		return clone(SQLEntityDescriptorEnum.ColumnExpressions, initialSize);
	}

	public ColumnExpression createColumnExpression() {
		return create(SQLEntityDescriptorEnum.ColumnExpression);
	}

	public ColumnExpression createColumnExpression(SQLExpression expression,
			Alias alias) {
		return create(SQLEntityDescriptorEnum.ColumnExpression, expression,
				alias);
	}

	public IEntityBuilder<ColumnExpression> buildColumnExpression() {
		return new EntityBuilder<ColumnExpression>(
				create(SQLEntityDescriptorEnum.ColumnExpression));
	}

	public Alias createAlias() {
		return create(SQLEntityDescriptorEnum.Alias);
	}

	public Alias createAlias(String value) {
		return create(SQLEntityDescriptorEnum.Alias, value);
	}

	public FromClauses createFromClauses() {
		return create(SQLEntityDescriptorEnum.FromClauses);
	}

	public FromClauses createFromClauses(FromClause... entities) {
		return create(SQLEntityDescriptorEnum.FromClauses, (IEntity[]) entities);
	}

	public FromClauses createFromClauses(int initialSize) {
		return clone(SQLEntityDescriptorEnum.FromClauses, initialSize);
	}

	public SimpleFromClause createSimpleFromClause() {
		return create(SQLEntityDescriptorEnum.SimpleFromClause);
	}

	public SimpleFromClause createSimpleFromClause(String value) {
		return create(SQLEntityDescriptorEnum.SimpleFromClause, value);
	}

	public InnerJoinFromClause createInnerJoinFromClause() {
		return create(SQLEntityDescriptorEnum.InnerJoinFromClause);
	}

	public InnerJoinFromClause createInnerJoinFromClause(TableName tableName,
			TableName innerTable, SQLExpression onExpression) {
		return create(SQLEntityDescriptorEnum.InnerJoinFromClause, tableName,
				innerTable, onExpression);
	}

	public IEntityBuilder<InnerJoinFromClause> buildInnerJoinFromClause() {
		return new EntityBuilder<InnerJoinFromClause>(
				create(SQLEntityDescriptorEnum.InnerJoinFromClause));
	}

	public LeftOuterJoinFromClause createLeftOuterJoinFromClause() {
		return create(SQLEntityDescriptorEnum.LeftOuterJoinFromClause);
	}

	public LeftOuterJoinFromClause createLeftOuterJoinFromClause(
			TableName tableName, TableName outerTable,
			SQLExpression onExpression) {
		return create(SQLEntityDescriptorEnum.LeftOuterJoinFromClause,
				tableName, outerTable, onExpression);
	}

	public IEntityBuilder<LeftOuterJoinFromClause> buildLeftOuterJoinFromClause() {
		return new EntityBuilder<LeftOuterJoinFromClause>(
				create(SQLEntityDescriptorEnum.LeftOuterJoinFromClause));
	}

	public RightOuterJoinFromClause createRightOuterJoinFromClause() {
		return create(SQLEntityDescriptorEnum.RightOuterJoinFromClause);
	}

	public RightOuterJoinFromClause createRightOuterJoinFromClause(
			TableName tableName, TableName outerTable,
			SQLExpression onExpression) {
		return create(SQLEntityDescriptorEnum.RightOuterJoinFromClause,
				tableName, outerTable, onExpression);
	}

	public IEntityBuilder<RightOuterJoinFromClause> buildRightOuterJoinFromClause() {
		return new EntityBuilder<RightOuterJoinFromClause>(
				create(SQLEntityDescriptorEnum.RightOuterJoinFromClause));
	}

	public Between createBetween() {
		return create(SQLEntityDescriptorEnum.Between);
	}

	public Between createBetween(SQLExpression expression,
			SQLExpression lowerExpression, SQLExpression upperExpression) {
		return create(SQLEntityDescriptorEnum.Between, expression,
				lowerExpression, upperExpression);
	}

	public IEntityBuilder<Between> buildBetween() {
		return new EntityBuilder<Between>(
				create(SQLEntityDescriptorEnum.Between));
	}

	public NotBetween createNotBetween() {
		return create(SQLEntityDescriptorEnum.NotBetween);
	}

	public NotBetween createNotBetween(SQLExpression expression,
			SQLExpression lowerExpression, SQLExpression upperExpression) {
		return create(SQLEntityDescriptorEnum.NotBetween, expression,
				lowerExpression, upperExpression);
	}

	public IEntityBuilder<NotBetween> buildNotBetween() {
		return new EntityBuilder<NotBetween>(
				create(SQLEntityDescriptorEnum.NotBetween));
	}

	public Is createIs() {
		return create(SQLEntityDescriptorEnum.Is);
	}

	public Is createIs(SQLExpression expression, IsType type) {
		return create(SQLEntityDescriptorEnum.Is, expression, type);
	}

	public IEntityBuilder<Is> buildIs() {
		return new EntityBuilder<Is>(create(SQLEntityDescriptorEnum.Is));
	}

	public IsType createIsType() {
		return create(SQLEntityDescriptorEnum.IsType);
	}

	public IsType createIsType(IsTypeEnum.Value value) {
		return create(SQLEntityDescriptorEnum.IsType, value);
	}

	public Values createValues() {
		return create(SQLEntityDescriptorEnum.Values);
	}

	public Values createValues(SQLExpressions... entities) {
		return create(SQLEntityDescriptorEnum.Values, (IEntity[]) entities);
	}

	public Values createValues(int initialSize) {
		return clone(SQLEntityDescriptorEnum.Values, initialSize);
	}

	public ParenthesizedExpression createParenthesizedExpression() {
		return create(SQLEntityDescriptorEnum.ParenthesizedExpression);
	}

	public ParenthesizedExpression createParenthesizedExpression(
			SQLExpression expression) {
		return create(SQLEntityDescriptorEnum.ParenthesizedExpression,
				expression);
	}

	public SQLExpressions createSQLExpressions() {
		return create(SQLEntityDescriptorEnum.SQLExpressions);
	}

	public SQLExpressions createSQLExpressions(SQLExpression... entities) {
		return create(SQLEntityDescriptorEnum.SQLExpressions,
				(IEntity[]) entities);
	}

	public SQLExpressions createSQLExpressions(int initialSize) {
		return clone(SQLEntityDescriptorEnum.SQLExpressions, initialSize);
	}

	public NullValue createNullValue() {
		return create(SQLEntityDescriptorEnum.NullValue);
	}

	public ArrayValue createArrayValue() {
		return create(SQLEntityDescriptorEnum.ArrayValue);
	}

	public ArrayValue createArrayValue(Object value) {
		return create(SQLEntityDescriptorEnum.ArrayValue, value);
	}

	public BooleanValue createBooleanValue() {
		return create(SQLEntityDescriptorEnum.BooleanValue);
	}

	public BooleanValue createBooleanValue(boolean value) {
		return create(SQLEntityDescriptorEnum.BooleanValue, value);
	}

	public TinyIntValue createTinyIntValue() {
		return create(SQLEntityDescriptorEnum.TinyIntValue);
	}

	public TinyIntValue createTinyIntValue(byte value) {
		return create(SQLEntityDescriptorEnum.TinyIntValue, value);
	}

	public SmallIntValue createSmallIntValue() {
		return create(SQLEntityDescriptorEnum.SmallIntValue);
	}

	public SmallIntValue createSmallIntValue(short value) {
		return create(SQLEntityDescriptorEnum.SmallIntValue, value);
	}

	public IntValue createIntValue() {
		return create(SQLEntityDescriptorEnum.IntValue);
	}

	public IntValue createIntValue(int value) {
		return create(SQLEntityDescriptorEnum.IntValue, value);
	}

	public BigIntValue createBigIntValue() {
		return create(SQLEntityDescriptorEnum.BigIntValue);
	}

	public BigIntValue createBigIntValue(long value) {
		return create(SQLEntityDescriptorEnum.BigIntValue, value);
	}

	public DoubleValue createDoubleValue() {
		return create(SQLEntityDescriptorEnum.DoubleValue);
	}

	public DoubleValue createDoubleValue(double value) {
		return create(SQLEntityDescriptorEnum.DoubleValue, value);
	}

	public RealValue createRealValue() {
		return create(SQLEntityDescriptorEnum.RealValue);
	}

	public RealValue createRealValue(float value) {
		return create(SQLEntityDescriptorEnum.RealValue, value);
	}

	public DecimalValue createDecimalValue() {
		return create(SQLEntityDescriptorEnum.DecimalValue);
	}

	public DecimalValue createDecimalValue(java.math.BigDecimal value) {
		return create(SQLEntityDescriptorEnum.DecimalValue, value);
	}

	public StringValue createStringValue() {
		return create(SQLEntityDescriptorEnum.StringValue);
	}

	public StringValue createStringValue(String value) {
		return create(SQLEntityDescriptorEnum.StringValue, value);
	}

	public BinaryValue createBinaryValue() {
		return create(SQLEntityDescriptorEnum.BinaryValue);
	}

	public BinaryValue createBinaryValue(Object value) {
		return create(SQLEntityDescriptorEnum.BinaryValue, value);
	}

	public DateValue createDateValue() {
		return create(SQLEntityDescriptorEnum.DateValue);
	}

	public DateValue createDateValue(java.sql.Date value) {
		return create(SQLEntityDescriptorEnum.DateValue, value);
	}

	public TimeValue createTimeValue() {
		return create(SQLEntityDescriptorEnum.TimeValue);
	}

	public TimeValue createTimeValue(java.sql.Time value) {
		return create(SQLEntityDescriptorEnum.TimeValue, value);
	}

	public TimestampValue createTimestampValue() {
		return create(SQLEntityDescriptorEnum.TimestampValue);
	}

	public TimestampValue createTimestampValue(java.sql.Timestamp value) {
		return create(SQLEntityDescriptorEnum.TimestampValue, value);
	}

	public BlobValue createBlobValue() {
		return create(SQLEntityDescriptorEnum.BlobValue);
	}

	public BlobValue createBlobValue(java.sql.Blob value) {
		return create(SQLEntityDescriptorEnum.BlobValue, value);
	}

	public ClobValue createClobValue() {
		return create(SQLEntityDescriptorEnum.ClobValue);
	}

	public ClobValue createClobValue(java.sql.Clob value) {
		return create(SQLEntityDescriptorEnum.ClobValue, value);
	}

	public RawValue createRawValue() {
		return create(SQLEntityDescriptorEnum.RawValue);
	}

	public RawValue createRawValue(Object value) {
		return create(SQLEntityDescriptorEnum.RawValue, value);
	}

	public TableName createTableName() {
		return create(SQLEntityDescriptorEnum.TableName);
	}

	public TableName createTableName(String value) {
		return create(SQLEntityDescriptorEnum.TableName, value);
	}

	public ColumnName createColumnName() {
		return create(SQLEntityDescriptorEnum.ColumnName);
	}

	public ColumnName createColumnName(String value) {
		return create(SQLEntityDescriptorEnum.ColumnName, value);
	}

	public IndexName createIndexName() {
		return create(SQLEntityDescriptorEnum.IndexName);
	}

	public IndexName createIndexName(String value) {
		return create(SQLEntityDescriptorEnum.IndexName, value);
	}

	public CaseExpression createCaseExpression() {
		return create(SQLEntityDescriptorEnum.CaseExpression);
	}

	public CaseExpression createCaseExpression(WhenClauses whenClauses,
			SQLExpression elseClause) {
		return create(SQLEntityDescriptorEnum.CaseExpression, whenClauses,
				elseClause);
	}

	public IEntityBuilder<CaseExpression> buildCaseExpression() {
		return new EntityBuilder<CaseExpression>(
				create(SQLEntityDescriptorEnum.CaseExpression));
	}

	public WhenClauses createWhenClauses() {
		return create(SQLEntityDescriptorEnum.WhenClauses);
	}

	public WhenClauses createWhenClauses(WhenClause... entities) {
		return create(SQLEntityDescriptorEnum.WhenClauses, (IEntity[]) entities);
	}

	public WhenClauses createWhenClauses(int initialSize) {
		return clone(SQLEntityDescriptorEnum.WhenClauses, initialSize);
	}

	public WhenClause createWhenClause() {
		return create(SQLEntityDescriptorEnum.WhenClause);
	}

	public WhenClause createWhenClause(BooleanExpression condition,
			SQLExpression result) {
		return create(SQLEntityDescriptorEnum.WhenClause, condition, result);
	}

	public IEntityBuilder<WhenClause> buildWhenClause() {
		return new EntityBuilder<WhenClause>(
				create(SQLEntityDescriptorEnum.WhenClause));
	}

	public In createIn() {
		return create(SQLEntityDescriptorEnum.In);
	}

	public In createIn(SQLExpression leftExpr, InPredicate inPredicate) {
		return create(SQLEntityDescriptorEnum.In, leftExpr, inPredicate);
	}

	public IEntityBuilder<In> buildIn() {
		return new EntityBuilder<In>(create(SQLEntityDescriptorEnum.In));
	}

	public NotIn createNotIn() {
		return create(SQLEntityDescriptorEnum.NotIn);
	}

	public NotIn createNotIn(SQLExpression leftExpr, InPredicate inPredicate) {
		return create(SQLEntityDescriptorEnum.NotIn, leftExpr, inPredicate);
	}

	public IEntityBuilder<NotIn> buildNotIn() {
		return new EntityBuilder<NotIn>(create(SQLEntityDescriptorEnum.NotIn));
	}

	public Subquery createSubquery() {
		return create(SQLEntityDescriptorEnum.Subquery);
	}

	public Subquery createSubquery(SelectSQLStatement query) {
		return create(SQLEntityDescriptorEnum.Subquery, query);
	}

	public InValueList createInValueList() {
		return create(SQLEntityDescriptorEnum.InValueList);
	}

	public InValueList createInValueList(SQLExpression... entities) {
		return create(SQLEntityDescriptorEnum.InValueList, (IEntity[]) entities);
	}

	public InValueList createInValueList(int initialSize) {
		return clone(SQLEntityDescriptorEnum.InValueList, initialSize);
	}

	public BinaryExpression createBinaryExpression() {
		return create(SQLEntityDescriptorEnum.BinaryExpression);
	}

	public BinaryExpression createBinaryExpression(SQLExpression leftExpr,
			BinaryOperator operator, SQLExpression rightExpr) {
		return create(SQLEntityDescriptorEnum.BinaryExpression, leftExpr,
				operator, rightExpr);
	}

	public IEntityBuilder<BinaryExpression> buildBinaryExpression() {
		return new EntityBuilder<BinaryExpression>(
				create(SQLEntityDescriptorEnum.BinaryExpression));
	}

	public BinaryOperator createBinaryOperator() {
		return create(SQLEntityDescriptorEnum.BinaryOperator);
	}

	public BinaryOperator createBinaryOperator(BinaryOperatorEnum.Value value) {
		return create(SQLEntityDescriptorEnum.BinaryOperator, value);
	}

	public BooleanBinaryExpression createBooleanBinaryExpression() {
		return create(SQLEntityDescriptorEnum.BooleanBinaryExpression);
	}

	public BooleanBinaryExpression createBooleanBinaryExpression(
			SQLExpression leftExpr, BooleanOperator operator,
			SQLExpression rightExpr) {
		return create(SQLEntityDescriptorEnum.BooleanBinaryExpression,
				leftExpr, operator, rightExpr);
	}

	public IEntityBuilder<BooleanBinaryExpression> buildBooleanBinaryExpression() {
		return new EntityBuilder<BooleanBinaryExpression>(
				create(SQLEntityDescriptorEnum.BooleanBinaryExpression));
	}

	public BooleanOperator createBooleanOperator() {
		return create(SQLEntityDescriptorEnum.BooleanOperator);
	}

	public BooleanOperator createBooleanOperator(BooleanOperatorEnum.Value value) {
		return create(SQLEntityDescriptorEnum.BooleanOperator, value);
	}

	public FunctionExpression createFunctionExpression() {
		return create(SQLEntityDescriptorEnum.FunctionExpression);
	}

	public FunctionExpression createFunctionExpression(
			FunctionName functionName, SQLExpressions params) {
		return create(SQLEntityDescriptorEnum.FunctionExpression, functionName,
				params);
	}

	public IEntityBuilder<FunctionExpression> buildFunctionExpression() {
		return new EntityBuilder<FunctionExpression>(
				create(SQLEntityDescriptorEnum.FunctionExpression));
	}

	public FunctionName createFunctionName() {
		return create(SQLEntityDescriptorEnum.FunctionName);
	}

	public FunctionName createFunctionName(String value) {
		return create(SQLEntityDescriptorEnum.FunctionName, value);
	}

	public OrderByColumnExpressions createOrderByColumnExpressions() {
		return create(SQLEntityDescriptorEnum.OrderByColumnExpressions);
	}

	public OrderByColumnExpressions createOrderByColumnExpressions(
			OrderByColumnExpression... entities) {
		return create(SQLEntityDescriptorEnum.OrderByColumnExpressions,
				(IEntity[]) entities);
	}

	public OrderByColumnExpressions createOrderByColumnExpressions(
			int initialSize) {
		return clone(SQLEntityDescriptorEnum.OrderByColumnExpressions,
				initialSize);
	}

	public OrderByColumnExpression createOrderByColumnExpression() {
		return create(SQLEntityDescriptorEnum.OrderByColumnExpression);
	}

	public OrderByColumnExpression createOrderByColumnExpression(
			SQLExpression expression, OrderType orderType) {
		return create(SQLEntityDescriptorEnum.OrderByColumnExpression,
				expression, orderType);
	}

	public IEntityBuilder<OrderByColumnExpression> buildOrderByColumnExpression() {
		return new EntityBuilder<OrderByColumnExpression>(
				create(SQLEntityDescriptorEnum.OrderByColumnExpression));
	}

	public OrderType createOrderType() {
		return create(SQLEntityDescriptorEnum.OrderType);
	}

	public OrderType createOrderType(OrderTypeEnum.Value value) {
		return create(SQLEntityDescriptorEnum.OrderType, value);
	}

	public SetClauses createSetClauses() {
		return create(SQLEntityDescriptorEnum.SetClauses);
	}

	public SetClauses createSetClauses(SetClause... entities) {
		return create(SQLEntityDescriptorEnum.SetClauses, (IEntity[]) entities);
	}

	public SetClauses createSetClauses(int initialSize) {
		return clone(SQLEntityDescriptorEnum.SetClauses, initialSize);
	}

	public SetClause createSetClause() {
		return create(SQLEntityDescriptorEnum.SetClause);
	}

	public SetClause createSetClause(ColumnName columnName,
			SQLExpression expression) {
		return create(SQLEntityDescriptorEnum.SetClause, columnName, expression);
	}

	public IEntityBuilder<SetClause> buildSetClause() {
		return new EntityBuilder<SetClause>(
				create(SQLEntityDescriptorEnum.SetClause));
	}

	public DeclarationOrConstraints createDeclarationOrConstraints() {
		return create(SQLEntityDescriptorEnum.DeclarationOrConstraints);
	}

	public DeclarationOrConstraints createDeclarationOrConstraints(
			DeclarationOrConstraint... entities) {
		return create(SQLEntityDescriptorEnum.DeclarationOrConstraints,
				(IEntity[]) entities);
	}

	public DeclarationOrConstraints createDeclarationOrConstraints(
			int initialSize) {
		return clone(SQLEntityDescriptorEnum.DeclarationOrConstraints,
				initialSize);
	}

	public ColumnDeclaration createColumnDeclaration() {
		return create(SQLEntityDescriptorEnum.ColumnDeclaration);
	}

	public ColumnDeclaration createColumnDeclaration(ColumnName columnName,
			ColumnType columnType, ColumnConstraints columnConstraints) {
		return create(SQLEntityDescriptorEnum.ColumnDeclaration, columnName,
				columnType, columnConstraints);
	}

	public IEntityBuilder<ColumnDeclaration> buildColumnDeclaration() {
		return new EntityBuilder<ColumnDeclaration>(
				create(SQLEntityDescriptorEnum.ColumnDeclaration));
	}

	public ColumnType createColumnType() {
		return create(SQLEntityDescriptorEnum.ColumnType);
	}

	public ColumnType createColumnType(Type type, IntValue size,
			IntValue precision) {
		return create(SQLEntityDescriptorEnum.ColumnType, type, size, precision);
	}

	public IEntityBuilder<ColumnType> buildColumnType() {
		return new EntityBuilder<ColumnType>(
				create(SQLEntityDescriptorEnum.ColumnType));
	}

	public Type createType() {
		return create(SQLEntityDescriptorEnum.Type);
	}

	public Type createType(String value) {
		return create(SQLEntityDescriptorEnum.Type, value);
	}

	public ColumnConstraints createColumnConstraints() {
		return create(SQLEntityDescriptorEnum.ColumnConstraints);
	}

	public ColumnConstraints createColumnConstraints(
			ColumnConstraint... entities) {
		return create(SQLEntityDescriptorEnum.ColumnConstraints,
				(IEntity[]) entities);
	}

	public ColumnConstraints createColumnConstraints(int initialSize) {
		return clone(SQLEntityDescriptorEnum.ColumnConstraints, initialSize);
	}

	public SimpleColumnConstraint createSimpleColumnConstraint() {
		return create(SQLEntityDescriptorEnum.SimpleColumnConstraint);
	}

	public SimpleColumnConstraint createSimpleColumnConstraint(
			SimpleColumnConstraintEnum.Value value) {
		return create(SQLEntityDescriptorEnum.SimpleColumnConstraint, value);
	}

	public ForeignKeyColumnConstraint createForeignKeyColumnConstraint() {
		return create(SQLEntityDescriptorEnum.ForeignKeyColumnConstraint);
	}

	public ForeignKeyColumnConstraint createForeignKeyColumnConstraint(
			TableName foreignTableName, ColumnName foreignColumnName) {
		return create(SQLEntityDescriptorEnum.ForeignKeyColumnConstraint,
				foreignTableName, foreignColumnName);
	}

	public IEntityBuilder<ForeignKeyColumnConstraint> buildForeignKeyColumnConstraint() {
		return new EntityBuilder<ForeignKeyColumnConstraint>(
				create(SQLEntityDescriptorEnum.ForeignKeyColumnConstraint));
	}

	public UniqueTableConstraint createUniqueTableConstraint() {
		return create(SQLEntityDescriptorEnum.UniqueTableConstraint);
	}

	public UniqueTableConstraint createUniqueTableConstraint(
			ColumnNames columnNames) {
		return create(SQLEntityDescriptorEnum.UniqueTableConstraint,
				columnNames);
	}

	public PrimaryKeyTableConstraint createPrimaryKeyTableConstraint() {
		return create(SQLEntityDescriptorEnum.PrimaryKeyTableConstraint);
	}

	public PrimaryKeyTableConstraint createPrimaryKeyTableConstraint(
			ColumnNames columnNames) {
		return create(SQLEntityDescriptorEnum.PrimaryKeyTableConstraint,
				columnNames);
	}

	public ForeignKeyTableConstraint createForeignKeyTableConstraint() {
		return create(SQLEntityDescriptorEnum.ForeignKeyTableConstraint);
	}

	public ForeignKeyTableConstraint createForeignKeyTableConstraint(
			ColumnNames columnNames, TableName foreignTableName,
			ColumnNames foreignColumnNames, Match match, Action onDelete,
			Action onUpdate, Deferrable deferrable, DeferCheck deferCheck) {
		return create(SQLEntityDescriptorEnum.ForeignKeyTableConstraint,
				columnNames, foreignTableName, foreignColumnNames, match,
				onDelete, onUpdate, deferrable, deferCheck);
	}

	public IEntityBuilder<ForeignKeyTableConstraint> buildForeignKeyTableConstraint() {
		return new EntityBuilder<ForeignKeyTableConstraint>(
				create(SQLEntityDescriptorEnum.ForeignKeyTableConstraint));
	}

	public Match createMatch() {
		return create(SQLEntityDescriptorEnum.Match);
	}

	public Match createMatch(MatchEnum.Value value) {
		return create(SQLEntityDescriptorEnum.Match, value);
	}

	public Action createAction() {
		return create(SQLEntityDescriptorEnum.Action);
	}

	public Action createAction(ActionEnum.Value value) {
		return create(SQLEntityDescriptorEnum.Action, value);
	}

	public Deferrable createDeferrable() {
		return create(SQLEntityDescriptorEnum.Deferrable);
	}

	public Deferrable createDeferrable(DeferrableEnum.Value value) {
		return create(SQLEntityDescriptorEnum.Deferrable, value);
	}

	public DeferCheck createDeferCheck() {
		return create(SQLEntityDescriptorEnum.DeferCheck);
	}

	public DeferCheck createDeferCheck(DeferCheckEnum.Value value) {
		return create(SQLEntityDescriptorEnum.DeferCheck, value);
	}

	public StoredProcedures createStoredProcedures() {
		return create(SQLEntityDescriptorEnum.StoredProcedures);
	}

	public StoredProcedures createStoredProcedures(StoredProcedure... entities) {
		return create(SQLEntityDescriptorEnum.StoredProcedures,
				(IEntity[]) entities);
	}

	public StoredProcedures createStoredProcedures(int initialSize) {
		return clone(SQLEntityDescriptorEnum.StoredProcedures, initialSize);
	}

	public StoredProcedure createStoredProcedure() {
		return create(SQLEntityDescriptorEnum.StoredProcedure);
	}

	public StoredProcedure createStoredProcedure(Name name,
			ProcedureDeclarations procedureDeclarations,
			ProcedureStatements procedureStatements) {
		return create(SQLEntityDescriptorEnum.StoredProcedure, name,
				procedureDeclarations, procedureStatements);
	}

	public IEntityBuilder<StoredProcedure> buildStoredProcedure() {
		return new EntityBuilder<StoredProcedure>(
				create(SQLEntityDescriptorEnum.StoredProcedure));
	}

	public ProcedureDeclarations createProcedureDeclarations() {
		return create(SQLEntityDescriptorEnum.ProcedureDeclarations);
	}

	public ProcedureDeclarations createProcedureDeclarations(
			ProcedureDeclaration... entities) {
		return create(SQLEntityDescriptorEnum.ProcedureDeclarations,
				(IEntity[]) entities);
	}

	public ProcedureDeclarations createProcedureDeclarations(int initialSize) {
		return clone(SQLEntityDescriptorEnum.ProcedureDeclarations, initialSize);
	}

	public ProcedureStatements createProcedureStatements() {
		return create(SQLEntityDescriptorEnum.ProcedureStatements);
	}

	public ProcedureStatements createProcedureStatements(
			SQLStatement... entities) {
		return create(SQLEntityDescriptorEnum.ProcedureStatements,
				(IEntity[]) entities);
	}

	public ProcedureStatements createProcedureStatements(int initialSize) {
		return clone(SQLEntityDescriptorEnum.ProcedureStatements, initialSize);
	}

	public DeclareCursor createDeclareCursor() {
		return create(SQLEntityDescriptorEnum.DeclareCursor);
	}

	public DeclareCursor createDeclareCursor(Name name,
			SQLStatement sqlStatement) {
		return create(SQLEntityDescriptorEnum.DeclareCursor, name, sqlStatement);
	}

	public IEntityBuilder<DeclareCursor> buildDeclareCursor() {
		return new EntityBuilder<DeclareCursor>(
				create(SQLEntityDescriptorEnum.DeclareCursor));
	}

	public SimpleVariableDeclaration createSimpleVariableDeclaration() {
		return create(SQLEntityDescriptorEnum.SimpleVariableDeclaration);
	}

	public SimpleVariableDeclaration createSimpleVariableDeclaration(Name name,
			Type type) {
		return create(SQLEntityDescriptorEnum.SimpleVariableDeclaration, name,
				type);
	}

	public IEntityBuilder<SimpleVariableDeclaration> buildSimpleVariableDeclaration() {
		return new EntityBuilder<SimpleVariableDeclaration>(
				create(SQLEntityDescriptorEnum.SimpleVariableDeclaration));
	}

	public VariableDeclaration createVariableDeclaration() {
		return create(SQLEntityDescriptorEnum.VariableDeclaration);
	}

	public VariableDeclaration createVariableDeclaration(Name name,
			Reference reference, ReferenceType referenceType) {
		return create(SQLEntityDescriptorEnum.VariableDeclaration, name,
				reference, referenceType);
	}

	public IEntityBuilder<VariableDeclaration> buildVariableDeclaration() {
		return new EntityBuilder<VariableDeclaration>(
				create(SQLEntityDescriptorEnum.VariableDeclaration));
	}

	public Reference createReference() {
		return create(SQLEntityDescriptorEnum.Reference);
	}

	public Reference createReference(String value) {
		return create(SQLEntityDescriptorEnum.Reference, value);
	}

	public ReferenceType createReferenceType() {
		return create(SQLEntityDescriptorEnum.ReferenceType);
	}

	public ReferenceType createReferenceType(ReferenceTypeEnum.Value value) {
		return create(SQLEntityDescriptorEnum.ReferenceType, value);
	}

	public ArrayExpr createArrayExpr() {
		return create(SQLEntityDescriptorEnum.ArrayExpr);
	}

	public ArrayExpr createArrayExpr(String value) {
		return create(SQLEntityDescriptorEnum.ArrayExpr, value);
	}

	public Name createName() {
		return create(SQLEntityDescriptorEnum.Name);
	}

	public Name createName(String value) {
		return create(SQLEntityDescriptorEnum.Name, value);
	}
}
