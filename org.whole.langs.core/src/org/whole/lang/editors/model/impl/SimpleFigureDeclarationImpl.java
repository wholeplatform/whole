package org.whole.lang.editors.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.editors.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.editors.reflect.EditorsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SimpleFigureDeclarationImpl extends AbstractSimpleEntity implements
		SimpleFigureDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SimpleFigureDeclaration> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.SimpleFigureDeclaration;
	}

	public int wGetEntityOrd() {
		return EditorsEntityDescriptorEnum.SimpleFigureDeclaration_ord;
	}

	public void accept(IEditorsVisitor visitor) {
		visitor.visit(this);
	}

	private FigureName name;

	public FigureName getName() {
		return notifyRequested(EditorsFeatureDescriptorEnum.name, name);
	}

	public void setName(FigureName name) {
		notifyChanged(EditorsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private FigureBody figure;

	public FigureBody getFigure() {
		return notifyRequested(EditorsFeatureDescriptorEnum.figure, figure);
	}

	public void setFigure(FigureBody figure) {
		notifyChanged(EditorsFeatureDescriptorEnum.figure, this.figure,
				this.figure = figure);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getFigure().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(EditorsEntityDescriptorEnum.FigureName));
			break;
		case 1:
			setFigure(value.wGetAdapter(EditorsEntityDescriptorEnum.FigureBody));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
