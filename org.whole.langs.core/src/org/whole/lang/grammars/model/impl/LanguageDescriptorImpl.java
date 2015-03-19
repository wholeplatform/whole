package org.whole.lang.grammars.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.grammars.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class LanguageDescriptorImpl extends AbstractSimpleEntity implements
		LanguageDescriptor {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LanguageDescriptor> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.LanguageDescriptor;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.LanguageDescriptor_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private URI uri;

	public URI getUri() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.uri, uri);
	}

	public void setUri(URI uri) {
		notifyChanged(GrammarsFeatureDescriptorEnum.uri, this.uri,
				this.uri = uri);
	}

	private Namespace namespace;

	public Namespace getNamespace() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.namespace,
				namespace);
	}

	public void setNamespace(Namespace namespace) {
		notifyChanged(GrammarsFeatureDescriptorEnum.namespace, this.namespace,
				this.namespace = namespace);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(GrammarsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Version version;

	public Version getVersion() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.version, version);
	}

	public void setVersion(Version version) {
		notifyChanged(GrammarsFeatureDescriptorEnum.version, this.version,
				this.version = version);
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
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setUri(value.wGetAdapter(GrammarsEntityDescriptorEnum.URI));
			break;
		case 1:
			setNamespace(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.Namespace));
			break;
		case 2:
			setName(value.wGetAdapter(GrammarsEntityDescriptorEnum.Name));
			break;
		case 3:
			setVersion(value.wGetAdapter(GrammarsEntityDescriptorEnum.Version));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
