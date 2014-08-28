package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class PatternLanguageImpl extends AbstractSimpleEntity implements PatternLanguage {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PatternLanguage> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.PatternLanguage;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.PatternLanguage_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }
    private URI uri;

    public URI getUri() {
        return notifyRequested(PatternsFeatureDescriptorEnum.uri, uri);
    }

    public void setUri(URI uri) {
        notifyChanged(PatternsFeatureDescriptorEnum.uri, this.uri, this.uri = uri);
    }
    private Namespace namespace;

    public Namespace getNamespace() {
        return notifyRequested(PatternsFeatureDescriptorEnum.namespace, namespace);
    }

    public void setNamespace(Namespace namespace) {
        notifyChanged(PatternsFeatureDescriptorEnum.namespace, this.namespace, this.namespace = namespace);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(PatternsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(PatternsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Version version;

    public Version getVersion() {
        return notifyRequested(PatternsFeatureDescriptorEnum.version, version);
    }

    public void setVersion(Version version) {
        notifyChanged(PatternsFeatureDescriptorEnum.version, this.version, this.version = version);
    }
    private Patterns patterns;

    public Patterns getPatterns() {
        return notifyRequested(PatternsFeatureDescriptorEnum.patterns, patterns);
    }

    public void setPatterns(Patterns patterns) {
        notifyChanged(PatternsFeatureDescriptorEnum.patterns, this.patterns, this.patterns = patterns);
    }
    private Declarations declarations;

    public Declarations getDeclarations() {
        return notifyRequested(PatternsFeatureDescriptorEnum.declarations, declarations);
    }

    public void setDeclarations(Declarations declarations) {
        notifyChanged(PatternsFeatureDescriptorEnum.declarations, this.declarations, this.declarations = declarations);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getUri().wGetAdaptee(false);
            case 1 :
            return getNamespace().wGetAdaptee(false);
            case 2 :
            return getName().wGetAdaptee(false);
            case 3 :
            return getVersion().wGetAdaptee(false);
            case 4 :
            return getPatterns().wGetAdaptee(false);
            case 5 :
            return getDeclarations().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setUri(value.wGetAdapter(PatternsEntityDescriptorEnum.URI));
            break;
            case 1 :
            setNamespace(value.wGetAdapter(PatternsEntityDescriptorEnum.Namespace));
            break;
            case 2 :
            setName(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            case 3 :
            setVersion(value.wGetAdapter(PatternsEntityDescriptorEnum.Version));
            break;
            case 4 :
            setPatterns(value.wGetAdapter(PatternsEntityDescriptorEnum.Patterns));
            break;
            case 5 :
            setDeclarations(value.wGetAdapter(PatternsEntityDescriptorEnum.Declarations));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 6;
    }
}
