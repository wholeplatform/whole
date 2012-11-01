package org.whole.lang.grammars.visitors;

import org.whole.lang.grammars.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class GrammarsFailureVisitor extends GrammarsIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Grammar entity) {
		throw new VisitException();
	}

	public void visit(Productions entity) {
		throw new VisitException();
	}

	public void visit(Production entity) {
		throw new VisitException();
	}

	public void visit(And entity) {
		throw new VisitException();
	}

	public void visit(Or entity) {
		throw new VisitException();
	}

	public void visit(Not entity) {
		throw new VisitException();
	}

	public void visit(Empty entity) {
		throw new VisitException();
	}

	public void visit(Space entity) {
		throw new VisitException();
	}

	public void visit(Indent entity) {
		throw new VisitException();
	}

	public void visit(NewLine entity) {
		throw new VisitException();
	}

	public void visit(LiteralTerminal entity) {
		throw new VisitException();
	}

	public void visit(DataTerminal entity) {
		throw new VisitException();
	}

	public void visit(NonTerminal entity) {
		throw new VisitException();
	}

	public void visit(Optional entity) {
		throw new VisitException();
	}

	public void visit(Repeat entity) {
		throw new VisitException();
	}

	public void visit(Concatenate entity) {
		throw new VisitException();
	}

	public void visit(Choose entity) {
		throw new VisitException();
	}

	public void visit(When entity) {
		throw new VisitException();
	}

	public void visit(As entity) {
		throw new VisitException();
	}

	public void visit(Split entity) {
		throw new VisitException();
	}

	public void visit(BySize entity) {
		throw new VisitException();
	}

	public void visit(ByLines entity) {
		throw new VisitException();
	}

	public void visit(ByDelimiter entity) {
		throw new VisitException();
	}

	public void visit(LanguageDescriptor entity) {
		throw new VisitException();
	}

	public void visit(Name entity) {
		throw new VisitException();
	}

	public void visit(URI entity) {
		throw new VisitException();
	}

	public void visit(Namespace entity) {
		throw new VisitException();
	}

	public void visit(Version entity) {
		throw new VisitException();
	}

	public void visit(Unbounded entity) {
		throw new VisitException();
	}

	public void visit(Size entity) {
		throw new VisitException();
	}

	public void visit(Literal entity) {
		throw new VisitException();
	}

	public void visit(RegExp entity) {
		throw new VisitException();
	}

	public void visit(CompiledPattern entity) {
		throw new VisitException();
	}

	public void visit(Format entity) {
		throw new VisitException();
	}

	public void visit(Category entity) {
		throw new VisitException();
	}

	public void visit(DataType entity) {
		throw new VisitException();
	}

	public void visit(CustomDataType entity) {
		throw new VisitException();
	}
}
