/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.patterns.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class PatternsModelContext extends EntityContext {

    public PatternsModelContext(IEntity root) {
        super(root);
    }

    public PatternsModelContext getUri() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.uri);
    }

    public void setUri(PatternsModelContext uri) {
        wSet(PatternsFeatureDescriptorEnum.uri, uri);
    }

    public PatternsModelContext getNamespace() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.namespace);
    }

    public void setNamespace(PatternsModelContext namespace) {
        wSet(PatternsFeatureDescriptorEnum.namespace, namespace);
    }

    public PatternsModelContext getName() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.name);
    }

    public void setName(PatternsModelContext name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public PatternsModelContext getVersion() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.version);
    }

    public void setVersion(PatternsModelContext version) {
        wSet(PatternsFeatureDescriptorEnum.version, version);
    }

    public PatternsModelContext getPatterns() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.patterns);
    }

    public void setPatterns(PatternsModelContext patterns) {
        wSet(PatternsFeatureDescriptorEnum.patterns, patterns);
    }

    public PatternsModelContext getDeclarations() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.declarations);
    }

    public void setDeclarations(PatternsModelContext declarations) {
        wSet(PatternsFeatureDescriptorEnum.declarations, declarations);
    }

    public PatternsModelContext getResultTypes() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.resultTypes);
    }

    public void setResultTypes(PatternsModelContext resultTypes) {
        wSet(PatternsFeatureDescriptorEnum.resultTypes, resultTypes);
    }

    public PatternsModelContext getTemplate() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.template);
    }

    public void setTemplate(PatternsModelContext template) {
        wSet(PatternsFeatureDescriptorEnum.template, template);
    }

    public PatternsModelContext getType() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.type);
    }

    public void setType(PatternsModelContext type) {
        wSet(PatternsFeatureDescriptorEnum.type, type);
    }

    public PatternsModelContext getSupertypes() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.supertypes);
    }

    public void setSupertypes(PatternsModelContext supertypes) {
        wSet(PatternsFeatureDescriptorEnum.supertypes, supertypes);
    }

    public PatternsModelContext getTypes() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.types);
    }

    public void setTypes(PatternsModelContext types) {
        wSet(PatternsFeatureDescriptorEnum.types, types);
    }

    public PatternsModelContext getResultType() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.resultType);
    }

    public void setResultType(PatternsModelContext resultType) {
        wSet(PatternsFeatureDescriptorEnum.resultType, resultType);
    }

    public PatternsModelContext getValues() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.values);
    }

    public void setValues(PatternsModelContext values) {
        wSet(PatternsFeatureDescriptorEnum.values, values);
    }

    public PatternsModelContext getValue() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.value);
    }

    public void setValue(PatternsModelContext value) {
        wSet(PatternsFeatureDescriptorEnum.value, value);
    }

    public PatternsModelContext getResult() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.result);
    }

    public void setResult(PatternsModelContext result) {
        wSet(PatternsFeatureDescriptorEnum.result, result);
    }

    public PatternsModelContext getDataType() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.dataType);
    }

    public void setDataType(PatternsModelContext dataType) {
        wSet(PatternsFeatureDescriptorEnum.dataType, dataType);
    }

    public PatternsModelContext getArguments() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.arguments);
    }

    public void setArguments(PatternsModelContext arguments) {
        wSet(PatternsFeatureDescriptorEnum.arguments, arguments);
    }

    public PatternsModelContext getExpression() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.expression);
    }

    public void setExpression(PatternsModelContext expression) {
        wSet(PatternsFeatureDescriptorEnum.expression, expression);
    }

    public PatternsModelContext getOptional() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.optional);
    }

    public void setOptional(PatternsModelContext optional) {
        wSet(PatternsFeatureDescriptorEnum.optional, optional);
    }

    public PatternsModelContext getAdapter() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.adapter);
    }

    public void setAdapter(PatternsModelContext adapter) {
        wSet(PatternsFeatureDescriptorEnum.adapter, adapter);
    }

    public PatternsModelContext getWeaver() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.weaver);
    }

    public void setWeaver(PatternsModelContext weaver) {
        wSet(PatternsFeatureDescriptorEnum.weaver, weaver);
    }

    public PatternsModelContext getContext() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.context);
    }

    public void setContext(PatternsModelContext context) {
        wSet(PatternsFeatureDescriptorEnum.context, context);
    }

    public PatternsModelContext getCondition() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.condition);
    }

    public void setCondition(PatternsModelContext condition) {
        wSet(PatternsFeatureDescriptorEnum.condition, condition);
    }

    public PatternsModelContext getVariability() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.variability);
    }

    public void setVariability(PatternsModelContext variability) {
        wSet(PatternsFeatureDescriptorEnum.variability, variability);
    }

    public PatternsModelContext getVariants() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.variants);
    }

    public void setVariants(PatternsModelContext variants) {
        wSet(PatternsFeatureDescriptorEnum.variants, variants);
    }

    public PatternsModelContext getIterator() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.iterator);
    }

    public void setIterator(PatternsModelContext iterator) {
        wSet(PatternsFeatureDescriptorEnum.iterator, iterator);
    }

    public PatternsModelContext getApplicationTypes() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.applicationTypes);
    }

    public void setApplicationTypes(PatternsModelContext applicationTypes) {
        wSet(PatternsFeatureDescriptorEnum.applicationTypes, applicationTypes);
    }

    public PatternsModelContext getBody() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.body);
    }

    public void setBody(PatternsModelContext body) {
        wSet(PatternsFeatureDescriptorEnum.body, body);
    }

    public PatternsModelContext getSubgoals() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.subgoals);
    }

    public void setSubgoals(PatternsModelContext subgoals) {
        wSet(PatternsFeatureDescriptorEnum.subgoals, subgoals);
    }

    public PatternsModelContext getVariant() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.variant);
    }

    public void setVariant(PatternsModelContext variant) {
        wSet(PatternsFeatureDescriptorEnum.variant, variant);
    }

    public PatternsModelContext getPath() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.path);
    }

    public void setPath(PatternsModelContext path) {
        wSet(PatternsFeatureDescriptorEnum.path, path);
    }

    public PatternsModelContext getPlacement() {
        return (PatternsModelContext) wGet(PatternsFeatureDescriptorEnum.placement);
    }

    public void setPlacement(PatternsModelContext placement) {
        wSet(PatternsFeatureDescriptorEnum.placement, placement);
    }
}
