package org.whole.lang.sql.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class SQLModelContext extends EntityContext {
	public SQLModelContext(IEntity root) {
		super(root);
	}

	public SQLModelContext getSelectType() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.selectType);
	}

	public void setSelectType(SQLModelContext selectType) {
		wSet(SQLFeatureDescriptorEnum.selectType, selectType);
	}

	public SQLModelContext getColumnExprs() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.columnExprs);
	}

	public void setColumnExprs(SQLModelContext columnExprs) {
		wSet(SQLFeatureDescriptorEnum.columnExprs, columnExprs);
	}

	public SQLModelContext getFromClauses() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.fromClauses);
	}

	public void setFromClauses(SQLModelContext fromClauses) {
		wSet(SQLFeatureDescriptorEnum.fromClauses, fromClauses);
	}

	public SQLModelContext getWhereExpr() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.whereExpr);
	}

	public void setWhereExpr(SQLModelContext whereExpr) {
		wSet(SQLFeatureDescriptorEnum.whereExpr, whereExpr);
	}

	public SQLModelContext getGroupByExprs() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.groupByExprs);
	}

	public void setGroupByExprs(SQLModelContext groupByExprs) {
		wSet(SQLFeatureDescriptorEnum.groupByExprs, groupByExprs);
	}

	public SQLModelContext getHavingExpr() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.havingExpr);
	}

	public void setHavingExpr(SQLModelContext havingExpr) {
		wSet(SQLFeatureDescriptorEnum.havingExpr, havingExpr);
	}

	public SQLModelContext getOrderByColumnExprs() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.orderByColumnExprs);
	}

	public void setOrderByColumnExprs(SQLModelContext orderByColumnExprs) {
		wSet(SQLFeatureDescriptorEnum.orderByColumnExprs, orderByColumnExprs);
	}

	public SQLModelContext getSimpleSelect() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.simpleSelect);
	}

	public void setSimpleSelect(SQLModelContext simpleSelect) {
		wSet(SQLFeatureDescriptorEnum.simpleSelect, simpleSelect);
	}

	public SQLModelContext getUnionSelectStatement() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.unionSelectStatement);
	}

	public void setUnionSelectStatement(SQLModelContext unionSelectStatement) {
		wSet(SQLFeatureDescriptorEnum.unionSelectStatement, unionSelectStatement);
	}

	public SQLModelContext getTableName() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.tableName);
	}

	public void setTableName(SQLModelContext tableName) {
		wSet(SQLFeatureDescriptorEnum.tableName, tableName);
	}

	public SQLModelContext getColumnNames() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.columnNames);
	}

	public void setColumnNames(SQLModelContext columnNames) {
		wSet(SQLFeatureDescriptorEnum.columnNames, columnNames);
	}

	public SQLModelContext getValues() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.values);
	}

	public void setValues(SQLModelContext values) {
		wSet(SQLFeatureDescriptorEnum.values, values);
	}

	public SQLModelContext getSelect() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.select);
	}

	public void setSelect(SQLModelContext select) {
		wSet(SQLFeatureDescriptorEnum.select, select);
	}

	public SQLModelContext getSetClauses() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.setClauses);
	}

	public void setSetClauses(SQLModelContext setClauses) {
		wSet(SQLFeatureDescriptorEnum.setClauses, setClauses);
	}

	public SQLModelContext getLimit() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.limit);
	}

	public void setLimit(SQLModelContext limit) {
		wSet(SQLFeatureDescriptorEnum.limit, limit);
	}

	public SQLModelContext getDeclarationOrConstraints() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.declarationOrConstraints);
	}

	public void setDeclarationOrConstraints(SQLModelContext declarationOrConstraints) {
		wSet(SQLFeatureDescriptorEnum.declarationOrConstraints, declarationOrConstraints);
	}

	public SQLModelContext getAction() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.action);
	}

	public void setAction(SQLModelContext action) {
		wSet(SQLFeatureDescriptorEnum.action, action);
	}

	public SQLModelContext getUnique() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.unique);
	}

	public void setUnique(SQLModelContext unique) {
		wSet(SQLFeatureDescriptorEnum.unique, unique);
	}

	public SQLModelContext getIndexName() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.indexName);
	}

	public void setIndexName(SQLModelContext indexName) {
		wSet(SQLFeatureDescriptorEnum.indexName, indexName);
	}

	public SQLModelContext getIndexDeclarations() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.indexDeclarations);
	}

	public void setIndexDeclarations(SQLModelContext indexDeclarations) {
		wSet(SQLFeatureDescriptorEnum.indexDeclarations, indexDeclarations);
	}

	public SQLModelContext getColumnName() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.columnName);
	}

	public void setColumnName(SQLModelContext columnName) {
		wSet(SQLFeatureDescriptorEnum.columnName, columnName);
	}

	public SQLModelContext getOrderType() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.orderType);
	}

	public void setOrderType(SQLModelContext orderType) {
		wSet(SQLFeatureDescriptorEnum.orderType, orderType);
	}

	public SQLModelContext getNullOrderType() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.nullOrderType);
	}

	public void setNullOrderType(SQLModelContext nullOrderType) {
		wSet(SQLFeatureDescriptorEnum.nullOrderType, nullOrderType);
	}

	public SQLModelContext getName() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.name);
	}

	public void setName(SQLModelContext name) {
		wSet(SQLFeatureDescriptorEnum.name, name);
	}

	public SQLModelContext getArrayExp() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.arrayExp);
	}

	public void setArrayExp(SQLModelContext arrayExp) {
		wSet(SQLFeatureDescriptorEnum.arrayExp, arrayExp);
	}

	public SQLModelContext getTrueBody() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.trueBody);
	}

	public void setTrueBody(SQLModelContext trueBody) {
		wSet(SQLFeatureDescriptorEnum.trueBody, trueBody);
	}

	public SQLModelContext getDeclarationOrConstraint() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.declarationOrConstraint);
	}

	public void setDeclarationOrConstraint(SQLModelContext declarationOrConstraint) {
		wSet(SQLFeatureDescriptorEnum.declarationOrConstraint, declarationOrConstraint);
	}

	public SQLModelContext getExpression() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.expression);
	}

	public void setExpression(SQLModelContext expression) {
		wSet(SQLFeatureDescriptorEnum.expression, expression);
	}

	public SQLModelContext getAlias() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.alias);
	}

	public void setAlias(SQLModelContext alias) {
		wSet(SQLFeatureDescriptorEnum.alias, alias);
	}

	public SQLModelContext getInnerTable() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.innerTable);
	}

	public void setInnerTable(SQLModelContext innerTable) {
		wSet(SQLFeatureDescriptorEnum.innerTable, innerTable);
	}

	public SQLModelContext getOnExpression() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.onExpression);
	}

	public void setOnExpression(SQLModelContext onExpression) {
		wSet(SQLFeatureDescriptorEnum.onExpression, onExpression);
	}

	public SQLModelContext getOuterTable() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.outerTable);
	}

	public void setOuterTable(SQLModelContext outerTable) {
		wSet(SQLFeatureDescriptorEnum.outerTable, outerTable);
	}

	public SQLModelContext getLowerExpression() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.lowerExpression);
	}

	public void setLowerExpression(SQLModelContext lowerExpression) {
		wSet(SQLFeatureDescriptorEnum.lowerExpression, lowerExpression);
	}

	public SQLModelContext getUpperExpression() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.upperExpression);
	}

	public void setUpperExpression(SQLModelContext upperExpression) {
		wSet(SQLFeatureDescriptorEnum.upperExpression, upperExpression);
	}

	public SQLModelContext getType() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.type);
	}

	public void setType(SQLModelContext type) {
		wSet(SQLFeatureDescriptorEnum.type, type);
	}

	public SQLModelContext getWhenClauses() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.whenClauses);
	}

	public void setWhenClauses(SQLModelContext whenClauses) {
		wSet(SQLFeatureDescriptorEnum.whenClauses, whenClauses);
	}

	public SQLModelContext getElseClause() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.elseClause);
	}

	public void setElseClause(SQLModelContext elseClause) {
		wSet(SQLFeatureDescriptorEnum.elseClause, elseClause);
	}

	public SQLModelContext getCondition() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.condition);
	}

	public void setCondition(SQLModelContext condition) {
		wSet(SQLFeatureDescriptorEnum.condition, condition);
	}

	public SQLModelContext getResult() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.result);
	}

	public void setResult(SQLModelContext result) {
		wSet(SQLFeatureDescriptorEnum.result, result);
	}

	public SQLModelContext getLeftExpr() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.leftExpr);
	}

	public void setLeftExpr(SQLModelContext leftExpr) {
		wSet(SQLFeatureDescriptorEnum.leftExpr, leftExpr);
	}

	public SQLModelContext getInPredicate() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.inPredicate);
	}

	public void setInPredicate(SQLModelContext inPredicate) {
		wSet(SQLFeatureDescriptorEnum.inPredicate, inPredicate);
	}

	public SQLModelContext getQuery() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.query);
	}

	public void setQuery(SQLModelContext query) {
		wSet(SQLFeatureDescriptorEnum.query, query);
	}

	public SQLModelContext getOperator() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.operator);
	}

	public void setOperator(SQLModelContext operator) {
		wSet(SQLFeatureDescriptorEnum.operator, operator);
	}

	public SQLModelContext getRightExpr() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.rightExpr);
	}

	public void setRightExpr(SQLModelContext rightExpr) {
		wSet(SQLFeatureDescriptorEnum.rightExpr, rightExpr);
	}

	public SQLModelContext getFunctionName() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.functionName);
	}

	public void setFunctionName(SQLModelContext functionName) {
		wSet(SQLFeatureDescriptorEnum.functionName, functionName);
	}

	public SQLModelContext getParams() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.params);
	}

	public void setParams(SQLModelContext params) {
		wSet(SQLFeatureDescriptorEnum.params, params);
	}

	public SQLModelContext getColumnType() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.columnType);
	}

	public void setColumnType(SQLModelContext columnType) {
		wSet(SQLFeatureDescriptorEnum.columnType, columnType);
	}

	public SQLModelContext getColumnConstraints() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.columnConstraints);
	}

	public void setColumnConstraints(SQLModelContext columnConstraints) {
		wSet(SQLFeatureDescriptorEnum.columnConstraints, columnConstraints);
	}

	public SQLModelContext getSize() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.size);
	}

	public void setSize(SQLModelContext size) {
		wSet(SQLFeatureDescriptorEnum.size, size);
	}

	public SQLModelContext getPrecision() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.precision);
	}

	public void setPrecision(SQLModelContext precision) {
		wSet(SQLFeatureDescriptorEnum.precision, precision);
	}

	public SQLModelContext getForeignTableName() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.foreignTableName);
	}

	public void setForeignTableName(SQLModelContext foreignTableName) {
		wSet(SQLFeatureDescriptorEnum.foreignTableName, foreignTableName);
	}

	public SQLModelContext getForeignColumnName() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.foreignColumnName);
	}

	public void setForeignColumnName(SQLModelContext foreignColumnName) {
		wSet(SQLFeatureDescriptorEnum.foreignColumnName, foreignColumnName);
	}

	public SQLModelContext getConstraintName() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.constraintName);
	}

	public void setConstraintName(SQLModelContext constraintName) {
		wSet(SQLFeatureDescriptorEnum.constraintName, constraintName);
	}

	public SQLModelContext getForeignColumnNames() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.foreignColumnNames);
	}

	public void setForeignColumnNames(SQLModelContext foreignColumnNames) {
		wSet(SQLFeatureDescriptorEnum.foreignColumnNames, foreignColumnNames);
	}

	public SQLModelContext getMatch() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.match);
	}

	public void setMatch(SQLModelContext match) {
		wSet(SQLFeatureDescriptorEnum.match, match);
	}

	public SQLModelContext getOnDelete() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.onDelete);
	}

	public void setOnDelete(SQLModelContext onDelete) {
		wSet(SQLFeatureDescriptorEnum.onDelete, onDelete);
	}

	public SQLModelContext getOnUpdate() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.onUpdate);
	}

	public void setOnUpdate(SQLModelContext onUpdate) {
		wSet(SQLFeatureDescriptorEnum.onUpdate, onUpdate);
	}

	public SQLModelContext getDeferrable() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.deferrable);
	}

	public void setDeferrable(SQLModelContext deferrable) {
		wSet(SQLFeatureDescriptorEnum.deferrable, deferrable);
	}

	public SQLModelContext getDeferCheck() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.deferCheck);
	}

	public void setDeferCheck(SQLModelContext deferCheck) {
		wSet(SQLFeatureDescriptorEnum.deferCheck, deferCheck);
	}

	public SQLModelContext getProcedureDeclarations() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.procedureDeclarations);
	}

	public void setProcedureDeclarations(SQLModelContext procedureDeclarations) {
		wSet(SQLFeatureDescriptorEnum.procedureDeclarations, procedureDeclarations);
	}

	public SQLModelContext getProcedureStatements() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.procedureStatements);
	}

	public void setProcedureStatements(SQLModelContext procedureStatements) {
		wSet(SQLFeatureDescriptorEnum.procedureStatements, procedureStatements);
	}

	public SQLModelContext getSqlStatement() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.sqlStatement);
	}

	public void setSqlStatement(SQLModelContext sqlStatement) {
		wSet(SQLFeatureDescriptorEnum.sqlStatement, sqlStatement);
	}

	public SQLModelContext getReference() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.reference);
	}

	public void setReference(SQLModelContext reference) {
		wSet(SQLFeatureDescriptorEnum.reference, reference);
	}

	public SQLModelContext getReferenceType() {
		return (SQLModelContext) wGet(SQLFeatureDescriptorEnum.referenceType);
	}

	public void setReferenceType(SQLModelContext referenceType) {
		wSet(SQLFeatureDescriptorEnum.referenceType, referenceType);
	}
}
