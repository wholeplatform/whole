package org.whole.lang.grammars.model;

/** 
 * @generator Whole
 */
public interface DataType extends IGrammarsEntity, Template {
	public org.whole.lang.grammars.model.DataTypeEnum.Value getValue();

	public void setValue(org.whole.lang.grammars.model.DataTypeEnum.Value value);
}
