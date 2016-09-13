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
package org.whole.lang.syntaxtrees.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.syntaxtrees.model.*;
import org.whole.lang.syntaxtrees.model.Error;

/**
 *  @generator Whole
 */
@SuppressWarnings("unchecked")
public class SyntaxTreesEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int Node_ord = 0;
    public static final int Rule_ord = 1;
    public static final int Nodes_ord = 2;
    public static final int Terminal_ord = 3;
    public static final int Literal_ord = 4;
    public static final int Data_ord = 5;
    public static final int Error_ord = 6;
    public static final int Text_ord = 7;
    public static final int Name_ord = 8;
    public static final SyntaxTreesEntityDescriptorEnum instance = new SyntaxTreesEntityDescriptorEnum();
    public static final EntityDescriptor<Node> Node = (EntityDescriptor<Node>) instance.valueOf(Node_ord);
    public static final EntityDescriptor<Rule> Rule = (EntityDescriptor<Rule>) instance.valueOf(Rule_ord);
    public static final EntityDescriptor<Nodes> Nodes = (EntityDescriptor<Nodes>) instance.valueOf(Nodes_ord);
    public static final EntityDescriptor<Terminal> Terminal = (EntityDescriptor<Terminal>) instance.valueOf(Terminal_ord);
    public static final EntityDescriptor<Literal> Literal = (EntityDescriptor<Literal>) instance.valueOf(Literal_ord);
    public static final EntityDescriptor<Data> Data = (EntityDescriptor<Data>) instance.valueOf(Data_ord);
    public static final EntityDescriptor<Error> Error = (EntityDescriptor<Error>) instance.valueOf(Error_ord);
    public static final EntityDescriptor<Text> Text = (EntityDescriptor<Text>) instance.valueOf(Text_ord);
    public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance.valueOf(Name_ord);

    private SyntaxTreesEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(Node_ord, "Node", Node.class, true, Error_ord, Data_ord, Rule_ord, Terminal_ord, Literal_ord).withFeature(SyntaxTreesFeatureDescriptorEnum.name, Name_ord);
        putSimpleEntity(Rule_ord, "Rule", Rule.class, false).withFeature(SyntaxTreesFeatureDescriptorEnum.name, Name_ord).withFeature(SyntaxTreesFeatureDescriptorEnum.children, Nodes_ord, true, false, false, false, false);
        putCompositeEntity(
		Nodes_ord, "Nodes", Nodes.class, false, Node_ord, true, false);
        putSimpleEntity(Terminal_ord, "Terminal", Terminal.class, false, Error_ord, Data_ord, Literal_ord).withFeature(SyntaxTreesFeatureDescriptorEnum.name, Name_ord).withFeature(SyntaxTreesFeatureDescriptorEnum.text, Text_ord);
        putSimpleEntity(Literal_ord, "Literal", Literal.class, false).withFeature(SyntaxTreesFeatureDescriptorEnum.name, Name_ord).withFeature(SyntaxTreesFeatureDescriptorEnum.text, Text_ord);
        putSimpleEntity(Data_ord, "Data", Data.class, false).withFeature(SyntaxTreesFeatureDescriptorEnum.name, Name_ord).withFeature(SyntaxTreesFeatureDescriptorEnum.text, Text_ord);
        putSimpleEntity(Error_ord, "Error", Error.class, false).withFeature(SyntaxTreesFeatureDescriptorEnum.name, Name_ord).withFeature(SyntaxTreesFeatureDescriptorEnum.text, Text_ord);
        putDataEntity(Text_ord, "Text", Text.class, false, String.class);
        putDataEntity(Name_ord, "Name", Name.class, false, String.class);
    }
}
