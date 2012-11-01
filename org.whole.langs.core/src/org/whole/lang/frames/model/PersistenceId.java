package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface PersistenceId extends IFramesEntity, Persistence {
	public String getValue();

	public void setValue(String value);
}
