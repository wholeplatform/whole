package org.whole.lang.grammars.visitors;

import org.whole.lang.grammars.visitors.GrammarsIdentityUnaryVisitor;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.grammars.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class GrammarsTraverseAllChildrenVisitor extends
		GrammarsIdentityUnaryVisitor<IGrammarsVisitor> {
	public GrammarsTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public GrammarsTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Grammar entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getTargetLanguage().accept(wGetVisitor1());
		entity.getStartSymbol().accept(wGetVisitor1());
		entity.getDelimiter().accept(wGetVisitor1());
		entity.getLexicalStructure().accept(wGetVisitor1());
		entity.getPhraseStructure().accept(wGetVisitor1());
		entity.getUri().accept(wGetVisitor1());
		entity.getNamespace().accept(wGetVisitor1());
		entity.getVersion().accept(wGetVisitor1());
		entity.getSpaceLiteral().accept(wGetVisitor1());
		entity.getIndentLiteral().accept(wGetVisitor1());
		entity.getNewLineLiteral().accept(wGetVisitor1());
	}

	public void visit(Productions entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Production entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getRule().accept(wGetVisitor1());
		entity.getTemplate().accept(wGetVisitor1());
	}

	public void visit(And entity) {
		entity.getPredicate1().accept(wGetVisitor1());
		entity.getPredicate2().accept(wGetVisitor1());
	}

	public void visit(Or entity) {
		entity.getPredicate1().accept(wGetVisitor1());
		entity.getPredicate2().accept(wGetVisitor1());
	}

	public void visit(Not entity) {
		entity.getPredicate().accept(wGetVisitor1());
	}

	public void visit(Empty entity) {
		entity.getLiteral().accept(wGetVisitor1());
	}

	public void visit(Terminal entity) {
		entity.getPattern().accept(wGetVisitor1());
		entity.getCategory().accept(wGetVisitor1());
	}

	public void visit(LiteralTerminal entity) {
		entity.getPattern().accept(wGetVisitor1());
		entity.getCategory().accept(wGetVisitor1());
		entity.getLiteral().accept(wGetVisitor1());
	}

	public void visit(DataTerminal entity) {
		entity.getPattern().accept(wGetVisitor1());
		entity.getCategory().accept(wGetVisitor1());
		entity.getFormat().accept(wGetVisitor1());
	}

	public void visit(Optional entity) {
		entity.getRule().accept(wGetVisitor1());
	}

	public void visit(Repeat entity) {
		entity.getLowerBound().accept(wGetVisitor1());
		entity.getUpperBound().accept(wGetVisitor1());
		entity.getSeparator().accept(wGetVisitor1());
		entity.getRule().accept(wGetVisitor1());
	}

	public void visit(Concatenate entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Choose entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(When entity) {
		entity.getPredicate().accept(wGetVisitor1());
		entity.getRule().accept(wGetVisitor1());
	}

	public void visit(As entity) {
		entity.getRule().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(Split entity) {
		entity.getSplitter().accept(wGetVisitor1());
		entity.getRule().accept(wGetVisitor1());
	}

	public void visit(ByDelimiter entity) {
		entity.getDelimiter().accept(wGetVisitor1());
	}

	public void visit(LanguageDescriptor entity) {
		entity.getUri().accept(wGetVisitor1());
		entity.getNamespace().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getVersion().accept(wGetVisitor1());
	}
}
