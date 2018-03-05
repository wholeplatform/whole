package org.whole.lang.text.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.text.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TextForwardStrategyVisitor extends GenericForwardStrategyVisitor<ITextVisitor> implements ITextVisitor {
	public TextForwardStrategyVisitor() {
		this(new TextIdentityVisitor());
	}

	public TextForwardStrategyVisitor(ITextVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((ITextEntity) entity).accept(this);
	}

	public void visit(Document entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Indent entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(RowSeparator entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TextSeparator entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Row entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Text entity) {
		wGetStrategy().visit(entity);
	}
}
