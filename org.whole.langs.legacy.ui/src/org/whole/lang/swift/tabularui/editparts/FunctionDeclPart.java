package org.whole.lang.swift.tabularui.editparts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.swift.model.FunctionDecl;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.swift.tabularui.figures.FunctionDeclRowFigure;

public class FunctionDeclPart extends AbstractContentPanePart {

    protected IFigure createFigure() {
        return new FunctionDeclRowFigure();
    }

    protected List<IEntity> getModelSpecificChildren() {
        FunctionDecl entity = getModelEntity();
        List<IEntity> children = new ArrayList<IEntity>(7);
        children.add(entity.getFunctionIdentifier());
        children.add(entity.getModifiers());
        children.add(entity.getAttributes());
        children.add(entity.getGenericParameterClause());
        children.add(entity.getSignature());
        children.add(entity.getGenericWhereClause());
        children.add(entity.getBody());
        return children;
    }
}
