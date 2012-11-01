package org.whole.lang.grammars.visitors;

import org.whole.lang.grammars.visitors.GrammarsIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.grammars.model.*;

/** 
 * @generator Whole
 */
public class GrammarsTraverseAllSwitchVisitor extends
		GrammarsIdentityUnaryVisitor<IVisitor> {
	public GrammarsTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Grammar entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTargetLanguage());
		wGetVisitor1().visit(entity.getStartSymbol());
		wGetVisitor1().visit(entity.getDelimiter());
		wGetVisitor1().visit(entity.getLexicalStructure());
		wGetVisitor1().visit(entity.getPhraseStructure());
		wGetVisitor1().visit(entity.getUri());
		wGetVisitor1().visit(entity.getNamespace());
		wGetVisitor1().visit(entity.getVersion());
		wGetVisitor1().visit(entity.getSpaceLiteral());
		wGetVisitor1().visit(entity.getIndentLiteral());
		wGetVisitor1().visit(entity.getNewLineLiteral());
	}

	public void visit(Productions entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Production entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getRule());
		wGetVisitor1().visit(entity.getTemplate());
	}

	public void visit(And entity) {
		wGetVisitor1().visit(entity.getPredicate1());
		wGetVisitor1().visit(entity.getPredicate2());
	}

	public void visit(Or entity) {
		wGetVisitor1().visit(entity.getPredicate1());
		wGetVisitor1().visit(entity.getPredicate2());
	}

	public void visit(Not entity) {
		wGetVisitor1().visit(entity.getPredicate());
	}

	public void visit(Empty entity) {
		wGetVisitor1().visit(entity.getLiteral());
	}

	public void visit(Terminal entity) {
		wGetVisitor1().visit(entity.getPattern());
		wGetVisitor1().visit(entity.getCategory());
	}

	public void visit(LiteralTerminal entity) {
		wGetVisitor1().visit(entity.getPattern());
		wGetVisitor1().visit(entity.getCategory());
		wGetVisitor1().visit(entity.getLiteral());
	}

	public void visit(DataTerminal entity) {
		wGetVisitor1().visit(entity.getPattern());
		wGetVisitor1().visit(entity.getCategory());
		wGetVisitor1().visit(entity.getFormat());
	}

	public void visit(Optional entity) {
		wGetVisitor1().visit(entity.getRule());
	}

	public void visit(Repeat entity) {
		wGetVisitor1().visit(entity.getLowerBound());
		wGetVisitor1().visit(entity.getUpperBound());
		wGetVisitor1().visit(entity.getSeparator());
		wGetVisitor1().visit(entity.getRule());
	}

	public void visit(Concatenate entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Choose entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(When entity) {
		wGetVisitor1().visit(entity.getPredicate());
		wGetVisitor1().visit(entity.getRule());
	}

	public void visit(As entity) {
		wGetVisitor1().visit(entity.getRule());
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(Split entity) {
		wGetVisitor1().visit(entity.getSplitter());
		wGetVisitor1().visit(entity.getRule());
	}

	public void visit(ByDelimiter entity) {
		wGetVisitor1().visit(entity.getDelimiter());
	}

	public void visit(LanguageDescriptor entity) {
		wGetVisitor1().visit(entity.getUri());
		wGetVisitor1().visit(entity.getNamespace());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getVersion());
	}
}
