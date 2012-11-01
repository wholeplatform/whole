package org.whole.lang.editors.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class EditorsFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int editorName_ord = 0;
	public static final int superEditorName_ord = 1;
	public static final int modelComponent_ord = 2;
	public static final int viewComponent_ord = 3;
	public static final int controllerComponent_ord = 4;
	public static final int modelName_ord = 5;
	public static final int declarations_ord = 6;
	public static final int partName_ord = 7;
	public static final int entityName_ord = 8;
	public static final int figureName_ord = 9;
	public static final int entityFeatures_ord = 10;
	public static final int entityNames_ord = 11;
	public static final int name_ord = 12;
	public static final int figure_ord = 13;
	public static final int expandedFigure_ord = 14;
	public static final int collapsedFigure_ord = 15;
	public static final EditorsFeatureDescriptorEnum instance = new EditorsFeatureDescriptorEnum();
	public static final FeatureDescriptor editorName = instance
			.valueOf(editorName_ord);
	public static final FeatureDescriptor superEditorName = instance
			.valueOf(superEditorName_ord);
	public static final FeatureDescriptor modelComponent = instance
			.valueOf(modelComponent_ord);
	public static final FeatureDescriptor viewComponent = instance
			.valueOf(viewComponent_ord);
	public static final FeatureDescriptor controllerComponent = instance
			.valueOf(controllerComponent_ord);
	public static final FeatureDescriptor modelName = instance
			.valueOf(modelName_ord);
	public static final FeatureDescriptor declarations = instance
			.valueOf(declarations_ord);
	public static final FeatureDescriptor partName = instance
			.valueOf(partName_ord);
	public static final FeatureDescriptor entityName = instance
			.valueOf(entityName_ord);
	public static final FeatureDescriptor figureName = instance
			.valueOf(figureName_ord);
	public static final FeatureDescriptor entityFeatures = instance
			.valueOf(entityFeatures_ord);
	public static final FeatureDescriptor entityNames = instance
			.valueOf(entityNames_ord);
	public static final FeatureDescriptor name = instance.valueOf(name_ord);
	public static final FeatureDescriptor figure = instance.valueOf(figure_ord);
	public static final FeatureDescriptor expandedFigure = instance
			.valueOf(expandedFigure_ord);
	public static final FeatureDescriptor collapsedFigure = instance
			.valueOf(collapsedFigure_ord);

	private EditorsFeatureDescriptorEnum() {
		putFeatureDescriptor(editorName_ord, "editorName");
		putFeatureDescriptor(superEditorName_ord, "superEditorName");
		putFeatureDescriptor(modelComponent_ord, "modelComponent");
		putFeatureDescriptor(viewComponent_ord, "viewComponent");
		putFeatureDescriptor(controllerComponent_ord, "controllerComponent");
		putFeatureDescriptor(modelName_ord, "modelName");
		putFeatureDescriptor(declarations_ord, "declarations");
		putFeatureDescriptor(partName_ord, "partName");
		putFeatureDescriptor(entityName_ord, "entityName");
		putFeatureDescriptor(figureName_ord, "figureName");
		putFeatureDescriptor(entityFeatures_ord, "entityFeatures");
		putFeatureDescriptor(entityNames_ord, "entityNames");
		putFeatureDescriptor(name_ord, "name");
		putFeatureDescriptor(figure_ord, "figure");
		putFeatureDescriptor(expandedFigure_ord, "expandedFigure");
		putFeatureDescriptor(collapsedFigure_ord, "collapsedFigure");
	}

	private static final long serialVersionUID = 1;
}
