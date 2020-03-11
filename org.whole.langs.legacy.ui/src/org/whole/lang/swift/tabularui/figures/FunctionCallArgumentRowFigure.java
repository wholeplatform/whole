package org.whole.lang.swift.tabularui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.TableRowLayout;

public class FunctionCallArgumentRowFigure extends ContentPaneFigure {

    public FunctionCallArgumentRowFigure() {
        initContentPanes(2);
        setLayoutManager(new TableRowLayout());
        add(createContentPane(0));
        add(createContentPane(1));
    }
}
