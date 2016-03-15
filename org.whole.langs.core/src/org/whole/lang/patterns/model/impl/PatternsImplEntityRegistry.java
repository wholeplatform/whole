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
package org.whole.lang.patterns.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class PatternsImplEntityRegistry extends AbstractEntityRegistry {

    public PatternsImplEntityRegistry() {
        super(PatternsEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new PatternLanguageImpl());
        put(new PatternsImpl());
        put(new LibraryImpl());
        put(new PatternImpl());
        put(new RepetitionImpl());
        put(new ChoiceImpl());
        put(new EnumerationImpl());
        put(new EnumValuesImpl());
        put(new EnumValueImpl());
        put(new DataImpl());
        put(new DataTypeImpl());
        put(new PatternApplicationImpl());
        put(new ArgumentsImpl());
        put(new BindingImpl());
        put(new VariablePointImpl());
        put(new FunctionPointImpl());
        put(new SlotImpl());
        put(new ResultPointImpl());
        put(new JoinPointImpl());
        put(new InsertionPointImpl());
        put(new ScopePointImpl());
        put(new TemplatePointImpl());
        put(new DerivationPointImpl());
        put(new SelectionPointImpl());
        put(new ConditionPointImpl());
        put(new VariantSelectionPointImpl());
        put(new VariantsImpl());
        put(new VariantImpl());
        put(new IterationPointImpl());
        put(new SequencePointImpl());
        put(new InlinePointImpl());
        put(new DeclarationsImpl());
        put(new FunctionDeclarationImpl());
        put(new GoalDeclarationImpl());
        put(new PointcutDeclarationImpl());
        put(new JoinPointDeclarationImpl());
        put(new VariableDeclarationImpl());
        put(new VariantSelectorImpl());
        put(new TypesImpl());
        put(new ResultTypesImpl());
        put(new NameImpl());
        put(new PatternJoinPointStepImpl());
        put(new JoinPointStepImpl());
        put(new PointcutStepImpl());
        put(new GoalStepImpl());
        put(new FunctionStepImpl());
        put(new SlotStepImpl());
        put(new OuterDefinitionStepImpl());
        put(new PatternInstanceImpl());
        put(new CutImpl());
        put(new InsertImpl());
        put(new SlotsDefinedImpl());
        put(new PatternTypeTestImpl());
        put(new PlacementImpl());
        put(new URIImpl());
        put(new NamespaceImpl());
        put(new VersionImpl());
        put(new BooleanValueImpl());
    }
}
