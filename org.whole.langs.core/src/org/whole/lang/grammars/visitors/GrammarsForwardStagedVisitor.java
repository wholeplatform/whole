package org.whole.lang.grammars.visitors;

import org.whole.lang.grammars.model.*;

/** 
 * @generator Whole
 */
public class GrammarsForwardStagedVisitor extends GrammarsIdentityVisitor {
	public void visit(Grammar entity) {
		stagedVisit(entity);
	}

	public void visit(Productions entity) {
		stagedVisit(entity);
	}

	public void visit(Production entity) {
		stagedVisit(entity);
	}

	public void visit(And entity) {
		stagedVisit(entity);
	}

	public void visit(Or entity) {
		stagedVisit(entity);
	}

	public void visit(Not entity) {
		stagedVisit(entity);
	}

	public void visit(Empty entity) {
		stagedVisit(entity);
	}

	public void visit(Space entity) {
		stagedVisit(entity);
	}

	public void visit(Indent entity) {
		stagedVisit(entity);
	}

	public void visit(NewLine entity) {
		stagedVisit(entity);
	}

	public void visit(LiteralTerminal entity) {
		stagedVisit(entity);
	}

	public void visit(DataTerminal entity) {
		stagedVisit(entity);
	}

	public void visit(NonTerminal entity) {
		stagedVisit(entity);
	}

	public void visit(Optional entity) {
		stagedVisit(entity);
	}

	public void visit(Repeat entity) {
		stagedVisit(entity);
	}

	public void visit(Concatenate entity) {
		stagedVisit(entity);
	}

	public void visit(Choose entity) {
		stagedVisit(entity);
	}

	public void visit(When entity) {
		stagedVisit(entity);
	}

	public void visit(As entity) {
		stagedVisit(entity);
	}

	public void visit(Split entity) {
		stagedVisit(entity);
	}

	public void visit(BySize entity) {
		stagedVisit(entity);
	}

	public void visit(ByLines entity) {
		stagedVisit(entity);
	}

	public void visit(ByDelimiter entity) {
		stagedVisit(entity);
	}

	public void visit(LanguageDescriptor entity) {
		stagedVisit(entity);
	}

	public void visit(Name entity) {
		stagedVisit(entity);
	}

	public void visit(URI entity) {
		stagedVisit(entity);
	}

	public void visit(Namespace entity) {
		stagedVisit(entity);
	}

	public void visit(Version entity) {
		stagedVisit(entity);
	}

	public void visit(Unbounded entity) {
		stagedVisit(entity);
	}

	public void visit(Size entity) {
		stagedVisit(entity);
	}

	public void visit(Literal entity) {
		stagedVisit(entity);
	}

	public void visit(RegExp entity) {
		stagedVisit(entity);
	}

	public void visit(CompiledPattern entity) {
		stagedVisit(entity);
	}

	public void visit(Format entity) {
		stagedVisit(entity);
	}

	public void visit(Category entity) {
		stagedVisit(entity);
	}

	public void visit(DataType entity) {
		stagedVisit(entity);
	}

	public void visit(CustomDataType entity) {
		stagedVisit(entity);
	}
}
