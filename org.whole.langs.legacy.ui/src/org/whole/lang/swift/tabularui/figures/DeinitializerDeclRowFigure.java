package org.whole.lang.swift.tabularui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.TableRowLayout;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.UnderColumnLayout;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.RoundBracketsBorder;

public class DeinitializerDeclRowFigure extends ContentPaneFigure {

    public DeinitializerDeclRowFigure() {
        initContentPanes(3);
        setLayoutManager(new TableRowLayout().withMinorAlignment(Alignment.CENTER));
        EntityFigure column = new EntityFigure(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING));
        column.add(createContentPane(0));
        column.add(createContentPane(1));
        column.addKeyword("deinit");
        add(column);
        addContentLighter("()");
        add(createContentPane(2, new RoundBracketsBorder()));
    }
}
