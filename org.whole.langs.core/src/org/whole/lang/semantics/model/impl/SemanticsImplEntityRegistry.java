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
package org.whole.lang.semantics.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class SemanticsImplEntityRegistry extends AbstractEntityRegistry {

    public SemanticsImplEntityRegistry() {
        super(SemanticsEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new SemanticTheoryImpl());
        put(new SemanticFunctionsImpl());
        put(new SemanticFunctionImpl());
        put(new RulesImpl());
        put(new InferenceRulesImpl());
        put(new AnyTypeImpl());
        put(new LanguageTypeImpl());
        put(new EnvTypeImpl());
        put(new EntityTypeImpl());
        put(new EnvironmentTypeImpl());
        put(new LegacyTypeImpl());
        put(new UnionTypeImpl());
        put(new FunctionTypeImpl());
        put(new SequenceTypeImpl());
        put(new SubtypeTypeImpl());
        put(new SupertypeTypeImpl());
        put(new ProductTypeImpl());
        put(new ExecutionRuleImpl());
        put(new InferenceRuleImpl());
        put(new PremisesImpl());
        put(new TransitionImpl());
        put(new ConfigurationImpl());
        put(new TypedVariableImpl());
        put(new StructuredVariableImpl());
        put(new VariableImpl());
        put(new VariableValueImpl());
        put(new RenameGroupImpl());
        put(new RenameImpl());
        put(new EnvironmentsImpl());
        put(new BindingsScopeImpl());
        put(new LocalBindingsImpl());
        put(new LocalBindingImpl());
        put(new BindingOpImpl());
        put(new EnvironmentVariableImpl());
        put(new TypeCastImpl());
        put(new FunctionApplicationImpl());
        put(new StageChangeImpl());
        put(new OutputBindingsImpl());
        put(new OutputBindingImpl());
        put(new InputBindingsImpl());
        put(new InputBindingImpl());
        put(new InlineTemplateImpl());
        put(new ChooseTemplateImpl());
        put(new WhereTemplateImpl());
        put(new ForTemplateImpl());
        put(new IfTemplateImpl());
        put(new IfDefTemplateImpl());
        put(new ElseTemplateImpl());
        put(new RuleNameImpl());
        put(new NumImpl());
        put(new URIImpl());
        put(new NamespaceImpl());
        put(new NameImpl());
        put(new VersionImpl());
    }
}
