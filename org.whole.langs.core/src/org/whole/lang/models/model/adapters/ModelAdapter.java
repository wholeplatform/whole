package org.whole.lang.models.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.models.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ModelAdapter extends AbstractEntityAdapter implements Model {
	private static final long serialVersionUID = 1;

	public ModelAdapter(IEntity implementor) {
		super(implementor);
	}

	public ModelAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Model> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.Model;
	}

	public SimpleName getName() {
		return wGet(ModelsFeatureDescriptorEnum.name).wGetAdapter(
				ModelsEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(ModelsFeatureDescriptorEnum.name, name);
	}

	public TypeRelations getTypeRelations() {
		return wGet(ModelsFeatureDescriptorEnum.typeRelations).wGetAdapter(
				ModelsEntityDescriptorEnum.TypeRelations);
	}

	public void setTypeRelations(TypeRelations typeRelations) {
		wSet(ModelsFeatureDescriptorEnum.typeRelations, typeRelations);
	}

	public ModelDeclarations getDeclarations() {
		return wGet(ModelsFeatureDescriptorEnum.declarations).wGetAdapter(
				ModelsEntityDescriptorEnum.ModelDeclarations);
	}

	public void setDeclarations(ModelDeclarations declarations) {
		wSet(ModelsFeatureDescriptorEnum.declarations, declarations);
	}

	public Namespace getNamespace() {
		return wGet(ModelsFeatureDescriptorEnum.namespace).wGetAdapter(
				ModelsEntityDescriptorEnum.Namespace);
	}

	public void setNamespace(Namespace namespace) {
		wSet(ModelsFeatureDescriptorEnum.namespace, namespace);
	}

	public Version getVersion() {
		return wGet(ModelsFeatureDescriptorEnum.version).wGetAdapter(
				ModelsEntityDescriptorEnum.Version);
	}

	public void setVersion(Version version) {
		wSet(ModelsFeatureDescriptorEnum.version, version);
	}

	public URI getUri() {
		return wGet(ModelsFeatureDescriptorEnum.uri).wGetAdapter(
				ModelsEntityDescriptorEnum.URI);
	}

	public void setUri(URI uri) {
		wSet(ModelsFeatureDescriptorEnum.uri, uri);
	}
}
