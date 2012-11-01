package org.whole.lang.grammars.visitors;

import org.whole.lang.grammars.model.*;

/** 
 * @generator Whole
 */
public class GrammarsIdentityDefaultVisitor extends GrammarsIdentityVisitor {
	public void visit(IGrammarsEntity entity) {
	}

	public void visit(Grammar entity) {
		visit((IGrammarsEntity) entity);
	}

	public void visit(Productions entity) {
		visit((IGrammarsEntity) entity);
	}

	public void visit(Rule entity) {
		visit((Predicate) entity);
	}

	public void visit(Production entity) {
		visit((IGrammarsEntity) entity);
		visit((Rule) entity);
	}

	public void visit(Predicate entity) {
	}

	public void visit(And entity) {
		visit((IGrammarsEntity) entity);
		visit((Predicate) entity);
	}

	public void visit(Or entity) {
		visit((IGrammarsEntity) entity);
		visit((Predicate) entity);
	}

	public void visit(Not entity) {
		visit((IGrammarsEntity) entity);
		visit((Predicate) entity);
	}

	public void visit(EpsilonRule entity) {
		visit((Rule) entity);
	}

	public void visit(Empty entity) {
		visit((IGrammarsEntity) entity);
		visit((EpsilonRule) entity);
	}

	public void visit(Space entity) {
		visit((IGrammarsEntity) entity);
		visit((EpsilonRule) entity);
	}

	public void visit(Indent entity) {
		visit((IGrammarsEntity) entity);
		visit((EpsilonRule) entity);
	}

	public void visit(NewLine entity) {
		visit((IGrammarsEntity) entity);
		visit((EpsilonRule) entity);
	}

	public void visit(Terminal entity) {
		visit((Rule) entity);
	}

	public void visit(LiteralTerminal entity) {
		visit((IGrammarsEntity) entity);
		visit((Terminal) entity);
	}

	public void visit(DataTerminal entity) {
		visit((IGrammarsEntity) entity);
		visit((Terminal) entity);
	}

	public void visit(NonTerminal entity) {
		visit((IGrammarsEntity) entity);
		visit((Rule) entity);
	}

	public void visit(Optional entity) {
		visit((IGrammarsEntity) entity);
		visit((Rule) entity);
	}

	public void visit(Repeat entity) {
		visit((IGrammarsEntity) entity);
		visit((Rule) entity);
	}

	public void visit(Concatenate entity) {
		visit((IGrammarsEntity) entity);
		visit((Rule) entity);
	}

	public void visit(Choose entity) {
		visit((IGrammarsEntity) entity);
		visit((Rule) entity);
	}

	public void visit(When entity) {
		visit((IGrammarsEntity) entity);
		visit((Rule) entity);
	}

	public void visit(As entity) {
		visit((IGrammarsEntity) entity);
		visit((Rule) entity);
	}

	public void visit(Split entity) {
		visit((IGrammarsEntity) entity);
		visit((Rule) entity);
	}

	public void visit(Splitter entity) {
	}

	public void visit(BySize entity) {
		visit((IGrammarsEntity) entity);
		visit((Splitter) entity);
	}

	public void visit(ByLines entity) {
		visit((IGrammarsEntity) entity);
		visit((Splitter) entity);
	}

	public void visit(ByDelimiter entity) {
		visit((IGrammarsEntity) entity);
		visit((Splitter) entity);
	}

	public void visit(TargetLanguage entity) {
	}

	public void visit(LanguageDescriptor entity) {
		visit((IGrammarsEntity) entity);
		visit((TargetLanguage) entity);
	}

	public void visit(Name entity) {
		visit((IGrammarsEntity) entity);
	}

	public void visit(URI entity) {
		visit((IGrammarsEntity) entity);
		visit((TargetLanguage) entity);
	}

	public void visit(Namespace entity) {
		visit((IGrammarsEntity) entity);
	}

	public void visit(Version entity) {
		visit((IGrammarsEntity) entity);
	}

	public void visit(Bound entity) {
	}

	public void visit(Unbounded entity) {
		visit((IGrammarsEntity) entity);
		visit((Bound) entity);
	}

	public void visit(Size entity) {
		visit((IGrammarsEntity) entity);
		visit((Bound) entity);
	}

	public void visit(Literal entity) {
		visit((IGrammarsEntity) entity);
	}

	public void visit(Pattern entity) {
	}

	public void visit(RegExp entity) {
		visit((IGrammarsEntity) entity);
		visit((Pattern) entity);
	}

	public void visit(CompiledPattern entity) {
		visit((IGrammarsEntity) entity);
		visit((Pattern) entity);
	}

	public void visit(Format entity) {
		visit((IGrammarsEntity) entity);
	}

	public void visit(Category entity) {
		visit((IGrammarsEntity) entity);
	}

	public void visit(DataType entity) {
		visit((IGrammarsEntity) entity);
		visit((Template) entity);
	}

	public void visit(Template entity) {
	}

	public void visit(CustomDataType entity) {
		visit((IGrammarsEntity) entity);
		visit((Template) entity);
	}
}
