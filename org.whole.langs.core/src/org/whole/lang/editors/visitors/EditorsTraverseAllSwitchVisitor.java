package org.whole.lang.editors.visitors;

import org.whole.lang.editors.visitors.EditorsIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.editors.model.*;

/** 
 * @generator Whole
 */
public class EditorsTraverseAllSwitchVisitor extends
		EditorsIdentityUnaryVisitor<IVisitor> {
	public EditorsTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Editor entity) {
		wGetVisitor1().visit(entity.getEditorName());
		wGetVisitor1().visit(entity.getSuperEditorName());
		wGetVisitor1().visit(entity.getModelComponent());
		wGetVisitor1().visit(entity.getViewComponent());
		wGetVisitor1().visit(entity.getControllerComponent());
	}

	public void visit(ModelComponent entity) {
		wGetVisitor1().visit(entity.getModelName());
	}

	public void visit(ControllerComponent entity) {
		wGetVisitor1().visit(entity.getDeclarations());
	}

	public void visit(ControllerDeclarations entity) {
		for (ControllerDeclaration child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(PartDeclaration entity) {
		wGetVisitor1().visit(entity.getPartName());
		wGetVisitor1().visit(entity.getEntityName());
		wGetVisitor1().visit(entity.getFigureName());
		wGetVisitor1().visit(entity.getEntityFeatures());
	}

	public void visit(JavaPartDeclaration entity) {
		wGetVisitor1().visit(entity.getPartName());
		wGetVisitor1().visit(entity.getEntityNames());
	}

	public void visit(GenericPartDeclaration entity) {
		wGetVisitor1().visit(entity.getPartName());
		wGetVisitor1().visit(entity.getEntityNames());
	}

	public void visit(EntityFeatures entity) {
		for (FeatureName child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(ViewComponent entity) {
		wGetVisitor1().visit(entity.getDeclarations());
	}

	public void visit(ViewDeclarations entity) {
		for (ViewDeclaration child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(SimpleFigureDeclaration entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getFigure());
	}

	public void visit(FoldableTextualFigure entity) {
		wGetVisitor1().visit(entity.getExpandedFigure());
		wGetVisitor1().visit(entity.getCollapsedFigure());
	}

	public void visit(TextualFigure entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Row entity) {
		for (RowElement child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(EntityNames entity) {
		for (EntityName child : entity)
			wGetVisitor1().visit(child);
	}
}
