package org.whole.lang.grammars.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class GrammarsForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements IGrammarsVisitor {
	public GrammarsForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Grammar entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Productions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Production entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(And entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Or entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Not entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Empty entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Space entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Indent entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(NewLine entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LiteralTerminal entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DataTerminal entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(NonTerminal entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Optional entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Repeat entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Concatenate entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Choose entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(When entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(As entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Split entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BySize entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ByLines entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ByDelimiter entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LanguageDescriptor entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Name entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(URI entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Namespace entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Version entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Unbounded entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Size entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Literal entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(RegExp entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CompiledPattern entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Format entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Category entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DataType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CustomDataType entity) {
		wGetVisitor1().visit(entity);
	}
}
