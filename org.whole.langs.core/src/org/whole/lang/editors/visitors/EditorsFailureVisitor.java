package org.whole.lang.editors.visitors;

import org.whole.lang.editors.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class EditorsFailureVisitor extends EditorsIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Editor entity) {
		throw new VisitException();
	}

	public void visit(ModelComponent entity) {
		throw new VisitException();
	}

	public void visit(ControllerComponent entity) {
		throw new VisitException();
	}

	public void visit(ControllerDeclarations entity) {
		throw new VisitException();
	}

	public void visit(PartDeclaration entity) {
		throw new VisitException();
	}

	public void visit(JavaPartDeclaration entity) {
		throw new VisitException();
	}

	public void visit(GenericPartDeclaration entity) {
		throw new VisitException();
	}

	public void visit(EntityFeatures entity) {
		throw new VisitException();
	}

	public void visit(GenericPartName entity) {
		throw new VisitException();
	}

	public void visit(ViewComponent entity) {
		throw new VisitException();
	}

	public void visit(ViewDeclarations entity) {
		throw new VisitException();
	}

	public void visit(SimpleFigureDeclaration entity) {
		throw new VisitException();
	}

	public void visit(FoldableTextualFigure entity) {
		throw new VisitException();
	}

	public void visit(TextualFigure entity) {
		throw new VisitException();
	}

	public void visit(Row entity) {
		throw new VisitException();
	}

	public void visit(ChildPlace entity) {
		throw new VisitException();
	}

	public void visit(Indent entity) {
		throw new VisitException();
	}

	public void visit(FoldingToggle entity) {
		throw new VisitException();
	}

	public void visit(KeywordToken entity) {
		throw new VisitException();
	}

	public void visit(LiteralToken entity) {
		throw new VisitException();
	}

	public void visit(IdentifierToken entity) {
		throw new VisitException();
	}

	public void visit(OperatorToken entity) {
		throw new VisitException();
	}

	public void visit(DelimiterToken entity) {
		throw new VisitException();
	}

	public void visit(ParenthesisToken entity) {
		throw new VisitException();
	}

	public void visit(EntityNames entity) {
		throw new VisitException();
	}

	public void visit(Identifier entity) {
		throw new VisitException();
	}
}
