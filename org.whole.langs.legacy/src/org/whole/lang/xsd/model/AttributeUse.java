package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface AttributeUse extends IXsdEntity, AttributeUseOrGroup {
	public Use getUse();

	public void setUse(Use use);

	public Qualify getForm();

	public void setForm(Qualify form);
}
