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
package org.whole.lang.semantics.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class SemanticsAdaptersEntityRegistry extends AbstractEntityRegistry {

    public SemanticsAdaptersEntityRegistry() {
        super(SemanticsEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new SemanticTheoryAdapter());
        put(new SemanticFunctionsAdapter());
        put(new SemanticFunctionAdapter());
        put(new FunctionBodyAdapter());
        put(new RulesAdapter());
        put(new InferenceRulesAdapter());
        put(new SignatureOrSequenceAdapter());
        put(new SignatureAdapter());
        put(new CategoryAdapter());
        put(new AnyTypeAdapter());
        put(new LanguageTypeAdapter());
        put(new CastTypeAdapter());
        put(new EnvTypeAdapter());
        put(new EntityTypeAdapter());
        put(new EnvironmentTypeAdapter());
        put(new LegacyTypeAdapter());
        put(new UnionTypeAdapter());
        put(new FunctionTypeAdapter());
        put(new SequenceTypeAdapter());
        put(new SubtypeTypeAdapter());
        put(new SupertypeTypeAdapter());
        put(new ProductTypeAdapter());
        put(new RuleAdapter());
        put(new ExecutionRuleAdapter());
        put(new InferenceRuleAdapter());
        put(new PremisesAdapter());
        put(new PremiseAdapter());
        put(new ConfigurationOrTransitionAdapter());
        put(new TransitionAdapter());
        put(new PredicateAdapter());
        put(new ConfigurationAdapter());
        put(new ConfigurationItemAdapter());
        put(new BindingSubjectAdapter());
        put(new TermAdapter());
        put(new ExpressionAdapter());
        put(new IdentifierAdapter());
        put(new LocalIdentifierAdapter());
        put(new TemplateAdapter());
        put(new AbstractVariableAdapter());
        put(new TypedVariableAdapter());
        put(new StructuredVariableAdapter());
        put(new VariableAdapter());
        put(new VariableValueAdapter());
        put(new RenameGroupAdapter());
        put(new RenameAdapter());
        put(new EnvironmentsAdapter());
        put(new EnvironmentAdapter());
        put(new BindingsScopeAdapter());
        put(new LocalBindingsAdapter());
        put(new LocalBindingAdapter());
        put(new BindingOpAdapter());
        put(new EnvironmentVariableAdapter());
        put(new TypeCastAdapter());
        put(new FunctionApplicationAdapter());
        put(new StageChangeAdapter());
        put(new OutputBindingsAdapter());
        put(new OutputBindingAdapter());
        put(new InputBindingsAdapter());
        put(new InputBindingAdapter());
        put(new InlineTemplateAdapter());
        put(new ChooseTemplateAdapter());
        put(new CaseAdapter());
        put(new WhereTemplateAdapter());
        put(new ForTemplateAdapter());
        put(new IfTemplateAdapter());
        put(new IfDefTemplateAdapter());
        put(new ElseTemplateAdapter());
        put(new RuleNameAdapter());
        put(new NumAdapter());
        put(new URIAdapter());
        put(new NamespaceAdapter());
        put(new NameAdapter());
        put(new VersionAdapter());
    }
}
