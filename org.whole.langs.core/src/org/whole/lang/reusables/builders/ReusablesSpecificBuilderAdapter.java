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

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class ReusablesSpecificBuilderAdapter extends GenericBuilderContext implements IReusablesBuilder {

    public ReusablesSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public ReusablesSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void uri() {
        wFeature(ReusablesFeatureDescriptorEnum.uri);
    }

    public void persistence() {
        wFeature(ReusablesFeatureDescriptorEnum.persistence);
    }

    public void locator() {
        wFeature(ReusablesFeatureDescriptorEnum.locator);
    }

    public void variantRevision() {
        wFeature(ReusablesFeatureDescriptorEnum.variantRevision);
    }

    public void variant() {
        wFeature(ReusablesFeatureDescriptorEnum.variant);
    }

    public void source() {
        wFeature(ReusablesFeatureDescriptorEnum.source);
    }

    public void adaptedRevision() {
        wFeature(ReusablesFeatureDescriptorEnum.adaptedRevision);
    }

    public void adapted() {
        wFeature(ReusablesFeatureDescriptorEnum.adapted);
    }

    public void adapter() {
        wFeature(ReusablesFeatureDescriptorEnum.adapter);
    }

    public void original() {
        wFeature(ReusablesFeatureDescriptorEnum.original);
    }

    public void visit() {
    }

    public void Adapt() {
        wEntity(ReusablesEntityDescriptorEnum.Adapt);
    }

    public void Adapt_() {
        wEntity_(ReusablesEntityDescriptorEnum.Adapt);
    }

    public void _Adapt() {
        _wEntity(ReusablesEntityDescriptorEnum.Adapt);
    }

    public void Reuse() {
        wEntity(ReusablesEntityDescriptorEnum.Reuse);
    }

    public void Reuse_() {
        wEntity_(ReusablesEntityDescriptorEnum.Reuse);
    }

    public void _Reuse() {
        _wEntity(ReusablesEntityDescriptorEnum.Reuse);
    }

    public void Synch() {
        wEntity(ReusablesEntityDescriptorEnum.Synch);
    }

    public void Synch_() {
        wEntity_(ReusablesEntityDescriptorEnum.Synch);
    }

    public void _Synch() {
        _wEntity(ReusablesEntityDescriptorEnum.Synch);
    }

    public void Include() {
        wEntity(ReusablesEntityDescriptorEnum.Include);
    }

    public void Include_() {
        wEntity_(ReusablesEntityDescriptorEnum.Include);
    }

    public void _Include() {
        _wEntity(ReusablesEntityDescriptorEnum.Include);
    }

    public void Reusables() {
        wEntity(ReusablesEntityDescriptorEnum.Reusables);
    }

    public void Reusables_() {
        wEntity_(ReusablesEntityDescriptorEnum.Reusables);
    }

    public void Reusables_(int initialCapacity) {
        wEntity_(ReusablesEntityDescriptorEnum.Reusables, initialCapacity);
    }

    public void _Reusables() {
        _wEntity(ReusablesEntityDescriptorEnum.Reusables);
    }

    public void ReferenceStep() {
        wEntity(ReusablesEntityDescriptorEnum.ReferenceStep);
    }

    public void ReferenceStep_() {
        wEntity_(ReusablesEntityDescriptorEnum.ReferenceStep);
    }

    public void _ReferenceStep() {
        _wEntity(ReusablesEntityDescriptorEnum.ReferenceStep);
    }

    public void Resource() {
        wEntity(ReusablesEntityDescriptorEnum.Resource);
    }

    public void Resource_() {
        wEntity_(ReusablesEntityDescriptorEnum.Resource);
    }

    public void _Resource() {
        _wEntity(ReusablesEntityDescriptorEnum.Resource);
    }

    public void Registry() {
        wEntity(ReusablesEntityDescriptorEnum.Registry);
    }

    public void Registry_() {
        wEntity_(ReusablesEntityDescriptorEnum.Registry);
    }

    public void _Registry() {
        _wEntity(ReusablesEntityDescriptorEnum.Registry);
    }

    public void WorkspacePath() {
        wEntity(ReusablesEntityDescriptorEnum.WorkspacePath);
    }

    public void WorkspacePath(String value) {
        wEntity(ReusablesEntityDescriptorEnum.WorkspacePath, value);
    }

    public void FileSystemPath() {
        wEntity(ReusablesEntityDescriptorEnum.FileSystemPath);
    }

    public void FileSystemPath(String value) {
        wEntity(ReusablesEntityDescriptorEnum.FileSystemPath, value);
    }

    public void ClassPathURI() {
        wEntity(ReusablesEntityDescriptorEnum.ClassPathURI);
    }

    public void ClassPathURI(String value) {
        wEntity(ReusablesEntityDescriptorEnum.ClassPathURI, value);
    }

    public void URI() {
        wEntity(ReusablesEntityDescriptorEnum.URI);
    }

    public void URI(String value) {
        wEntity(ReusablesEntityDescriptorEnum.URI, value);
    }

    public void Persistence() {
        wEntity(ReusablesEntityDescriptorEnum.Persistence);
    }

    public void Persistence(String value) {
        wEntity(ReusablesEntityDescriptorEnum.Persistence, value);
    }
}
