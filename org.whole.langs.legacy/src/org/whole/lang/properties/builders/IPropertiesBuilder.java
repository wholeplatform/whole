package org.whole.lang.properties.builders;

import org.whole.lang.builders.IBuilder;

/** 
 * @generator Whole
 */
public interface IPropertiesBuilder extends IBuilder {
	public void visit();

	public void value();

	public void name();

	public void entries();

	public void defaults();

	public void comment();

	public void Properties();

	public void Properties_();

	public void _Properties();

	public void Entries();

	public void Entries_();

	public void Entries_(int initialCapacity);

	public void _Entries();

	public void Property();

	public void Property_();

	public void _Property();

	public void Comment();

	public void Comment(String value);

	public void PropertyName();

	public void PropertyName(String value);

	public void PropertyValue();

	public void PropertyValue(String value);
}
