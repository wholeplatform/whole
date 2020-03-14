/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.PatternLanguage;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.patterns.model.URI;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.model.Namespace;
import org.whole.lang.patterns.model.Name;
import org.whole.lang.patterns.model.Version;
import org.whole.lang.patterns.model.Patterns;
import org.whole.lang.patterns.model.Declarations;
import org.whole.lang.patterns.model.ContextMenuActions;

/**
 *  @generator Whole
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
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
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
    private ContextMenuActions actions;

    public ContextMenuActions getActions() {
        return notifyRequested(PatternsFeatureDescriptorEnum.actions, actions);
    }

    public void setActions(ContextMenuActions actions) {
        notifyChanged(PatternsFeatureDescriptorEnum.actions, this.actions, this.actions = actions);
    }
    private ContextMenuActions guestActions;

    public ContextMenuActions getGuestActions() {
        return notifyRequested(PatternsFeatureDescriptorEnum.guestActions, guestActions);
    }

    public void setGuestActions(ContextMenuActions guestActions) {
        notifyChanged(PatternsFeatureDescriptorEnum.guestActions, this.guestActions, this.guestActions = guestActions);
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
            case 6 :
            return getActions().wGetAdaptee(false);
            case 7 :
            return getGuestActions().wGetAdaptee(false);
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
            case 6 :
            setActions(value.wGetAdapter(PatternsEntityDescriptorEnum.ContextMenuActions));
            break;
            case 7 :
            setGuestActions(value.wGetAdapter(PatternsEntityDescriptorEnum.ContextMenuActions));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 8;
    }
}
