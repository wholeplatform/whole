package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface VariableDeclaration extends ISQLEntity, ProcedureDeclaration {
	public Name getName();

	public void setName(Name name);

	public Reference getReference();

	public void setReference(Reference reference);

	public ReferenceType getReferenceType();

	public void setReferenceType(ReferenceType referenceType);
}
