package org.whole.lang.grammars.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.grammars.model.*;

/** 
 * @generator Whole
 */
public interface IGrammarsVisitor extends IVisitor {
	public void visit(Grammar entity);

	public void visit(Productions entity);

	public void visit(Production entity);

	public void visit(And entity);

	public void visit(Or entity);

	public void visit(Not entity);

	public void visit(Empty entity);

	public void visit(Space entity);

	public void visit(Indent entity);

	public void visit(NewLine entity);

	public void visit(LiteralTerminal entity);

	public void visit(DataTerminal entity);

	public void visit(NonTerminal entity);

	public void visit(Optional entity);

	public void visit(Repeat entity);

	public void visit(Concatenate entity);

	public void visit(Choose entity);

	public void visit(When entity);

	public void visit(As entity);

	public void visit(Split entity);

	public void visit(BySize entity);

	public void visit(ByLines entity);

	public void visit(ByDelimiter entity);

	public void visit(LanguageDescriptor entity);

	public void visit(Name entity);

	public void visit(URI entity);

	public void visit(Namespace entity);

	public void visit(Version entity);

	public void visit(Unbounded entity);

	public void visit(Size entity);

	public void visit(Literal entity);

	public void visit(RegExp entity);

	public void visit(CompiledPattern entity);

	public void visit(Format entity);

	public void visit(Category entity);

	public void visit(DataType entity);

	public void visit(CustomDataType entity);
}
