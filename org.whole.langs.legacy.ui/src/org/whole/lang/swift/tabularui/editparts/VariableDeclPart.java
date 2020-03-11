package org.whole.lang.swift.tabularui.editparts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.swift.model.VariableDecl;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.swift.tabularui.figures.VariableDeclRowFigure;

public class VariableDeclPart extends AbstractContentPanePart {

    protected IFigure createFigure() {
        return new VariableDeclRowFigure();
    }

    protected List<IEntity> getModelSpecificChildren() {
        VariableDecl entity = getModelEntity();
        List<IEntity> children = new ArrayList<IEntity>(4);
        children.add(entity.getAttributes());
        children.add(entity.getModifiers());
        children.add(entity.getLetOrVarKeyword());
        children.add(entity.getBindings());
        return children;
    }
}
