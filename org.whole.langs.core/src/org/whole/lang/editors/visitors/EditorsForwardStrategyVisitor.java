package org.whole.lang.editors.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.editors.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class EditorsForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IEditorsVisitor> implements
		IEditorsVisitor {
	public EditorsForwardStrategyVisitor() {
		this(new EditorsIdentityVisitor());
	}

	public EditorsForwardStrategyVisitor(IEditorsVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IEditorsEntity) entity).accept(this);
	}

	public void visit(Editor entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ModelComponent entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ControllerComponent entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ControllerDeclarations entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PartDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(JavaPartDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(GenericPartDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EntityFeatures entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(GenericPartName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ViewComponent entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ViewDeclarations entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleFigureDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FoldableTextualFigure entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TextualFigure entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Row entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ChildPlace entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Indent entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FoldingToggle entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(KeywordToken entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LiteralToken entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IdentifierToken entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(OperatorToken entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DelimiterToken entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ParenthesisToken entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EntityNames entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Identifier entity) {
		wGetStrategy().visit(entity);
	}
}
