package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FrameAdapter extends AbstractEntityAdapter implements Frame {
	private static final long serialVersionUID = 1;

	public FrameAdapter(IEntity implementor) {
		super(implementor);
	}

	public FrameAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Frame> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Frame;
	}

	public URI getUri() {
		return wGet(FramesFeatureDescriptorEnum.uri).wGetAdapter(
				FramesEntityDescriptorEnum.URI);
	}

	public void setUri(URI uri) {
		wSet(FramesFeatureDescriptorEnum.uri, uri);
	}

	public Namespace getNamespace() {
		return wGet(FramesFeatureDescriptorEnum.namespace).wGetAdapter(
				FramesEntityDescriptorEnum.Namespace);
	}

	public void setNamespace(Namespace namespace) {
		wSet(FramesFeatureDescriptorEnum.namespace, namespace);
	}

	public Name getName() {
		return wGet(FramesFeatureDescriptorEnum.name).wGetAdapter(
				FramesEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(FramesFeatureDescriptorEnum.name, name);
	}

	public Version getVersion() {
		return wGet(FramesFeatureDescriptorEnum.version).wGetAdapter(
				FramesEntityDescriptorEnum.Version);
	}

	public void setVersion(Version version) {
		wSet(FramesFeatureDescriptorEnum.version, version);
	}

	public Resources getImports() {
		return wGet(FramesFeatureDescriptorEnum.imports).wGetAdapter(
				FramesEntityDescriptorEnum.Resources);
	}

	public void setImports(Resources imports) {
		wSet(FramesFeatureDescriptorEnum.imports, imports);
	}

	public Features getVariability() {
		return wGet(FramesFeatureDescriptorEnum.variability).wGetAdapter(
				FramesEntityDescriptorEnum.Features);
	}

	public void setVariability(Features variability) {
		wSet(FramesFeatureDescriptorEnum.variability, variability);
	}

	public Relations getRelations() {
		return wGet(FramesFeatureDescriptorEnum.relations).wGetAdapter(
				FramesEntityDescriptorEnum.Relations);
	}

	public void setRelations(Relations relations) {
		wSet(FramesFeatureDescriptorEnum.relations, relations);
	}

	public Content getContent() {
		return wGet(FramesFeatureDescriptorEnum.content).wGetAdapter(
				FramesEntityDescriptorEnum.Content);
	}

	public void setContent(Content content) {
		wSet(FramesFeatureDescriptorEnum.content, content);
	}
}
