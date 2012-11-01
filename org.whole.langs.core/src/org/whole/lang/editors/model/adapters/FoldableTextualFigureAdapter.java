package org.whole.lang.editors.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.editors.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.editors.reflect.EditorsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FoldableTextualFigureAdapter extends AbstractEntityAdapter
		implements FoldableTextualFigure {
	private static final long serialVersionUID = 1;

	public FoldableTextualFigureAdapter(IEntity implementor) {
		super(implementor);
	}

	public FoldableTextualFigureAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FoldableTextualFigure> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.FoldableTextualFigure;
	}

	public TextualFigure getExpandedFigure() {
		return wGet(EditorsFeatureDescriptorEnum.expandedFigure).wGetAdapter(
				EditorsEntityDescriptorEnum.TextualFigure);
	}

	public void setExpandedFigure(TextualFigure expandedFigure) {
		wSet(EditorsFeatureDescriptorEnum.expandedFigure, expandedFigure);
	}

	public TextualFigure getCollapsedFigure() {
		return wGet(EditorsFeatureDescriptorEnum.collapsedFigure).wGetAdapter(
				EditorsEntityDescriptorEnum.TextualFigure);
	}

	public void setCollapsedFigure(TextualFigure collapsedFigure) {
		wSet(EditorsFeatureDescriptorEnum.collapsedFigure, collapsedFigure);
	}
}
