package org.whole.lang.sql.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class SQLIdentitySwitchVisitor extends AbstractVisitor
		implements ISQLVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case SQLEntityDescriptorEnum.SQLStatements_ord:
			visit((SQLStatements) entity);
			break;
		case SQLEntityDescriptorEnum.Select_ord:
			visit((Select) entity);
			break;
		case SQLEntityDescriptorEnum.UnionSelect_ord:
			visit((UnionSelect) entity);
			break;
		case SQLEntityDescriptorEnum.Insert_ord:
			visit((Insert) entity);
			break;
		case SQLEntityDescriptorEnum.InsertFromSelect_ord:
			visit((InsertFromSelect) entity);
			break;
		case SQLEntityDescriptorEnum.Update_ord:
			visit((Update) entity);
			break;
		case SQLEntityDescriptorEnum.Create_ord:
			visit((Create) entity);
			break;
		case SQLEntityDescriptorEnum.Delete_ord:
			visit((Delete) entity);
			break;
		case SQLEntityDescriptorEnum.Drop_ord:
			visit((Drop) entity);
			break;
		case SQLEntityDescriptorEnum.Truncate_ord:
			visit((Truncate) entity);
			break;
		case SQLEntityDescriptorEnum.AlterTable_ord:
			visit((AlterTable) entity);
			break;
		case SQLEntityDescriptorEnum.CreateIndex_ord:
			visit((CreateIndex) entity);
			break;
		case SQLEntityDescriptorEnum.UniqueIndex_ord:
			visit((UniqueIndex) entity);
			break;
		case SQLEntityDescriptorEnum.IndexDeclarations_ord:
			visit((IndexDeclarations) entity);
			break;
		case SQLEntityDescriptorEnum.IndexDeclaration_ord:
			visit((IndexDeclaration) entity);
			break;
		case SQLEntityDescriptorEnum.NullOrderType_ord:
			visit((NullOrderType) entity);
			break;
		case SQLEntityDescriptorEnum.DropIndex_ord:
			visit((DropIndex) entity);
			break;
		case SQLEntityDescriptorEnum.Foreach_ord:
			visit((Foreach) entity);
			break;
		case SQLEntityDescriptorEnum.AddAction_ord:
			visit((AddAction) entity);
			break;
		case SQLEntityDescriptorEnum.SelectType_ord:
			visit((SelectType) entity);
			break;
		case SQLEntityDescriptorEnum.ColumnNames_ord:
			visit((ColumnNames) entity);
			break;
		case SQLEntityDescriptorEnum.ColumnExpressions_ord:
			visit((ColumnExpressions) entity);
			break;
		case SQLEntityDescriptorEnum.ColumnExpression_ord:
			visit((ColumnExpression) entity);
			break;
		case SQLEntityDescriptorEnum.Alias_ord:
			visit((Alias) entity);
			break;
		case SQLEntityDescriptorEnum.FromClauses_ord:
			visit((FromClauses) entity);
			break;
		case SQLEntityDescriptorEnum.SimpleFromClause_ord:
			visit((SimpleFromClause) entity);
			break;
		case SQLEntityDescriptorEnum.InnerJoinFromClause_ord:
			visit((InnerJoinFromClause) entity);
			break;
		case SQLEntityDescriptorEnum.LeftOuterJoinFromClause_ord:
			visit((LeftOuterJoinFromClause) entity);
			break;
		case SQLEntityDescriptorEnum.RightOuterJoinFromClause_ord:
			visit((RightOuterJoinFromClause) entity);
			break;
		case SQLEntityDescriptorEnum.Between_ord:
			visit((Between) entity);
			break;
		case SQLEntityDescriptorEnum.NotBetween_ord:
			visit((NotBetween) entity);
			break;
		case SQLEntityDescriptorEnum.Is_ord:
			visit((Is) entity);
			break;
		case SQLEntityDescriptorEnum.IsType_ord:
			visit((IsType) entity);
			break;
		case SQLEntityDescriptorEnum.Values_ord:
			visit((Values) entity);
			break;
		case SQLEntityDescriptorEnum.ParenthesizedExpression_ord:
			visit((ParenthesizedExpression) entity);
			break;
		case SQLEntityDescriptorEnum.SQLExpressions_ord:
			visit((SQLExpressions) entity);
			break;
		case SQLEntityDescriptorEnum.NullValue_ord:
			visit((NullValue) entity);
			break;
		case SQLEntityDescriptorEnum.ArrayValue_ord:
			visit((ArrayValue) entity);
			break;
		case SQLEntityDescriptorEnum.BooleanValue_ord:
			visit((BooleanValue) entity);
			break;
		case SQLEntityDescriptorEnum.TinyIntValue_ord:
			visit((TinyIntValue) entity);
			break;
		case SQLEntityDescriptorEnum.SmallIntValue_ord:
			visit((SmallIntValue) entity);
			break;
		case SQLEntityDescriptorEnum.IntValue_ord:
			visit((IntValue) entity);
			break;
		case SQLEntityDescriptorEnum.BigIntValue_ord:
			visit((BigIntValue) entity);
			break;
		case SQLEntityDescriptorEnum.DoubleValue_ord:
			visit((DoubleValue) entity);
			break;
		case SQLEntityDescriptorEnum.RealValue_ord:
			visit((RealValue) entity);
			break;
		case SQLEntityDescriptorEnum.DecimalValue_ord:
			visit((DecimalValue) entity);
			break;
		case SQLEntityDescriptorEnum.StringValue_ord:
			visit((StringValue) entity);
			break;
		case SQLEntityDescriptorEnum.BinaryValue_ord:
			visit((BinaryValue) entity);
			break;
		case SQLEntityDescriptorEnum.DateValue_ord:
			visit((DateValue) entity);
			break;
		case SQLEntityDescriptorEnum.TimeValue_ord:
			visit((TimeValue) entity);
			break;
		case SQLEntityDescriptorEnum.TimestampValue_ord:
			visit((TimestampValue) entity);
			break;
		case SQLEntityDescriptorEnum.BlobValue_ord:
			visit((BlobValue) entity);
			break;
		case SQLEntityDescriptorEnum.ClobValue_ord:
			visit((ClobValue) entity);
			break;
		case SQLEntityDescriptorEnum.RawValue_ord:
			visit((RawValue) entity);
			break;
		case SQLEntityDescriptorEnum.TableName_ord:
			visit((TableName) entity);
			break;
		case SQLEntityDescriptorEnum.ColumnName_ord:
			visit((ColumnName) entity);
			break;
		case SQLEntityDescriptorEnum.IndexName_ord:
			visit((IndexName) entity);
			break;
		case SQLEntityDescriptorEnum.CaseExpression_ord:
			visit((CaseExpression) entity);
			break;
		case SQLEntityDescriptorEnum.WhenClauses_ord:
			visit((WhenClauses) entity);
			break;
		case SQLEntityDescriptorEnum.WhenClause_ord:
			visit((WhenClause) entity);
			break;
		case SQLEntityDescriptorEnum.In_ord:
			visit((In) entity);
			break;
		case SQLEntityDescriptorEnum.NotIn_ord:
			visit((NotIn) entity);
			break;
		case SQLEntityDescriptorEnum.Subquery_ord:
			visit((Subquery) entity);
			break;
		case SQLEntityDescriptorEnum.InValueList_ord:
			visit((InValueList) entity);
			break;
		case SQLEntityDescriptorEnum.BinaryExpression_ord:
			visit((BinaryExpression) entity);
			break;
		case SQLEntityDescriptorEnum.BinaryOperator_ord:
			visit((BinaryOperator) entity);
			break;
		case SQLEntityDescriptorEnum.BooleanBinaryExpression_ord:
			visit((BooleanBinaryExpression) entity);
			break;
		case SQLEntityDescriptorEnum.BooleanOperator_ord:
			visit((BooleanOperator) entity);
			break;
		case SQLEntityDescriptorEnum.FunctionExpression_ord:
			visit((FunctionExpression) entity);
			break;
		case SQLEntityDescriptorEnum.FunctionName_ord:
			visit((FunctionName) entity);
			break;
		case SQLEntityDescriptorEnum.OrderByColumnExpressions_ord:
			visit((OrderByColumnExpressions) entity);
			break;
		case SQLEntityDescriptorEnum.OrderByColumnExpression_ord:
			visit((OrderByColumnExpression) entity);
			break;
		case SQLEntityDescriptorEnum.OrderType_ord:
			visit((OrderType) entity);
			break;
		case SQLEntityDescriptorEnum.SetClauses_ord:
			visit((SetClauses) entity);
			break;
		case SQLEntityDescriptorEnum.SetClause_ord:
			visit((SetClause) entity);
			break;
		case SQLEntityDescriptorEnum.DeclarationOrConstraints_ord:
			visit((DeclarationOrConstraints) entity);
			break;
		case SQLEntityDescriptorEnum.ColumnDeclaration_ord:
			visit((ColumnDeclaration) entity);
			break;
		case SQLEntityDescriptorEnum.ColumnType_ord:
			visit((ColumnType) entity);
			break;
		case SQLEntityDescriptorEnum.Type_ord:
			visit((Type) entity);
			break;
		case SQLEntityDescriptorEnum.ColumnConstraints_ord:
			visit((ColumnConstraints) entity);
			break;
		case SQLEntityDescriptorEnum.SimpleColumnConstraint_ord:
			visit((SimpleColumnConstraint) entity);
			break;
		case SQLEntityDescriptorEnum.ForeignKeyColumnConstraint_ord:
			visit((ForeignKeyColumnConstraint) entity);
			break;
		case SQLEntityDescriptorEnum.UniqueTableConstraint_ord:
			visit((UniqueTableConstraint) entity);
			break;
		case SQLEntityDescriptorEnum.PrimaryKeyTableConstraint_ord:
			visit((PrimaryKeyTableConstraint) entity);
			break;
		case SQLEntityDescriptorEnum.ForeignKeyTableConstraint_ord:
			visit((ForeignKeyTableConstraint) entity);
			break;
		case SQLEntityDescriptorEnum.Match_ord:
			visit((Match) entity);
			break;
		case SQLEntityDescriptorEnum.Action_ord:
			visit((Action) entity);
			break;
		case SQLEntityDescriptorEnum.Deferrable_ord:
			visit((Deferrable) entity);
			break;
		case SQLEntityDescriptorEnum.DeferCheck_ord:
			visit((DeferCheck) entity);
			break;
		case SQLEntityDescriptorEnum.StoredProcedures_ord:
			visit((StoredProcedures) entity);
			break;
		case SQLEntityDescriptorEnum.StoredProcedure_ord:
			visit((StoredProcedure) entity);
			break;
		case SQLEntityDescriptorEnum.ProcedureDeclarations_ord:
			visit((ProcedureDeclarations) entity);
			break;
		case SQLEntityDescriptorEnum.ProcedureStatements_ord:
			visit((ProcedureStatements) entity);
			break;
		case SQLEntityDescriptorEnum.DeclareCursor_ord:
			visit((DeclareCursor) entity);
			break;
		case SQLEntityDescriptorEnum.SimpleVariableDeclaration_ord:
			visit((SimpleVariableDeclaration) entity);
			break;
		case SQLEntityDescriptorEnum.VariableDeclaration_ord:
			visit((VariableDeclaration) entity);
			break;
		case SQLEntityDescriptorEnum.Reference_ord:
			visit((Reference) entity);
			break;
		case SQLEntityDescriptorEnum.ReferenceType_ord:
			visit((ReferenceType) entity);
			break;
		case SQLEntityDescriptorEnum.ArrayExpr_ord:
			visit((ArrayExpr) entity);
			break;
		case SQLEntityDescriptorEnum.Name_ord:
			visit((Name) entity);
			break;
		}
	}
}
