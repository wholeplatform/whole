package org.whole.lang.editors.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.editors.reflect.EditorsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class EditorsModelContext extends EntityContext {
	public EditorsModelContext(IEntity root) {
		super(root);
	}

	public EditorsModelContext getEditorName() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.editorName);
	}

	public void setEditorName(EditorsModelContext editorName) {
		wSet(EditorsFeatureDescriptorEnum.editorName, editorName);
	}

	public EditorsModelContext getSuperEditorName() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.superEditorName);
	}

	public void setSuperEditorName(EditorsModelContext superEditorName) {
		wSet(EditorsFeatureDescriptorEnum.superEditorName, superEditorName);
	}

	public EditorsModelContext getModelComponent() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.modelComponent);
	}

	public void setModelComponent(EditorsModelContext modelComponent) {
		wSet(EditorsFeatureDescriptorEnum.modelComponent, modelComponent);
	}

	public EditorsModelContext getViewComponent() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.viewComponent);
	}

	public void setViewComponent(EditorsModelContext viewComponent) {
		wSet(EditorsFeatureDescriptorEnum.viewComponent, viewComponent);
	}

	public EditorsModelContext getControllerComponent() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.controllerComponent);
	}

	public void setControllerComponent(EditorsModelContext controllerComponent) {
		wSet(EditorsFeatureDescriptorEnum.controllerComponent,
				controllerComponent);
	}

	public EditorsModelContext getModelName() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.modelName);
	}

	public void setModelName(EditorsModelContext modelName) {
		wSet(EditorsFeatureDescriptorEnum.modelName, modelName);
	}

	public EditorsModelContext getDeclarations() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.declarations);
	}

	public void setDeclarations(EditorsModelContext declarations) {
		wSet(EditorsFeatureDescriptorEnum.declarations, declarations);
	}

	public EditorsModelContext getPartName() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.partName);
	}

	public void setPartName(EditorsModelContext partName) {
		wSet(EditorsFeatureDescriptorEnum.partName, partName);
	}

	public EditorsModelContext getEntityName() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.entityName);
	}

	public void setEntityName(EditorsModelContext entityName) {
		wSet(EditorsFeatureDescriptorEnum.entityName, entityName);
	}

	public EditorsModelContext getFigureName() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.figureName);
	}

	public void setFigureName(EditorsModelContext figureName) {
		wSet(EditorsFeatureDescriptorEnum.figureName, figureName);
	}

	public EditorsModelContext getEntityFeatures() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.entityFeatures);
	}

	public void setEntityFeatures(EditorsModelContext entityFeatures) {
		wSet(EditorsFeatureDescriptorEnum.entityFeatures, entityFeatures);
	}

	public EditorsModelContext getEntityNames() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.entityNames);
	}

	public void setEntityNames(EditorsModelContext entityNames) {
		wSet(EditorsFeatureDescriptorEnum.entityNames, entityNames);
	}

	public EditorsModelContext getName() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.name);
	}

	public void setName(EditorsModelContext name) {
		wSet(EditorsFeatureDescriptorEnum.name, name);
	}

	public EditorsModelContext getFigure() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.figure);
	}

	public void setFigure(EditorsModelContext figure) {
		wSet(EditorsFeatureDescriptorEnum.figure, figure);
	}

	public EditorsModelContext getExpandedFigure() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.expandedFigure);
	}

	public void setExpandedFigure(EditorsModelContext expandedFigure) {
		wSet(EditorsFeatureDescriptorEnum.expandedFigure, expandedFigure);
	}

	public EditorsModelContext getCollapsedFigure() {
		return (EditorsModelContext) wGet(EditorsFeatureDescriptorEnum.collapsedFigure);
	}

	public void setCollapsedFigure(EditorsModelContext collapsedFigure) {
		wSet(EditorsFeatureDescriptorEnum.collapsedFigure, collapsedFigure);
	}
}
