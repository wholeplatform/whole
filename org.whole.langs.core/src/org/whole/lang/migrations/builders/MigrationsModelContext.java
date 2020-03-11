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
package org.whole.lang.migrations.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.migrations.reflect.MigrationsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class MigrationsModelContext extends EntityContext {

    public MigrationsModelContext(IEntity root) {
        super(root);
    }

    public MigrationsModelContext getUri() {
        return (MigrationsModelContext) wGet(MigrationsFeatureDescriptorEnum.uri);
    }

    public void setUri(MigrationsModelContext uri) {
        wSet(MigrationsFeatureDescriptorEnum.uri, uri);
    }

    public MigrationsModelContext getNamespace() {
        return (MigrationsModelContext) wGet(MigrationsFeatureDescriptorEnum.namespace);
    }

    public void setNamespace(MigrationsModelContext namespace) {
        wSet(MigrationsFeatureDescriptorEnum.namespace, namespace);
    }

    public MigrationsModelContext getName() {
        return (MigrationsModelContext) wGet(MigrationsFeatureDescriptorEnum.name);
    }

    public void setName(MigrationsModelContext name) {
        wSet(MigrationsFeatureDescriptorEnum.name, name);
    }

    public MigrationsModelContext getArtifacts() {
        return (MigrationsModelContext) wGet(MigrationsFeatureDescriptorEnum.artifacts);
    }

    public void setArtifacts(MigrationsModelContext artifacts) {
        wSet(MigrationsFeatureDescriptorEnum.artifacts, artifacts);
    }

    public MigrationsModelContext getRules() {
        return (MigrationsModelContext) wGet(MigrationsFeatureDescriptorEnum.rules);
    }

    public void setRules(MigrationsModelContext rules) {
        wSet(MigrationsFeatureDescriptorEnum.rules, rules);
    }

    public MigrationsModelContext getFunctions() {
        return (MigrationsModelContext) wGet(MigrationsFeatureDescriptorEnum.functions);
    }

    public void setFunctions(MigrationsModelContext functions) {
        wSet(MigrationsFeatureDescriptorEnum.functions, functions);
    }

    public MigrationsModelContext getLabel() {
        return (MigrationsModelContext) wGet(MigrationsFeatureDescriptorEnum.label);
    }

    public void setLabel(MigrationsModelContext label) {
        wSet(MigrationsFeatureDescriptorEnum.label, label);
    }

    public MigrationsModelContext getSource() {
        return (MigrationsModelContext) wGet(MigrationsFeatureDescriptorEnum.source);
    }

    public void setSource(MigrationsModelContext source) {
        wSet(MigrationsFeatureDescriptorEnum.source, source);
    }

    public MigrationsModelContext getTarget() {
        return (MigrationsModelContext) wGet(MigrationsFeatureDescriptorEnum.target);
    }

    public void setTarget(MigrationsModelContext target) {
        wSet(MigrationsFeatureDescriptorEnum.target, target);
    }

    public MigrationsModelContext getRegistry() {
        return (MigrationsModelContext) wGet(MigrationsFeatureDescriptorEnum.registry);
    }

    public void setRegistry(MigrationsModelContext registry) {
        wSet(MigrationsFeatureDescriptorEnum.registry, registry);
    }

    public MigrationsModelContext getWhen() {
        return (MigrationsModelContext) wGet(MigrationsFeatureDescriptorEnum.when);
    }

    public void setWhen(MigrationsModelContext when) {
        wSet(MigrationsFeatureDescriptorEnum.when, when);
    }

    public MigrationsModelContext getPath() {
        return (MigrationsModelContext) wGet(MigrationsFeatureDescriptorEnum.path);
    }

    public void setPath(MigrationsModelContext path) {
        wSet(MigrationsFeatureDescriptorEnum.path, path);
    }

    public MigrationsModelContext getFeature() {
        return (MigrationsModelContext) wGet(MigrationsFeatureDescriptorEnum.feature);
    }

    public void setFeature(MigrationsModelContext feature) {
        wSet(MigrationsFeatureDescriptorEnum.feature, feature);
    }
}
