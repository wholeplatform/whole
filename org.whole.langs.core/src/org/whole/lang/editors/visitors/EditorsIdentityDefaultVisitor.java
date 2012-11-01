package org.whole.lang.editors.visitors;

import org.whole.lang.editors.model.*;

/** 
 * @generator Whole
 */
public class EditorsIdentityDefaultVisitor extends EditorsIdentityVisitor {
	public void visit(IEditorsEntity entity) {
	}

	public void visit(Editor entity) {
		visit((IEditorsEntity) entity);
	}

	public void visit(ModelComponent entity) {
		visit((IEditorsEntity) entity);
	}

	public void visit(ControllerComponent entity) {
		visit((IEditorsEntity) entity);
	}

	public void visit(ControllerDeclarations entity) {
		visit((IEditorsEntity) entity);
	}

	public void visit(ControllerDeclaration entity) {
	}

	public void visit(PartDeclaration entity) {
		visit((IEditorsEntity) entity);
		visit((ControllerDeclaration) entity);
	}

	public void visit(JavaPartDeclaration entity) {
		visit((IEditorsEntity) entity);
		visit((ControllerDeclaration) entity);
	}

	public void visit(GenericPartDeclaration entity) {
		visit((IEditorsEntity) entity);
		visit((ControllerDeclaration) entity);
	}

	public void visit(EntityFeatures entity) {
		visit((IEditorsEntity) entity);
	}

	public void visit(GenericPartName entity) {
		visit((IEditorsEntity) entity);
	}

	public void visit(ViewComponent entity) {
		visit((IEditorsEntity) entity);
	}

	public void visit(ViewDeclarations entity) {
		visit((IEditorsEntity) entity);
	}

	public void visit(ViewDeclaration entity) {
	}

	public void visit(SimpleFigureDeclaration entity) {
		visit((IEditorsEntity) entity);
		visit((ViewDeclaration) entity);
	}

	public void visit(FigureBody entity) {
	}

	public void visit(FoldableTextualFigure entity) {
		visit((IEditorsEntity) entity);
		visit((FigureBody) entity);
	}

	public void visit(TextualFigure entity) {
		visit((IEditorsEntity) entity);
		visit((FigureBody) entity);
	}

	public void visit(Row entity) {
		visit((IEditorsEntity) entity);
	}

	public void visit(RowElement entity) {
	}

	public void visit(ChildPlace entity) {
		visit((IEditorsEntity) entity);
		visit((RowElement) entity);
	}

	public void visit(Indent entity) {
		visit((IEditorsEntity) entity);
		visit((RowElement) entity);
	}

	public void visit(FoldingToggle entity) {
		visit((IEditorsEntity) entity);
		visit((RowElement) entity);
	}

	public void visit(KeywordToken entity) {
		visit((IEditorsEntity) entity);
		visit((RowElement) entity);
	}

	public void visit(LiteralToken entity) {
		visit((IEditorsEntity) entity);
		visit((RowElement) entity);
	}

	public void visit(IdentifierToken entity) {
		visit((IEditorsEntity) entity);
		visit((RowElement) entity);
	}

	public void visit(OperatorToken entity) {
		visit((IEditorsEntity) entity);
		visit((RowElement) entity);
	}

	public void visit(DelimiterToken entity) {
		visit((IEditorsEntity) entity);
		visit((RowElement) entity);
	}

	public void visit(ParenthesisToken entity) {
		visit((IEditorsEntity) entity);
		visit((RowElement) entity);
	}

	public void visit(EntityNames entity) {
		visit((IEditorsEntity) entity);
	}

	public void visit(EditorName entity) {
	}

	public void visit(Identifier entity) {
		visit((IEditorsEntity) entity);
		visit((EditorName) entity);
		visit((ModelName) entity);
		visit((EntityName) entity);
		visit((FeatureName) entity);
		visit((FigureName) entity);
		visit((PartName) entity);
	}

	public void visit(ModelName entity) {
	}

	public void visit(EntityName entity) {
	}

	public void visit(FeatureName entity) {
	}

	public void visit(FigureName entity) {
	}

	public void visit(PartName entity) {
	}
}
