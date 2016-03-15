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
package org.whole.lang.sql.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.sql.model.Alias;
import org.whole.lang.sql.model.ArrayValue;
import org.whole.lang.sql.model.Between;
import org.whole.lang.sql.model.BigIntValue;
import org.whole.lang.sql.model.BinaryExpression;
import org.whole.lang.sql.model.BinaryOperator;
import org.whole.lang.sql.model.BinaryValue;
import org.whole.lang.sql.model.BlobValue;
import org.whole.lang.sql.model.BooleanBinaryExpression;
import org.whole.lang.sql.model.BooleanOperator;
import org.whole.lang.sql.model.BooleanValue;
import org.whole.lang.sql.model.CaseExpression;
import org.whole.lang.sql.model.ClobValue;
import org.whole.lang.sql.model.ColumnExpression;
import org.whole.lang.sql.model.ColumnExpressions;
import org.whole.lang.sql.model.ColumnName;
import org.whole.lang.sql.model.ColumnNames;
import org.whole.lang.sql.model.DateValue;
import org.whole.lang.sql.model.DecimalValue;
import org.whole.lang.sql.model.Delete;
import org.whole.lang.sql.model.DoubleValue;
import org.whole.lang.sql.model.FromClauses;
import org.whole.lang.sql.model.FunctionExpression;
import org.whole.lang.sql.model.ISQLEntity;
import org.whole.lang.sql.model.In;
import org.whole.lang.sql.model.InValueList;
import org.whole.lang.sql.model.InnerJoinFromClause;
import org.whole.lang.sql.model.Insert;
import org.whole.lang.sql.model.InsertFromSelect;
import org.whole.lang.sql.model.IntValue;
import org.whole.lang.sql.model.Is;
import org.whole.lang.sql.model.IsType;
import org.whole.lang.sql.model.LeftOuterJoinFromClause;
import org.whole.lang.sql.model.NotBetween;
import org.whole.lang.sql.model.NotIn;
import org.whole.lang.sql.model.NullValue;
import org.whole.lang.sql.model.OrderByColumnExpression;
import org.whole.lang.sql.model.OrderByColumnExpressions;
import org.whole.lang.sql.model.OrderType;
import org.whole.lang.sql.model.ParenthesizedExpression;
import org.whole.lang.sql.model.RealValue;
import org.whole.lang.sql.model.RightOuterJoinFromClause;
import org.whole.lang.sql.model.SQLExpressions;
import org.whole.lang.sql.model.SQLStatements;
import org.whole.lang.sql.model.Select;
import org.whole.lang.sql.model.SelectType;
import org.whole.lang.sql.model.SetClause;
import org.whole.lang.sql.model.SetClauses;
import org.whole.lang.sql.model.SimpleFromClause;
import org.whole.lang.sql.model.SmallIntValue;
import org.whole.lang.sql.model.StringValue;
import org.whole.lang.sql.model.Subquery;
import org.whole.lang.sql.model.TableName;
import org.whole.lang.sql.model.TimeValue;
import org.whole.lang.sql.model.TimestampValue;
import org.whole.lang.sql.model.TinyIntValue;
import org.whole.lang.sql.model.Update;
import org.whole.lang.sql.model.WhenClause;
import org.whole.lang.sql.model.WhenClauses;
import org.whole.lang.sql.visitors.SQLIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.CommaSeparatedCompositeFlowPart;
import org.whole.lang.ui.editparts.CompositeColumnWithPlaceholderPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.IdentifierTextualEntityPart;
import org.whole.lang.ui.editparts.KeywordDataEntityPart;
import org.whole.lang.ui.editparts.ContentDataEntityPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;

/** 
 * @author Riccardo Solmi
 */
