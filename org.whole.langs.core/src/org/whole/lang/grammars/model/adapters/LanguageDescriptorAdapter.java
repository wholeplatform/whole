package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class LanguageDescriptorAdapter extends AbstractEntityAdapter implements
		LanguageDescriptor {
	private static final long serialVersionUID = 1;

	public LanguageDescriptorAdapter(IEntity implementor) {
		super(implementor);
	}

	public LanguageDescriptorAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LanguageDescriptor> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.LanguageDescriptor;
	}

	public URI getUri() {
		return wGet(GrammarsFeatureDescriptorEnum.uri).wGetAdapter(
				GrammarsEntityDescriptorEnum.URI);
	}

	public void setUri(URI uri) {
		wSet(GrammarsFeatureDescriptorEnum.uri, uri);
	}

	public Namespace getNamespace() {
		return wGet(GrammarsFeatureDescriptorEnum.namespace).wGetAdapter(
				GrammarsEntityDescriptorEnum.Namespace);
	}

	public void setNamespace(Namespace namespace) {
		wSet(GrammarsFeatureDescriptorEnum.namespace, namespace);
	}

	public Name getName() {
		return wGet(GrammarsFeatureDescriptorEnum.name).wGetAdapter(
				GrammarsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(GrammarsFeatureDescriptorEnum.name, name);
	}

	public Version getVersion() {
		return wGet(GrammarsFeatureDescriptorEnum.version).wGetAdapter(
				GrammarsEntityDescriptorEnum.Version);
	}

	public void setVersion(Version version) {
		wSet(GrammarsFeatureDescriptorEnum.version, version);
	}
}
