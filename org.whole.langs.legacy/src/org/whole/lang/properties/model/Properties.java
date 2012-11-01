package org.whole.lang.properties.model;

/** 
 * @generator Whole
 */
public interface Properties extends IPropertiesEntity {
	public Comment getComment();

	public void setComment(Comment comment);

	public Properties getDefaults();

	public void setDefaults(Properties defaults);

	public Entries getEntries();

	public void setEntries(Entries entries);
}
