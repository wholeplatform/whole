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
package org.whole.lang.reusables.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class ReusablesModelContext extends EntityContext {

    public ReusablesModelContext(IEntity root) {
        super(root);
    }

    public ReusablesModelContext getOriginal() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.original);
    }

    public void setOriginal(ReusablesModelContext original) {
        wSet(ReusablesFeatureDescriptorEnum.original, original);
    }

    public ReusablesModelContext getAdapter() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.adapter);
    }

    public void setAdapter(ReusablesModelContext adapter) {
        wSet(ReusablesFeatureDescriptorEnum.adapter, adapter);
    }

    public ReusablesModelContext getAdapted() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.adapted);
    }

    public void setAdapted(ReusablesModelContext adapted) {
        wSet(ReusablesFeatureDescriptorEnum.adapted, adapted);
    }

    public ReusablesModelContext getAdaptedRevision() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.adaptedRevision);
    }

    public void setAdaptedRevision(ReusablesModelContext adaptedRevision) {
        wSet(ReusablesFeatureDescriptorEnum.adaptedRevision, adaptedRevision);
    }

    public ReusablesModelContext getSource() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.source);
    }

    public void setSource(ReusablesModelContext source) {
        wSet(ReusablesFeatureDescriptorEnum.source, source);
    }

    public ReusablesModelContext getVariant() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.variant);
    }

    public void setVariant(ReusablesModelContext variant) {
        wSet(ReusablesFeatureDescriptorEnum.variant, variant);
    }

    public ReusablesModelContext getVariantRevision() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.variantRevision);
    }

    public void setVariantRevision(ReusablesModelContext variantRevision) {
        wSet(ReusablesFeatureDescriptorEnum.variantRevision, variantRevision);
    }

    public ReusablesModelContext getLocator() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.locator);
    }

    public void setLocator(ReusablesModelContext locator) {
        wSet(ReusablesFeatureDescriptorEnum.locator, locator);
    }

    public ReusablesModelContext getPersistence() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.persistence);
    }

    public void setPersistence(ReusablesModelContext persistence) {
        wSet(ReusablesFeatureDescriptorEnum.persistence, persistence);
    }

    public ReusablesModelContext getUri() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.uri);
    }

    public void setUri(ReusablesModelContext uri) {
        wSet(ReusablesFeatureDescriptorEnum.uri, uri);
    }
}
