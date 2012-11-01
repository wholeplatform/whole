package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface Theory extends IFirstOrderLogicEntity {
	public Name getName();

	public void setName(Name name);

	public ImportTheories getImports();

	public void setImports(ImportTheories imports);

	public Declarations getDeclarations();

	public void setDeclarations(Declarations declarations);

	public Assertions getAssertions();

	public void setAssertions(Assertions assertions);
}
