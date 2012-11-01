package org.whole.lang.grammars.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class GrammarsImplEntityRegistry extends AbstractEntityRegistry {
	public GrammarsImplEntityRegistry() {
		super(GrammarsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new GrammarImpl());
		put(new ProductionsImpl());
		put(new ProductionImpl());
		put(new AndImpl());
		put(new OrImpl());
		put(new NotImpl());
		put(new EmptyImpl());
		put(new SpaceImpl());
		put(new IndentImpl());
		put(new NewLineImpl());
		put(new LiteralTerminalImpl());
		put(new DataTerminalImpl());
		put(new NonTerminalImpl());
		put(new OptionalImpl());
		put(new RepeatImpl());
		put(new ConcatenateImpl());
		put(new ChooseImpl());
		put(new WhenImpl());
		put(new AsImpl());
		put(new SplitImpl());
		put(new BySizeImpl());
		put(new ByLinesImpl());
		put(new ByDelimiterImpl());
		put(new LanguageDescriptorImpl());
		put(new NameImpl());
		put(new URIImpl());
		put(new NamespaceImpl());
		put(new VersionImpl());
		put(new UnboundedImpl());
		put(new SizeImpl());
		put(new LiteralImpl());
		put(new RegExpImpl());
		put(new CompiledPatternImpl());
		put(new FormatImpl());
		put(new CategoryImpl());
		put(new DataTypeImpl());
		put(new CustomDataTypeImpl());
	}
}
