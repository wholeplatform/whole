package org.whole.lang.sql.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.sql.model.NullOrderTypeEnum.Value;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Blob;
import java.sql.Clob;

/** 
 * @generator Whole
 */
public class SQLGenericBuilderAdapter extends GenericIdentityBuilder {
	private ISQLBuilder specificBuilder;

	public SQLGenericBuilderAdapter(ISQLBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public SQLGenericBuilderAdapter(ISQLBuilder specificBuilder, IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.SQLStatements_ord:
			specificBuilder.SQLStatements();
			break;
		case SQLEntityDescriptorEnum.Select_ord:
			specificBuilder.Select();
			break;
		case SQLEntityDescriptorEnum.UnionSelect_ord:
			specificBuilder.UnionSelect();
			break;
		case SQLEntityDescriptorEnum.Insert_ord:
			specificBuilder.Insert();
			break;
		case SQLEntityDescriptorEnum.InsertFromSelect_ord:
			specificBuilder.InsertFromSelect();
			break;
		case SQLEntityDescriptorEnum.Update_ord:
			specificBuilder.Update();
			break;
		case SQLEntityDescriptorEnum.Create_ord:
			specificBuilder.Create();
			break;
		case SQLEntityDescriptorEnum.Delete_ord:
			specificBuilder.Delete();
			break;
		case SQLEntityDescriptorEnum.Drop_ord:
			specificBuilder.Drop();
			break;
		case SQLEntityDescriptorEnum.Truncate_ord:
			specificBuilder.Truncate();
			break;
		case SQLEntityDescriptorEnum.AlterTable_ord:
			specificBuilder.AlterTable();
			break;
		case SQLEntityDescriptorEnum.CreateIndex_ord:
			specificBuilder.CreateIndex();
			break;
		case SQLEntityDescriptorEnum.UniqueIndex_ord:
			specificBuilder.UniqueIndex();
			break;
		case SQLEntityDescriptorEnum.IndexDeclarations_ord:
			specificBuilder.IndexDeclarations();
			break;
		case SQLEntityDescriptorEnum.IndexDeclaration_ord:
			specificBuilder.IndexDeclaration();
			break;
		case SQLEntityDescriptorEnum.DropIndex_ord:
			specificBuilder.DropIndex();
			break;
		case SQLEntityDescriptorEnum.Foreach_ord:
			specificBuilder.Foreach();
			break;
		case SQLEntityDescriptorEnum.AddAction_ord:
			specificBuilder.AddAction();
			break;
		case SQLEntityDescriptorEnum.ColumnNames_ord:
			specificBuilder.ColumnNames();
			break;
		case SQLEntityDescriptorEnum.ColumnExpressions_ord:
			specificBuilder.ColumnExpressions();
			break;
		case SQLEntityDescriptorEnum.ColumnExpression_ord:
			specificBuilder.ColumnExpression();
			break;
		case SQLEntityDescriptorEnum.FromClauses_ord:
			specificBuilder.FromClauses();
			break;
		case SQLEntityDescriptorEnum.InnerJoinFromClause_ord:
			specificBuilder.InnerJoinFromClause();
			break;
		case SQLEntityDescriptorEnum.LeftOuterJoinFromClause_ord:
			specificBuilder.LeftOuterJoinFromClause();
			break;
		case SQLEntityDescriptorEnum.RightOuterJoinFromClause_ord:
			specificBuilder.RightOuterJoinFromClause();
			break;
		case SQLEntityDescriptorEnum.Between_ord:
			specificBuilder.Between();
			break;
		case SQLEntityDescriptorEnum.NotBetween_ord:
			specificBuilder.NotBetween();
			break;
		case SQLEntityDescriptorEnum.Is_ord:
			specificBuilder.Is();
			break;
		case SQLEntityDescriptorEnum.Values_ord:
			specificBuilder.Values();
			break;
		case SQLEntityDescriptorEnum.ParenthesizedExpression_ord:
			specificBuilder.ParenthesizedExpression();
			break;
		case SQLEntityDescriptorEnum.SQLExpressions_ord:
			specificBuilder.SQLExpressions();
			break;
		case SQLEntityDescriptorEnum.NullValue_ord:
			specificBuilder.NullValue();
			break;
		case SQLEntityDescriptorEnum.CaseExpression_ord:
			specificBuilder.CaseExpression();
			break;
		case SQLEntityDescriptorEnum.WhenClauses_ord:
			specificBuilder.WhenClauses();
			break;
		case SQLEntityDescriptorEnum.WhenClause_ord:
			specificBuilder.WhenClause();
			break;
		case SQLEntityDescriptorEnum.In_ord:
			specificBuilder.In();
			break;
		case SQLEntityDescriptorEnum.NotIn_ord:
			specificBuilder.NotIn();
			break;
		case SQLEntityDescriptorEnum.Subquery_ord:
			specificBuilder.Subquery();
			break;
		case SQLEntityDescriptorEnum.InValueList_ord:
			specificBuilder.InValueList();
			break;
		case SQLEntityDescriptorEnum.BinaryExpression_ord:
			specificBuilder.BinaryExpression();
			break;
		case SQLEntityDescriptorEnum.BooleanBinaryExpression_ord:
			specificBuilder.BooleanBinaryExpression();
			break;
		case SQLEntityDescriptorEnum.FunctionExpression_ord:
			specificBuilder.FunctionExpression();
			break;
		case SQLEntityDescriptorEnum.OrderByColumnExpressions_ord:
			specificBuilder.OrderByColumnExpressions();
			break;
		case SQLEntityDescriptorEnum.OrderByColumnExpression_ord:
			specificBuilder.OrderByColumnExpression();
			break;
		case SQLEntityDescriptorEnum.SetClauses_ord:
			specificBuilder.SetClauses();
			break;
		case SQLEntityDescriptorEnum.SetClause_ord:
			specificBuilder.SetClause();
			break;
		case SQLEntityDescriptorEnum.DeclarationOrConstraints_ord:
			specificBuilder.DeclarationOrConstraints();
			break;
		case SQLEntityDescriptorEnum.ColumnDeclaration_ord:
			specificBuilder.ColumnDeclaration();
			break;
		case SQLEntityDescriptorEnum.ColumnType_ord:
			specificBuilder.ColumnType();
			break;
		case SQLEntityDescriptorEnum.ColumnConstraints_ord:
			specificBuilder.ColumnConstraints();
			break;
		case SQLEntityDescriptorEnum.ForeignKeyColumnConstraint_ord:
			specificBuilder.ForeignKeyColumnConstraint();
			break;
		case SQLEntityDescriptorEnum.UniqueTableConstraint_ord:
			specificBuilder.UniqueTableConstraint();
			break;
		case SQLEntityDescriptorEnum.PrimaryKeyTableConstraint_ord:
			specificBuilder.PrimaryKeyTableConstraint();
			break;
		case SQLEntityDescriptorEnum.ForeignKeyTableConstraint_ord:
			specificBuilder.ForeignKeyTableConstraint();
			break;
		case SQLEntityDescriptorEnum.StoredProcedures_ord:
			specificBuilder.StoredProcedures();
			break;
		case SQLEntityDescriptorEnum.StoredProcedure_ord:
			specificBuilder.StoredProcedure();
			break;
		case SQLEntityDescriptorEnum.ProcedureDeclarations_ord:
			specificBuilder.ProcedureDeclarations();
			break;
		case SQLEntityDescriptorEnum.ProcedureStatements_ord:
			specificBuilder.ProcedureStatements();
			break;
		case SQLEntityDescriptorEnum.DeclareCursor_ord:
			specificBuilder.DeclareCursor();
			break;
		case SQLEntityDescriptorEnum.SimpleVariableDeclaration_ord:
			specificBuilder.SimpleVariableDeclaration();
			break;
		case SQLEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder.VariableDeclaration();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.SQLStatements_ord:
			specificBuilder.SQLStatements_();
			break;
		case SQLEntityDescriptorEnum.Select_ord:
			specificBuilder.Select_();
			break;
		case SQLEntityDescriptorEnum.UnionSelect_ord:
			specificBuilder.UnionSelect_();
			break;
		case SQLEntityDescriptorEnum.Insert_ord:
			specificBuilder.Insert_();
			break;
		case SQLEntityDescriptorEnum.InsertFromSelect_ord:
			specificBuilder.InsertFromSelect_();
			break;
		case SQLEntityDescriptorEnum.Update_ord:
			specificBuilder.Update_();
			break;
		case SQLEntityDescriptorEnum.Create_ord:
			specificBuilder.Create_();
			break;
		case SQLEntityDescriptorEnum.Delete_ord:
			specificBuilder.Delete_();
			break;
		case SQLEntityDescriptorEnum.Drop_ord:
			specificBuilder.Drop_();
			break;
		case SQLEntityDescriptorEnum.Truncate_ord:
			specificBuilder.Truncate_();
			break;
		case SQLEntityDescriptorEnum.AlterTable_ord:
			specificBuilder.AlterTable_();
			break;
		case SQLEntityDescriptorEnum.CreateIndex_ord:
			specificBuilder.CreateIndex_();
			break;
		case SQLEntityDescriptorEnum.UniqueIndex_ord:
			specificBuilder.UniqueIndex_();
			break;
		case SQLEntityDescriptorEnum.IndexDeclarations_ord:
			specificBuilder.IndexDeclarations_();
			break;
		case SQLEntityDescriptorEnum.IndexDeclaration_ord:
			specificBuilder.IndexDeclaration_();
			break;
		case SQLEntityDescriptorEnum.DropIndex_ord:
			specificBuilder.DropIndex_();
			break;
		case SQLEntityDescriptorEnum.Foreach_ord:
			specificBuilder.Foreach_();
			break;
		case SQLEntityDescriptorEnum.AddAction_ord:
			specificBuilder.AddAction_();
			break;
		case SQLEntityDescriptorEnum.ColumnNames_ord:
			specificBuilder.ColumnNames_();
			break;
		case SQLEntityDescriptorEnum.ColumnExpressions_ord:
			specificBuilder.ColumnExpressions_();
			break;
		case SQLEntityDescriptorEnum.ColumnExpression_ord:
			specificBuilder.ColumnExpression_();
			break;
		case SQLEntityDescriptorEnum.FromClauses_ord:
			specificBuilder.FromClauses_();
			break;
		case SQLEntityDescriptorEnum.InnerJoinFromClause_ord:
			specificBuilder.InnerJoinFromClause_();
			break;
		case SQLEntityDescriptorEnum.LeftOuterJoinFromClause_ord:
			specificBuilder.LeftOuterJoinFromClause_();
			break;
		case SQLEntityDescriptorEnum.RightOuterJoinFromClause_ord:
			specificBuilder.RightOuterJoinFromClause_();
			break;
		case SQLEntityDescriptorEnum.Between_ord:
			specificBuilder.Between_();
			break;
		case SQLEntityDescriptorEnum.NotBetween_ord:
			specificBuilder.NotBetween_();
			break;
		case SQLEntityDescriptorEnum.Is_ord:
			specificBuilder.Is_();
			break;
		case SQLEntityDescriptorEnum.Values_ord:
			specificBuilder.Values_();
			break;
		case SQLEntityDescriptorEnum.ParenthesizedExpression_ord:
			specificBuilder.ParenthesizedExpression_();
			break;
		case SQLEntityDescriptorEnum.SQLExpressions_ord:
			specificBuilder.SQLExpressions_();
			break;
		case SQLEntityDescriptorEnum.NullValue_ord:
			specificBuilder.NullValue_();
			break;
		case SQLEntityDescriptorEnum.CaseExpression_ord:
			specificBuilder.CaseExpression_();
			break;
		case SQLEntityDescriptorEnum.WhenClauses_ord:
			specificBuilder.WhenClauses_();
			break;
		case SQLEntityDescriptorEnum.WhenClause_ord:
			specificBuilder.WhenClause_();
			break;
		case SQLEntityDescriptorEnum.In_ord:
			specificBuilder.In_();
			break;
		case SQLEntityDescriptorEnum.NotIn_ord:
			specificBuilder.NotIn_();
			break;
		case SQLEntityDescriptorEnum.Subquery_ord:
			specificBuilder.Subquery_();
			break;
		case SQLEntityDescriptorEnum.InValueList_ord:
			specificBuilder.InValueList_();
			break;
		case SQLEntityDescriptorEnum.BinaryExpression_ord:
			specificBuilder.BinaryExpression_();
			break;
		case SQLEntityDescriptorEnum.BooleanBinaryExpression_ord:
			specificBuilder.BooleanBinaryExpression_();
			break;
		case SQLEntityDescriptorEnum.FunctionExpression_ord:
			specificBuilder.FunctionExpression_();
			break;
		case SQLEntityDescriptorEnum.OrderByColumnExpressions_ord:
			specificBuilder.OrderByColumnExpressions_();
			break;
		case SQLEntityDescriptorEnum.OrderByColumnExpression_ord:
			specificBuilder.OrderByColumnExpression_();
			break;
		case SQLEntityDescriptorEnum.SetClauses_ord:
			specificBuilder.SetClauses_();
			break;
		case SQLEntityDescriptorEnum.SetClause_ord:
			specificBuilder.SetClause_();
			break;
		case SQLEntityDescriptorEnum.DeclarationOrConstraints_ord:
			specificBuilder.DeclarationOrConstraints_();
			break;
		case SQLEntityDescriptorEnum.ColumnDeclaration_ord:
			specificBuilder.ColumnDeclaration_();
			break;
		case SQLEntityDescriptorEnum.ColumnType_ord:
			specificBuilder.ColumnType_();
			break;
		case SQLEntityDescriptorEnum.ColumnConstraints_ord:
			specificBuilder.ColumnConstraints_();
			break;
		case SQLEntityDescriptorEnum.ForeignKeyColumnConstraint_ord:
			specificBuilder.ForeignKeyColumnConstraint_();
			break;
		case SQLEntityDescriptorEnum.UniqueTableConstraint_ord:
			specificBuilder.UniqueTableConstraint_();
			break;
		case SQLEntityDescriptorEnum.PrimaryKeyTableConstraint_ord:
			specificBuilder.PrimaryKeyTableConstraint_();
			break;
		case SQLEntityDescriptorEnum.ForeignKeyTableConstraint_ord:
			specificBuilder.ForeignKeyTableConstraint_();
			break;
		case SQLEntityDescriptorEnum.StoredProcedures_ord:
			specificBuilder.StoredProcedures_();
			break;
		case SQLEntityDescriptorEnum.StoredProcedure_ord:
			specificBuilder.StoredProcedure_();
			break;
		case SQLEntityDescriptorEnum.ProcedureDeclarations_ord:
			specificBuilder.ProcedureDeclarations_();
			break;
		case SQLEntityDescriptorEnum.ProcedureStatements_ord:
			specificBuilder.ProcedureStatements_();
			break;
		case SQLEntityDescriptorEnum.DeclareCursor_ord:
			specificBuilder.DeclareCursor_();
			break;
		case SQLEntityDescriptorEnum.SimpleVariableDeclaration_ord:
			specificBuilder.SimpleVariableDeclaration_();
			break;
		case SQLEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder.VariableDeclaration_();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.SQLStatements_ord:
			specificBuilder.SQLStatements_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.IndexDeclarations_ord:
			specificBuilder.IndexDeclarations_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.ColumnNames_ord:
			specificBuilder.ColumnNames_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.ColumnExpressions_ord:
			specificBuilder.ColumnExpressions_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.FromClauses_ord:
			specificBuilder.FromClauses_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.Values_ord:
			specificBuilder.Values_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.SQLExpressions_ord:
			specificBuilder.SQLExpressions_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.WhenClauses_ord:
			specificBuilder.WhenClauses_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.InValueList_ord:
			specificBuilder.InValueList_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.OrderByColumnExpressions_ord:
			specificBuilder.OrderByColumnExpressions_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.SetClauses_ord:
			specificBuilder.SetClauses_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.DeclarationOrConstraints_ord:
			specificBuilder.DeclarationOrConstraints_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.ColumnConstraints_ord:
			specificBuilder.ColumnConstraints_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.StoredProcedures_ord:
			specificBuilder.StoredProcedures_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.ProcedureDeclarations_ord:
			specificBuilder.ProcedureDeclarations_(initialCapacity);
			break;
		case SQLEntityDescriptorEnum.ProcedureStatements_ord:
			specificBuilder.ProcedureStatements_(initialCapacity);
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.SQLStatements_ord:
			specificBuilder._SQLStatements();
			break;
		case SQLEntityDescriptorEnum.Select_ord:
			specificBuilder._Select();
			break;
		case SQLEntityDescriptorEnum.UnionSelect_ord:
			specificBuilder._UnionSelect();
			break;
		case SQLEntityDescriptorEnum.Insert_ord:
			specificBuilder._Insert();
			break;
		case SQLEntityDescriptorEnum.InsertFromSelect_ord:
			specificBuilder._InsertFromSelect();
			break;
		case SQLEntityDescriptorEnum.Update_ord:
			specificBuilder._Update();
			break;
		case SQLEntityDescriptorEnum.Create_ord:
			specificBuilder._Create();
			break;
		case SQLEntityDescriptorEnum.Delete_ord:
			specificBuilder._Delete();
			break;
		case SQLEntityDescriptorEnum.Drop_ord:
			specificBuilder._Drop();
			break;
		case SQLEntityDescriptorEnum.Truncate_ord:
			specificBuilder._Truncate();
			break;
		case SQLEntityDescriptorEnum.AlterTable_ord:
			specificBuilder._AlterTable();
			break;
		case SQLEntityDescriptorEnum.CreateIndex_ord:
			specificBuilder._CreateIndex();
			break;
		case SQLEntityDescriptorEnum.UniqueIndex_ord:
			specificBuilder._UniqueIndex();
			break;
		case SQLEntityDescriptorEnum.IndexDeclarations_ord:
			specificBuilder._IndexDeclarations();
			break;
		case SQLEntityDescriptorEnum.IndexDeclaration_ord:
			specificBuilder._IndexDeclaration();
			break;
		case SQLEntityDescriptorEnum.DropIndex_ord:
			specificBuilder._DropIndex();
			break;
		case SQLEntityDescriptorEnum.Foreach_ord:
			specificBuilder._Foreach();
			break;
		case SQLEntityDescriptorEnum.AddAction_ord:
			specificBuilder._AddAction();
			break;
		case SQLEntityDescriptorEnum.ColumnNames_ord:
			specificBuilder._ColumnNames();
			break;
		case SQLEntityDescriptorEnum.ColumnExpressions_ord:
			specificBuilder._ColumnExpressions();
			break;
		case SQLEntityDescriptorEnum.ColumnExpression_ord:
			specificBuilder._ColumnExpression();
			break;
		case SQLEntityDescriptorEnum.FromClauses_ord:
			specificBuilder._FromClauses();
			break;
		case SQLEntityDescriptorEnum.InnerJoinFromClause_ord:
			specificBuilder._InnerJoinFromClause();
			break;
		case SQLEntityDescriptorEnum.LeftOuterJoinFromClause_ord:
			specificBuilder._LeftOuterJoinFromClause();
			break;
		case SQLEntityDescriptorEnum.RightOuterJoinFromClause_ord:
			specificBuilder._RightOuterJoinFromClause();
			break;
		case SQLEntityDescriptorEnum.Between_ord:
			specificBuilder._Between();
			break;
		case SQLEntityDescriptorEnum.NotBetween_ord:
			specificBuilder._NotBetween();
			break;
		case SQLEntityDescriptorEnum.Is_ord:
			specificBuilder._Is();
			break;
		case SQLEntityDescriptorEnum.Values_ord:
			specificBuilder._Values();
			break;
		case SQLEntityDescriptorEnum.ParenthesizedExpression_ord:
			specificBuilder._ParenthesizedExpression();
			break;
		case SQLEntityDescriptorEnum.SQLExpressions_ord:
			specificBuilder._SQLExpressions();
			break;
		case SQLEntityDescriptorEnum.NullValue_ord:
			specificBuilder._NullValue();
			break;
		case SQLEntityDescriptorEnum.CaseExpression_ord:
			specificBuilder._CaseExpression();
			break;
		case SQLEntityDescriptorEnum.WhenClauses_ord:
			specificBuilder._WhenClauses();
			break;
		case SQLEntityDescriptorEnum.WhenClause_ord:
			specificBuilder._WhenClause();
			break;
		case SQLEntityDescriptorEnum.In_ord:
			specificBuilder._In();
			break;
		case SQLEntityDescriptorEnum.NotIn_ord:
			specificBuilder._NotIn();
			break;
		case SQLEntityDescriptorEnum.Subquery_ord:
			specificBuilder._Subquery();
			break;
		case SQLEntityDescriptorEnum.InValueList_ord:
			specificBuilder._InValueList();
			break;
		case SQLEntityDescriptorEnum.BinaryExpression_ord:
			specificBuilder._BinaryExpression();
			break;
		case SQLEntityDescriptorEnum.BooleanBinaryExpression_ord:
			specificBuilder._BooleanBinaryExpression();
			break;
		case SQLEntityDescriptorEnum.FunctionExpression_ord:
			specificBuilder._FunctionExpression();
			break;
		case SQLEntityDescriptorEnum.OrderByColumnExpressions_ord:
			specificBuilder._OrderByColumnExpressions();
			break;
		case SQLEntityDescriptorEnum.OrderByColumnExpression_ord:
			specificBuilder._OrderByColumnExpression();
			break;
		case SQLEntityDescriptorEnum.SetClauses_ord:
			specificBuilder._SetClauses();
			break;
		case SQLEntityDescriptorEnum.SetClause_ord:
			specificBuilder._SetClause();
			break;
		case SQLEntityDescriptorEnum.DeclarationOrConstraints_ord:
			specificBuilder._DeclarationOrConstraints();
			break;
		case SQLEntityDescriptorEnum.ColumnDeclaration_ord:
			specificBuilder._ColumnDeclaration();
			break;
		case SQLEntityDescriptorEnum.ColumnType_ord:
			specificBuilder._ColumnType();
			break;
		case SQLEntityDescriptorEnum.ColumnConstraints_ord:
			specificBuilder._ColumnConstraints();
			break;
		case SQLEntityDescriptorEnum.ForeignKeyColumnConstraint_ord:
			specificBuilder._ForeignKeyColumnConstraint();
			break;
		case SQLEntityDescriptorEnum.UniqueTableConstraint_ord:
			specificBuilder._UniqueTableConstraint();
			break;
		case SQLEntityDescriptorEnum.PrimaryKeyTableConstraint_ord:
			specificBuilder._PrimaryKeyTableConstraint();
			break;
		case SQLEntityDescriptorEnum.ForeignKeyTableConstraint_ord:
			specificBuilder._ForeignKeyTableConstraint();
			break;
		case SQLEntityDescriptorEnum.StoredProcedures_ord:
			specificBuilder._StoredProcedures();
			break;
		case SQLEntityDescriptorEnum.StoredProcedure_ord:
			specificBuilder._StoredProcedure();
			break;
		case SQLEntityDescriptorEnum.ProcedureDeclarations_ord:
			specificBuilder._ProcedureDeclarations();
			break;
		case SQLEntityDescriptorEnum.ProcedureStatements_ord:
			specificBuilder._ProcedureStatements();
			break;
		case SQLEntityDescriptorEnum.DeclareCursor_ord:
			specificBuilder._DeclareCursor();
			break;
		case SQLEntityDescriptorEnum.SimpleVariableDeclaration_ord:
			specificBuilder._SimpleVariableDeclaration();
			break;
		case SQLEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder._VariableDeclaration();
			break;
		}
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case SQLFeatureDescriptorEnum.selectType_ord:
			specificBuilder.selectType();
			break;
		case SQLFeatureDescriptorEnum.columnExprs_ord:
			specificBuilder.columnExprs();
			break;
		case SQLFeatureDescriptorEnum.fromClauses_ord:
			specificBuilder.fromClauses();
			break;
		case SQLFeatureDescriptorEnum.whereExpr_ord:
			specificBuilder.whereExpr();
			break;
		case SQLFeatureDescriptorEnum.groupByExprs_ord:
			specificBuilder.groupByExprs();
			break;
		case SQLFeatureDescriptorEnum.havingExpr_ord:
			specificBuilder.havingExpr();
			break;
		case SQLFeatureDescriptorEnum.orderByColumnExprs_ord:
			specificBuilder.orderByColumnExprs();
			break;
		case SQLFeatureDescriptorEnum.simpleSelect_ord:
			specificBuilder.simpleSelect();
			break;
		case SQLFeatureDescriptorEnum.unionSelectStatement_ord:
			specificBuilder.unionSelectStatement();
			break;
		case SQLFeatureDescriptorEnum.tableName_ord:
			specificBuilder.tableName();
			break;
		case SQLFeatureDescriptorEnum.columnNames_ord:
			specificBuilder.columnNames();
			break;
		case SQLFeatureDescriptorEnum.values_ord:
			specificBuilder.values();
			break;
		case SQLFeatureDescriptorEnum.select_ord:
			specificBuilder.select();
			break;
		case SQLFeatureDescriptorEnum.setClauses_ord:
			specificBuilder.setClauses();
			break;
		case SQLFeatureDescriptorEnum.limit_ord:
			specificBuilder.limit();
			break;
		case SQLFeatureDescriptorEnum.declarationOrConstraints_ord:
			specificBuilder.declarationOrConstraints();
			break;
		case SQLFeatureDescriptorEnum.action_ord:
			specificBuilder.action();
			break;
		case SQLFeatureDescriptorEnum.unique_ord:
			specificBuilder.unique();
			break;
		case SQLFeatureDescriptorEnum.indexName_ord:
			specificBuilder.indexName();
			break;
		case SQLFeatureDescriptorEnum.indexDeclarations_ord:
			specificBuilder.indexDeclarations();
			break;
		case SQLFeatureDescriptorEnum.columnName_ord:
			specificBuilder.columnName();
			break;
		case SQLFeatureDescriptorEnum.orderType_ord:
			specificBuilder.orderType();
			break;
		case SQLFeatureDescriptorEnum.nullOrderType_ord:
			specificBuilder.nullOrderType();
			break;
		case SQLFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case SQLFeatureDescriptorEnum.arrayExp_ord:
			specificBuilder.arrayExp();
			break;
		case SQLFeatureDescriptorEnum.trueBody_ord:
			specificBuilder.trueBody();
			break;
		case SQLFeatureDescriptorEnum.declarationOrConstraint_ord:
			specificBuilder.declarationOrConstraint();
			break;
		case SQLFeatureDescriptorEnum.expression_ord:
			specificBuilder.expression();
			break;
		case SQLFeatureDescriptorEnum.alias_ord:
			specificBuilder.alias();
			break;
		case SQLFeatureDescriptorEnum.innerTable_ord:
			specificBuilder.innerTable();
			break;
		case SQLFeatureDescriptorEnum.onExpression_ord:
			specificBuilder.onExpression();
			break;
		case SQLFeatureDescriptorEnum.outerTable_ord:
			specificBuilder.outerTable();
			break;
		case SQLFeatureDescriptorEnum.lowerExpression_ord:
			specificBuilder.lowerExpression();
			break;
		case SQLFeatureDescriptorEnum.upperExpression_ord:
			specificBuilder.upperExpression();
			break;
		case SQLFeatureDescriptorEnum.type_ord:
			specificBuilder.type();
			break;
		case SQLFeatureDescriptorEnum.whenClauses_ord:
			specificBuilder.whenClauses();
			break;
		case SQLFeatureDescriptorEnum.elseClause_ord:
			specificBuilder.elseClause();
			break;
		case SQLFeatureDescriptorEnum.condition_ord:
			specificBuilder.condition();
			break;
		case SQLFeatureDescriptorEnum.result_ord:
			specificBuilder.result();
			break;
		case SQLFeatureDescriptorEnum.leftExpr_ord:
			specificBuilder.leftExpr();
			break;
		case SQLFeatureDescriptorEnum.inPredicate_ord:
			specificBuilder.inPredicate();
			break;
		case SQLFeatureDescriptorEnum.query_ord:
			specificBuilder.query();
			break;
		case SQLFeatureDescriptorEnum.operator_ord:
			specificBuilder.operator();
			break;
		case SQLFeatureDescriptorEnum.rightExpr_ord:
			specificBuilder.rightExpr();
			break;
		case SQLFeatureDescriptorEnum.functionName_ord:
			specificBuilder.functionName();
			break;
		case SQLFeatureDescriptorEnum.params_ord:
			specificBuilder.params();
			break;
		case SQLFeatureDescriptorEnum.columnType_ord:
			specificBuilder.columnType();
			break;
		case SQLFeatureDescriptorEnum.columnConstraints_ord:
			specificBuilder.columnConstraints();
			break;
		case SQLFeatureDescriptorEnum.size_ord:
			specificBuilder.size();
			break;
		case SQLFeatureDescriptorEnum.precision_ord:
			specificBuilder.precision();
			break;
		case SQLFeatureDescriptorEnum.foreignTableName_ord:
			specificBuilder.foreignTableName();
			break;
		case SQLFeatureDescriptorEnum.foreignColumnName_ord:
			specificBuilder.foreignColumnName();
			break;
		case SQLFeatureDescriptorEnum.constraintName_ord:
			specificBuilder.constraintName();
			break;
		case SQLFeatureDescriptorEnum.foreignColumnNames_ord:
			specificBuilder.foreignColumnNames();
			break;
		case SQLFeatureDescriptorEnum.match_ord:
			specificBuilder.match();
			break;
		case SQLFeatureDescriptorEnum.onDelete_ord:
			specificBuilder.onDelete();
			break;
		case SQLFeatureDescriptorEnum.onUpdate_ord:
			specificBuilder.onUpdate();
			break;
		case SQLFeatureDescriptorEnum.deferrable_ord:
			specificBuilder.deferrable();
			break;
		case SQLFeatureDescriptorEnum.deferCheck_ord:
			specificBuilder.deferCheck();
			break;
		case SQLFeatureDescriptorEnum.procedureDeclarations_ord:
			specificBuilder.procedureDeclarations();
			break;
		case SQLFeatureDescriptorEnum.procedureStatements_ord:
			specificBuilder.procedureStatements();
			break;
		case SQLFeatureDescriptorEnum.sqlStatement_ord:
			specificBuilder.sqlStatement();
			break;
		case SQLFeatureDescriptorEnum.reference_ord:
			specificBuilder.reference();
			break;
		case SQLFeatureDescriptorEnum.referenceType_ord:
			specificBuilder.referenceType();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.NullOrderType_ord:
			specificBuilder.NullOrderType((Value) value);
			break;
		case SQLEntityDescriptorEnum.SelectType_ord:
			specificBuilder.SelectType((org.whole.lang.sql.model.SelectTypeEnum.Value) value);
			break;
		case SQLEntityDescriptorEnum.IsType_ord:
			specificBuilder.IsType((org.whole.lang.sql.model.IsTypeEnum.Value) value);
			break;
		case SQLEntityDescriptorEnum.BinaryOperator_ord:
			specificBuilder.BinaryOperator((org.whole.lang.sql.model.BinaryOperatorEnum.Value) value);
			break;
		case SQLEntityDescriptorEnum.BooleanOperator_ord:
			specificBuilder.BooleanOperator((org.whole.lang.sql.model.BooleanOperatorEnum.Value) value);
			break;
		case SQLEntityDescriptorEnum.OrderType_ord:
			specificBuilder.OrderType((org.whole.lang.sql.model.OrderTypeEnum.Value) value);
			break;
		case SQLEntityDescriptorEnum.SimpleColumnConstraint_ord:
			specificBuilder.SimpleColumnConstraint((org.whole.lang.sql.model.SimpleColumnConstraintEnum.Value) value);
			break;
		case SQLEntityDescriptorEnum.Match_ord:
			specificBuilder.Match((org.whole.lang.sql.model.MatchEnum.Value) value);
			break;
		case SQLEntityDescriptorEnum.Action_ord:
			specificBuilder.Action((org.whole.lang.sql.model.ActionEnum.Value) value);
			break;
		case SQLEntityDescriptorEnum.Deferrable_ord:
			specificBuilder.Deferrable((org.whole.lang.sql.model.DeferrableEnum.Value) value);
			break;
		case SQLEntityDescriptorEnum.DeferCheck_ord:
			specificBuilder.DeferCheck((org.whole.lang.sql.model.DeferCheckEnum.Value) value);
			break;
		case SQLEntityDescriptorEnum.ReferenceType_ord:
			specificBuilder.ReferenceType((org.whole.lang.sql.model.ReferenceTypeEnum.Value) value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.Alias_ord:
			specificBuilder.Alias(value);
			break;
		case SQLEntityDescriptorEnum.SimpleFromClause_ord:
			specificBuilder.SimpleFromClause(value);
			break;
		case SQLEntityDescriptorEnum.StringValue_ord:
			specificBuilder.StringValue(value);
			break;
		case SQLEntityDescriptorEnum.TableName_ord:
			specificBuilder.TableName(value);
			break;
		case SQLEntityDescriptorEnum.ColumnName_ord:
			specificBuilder.ColumnName(value);
			break;
		case SQLEntityDescriptorEnum.IndexName_ord:
			specificBuilder.IndexName(value);
			break;
		case SQLEntityDescriptorEnum.ConstraintName_ord:
			specificBuilder.ConstraintName(value);
			break;
		case SQLEntityDescriptorEnum.FunctionName_ord:
			specificBuilder.FunctionName(value);
			break;
		case SQLEntityDescriptorEnum.Type_ord:
			specificBuilder.Type(value);
			break;
		case SQLEntityDescriptorEnum.Reference_ord:
			specificBuilder.Reference(value);
			break;
		case SQLEntityDescriptorEnum.ArrayExpr_ord:
			specificBuilder.ArrayExpr(value);
			break;
		case SQLEntityDescriptorEnum.Name_ord:
			specificBuilder.Name(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.ArrayValue_ord:
			specificBuilder.ArrayValue(value);
			break;
		case SQLEntityDescriptorEnum.BinaryValue_ord:
			specificBuilder.BinaryValue(value);
			break;
		case SQLEntityDescriptorEnum.RawValue_ord:
			specificBuilder.RawValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.BooleanValue_ord:
			specificBuilder.BooleanValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.TinyIntValue_ord:
			specificBuilder.TinyIntValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.SmallIntValue_ord:
			specificBuilder.SmallIntValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.IntValue_ord:
			specificBuilder.IntValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.BigIntValue_ord:
			specificBuilder.BigIntValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.DoubleValue_ord:
			specificBuilder.DoubleValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.RealValue_ord:
			specificBuilder.RealValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, BigDecimal value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.DecimalValue_ord:
			specificBuilder.DecimalValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.DateValue_ord:
			specificBuilder.DateValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, Time value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.TimeValue_ord:
			specificBuilder.TimeValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, Timestamp value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.TimestampValue_ord:
			specificBuilder.TimestampValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, Blob value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.BlobValue_ord:
			specificBuilder.BlobValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, Clob value) {
		switch (entityDesc.getOrdinal()) {
		case SQLEntityDescriptorEnum.ClobValue_ord:
			specificBuilder.ClobValue(value);
			break;
		}
	}
}
