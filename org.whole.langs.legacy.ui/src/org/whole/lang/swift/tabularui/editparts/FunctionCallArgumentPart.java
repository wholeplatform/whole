package org.whole.lang.swift.tabularui.editparts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.swift.model.FunctionCallArgument;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.swift.tabularui.figures.FunctionCallArgumentRowFigure;

public class FunctionCallArgumentPart extends AbstractContentPanePart {

    protected IFigure createFigure() {
        return new FunctionCallArgumentRowFigure();
    }

    protected List<IEntity> getModelSpecificChildren() {
        FunctionCallArgument entity = getModelEntity();
        List<IEntity> children = new ArrayList<IEntity>(2);
        children.add(entity.getLabel());
        children.add(entity.getExpression());
        return children;
    }
}
