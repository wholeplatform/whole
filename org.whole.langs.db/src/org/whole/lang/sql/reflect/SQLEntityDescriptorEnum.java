package org.whole.lang.sql.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class SQLEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int SQLStatements_ord = 0;
	public static final int SelectSQLStatement_ord = 1;
	public static final int SQLStatement_ord = 2;
	public static final int SQLExpression_ord = 3;
	public static final int FromClause_ord = 4;
	public static final int Select_ord = 5;
	public static final int UnionSelect_ord = 6;
	public static final int Insert_ord = 7;
	public static final int InsertFromSelect_ord = 8;
	public static final int Update_ord = 9;
	public static final int Create_ord = 10;
	public static final int Delete_ord = 11;
	public static final int Drop_ord = 12;
	public static final int Truncate_ord = 13;
	public static final int AlterTable_ord = 14;
	public static final int CreateIndex_ord = 15;
	public static final int UniqueIndex_ord = 16;
	public static final int IndexDeclarations_ord = 17;
	public static final int IndexDeclaration_ord = 18;
	public static final int NullOrderType_ord = 19;
	public static final int DropIndex_ord = 20;
	public static final int Foreach_ord = 21;
	public static final int AlterAction_ord = 22;
	public static final int AddAction_ord = 23;
	public static final int SelectType_ord = 24;
	public static final int ColumnNames_ord = 25;
	public static final int ColumnExpressions_ord = 26;
	public static final int ColumnExpression_ord = 27;
	public static final int Alias_ord = 28;
	public static final int FromClauses_ord = 29;
	public static final int SimpleFromClause_ord = 30;
	public static final int InnerJoinFromClause_ord = 31;
	public static final int LeftOuterJoinFromClause_ord = 32;
	public static final int RightOuterJoinFromClause_ord = 33;
	public static final int Between_ord = 34;
	public static final int NotBetween_ord = 35;
	public static final int Is_ord = 36;
	public static final int IsType_ord = 37;
	public static final int Values_ord = 38;
	public static final int ParenthesizedExpression_ord = 39;
	public static final int SQLExpressions_ord = 40;
	public static final int NullValue_ord = 41;
	public static final int ArrayValue_ord = 42;
	public static final int BooleanValue_ord = 43;
	public static final int TinyIntValue_ord = 44;
	public static final int SmallIntValue_ord = 45;
	public static final int IntValue_ord = 46;
	public static final int BigIntValue_ord = 47;
	public static final int DoubleValue_ord = 48;
	public static final int RealValue_ord = 49;
	public static final int DecimalValue_ord = 50;
	public static final int StringValue_ord = 51;
	public static final int BinaryValue_ord = 52;
	public static final int DateValue_ord = 53;
	public static final int TimeValue_ord = 54;
	public static final int TimestampValue_ord = 55;
	public static final int BlobValue_ord = 56;
	public static final int ClobValue_ord = 57;
	public static final int RawValue_ord = 58;
	public static final int TableName_ord = 59;
	public static final int ColumnName_ord = 60;
	public static final int IndexName_ord = 61;
	public static final int CaseExpression_ord = 62;
	public static final int WhenClauses_ord = 63;
	public static final int WhenClause_ord = 64;
	public static final int In_ord = 65;
	public static final int NotIn_ord = 66;
	public static final int InPredicate_ord = 67;
	public static final int Subquery_ord = 68;
	public static final int InValueList_ord = 69;
	public static final int BinaryExpression_ord = 70;
	public static final int BinaryOperator_ord = 71;
	public static final int BooleanExpression_ord = 72;
	public static final int BooleanBinaryExpression_ord = 73;
	public static final int BooleanOperator_ord = 74;
	public static final int FunctionExpression_ord = 75;
	public static final int FunctionName_ord = 76;
	public static final int OrderByColumnExpressions_ord = 77;
	public static final int OrderByColumnExpression_ord = 78;
	public static final int OrderType_ord = 79;
	public static final int SetClauses_ord = 80;
	public static final int SetClause_ord = 81;
	public static final int DeclarationOrConstraints_ord = 82;
	public static final int DeclarationOrConstraint_ord = 83;
	public static final int ColumnDeclaration_ord = 84;
	public static final int ColumnType_ord = 85;
	public static final int Type_ord = 86;
	public static final int ColumnConstraints_ord = 87;
	public static final int ColumnConstraint_ord = 88;
	public static final int SimpleColumnConstraint_ord = 89;
	public static final int ForeignKeyColumnConstraint_ord = 90;
	public static final int TableConstraint_ord = 91;
	public static final int UniqueTableConstraint_ord = 92;
	public static final int PrimaryKeyTableConstraint_ord = 93;
	public static final int ForeignKeyTableConstraint_ord = 94;
	public static final int Match_ord = 95;
	public static final int Action_ord = 96;
	public static final int Deferrable_ord = 97;
	public static final int DeferCheck_ord = 98;
	public static final int StoredProcedures_ord = 99;
	public static final int StoredProcedure_ord = 100;
	public static final int ProcedureDeclaration_ord = 101;
	public static final int ProcedureDeclarations_ord = 102;
	public static final int ProcedureStatements_ord = 103;
	public static final int DeclareCursor_ord = 104;
	public static final int SimpleVariableDeclaration_ord = 105;
	public static final int VariableDeclaration_ord = 106;
	public static final int Reference_ord = 107;
	public static final int ReferenceType_ord = 108;
	public static final int ArrayExpr_ord = 109;
	public static final int Name_ord = 110;
	public static final SQLEntityDescriptorEnum instance = new SQLEntityDescriptorEnum();
	public static final EntityDescriptor<SQLStatements> SQLStatements = (EntityDescriptor<SQLStatements>) instance
			.valueOf(SQLStatements_ord);
	public static final EntityDescriptor<SelectSQLStatement> SelectSQLStatement = (EntityDescriptor<SelectSQLStatement>) instance
			.valueOf(SelectSQLStatement_ord);
	public static final EntityDescriptor<SQLStatement> SQLStatement = (EntityDescriptor<SQLStatement>) instance
			.valueOf(SQLStatement_ord);
	public static final EntityDescriptor<SQLExpression> SQLExpression = (EntityDescriptor<SQLExpression>) instance
			.valueOf(SQLExpression_ord);
	public static final EntityDescriptor<FromClause> FromClause = (EntityDescriptor<FromClause>) instance
			.valueOf(FromClause_ord);
	public static final EntityDescriptor<Select> Select = (EntityDescriptor<Select>) instance
			.valueOf(Select_ord);
	public static final EntityDescriptor<UnionSelect> UnionSelect = (EntityDescriptor<UnionSelect>) instance
			.valueOf(UnionSelect_ord);
	public static final EntityDescriptor<Insert> Insert = (EntityDescriptor<Insert>) instance
			.valueOf(Insert_ord);
	public static final EntityDescriptor<InsertFromSelect> InsertFromSelect = (EntityDescriptor<InsertFromSelect>) instance
			.valueOf(InsertFromSelect_ord);
	public static final EntityDescriptor<Update> Update = (EntityDescriptor<Update>) instance
			.valueOf(Update_ord);
	public static final EntityDescriptor<Create> Create = (EntityDescriptor<Create>) instance
			.valueOf(Create_ord);
	public static final EntityDescriptor<Delete> Delete = (EntityDescriptor<Delete>) instance
			.valueOf(Delete_ord);
	public static final EntityDescriptor<Drop> Drop = (EntityDescriptor<Drop>) instance
			.valueOf(Drop_ord);
	public static final EntityDescriptor<Truncate> Truncate = (EntityDescriptor<Truncate>) instance
			.valueOf(Truncate_ord);
	public static final EntityDescriptor<AlterTable> AlterTable = (EntityDescriptor<AlterTable>) instance
			.valueOf(AlterTable_ord);
	public static final EntityDescriptor<CreateIndex> CreateIndex = (EntityDescriptor<CreateIndex>) instance
			.valueOf(CreateIndex_ord);
	public static final EntityDescriptor<UniqueIndex> UniqueIndex = (EntityDescriptor<UniqueIndex>) instance
			.valueOf(UniqueIndex_ord);
	public static final EntityDescriptor<IndexDeclarations> IndexDeclarations = (EntityDescriptor<IndexDeclarations>) instance
			.valueOf(IndexDeclarations_ord);
	public static final EntityDescriptor<IndexDeclaration> IndexDeclaration = (EntityDescriptor<IndexDeclaration>) instance
			.valueOf(IndexDeclaration_ord);
	public static final EntityDescriptor<NullOrderType> NullOrderType = (EntityDescriptor<NullOrderType>) instance
			.valueOf(NullOrderType_ord);
	public static final EntityDescriptor<DropIndex> DropIndex = (EntityDescriptor<DropIndex>) instance
			.valueOf(DropIndex_ord);
	public static final EntityDescriptor<Foreach> Foreach = (EntityDescriptor<Foreach>) instance
			.valueOf(Foreach_ord);
	public static final EntityDescriptor<AlterAction> AlterAction = (EntityDescriptor<AlterAction>) instance
			.valueOf(AlterAction_ord);
	public static final EntityDescriptor<AddAction> AddAction = (EntityDescriptor<AddAction>) instance
			.valueOf(AddAction_ord);
	public static final EntityDescriptor<SelectType> SelectType = (EntityDescriptor<SelectType>) instance
			.valueOf(SelectType_ord);
	public static final EntityDescriptor<ColumnNames> ColumnNames = (EntityDescriptor<ColumnNames>) instance
			.valueOf(ColumnNames_ord);
	public static final EntityDescriptor<ColumnExpressions> ColumnExpressions = (EntityDescriptor<ColumnExpressions>) instance
			.valueOf(ColumnExpressions_ord);
	public static final EntityDescriptor<ColumnExpression> ColumnExpression = (EntityDescriptor<ColumnExpression>) instance
			.valueOf(ColumnExpression_ord);
	public static final EntityDescriptor<Alias> Alias = (EntityDescriptor<Alias>) instance
			.valueOf(Alias_ord);
	public static final EntityDescriptor<FromClauses> FromClauses = (EntityDescriptor<FromClauses>) instance
			.valueOf(FromClauses_ord);
	public static final EntityDescriptor<SimpleFromClause> SimpleFromClause = (EntityDescriptor<SimpleFromClause>) instance
			.valueOf(SimpleFromClause_ord);
	public static final EntityDescriptor<InnerJoinFromClause> InnerJoinFromClause = (EntityDescriptor<InnerJoinFromClause>) instance
			.valueOf(InnerJoinFromClause_ord);
	public static final EntityDescriptor<LeftOuterJoinFromClause> LeftOuterJoinFromClause = (EntityDescriptor<LeftOuterJoinFromClause>) instance
			.valueOf(LeftOuterJoinFromClause_ord);
	public static final EntityDescriptor<RightOuterJoinFromClause> RightOuterJoinFromClause = (EntityDescriptor<RightOuterJoinFromClause>) instance
			.valueOf(RightOuterJoinFromClause_ord);
	public static final EntityDescriptor<Between> Between = (EntityDescriptor<Between>) instance
			.valueOf(Between_ord);
	public static final EntityDescriptor<NotBetween> NotBetween = (EntityDescriptor<NotBetween>) instance
			.valueOf(NotBetween_ord);
	public static final EntityDescriptor<Is> Is = (EntityDescriptor<Is>) instance
			.valueOf(Is_ord);
	public static final EntityDescriptor<IsType> IsType = (EntityDescriptor<IsType>) instance
			.valueOf(IsType_ord);
	public static final EntityDescriptor<Values> Values = (EntityDescriptor<Values>) instance
			.valueOf(Values_ord);
	public static final EntityDescriptor<ParenthesizedExpression> ParenthesizedExpression = (EntityDescriptor<ParenthesizedExpression>) instance
			.valueOf(ParenthesizedExpression_ord);
	public static final EntityDescriptor<SQLExpressions> SQLExpressions = (EntityDescriptor<SQLExpressions>) instance
			.valueOf(SQLExpressions_ord);
	public static final EntityDescriptor<NullValue> NullValue = (EntityDescriptor<NullValue>) instance
			.valueOf(NullValue_ord);
	public static final EntityDescriptor<ArrayValue> ArrayValue = (EntityDescriptor<ArrayValue>) instance
			.valueOf(ArrayValue_ord);
	public static final EntityDescriptor<BooleanValue> BooleanValue = (EntityDescriptor<BooleanValue>) instance
			.valueOf(BooleanValue_ord);
	public static final EntityDescriptor<TinyIntValue> TinyIntValue = (EntityDescriptor<TinyIntValue>) instance
			.valueOf(TinyIntValue_ord);
	public static final EntityDescriptor<SmallIntValue> SmallIntValue = (EntityDescriptor<SmallIntValue>) instance
			.valueOf(SmallIntValue_ord);
	public static final EntityDescriptor<IntValue> IntValue = (EntityDescriptor<IntValue>) instance
			.valueOf(IntValue_ord);
	public static final EntityDescriptor<BigIntValue> BigIntValue = (EntityDescriptor<BigIntValue>) instance
			.valueOf(BigIntValue_ord);
	public static final EntityDescriptor<DoubleValue> DoubleValue = (EntityDescriptor<DoubleValue>) instance
			.valueOf(DoubleValue_ord);
	public static final EntityDescriptor<RealValue> RealValue = (EntityDescriptor<RealValue>) instance
			.valueOf(RealValue_ord);
	public static final EntityDescriptor<DecimalValue> DecimalValue = (EntityDescriptor<DecimalValue>) instance
			.valueOf(DecimalValue_ord);
	public static final EntityDescriptor<StringValue> StringValue = (EntityDescriptor<StringValue>) instance
			.valueOf(StringValue_ord);
	public static final EntityDescriptor<BinaryValue> BinaryValue = (EntityDescriptor<BinaryValue>) instance
			.valueOf(BinaryValue_ord);
	public static final EntityDescriptor<DateValue> DateValue = (EntityDescriptor<DateValue>) instance
			.valueOf(DateValue_ord);
	public static final EntityDescriptor<TimeValue> TimeValue = (EntityDescriptor<TimeValue>) instance
			.valueOf(TimeValue_ord);
	public static final EntityDescriptor<TimestampValue> TimestampValue = (EntityDescriptor<TimestampValue>) instance
			.valueOf(TimestampValue_ord);
	public static final EntityDescriptor<BlobValue> BlobValue = (EntityDescriptor<BlobValue>) instance
			.valueOf(BlobValue_ord);
	public static final EntityDescriptor<ClobValue> ClobValue = (EntityDescriptor<ClobValue>) instance
			.valueOf(ClobValue_ord);
	public static final EntityDescriptor<RawValue> RawValue = (EntityDescriptor<RawValue>) instance
			.valueOf(RawValue_ord);
	public static final EntityDescriptor<TableName> TableName = (EntityDescriptor<TableName>) instance
			.valueOf(TableName_ord);
	public static final EntityDescriptor<ColumnName> ColumnName = (EntityDescriptor<ColumnName>) instance
			.valueOf(ColumnName_ord);
	public static final EntityDescriptor<IndexName> IndexName = (EntityDescriptor<IndexName>) instance
			.valueOf(IndexName_ord);
	public static final EntityDescriptor<CaseExpression> CaseExpression = (EntityDescriptor<CaseExpression>) instance
			.valueOf(CaseExpression_ord);
	public static final EntityDescriptor<WhenClauses> WhenClauses = (EntityDescriptor<WhenClauses>) instance
			.valueOf(WhenClauses_ord);
	public static final EntityDescriptor<WhenClause> WhenClause = (EntityDescriptor<WhenClause>) instance
			.valueOf(WhenClause_ord);
	public static final EntityDescriptor<In> In = (EntityDescriptor<In>) instance
			.valueOf(In_ord);
	public static final EntityDescriptor<NotIn> NotIn = (EntityDescriptor<NotIn>) instance
			.valueOf(NotIn_ord);
	public static final EntityDescriptor<InPredicate> InPredicate = (EntityDescriptor<InPredicate>) instance
			.valueOf(InPredicate_ord);
	public static final EntityDescriptor<Subquery> Subquery = (EntityDescriptor<Subquery>) instance
			.valueOf(Subquery_ord);
	public static final EntityDescriptor<InValueList> InValueList = (EntityDescriptor<InValueList>) instance
			.valueOf(InValueList_ord);
	public static final EntityDescriptor<BinaryExpression> BinaryExpression = (EntityDescriptor<BinaryExpression>) instance
			.valueOf(BinaryExpression_ord);
	public static final EntityDescriptor<BinaryOperator> BinaryOperator = (EntityDescriptor<BinaryOperator>) instance
			.valueOf(BinaryOperator_ord);
	public static final EntityDescriptor<BooleanExpression> BooleanExpression = (EntityDescriptor<BooleanExpression>) instance
			.valueOf(BooleanExpression_ord);
	public static final EntityDescriptor<BooleanBinaryExpression> BooleanBinaryExpression = (EntityDescriptor<BooleanBinaryExpression>) instance
			.valueOf(BooleanBinaryExpression_ord);
	public static final EntityDescriptor<BooleanOperator> BooleanOperator = (EntityDescriptor<BooleanOperator>) instance
			.valueOf(BooleanOperator_ord);
	public static final EntityDescriptor<FunctionExpression> FunctionExpression = (EntityDescriptor<FunctionExpression>) instance
			.valueOf(FunctionExpression_ord);
	public static final EntityDescriptor<FunctionName> FunctionName = (EntityDescriptor<FunctionName>) instance
			.valueOf(FunctionName_ord);
	public static final EntityDescriptor<OrderByColumnExpressions> OrderByColumnExpressions = (EntityDescriptor<OrderByColumnExpressions>) instance
			.valueOf(OrderByColumnExpressions_ord);
	public static final EntityDescriptor<OrderByColumnExpression> OrderByColumnExpression = (EntityDescriptor<OrderByColumnExpression>) instance
			.valueOf(OrderByColumnExpression_ord);
	public static final EntityDescriptor<OrderType> OrderType = (EntityDescriptor<OrderType>) instance
			.valueOf(OrderType_ord);
	public static final EntityDescriptor<SetClauses> SetClauses = (EntityDescriptor<SetClauses>) instance
			.valueOf(SetClauses_ord);
	public static final EntityDescriptor<SetClause> SetClause = (EntityDescriptor<SetClause>) instance
			.valueOf(SetClause_ord);
	public static final EntityDescriptor<DeclarationOrConstraints> DeclarationOrConstraints = (EntityDescriptor<DeclarationOrConstraints>) instance
			.valueOf(DeclarationOrConstraints_ord);
	public static final EntityDescriptor<DeclarationOrConstraint> DeclarationOrConstraint = (EntityDescriptor<DeclarationOrConstraint>) instance
			.valueOf(DeclarationOrConstraint_ord);
	public static final EntityDescriptor<ColumnDeclaration> ColumnDeclaration = (EntityDescriptor<ColumnDeclaration>) instance
			.valueOf(ColumnDeclaration_ord);
	public static final EntityDescriptor<ColumnType> ColumnType = (EntityDescriptor<ColumnType>) instance
			.valueOf(ColumnType_ord);
	public static final EntityDescriptor<Type> Type = (EntityDescriptor<Type>) instance
			.valueOf(Type_ord);
	public static final EntityDescriptor<ColumnConstraints> ColumnConstraints = (EntityDescriptor<ColumnConstraints>) instance
			.valueOf(ColumnConstraints_ord);
	public static final EntityDescriptor<ColumnConstraint> ColumnConstraint = (EntityDescriptor<ColumnConstraint>) instance
			.valueOf(ColumnConstraint_ord);
	public static final EntityDescriptor<SimpleColumnConstraint> SimpleColumnConstraint = (EntityDescriptor<SimpleColumnConstraint>) instance
			.valueOf(SimpleColumnConstraint_ord);
	public static final EntityDescriptor<ForeignKeyColumnConstraint> ForeignKeyColumnConstraint = (EntityDescriptor<ForeignKeyColumnConstraint>) instance
			.valueOf(ForeignKeyColumnConstraint_ord);
	public static final EntityDescriptor<TableConstraint> TableConstraint = (EntityDescriptor<TableConstraint>) instance
			.valueOf(TableConstraint_ord);
	public static final EntityDescriptor<UniqueTableConstraint> UniqueTableConstraint = (EntityDescriptor<UniqueTableConstraint>) instance
			.valueOf(UniqueTableConstraint_ord);
	public static final EntityDescriptor<PrimaryKeyTableConstraint> PrimaryKeyTableConstraint = (EntityDescriptor<PrimaryKeyTableConstraint>) instance
			.valueOf(PrimaryKeyTableConstraint_ord);
	public static final EntityDescriptor<ForeignKeyTableConstraint> ForeignKeyTableConstraint = (EntityDescriptor<ForeignKeyTableConstraint>) instance
			.valueOf(ForeignKeyTableConstraint_ord);
	public static final EntityDescriptor<Match> Match = (EntityDescriptor<Match>) instance
			.valueOf(Match_ord);
	public static final EntityDescriptor<Action> Action = (EntityDescriptor<Action>) instance
			.valueOf(Action_ord);
	public static final EntityDescriptor<Deferrable> Deferrable = (EntityDescriptor<Deferrable>) instance
			.valueOf(Deferrable_ord);
	public static final EntityDescriptor<DeferCheck> DeferCheck = (EntityDescriptor<DeferCheck>) instance
			.valueOf(DeferCheck_ord);
	public static final EntityDescriptor<StoredProcedures> StoredProcedures = (EntityDescriptor<StoredProcedures>) instance
			.valueOf(StoredProcedures_ord);
	public static final EntityDescriptor<StoredProcedure> StoredProcedure = (EntityDescriptor<StoredProcedure>) instance
			.valueOf(StoredProcedure_ord);
	public static final EntityDescriptor<ProcedureDeclaration> ProcedureDeclaration = (EntityDescriptor<ProcedureDeclaration>) instance
			.valueOf(ProcedureDeclaration_ord);
	public static final EntityDescriptor<ProcedureDeclarations> ProcedureDeclarations = (EntityDescriptor<ProcedureDeclarations>) instance
			.valueOf(ProcedureDeclarations_ord);
	public static final EntityDescriptor<ProcedureStatements> ProcedureStatements = (EntityDescriptor<ProcedureStatements>) instance
			.valueOf(ProcedureStatements_ord);
	public static final EntityDescriptor<DeclareCursor> DeclareCursor = (EntityDescriptor<DeclareCursor>) instance
			.valueOf(DeclareCursor_ord);
	public static final EntityDescriptor<SimpleVariableDeclaration> SimpleVariableDeclaration = (EntityDescriptor<SimpleVariableDeclaration>) instance
			.valueOf(SimpleVariableDeclaration_ord);
	public static final EntityDescriptor<VariableDeclaration> VariableDeclaration = (EntityDescriptor<VariableDeclaration>) instance
			.valueOf(VariableDeclaration_ord);
	public static final EntityDescriptor<Reference> Reference = (EntityDescriptor<Reference>) instance
			.valueOf(Reference_ord);
	public static final EntityDescriptor<ReferenceType> ReferenceType = (EntityDescriptor<ReferenceType>) instance
			.valueOf(ReferenceType_ord);
	public static final EntityDescriptor<ArrayExpr> ArrayExpr = (EntityDescriptor<ArrayExpr>) instance
			.valueOf(ArrayExpr_ord);
	public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance
			.valueOf(Name_ord);

	private SQLEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putCompositeEntity(
		SQLStatements_ord, "SQLStatements", SQLStatements.class, false, SQLStatement_ord, true, false);
		putSimpleEntity(SelectSQLStatement_ord, "SelectSQLStatement",
				SelectSQLStatement.class, true, Select_ord, UnionSelect_ord);
		putSimpleEntity(SQLStatement_ord, "SQLStatement", SQLStatement.class,
				true, Insert_ord, StoredProcedures_ord, Update_ord,
				Truncate_ord, InsertFromSelect_ord, SelectSQLStatement_ord,
				Select_ord, UnionSelect_ord, AlterTable_ord, Drop_ord,
				DropIndex_ord, CreateIndex_ord, Create_ord, Foreach_ord,
				Delete_ord);
		putSimpleEntity(SQLExpression_ord, "SQLExpression",
				SQLExpression.class, true, In_ord, DecimalValue_ord,
				IndexName_ord, Is_ord, BinaryValue_ord, BooleanValue_ord,
				TimestampValue_ord, DoubleValue_ord, BooleanExpression_ord,
				BlobValue_ord, CaseExpression_ord, NotBetween_ord,
				ColumnName_ord, TimeValue_ord, RawValue_ord, DateValue_ord,
				Between_ord, FunctionExpression_ord, TinyIntValue_ord,
				ClobValue_ord, BinaryExpression_ord, RealValue_ord,
				IntValue_ord, NullValue_ord, ParenthesizedExpression_ord,
				BooleanBinaryExpression_ord, InValueList_ord, BigIntValue_ord,
				InPredicate_ord, Subquery_ord, StringValue_ord,
				WhenClauses_ord, ArrayValue_ord, SmallIntValue_ord,
				TableName_ord, NotIn_ord);
		putSimpleEntity(FromClause_ord, "FromClause", FromClause.class, true,
				RightOuterJoinFromClause_ord, SimpleFromClause_ord,
				LeftOuterJoinFromClause_ord, InnerJoinFromClause_ord);
		putSimpleEntity(Select_ord, "Select", Select.class, false)
				.withFeature(SQLFeatureDescriptorEnum.selectType,
						SelectType_ord, true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.columnExprs,
						ColumnExpressions_ord)
				.withFeature(SQLFeatureDescriptorEnum.fromClauses,
						FromClauses_ord, true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.whereExpr,
						SQLExpression_ord, true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.groupByExprs,
						SQLExpressions_ord, true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.havingExpr,
						SQLExpression_ord, true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.orderByColumnExprs,
						OrderByColumnExpressions_ord, true, false, false,
						false, false);
		putSimpleEntity(UnionSelect_ord, "UnionSelect", UnionSelect.class,
				false).withFeature(SQLFeatureDescriptorEnum.simpleSelect,
				Select_ord).withFeature(
				SQLFeatureDescriptorEnum.unionSelectStatement,
				SelectSQLStatement_ord);
		putSimpleEntity(Insert_ord, "Insert", Insert.class, false)
				.withFeature(SQLFeatureDescriptorEnum.tableName, TableName_ord)
				.withFeature(SQLFeatureDescriptorEnum.columnNames,
						ColumnNames_ord, true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.values, Values_ord);
		putSimpleEntity(InsertFromSelect_ord, "InsertFromSelect",
				InsertFromSelect.class, false)
				.withFeature(SQLFeatureDescriptorEnum.tableName, TableName_ord)
				.withFeature(SQLFeatureDescriptorEnum.columnNames,
						ColumnNames_ord, true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.select,
						SelectSQLStatement_ord);
		putSimpleEntity(Update_ord, "Update", Update.class, false)
				.withFeature(SQLFeatureDescriptorEnum.tableName, TableName_ord)
				.withFeature(SQLFeatureDescriptorEnum.setClauses,
						SetClauses_ord)
				.withFeature(SQLFeatureDescriptorEnum.fromClauses,
						FromClauses_ord, true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.whereExpr,
						SQLExpression_ord, true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.limit, IntValue_ord,
						true, false, false, false, false);
		putSimpleEntity(Create_ord, "Create", Create.class, false).withFeature(
				SQLFeatureDescriptorEnum.tableName, TableName_ord).withFeature(
				SQLFeatureDescriptorEnum.declarationOrConstraints,
				DeclarationOrConstraints_ord);
		putSimpleEntity(Delete_ord, "Delete", Delete.class, false)
				.withFeature(SQLFeatureDescriptorEnum.tableName, TableName_ord)
				.withFeature(SQLFeatureDescriptorEnum.whereExpr,
						SQLExpression_ord, true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.limit, IntValue_ord,
						true, false, false, false, false);
		putSimpleEntity(Drop_ord, "Drop", Drop.class, false).withFeature(
				SQLFeatureDescriptorEnum.tableName, TableName_ord);
		putSimpleEntity(Truncate_ord, "Truncate", Truncate.class, false)
				.withFeature(SQLFeatureDescriptorEnum.tableName, TableName_ord);
		putSimpleEntity(AlterTable_ord, "AlterTable", AlterTable.class, false)
				.withFeature(SQLFeatureDescriptorEnum.tableName, TableName_ord)
				.withFeature(SQLFeatureDescriptorEnum.action, AlterAction_ord);
		putSimpleEntity(CreateIndex_ord, "CreateIndex", CreateIndex.class,
				false)
				.withFeature(SQLFeatureDescriptorEnum.unique, UniqueIndex_ord,
						true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.indexName, IndexName_ord)
				.withFeature(SQLFeatureDescriptorEnum.tableName, TableName_ord)
				.withFeature(SQLFeatureDescriptorEnum.indexDeclarations,
						IndexDeclarations_ord);
		putSimpleEntity(UniqueIndex_ord, "UniqueIndex", UniqueIndex.class,
				false);
		putCompositeEntity(
		IndexDeclarations_ord, "IndexDeclarations", IndexDeclarations.class, false, IndexDeclaration_ord, false, true);
		putSimpleEntity(IndexDeclaration_ord, "IndexDeclaration",
				IndexDeclaration.class, false)
				.withFeature(SQLFeatureDescriptorEnum.columnName,
						ColumnName_ord)
				.withFeature(SQLFeatureDescriptorEnum.orderType, OrderType_ord,
						true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.nullOrderType,
						NullOrderType_ord, true, false, false, false, false);
		putDataEntity(NullOrderType_ord, "NullOrderType", NullOrderType.class,
				false, NullOrderTypeEnum.Value.class);
		putSimpleEntity(DropIndex_ord, "DropIndex", DropIndex.class, false)
				.withFeature(SQLFeatureDescriptorEnum.indexName, IndexName_ord);
		putSimpleEntity(Foreach_ord, "Foreach", Foreach.class, false)
				.withFeature(SQLFeatureDescriptorEnum.name, Name_ord)
				.withFeature(SQLFeatureDescriptorEnum.arrayExp, ArrayExpr_ord)
				.withFeature(SQLFeatureDescriptorEnum.trueBody,
						SQLStatement_ord);
		putSimpleEntity(AlterAction_ord, "AlterAction", AlterAction.class,
				true, AddAction_ord);
		putSimpleEntity(AddAction_ord, "AddAction", AddAction.class, false)
				.withFeature(SQLFeatureDescriptorEnum.declarationOrConstraint,
						DeclarationOrConstraint_ord);
		putDataEntity(SelectType_ord, "SelectType", SelectType.class, false,
				SelectTypeEnum.Value.class);
		putCompositeEntity(
		ColumnNames_ord, "ColumnNames", ColumnNames.class, false, ColumnName_ord, true, true);
		putCompositeEntity(
		ColumnExpressions_ord, "ColumnExpressions", ColumnExpressions.class, false, ColumnExpression_ord, true, true);
		putSimpleEntity(ColumnExpression_ord, "ColumnExpression",
				ColumnExpression.class, false).withFeature(
				SQLFeatureDescriptorEnum.expression, SQLExpression_ord)
				.withFeature(SQLFeatureDescriptorEnum.alias, Alias_ord, true,
						false, false, false, false);
		putDataEntity(Alias_ord, "Alias", Alias.class, false, String.class);
		putCompositeEntity(
		FromClauses_ord, "FromClauses", FromClauses.class, false, FromClause_ord, true, true);
		putDataEntity(SimpleFromClause_ord, "SimpleFromClause",
				SimpleFromClause.class, false, String.class);
		putSimpleEntity(InnerJoinFromClause_ord, "InnerJoinFromClause",
				InnerJoinFromClause.class, false)
				.withFeature(SQLFeatureDescriptorEnum.tableName, TableName_ord)
				.withFeature(SQLFeatureDescriptorEnum.innerTable, TableName_ord)
				.withFeature(SQLFeatureDescriptorEnum.onExpression,
						SQLExpression_ord);
		putSimpleEntity(LeftOuterJoinFromClause_ord, "LeftOuterJoinFromClause",
				LeftOuterJoinFromClause.class, false)
				.withFeature(SQLFeatureDescriptorEnum.tableName, TableName_ord)
				.withFeature(SQLFeatureDescriptorEnum.outerTable, TableName_ord)
				.withFeature(SQLFeatureDescriptorEnum.onExpression,
						SQLExpression_ord);
		putSimpleEntity(RightOuterJoinFromClause_ord,
				"RightOuterJoinFromClause", RightOuterJoinFromClause.class,
				false)
				.withFeature(SQLFeatureDescriptorEnum.tableName, TableName_ord)
				.withFeature(SQLFeatureDescriptorEnum.outerTable, TableName_ord)
				.withFeature(SQLFeatureDescriptorEnum.onExpression,
						SQLExpression_ord);
		putSimpleEntity(Between_ord, "Between", Between.class, false)
				.withFeature(SQLFeatureDescriptorEnum.expression,
						SQLExpression_ord)
				.withFeature(SQLFeatureDescriptorEnum.lowerExpression,
						SQLExpression_ord)
				.withFeature(SQLFeatureDescriptorEnum.upperExpression,
						SQLExpression_ord);
		putSimpleEntity(NotBetween_ord, "NotBetween", NotBetween.class, false)
				.withFeature(SQLFeatureDescriptorEnum.expression,
						SQLExpression_ord)
				.withFeature(SQLFeatureDescriptorEnum.lowerExpression,
						SQLExpression_ord)
				.withFeature(SQLFeatureDescriptorEnum.upperExpression,
						SQLExpression_ord);
		putSimpleEntity(Is_ord, "Is", Is.class, false).withFeature(
				SQLFeatureDescriptorEnum.expression, SQLExpression_ord)
				.withFeature(SQLFeatureDescriptorEnum.type, IsType_ord);
		putDataEntity(IsType_ord, "IsType", IsType.class, false,
				IsTypeEnum.Value.class);
		putCompositeEntity(
		Values_ord, "Values", Values.class, false, SQLExpressions_ord, true, false);
		putSimpleEntity(ParenthesizedExpression_ord, "ParenthesizedExpression",
				ParenthesizedExpression.class, false).withFeature(
				SQLFeatureDescriptorEnum.expression, SQLExpression_ord);
		putCompositeEntity(
		SQLExpressions_ord, "SQLExpressions", SQLExpressions.class, false, SQLExpression_ord, true, false);
		putSimpleEntity(NullValue_ord, "NullValue", NullValue.class, false);
		putDataEntity(ArrayValue_ord, "ArrayValue", ArrayValue.class, false,
				Object.class);
		putDataEntity(BooleanValue_ord, "BooleanValue", BooleanValue.class,
				false, boolean.class);
		putDataEntity(TinyIntValue_ord, "TinyIntValue", TinyIntValue.class,
				false, byte.class);
		putDataEntity(SmallIntValue_ord, "SmallIntValue", SmallIntValue.class,
				false, short.class);
		putDataEntity(IntValue_ord, "IntValue", IntValue.class, false,
				int.class);
		putDataEntity(BigIntValue_ord, "BigIntValue", BigIntValue.class, false,
				long.class);
		putDataEntity(DoubleValue_ord, "DoubleValue", DoubleValue.class, false,
				double.class);
		putDataEntity(RealValue_ord, "RealValue", RealValue.class, false,
				float.class);
		putDataEntity(DecimalValue_ord, "DecimalValue", DecimalValue.class,
				false, java.math.BigDecimal.class);
		putDataEntity(StringValue_ord, "StringValue", StringValue.class, false,
				String.class);
		putDataEntity(BinaryValue_ord, "BinaryValue", BinaryValue.class, false,
				Object.class);
		putDataEntity(DateValue_ord, "DateValue", DateValue.class, false,
				java.sql.Date.class);
		putDataEntity(TimeValue_ord, "TimeValue", TimeValue.class, false,
				java.sql.Time.class);
		putDataEntity(TimestampValue_ord, "TimestampValue",
				TimestampValue.class, false, java.sql.Timestamp.class);
		putDataEntity(BlobValue_ord, "BlobValue", BlobValue.class, false,
				java.sql.Blob.class);
		putDataEntity(ClobValue_ord, "ClobValue", ClobValue.class, false,
				java.sql.Clob.class);
		putDataEntity(RawValue_ord, "RawValue", RawValue.class, false,
				Object.class);
		putDataEntity(TableName_ord, "TableName", TableName.class, false,
				String.class);
		putDataEntity(ColumnName_ord, "ColumnName", ColumnName.class, false,
				String.class);
		putDataEntity(IndexName_ord, "IndexName", IndexName.class, false,
				String.class);
		putSimpleEntity(CaseExpression_ord, "CaseExpression",
				CaseExpression.class, false).withFeature(
				SQLFeatureDescriptorEnum.whenClauses, WhenClauses_ord)
				.withFeature(SQLFeatureDescriptorEnum.elseClause,
						SQLExpression_ord, true, false, false, false, false);
		putCompositeEntity(
		WhenClauses_ord, "WhenClauses", WhenClauses.class, false, WhenClause_ord, true, false);
		putSimpleEntity(WhenClause_ord, "WhenClause", WhenClause.class, false)
				.withFeature(SQLFeatureDescriptorEnum.condition,
						BooleanExpression_ord).withFeature(
						SQLFeatureDescriptorEnum.result, SQLExpression_ord);
		putSimpleEntity(In_ord, "In", In.class, false).withFeature(
				SQLFeatureDescriptorEnum.leftExpr, SQLExpression_ord)
				.withFeature(SQLFeatureDescriptorEnum.inPredicate,
						InPredicate_ord);
		putSimpleEntity(NotIn_ord, "NotIn", NotIn.class, false).withFeature(
				SQLFeatureDescriptorEnum.leftExpr, SQLExpression_ord)
				.withFeature(SQLFeatureDescriptorEnum.inPredicate,
						InPredicate_ord);
		putSimpleEntity(InPredicate_ord, "InPredicate", InPredicate.class,
				true, InValueList_ord, Subquery_ord, WhenClauses_ord);
		putSimpleEntity(Subquery_ord, "Subquery", Subquery.class, false)
				.withFeature(SQLFeatureDescriptorEnum.query,
						SelectSQLStatement_ord);
		putCompositeEntity(
		InValueList_ord, "InValueList", InValueList.class, false, SQLExpression_ord, true, false);
		putSimpleEntity(BinaryExpression_ord, "BinaryExpression",
				BinaryExpression.class, false)
				.withFeature(SQLFeatureDescriptorEnum.leftExpr,
						SQLExpression_ord)
				.withFeature(SQLFeatureDescriptorEnum.operator,
						BinaryOperator_ord)
				.withFeature(SQLFeatureDescriptorEnum.rightExpr,
						SQLExpression_ord);
		putDataEntity(BinaryOperator_ord, "BinaryOperator",
				BinaryOperator.class, false, BinaryOperatorEnum.Value.class);
		putSimpleEntity(BooleanExpression_ord, "BooleanExpression",
				BooleanExpression.class, true, In_ord, BooleanValue_ord,
				BooleanBinaryExpression_ord, NotBetween_ord, NotIn_ord, Is_ord,
				Between_ord);
		putSimpleEntity(BooleanBinaryExpression_ord, "BooleanBinaryExpression",
				BooleanBinaryExpression.class, false)
				.withFeature(SQLFeatureDescriptorEnum.leftExpr,
						SQLExpression_ord)
				.withFeature(SQLFeatureDescriptorEnum.operator,
						BooleanOperator_ord)
				.withFeature(SQLFeatureDescriptorEnum.rightExpr,
						SQLExpression_ord);
		putDataEntity(BooleanOperator_ord, "BooleanOperator",
				BooleanOperator.class, false, BooleanOperatorEnum.Value.class);
		putSimpleEntity(FunctionExpression_ord, "FunctionExpression",
				FunctionExpression.class, false).withFeature(
				SQLFeatureDescriptorEnum.functionName, FunctionName_ord)
				.withFeature(SQLFeatureDescriptorEnum.params,
						SQLExpressions_ord);
		putDataEntity(FunctionName_ord, "FunctionName", FunctionName.class,
				false, String.class);
		putCompositeEntity(
		OrderByColumnExpressions_ord, "OrderByColumnExpressions", OrderByColumnExpressions.class, false, OrderByColumnExpression_ord, true, false);
		putSimpleEntity(OrderByColumnExpression_ord, "OrderByColumnExpression",
				OrderByColumnExpression.class, false).withFeature(
				SQLFeatureDescriptorEnum.expression, SQLExpression_ord)
				.withFeature(SQLFeatureDescriptorEnum.orderType, OrderType_ord,
						true, false, false, false, false);
		putDataEntity(OrderType_ord, "OrderType", OrderType.class, false,
				OrderTypeEnum.Value.class);
		putCompositeEntity(
		SetClauses_ord, "SetClauses", SetClauses.class, false, SetClause_ord, false, true);
		putSimpleEntity(SetClause_ord, "SetClause", SetClause.class, false)
				.withFeature(SQLFeatureDescriptorEnum.columnName,
						ColumnName_ord, false, true, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.expression,
						SQLExpression_ord);
		putCompositeEntity(
		DeclarationOrConstraints_ord, "DeclarationOrConstraints", DeclarationOrConstraints.class, false, DeclarationOrConstraint_ord, false, true);
		putSimpleEntity(DeclarationOrConstraint_ord, "DeclarationOrConstraint",
				DeclarationOrConstraint.class, true, UniqueTableConstraint_ord,
				ForeignKeyTableConstraint_ord, PrimaryKeyTableConstraint_ord,
				TableConstraint_ord, ColumnDeclaration_ord);
		putSimpleEntity(ColumnDeclaration_ord, "ColumnDeclaration",
				ColumnDeclaration.class, false)
				.withFeature(SQLFeatureDescriptorEnum.columnName,
						ColumnName_ord)
				.withFeature(SQLFeatureDescriptorEnum.columnType,
						ColumnType_ord)
				.withFeature(SQLFeatureDescriptorEnum.columnConstraints,
						ColumnConstraints_ord, true, false, false, false, false);
		putSimpleEntity(ColumnType_ord, "ColumnType", ColumnType.class, false)
				.withFeature(SQLFeatureDescriptorEnum.type, Type_ord)
				.withFeature(SQLFeatureDescriptorEnum.size, IntValue_ord, true,
						false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.precision, IntValue_ord,
						true, false, false, false, false);
		putDataEntity(Type_ord, "Type", Type.class, false, String.class);
		putCompositeEntity(
		ColumnConstraints_ord, "ColumnConstraints", ColumnConstraints.class, false, ColumnConstraint_ord, false, true);
		putSimpleEntity(ColumnConstraint_ord, "ColumnConstraint",
				ColumnConstraint.class, true, ForeignKeyColumnConstraint_ord,
				SimpleColumnConstraint_ord);
		putDataEntity(SimpleColumnConstraint_ord, "SimpleColumnConstraint",
				SimpleColumnConstraint.class, false,
				SimpleColumnConstraintEnum.Value.class);
		putSimpleEntity(ForeignKeyColumnConstraint_ord,
				"ForeignKeyColumnConstraint", ForeignKeyColumnConstraint.class,
				false).withFeature(SQLFeatureDescriptorEnum.foreignTableName,
				TableName_ord).withFeature(
				SQLFeatureDescriptorEnum.foreignColumnName, ColumnName_ord,
				true, false, false, false, false);
		putSimpleEntity(TableConstraint_ord, "TableConstraint",
				TableConstraint.class, true, UniqueTableConstraint_ord,
				ForeignKeyTableConstraint_ord, PrimaryKeyTableConstraint_ord);
		putSimpleEntity(UniqueTableConstraint_ord, "UniqueTableConstraint",
				UniqueTableConstraint.class, false).withFeature(
				SQLFeatureDescriptorEnum.columnNames, ColumnNames_ord);
		putSimpleEntity(PrimaryKeyTableConstraint_ord,
				"PrimaryKeyTableConstraint", PrimaryKeyTableConstraint.class,
				false).withFeature(SQLFeatureDescriptorEnum.columnNames,
				ColumnNames_ord);
		putSimpleEntity(ForeignKeyTableConstraint_ord,
				"ForeignKeyTableConstraint", ForeignKeyTableConstraint.class,
				false)
				.withFeature(SQLFeatureDescriptorEnum.columnNames,
						ColumnNames_ord)
				.withFeature(SQLFeatureDescriptorEnum.foreignTableName,
						TableName_ord)
				.withFeature(SQLFeatureDescriptorEnum.foreignColumnNames,
						ColumnNames_ord, true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.match, Match_ord, true,
						false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.onDelete, Action_ord,
						true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.onUpdate, Action_ord,
						true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.deferrable,
						Deferrable_ord, true, false, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.deferCheck,
						DeferCheck_ord, true, false, false, false, false);
		putDataEntity(Match_ord, "Match", Match.class, false,
				MatchEnum.Value.class);
		putDataEntity(Action_ord, "Action", Action.class, false,
				ActionEnum.Value.class);
		putDataEntity(Deferrable_ord, "Deferrable", Deferrable.class, false,
				DeferrableEnum.Value.class);
		putDataEntity(DeferCheck_ord, "DeferCheck", DeferCheck.class, false,
				DeferCheckEnum.Value.class);
		putCompositeEntity(
		StoredProcedures_ord, "StoredProcedures", StoredProcedures.class, false, StoredProcedure_ord, false, true);
		putSimpleEntity(StoredProcedure_ord, "StoredProcedure",
				StoredProcedure.class, false)
				.withFeature(SQLFeatureDescriptorEnum.name, Name_ord, false,
						true, false, false, false)
				.withFeature(SQLFeatureDescriptorEnum.procedureDeclarations,
						ProcedureDeclarations_ord, true, false, false, false,
						false)
				.withFeature(SQLFeatureDescriptorEnum.procedureStatements,
						ProcedureStatements_ord);
		putSimpleEntity(ProcedureDeclaration_ord, "ProcedureDeclaration",
				ProcedureDeclaration.class, true, VariableDeclaration_ord,
				SimpleVariableDeclaration_ord, DeclareCursor_ord);
		putCompositeEntity(
		ProcedureDeclarations_ord, "ProcedureDeclarations", ProcedureDeclarations.class, false, ProcedureDeclaration_ord, false, true);
		putCompositeEntity(
		ProcedureStatements_ord, "ProcedureStatements", ProcedureStatements.class, false, SQLStatement_ord, false, true);
		putSimpleEntity(DeclareCursor_ord, "DeclareCursor",
				DeclareCursor.class, false).withFeature(
				SQLFeatureDescriptorEnum.name, Name_ord).withFeature(
				SQLFeatureDescriptorEnum.sqlStatement, SQLStatement_ord);
		putSimpleEntity(SimpleVariableDeclaration_ord,
				"SimpleVariableDeclaration", SimpleVariableDeclaration.class,
				false).withFeature(SQLFeatureDescriptorEnum.name, Name_ord)
				.withFeature(SQLFeatureDescriptorEnum.type, Type_ord);
		putSimpleEntity(VariableDeclaration_ord, "VariableDeclaration",
				VariableDeclaration.class, false)
				.withFeature(SQLFeatureDescriptorEnum.name, Name_ord)
				.withFeature(SQLFeatureDescriptorEnum.reference, Reference_ord)
				.withFeature(SQLFeatureDescriptorEnum.referenceType,
						ReferenceType_ord);
		putDataEntity(Reference_ord, "Reference", Reference.class, false,
				String.class);
		putDataEntity(ReferenceType_ord, "ReferenceType", ReferenceType.class,
				false, ReferenceTypeEnum.Value.class);
		putDataEntity(ArrayExpr_ord, "ArrayExpr", ArrayExpr.class, false,
				String.class);
		putDataEntity(Name_ord, "Name", Name.class, false, String.class);
	}
}
