package org.whole.lang.swift.tabularui.editparts;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.editparts.AbstractCompositePart;
import org.whole.lang.swift.tabularui.figures.MemberDeclListTableFigure;

public class MemberDeclListPart extends AbstractCompositePart {

    protected IFigure createFigure() {
        return new MemberDeclListTableFigure();
    }
}
