package org.whole.lang.patterns.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class PatternsAdaptersEntityRegistry extends AbstractEntityRegistry {

    public PatternsAdaptersEntityRegistry() {
        super(PatternsEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new PatternLanguageAdapter());
        put(new PatternsAdapter());
        put(new PatternOrTypeDeclarationAdapter());
        put(new LibraryAdapter());
        put(new TemplateAdapter());
        put(new PatternAdapter());
        put(new RepetitionAdapter());
        put(new ChoiceAdapter());
        put(new EnumerationAdapter());
        put(new EnumValuesAdapter());
        put(new EnumValueAdapter());
        put(new DataAdapter());
        put(new DataTypeAdapter());
        put(new VariationPointAdapter());
        put(new PatternApplicationAdapter());
        put(new ArgumentsAdapter());
        put(new BindingAdapter());
        put(new VariablePointAdapter());
        put(new FunctionApplicationPointAdapter());
        put(new SlotAdapter());
        put(new ResultPointAdapter());
        put(new JoinPointAdapter());
        put(new InsertionPointAdapter());
        put(new ScopePointAdapter());
        put(new TemplatePointAdapter());
        put(new DerivationPointAdapter());
        put(new SelectionPointAdapter());
        put(new ConditionPointAdapter());
        put(new VariantSelectionPointAdapter());
        put(new VariantsAdapter());
        put(new VariantAdapter());
        put(new IterationPointAdapter());
        put(new SequencePointAdapter());
        put(new InlinePointAdapter());
        put(new DeclarationsAdapter());
        put(new FunctionDeclarationAdapter());
        put(new GoalDeclarationAdapter());
        put(new PointcutDeclarationAdapter());
        put(new JoinPointDeclarationAdapter());
        put(new VariableDeclarationAdapter());
        put(new VariantSelectorAdapter());
        put(new TypesAdapter());
        put(new ResultTypesAdapter());
        put(new TypeAdapter());
        put(new ResultTypeOrPathExpressionAdapter());
        put(new ResultTypeAdapter());
        put(new NameAdapter());
        put(new PathExpressionAdapter());
        put(new StepExpressionAdapter());
        put(new PatternJoinPointStepAdapter());
        put(new JoinPointStepAdapter());
        put(new PointcutStepAdapter());
        put(new GoalStepAdapter());
        put(new SlotStepAdapter());
        put(new OuterDefinitionStepAdapter());
        put(new CutAdapter());
        put(new InsertAdapter());
        put(new SlotsDefinedAdapter());
        put(new PatternTypeTestAdapter());
        put(new PlacementAdapter());
        put(new URIAdapter());
        put(new NamespaceAdapter());
        put(new VersionAdapter());
        put(new BooleanValueAdapter());
        put(new GoalExpressionAdapter());
        put(new ArgumentAdapter());
        put(new PredicateAdapter());
        put(new DeclarationAdapter());
        put(new ExpressionAdapter());
    }
}
