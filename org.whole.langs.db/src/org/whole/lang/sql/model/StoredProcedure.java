package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface StoredProcedure extends ISQLEntity {
	public Name getName();

	public void setName(Name name);

	public ProcedureDeclarations getProcedureDeclarations();

	public void setProcedureDeclarations(ProcedureDeclarations procedureDeclarations);

	public ProcedureStatements getProcedureStatements();

	public void setProcedureStatements(ProcedureStatements procedureStatements);
}
