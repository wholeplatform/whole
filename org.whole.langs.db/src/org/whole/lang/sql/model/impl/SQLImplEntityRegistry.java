package org.whole.lang.sql.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SQLImplEntityRegistry extends AbstractEntityRegistry {
	public SQLImplEntityRegistry() {
		super(SQLEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new SQLStatementsImpl());
		put(new SelectImpl());
		put(new UnionSelectImpl());
		put(new InsertImpl());
		put(new InsertFromSelectImpl());
		put(new UpdateImpl());
		put(new CreateImpl());
		put(new DeleteImpl());
		put(new DropImpl());
		put(new TruncateImpl());
		put(new AlterTableImpl());
		put(new CreateIndexImpl());
		put(new UniqueIndexImpl());
		put(new IndexDeclarationsImpl());
		put(new IndexDeclarationImpl());
		put(new NullOrderTypeImpl());
		put(new DropIndexImpl());
		put(new ForeachImpl());
		put(new AddActionImpl());
		put(new SelectTypeImpl());
		put(new ColumnNamesImpl());
		put(new ColumnExpressionsImpl());
		put(new ColumnExpressionImpl());
		put(new AliasImpl());
		put(new FromClausesImpl());
		put(new SimpleFromClauseImpl());
		put(new InnerJoinFromClauseImpl());
		put(new LeftOuterJoinFromClauseImpl());
		put(new RightOuterJoinFromClauseImpl());
		put(new BetweenImpl());
		put(new NotBetweenImpl());
		put(new IsImpl());
		put(new IsTypeImpl());
		put(new ValuesImpl());
		put(new ParenthesizedExpressionImpl());
		put(new SQLExpressionsImpl());
		put(new NullValueImpl());
		put(new ArrayValueImpl());
		put(new BooleanValueImpl());
		put(new TinyIntValueImpl());
		put(new SmallIntValueImpl());
		put(new IntValueImpl());
		put(new BigIntValueImpl());
		put(new DoubleValueImpl());
		put(new RealValueImpl());
		put(new DecimalValueImpl());
		put(new StringValueImpl());
		put(new BinaryValueImpl());
		put(new DateValueImpl());
		put(new TimeValueImpl());
		put(new TimestampValueImpl());
		put(new BlobValueImpl());
		put(new ClobValueImpl());
		put(new RawValueImpl());
		put(new TableNameImpl());
		put(new ColumnNameImpl());
		put(new IndexNameImpl());
		put(new ConstraintNameImpl());
		put(new CaseExpressionImpl());
		put(new WhenClausesImpl());
		put(new WhenClauseImpl());
		put(new InImpl());
		put(new NotInImpl());
		put(new SubqueryImpl());
		put(new InValueListImpl());
		put(new BinaryExpressionImpl());
		put(new BinaryOperatorImpl());
		put(new BooleanBinaryExpressionImpl());
		put(new BooleanOperatorImpl());
		put(new FunctionExpressionImpl());
		put(new FunctionNameImpl());
		put(new OrderByColumnExpressionsImpl());
		put(new OrderByColumnExpressionImpl());
		put(new OrderTypeImpl());
		put(new SetClausesImpl());
		put(new SetClauseImpl());
		put(new DeclarationOrConstraintsImpl());
		put(new ColumnDeclarationImpl());
		put(new ColumnTypeImpl());
		put(new TypeImpl());
		put(new ColumnConstraintsImpl());
		put(new SimpleColumnConstraintImpl());
		put(new ForeignKeyColumnConstraintImpl());
		put(new UniqueTableConstraintImpl());
		put(new PrimaryKeyTableConstraintImpl());
		put(new ForeignKeyTableConstraintImpl());
		put(new MatchImpl());
		put(new ActionImpl());
		put(new DeferrableImpl());
		put(new DeferCheckImpl());
		put(new StoredProceduresImpl());
		put(new StoredProcedureImpl());
		put(new ProcedureDeclarationsImpl());
		put(new ProcedureStatementsImpl());
		put(new DeclareCursorImpl());
		put(new SimpleVariableDeclarationImpl());
		put(new VariableDeclarationImpl());
		put(new ReferenceImpl());
		put(new ReferenceTypeImpl());
		put(new ArrayExprImpl());
		put(new NameImpl());
	}
}
