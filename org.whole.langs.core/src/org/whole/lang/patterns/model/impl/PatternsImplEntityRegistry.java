package org.whole.lang.patterns.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

/** 
 * @generator Whole
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
		put(new PatternApplicationImpl());
		put(new ArgumentsImpl());
		put(new BindingImpl());
		put(new VariablePointImpl());
		put(new FunctionApplicationPointImpl());
		put(new SlotImpl());
		put(new ResultPointImpl());
		put(new JoinPointImpl());
		put(new InsertionPointImpl());
		put(new ScopePointImpl());
		put(new TemplatePointImpl());
		put(new DerivationPointImpl());
		put(new SelectionPointImpl());
		put(new ConditionPointImpl());
		put(new IterationPointImpl());
		put(new SequencePointImpl());
		put(new InlinePointImpl());
		put(new DeclarationsImpl());
		put(new FunctionDeclarationImpl());
		put(new PointcutDeclarationImpl());
		put(new JoinPointDeclarationImpl());
		put(new VariableDeclarationImpl());
		put(new TypesImpl());
		put(new ResultTypesImpl());
		put(new RepetitionImpl());
		put(new ChoiceImpl());
		put(new EnumerationImpl());
		put(new EnumValuesImpl());
		put(new EnumValueImpl());
		put(new NameImpl());
		put(new PatternJoinPointStepImpl());
		put(new JoinPointStepImpl());
		put(new PointcutStepImpl());
		put(new SlotStepImpl());
		put(new OuterDefinitionStepImpl());
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
