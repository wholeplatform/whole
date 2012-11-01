package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface TypeDef extends IXsdEntity, NamedComponent, SchemaComponent,
		RedefineComponent {
	public Name getName();

	public void setName(Name name);

	public DerivationSet getFinal();

	public void setFinal(DerivationSet _final);
}
