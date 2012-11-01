package org.whole.lang.grammars.builders;

import org.whole.lang.builders.IBuilder;
import java.util.regex.Pattern;
import org.whole.lang.grammars.model.CategoryEnum;
import org.whole.lang.grammars.model.DataTypeEnum;

/** 
 * @generator Whole
 */
public interface IGrammarsBuilder extends IBuilder {
	public void visit();

	public void splitter();

	public void separator();

	public void upperBound();

	public void lowerBound();

	public void format();

	public void category();

	public void pattern();

	public void literal();

	public void predicate();

	public void predicate2();

	public void predicate1();

	public void template();

	public void rule();

	public void newLineLiteral();

	public void indentLiteral();

	public void spaceLiteral();

	public void version();

	public void namespace();

	public void uri();

	public void phraseStructure();

	public void lexicalStructure();

	public void delimiter();

	public void startSymbol();

	public void targetLanguage();

	public void name();

	public void Grammar();

	public void Grammar_();

	public void _Grammar();

	public void Productions();

	public void Productions_();

	public void Productions_(int initialCapacity);

	public void _Productions();

	public void Production();

	public void Production_();

	public void _Production();

	public void And();

	public void And_();

	public void _And();

	public void Or();

	public void Or_();

	public void _Or();

	public void Not();

	public void Not_();

	public void _Not();

	public void Empty();

	public void Empty_();

	public void _Empty();

	public void Space();

	public void Space_();

	public void _Space();

	public void Indent();

	public void Indent_();

	public void _Indent();

	public void NewLine();

	public void NewLine_();

	public void _NewLine();

	public void LiteralTerminal();

	public void LiteralTerminal_();

	public void _LiteralTerminal();

	public void DataTerminal();

	public void DataTerminal_();

	public void _DataTerminal();

	public void NonTerminal();

	public void NonTerminal(String value);

	public void Optional();

	public void Optional_();

	public void _Optional();

	public void Repeat();

	public void Repeat_();

	public void _Repeat();

	public void Concatenate();

	public void Concatenate_();

	public void Concatenate_(int initialCapacity);

	public void _Concatenate();

	public void Choose();

	public void Choose_();

	public void Choose_(int initialCapacity);

	public void _Choose();

	public void When();

	public void When_();

	public void _When();

	public void As();

	public void As_();

	public void _As();

	public void Split();

	public void Split_();

	public void _Split();

	public void BySize();

	public void BySize(int value);

	public void ByLines();

	public void ByLines(int value);

	public void ByDelimiter();

	public void ByDelimiter_();

	public void _ByDelimiter();

	public void LanguageDescriptor();

	public void LanguageDescriptor_();

	public void _LanguageDescriptor();

	public void Name();

	public void Name(String value);

	public void URI();

	public void URI(String value);

	public void Namespace();

	public void Namespace(String value);

	public void Version();

	public void Version(String value);

	public void Unbounded();

	public void Unbounded_();

	public void _Unbounded();

	public void Size();

	public void Size(int value);

	public void Literal();

	public void Literal(String value);

	public void RegExp();

	public void RegExp(String value);

	public void CompiledPattern();

	public void CompiledPattern(Pattern value);

	public void CompiledPattern(String value);

	public void Format();

	public void Format(String value);

	public void Category();

	public void Category(CategoryEnum.Value value);

	public void Category(String value);

	public void DataType();

	public void DataType(DataTypeEnum.Value value);

	public void DataType(String value);

	public void CustomDataType();

	public void CustomDataType(String value);
}
