package org.whole.lang.actions.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.actions.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class LanguageActionFactoryAdapter extends AbstractEntityAdapter
		implements LanguageActionFactory {
	private static final long serialVersionUID = 1;

	public LanguageActionFactoryAdapter(IEntity implementor) {
		super(implementor);
	}

	public LanguageActionFactoryAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LanguageActionFactory> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.LanguageActionFactory;
	}

	public URI getUri() {
		return wGet(ActionsFeatureDescriptorEnum.uri).wGetAdapter(
				ActionsEntityDescriptorEnum.URI);
	}

	public void setUri(URI uri) {
		wSet(ActionsFeatureDescriptorEnum.uri, uri);
	}

	public Namespace getNamespace() {
		return wGet(ActionsFeatureDescriptorEnum.namespace).wGetAdapter(
				ActionsEntityDescriptorEnum.Namespace);
	}

	public void setNamespace(Namespace namespace) {
		wSet(ActionsFeatureDescriptorEnum.namespace, namespace);
	}

	public Name getName() {
		return wGet(ActionsFeatureDescriptorEnum.name).wGetAdapter(
				ActionsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(ActionsFeatureDescriptorEnum.name, name);
	}

	public Version getVersion() {
		return wGet(ActionsFeatureDescriptorEnum.version).wGetAdapter(
				ActionsEntityDescriptorEnum.Version);
	}

	public void setVersion(Version version) {
		wSet(ActionsFeatureDescriptorEnum.version, version);
	}

	public URI getTargetLanguage() {
		return wGet(ActionsFeatureDescriptorEnum.targetLanguage).wGetAdapter(
				ActionsEntityDescriptorEnum.URI);
	}

	public void setTargetLanguage(URI targetLanguage) {
		wSet(ActionsFeatureDescriptorEnum.targetLanguage, targetLanguage);
	}

	public ToolbarActions getToolbarActions() {
		return wGet(ActionsFeatureDescriptorEnum.toolbarActions).wGetAdapter(
				ActionsEntityDescriptorEnum.ToolbarActions);
	}

	public void setToolbarActions(ToolbarActions toolbarActions) {
		wSet(ActionsFeatureDescriptorEnum.toolbarActions, toolbarActions);
	}

	public ContextMenuActions getContextMenuActions() {
		return wGet(ActionsFeatureDescriptorEnum.contextMenuActions)
				.wGetAdapter(ActionsEntityDescriptorEnum.ContextMenuActions);
	}

	public void setContextMenuActions(ContextMenuActions contextMenuActions) {
		wSet(ActionsFeatureDescriptorEnum.contextMenuActions,
				contextMenuActions);
	}
}
