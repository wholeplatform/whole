package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface IdentityConstraintDef extends IXsdEntity, NamedComponent,
		Annotated {
	public Selector getSelector();

	public void setSelector(Selector selector);

	public Fields getFields();

	public void setFields(Fields fields);
}
