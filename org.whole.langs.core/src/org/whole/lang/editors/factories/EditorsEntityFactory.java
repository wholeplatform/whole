package org.whole.lang.editors.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.editors.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class EditorsEntityFactory extends GenericEntityFactory {
	public static final EditorsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static EditorsEntityFactory instance(IEntityRegistryProvider provider) {
		return new EditorsEntityFactory(provider);
	}

	protected EditorsEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Editor createEditor() {
		return create(EditorsEntityDescriptorEnum.Editor);
	}

	public Editor createEditor(EditorName editorName,
			EditorName superEditorName, ModelComponent modelComponent,
			ViewComponent viewComponent, ControllerComponent controllerComponent) {
		return create(EditorsEntityDescriptorEnum.Editor, editorName,
				superEditorName, modelComponent, viewComponent,
				controllerComponent);
	}

	public IEntityBuilder<Editor> buildEditor() {
		return new EntityBuilder<Editor>(
				create(EditorsEntityDescriptorEnum.Editor));
	}

	public ModelComponent createModelComponent() {
		return create(EditorsEntityDescriptorEnum.ModelComponent);
	}

	public ModelComponent createModelComponent(ModelName modelName) {
		return create(EditorsEntityDescriptorEnum.ModelComponent, modelName);
	}

	public ControllerComponent createControllerComponent() {
		return create(EditorsEntityDescriptorEnum.ControllerComponent);
	}

	public ControllerComponent createControllerComponent(
			ControllerDeclarations declarations) {
		return create(EditorsEntityDescriptorEnum.ControllerComponent,
				declarations);
	}

	public ControllerDeclarations createControllerDeclarations() {
		return create(EditorsEntityDescriptorEnum.ControllerDeclarations);
	}

	public ControllerDeclarations createControllerDeclarations(
			ControllerDeclaration... entities) {
		return create(EditorsEntityDescriptorEnum.ControllerDeclarations,
				(IEntity[]) entities);
	}

	public ControllerDeclarations createControllerDeclarations(int initialSize) {
		return clone(EditorsEntityDescriptorEnum.ControllerDeclarations,
				initialSize);
	}

	public PartDeclaration createPartDeclaration() {
		return create(EditorsEntityDescriptorEnum.PartDeclaration);
	}

	public PartDeclaration createPartDeclaration(PartName partName,
			EntityName entityName, FigureName figureName,
			EntityFeatures entityFeatures) {
		return create(EditorsEntityDescriptorEnum.PartDeclaration, partName,
				entityName, figureName, entityFeatures);
	}

	public IEntityBuilder<PartDeclaration> buildPartDeclaration() {
		return new EntityBuilder<PartDeclaration>(
				create(EditorsEntityDescriptorEnum.PartDeclaration));
	}

	public JavaPartDeclaration createJavaPartDeclaration() {
		return create(EditorsEntityDescriptorEnum.JavaPartDeclaration);
	}

	public JavaPartDeclaration createJavaPartDeclaration(PartName partName,
			EntityNames entityNames) {
		return create(EditorsEntityDescriptorEnum.JavaPartDeclaration,
				partName, entityNames);
	}

	public IEntityBuilder<JavaPartDeclaration> buildJavaPartDeclaration() {
		return new EntityBuilder<JavaPartDeclaration>(
				create(EditorsEntityDescriptorEnum.JavaPartDeclaration));
	}

	public GenericPartDeclaration createGenericPartDeclaration() {
		return create(EditorsEntityDescriptorEnum.GenericPartDeclaration);
	}

	public GenericPartDeclaration createGenericPartDeclaration(
			GenericPartName partName, EntityNames entityNames) {
		return create(EditorsEntityDescriptorEnum.GenericPartDeclaration,
				partName, entityNames);
	}

	public IEntityBuilder<GenericPartDeclaration> buildGenericPartDeclaration() {
		return new EntityBuilder<GenericPartDeclaration>(
				create(EditorsEntityDescriptorEnum.GenericPartDeclaration));
	}

	public EntityFeatures createEntityFeatures() {
		return create(EditorsEntityDescriptorEnum.EntityFeatures);
	}

	public EntityFeatures createEntityFeatures(FeatureName... entities) {
		return create(EditorsEntityDescriptorEnum.EntityFeatures,
				(IEntity[]) entities);
	}

	public EntityFeatures createEntityFeatures(int initialSize) {
		return clone(EditorsEntityDescriptorEnum.EntityFeatures, initialSize);
	}

	public GenericPartName createGenericPartName() {
		return create(EditorsEntityDescriptorEnum.GenericPartName);
	}

	public GenericPartName createGenericPartName(GenericPartNameEnum.Value value) {
		return create(EditorsEntityDescriptorEnum.GenericPartName, value);
	}

	public ViewComponent createViewComponent() {
		return create(EditorsEntityDescriptorEnum.ViewComponent);
	}

	public ViewComponent createViewComponent(ViewDeclarations declarations) {
		return create(EditorsEntityDescriptorEnum.ViewComponent, declarations);
	}

	public ViewDeclarations createViewDeclarations() {
		return create(EditorsEntityDescriptorEnum.ViewDeclarations);
	}

	public ViewDeclarations createViewDeclarations(ViewDeclaration... entities) {
		return create(EditorsEntityDescriptorEnum.ViewDeclarations,
				(IEntity[]) entities);
	}

	public ViewDeclarations createViewDeclarations(int initialSize) {
		return clone(EditorsEntityDescriptorEnum.ViewDeclarations, initialSize);
	}

	public SimpleFigureDeclaration createSimpleFigureDeclaration() {
		return create(EditorsEntityDescriptorEnum.SimpleFigureDeclaration);
	}

	public SimpleFigureDeclaration createSimpleFigureDeclaration(
			FigureName name, FigureBody figure) {
		return create(EditorsEntityDescriptorEnum.SimpleFigureDeclaration,
				name, figure);
	}

	public IEntityBuilder<SimpleFigureDeclaration> buildSimpleFigureDeclaration() {
		return new EntityBuilder<SimpleFigureDeclaration>(
				create(EditorsEntityDescriptorEnum.SimpleFigureDeclaration));
	}

	public FoldableTextualFigure createFoldableTextualFigure() {
		return create(EditorsEntityDescriptorEnum.FoldableTextualFigure);
	}

	public FoldableTextualFigure createFoldableTextualFigure(
			TextualFigure expandedFigure, TextualFigure collapsedFigure) {
		return create(EditorsEntityDescriptorEnum.FoldableTextualFigure,
				expandedFigure, collapsedFigure);
	}

	public IEntityBuilder<FoldableTextualFigure> buildFoldableTextualFigure() {
		return new EntityBuilder<FoldableTextualFigure>(
				create(EditorsEntityDescriptorEnum.FoldableTextualFigure));
	}

	public TextualFigure createTextualFigure() {
		return create(EditorsEntityDescriptorEnum.TextualFigure);
	}

	public TextualFigure createTextualFigure(Row... entities) {
		return create(EditorsEntityDescriptorEnum.TextualFigure,
				(IEntity[]) entities);
	}

	public TextualFigure createTextualFigure(int initialSize) {
		return clone(EditorsEntityDescriptorEnum.TextualFigure, initialSize);
	}

	public Row createRow() {
		return create(EditorsEntityDescriptorEnum.Row);
	}

	public Row createRow(RowElement... entities) {
		return create(EditorsEntityDescriptorEnum.Row, (IEntity[]) entities);
	}

	public Row createRow(int initialSize) {
		return clone(EditorsEntityDescriptorEnum.Row, initialSize);
	}

	public ChildPlace createChildPlace() {
		return create(EditorsEntityDescriptorEnum.ChildPlace);
	}

	public Indent createIndent() {
		return create(EditorsEntityDescriptorEnum.Indent);
	}

	public FoldingToggle createFoldingToggle() {
		return create(EditorsEntityDescriptorEnum.FoldingToggle);
	}

	public KeywordToken createKeywordToken() {
		return create(EditorsEntityDescriptorEnum.KeywordToken);
	}

	public KeywordToken createKeywordToken(String value) {
		return create(EditorsEntityDescriptorEnum.KeywordToken, value);
	}

	public LiteralToken createLiteralToken() {
		return create(EditorsEntityDescriptorEnum.LiteralToken);
	}

	public LiteralToken createLiteralToken(String value) {
		return create(EditorsEntityDescriptorEnum.LiteralToken, value);
	}

	public IdentifierToken createIdentifierToken() {
		return create(EditorsEntityDescriptorEnum.IdentifierToken);
	}

	public IdentifierToken createIdentifierToken(String value) {
		return create(EditorsEntityDescriptorEnum.IdentifierToken, value);
	}

	public OperatorToken createOperatorToken() {
		return create(EditorsEntityDescriptorEnum.OperatorToken);
	}

	public OperatorToken createOperatorToken(String value) {
		return create(EditorsEntityDescriptorEnum.OperatorToken, value);
	}

	public DelimiterToken createDelimiterToken() {
		return create(EditorsEntityDescriptorEnum.DelimiterToken);
	}

	public DelimiterToken createDelimiterToken(String value) {
		return create(EditorsEntityDescriptorEnum.DelimiterToken, value);
	}

	public ParenthesisToken createParenthesisToken() {
		return create(EditorsEntityDescriptorEnum.ParenthesisToken);
	}

	public ParenthesisToken createParenthesisToken(String value) {
		return create(EditorsEntityDescriptorEnum.ParenthesisToken, value);
	}

	public EntityNames createEntityNames() {
		return create(EditorsEntityDescriptorEnum.EntityNames);
	}

	public EntityNames createEntityNames(EntityName... entities) {
		return create(EditorsEntityDescriptorEnum.EntityNames,
				(IEntity[]) entities);
	}

	public EntityNames createEntityNames(int initialSize) {
		return clone(EditorsEntityDescriptorEnum.EntityNames, initialSize);
	}

	public Identifier createIdentifier() {
		return create(EditorsEntityDescriptorEnum.Identifier);
	}

	public Identifier createIdentifier(String value) {
		return create(EditorsEntityDescriptorEnum.Identifier, value);
	}
}
