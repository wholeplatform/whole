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
package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class PatternLanguageAdapter extends AbstractEntityAdapter implements PatternLanguage {
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

    public Patterns getPatterns() {
        return wGet(PatternsFeatureDescriptorEnum.patterns).wGetAdapter(PatternsEntityDescriptorEnum.Patterns);
    }

    public void setPatterns(Patterns patterns) {
        wSet(PatternsFeatureDescriptorEnum.patterns, patterns);
    }

    public Declarations getDeclarations() {
        return wGet(PatternsFeatureDescriptorEnum.declarations).wGetAdapter(PatternsEntityDescriptorEnum.Declarations);
    }

    public void setDeclarations(Declarations declarations) {
        wSet(PatternsFeatureDescriptorEnum.declarations, declarations);
    }

    public ContextMenuActions getActions() {
        return wGet(PatternsFeatureDescriptorEnum.actions).wGetAdapter(PatternsEntityDescriptorEnum.ContextMenuActions);
    }

    public void setActions(ContextMenuActions actions) {
        wSet(PatternsFeatureDescriptorEnum.actions, actions);
    }

    public ContextMenuActions getGuestActions() {
        return wGet(PatternsFeatureDescriptorEnum.guestActions).wGetAdapter(PatternsEntityDescriptorEnum.ContextMenuActions);
    }

    public void setGuestActions(ContextMenuActions guestActions) {
        wSet(PatternsFeatureDescriptorEnum.guestActions, guestActions);
    }
}
