package org.whole.lang.actions.model;

/** 
 * @generator Whole
 */
public interface Hierarchical extends IActionsEntity, FillStrategy {
	public NamingStrategy getNamingStrategy();

	public void setNamingStrategy(NamingStrategy namingStrategy);

	public Size getSplitSize();

	public void setSplitSize(Size splitSize);
}
