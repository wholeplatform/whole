package org.whole.lang.actions.model;

/** 
 * @generator Whole
 */
public interface GroupAction extends IActionsEntity, Action {
	public Icon getIcon();

	public void setIcon(Icon icon);

	public Text getText();

	public void setText(Text text);

	public FillStrategy getFillStrategy();

	public void setFillStrategy(FillStrategy fillStrategy);

	public Actions getActions();

	public void setActions(Actions actions);
}
