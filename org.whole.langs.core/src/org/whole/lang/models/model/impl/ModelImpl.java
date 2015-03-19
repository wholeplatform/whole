package org.whole.lang.models.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.models.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ModelImpl extends AbstractSimpleEntity implements Model {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Model> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.Model;
	}

	public int wGetEntityOrd() {
		return ModelsEntityDescriptorEnum.Model_ord;
	}

	public void accept(IModelsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(ModelsFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(ModelsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private TypeRelations typeRelations;

	public TypeRelations getTypeRelations() {
		return notifyRequested(ModelsFeatureDescriptorEnum.typeRelations,
				typeRelations);
	}

	public void setTypeRelations(TypeRelations typeRelations) {
		notifyChanged(ModelsFeatureDescriptorEnum.typeRelations,
				this.typeRelations, this.typeRelations = typeRelations);
	}

	private ModelDeclarations declarations;

	public ModelDeclarations getDeclarations() {
		return notifyRequested(ModelsFeatureDescriptorEnum.declarations,
				declarations);
	}

	public void setDeclarations(ModelDeclarations declarations) {
		notifyChanged(ModelsFeatureDescriptorEnum.declarations,
				this.declarations, this.declarations = declarations);
	}

	private Namespace namespace;

	public Namespace getNamespace() {
		return notifyRequested(ModelsFeatureDescriptorEnum.namespace, namespace);
	}

	public void setNamespace(Namespace namespace) {
		notifyChanged(ModelsFeatureDescriptorEnum.namespace, this.namespace,
				this.namespace = namespace);
	}

	private Version version;

	public Version getVersion() {
		return notifyRequested(ModelsFeatureDescriptorEnum.version, version);
	}

	public void setVersion(Version version) {
		notifyChanged(ModelsFeatureDescriptorEnum.version, this.version,
				this.version = version);
	}

	private URI uri;

	public URI getUri() {
		return notifyRequested(ModelsFeatureDescriptorEnum.uri, uri);
	}

	public void setUri(URI uri) {
		notifyChanged(ModelsFeatureDescriptorEnum.uri, this.uri, this.uri = uri);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getTypeRelations().wGetAdaptee(false);
		case 2:
			return getDeclarations().wGetAdaptee(false);
		case 3:
			return getNamespace().wGetAdaptee(false);
		case 4:
			return getVersion().wGetAdaptee(false);
		case 5:
			return getUri().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(ModelsEntityDescriptorEnum.SimpleName));
			break;
		case 1:
			setTypeRelations(value
					.wGetAdapter(ModelsEntityDescriptorEnum.TypeRelations));
			break;
		case 2:
			setDeclarations(value
					.wGetAdapter(ModelsEntityDescriptorEnum.ModelDeclarations));
			break;
		case 3:
			setNamespace(value
					.wGetAdapter(ModelsEntityDescriptorEnum.Namespace));
			break;
		case 4:
			setVersion(value.wGetAdapter(ModelsEntityDescriptorEnum.Version));
			break;
		case 5:
			setUri(value.wGetAdapter(ModelsEntityDescriptorEnum.URI));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
