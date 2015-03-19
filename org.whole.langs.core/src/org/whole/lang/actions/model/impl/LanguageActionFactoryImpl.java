package org.whole.lang.actions.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.actions.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class LanguageActionFactoryImpl extends AbstractSimpleEntity implements
		LanguageActionFactory {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LanguageActionFactory> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.LanguageActionFactory;
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.LanguageActionFactory_ord;
	}

	public void accept(IActionsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private URI uri;

	public URI getUri() {
		return notifyRequested(ActionsFeatureDescriptorEnum.uri, uri);
	}

	public void setUri(URI uri) {
		notifyChanged(ActionsFeatureDescriptorEnum.uri, this.uri,
				this.uri = uri);
	}

	private Namespace namespace;

	public Namespace getNamespace() {
		return notifyRequested(ActionsFeatureDescriptorEnum.namespace,
				namespace);
	}

	public void setNamespace(Namespace namespace) {
		notifyChanged(ActionsFeatureDescriptorEnum.namespace, this.namespace,
				this.namespace = namespace);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(ActionsFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(ActionsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Version version;

	public Version getVersion() {
		return notifyRequested(ActionsFeatureDescriptorEnum.version, version);
	}

	public void setVersion(Version version) {
		notifyChanged(ActionsFeatureDescriptorEnum.version, this.version,
				this.version = version);
	}

	private URI targetLanguage;

	public URI getTargetLanguage() {
		return notifyRequested(ActionsFeatureDescriptorEnum.targetLanguage,
				targetLanguage);
	}

	public void setTargetLanguage(URI targetLanguage) {
		notifyChanged(ActionsFeatureDescriptorEnum.targetLanguage,
				this.targetLanguage, this.targetLanguage = targetLanguage);
	}

	private ToolbarActions toolbarActions;

	public ToolbarActions getToolbarActions() {
		return notifyRequested(ActionsFeatureDescriptorEnum.toolbarActions,
				toolbarActions);
	}

	public void setToolbarActions(ToolbarActions toolbarActions) {
		notifyChanged(ActionsFeatureDescriptorEnum.toolbarActions,
				this.toolbarActions, this.toolbarActions = toolbarActions);
	}

	private ContextMenuActions contextMenuActions;

	public ContextMenuActions getContextMenuActions() {
		return notifyRequested(ActionsFeatureDescriptorEnum.contextMenuActions,
				contextMenuActions);
	}

	public void setContextMenuActions(ContextMenuActions contextMenuActions) {
		notifyChanged(ActionsFeatureDescriptorEnum.contextMenuActions,
				this.contextMenuActions,
				this.contextMenuActions = contextMenuActions);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getUri().wGetAdaptee(false);
		case 1:
			return getNamespace().wGetAdaptee(false);
		case 2:
			return getName().wGetAdaptee(false);
		case 3:
			return getVersion().wGetAdaptee(false);
		case 4:
			return getTargetLanguage().wGetAdaptee(false);
		case 5:
			return getToolbarActions().wGetAdaptee(false);
		case 6:
			return getContextMenuActions().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setUri(value.wGetAdapter(ActionsEntityDescriptorEnum.URI));
			break;
		case 1:
			setNamespace(value
					.wGetAdapter(ActionsEntityDescriptorEnum.Namespace));
			break;
		case 2:
			setName(value.wGetAdapter(ActionsEntityDescriptorEnum.Name));
			break;
		case 3:
			setVersion(value.wGetAdapter(ActionsEntityDescriptorEnum.Version));
			break;
		case 4:
			setTargetLanguage(value
					.wGetAdapter(ActionsEntityDescriptorEnum.URI));
			break;
		case 5:
			setToolbarActions(value
					.wGetAdapter(ActionsEntityDescriptorEnum.ToolbarActions));
			break;
		case 6:
			setContextMenuActions(value
					.wGetAdapter(ActionsEntityDescriptorEnum.ContextMenuActions));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 7;
	}
}
