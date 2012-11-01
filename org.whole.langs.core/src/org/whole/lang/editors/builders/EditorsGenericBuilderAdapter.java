package org.whole.lang.editors.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.editors.reflect.EditorsFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.editors.model.GenericPartNameEnum.Value;

/** 
 * @generator Whole
 */
public class EditorsGenericBuilderAdapter extends GenericIdentityBuilder {
	private IEditorsBuilder specificBuilder;

	public EditorsGenericBuilderAdapter(IEditorsBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public EditorsGenericBuilderAdapter(IEditorsBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case EditorsFeatureDescriptorEnum.editorName_ord:
			specificBuilder.editorName();
			break;
		case EditorsFeatureDescriptorEnum.superEditorName_ord:
			specificBuilder.superEditorName();
			break;
		case EditorsFeatureDescriptorEnum.modelComponent_ord:
			specificBuilder.modelComponent();
			break;
		case EditorsFeatureDescriptorEnum.viewComponent_ord:
			specificBuilder.viewComponent();
			break;
		case EditorsFeatureDescriptorEnum.controllerComponent_ord:
			specificBuilder.controllerComponent();
			break;
		case EditorsFeatureDescriptorEnum.modelName_ord:
			specificBuilder.modelName();
			break;
		case EditorsFeatureDescriptorEnum.declarations_ord:
			specificBuilder.declarations();
			break;
		case EditorsFeatureDescriptorEnum.partName_ord:
			specificBuilder.partName();
			break;
		case EditorsFeatureDescriptorEnum.entityName_ord:
			specificBuilder.entityName();
			break;
		case EditorsFeatureDescriptorEnum.figureName_ord:
			specificBuilder.figureName();
			break;
		case EditorsFeatureDescriptorEnum.entityFeatures_ord:
			specificBuilder.entityFeatures();
			break;
		case EditorsFeatureDescriptorEnum.entityNames_ord:
			specificBuilder.entityNames();
			break;
		case EditorsFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case EditorsFeatureDescriptorEnum.figure_ord:
			specificBuilder.figure();
			break;
		case EditorsFeatureDescriptorEnum.expandedFigure_ord:
			specificBuilder.expandedFigure();
			break;
		case EditorsFeatureDescriptorEnum.collapsedFigure_ord:
			specificBuilder.collapsedFigure();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case EditorsEntityDescriptorEnum.Editor_ord:
			specificBuilder.Editor();
			break;
		case EditorsEntityDescriptorEnum.ModelComponent_ord:
			specificBuilder.ModelComponent();
			break;
		case EditorsEntityDescriptorEnum.ControllerComponent_ord:
			specificBuilder.ControllerComponent();
			break;
		case EditorsEntityDescriptorEnum.ControllerDeclarations_ord:
			specificBuilder.ControllerDeclarations();
			break;
		case EditorsEntityDescriptorEnum.PartDeclaration_ord:
			specificBuilder.PartDeclaration();
			break;
		case EditorsEntityDescriptorEnum.JavaPartDeclaration_ord:
			specificBuilder.JavaPartDeclaration();
			break;
		case EditorsEntityDescriptorEnum.GenericPartDeclaration_ord:
			specificBuilder.GenericPartDeclaration();
			break;
		case EditorsEntityDescriptorEnum.EntityFeatures_ord:
			specificBuilder.EntityFeatures();
			break;
		case EditorsEntityDescriptorEnum.ViewComponent_ord:
			specificBuilder.ViewComponent();
			break;
		case EditorsEntityDescriptorEnum.ViewDeclarations_ord:
			specificBuilder.ViewDeclarations();
			break;
		case EditorsEntityDescriptorEnum.SimpleFigureDeclaration_ord:
			specificBuilder.SimpleFigureDeclaration();
			break;
		case EditorsEntityDescriptorEnum.FoldableTextualFigure_ord:
			specificBuilder.FoldableTextualFigure();
			break;
		case EditorsEntityDescriptorEnum.TextualFigure_ord:
			specificBuilder.TextualFigure();
			break;
		case EditorsEntityDescriptorEnum.Row_ord:
			specificBuilder.Row();
			break;
		case EditorsEntityDescriptorEnum.ChildPlace_ord:
			specificBuilder.ChildPlace();
			break;
		case EditorsEntityDescriptorEnum.Indent_ord:
			specificBuilder.Indent();
			break;
		case EditorsEntityDescriptorEnum.FoldingToggle_ord:
			specificBuilder.FoldingToggle();
			break;
		case EditorsEntityDescriptorEnum.EntityNames_ord:
			specificBuilder.EntityNames();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case EditorsEntityDescriptorEnum.Editor_ord:
			specificBuilder.Editor_();
			break;
		case EditorsEntityDescriptorEnum.ModelComponent_ord:
			specificBuilder.ModelComponent_();
			break;
		case EditorsEntityDescriptorEnum.ControllerComponent_ord:
			specificBuilder.ControllerComponent_();
			break;
		case EditorsEntityDescriptorEnum.ControllerDeclarations_ord:
			specificBuilder.ControllerDeclarations_();
			break;
		case EditorsEntityDescriptorEnum.PartDeclaration_ord:
			specificBuilder.PartDeclaration_();
			break;
		case EditorsEntityDescriptorEnum.JavaPartDeclaration_ord:
			specificBuilder.JavaPartDeclaration_();
			break;
		case EditorsEntityDescriptorEnum.GenericPartDeclaration_ord:
			specificBuilder.GenericPartDeclaration_();
			break;
		case EditorsEntityDescriptorEnum.EntityFeatures_ord:
			specificBuilder.EntityFeatures_();
			break;
		case EditorsEntityDescriptorEnum.ViewComponent_ord:
			specificBuilder.ViewComponent_();
			break;
		case EditorsEntityDescriptorEnum.ViewDeclarations_ord:
			specificBuilder.ViewDeclarations_();
			break;
		case EditorsEntityDescriptorEnum.SimpleFigureDeclaration_ord:
			specificBuilder.SimpleFigureDeclaration_();
			break;
		case EditorsEntityDescriptorEnum.FoldableTextualFigure_ord:
			specificBuilder.FoldableTextualFigure_();
			break;
		case EditorsEntityDescriptorEnum.TextualFigure_ord:
			specificBuilder.TextualFigure_();
			break;
		case EditorsEntityDescriptorEnum.Row_ord:
			specificBuilder.Row_();
			break;
		case EditorsEntityDescriptorEnum.ChildPlace_ord:
			specificBuilder.ChildPlace_();
			break;
		case EditorsEntityDescriptorEnum.Indent_ord:
			specificBuilder.Indent_();
			break;
		case EditorsEntityDescriptorEnum.FoldingToggle_ord:
			specificBuilder.FoldingToggle_();
			break;
		case EditorsEntityDescriptorEnum.EntityNames_ord:
			specificBuilder.EntityNames_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case EditorsEntityDescriptorEnum.Editor_ord:
			specificBuilder._Editor();
			break;
		case EditorsEntityDescriptorEnum.ModelComponent_ord:
			specificBuilder._ModelComponent();
			break;
		case EditorsEntityDescriptorEnum.ControllerComponent_ord:
			specificBuilder._ControllerComponent();
			break;
		case EditorsEntityDescriptorEnum.ControllerDeclarations_ord:
			specificBuilder._ControllerDeclarations();
			break;
		case EditorsEntityDescriptorEnum.PartDeclaration_ord:
			specificBuilder._PartDeclaration();
			break;
		case EditorsEntityDescriptorEnum.JavaPartDeclaration_ord:
			specificBuilder._JavaPartDeclaration();
			break;
		case EditorsEntityDescriptorEnum.GenericPartDeclaration_ord:
			specificBuilder._GenericPartDeclaration();
			break;
		case EditorsEntityDescriptorEnum.EntityFeatures_ord:
			specificBuilder._EntityFeatures();
			break;
		case EditorsEntityDescriptorEnum.ViewComponent_ord:
			specificBuilder._ViewComponent();
			break;
		case EditorsEntityDescriptorEnum.ViewDeclarations_ord:
			specificBuilder._ViewDeclarations();
			break;
		case EditorsEntityDescriptorEnum.SimpleFigureDeclaration_ord:
			specificBuilder._SimpleFigureDeclaration();
			break;
		case EditorsEntityDescriptorEnum.FoldableTextualFigure_ord:
			specificBuilder._FoldableTextualFigure();
			break;
		case EditorsEntityDescriptorEnum.TextualFigure_ord:
			specificBuilder._TextualFigure();
			break;
		case EditorsEntityDescriptorEnum.Row_ord:
			specificBuilder._Row();
			break;
		case EditorsEntityDescriptorEnum.ChildPlace_ord:
			specificBuilder._ChildPlace();
			break;
		case EditorsEntityDescriptorEnum.Indent_ord:
			specificBuilder._Indent();
			break;
		case EditorsEntityDescriptorEnum.FoldingToggle_ord:
			specificBuilder._FoldingToggle();
			break;
		case EditorsEntityDescriptorEnum.EntityNames_ord:
			specificBuilder._EntityNames();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case EditorsEntityDescriptorEnum.ControllerDeclarations_ord:
			specificBuilder.ControllerDeclarations_(initialCapacity);
			break;
		case EditorsEntityDescriptorEnum.EntityFeatures_ord:
			specificBuilder.EntityFeatures_(initialCapacity);
			break;
		case EditorsEntityDescriptorEnum.ViewDeclarations_ord:
			specificBuilder.ViewDeclarations_(initialCapacity);
			break;
		case EditorsEntityDescriptorEnum.TextualFigure_ord:
			specificBuilder.TextualFigure_(initialCapacity);
			break;
		case EditorsEntityDescriptorEnum.Row_ord:
			specificBuilder.Row_(initialCapacity);
			break;
		case EditorsEntityDescriptorEnum.EntityNames_ord:
			specificBuilder.EntityNames_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case EditorsEntityDescriptorEnum.GenericPartName_ord:
			specificBuilder.GenericPartName((Value) value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case EditorsEntityDescriptorEnum.KeywordToken_ord:
			specificBuilder.KeywordToken(value);
			break;
		case EditorsEntityDescriptorEnum.LiteralToken_ord:
			specificBuilder.LiteralToken(value);
			break;
		case EditorsEntityDescriptorEnum.IdentifierToken_ord:
			specificBuilder.IdentifierToken(value);
			break;
		case EditorsEntityDescriptorEnum.OperatorToken_ord:
			specificBuilder.OperatorToken(value);
			break;
		case EditorsEntityDescriptorEnum.DelimiterToken_ord:
			specificBuilder.DelimiterToken(value);
			break;
		case EditorsEntityDescriptorEnum.ParenthesisToken_ord:
			specificBuilder.ParenthesisToken(value);
			break;
		case EditorsEntityDescriptorEnum.Identifier_ord:
			specificBuilder.Identifier(value);
			break;
		}
	}
}
