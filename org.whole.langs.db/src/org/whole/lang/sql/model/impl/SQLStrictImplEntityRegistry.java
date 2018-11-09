package org.whole.lang.sql.model.impl;

/** 
 * @generator Whole
 */
public class SQLStrictImplEntityRegistry extends SQLImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new IndexDeclarationsStrictImpl());
		put(new ColumnNamesStrictImpl());
		put(new ColumnExpressionsStrictImpl());
		put(new FromClausesStrictImpl());
		put(new SetClausesStrictImpl());
		put(new DeclarationOrConstraintsStrictImpl());
		put(new ColumnConstraintsStrictImpl());
		put(new StoredProceduresStrictImpl());
		put(new ProcedureDeclarationsStrictImpl());
		put(new ProcedureStatementsStrictImpl());
	}
}
