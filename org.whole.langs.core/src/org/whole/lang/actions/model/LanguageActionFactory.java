package org.whole.lang.actions.model;

/** 
 * @generator Whole
 */
public interface LanguageActionFactory extends IActionsEntity {
	public URI getUri();

	public void setUri(URI uri);

	public Namespace getNamespace();

	public void setNamespace(Namespace namespace);

	public Name getName();

	public void setName(Name name);

	public Version getVersion();

	public void setVersion(Version version);

	public URI getTargetLanguage();

	public void setTargetLanguage(URI targetLanguage);

	public ToolbarActions getToolbarActions();

	public void setToolbarActions(ToolbarActions toolbarActions);

	public ContextMenuActions getContextMenuActions();

	public void setContextMenuActions(ContextMenuActions contextMenuActions);
}
