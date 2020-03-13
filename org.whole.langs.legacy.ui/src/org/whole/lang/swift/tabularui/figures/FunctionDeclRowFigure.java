package org.whole.lang.swift.tabularui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.CurlyBracketsBorder;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.TableRowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;

public class FunctionDeclRowFigure extends ContentPaneFigure {

    public FunctionDeclRowFigure() {
        initContentPanes(7);
        setLayoutManager(new TableRowLayout().withMinorAlignment(Alignment.MATHLINE));
        EntityFigure column = new EntityFigure(new UnderColumnLayout().withMajorAlignment(Alignment.MATHLINE).withMinorAlignment(Alignment.TRAILING));
        column.add(createContentPane(0));
        column.add(createContentPane(1));
        column.add(createContentPane(2));
        add(column);
        EntityFigure column1 = new EntityFigure(new ColumnLayout().withMinorAlignment(Alignment.LEADING));
        column1.add(createContentPane(3));
        column1.add(createContentPane(4));
        column1.add(createContentPane(5));
        add(column1);
        add(createContentPane(6, new CurlyBracketsBorder()));
    }
}
