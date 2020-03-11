package org.whole.lang.swift.tabularui.editparts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.swift.model.FunctionParameter;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.swift.tabularui.figures.FunctionParameterRowFigure;

public class FunctionParameterPart extends AbstractContentPanePart {

    protected IFigure createFigure() {
        return new FunctionParameterRowFigure();
    }

    protected List<IEntity> getModelSpecificChildren() {
        FunctionParameter entity = getModelEntity();
        List<IEntity> children = new ArrayList<IEntity>(6);
        children.add(entity.getAttributes());
        children.add(entity.getFirstName());
        children.add(entity.getSecondName());
        children.add(entity.getType());
        children.add(entity.getEllipsis());
        children.add(entity.getDefaultArgument());
        return children;
    }
}
