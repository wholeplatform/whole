package org.whole.lang.swift.tabularui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.TableRowLayout;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.OverColumnLayout;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.figures.CurlyBracketsBorder;

public class FunctionDeclRowFigure extends ContentPaneFigure {

    public FunctionDeclRowFigure() {
        initContentPanes(7);
        setLayoutManager(new TableRowLayout().withMinorAlignment(Alignment.CENTER));
        EntityFigure column = new EntityFigure(new OverColumnLayout().withMinorAlignment(Alignment.LEADING));
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
