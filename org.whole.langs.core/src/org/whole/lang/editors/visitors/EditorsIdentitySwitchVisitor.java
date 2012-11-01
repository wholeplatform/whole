package org.whole.lang.editors.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.editors.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class EditorsIdentitySwitchVisitor extends AbstractVisitor
		implements IEditorsVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case EditorsEntityDescriptorEnum.Editor_ord:
			visit((Editor) entity);
			break;
		case EditorsEntityDescriptorEnum.ModelComponent_ord:
			visit((ModelComponent) entity);
			break;
		case EditorsEntityDescriptorEnum.ControllerComponent_ord:
			visit((ControllerComponent) entity);
			break;
		case EditorsEntityDescriptorEnum.ControllerDeclarations_ord:
			visit((ControllerDeclarations) entity);
			break;
		case EditorsEntityDescriptorEnum.PartDeclaration_ord:
			visit((PartDeclaration) entity);
			break;
		case EditorsEntityDescriptorEnum.JavaPartDeclaration_ord:
			visit((JavaPartDeclaration) entity);
			break;
		case EditorsEntityDescriptorEnum.GenericPartDeclaration_ord:
			visit((GenericPartDeclaration) entity);
			break;
		case EditorsEntityDescriptorEnum.EntityFeatures_ord:
			visit((EntityFeatures) entity);
			break;
		case EditorsEntityDescriptorEnum.GenericPartName_ord:
			visit((GenericPartName) entity);
			break;
		case EditorsEntityDescriptorEnum.ViewComponent_ord:
			visit((ViewComponent) entity);
			break;
		case EditorsEntityDescriptorEnum.ViewDeclarations_ord:
			visit((ViewDeclarations) entity);
			break;
		case EditorsEntityDescriptorEnum.SimpleFigureDeclaration_ord:
			visit((SimpleFigureDeclaration) entity);
			break;
		case EditorsEntityDescriptorEnum.FoldableTextualFigure_ord:
			visit((FoldableTextualFigure) entity);
			break;
		case EditorsEntityDescriptorEnum.TextualFigure_ord:
			visit((TextualFigure) entity);
			break;
		case EditorsEntityDescriptorEnum.Row_ord:
			visit((Row) entity);
			break;
		case EditorsEntityDescriptorEnum.ChildPlace_ord:
			visit((ChildPlace) entity);
			break;
		case EditorsEntityDescriptorEnum.Indent_ord:
			visit((Indent) entity);
			break;
		case EditorsEntityDescriptorEnum.FoldingToggle_ord:
			visit((FoldingToggle) entity);
			break;
		case EditorsEntityDescriptorEnum.KeywordToken_ord:
			visit((KeywordToken) entity);
			break;
		case EditorsEntityDescriptorEnum.LiteralToken_ord:
			visit((LiteralToken) entity);
			break;
		case EditorsEntityDescriptorEnum.IdentifierToken_ord:
			visit((IdentifierToken) entity);
			break;
		case EditorsEntityDescriptorEnum.OperatorToken_ord:
			visit((OperatorToken) entity);
			break;
		case EditorsEntityDescriptorEnum.DelimiterToken_ord:
			visit((DelimiterToken) entity);
			break;
		case EditorsEntityDescriptorEnum.ParenthesisToken_ord:
			visit((ParenthesisToken) entity);
			break;
		case EditorsEntityDescriptorEnum.EntityNames_ord:
			visit((EntityNames) entity);
			break;
		case EditorsEntityDescriptorEnum.Identifier_ord:
			visit((Identifier) entity);
			break;
		}
	}
}
