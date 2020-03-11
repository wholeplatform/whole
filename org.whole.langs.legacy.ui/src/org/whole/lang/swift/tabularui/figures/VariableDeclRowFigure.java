package org.whole.lang.swift.tabularui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.TableRowLayout;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.OverColumnLayout;
import org.whole.lang.ui.figures.EntityFigure;

public class VariableDeclRowFigure extends ContentPaneFigure {

    public VariableDeclRowFigure() {
        initContentPanes(4);
        setLayoutManager(new TableRowLayout().withMinorAlignment(Alignment.MATHLINE));
        EntityFigure column = new EntityFigure(new OverColumnLayout().withMinorAlignment(Alignment.LEADING));
        column.add(createContentPane(0));
        column.add(createContentPane(1));
        column.add(createContentPane(2));
        add(column);
        add(createContentPane(3));
    }
}