public class SQLTextualPartFactoryVisitor extends SQLIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((ISQLEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(ISQLEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(SQLStatements entity) {
		part = new CompositeColumnWithPlaceholderPart();
	}

	public void visit(Insert entity) {
		part = new InsertPart();
	}

	public void visit(ColumnNames entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(ColumnName entity) {
		part = new ContentTextualEntityPart();
	}

	public void visit(Alias entity) {
		part = new IdentifierTextualEntityPart();
	}

	public void visit(InsertFromSelect entity) {
		part = new InsertFromSelectPart();
	}

	public void visit(Select entity) {
		part = new SelectPart();
	}

	public void visit(SelectType entity) {
		part = new KeywordDataEntityPart();
	}

	public void visit(ColumnExpressions entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(ColumnExpression entity) {
		part = new ColumnExpressionPart();
	}

	public void visit(FromClauses entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(TableName entity) {
		part = new ContentTextualEntityPart();
	}

	public void visit(SimpleFromClause entity) {
		part = new ContentTextualEntityPart();
	}

	public void visit(InnerJoinFromClause entity) {
		part = new InnerJoinPart();
	}
	public void visit(LeftOuterJoinFromClause entity) {
		part = new LeftOuterJoinPart();
	}
	public void visit(RightOuterJoinFromClause entity) {
		part = new RightOuterJoinPart();
	}

	public void visit(SQLExpressions entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(Subquery entity) {
		part = new SubqueryPart();
	}

	public void visit(In entity) {
		part = new InPart();
	}
	public void visit(NotIn entity) {
		part = new NotInPart();
	}
	public void visit(InValueList entity) {
		part = new InValueListPart();
	}

	public void visit(Between entity) {
		part = new BetweenPart();
	}
	public void visit(NotBetween entity) {
		part = new NotBetweenPart();
	}

	public void visit(Is entity) {
		part = new IsPart();
	}
	public void visit(IsType entity) {
		part = new KeywordDataEntityPart();
	}

	public void visit(NullValue entity) {
		part = new NullValuePart();
	}

	public void visit(BlobValue entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	public void visit(ClobValue entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	public void visit(ArrayValue entity) {
		part = new ArrayValuePart();
	}

	public void visit(BooleanValue entity) {
		part = new ContentDataEntityPart();
	}

	public void visit(TinyIntValue entity) {
		part = new ContentDataEntityPart();
	}
	public void visit(SmallIntValue entity) {
		part = new ContentDataEntityPart();
	}
	public void visit(IntValue entity) {
		part = new ContentDataEntityPart();
	}
	public void visit(BigIntValue entity) {
		part = new ContentDataEntityPart();
	}

	public void visit(DoubleValue entity) {
		part = new ContentDataEntityPart();
	}
	public void visit(RealValue entity) {
		part = new ContentDataEntityPart();
	}
	public void visit(DecimalValue entity) {
		part = new ContentDataEntityPart();
	}

	public void visit(StringValue entity) {
		part = new StringValuePart();
	}

	public void visit(BinaryValue entity) {
		part = new BinaryValuePart();
	}

	public void visit(DateValue entity) {
		part = new DateValuePart();
	}
	public void visit(TimeValue entity) {
		part = new TimeValuePart();
	}
	public void visit(TimestampValue entity) {
		part = new TimestampValuePart();
	}

	public void visit(BooleanBinaryExpression entity) {
		part = new BinaryExpressionPart();
	}

	public void visit(BooleanOperator entity) {
		part = new KeywordDataEntityPart();
	}

	public void visit(ParenthesizedExpression entity) {
		part = new ParenthesizedExpressionPart();
	}

	public void visit(BinaryExpression entity) {
		part = new BinaryExpressionPart();
	}

	public void visit(BinaryOperator entity) {
		part = new KeywordDataEntityPart();
	}

	public void visit(FunctionExpression entity) {
		part = new FunctionExpressionPart();
	}

	public void visit(OrderByColumnExpressions entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(OrderByColumnExpression entity) {
		part = new OrderByColumnExpressionPart();
	}

	public void visit(OrderType entity) {
		part = new KeywordDataEntityPart();
	}

	public void visit(Update entity) {
		part = new UpdatePart();
	}

	public void visit(SetClauses entity) {
		part = new CompositeColumnWithPlaceholderPart();
	}

	public void visit(SetClause entity) {
		part = new SetClausePart();
	}

	public void visit(Delete entity) {
		part = new DeletePart();
	}

	public void visit(CaseExpression entity) {
		part = new CaseExpressionPart();
	}

	public void visit(WhenClauses entity) {
		part = new CompositeColumnWithPlaceholderPart();
	}

	public void visit(WhenClause entity) {
		part = new WhenClausePart();
	}
}
