package org.whole.lang.swift.tabularui.editparts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.swift.model.StructDecl;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.swift.tabularui.figures.StructDeclRowFigure;

public class StructDeclPart extends AbstractContentPanePart {

    protected IFigure createFigure() {
        return new StructDeclRowFigure();
    }

    protected List<IEntity> getModelSpecificChildren() {
        StructDecl entity = getModelEntity();
        List<IEntity> children = new ArrayList<IEntity>(7);
        children.add(entity.getAttributes());
        children.add(entity.getModifiers());
        children.add(entity.getIdentifier());
        children.add(entity.getGenericParameterClause());
        children.add(entity.getInheritanceClause());
        children.add(entity.getGenericWhereClause());
        children.add(entity.getMembers());
        return children;
    }
}
