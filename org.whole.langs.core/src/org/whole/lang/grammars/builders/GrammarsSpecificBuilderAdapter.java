package org.whole.lang.grammars.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import java.util.regex.Pattern;
import org.whole.lang.grammars.model.CategoryEnum;
import org.whole.lang.grammars.model.DataTypeEnum;

/** 
 * @generator Whole
 */
public class GrammarsSpecificBuilderAdapter extends GenericBuilderContext
		implements IGrammarsBuilder {
	public GrammarsSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public GrammarsSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void splitter() {
		wFeature(GrammarsFeatureDescriptorEnum.splitter);
	}

	public void separator() {
		wFeature(GrammarsFeatureDescriptorEnum.separator);
	}

	public void upperBound() {
		wFeature(GrammarsFeatureDescriptorEnum.upperBound);
	}

	public void lowerBound() {
		wFeature(GrammarsFeatureDescriptorEnum.lowerBound);
	}

	public void format() {
		wFeature(GrammarsFeatureDescriptorEnum.format);
	}

	public void category() {
		wFeature(GrammarsFeatureDescriptorEnum.category);
	}

	public void pattern() {
		wFeature(GrammarsFeatureDescriptorEnum.pattern);
	}

	public void literal() {
		wFeature(GrammarsFeatureDescriptorEnum.literal);
	}

	public void predicate() {
		wFeature(GrammarsFeatureDescriptorEnum.predicate);
	}

	public void predicate2() {
		wFeature(GrammarsFeatureDescriptorEnum.predicate2);
	}

	public void predicate1() {
		wFeature(GrammarsFeatureDescriptorEnum.predicate1);
	}

	public void template() {
		wFeature(GrammarsFeatureDescriptorEnum.template);
	}

	public void rule() {
		wFeature(GrammarsFeatureDescriptorEnum.rule);
	}

	public void newLineLiteral() {
		wFeature(GrammarsFeatureDescriptorEnum.newLineLiteral);
	}

	public void indentLiteral() {
		wFeature(GrammarsFeatureDescriptorEnum.indentLiteral);
	}

	public void spaceLiteral() {
		wFeature(GrammarsFeatureDescriptorEnum.spaceLiteral);
	}

	public void version() {
		wFeature(GrammarsFeatureDescriptorEnum.version);
	}

	public void namespace() {
		wFeature(GrammarsFeatureDescriptorEnum.namespace);
	}

	public void uri() {
		wFeature(GrammarsFeatureDescriptorEnum.uri);
	}

	public void phraseStructure() {
		wFeature(GrammarsFeatureDescriptorEnum.phraseStructure);
	}

	public void lexicalStructure() {
		wFeature(GrammarsFeatureDescriptorEnum.lexicalStructure);
	}

	public void delimiter() {
		wFeature(GrammarsFeatureDescriptorEnum.delimiter);
	}

	public void startSymbol() {
		wFeature(GrammarsFeatureDescriptorEnum.startSymbol);
	}

	public void targetLanguage() {
		wFeature(GrammarsFeatureDescriptorEnum.targetLanguage);
	}

	public void name() {
		wFeature(GrammarsFeatureDescriptorEnum.name);
	}

	public void visit() {
	}

	public void Grammar() {
		wEntity(GrammarsEntityDescriptorEnum.Grammar);
	}

	public void Grammar_() {
		wEntity_(GrammarsEntityDescriptorEnum.Grammar);
	}

	public void _Grammar() {
		_wEntity(GrammarsEntityDescriptorEnum.Grammar);
	}

	public void Productions() {
		wEntity(GrammarsEntityDescriptorEnum.Productions);
	}

	public void Productions_() {
		wEntity_(GrammarsEntityDescriptorEnum.Productions);
	}

	public void Productions_(int initialCapacity) {
		wEntity_(GrammarsEntityDescriptorEnum.Productions, initialCapacity);
	}

	public void _Productions() {
		_wEntity(GrammarsEntityDescriptorEnum.Productions);
	}

	public void Production() {
		wEntity(GrammarsEntityDescriptorEnum.Production);
	}

	public void Production_() {
		wEntity_(GrammarsEntityDescriptorEnum.Production);
	}

	public void _Production() {
		_wEntity(GrammarsEntityDescriptorEnum.Production);
	}

	public void And() {
		wEntity(GrammarsEntityDescriptorEnum.And);
	}

	public void And_() {
		wEntity_(GrammarsEntityDescriptorEnum.And);
	}

	public void _And() {
		_wEntity(GrammarsEntityDescriptorEnum.And);
	}

	public void Or() {
		wEntity(GrammarsEntityDescriptorEnum.Or);
	}

	public void Or_() {
		wEntity_(GrammarsEntityDescriptorEnum.Or);
	}

	public void _Or() {
		_wEntity(GrammarsEntityDescriptorEnum.Or);
	}

	public void Not() {
		wEntity(GrammarsEntityDescriptorEnum.Not);
	}

	public void Not_() {
		wEntity_(GrammarsEntityDescriptorEnum.Not);
	}

	public void _Not() {
		_wEntity(GrammarsEntityDescriptorEnum.Not);
	}

	public void Empty() {
		wEntity(GrammarsEntityDescriptorEnum.Empty);
	}

	public void Empty_() {
		wEntity_(GrammarsEntityDescriptorEnum.Empty);
	}

	public void _Empty() {
		_wEntity(GrammarsEntityDescriptorEnum.Empty);
	}

	public void Space() {
		wEntity(GrammarsEntityDescriptorEnum.Space);
	}

	public void Space_() {
		wEntity_(GrammarsEntityDescriptorEnum.Space);
	}

	public void _Space() {
		_wEntity(GrammarsEntityDescriptorEnum.Space);
	}

	public void Indent() {
		wEntity(GrammarsEntityDescriptorEnum.Indent);
	}

	public void Indent_() {
		wEntity_(GrammarsEntityDescriptorEnum.Indent);
	}

	public void _Indent() {
		_wEntity(GrammarsEntityDescriptorEnum.Indent);
	}

	public void NewLine() {
		wEntity(GrammarsEntityDescriptorEnum.NewLine);
	}

	public void NewLine_() {
		wEntity_(GrammarsEntityDescriptorEnum.NewLine);
	}

	public void _NewLine() {
		_wEntity(GrammarsEntityDescriptorEnum.NewLine);
	}

	public void LiteralTerminal() {
		wEntity(GrammarsEntityDescriptorEnum.LiteralTerminal);
	}

	public void LiteralTerminal_() {
		wEntity_(GrammarsEntityDescriptorEnum.LiteralTerminal);
	}

	public void _LiteralTerminal() {
		_wEntity(GrammarsEntityDescriptorEnum.LiteralTerminal);
	}

	public void DataTerminal() {
		wEntity(GrammarsEntityDescriptorEnum.DataTerminal);
	}

	public void DataTerminal_() {
		wEntity_(GrammarsEntityDescriptorEnum.DataTerminal);
	}

	public void _DataTerminal() {
		_wEntity(GrammarsEntityDescriptorEnum.DataTerminal);
	}

	public void NonTerminal() {
		wEntity(GrammarsEntityDescriptorEnum.NonTerminal);
	}

	public void NonTerminal(String value) {
		wEntity(GrammarsEntityDescriptorEnum.NonTerminal, value);
	}

	public void Optional() {
		wEntity(GrammarsEntityDescriptorEnum.Optional);
	}

	public void Optional_() {
		wEntity_(GrammarsEntityDescriptorEnum.Optional);
	}

	public void _Optional() {
		_wEntity(GrammarsEntityDescriptorEnum.Optional);
	}

	public void Repeat() {
		wEntity(GrammarsEntityDescriptorEnum.Repeat);
	}

	public void Repeat_() {
		wEntity_(GrammarsEntityDescriptorEnum.Repeat);
	}

	public void _Repeat() {
		_wEntity(GrammarsEntityDescriptorEnum.Repeat);
	}

	public void Concatenate() {
		wEntity(GrammarsEntityDescriptorEnum.Concatenate);
	}

	public void Concatenate_() {
		wEntity_(GrammarsEntityDescriptorEnum.Concatenate);
	}

	public void Concatenate_(int initialCapacity) {
		wEntity_(GrammarsEntityDescriptorEnum.Concatenate, initialCapacity);
	}

	public void _Concatenate() {
		_wEntity(GrammarsEntityDescriptorEnum.Concatenate);
	}

	public void Choose() {
		wEntity(GrammarsEntityDescriptorEnum.Choose);
	}

	public void Choose_() {
		wEntity_(GrammarsEntityDescriptorEnum.Choose);
	}

	public void Choose_(int initialCapacity) {
		wEntity_(GrammarsEntityDescriptorEnum.Choose, initialCapacity);
	}

	public void _Choose() {
		_wEntity(GrammarsEntityDescriptorEnum.Choose);
	}

	public void When() {
		wEntity(GrammarsEntityDescriptorEnum.When);
	}

	public void When_() {
		wEntity_(GrammarsEntityDescriptorEnum.When);
	}

	public void _When() {
		_wEntity(GrammarsEntityDescriptorEnum.When);
	}

	public void As() {
		wEntity(GrammarsEntityDescriptorEnum.As);
	}

	public void As_() {
		wEntity_(GrammarsEntityDescriptorEnum.As);
	}

	public void _As() {
		_wEntity(GrammarsEntityDescriptorEnum.As);
	}

	public void Split() {
		wEntity(GrammarsEntityDescriptorEnum.Split);
	}

	public void Split_() {
		wEntity_(GrammarsEntityDescriptorEnum.Split);
	}

	public void _Split() {
		_wEntity(GrammarsEntityDescriptorEnum.Split);
	}

	public void BySize() {
		wEntity(GrammarsEntityDescriptorEnum.BySize);
	}

	public void BySize(int value) {
		wEntity(GrammarsEntityDescriptorEnum.BySize, value);
	}

	public void ByLines() {
		wEntity(GrammarsEntityDescriptorEnum.ByLines);
	}

	public void ByLines(int value) {
		wEntity(GrammarsEntityDescriptorEnum.ByLines, value);
	}

	public void ByDelimiter() {
		wEntity(GrammarsEntityDescriptorEnum.ByDelimiter);
	}

	public void ByDelimiter_() {
		wEntity_(GrammarsEntityDescriptorEnum.ByDelimiter);
	}

	public void _ByDelimiter() {
		_wEntity(GrammarsEntityDescriptorEnum.ByDelimiter);
	}

	public void LanguageDescriptor() {
		wEntity(GrammarsEntityDescriptorEnum.LanguageDescriptor);
	}

	public void LanguageDescriptor_() {
		wEntity_(GrammarsEntityDescriptorEnum.LanguageDescriptor);
	}

	public void _LanguageDescriptor() {
		_wEntity(GrammarsEntityDescriptorEnum.LanguageDescriptor);
	}

	public void Name() {
		wEntity(GrammarsEntityDescriptorEnum.Name);
	}

	public void Name(String value) {
		wEntity(GrammarsEntityDescriptorEnum.Name, value);
	}

	public void URI() {
		wEntity(GrammarsEntityDescriptorEnum.URI);
	}

	public void URI(String value) {
		wEntity(GrammarsEntityDescriptorEnum.URI, value);
	}

	public void Namespace() {
		wEntity(GrammarsEntityDescriptorEnum.Namespace);
	}

	public void Namespace(String value) {
		wEntity(GrammarsEntityDescriptorEnum.Namespace, value);
	}

	public void Version() {
		wEntity(GrammarsEntityDescriptorEnum.Version);
	}

	public void Version(String value) {
		wEntity(GrammarsEntityDescriptorEnum.Version, value);
	}

	public void Unbounded() {
		wEntity(GrammarsEntityDescriptorEnum.Unbounded);
	}

	public void Unbounded_() {
		wEntity_(GrammarsEntityDescriptorEnum.Unbounded);
	}

	public void _Unbounded() {
		_wEntity(GrammarsEntityDescriptorEnum.Unbounded);
	}

	public void Size() {
		wEntity(GrammarsEntityDescriptorEnum.Size);
	}

	public void Size(int value) {
		wEntity(GrammarsEntityDescriptorEnum.Size, value);
	}

	public void Literal() {
		wEntity(GrammarsEntityDescriptorEnum.Literal);
	}

	public void Literal(String value) {
		wEntity(GrammarsEntityDescriptorEnum.Literal, value);
	}

	public void RegExp() {
		wEntity(GrammarsEntityDescriptorEnum.RegExp);
	}

	public void RegExp(String value) {
		wEntity(GrammarsEntityDescriptorEnum.RegExp, value);
	}

	public void CompiledPattern() {
		wEntity(GrammarsEntityDescriptorEnum.CompiledPattern);
	}

	public void CompiledPattern(Pattern value) {
		wEntity(GrammarsEntityDescriptorEnum.CompiledPattern, value);
	}

	public void CompiledPattern(String value) {
		wEntity(GrammarsEntityDescriptorEnum.CompiledPattern, value);
	}

	public void Format() {
		wEntity(GrammarsEntityDescriptorEnum.Format);
	}

	public void Format(String value) {
		wEntity(GrammarsEntityDescriptorEnum.Format, value);
	}

	public void Category() {
		wEntity(GrammarsEntityDescriptorEnum.Category);
	}

	public void Category(CategoryEnum.Value value) {
		wEntity(GrammarsEntityDescriptorEnum.Category, value);
	}

	public void Category(String value) {
		wEntity(GrammarsEntityDescriptorEnum.Category, value);
	}

	public void DataType() {
		wEntity(GrammarsEntityDescriptorEnum.DataType);
	}

	public void DataType(DataTypeEnum.Value value) {
		wEntity(GrammarsEntityDescriptorEnum.DataType, value);
	}

	public void DataType(String value) {
		wEntity(GrammarsEntityDescriptorEnum.DataType, value);
	}

	public void CustomDataType() {
		wEntity(GrammarsEntityDescriptorEnum.CustomDataType);
	}

	public void CustomDataType(String value) {
		wEntity(GrammarsEntityDescriptorEnum.CustomDataType, value);
	}
}
