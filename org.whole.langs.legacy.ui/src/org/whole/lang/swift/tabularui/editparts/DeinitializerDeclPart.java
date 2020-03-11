package org.whole.lang.swift.tabularui.editparts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.swift.model.DeinitializerDecl;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.swift.tabularui.figures.DeinitializerDeclRowFigure;

public class DeinitializerDeclPart extends AbstractContentPanePart {

    protected IFigure createFigure() {
        return new DeinitializerDeclRowFigure();
    }

    protected List<IEntity> getModelSpecificChildren() {
        DeinitializerDecl entity = getModelEntity();
        List<IEntity> children = new ArrayList<IEntity>(3);
        children.add(entity.getAttributes());
        children.add(entity.getModifiers());
        children.add(entity.getBody());
        return children;
    }
}
