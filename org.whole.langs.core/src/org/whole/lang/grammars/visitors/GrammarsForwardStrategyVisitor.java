package org.whole.lang.grammars.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class GrammarsForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IGrammarsVisitor> implements
		IGrammarsVisitor {
	public GrammarsForwardStrategyVisitor() {
		this(new GrammarsIdentityVisitor());
	}

	public GrammarsForwardStrategyVisitor(IGrammarsVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IGrammarsEntity) entity).accept(this);
	}

	public void visit(Grammar entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Productions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Production entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(And entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Or entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Not entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Empty entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Space entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Indent entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NewLine entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LiteralTerminal entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DataTerminal entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NonTerminal entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Optional entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Repeat entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Concatenate entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Choose entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(When entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(As entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Split entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BySize entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ByLines entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ByDelimiter entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LanguageDescriptor entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Name entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(URI entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Namespace entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Version entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Unbounded entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Size entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Literal entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(RegExp entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CompiledPattern entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Format entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Category entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DataType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CustomDataType entity) {
		wGetStrategy().visit(entity);
	}
}
