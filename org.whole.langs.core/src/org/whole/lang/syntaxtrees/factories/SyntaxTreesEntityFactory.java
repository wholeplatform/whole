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
package org.whole.lang.syntaxtrees.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.syntaxtrees.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;
import org.whole.lang.syntaxtrees.model.Error;

/**
 *  @generator Whole
 */
public class SyntaxTreesEntityFactory extends GenericEntityFactory {
    public static final SyntaxTreesEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static SyntaxTreesEntityFactory instance(IEntityRegistryProvider provider) {
        return new SyntaxTreesEntityFactory(provider);
    }

    protected SyntaxTreesEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public Rule createRule() {
        return create(SyntaxTreesEntityDescriptorEnum.Rule);
    }

    public Rule createRule(Name name, Nodes children) {
        return create(SyntaxTreesEntityDescriptorEnum.Rule, name, children);
    }

    public IEntityBuilder<Rule> buildRule() {
        return new EntityBuilder<Rule>(create(SyntaxTreesEntityDescriptorEnum.Rule));
    }

    public Nodes createNodes() {
        return create(SyntaxTreesEntityDescriptorEnum.Nodes);
    }

    public Nodes createNodes(Node... entities) {
        return create(SyntaxTreesEntityDescriptorEnum.Nodes, (IEntity[]) entities);
    }

    public Nodes createNodes(int initialSize) {
        return clone(SyntaxTreesEntityDescriptorEnum.Nodes, initialSize);
    }

    public Terminal createTerminal() {
        return create(SyntaxTreesEntityDescriptorEnum.Terminal);
    }

    public Terminal createTerminal(Name name, Text text) {
        return create(SyntaxTreesEntityDescriptorEnum.Terminal, name, text);
    }

    public IEntityBuilder<Terminal> buildTerminal() {
        return new EntityBuilder<Terminal>(create(SyntaxTreesEntityDescriptorEnum.Terminal));
    }

    public Literal createLiteral() {
        return create(SyntaxTreesEntityDescriptorEnum.Literal);
    }

    public Literal createLiteral(Name name, Text text) {
        return create(SyntaxTreesEntityDescriptorEnum.Literal, name, text);
    }

    public IEntityBuilder<Literal> buildLiteral() {
        return new EntityBuilder<Literal>(create(SyntaxTreesEntityDescriptorEnum.Literal));
    }

    public Data createData() {
        return create(SyntaxTreesEntityDescriptorEnum.Data);
    }

    public Data createData(Name name, Text text) {
        return create(SyntaxTreesEntityDescriptorEnum.Data, name, text);
    }

    public IEntityBuilder<Data> buildData() {
        return new EntityBuilder<Data>(create(SyntaxTreesEntityDescriptorEnum.Data));
    }

    public Error createError() {
        return create(SyntaxTreesEntityDescriptorEnum.Error);
    }

    public Error createError(Name name, Text text) {
        return create(SyntaxTreesEntityDescriptorEnum.Error, name, text);
    }

    public IEntityBuilder<Error> buildError() {
        return new EntityBuilder<Error>(create(SyntaxTreesEntityDescriptorEnum.Error));
    }

    public Text createText() {
        return create(SyntaxTreesEntityDescriptorEnum.Text);
    }

    public Text createText(String value) {
        return create(SyntaxTreesEntityDescriptorEnum.Text, value);
    }

    public Name createName() {
        return create(SyntaxTreesEntityDescriptorEnum.Name);
    }

    public Name createName(String value) {
        return create(SyntaxTreesEntityDescriptorEnum.Name, value);
    }
}
