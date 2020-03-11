package org.whole.lang.swift.tabularui.editparts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.swift.model.ExtensionDecl;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.swift.tabularui.figures.ExtensionDeclRowFigure;

public class ExtensionDeclPart extends AbstractContentPanePart {

    protected IFigure createFigure() {
        return new ExtensionDeclRowFigure();
    }

    protected List<IEntity> getModelSpecificChildren() {
        ExtensionDecl entity = getModelEntity();
        List<IEntity> children = new ArrayList<IEntity>(6);
        children.add(entity.getAttributes());
        children.add(entity.getModifiers());
        children.add(entity.getExtendedType());
        children.add(entity.getInheritanceClause());
        children.add(entity.getGenericWhereClause());
        children.add(entity.getMembers());
        return children;
    }
}
