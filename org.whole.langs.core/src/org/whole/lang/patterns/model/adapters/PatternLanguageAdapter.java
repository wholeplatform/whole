package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class PatternLanguageAdapter extends AbstractEntityAdapter implements
		PatternLanguage {
	private static final long serialVersionUID = 1;

	public PatternLanguageAdapter(IEntity implementor) {
		super(implementor);
	}

	public PatternLanguageAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PatternLanguage> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.PatternLanguage;
	}

	public URI getUri() {
		return wGet(PatternsFeatureDescriptorEnum.uri).wGetAdapter(
				PatternsEntityDescriptorEnum.URI);
	}

	public void setUri(URI uri) {
		wSet(PatternsFeatureDescriptorEnum.uri, uri);
	}

	public Namespace getNamespace() {
		return wGet(PatternsFeatureDescriptorEnum.namespace).wGetAdapter(
				PatternsEntityDescriptorEnum.Namespace);
	}

	public void setNamespace(Namespace namespace) {
		wSet(PatternsFeatureDescriptorEnum.namespace, namespace);
	}

	public Name getName() {
		return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(
				PatternsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(PatternsFeatureDescriptorEnum.name, name);
	}

	public Version getVersion() {
		return wGet(PatternsFeatureDescriptorEnum.version).wGetAdapter(
				PatternsEntityDescriptorEnum.Version);
	}

	public void setVersion(Version version) {
		wSet(PatternsFeatureDescriptorEnum.version, version);
	}

	public Patterns getPatterns() {
		return wGet(PatternsFeatureDescriptorEnum.patterns).wGetAdapter(
				PatternsEntityDescriptorEnum.Patterns);
	}

	public void setPatterns(Patterns patterns) {
		wSet(PatternsFeatureDescriptorEnum.patterns, patterns);
	}
}
