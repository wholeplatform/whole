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
package org.whole.lang.syntaxtrees.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesFeatureDescriptorEnum;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class SyntaxTreesSpecificBuilderAdapter extends GenericBuilderContext implements ISyntaxTreesBuilder {

    public SyntaxTreesSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public SyntaxTreesSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void text() {
        wFeature(SyntaxTreesFeatureDescriptorEnum.text);
    }

    public void children() {
        wFeature(SyntaxTreesFeatureDescriptorEnum.children);
    }

    public void name() {
        wFeature(SyntaxTreesFeatureDescriptorEnum.name);
    }

    public void visit() {
    }

    public void Rule() {
        wEntity(SyntaxTreesEntityDescriptorEnum.Rule);
    }

    public void Rule_() {
        wEntity_(SyntaxTreesEntityDescriptorEnum.Rule);
    }

    public void _Rule() {
        _wEntity(SyntaxTreesEntityDescriptorEnum.Rule);
    }

    public void Nodes() {
        wEntity(SyntaxTreesEntityDescriptorEnum.Nodes);
    }

    public void Nodes_() {
        wEntity_(SyntaxTreesEntityDescriptorEnum.Nodes);
    }

    public void Nodes_(int initialCapacity) {
        wEntity_(SyntaxTreesEntityDescriptorEnum.Nodes, initialCapacity);
    }

    public void _Nodes() {
        _wEntity(SyntaxTreesEntityDescriptorEnum.Nodes);
    }

    public void Terminal() {
        wEntity(SyntaxTreesEntityDescriptorEnum.Terminal);
    }

    public void Terminal_() {
        wEntity_(SyntaxTreesEntityDescriptorEnum.Terminal);
    }

    public void _Terminal() {
        _wEntity(SyntaxTreesEntityDescriptorEnum.Terminal);
    }

    public void Literal() {
        wEntity(SyntaxTreesEntityDescriptorEnum.Literal);
    }

    public void Literal_() {
        wEntity_(SyntaxTreesEntityDescriptorEnum.Literal);
    }

    public void _Literal() {
        _wEntity(SyntaxTreesEntityDescriptorEnum.Literal);
    }

    public void Data() {
        wEntity(SyntaxTreesEntityDescriptorEnum.Data);
    }

    public void Data_() {
        wEntity_(SyntaxTreesEntityDescriptorEnum.Data);
    }

    public void _Data() {
        _wEntity(SyntaxTreesEntityDescriptorEnum.Data);
    }

    public void Error() {
        wEntity(SyntaxTreesEntityDescriptorEnum.Error);
    }

    public void Error_() {
        wEntity_(SyntaxTreesEntityDescriptorEnum.Error);
    }

    public void _Error() {
        _wEntity(SyntaxTreesEntityDescriptorEnum.Error);
    }

    public void Text() {
        wEntity(SyntaxTreesEntityDescriptorEnum.Text);
    }

    public void Text(String value) {
        wEntity(SyntaxTreesEntityDescriptorEnum.Text, value);
    }

    public void Name() {
        wEntity(SyntaxTreesEntityDescriptorEnum.Name);
    }

    public void Name(String value) {
        wEntity(SyntaxTreesEntityDescriptorEnum.Name, value);
    }
}
