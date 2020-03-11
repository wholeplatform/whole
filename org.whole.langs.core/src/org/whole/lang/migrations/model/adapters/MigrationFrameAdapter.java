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
package org.whole.lang.migrations.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.migrations.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.migrations.visitors.IMigrationsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.migrations.reflect.MigrationsEntityDescriptorEnum;
import org.whole.lang.migrations.reflect.MigrationsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class MigrationFrameAdapter extends AbstractEntityAdapter implements MigrationFrame {
    private static final long serialVersionUID = 1;

    public MigrationFrameAdapter(IEntity implementor) {
        super(implementor);
    }

    public MigrationFrameAdapter() {
    }

    public void accept(IMigrationsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<MigrationFrame> wGetEntityDescriptor() {
        return MigrationsEntityDescriptorEnum.MigrationFrame;
    }

    public URI getUri() {
        return wGet(MigrationsFeatureDescriptorEnum.uri).wGetAdapter(MigrationsEntityDescriptorEnum.URI);
    }

    public void setUri(URI uri) {
        wSet(MigrationsFeatureDescriptorEnum.uri, uri);
    }

    public Namespace getNamespace() {
        return wGet(MigrationsFeatureDescriptorEnum.namespace).wGetAdapter(MigrationsEntityDescriptorEnum.Namespace);
    }

    public void setNamespace(Namespace namespace) {
        wSet(MigrationsFeatureDescriptorEnum.namespace, namespace);
    }

    public Name getName() {
        return wGet(MigrationsFeatureDescriptorEnum.name).wGetAdapter(MigrationsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(MigrationsFeatureDescriptorEnum.name, name);
    }

    public Workspace getArtifacts() {
        return wGet(MigrationsFeatureDescriptorEnum.artifacts).wGetAdapter(MigrationsEntityDescriptorEnum.Workspace);
    }

    public void setArtifacts(Workspace artifacts) {
        wSet(MigrationsFeatureDescriptorEnum.artifacts, artifacts);
    }

    public MigrationRules getRules() {
        return wGet(MigrationsFeatureDescriptorEnum.rules).wGetAdapter(MigrationsEntityDescriptorEnum.MigrationRules);
    }

    public void setRules(MigrationRules rules) {
        wSet(MigrationsFeatureDescriptorEnum.rules, rules);
    }
}
