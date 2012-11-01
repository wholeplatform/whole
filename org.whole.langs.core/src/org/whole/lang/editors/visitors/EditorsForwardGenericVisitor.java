package org.whole.lang.editors.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.editors.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class EditorsForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements IEditorsVisitor {
	public EditorsForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Editor entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ModelComponent entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ControllerComponent entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ControllerDeclarations entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PartDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(JavaPartDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(GenericPartDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EntityFeatures entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(GenericPartName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ViewComponent entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ViewDeclarations entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SimpleFigureDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FoldableTextualFigure entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TextualFigure entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Row entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ChildPlace entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Indent entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FoldingToggle entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(KeywordToken entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LiteralToken entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IdentifierToken entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(OperatorToken entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DelimiterToken entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ParenthesisToken entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EntityNames entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Identifier entity) {
		wGetVisitor1().visit(entity);
	}
}
