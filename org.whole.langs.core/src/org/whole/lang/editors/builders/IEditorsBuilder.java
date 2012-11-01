package org.whole.lang.editors.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.editors.model.GenericPartNameEnum;

/** 
 * @generator Whole
 */
public interface IEditorsBuilder extends IBuilder {
	public void visit();

	public void collapsedFigure();

	public void expandedFigure();

	public void figure();

	public void name();

	public void entityNames();

	public void entityFeatures();

	public void figureName();

	public void entityName();

	public void partName();

	public void declarations();

	public void modelName();

	public void controllerComponent();

	public void viewComponent();

	public void modelComponent();

	public void superEditorName();

	public void editorName();

	public void Editor();

	public void Editor_();

	public void _Editor();

	public void ModelComponent();

	public void ModelComponent_();

	public void _ModelComponent();

	public void ControllerComponent();

	public void ControllerComponent_();

	public void _ControllerComponent();

	public void ControllerDeclarations();

	public void ControllerDeclarations_();

	public void ControllerDeclarations_(int initialCapacity);

	public void _ControllerDeclarations();

	public void PartDeclaration();

	public void PartDeclaration_();

	public void _PartDeclaration();

	public void JavaPartDeclaration();

	public void JavaPartDeclaration_();

	public void _JavaPartDeclaration();

	public void GenericPartDeclaration();

	public void GenericPartDeclaration_();

	public void _GenericPartDeclaration();

	public void EntityFeatures();

	public void EntityFeatures_();

	public void EntityFeatures_(int initialCapacity);

	public void _EntityFeatures();

	public void GenericPartName();

	public void GenericPartName(GenericPartNameEnum.Value value);

	public void GenericPartName(String value);

	public void ViewComponent();

	public void ViewComponent_();

	public void _ViewComponent();

	public void ViewDeclarations();

	public void ViewDeclarations_();

	public void ViewDeclarations_(int initialCapacity);

	public void _ViewDeclarations();

	public void SimpleFigureDeclaration();

	public void SimpleFigureDeclaration_();

	public void _SimpleFigureDeclaration();

	public void FoldableTextualFigure();

	public void FoldableTextualFigure_();

	public void _FoldableTextualFigure();

	public void TextualFigure();

	public void TextualFigure_();

	public void TextualFigure_(int initialCapacity);

	public void _TextualFigure();

	public void Row();

	public void Row_();

	public void Row_(int initialCapacity);

	public void _Row();

	public void ChildPlace();

	public void ChildPlace_();

	public void _ChildPlace();

	public void Indent();

	public void Indent_();

	public void _Indent();

	public void FoldingToggle();

	public void FoldingToggle_();

	public void _FoldingToggle();

	public void KeywordToken();

	public void KeywordToken(String value);

	public void LiteralToken();

	public void LiteralToken(String value);

	public void IdentifierToken();

	public void IdentifierToken(String value);

	public void OperatorToken();

	public void OperatorToken(String value);

	public void DelimiterToken();

	public void DelimiterToken(String value);

	public void ParenthesisToken();

	public void ParenthesisToken(String value);

	public void EntityNames();

	public void EntityNames_();

	public void EntityNames_(int initialCapacity);

	public void _EntityNames();

	public void Identifier();

	public void Identifier(String value);
}
