package org.whole.lang.actions.model;

/** 
 * @generator Whole
 */
public interface ContextMenuActions extends IActionsEntity {
	public MenuActions getSourceMenuActions();

	public void setSourceMenuActions(MenuActions sourceMenuActions);

	public MenuActions getRefactorMenuActions();

	public void setRefactorMenuActions(MenuActions refactorMenuActions);

	public MenuActions getTranslateMenuActions();

	public void setTranslateMenuActions(MenuActions translateMenuActions);

	public MenuActions getAnalyzeMenuActions();

	public void setAnalyzeMenuActions(MenuActions analyzeMenuActions);

	public MenuActions getMigrateMenuActions();

	public void setMigrateMenuActions(MenuActions migrateMenuActions);

	public SimpleAction getValueAssistActions();

	public void setValueAssistActions(SimpleAction valueAssistActions);
}
