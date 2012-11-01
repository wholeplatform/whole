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
public class SimpleFigureDeclarationAdapter extends AbstractEntityAdapter
		implements SimpleFigureDeclaration {
	private static final long serialVersionUID = 1;

	public SimpleFigureDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public SimpleFigureDeclarationAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SimpleFigureDeclaration> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.SimpleFigureDeclaration;
	}

	public FigureName getName() {
		return wGet(EditorsFeatureDescriptorEnum.name).wGetAdapter(
				EditorsEntityDescriptorEnum.FigureName);
	}

	public void setName(FigureName name) {
		wSet(EditorsFeatureDescriptorEnum.name, name);
	}

	public FigureBody getFigure() {
		return wGet(EditorsFeatureDescriptorEnum.figure).wGetAdapter(
				EditorsEntityDescriptorEnum.FigureBody);
	}

	public void setFigure(FigureBody figure) {
		wSet(EditorsFeatureDescriptorEnum.figure, figure);
	}
}
