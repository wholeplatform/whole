package org.whole.lang.grammars.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class GrammarsAdaptersEntityRegistry extends AbstractEntityRegistry {
	public GrammarsAdaptersEntityRegistry() {
		super(GrammarsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new GrammarAdapter());
		put(new ProductionsAdapter());
		put(new ProductionAdapter());
		put(new PredicateAdapter());
		put(new AndAdapter());
		put(new OrAdapter());
		put(new NotAdapter());
		put(new RuleAdapter());
		put(new EpsilonRuleAdapter());
		put(new EmptyAdapter());
		put(new SpaceAdapter());
		put(new IndentAdapter());
		put(new NewLineAdapter());
		put(new TerminalAdapter());
		put(new LiteralTerminalAdapter());
		put(new DataTerminalAdapter());
		put(new NonTerminalAdapter());
		put(new OptionalAdapter());
		put(new RepeatAdapter());
		put(new ConcatenateAdapter());
		put(new ChooseAdapter());
		put(new WhenAdapter());
		put(new AsAdapter());
		put(new SplitAdapter());
		put(new SplitterAdapter());
		put(new BySizeAdapter());
		put(new ByLinesAdapter());
		put(new ByDelimiterAdapter());
		put(new TargetLanguageAdapter());
		put(new LanguageDescriptorAdapter());
		put(new NameAdapter());
		put(new URIAdapter());
		put(new NamespaceAdapter());
		put(new VersionAdapter());
		put(new BoundAdapter());
		put(new UnboundedAdapter());
		put(new SizeAdapter());
		put(new LiteralAdapter());
		put(new PatternAdapter());
		put(new RegExpAdapter());
		put(new CompiledPatternAdapter());
		put(new FormatAdapter());
		put(new CategoryAdapter());
		put(new TemplateAdapter());
		put(new DataTypeAdapter());
		put(new CustomDataTypeAdapter());
	}
}
