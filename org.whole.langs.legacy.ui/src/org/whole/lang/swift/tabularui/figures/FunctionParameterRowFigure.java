package org.whole.lang.swift.tabularui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.TableRowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;

public class FunctionParameterRowFigure extends ContentPaneFigure {

    public FunctionParameterRowFigure() {
        initContentPanes(6);
        setLayoutManager(new TableRowLayout());
        add(createContentPane(0));
        EntityFigure column = new EntityFigure(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING));
        column.add(createContentPane(1));
        column.add(createContentPane(2));
        add(column);
        EntityFigure row = new EntityFigure(new RowLayout().withMinorAlignment(Alignment.LEADING));
        row.add(createContentPane(3));
        row.add(createContentPane(4));
        add(row);
        add(createContentPane(5));
    }
}
