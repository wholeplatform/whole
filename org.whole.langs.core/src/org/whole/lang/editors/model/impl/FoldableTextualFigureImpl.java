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
public class FoldableTextualFigureImpl extends AbstractSimpleEntity implements
		FoldableTextualFigure {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FoldableTextualFigure> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.FoldableTextualFigure;
	}

	public int wGetEntityOrd() {
		return EditorsEntityDescriptorEnum.FoldableTextualFigure_ord;
	}

	public void accept(IEditorsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private TextualFigure expandedFigure;

	public TextualFigure getExpandedFigure() {
		return notifyRequested(EditorsFeatureDescriptorEnum.expandedFigure,
				expandedFigure);
	}

	public void setExpandedFigure(TextualFigure expandedFigure) {
		notifyChanged(EditorsFeatureDescriptorEnum.expandedFigure,
				this.expandedFigure, this.expandedFigure = expandedFigure);
	}

	private TextualFigure collapsedFigure;

	public TextualFigure getCollapsedFigure() {
		return notifyRequested(EditorsFeatureDescriptorEnum.collapsedFigure,
				collapsedFigure);
	}

	public void setCollapsedFigure(TextualFigure collapsedFigure) {
		notifyChanged(EditorsFeatureDescriptorEnum.collapsedFigure,
				this.collapsedFigure, this.collapsedFigure = collapsedFigure);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpandedFigure().wGetAdaptee(false);
		case 1:
			return getCollapsedFigure().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpandedFigure(value
					.wGetAdapter(EditorsEntityDescriptorEnum.TextualFigure));
			break;
		case 1:
			setCollapsedFigure(value
					.wGetAdapter(EditorsEntityDescriptorEnum.TextualFigure));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
