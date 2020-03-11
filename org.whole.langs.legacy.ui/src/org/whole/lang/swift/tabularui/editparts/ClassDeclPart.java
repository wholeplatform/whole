package org.whole.lang.swift.tabularui.editparts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.swift.model.ClassDecl;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.swift.tabularui.figures.ClassDeclRowFigure;

public class ClassDeclPart extends AbstractContentPanePart {

    protected IFigure createFigure() {
        return new ClassDeclRowFigure();
    }

    protected List<IEntity> getModelSpecificChildren() {
        ClassDecl entity = getModelEntity();
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
