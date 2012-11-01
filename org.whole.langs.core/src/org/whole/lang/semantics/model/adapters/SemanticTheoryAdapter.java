package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class SemanticTheoryAdapter extends AbstractEntityAdapter implements
		SemanticTheory {
	private static final long serialVersionUID = 1;

	public SemanticTheoryAdapter(IEntity implementor) {
		super(implementor);
	}

	public SemanticTheoryAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SemanticTheory> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.SemanticTheory;
	}

	public URI getUri() {
		return wGet(SemanticsFeatureDescriptorEnum.uri).wGetAdapter(
				SemanticsEntityDescriptorEnum.URI);
	}

	public void setUri(URI uri) {
		wSet(SemanticsFeatureDescriptorEnum.uri, uri);
	}

	public Namespace getNamespace() {
		return wGet(SemanticsFeatureDescriptorEnum.namespace).wGetAdapter(
				SemanticsEntityDescriptorEnum.Namespace);
	}

	public void setNamespace(Namespace namespace) {
		wSet(SemanticsFeatureDescriptorEnum.namespace, namespace);
	}

	public Name getName() {
		return wGet(SemanticsFeatureDescriptorEnum.name).wGetAdapter(
				SemanticsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(SemanticsFeatureDescriptorEnum.name, name);
	}

	public Version getVersion() {
		return wGet(SemanticsFeatureDescriptorEnum.version).wGetAdapter(
				SemanticsEntityDescriptorEnum.Version);
	}

	public void setVersion(Version version) {
		wSet(SemanticsFeatureDescriptorEnum.version, version);
	}

	public SemanticFunctions getFunctions() {
		return wGet(SemanticsFeatureDescriptorEnum.functions).wGetAdapter(
				SemanticsEntityDescriptorEnum.SemanticFunctions);
	}

	public void setFunctions(SemanticFunctions functions) {
		wSet(SemanticsFeatureDescriptorEnum.functions, functions);
	}
}
