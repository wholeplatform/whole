/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.sql.visitors;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;

import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.parsers.SQLDataTypeParser;
import org.whole.lang.sql.reflect.OperatorGroupEnum;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class SQLPrettyPrinterVisitor extends SQLTraverseAllVisitor {
	protected final IPrettyPrintWriter out;
	private String[] constraintArray = new String[] {
			"NULL", "NOT NULL", "PRIMARY KEY", "UNIQUE", "AUTOINCREMENT"};

	public SQLPrettyPrinterVisitor(PrettyPrinterOperation operation) {
    	out = operation.getPrettyPrintWriter();
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false));
		return false;
	}

	@Override
	public void visit(SQLStatements entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			((SQLStatement) entity.wGet(i)).accept(this);
			out.printlnRaw(";");
		}
	}
	public void visit(Insert entity) {
		out.printRaw("INSERT INTO ");
		entity.getTableName().accept(this);
		entity.getColumnNames().accept(this);
		
		out.printRaw(" VALUES ");
		entity.getValues().accept(this);
	}

	public void visit(TableName entity) {
		out.printRaw(entity.getValue());
	}

	public void visit(ColumnName entity) {
		out.printRaw(entity.getValue());
	}

	public void visit(ColumnNames entity) {
		if (!entity.wIsEmpty()) {
			out.printRaw(" (");
			for (int i = 0; i < entity.wSize(); i++) {
				if (i > 0)
					out.print(',');
				((ColumnName) entity.wGet(i)).accept(this);
			}
			out.print(')');
		}
	}
	
	public void visit(Values entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			if (i > 0)
				out.print(',');
			out.print('(');
			((SQLExpressions) entity.wGet(i)).accept(this);
			out.print(')');
		}
	}	

	public void visit(SQLExpressions entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			if (i > 0)
				out.print(',');
			((SQLExpression) entity.wGet(i)).accept(this);
		}
	}

	public void visit(Subquery entity) {
		out.print('(');
		entity.getQuery().accept(this);
		out.print(')');
	}

	public void visit(In entity) {
		entity.getLeftExpr().accept(this);
		out.printRaw(" IN ");
		entity.getInPredicate().accept(this);
	}
	public void visit(NotIn entity) {
		entity.getLeftExpr().accept(this);
		out.printRaw(" NOT IN ");
		entity.getInPredicate().accept(this);
	}
	public void visit(InValueList entity) {
		out.print('(');
		for (int i = 0; i < entity.wSize(); i++) {
			if (i > 0)
				out.print(',');
			((SQLExpression) entity.wGet(i)).accept(this);
		}
		out.print(')');
	}

	public void visit(Between entity) {
		entity.getExpression().accept(this);
		out.printRaw(" BETWEEN ");
		entity.getLowerExpression().accept(this);
		out.printRaw(" AND ");
		entity.getUpperExpression().accept(this);
	}
	public void visit(NotBetween entity) {
		entity.getExpression().accept(this);
		out.printRaw(" NOT BETWEEN ");
		entity.getLowerExpression().accept(this);
		out.printRaw(" AND ");
		entity.getUpperExpression().accept(this);
	}

	public void visit(Is entity) {
		entity.getExpression().accept(this);
		out.printRaw(" IS ");
		entity.getType().accept(this);
	}
	public void visit(IsType entity) {
		out.printRaw(SQLDataTypeParser.instance().unparseEnumValue(
				entity.wGetEntityDescriptor(), entity.getValue()));
	}

	public void visit(NullValue entity) {
		out.printRaw("NULL");
	}

	public void visit(BlobValue entity) {
		out.printRaw("X'");//TODO Oracle "'"
		Blob blob = entity.getValue();
		try {
			out.printRaw(SQLDataTypeParser.instance().unparseObject(
					SQLEntityDescriptorEnum.BinaryValue, blob.getBytes(1l, (int) blob.length()))); //TODO Oracle .toUpperCase());
		} catch (SQLException e) {
		}
		out.print('\'');
	}

	public void visit(ClobValue entity) {
		out.print('\'');
		Clob clob = entity.getValue();
		try {
			out.printRaw(clob.getSubString(1l, (int) clob.length()));
		} catch (SQLException e) {
		}
		out.print('\'');
	}

	public void visit(ArrayValue entity) {
		Object value = entity.getValue();
		assert value.getClass().isArray();
		
		out.printRaw("(");
		out.printRaw(SQLDataTypeParser.instance().unparseObject(
				entity.wGetEntityDescriptor(), entity.getValue()));
		out.printRaw(")");
	}

	public void visit(BooleanValue entity) {
		out.printRaw(SQLDataTypeParser.instance().unparseObject(
				entity.wGetEntityDescriptor(), entity.isValue()));
	}

	public void visit(TinyIntValue entity) {
		out.print(entity.getValue());
	}
	public void visit(SmallIntValue entity) {
		out.print(entity.getValue());
	}
	public void visit(IntValue entity) {
		out.print(entity.getValue());
	}
	public void visit(BigIntValue entity) {
		out.print(entity.getValue());
	}

	public void visit(DoubleValue entity) {
		out.printRaw(SQLDataTypeParser.instance().unparseDouble(
				entity.wGetEntityDescriptor(), entity.getValue()));
	}
	public void visit(RealValue entity) {
		out.printRaw(SQLDataTypeParser.instance().unparseFloat(
				entity.wGetEntityDescriptor(), entity.getValue()));
	}
	public void visit(DecimalValue entity) {
		out.printRaw(SQLDataTypeParser.instance().unparseObject(
				entity.wGetEntityDescriptor(), entity.getValue()));
	}

	public void visit(StringValue entity) {
		out.print('\'');
		out.printRaw(SQLDataTypeParser.instance().unparseString(
				entity.wGetEntityDescriptor(), entity.getValue()));
		out.print('\'');
	}

	public void visit(BinaryValue entity) {
		Object value = entity.getValue();
		assert value.getClass().isArray();

		out.printRaw("X'");//TODO Oracle "'"
		out.printRaw(SQLDataTypeParser.instance().unparseObject(
				entity.wGetEntityDescriptor(), entity.getValue())); //TODO Oracle .toUpperCase());
		out.print('\'');
	}

	public void visit(DateValue entity) {
		out.printRaw("DATE '");
		out.printRaw(SQLDataTypeParser.instance().unparseObject(
				entity.wGetEntityDescriptor(), entity.getValue()));
		out.print('\'');
	}

	public void visit(TimeValue entity) {
		out.printRaw("TIME '");
		out.printRaw(SQLDataTypeParser.instance().unparseObject(
				entity.wGetEntityDescriptor(), entity.getValue()));
		out.print('\'');
	}

	public void visit(TimestampValue entity) {
		out.printRaw("TIMESTAMP '");//TODO DB2 "TIMESTAMP('"
		out.printRaw(SQLDataTypeParser.instance().unparseObject(
				entity.wGetEntityDescriptor(), entity.getValue()));
		out.print('\'');//TODO DB2 "')"
	}

	public void visit(RawValue entity) {
		out.print('\'');
		out.printRaw(SQLDataTypeParser.instance().unparseObject(
				entity.wGetEntityDescriptor(), entity.getValue()));
		out.print('\'');
	}

	public void visit(InsertFromSelect entity) {
		out.printRaw("INSERT INTO ");
		entity.getTableName().accept(this);
		entity.getColumnNames().accept(this);
		out.print(' ');
		entity.getSelect().accept(this);
	}

	public void visit(Select entity) {
		out.printRaw("SELECT ");
		if (EntityUtils.isNotResolver(entity.getSelectType())) {				
			entity.getSelectType().accept(this);
			out.print(' ');
		}
		entity.getColumnExprs().accept(this);
		out.printRaw(" FROM ");
		entity.getFromClauses().accept(this);
		if (EntityUtils.isNotResolver(entity.getWhereExpr())) { 
			out.printRaw(" WHERE ");
			entity.getWhereExpr().accept(this);
		}
		if (EntityUtils.isNotResolver(entity.getGroupByExprs())) {
			out.printRaw(" GROUP BY ");
			entity.getGroupByExprs().accept(this);
		}
		if (EntityUtils.isNotResolver(entity.getHavingExpr())) {		
			out.printRaw(" HAVING ");
			entity.getHavingExpr().accept(this);
		}
		if (EntityUtils.isNotResolver(entity.getOrderByColumnExprs())) {		
			out.printRaw(" ORDER BY ");
			entity.getOrderByColumnExprs().accept(this);
		}
	}

	public void visit(UnionSelect entity) {
		entity.getSimpleSelect().accept(this);
		out.printRaw(" UNION ");
		entity.getUnionSelectStatement().accept(this);
	}
	
	public void visit(SelectType entity) {
		out.print(entity.getValue());
		out.print(' ');
	}

	public void visit(ColumnExpressions entity) {
		if (!entity.wIsEmpty()) {
			for (int i = 0; i < entity.wSize(); i++) {
				if (i > 0)
					out.printRaw(", ");
				((ColumnExpression) entity.wGet(i)).accept(this);
			}
		}		
	}

	public void visit(ColumnExpression entity) {
		entity.getExpression().accept(this);
		entity.getAlias().accept(this);
	}

	public void visit(Alias entity) {
		out.printRaw(" AS ");
		out.printRaw(entity.getValue());
	}

	public void visit(FunctionExpression entity) {
		entity.getFunctionName().accept(this);
		out.print('(');
		entity.getParams().accept(this);
		out.print(')');
	}


	public void visit(FunctionName entity) {
		out.printRaw(entity.getValue());
	}


	public void visit(FromClauses entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.print(',');
			((FromClause) entity.wGet(i)).accept(this);
		}
	}

	public void visit(InnerJoinFromClause entity) {
		entity.getTableName().accept(this);
		out.printRaw(" INNER JOIN ");
		entity.getInnerTable().accept(this);
		out.printRaw(" ON ");
		entity.getOnExpression().accept(this);
	}

	public void visit(LeftOuterJoinFromClause entity) {
		entity.getTableName().accept(this);
		out.printRaw(" LEFT JOIN ");
		entity.getOuterTable().accept(this);
		out.printRaw(" ON ");
		entity.getOnExpression().accept(this);
	}

	public void visit(RightOuterJoinFromClause entity) {
		entity.getTableName().accept(this);
		out.printRaw(" RIGHT JOIN ");
		entity.getOuterTable().accept(this);
		out.printRaw(" ON ");
		entity.getOnExpression().accept(this);
	}

	public void visit(SimpleFromClause entity) {
		out.printRaw(entity.getValue());
	}	

	public void visit(OrderByColumnExpressions entity) {
		if (!entity.wIsEmpty()) {
			for (int i = 0; i < entity.wSize(); i++) {
				if (i > 0)
					out.print(',');
				((OrderByColumnExpression) entity.wGet(i)).accept(this);
			}
		}
	}

	public void visit(OrderByColumnExpression entity) {
		entity.getExpression().accept(this);
		out.print(' ');
		entity.getOrderType().accept(this);
	}

	public void visit(OrderType entity) {
		out.print(entity.getValue());
	}
	
	public void visit(Update entity) {
		out.printRaw("UPDATE ");
		entity.getTableName().accept(this);
		out.printRaw(" SET ");
		entity.getSetClauses().accept(this);
		if (EntityUtils.isNotResolver(entity.getFromClauses())) {
			out.printRaw(" FROM ");
			entity.getFromClauses().accept(this);
		}
		if (EntityUtils.isNotResolver(entity.getWhereExpr())) {
			out.printRaw(" WHERE ");
			entity.getWhereExpr().accept(this);
		}
		if (EntityUtils.isNotResolver(entity.getLimit())) {
			out.printRaw(" LIMIT ");
			entity.getLimit().accept(this); 
		}
	}

	public void visit(SetClauses entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			if (i > 0)
				out.print(',');
			((SetClause) entity.wGet(i)).accept(this);
		}
	}
	
	public void visit(SetClause entity) {
		entity.getColumnName().accept(this);
		out.print('=');
		entity.getExpression().accept(this);
	}

	public void visit(Delete entity) {
		out.printRaw("DELETE FROM ");
		entity.getTableName().accept(this);
		if (EntityUtils.isNotResolver(entity.getWhereExpr())) { 
			out.printRaw(" WHERE ");
			entity.getWhereExpr().accept(this);
		}
		if (EntityUtils.isNotResolver(entity.getLimit())) {
			out.printRaw(" LIMIT ");
			entity.getLimit().accept(this); 
		}
	}

	@Override
	public void visit(ParenthesizedExpression entity) {
		out.print('(');
		entity.getExpression().accept(this);
		out.print(')');
	}

	public void visit(BooleanBinaryExpression entity) {
		SQLExpression leftExpr = entity.getLeftExpr();
		SQLExpression rightExpr = entity.getRightExpr();
		boolean showLeftParen = OperatorGroupEnum.hasPrecedence(entity, leftExpr);
		boolean showRightParen = OperatorGroupEnum.hasPrecedence(entity, rightExpr);

		if (showLeftParen)
			out.printRaw("(");
		leftExpr.accept(this);
		if (showLeftParen)
			out.printRaw(")");

		out.printRaw(" ");
		entity.getOperator().accept(this);
		out.printRaw(" ");

		if (showRightParen)
			out.printRaw("(");
		rightExpr.accept(this);
		if (showRightParen)
			out.printRaw(")");
	}

	public void visit(BooleanOperator entity) {
		out.printRaw(SQLDataTypeParser.instance().unparseEnumValue(entity.wGetEntityDescriptor(), entity.getValue()));
	}

	public void visit(BinaryExpression entity) {
		SQLExpression leftExpr = entity.getLeftExpr();
		SQLExpression rightExpr = entity.getRightExpr();
		boolean showLeftParen = OperatorGroupEnum.hasPrecedence(entity, leftExpr);
		boolean showRightParen = OperatorGroupEnum.hasPrecedence(entity, rightExpr);

		if (showLeftParen)
			out.printRaw("(");
		leftExpr.accept(this);
		if (showLeftParen)
			out.printRaw(")");

		out.printRaw(" ");
		entity.getOperator().accept(this);
		out.printRaw(" ");

		if (showRightParen)
			out.printRaw("(");
		rightExpr.accept(this);
		if (showRightParen)
			out.printRaw(")");
	}

	public void visit(BinaryOperator entity) {
		out.printRaw(SQLDataTypeParser.instance().unparseEnumValue(entity.wGetEntityDescriptor(), entity.getValue()));
	}

	public void visit(CaseExpression entity) {
		out.printRaw("CASE");
		entity.getWhenClauses().accept(this);
		out.printRaw(" ELSE ");
		entity.getElseClause().accept(this);
		out.printRaw(" END");
	}
	public void visit(WhenClause entity) {
		out.printRaw(" WHEN ");
		entity.getCondition().accept(this);
		out.printRaw(" THEN ");
		entity.getResult().accept(this);
	}

	public void visit(Truncate entity) {
		out.printRaw("TRUNCATE ");
		entity.getTableName().accept(this);
	}
	public void visit(Create entity) {
		out.printRaw("CREATE TABLE ");
		entity.getTableName().accept(this);
		out.printRaw(" (");
		entity.getDeclarationOrConstraints().accept(this);
		out.printRaw(") ");
	}

	public void visit(AlterTable entity) {
		out.printRaw("ALTER TABLE ");
		entity.getTableName().accept(this);
		entity.getAction().accept(this);
	}

	@Override
	public void visit(AddAction entity) {
		out.printRaw(" ADD ");
		super.visit(entity);
	}

	public void visit(DeclarationOrConstraints entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw(", ");
			((ISQLEntity) entity.wGet(i)).accept(this);
		}
	}
	public void visit(ColumnDeclaration entity) {
		entity.getColumnName().accept(this);
		out.printRaw(" ");
		entity.getColumnType().accept(this);
		entity.getColumnConstraints().accept(this);
	}
	
	public void visit(ColumnType entity) {
		String typeValue = entity.getType().wStringValue();
		out.printRaw(typeValue);
		if (DataTypeUtils.getDataKind(entity.getSize()).isInt()) {
			out.print('(');
			out.print(entity.getSize().wIntValue());
			if (DataTypeUtils.getDataKind(entity.getPrecision()).isInt()) {
				out.print('(');
				out.print(entity.getPrecision().wIntValue());
				out.print(')');
			}
			out.print(')');
		}
	}

	public void visit(SimpleColumnConstraint entity) {
		out.printRaw(" ");
		out.printRaw(constraintArray[entity.wEnumValue().getOrdinal()]);
	}

	public void visit(PrimaryKeyTableConstraint entity) {
		out.printRaw("PRIMARY KEY ");
		entity.getColumnNames().accept(this);
	}

	public void visit(ForeignKeyTableConstraint entity) {
		out.printRaw("FOREIGN KEY ");
		entity.getColumnNames().accept(this);
		out.printRaw(" REFERENCES ");
		entity.getForeignTableName().accept(this);
		entity.getForeignColumnNames().accept(this);
	}

	public void visit(ForeignKeyColumnConstraint entity) {
		out.printRaw(" REFERENCES ");
		entity.getForeignTableName().accept(this);
		entity.getForeignColumnName().accept(this);
	}

	public void visit(Drop entity) {
		out.printRaw("DROP TABLE ");
		entity.getTableName().accept(this);
	}
}

