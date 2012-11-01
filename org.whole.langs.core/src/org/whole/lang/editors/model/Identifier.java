package org.whole.lang.editors.model;

/** 
 * @generator Whole
 */
public interface Identifier extends IEditorsEntity, EditorName, ModelName,
		EntityName, FeatureName, FigureName, PartName {
	public String getValue();

	public void setValue(String value);
}
