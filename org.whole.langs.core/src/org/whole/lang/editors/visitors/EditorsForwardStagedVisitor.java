package org.whole.lang.editors.visitors;

import org.whole.lang.editors.model.*;

/** 
 * @generator Whole
 */
public class EditorsForwardStagedVisitor extends EditorsIdentityVisitor {
	public void visit(Editor entity) {
		stagedVisit(entity);
	}

	public void visit(ModelComponent entity) {
		stagedVisit(entity);
	}

	public void visit(ControllerComponent entity) {
		stagedVisit(entity);
	}

	public void visit(ControllerDeclarations entity) {
		stagedVisit(entity);
	}

	public void visit(PartDeclaration entity) {
		stagedVisit(entity);
	}

	public void visit(JavaPartDeclaration entity) {
		stagedVisit(entity);
	}

	public void visit(GenericPartDeclaration entity) {
		stagedVisit(entity);
	}

	public void visit(EntityFeatures entity) {
		stagedVisit(entity);
	}

	public void visit(GenericPartName entity) {
		stagedVisit(entity);
	}

	public void visit(ViewComponent entity) {
		stagedVisit(entity);
	}

	public void visit(ViewDeclarations entity) {
		stagedVisit(entity);
	}

	public void visit(SimpleFigureDeclaration entity) {
		stagedVisit(entity);
	}

	public void visit(FoldableTextualFigure entity) {
		stagedVisit(entity);
	}

	public void visit(TextualFigure entity) {
		stagedVisit(entity);
	}

	public void visit(Row entity) {
		stagedVisit(entity);
	}

	public void visit(ChildPlace entity) {
		stagedVisit(entity);
	}

	public void visit(Indent entity) {
		stagedVisit(entity);
	}

	public void visit(FoldingToggle entity) {
		stagedVisit(entity);
	}

	public void visit(KeywordToken entity) {
		stagedVisit(entity);
	}

	public void visit(LiteralToken entity) {
		stagedVisit(entity);
	}

	public void visit(IdentifierToken entity) {
		stagedVisit(entity);
	}

	public void visit(OperatorToken entity) {
		stagedVisit(entity);
	}

	public void visit(DelimiterToken entity) {
		stagedVisit(entity);
	}

	public void visit(ParenthesisToken entity) {
		stagedVisit(entity);
	}

	public void visit(EntityNames entity) {
		stagedVisit(entity);
	}

	public void visit(Identifier entity) {
		stagedVisit(entity);
	}
}
