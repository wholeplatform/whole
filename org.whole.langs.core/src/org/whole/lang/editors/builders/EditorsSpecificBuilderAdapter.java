package org.whole.lang.editors.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.editors.reflect.EditorsFeatureDescriptorEnum;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.editors.model.GenericPartNameEnum;

/** 
 * @generator Whole
 */
public class EditorsSpecificBuilderAdapter extends GenericBuilderContext
		implements IEditorsBuilder {
	public EditorsSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public EditorsSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void collapsedFigure() {
		wFeature(EditorsFeatureDescriptorEnum.collapsedFigure);
	}

	public void expandedFigure() {
		wFeature(EditorsFeatureDescriptorEnum.expandedFigure);
	}

	public void figure() {
		wFeature(EditorsFeatureDescriptorEnum.figure);
	}

	public void name() {
		wFeature(EditorsFeatureDescriptorEnum.name);
	}

	public void entityNames() {
		wFeature(EditorsFeatureDescriptorEnum.entityNames);
	}

	public void entityFeatures() {
		wFeature(EditorsFeatureDescriptorEnum.entityFeatures);
	}

	public void figureName() {
		wFeature(EditorsFeatureDescriptorEnum.figureName);
	}

	public void entityName() {
		wFeature(EditorsFeatureDescriptorEnum.entityName);
	}

	public void partName() {
		wFeature(EditorsFeatureDescriptorEnum.partName);
	}

	public void declarations() {
		wFeature(EditorsFeatureDescriptorEnum.declarations);
	}

	public void modelName() {
		wFeature(EditorsFeatureDescriptorEnum.modelName);
	}

	public void controllerComponent() {
		wFeature(EditorsFeatureDescriptorEnum.controllerComponent);
	}

	public void viewComponent() {
		wFeature(EditorsFeatureDescriptorEnum.viewComponent);
	}

	public void modelComponent() {
		wFeature(EditorsFeatureDescriptorEnum.modelComponent);
	}

	public void superEditorName() {
		wFeature(EditorsFeatureDescriptorEnum.superEditorName);
	}

	public void editorName() {
		wFeature(EditorsFeatureDescriptorEnum.editorName);
	}

	public void visit() {
	}

	public void Editor() {
		wEntity(EditorsEntityDescriptorEnum.Editor);
	}

	public void Editor_() {
		wEntity_(EditorsEntityDescriptorEnum.Editor);
	}

	public void _Editor() {
		_wEntity(EditorsEntityDescriptorEnum.Editor);
	}

	public void ModelComponent() {
		wEntity(EditorsEntityDescriptorEnum.ModelComponent);
	}

	public void ModelComponent_() {
		wEntity_(EditorsEntityDescriptorEnum.ModelComponent);
	}

	public void _ModelComponent() {
		_wEntity(EditorsEntityDescriptorEnum.ModelComponent);
	}

	public void ControllerComponent() {
		wEntity(EditorsEntityDescriptorEnum.ControllerComponent);
	}

	public void ControllerComponent_() {
		wEntity_(EditorsEntityDescriptorEnum.ControllerComponent);
	}

	public void _ControllerComponent() {
		_wEntity(EditorsEntityDescriptorEnum.ControllerComponent);
	}

	public void ControllerDeclarations() {
		wEntity(EditorsEntityDescriptorEnum.ControllerDeclarations);
	}

	public void ControllerDeclarations_() {
		wEntity_(EditorsEntityDescriptorEnum.ControllerDeclarations);
	}

	public void ControllerDeclarations_(int initialCapacity) {
		wEntity_(EditorsEntityDescriptorEnum.ControllerDeclarations,
				initialCapacity);
	}

	public void _ControllerDeclarations() {
		_wEntity(EditorsEntityDescriptorEnum.ControllerDeclarations);
	}

	public void PartDeclaration() {
		wEntity(EditorsEntityDescriptorEnum.PartDeclaration);
	}

	public void PartDeclaration_() {
		wEntity_(EditorsEntityDescriptorEnum.PartDeclaration);
	}

	public void _PartDeclaration() {
		_wEntity(EditorsEntityDescriptorEnum.PartDeclaration);
	}

	public void JavaPartDeclaration() {
		wEntity(EditorsEntityDescriptorEnum.JavaPartDeclaration);
	}

	public void JavaPartDeclaration_() {
		wEntity_(EditorsEntityDescriptorEnum.JavaPartDeclaration);
	}

	public void _JavaPartDeclaration() {
		_wEntity(EditorsEntityDescriptorEnum.JavaPartDeclaration);
	}

	public void GenericPartDeclaration() {
		wEntity(EditorsEntityDescriptorEnum.GenericPartDeclaration);
	}

	public void GenericPartDeclaration_() {
		wEntity_(EditorsEntityDescriptorEnum.GenericPartDeclaration);
	}

	public void _GenericPartDeclaration() {
		_wEntity(EditorsEntityDescriptorEnum.GenericPartDeclaration);
	}

	public void EntityFeatures() {
		wEntity(EditorsEntityDescriptorEnum.EntityFeatures);
	}

	public void EntityFeatures_() {
		wEntity_(EditorsEntityDescriptorEnum.EntityFeatures);
	}

	public void EntityFeatures_(int initialCapacity) {
		wEntity_(EditorsEntityDescriptorEnum.EntityFeatures, initialCapacity);
	}

	public void _EntityFeatures() {
		_wEntity(EditorsEntityDescriptorEnum.EntityFeatures);
	}

	public void GenericPartName() {
		wEntity(EditorsEntityDescriptorEnum.GenericPartName);
	}

	public void GenericPartName(GenericPartNameEnum.Value value) {
		wEntity(EditorsEntityDescriptorEnum.GenericPartName, value);
	}

	public void GenericPartName(String value) {
		wEntity(EditorsEntityDescriptorEnum.GenericPartName, value);
	}

	public void ViewComponent() {
		wEntity(EditorsEntityDescriptorEnum.ViewComponent);
	}

	public void ViewComponent_() {
		wEntity_(EditorsEntityDescriptorEnum.ViewComponent);
	}

	public void _ViewComponent() {
		_wEntity(EditorsEntityDescriptorEnum.ViewComponent);
	}

	public void ViewDeclarations() {
		wEntity(EditorsEntityDescriptorEnum.ViewDeclarations);
	}

	public void ViewDeclarations_() {
		wEntity_(EditorsEntityDescriptorEnum.ViewDeclarations);
	}

	public void ViewDeclarations_(int initialCapacity) {
		wEntity_(EditorsEntityDescriptorEnum.ViewDeclarations, initialCapacity);
	}

	public void _ViewDeclarations() {
		_wEntity(EditorsEntityDescriptorEnum.ViewDeclarations);
	}

	public void SimpleFigureDeclaration() {
		wEntity(EditorsEntityDescriptorEnum.SimpleFigureDeclaration);
	}

	public void SimpleFigureDeclaration_() {
		wEntity_(EditorsEntityDescriptorEnum.SimpleFigureDeclaration);
	}

	public void _SimpleFigureDeclaration() {
		_wEntity(EditorsEntityDescriptorEnum.SimpleFigureDeclaration);
	}

	public void FoldableTextualFigure() {
		wEntity(EditorsEntityDescriptorEnum.FoldableTextualFigure);
	}

	public void FoldableTextualFigure_() {
		wEntity_(EditorsEntityDescriptorEnum.FoldableTextualFigure);
	}

	public void _FoldableTextualFigure() {
		_wEntity(EditorsEntityDescriptorEnum.FoldableTextualFigure);
	}

	public void TextualFigure() {
		wEntity(EditorsEntityDescriptorEnum.TextualFigure);
	}

	public void TextualFigure_() {
		wEntity_(EditorsEntityDescriptorEnum.TextualFigure);
	}

	public void TextualFigure_(int initialCapacity) {
		wEntity_(EditorsEntityDescriptorEnum.TextualFigure, initialCapacity);
	}

	public void _TextualFigure() {
		_wEntity(EditorsEntityDescriptorEnum.TextualFigure);
	}

	public void Row() {
		wEntity(EditorsEntityDescriptorEnum.Row);
	}

	public void Row_() {
		wEntity_(EditorsEntityDescriptorEnum.Row);
	}

	public void Row_(int initialCapacity) {
		wEntity_(EditorsEntityDescriptorEnum.Row, initialCapacity);
	}

	public void _Row() {
		_wEntity(EditorsEntityDescriptorEnum.Row);
	}

	public void ChildPlace() {
		wEntity(EditorsEntityDescriptorEnum.ChildPlace);
	}

	public void ChildPlace_() {
		wEntity_(EditorsEntityDescriptorEnum.ChildPlace);
	}

	public void _ChildPlace() {
		_wEntity(EditorsEntityDescriptorEnum.ChildPlace);
	}

	public void Indent() {
		wEntity(EditorsEntityDescriptorEnum.Indent);
	}

	public void Indent_() {
		wEntity_(EditorsEntityDescriptorEnum.Indent);
	}

	public void _Indent() {
		_wEntity(EditorsEntityDescriptorEnum.Indent);
	}

	public void FoldingToggle() {
		wEntity(EditorsEntityDescriptorEnum.FoldingToggle);
	}

	public void FoldingToggle_() {
		wEntity_(EditorsEntityDescriptorEnum.FoldingToggle);
	}

	public void _FoldingToggle() {
		_wEntity(EditorsEntityDescriptorEnum.FoldingToggle);
	}

	public void KeywordToken() {
		wEntity(EditorsEntityDescriptorEnum.KeywordToken);
	}

	public void KeywordToken(String value) {
		wEntity(EditorsEntityDescriptorEnum.KeywordToken, value);
	}

	public void LiteralToken() {
		wEntity(EditorsEntityDescriptorEnum.LiteralToken);
	}

	public void LiteralToken(String value) {
		wEntity(EditorsEntityDescriptorEnum.LiteralToken, value);
	}

	public void IdentifierToken() {
		wEntity(EditorsEntityDescriptorEnum.IdentifierToken);
	}

	public void IdentifierToken(String value) {
		wEntity(EditorsEntityDescriptorEnum.IdentifierToken, value);
	}

	public void OperatorToken() {
		wEntity(EditorsEntityDescriptorEnum.OperatorToken);
	}

	public void OperatorToken(String value) {
		wEntity(EditorsEntityDescriptorEnum.OperatorToken, value);
	}

	public void DelimiterToken() {
		wEntity(EditorsEntityDescriptorEnum.DelimiterToken);
	}

	public void DelimiterToken(String value) {
		wEntity(EditorsEntityDescriptorEnum.DelimiterToken, value);
	}

	public void ParenthesisToken() {
		wEntity(EditorsEntityDescriptorEnum.ParenthesisToken);
	}

	public void ParenthesisToken(String value) {
		wEntity(EditorsEntityDescriptorEnum.ParenthesisToken, value);
	}

	public void EntityNames() {
		wEntity(EditorsEntityDescriptorEnum.EntityNames);
	}

	public void EntityNames_() {
		wEntity_(EditorsEntityDescriptorEnum.EntityNames);
	}

	public void EntityNames_(int initialCapacity) {
		wEntity_(EditorsEntityDescriptorEnum.EntityNames, initialCapacity);
	}

	public void _EntityNames() {
		_wEntity(EditorsEntityDescriptorEnum.EntityNames);
	}

	public void Identifier() {
		wEntity(EditorsEntityDescriptorEnum.Identifier);
	}

	public void Identifier(String value) {
		wEntity(EditorsEntityDescriptorEnum.Identifier, value);
	}
}
