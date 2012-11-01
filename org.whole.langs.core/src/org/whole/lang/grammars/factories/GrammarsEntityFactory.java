package org.whole.lang.grammars.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.grammars.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class GrammarsEntityFactory extends GenericEntityFactory {
	public static final GrammarsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static GrammarsEntityFactory instance(
			IEntityRegistryProvider provider) {
		return new GrammarsEntityFactory(provider);
	}

	protected GrammarsEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Grammar createGrammar() {
		return create(GrammarsEntityDescriptorEnum.Grammar);
	}

	public Grammar createGrammar(Name name, TargetLanguage targetLanguage,
			NonTerminal startSymbol, LiteralTerminal delimiter,
			Productions lexicalStructure, Productions phraseStructure, URI uri,
			Namespace namespace, Version version, Literal spaceLiteral,
			Literal indentLiteral, Literal newLineLiteral) {
		return create(GrammarsEntityDescriptorEnum.Grammar, name,
				targetLanguage, startSymbol, delimiter, lexicalStructure,
				phraseStructure, uri, namespace, version, spaceLiteral,
				indentLiteral, newLineLiteral);
	}

	public IEntityBuilder<Grammar> buildGrammar() {
		return new EntityBuilder<Grammar>(
				create(GrammarsEntityDescriptorEnum.Grammar));
	}

	public Productions createProductions() {
		return create(GrammarsEntityDescriptorEnum.Productions);
	}

	public Productions createProductions(Production... entities) {
		return create(GrammarsEntityDescriptorEnum.Productions,
				(IEntity[]) entities);
	}

	public Productions createProductions(int initialSize) {
		return clone(GrammarsEntityDescriptorEnum.Productions, initialSize);
	}

	public Production createProduction() {
		return create(GrammarsEntityDescriptorEnum.Production);
	}

	public Production createProduction(NonTerminal name, Rule rule,
			Template template) {
		return create(GrammarsEntityDescriptorEnum.Production, name, rule,
				template);
	}

	public IEntityBuilder<Production> buildProduction() {
		return new EntityBuilder<Production>(
				create(GrammarsEntityDescriptorEnum.Production));
	}

	public And createAnd() {
		return create(GrammarsEntityDescriptorEnum.And);
	}

	public And createAnd(Predicate predicate1, Predicate predicate2) {
		return create(GrammarsEntityDescriptorEnum.And, predicate1, predicate2);
	}

	public IEntityBuilder<And> buildAnd() {
		return new EntityBuilder<And>(create(GrammarsEntityDescriptorEnum.And));
	}

	public Or createOr() {
		return create(GrammarsEntityDescriptorEnum.Or);
	}

	public Or createOr(Predicate predicate1, Predicate predicate2) {
		return create(GrammarsEntityDescriptorEnum.Or, predicate1, predicate2);
	}

	public IEntityBuilder<Or> buildOr() {
		return new EntityBuilder<Or>(create(GrammarsEntityDescriptorEnum.Or));
	}

	public Not createNot() {
		return create(GrammarsEntityDescriptorEnum.Not);
	}

	public Not createNot(Predicate predicate) {
		return create(GrammarsEntityDescriptorEnum.Not, predicate);
	}

	public Empty createEmpty() {
		return create(GrammarsEntityDescriptorEnum.Empty);
	}

	public Empty createEmpty(Literal literal) {
		return create(GrammarsEntityDescriptorEnum.Empty, literal);
	}

	public Space createSpace() {
		return create(GrammarsEntityDescriptorEnum.Space);
	}

	public Indent createIndent() {
		return create(GrammarsEntityDescriptorEnum.Indent);
	}

	public NewLine createNewLine() {
		return create(GrammarsEntityDescriptorEnum.NewLine);
	}

	public LiteralTerminal createLiteralTerminal() {
		return create(GrammarsEntityDescriptorEnum.LiteralTerminal);
	}

	public LiteralTerminal createLiteralTerminal(Pattern pattern,
			Category category, Literal literal) {
		return create(GrammarsEntityDescriptorEnum.LiteralTerminal, pattern,
				category, literal);
	}

	public IEntityBuilder<LiteralTerminal> buildLiteralTerminal() {
		return new EntityBuilder<LiteralTerminal>(
				create(GrammarsEntityDescriptorEnum.LiteralTerminal));
	}

	public DataTerminal createDataTerminal() {
		return create(GrammarsEntityDescriptorEnum.DataTerminal);
	}

	public DataTerminal createDataTerminal(Pattern pattern, Category category,
			Format format) {
		return create(GrammarsEntityDescriptorEnum.DataTerminal, pattern,
				category, format);
	}

	public IEntityBuilder<DataTerminal> buildDataTerminal() {
		return new EntityBuilder<DataTerminal>(
				create(GrammarsEntityDescriptorEnum.DataTerminal));
	}

	public NonTerminal createNonTerminal() {
		return create(GrammarsEntityDescriptorEnum.NonTerminal);
	}

	public NonTerminal createNonTerminal(String value) {
		return create(GrammarsEntityDescriptorEnum.NonTerminal, value);
	}

	public Optional createOptional() {
		return create(GrammarsEntityDescriptorEnum.Optional);
	}

	public Optional createOptional(Rule rule) {
		return create(GrammarsEntityDescriptorEnum.Optional, rule);
	}

	public Repeat createRepeat() {
		return create(GrammarsEntityDescriptorEnum.Repeat);
	}

	public Repeat createRepeat(Size lowerBound, Bound upperBound,
			Rule separator, Rule rule) {
		return create(GrammarsEntityDescriptorEnum.Repeat, lowerBound,
				upperBound, separator, rule);
	}

	public IEntityBuilder<Repeat> buildRepeat() {
		return new EntityBuilder<Repeat>(
				create(GrammarsEntityDescriptorEnum.Repeat));
	}

	public Concatenate createConcatenate() {
		return create(GrammarsEntityDescriptorEnum.Concatenate);
	}

	public Concatenate createConcatenate(Rule... entities) {
		return create(GrammarsEntityDescriptorEnum.Concatenate,
				(IEntity[]) entities);
	}

	public Concatenate createConcatenate(int initialSize) {
		return clone(GrammarsEntityDescriptorEnum.Concatenate, initialSize);
	}

	public Choose createChoose() {
		return create(GrammarsEntityDescriptorEnum.Choose);
	}

	public Choose createChoose(Rule... entities) {
		return create(GrammarsEntityDescriptorEnum.Choose, (IEntity[]) entities);
	}

	public Choose createChoose(int initialSize) {
		return clone(GrammarsEntityDescriptorEnum.Choose, initialSize);
	}

	public When createWhen() {
		return create(GrammarsEntityDescriptorEnum.When);
	}

	public When createWhen(Predicate predicate, Rule rule) {
		return create(GrammarsEntityDescriptorEnum.When, predicate, rule);
	}

	public IEntityBuilder<When> buildWhen() {
		return new EntityBuilder<When>(
				create(GrammarsEntityDescriptorEnum.When));
	}

	public As createAs() {
		return create(GrammarsEntityDescriptorEnum.As);
	}

	public As createAs(Rule rule, Name name) {
		return create(GrammarsEntityDescriptorEnum.As, rule, name);
	}

	public IEntityBuilder<As> buildAs() {
		return new EntityBuilder<As>(create(GrammarsEntityDescriptorEnum.As));
	}

	public Split createSplit() {
		return create(GrammarsEntityDescriptorEnum.Split);
	}

	public Split createSplit(Splitter splitter, Rule rule) {
		return create(GrammarsEntityDescriptorEnum.Split, splitter, rule);
	}

	public IEntityBuilder<Split> buildSplit() {
		return new EntityBuilder<Split>(
				create(GrammarsEntityDescriptorEnum.Split));
	}

	public BySize createBySize() {
		return create(GrammarsEntityDescriptorEnum.BySize);
	}

	public BySize createBySize(int value) {
		return create(GrammarsEntityDescriptorEnum.BySize, value);
	}

	public ByLines createByLines() {
		return create(GrammarsEntityDescriptorEnum.ByLines);
	}

	public ByLines createByLines(int value) {
		return create(GrammarsEntityDescriptorEnum.ByLines, value);
	}

	public ByDelimiter createByDelimiter() {
		return create(GrammarsEntityDescriptorEnum.ByDelimiter);
	}

	public ByDelimiter createByDelimiter(Pattern delimiter) {
		return create(GrammarsEntityDescriptorEnum.ByDelimiter, delimiter);
	}

	public LanguageDescriptor createLanguageDescriptor() {
		return create(GrammarsEntityDescriptorEnum.LanguageDescriptor);
	}

	public LanguageDescriptor createLanguageDescriptor(URI uri,
			Namespace namespace, Name name, Version version) {
		return create(GrammarsEntityDescriptorEnum.LanguageDescriptor, uri,
				namespace, name, version);
	}

	public IEntityBuilder<LanguageDescriptor> buildLanguageDescriptor() {
		return new EntityBuilder<LanguageDescriptor>(
				create(GrammarsEntityDescriptorEnum.LanguageDescriptor));
	}

	public Name createName() {
		return create(GrammarsEntityDescriptorEnum.Name);
	}

	public Name createName(String value) {
		return create(GrammarsEntityDescriptorEnum.Name, value);
	}

	public URI createURI() {
		return create(GrammarsEntityDescriptorEnum.URI);
	}

	public URI createURI(String value) {
		return create(GrammarsEntityDescriptorEnum.URI, value);
	}

	public Namespace createNamespace() {
		return create(GrammarsEntityDescriptorEnum.Namespace);
	}

	public Namespace createNamespace(String value) {
		return create(GrammarsEntityDescriptorEnum.Namespace, value);
	}

	public Version createVersion() {
		return create(GrammarsEntityDescriptorEnum.Version);
	}

	public Version createVersion(String value) {
		return create(GrammarsEntityDescriptorEnum.Version, value);
	}

	public Unbounded createUnbounded() {
		return create(GrammarsEntityDescriptorEnum.Unbounded);
	}

	public Size createSize() {
		return create(GrammarsEntityDescriptorEnum.Size);
	}

	public Size createSize(int value) {
		return create(GrammarsEntityDescriptorEnum.Size, value);
	}

	public Literal createLiteral() {
		return create(GrammarsEntityDescriptorEnum.Literal);
	}

	public Literal createLiteral(String value) {
		return create(GrammarsEntityDescriptorEnum.Literal, value);
	}

	public RegExp createRegExp() {
		return create(GrammarsEntityDescriptorEnum.RegExp);
	}

	public RegExp createRegExp(String value) {
		return create(GrammarsEntityDescriptorEnum.RegExp, value);
	}

	public CompiledPattern createCompiledPattern() {
		return create(GrammarsEntityDescriptorEnum.CompiledPattern);
	}

	public CompiledPattern createCompiledPattern(java.util.regex.Pattern value) {
		return create(GrammarsEntityDescriptorEnum.CompiledPattern, value);
	}

	public Format createFormat() {
		return create(GrammarsEntityDescriptorEnum.Format);
	}

	public Format createFormat(String value) {
		return create(GrammarsEntityDescriptorEnum.Format, value);
	}

	public Category createCategory() {
		return create(GrammarsEntityDescriptorEnum.Category);
	}

	public Category createCategory(CategoryEnum.Value value) {
		return create(GrammarsEntityDescriptorEnum.Category, value);
	}

	public DataType createDataType() {
		return create(GrammarsEntityDescriptorEnum.DataType);
	}

	public DataType createDataType(DataTypeEnum.Value value) {
		return create(GrammarsEntityDescriptorEnum.DataType, value);
	}

	public CustomDataType createCustomDataType() {
		return create(GrammarsEntityDescriptorEnum.CustomDataType);
	}

	public CustomDataType createCustomDataType(String value) {
		return create(GrammarsEntityDescriptorEnum.CustomDataType, value);
	}
}
