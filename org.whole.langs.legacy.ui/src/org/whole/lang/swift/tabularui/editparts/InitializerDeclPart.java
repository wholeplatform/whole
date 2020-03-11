package org.whole.lang.swift.tabularui.editparts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.swift.model.InitializerDecl;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.swift.tabularui.figures.InitializerDeclRowFigure;

public class InitializerDeclPart extends AbstractContentPanePart {

    protected IFigure createFigure() {
        return new InitializerDeclRowFigure();
    }

    protected List<IEntity> getModelSpecificChildren() {
        InitializerDecl entity = getModelEntity();
        List<IEntity> children = new ArrayList<IEntity>(8);
        children.add(entity.getAttributes());
        children.add(entity.getModifiers());
        children.add(entity.getOptionalMark());
        children.add(entity.getGenericParameterClause());
        children.add(entity.getParameters());
        children.add(entity.getThrowsOrRethrowsKeyword());
        children.add(entity.getGenericWhereClause());
        children.add(entity.getBody());
        return children;
    }
}
