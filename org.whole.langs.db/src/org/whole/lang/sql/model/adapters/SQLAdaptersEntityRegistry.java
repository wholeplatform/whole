package org.whole.lang.sql.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SQLAdaptersEntityRegistry extends AbstractEntityRegistry {
	public SQLAdaptersEntityRegistry() {
		super(SQLEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new SQLStatementsAdapter());
		put(new SelectSQLStatementAdapter());
		put(new SQLStatementAdapter());
		put(new SQLExpressionAdapter());
		put(new FromClauseAdapter());
		put(new SelectAdapter());
		put(new UnionSelectAdapter());
		put(new InsertAdapter());
		put(new InsertFromSelectAdapter());
		put(new UpdateAdapter());
		put(new CreateAdapter());
		put(new DeleteAdapter());
		put(new DropAdapter());
		put(new TruncateAdapter());
		put(new AlterTableAdapter());
		put(new CreateIndexAdapter());
		put(new UniqueIndexAdapter());
		put(new IndexDeclarationsAdapter());
		put(new IndexDeclarationAdapter());
		put(new NullOrderTypeAdapter());
		put(new DropIndexAdapter());
		put(new ForeachAdapter());
		put(new AlterActionAdapter());
		put(new AddActionAdapter());
		put(new SelectTypeAdapter());
		put(new ColumnNamesAdapter());
		put(new ColumnExpressionsAdapter());
		put(new ColumnExpressionAdapter());
		put(new AliasAdapter());
		put(new FromClausesAdapter());
		put(new SimpleFromClauseAdapter());
		put(new InnerJoinFromClauseAdapter());
		put(new LeftOuterJoinFromClauseAdapter());
		put(new RightOuterJoinFromClauseAdapter());
		put(new BetweenAdapter());
		put(new NotBetweenAdapter());
		put(new IsAdapter());
		put(new IsTypeAdapter());
		put(new ValuesAdapter());
		put(new ParenthesizedExpressionAdapter());
		put(new SQLExpressionsAdapter());
		put(new NullValueAdapter());
		put(new ArrayValueAdapter());
		put(new BooleanValueAdapter());
		put(new TinyIntValueAdapter());
		put(new SmallIntValueAdapter());
		put(new IntValueAdapter());
		put(new BigIntValueAdapter());
		put(new DoubleValueAdapter());
		put(new RealValueAdapter());
		put(new DecimalValueAdapter());
		put(new StringValueAdapter());
		put(new BinaryValueAdapter());
		put(new DateValueAdapter());
		put(new TimeValueAdapter());
		put(new TimestampValueAdapter());
		put(new BlobValueAdapter());
		put(new ClobValueAdapter());
		put(new RawValueAdapter());
		put(new TableNameAdapter());
		put(new ColumnNameAdapter());
		put(new IndexNameAdapter());
		put(new CaseExpressionAdapter());
		put(new WhenClausesAdapter());
		put(new WhenClauseAdapter());
		put(new InAdapter());
		put(new NotInAdapter());
		put(new InPredicateAdapter());
		put(new SubqueryAdapter());
		put(new InValueListAdapter());
		put(new BinaryExpressionAdapter());
		put(new BinaryOperatorAdapter());
		put(new BooleanExpressionAdapter());
		put(new BooleanBinaryExpressionAdapter());
		put(new BooleanOperatorAdapter());
		put(new FunctionExpressionAdapter());
		put(new FunctionNameAdapter());
		put(new OrderByColumnExpressionsAdapter());
		put(new OrderByColumnExpressionAdapter());
		put(new OrderTypeAdapter());
		put(new SetClausesAdapter());
		put(new SetClauseAdapter());
		put(new DeclarationOrConstraintsAdapter());
		put(new DeclarationOrConstraintAdapter());
		put(new ColumnDeclarationAdapter());
		put(new ColumnTypeAdapter());
		put(new TypeAdapter());
		put(new ColumnConstraintsAdapter());
		put(new ColumnConstraintAdapter());
		put(new SimpleColumnConstraintAdapter());
		put(new ForeignKeyColumnConstraintAdapter());
		put(new TableConstraintAdapter());
		put(new UniqueTableConstraintAdapter());
		put(new PrimaryKeyTableConstraintAdapter());
		put(new ForeignKeyTableConstraintAdapter());
		put(new MatchAdapter());
		put(new ActionAdapter());
		put(new DeferrableAdapter());
		put(new DeferCheckAdapter());
		put(new StoredProceduresAdapter());
		put(new StoredProcedureAdapter());
		put(new ProcedureDeclarationAdapter());
		put(new ProcedureDeclarationsAdapter());
		put(new ProcedureStatementsAdapter());
		put(new DeclareCursorAdapter());
		put(new SimpleVariableDeclarationAdapter());
		put(new VariableDeclarationAdapter());
		put(new ReferenceAdapter());
		put(new ReferenceTypeAdapter());
		put(new ArrayExprAdapter());
		put(new NameAdapter());
	}
}
