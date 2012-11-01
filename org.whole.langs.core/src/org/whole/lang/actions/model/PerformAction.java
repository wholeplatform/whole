package org.whole.lang.actions.model;

/** 
 * @generator Whole
 */
public interface PerformAction extends IActionsEntity, Action {
	public Icon getIcon();

	public void setIcon(Icon icon);

	public Text getText();

	public void setText(Text text);

	public ActionKind getKind();

	public void setKind(ActionKind kind);

	public Predicate getEnablerPredicate();

	public void setEnablerPredicate(Predicate enablerPredicate);

	public Configuration getConfiguration();

	public void setConfiguration(Configuration configuration);

	public Transformation getTransformation();

	public void setTransformation(Transformation transformation);
}
