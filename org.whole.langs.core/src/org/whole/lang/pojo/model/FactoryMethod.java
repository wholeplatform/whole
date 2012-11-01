package org.whole.lang.pojo.model;

/** 
 * @generator Whole
 */
public interface FactoryMethod extends IPojoEntity {
	public ReferenceType getProductType();

	public void setProductType(ReferenceType productType);

	public Name getProductName();

	public void setProductName(Name productName);

	public Name getTemplate();

	public void setTemplate(Name template);

	public Parameters getParameters();

	public void setParameters(Parameters parameters);
}
