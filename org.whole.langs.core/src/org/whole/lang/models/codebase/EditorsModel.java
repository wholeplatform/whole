package org.whole.lang.models.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.models.builders.IModelsBuilder;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.reflect.ModelsLanguageKit;
import org.whole.lang.templates.AbstractTemplateFactory;

/**
 * @generator Whole
 */
public class EditorsModel extends AbstractTemplateFactory<Model> {
	public void apply(IBuilderOperation op) {
		IModelsBuilder b0 = (IModelsBuilder) op
				.wGetBuilder(ModelsLanguageKit.URI);
		b0.Model_();
		b0.SimpleName("Editors");
		b0.TypeRelations();
		b0.ModelDeclarations_(26);
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Editor");
		b0.Types();
		b0.Features_(5);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("EditorName");
		b0.SimpleName("editorName");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers_(1);
		b0.FeatureModifier("optional");
		b0._FeatureModifiers();
		b0.SimpleName("EditorName");
		b0.SimpleName("superEditorName");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ModelComponent");
		b0.SimpleName("modelComponent");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ViewComponent");
		b0.SimpleName("viewComponent");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ControllerComponent");
		b0.SimpleName("controllerComponent");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ModelComponent");
		b0.Types();
		b0.Features_(1);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ModelName");
		b0.SimpleName("modelName");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ControllerComponent");
		b0.Types();
		b0.Features_(1);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ControllerDeclarations");
		b0.SimpleName("declarations");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ControllerDeclarations");
		b0.Types();
		b0.ComponentModifiers();
		b0.SimpleName("ControllerDeclaration");
		b0._CompositeEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("PartDeclaration");
		b0.Types_(1);
		b0.SimpleName("ControllerDeclaration");
		b0._Types();
		b0.Features_(4);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("PartName");
		b0.SimpleName("partName");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("EntityName");
		b0.SimpleName("entityName");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("FigureName");
		b0.SimpleName("figureName");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("EntityFeatures");
		b0.SimpleName("entityFeatures");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("JavaPartDeclaration");
		b0.Types_(1);
		b0.SimpleName("ControllerDeclaration");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("PartName");
		b0.SimpleName("partName");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("EntityNames");
		b0.SimpleName("entityNames");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("GenericPartDeclaration");
		b0.Types_(1);
		b0.SimpleName("ControllerDeclaration");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("GenericPartName");
		b0.SimpleName("partName");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("EntityNames");
		b0.SimpleName("entityNames");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("EntityFeatures");
		b0.Types();
		b0.ComponentModifiers();
		b0.SimpleName("FeatureName");
		b0._CompositeEntity();
		b0.EnumEntity_();
		b0.EntityModifiers();
		b0.SimpleName("GenericPartName");
		b0.Types();
		b0.EnumValues_(13);
		b0.EnumValue("CompositeColumn");
		b0.EnumValue("CompositeRow");
		b0.EnumValue("ConstructorColumn");
		b0.EnumValue("ConstructorRow");
		b0.EnumValue("FoldableConstructor");
		b0.EnumValue("Resolver");
		b0.EnumValue("OptionalResolver");
		b0.EnumValue("LiteralData");
		b0.EnumValue("KeywordData");
		b0.EnumValue("IdentifierData");
		b0.EnumValue("OperatorData");
		b0.EnumValue("DelimiterData");
		b0.EnumValue("ParenthesisData");
		b0._EnumValues();
		b0._EnumEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ViewComponent");
		b0.Types();
		b0.Features_(1);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ViewDeclarations");
		b0.SimpleName("declarations");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ViewDeclarations");
		b0.Types();
		b0.ComponentModifiers();
		b0.SimpleName("ViewDeclaration");
		b0._CompositeEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleFigureDeclaration");
		b0.Types_(1);
		b0.SimpleName("ViewDeclaration");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("FigureName");
		b0.SimpleName("name");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("FigureBody");
		b0.SimpleName("figure");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("FoldableTextualFigure");
		b0.Types_(1);
		b0.SimpleName("FigureBody");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("TextualFigure");
		b0.SimpleName("expandedFigure");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("TextualFigure");
		b0.SimpleName("collapsedFigure");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("TextualFigure");
		b0.Types_(1);
		b0.SimpleName("FigureBody");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("ordered");
		b0._ComponentModifiers();
		b0.SimpleName("Row");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Row");
		b0.Types();
		b0.ComponentModifiers();
		b0.SimpleName("RowElement");
		b0._CompositeEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ChildPlace");
		b0.Types_(1);
		b0.SimpleName("RowElement");
		b0._Types();
		b0.Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Indent");
		b0.Types_(1);
		b0.SimpleName("RowElement");
		b0._Types();
		b0.Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("FoldingToggle");
		b0.Types_(1);
		b0.SimpleName("RowElement");
		b0._Types();
		b0.Features();
		b0._SimpleEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("KeywordToken");
		b0.Types_(1);
		b0.SimpleName("RowElement");
		b0._Types();
		b0.DataType("String");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("LiteralToken");
		b0.Types_(1);
		b0.SimpleName("RowElement");
		b0._Types();
		b0.DataType("String");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("IdentifierToken");
		b0.Types_(1);
		b0.SimpleName("RowElement");
		b0._Types();
		b0.DataType("String");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("OperatorToken");
		b0.Types_(1);
		b0.SimpleName("RowElement");
		b0._Types();
		b0.DataType("String");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("DelimiterToken");
		b0.Types_(1);
		b0.SimpleName("RowElement");
		b0._Types();
		b0.DataType("String");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ParenthesisToken");
		b0.Types_(1);
		b0.SimpleName("RowElement");
		b0._Types();
		b0.DataType("String");
		b0._DataEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("EntityNames");
		b0.Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("unique");
		b0._ComponentModifiers();
		b0.SimpleName("EntityName");
		b0._CompositeEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Identifier");
		b0.Types_(6);
		b0.SimpleName("EditorName");
		b0.SimpleName("ModelName");
		b0.SimpleName("EntityName");
		b0.SimpleName("FeatureName");
		b0.SimpleName("FigureName");
		b0.SimpleName("PartName");
		b0._Types();
		b0.DataType("String");
		b0._DataEntity();
		b0._ModelDeclarations();
        b0.Namespace("org.whole.lang.editors");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.URI("http://lang.whole.org/Editors");
		b0._Model();
	}
}