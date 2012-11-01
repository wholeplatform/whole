package org.whole.lang.properties.model;

/** 
 * @generator Whole
 */
public interface Property extends IPropertiesEntity {
	public PropertyName getName();

	public void setName(PropertyName name);

	public PropertyValue getValue();

	public void setValue(PropertyValue value);
}
