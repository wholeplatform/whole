package org.whole.lang.swift.tabularui.editparts;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.TableRowLayout;

public class DictionaryElementRowFigure extends ContentPaneFigure {

    public DictionaryElementRowFigure() {
        initContentPanes(2);
        setLayoutManager(new TableRowLayout());
        add(createContentPane(0));
        add(createContentPane(1));
    }
}
