package org.whole.lang.editors.visitors;

import org.whole.lang.editors.visitors.EditorsIdentityUnaryVisitor;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.editors.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class EditorsTraverseAllChildrenVisitor extends
		EditorsIdentityUnaryVisitor<IEditorsVisitor> {
	public EditorsTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public EditorsTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Editor entity) {
		entity.getEditorName().accept(wGetVisitor1());
		entity.getSuperEditorName().accept(wGetVisitor1());
		entity.getModelComponent().accept(wGetVisitor1());
		entity.getViewComponent().accept(wGetVisitor1());
		entity.getControllerComponent().accept(wGetVisitor1());
	}

	public void visit(ModelComponent entity) {
		entity.getModelName().accept(wGetVisitor1());
	}

	public void visit(ControllerComponent entity) {
		entity.getDeclarations().accept(wGetVisitor1());
	}

	public void visit(ControllerDeclarations entity) {
		for (ControllerDeclaration child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(PartDeclaration entity) {
		entity.getPartName().accept(wGetVisitor1());
		entity.getEntityName().accept(wGetVisitor1());
		entity.getFigureName().accept(wGetVisitor1());
		entity.getEntityFeatures().accept(wGetVisitor1());
	}

	public void visit(JavaPartDeclaration entity) {
		entity.getPartName().accept(wGetVisitor1());
		entity.getEntityNames().accept(wGetVisitor1());
	}

	public void visit(GenericPartDeclaration entity) {
		entity.getPartName().accept(wGetVisitor1());
		entity.getEntityNames().accept(wGetVisitor1());
	}

	public void visit(EntityFeatures entity) {
		for (FeatureName child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(ViewComponent entity) {
		entity.getDeclarations().accept(wGetVisitor1());
	}

	public void visit(ViewDeclarations entity) {
		for (ViewDeclaration child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(SimpleFigureDeclaration entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getFigure().accept(wGetVisitor1());
	}

	public void visit(FoldableTextualFigure entity) {
		entity.getExpandedFigure().accept(wGetVisitor1());
		entity.getCollapsedFigure().accept(wGetVisitor1());
	}

	public void visit(TextualFigure entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Row entity) {
		for (RowElement child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(EntityNames entity) {
		for (EntityName child : entity)
			child.accept(wGetVisitor1());
	}
}
