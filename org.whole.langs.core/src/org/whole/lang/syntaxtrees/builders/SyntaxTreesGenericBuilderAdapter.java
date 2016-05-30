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

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class SyntaxTreesGenericBuilderAdapter extends GenericIdentityBuilder {
    private ISyntaxTreesBuilder specificBuilder;

    public SyntaxTreesGenericBuilderAdapter(ISyntaxTreesBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public SyntaxTreesGenericBuilderAdapter(ISyntaxTreesBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case SyntaxTreesFeatureDescriptorEnum.name_ord :
            specificBuilder.name();
            break;
            case SyntaxTreesFeatureDescriptorEnum.children_ord :
            specificBuilder.children();
            break;
            case SyntaxTreesFeatureDescriptorEnum.text_ord :
            specificBuilder.text();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SyntaxTreesEntityDescriptorEnum.Rule_ord :
            specificBuilder.Rule();
            break;
            case SyntaxTreesEntityDescriptorEnum.Nodes_ord :
            specificBuilder.Nodes();
            break;
            case SyntaxTreesEntityDescriptorEnum.Terminal_ord :
            specificBuilder.Terminal();
            break;
            case SyntaxTreesEntityDescriptorEnum.Literal_ord :
            specificBuilder.Literal();
            break;
            case SyntaxTreesEntityDescriptorEnum.Data_ord :
            specificBuilder.Data();
            break;
            case SyntaxTreesEntityDescriptorEnum.Error_ord :
            specificBuilder.Error();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SyntaxTreesEntityDescriptorEnum.Rule_ord :
            specificBuilder.Rule_();
            break;
            case SyntaxTreesEntityDescriptorEnum.Nodes_ord :
            specificBuilder.Nodes_();
            break;
            case SyntaxTreesEntityDescriptorEnum.Terminal_ord :
            specificBuilder.Terminal_();
            break;
            case SyntaxTreesEntityDescriptorEnum.Literal_ord :
            specificBuilder.Literal_();
            break;
            case SyntaxTreesEntityDescriptorEnum.Data_ord :
            specificBuilder.Data_();
            break;
            case SyntaxTreesEntityDescriptorEnum.Error_ord :
            specificBuilder.Error_();
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SyntaxTreesEntityDescriptorEnum.Rule_ord :
            specificBuilder._Rule();
            break;
            case SyntaxTreesEntityDescriptorEnum.Nodes_ord :
            specificBuilder._Nodes();
            break;
            case SyntaxTreesEntityDescriptorEnum.Terminal_ord :
            specificBuilder._Terminal();
            break;
            case SyntaxTreesEntityDescriptorEnum.Literal_ord :
            specificBuilder._Literal();
            break;
            case SyntaxTreesEntityDescriptorEnum.Data_ord :
            specificBuilder._Data();
            break;
            case SyntaxTreesEntityDescriptorEnum.Error_ord :
            specificBuilder._Error();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case SyntaxTreesEntityDescriptorEnum.Nodes_ord :
            specificBuilder.Nodes_(initialCapacity);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case SyntaxTreesEntityDescriptorEnum.Text_ord :
            specificBuilder.Text(value);
            break;
            case SyntaxTreesEntityDescriptorEnum.Name_ord :
            specificBuilder.Name(value);
            break;
        }
    }
}
