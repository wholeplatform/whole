package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FrameImpl extends AbstractSimpleEntity implements Frame {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Frame> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Frame;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.Frame_ord;
	}

	public void accept(IFramesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private URI uri;

	public URI getUri() {
		return notifyRequested(FramesFeatureDescriptorEnum.uri, uri);
	}

	public void setUri(URI uri) {
		notifyChanged(FramesFeatureDescriptorEnum.uri, this.uri, this.uri = uri);
	}

	private Namespace namespace;

	public Namespace getNamespace() {
		return notifyRequested(FramesFeatureDescriptorEnum.namespace, namespace);
	}

	public void setNamespace(Namespace namespace) {
		notifyChanged(FramesFeatureDescriptorEnum.namespace, this.namespace,
				this.namespace = namespace);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(FramesFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(FramesFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Version version;

	public Version getVersion() {
		return notifyRequested(FramesFeatureDescriptorEnum.version, version);
	}

	public void setVersion(Version version) {
		notifyChanged(FramesFeatureDescriptorEnum.version, this.version,
				this.version = version);
	}

	private Resources imports;

	public Resources getImports() {
		return notifyRequested(FramesFeatureDescriptorEnum.imports, imports);
	}

	public void setImports(Resources imports) {
		notifyChanged(FramesFeatureDescriptorEnum.imports, this.imports,
				this.imports = imports);
	}

	private Features variability;

	public Features getVariability() {
		return notifyRequested(FramesFeatureDescriptorEnum.variability,
				variability);
	}

	public void setVariability(Features variability) {
		notifyChanged(FramesFeatureDescriptorEnum.variability,
				this.variability, this.variability = variability);
	}

	private Relations relations;

	public Relations getRelations() {
		return notifyRequested(FramesFeatureDescriptorEnum.relations, relations);
	}

	public void setRelations(Relations relations) {
		notifyChanged(FramesFeatureDescriptorEnum.relations, this.relations,
				this.relations = relations);
	}

	private Content content;

	public Content getContent() {
		return notifyRequested(FramesFeatureDescriptorEnum.content, content);
	}

	public void setContent(Content content) {
		notifyChanged(FramesFeatureDescriptorEnum.content, this.content,
				this.content = content);
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
			return getImports().wGetAdaptee(false);
		case 5:
			return getVariability().wGetAdaptee(false);
		case 6:
			return getRelations().wGetAdaptee(false);
		case 7:
			return getContent().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setUri(value.wGetAdapter(FramesEntityDescriptorEnum.URI));
			break;
		case 1:
			setNamespace(value
					.wGetAdapter(FramesEntityDescriptorEnum.Namespace));
			break;
		case 2:
			setName(value.wGetAdapter(FramesEntityDescriptorEnum.Name));
			break;
		case 3:
			setVersion(value.wGetAdapter(FramesEntityDescriptorEnum.Version));
			break;
		case 4:
			setImports(value.wGetAdapter(FramesEntityDescriptorEnum.Resources));
			break;
		case 5:
			setVariability(value
					.wGetAdapter(FramesEntityDescriptorEnum.Features));
			break;
		case 6:
			setRelations(value
					.wGetAdapter(FramesEntityDescriptorEnum.Relations));
			break;
		case 7:
			setContent(value.wGetAdapter(FramesEntityDescriptorEnum.Content));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 8;
	}
}
