package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class LibraryAdapter extends AbstractEntityAdapter implements Library {
    private static final long serialVersionUID = 1;

    public LibraryAdapter(IEntity implementor) {
        super(implementor);
    }

    public LibraryAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Library> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Library;
    }

    public URI getUri() {
        return wGet(PatternsFeatureDescriptorEnum.uri).wGetAdapter(PatternsEntityDescriptorEnum.URI);
    }

    public void setUri(URI uri) {
        wSet(PatternsFeatureDescriptorEnum.uri, uri);
    }

    public Namespace getNamespace() {
        return wGet(PatternsFeatureDescriptorEnum.namespace).wGetAdapter(PatternsEntityDescriptorEnum.Namespace);
    }

    public void setNamespace(Namespace namespace) {
        wSet(PatternsFeatureDescriptorEnum.namespace, namespace);
    }

    public Name getName() {
        return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public Version getVersion() {
        return wGet(PatternsFeatureDescriptorEnum.version).wGetAdapter(PatternsEntityDescriptorEnum.Version);
    }

    public void setVersion(Version version) {
        wSet(PatternsFeatureDescriptorEnum.version, version);
    }

    public Declarations getDeclarations() {
        return wGet(PatternsFeatureDescriptorEnum.declarations).wGetAdapter(PatternsEntityDescriptorEnum.Declarations);
    }

    public void setDeclarations(Declarations declarations) {
        wSet(PatternsFeatureDescriptorEnum.declarations, declarations);
    }
}
