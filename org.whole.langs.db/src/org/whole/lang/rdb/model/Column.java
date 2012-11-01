package org.whole.lang.rdb.model;

/** 
 * @generator Whole
 */
public interface Column extends IRDBEntity {
	public StringData getName();

	public void setName(StringData name);

	public Name getFeatureName();

	public void setFeatureName(Name featureName);

	public Name getFeatureType();

	public void setFeatureType(Name featureType);

	public Type getType();

	public void setType(Type type);

	public IntData getSize();

	public void setSize(IntData size);

	public IntData getDecimals();

	public void setDecimals(IntData decimals);

	public BooleanData getNullable();

	public void setNullable(BooleanData nullable);

	public StringData getDefaultValue();

	public void setDefaultValue(StringData defaultValue);

	public StringData getRemarks();

	public void setRemarks(StringData remarks);
}
