package org.whole.lang.commons.model;

/** 
 * @generator Whole
 */
public interface BaseFragment extends ICommonsEntity, Fragment {
	public Phase getPhase();

	public void setPhase(Phase phase);

	public Any getRootEntity();

	public void setRootEntity(Any rootEntity);
}
