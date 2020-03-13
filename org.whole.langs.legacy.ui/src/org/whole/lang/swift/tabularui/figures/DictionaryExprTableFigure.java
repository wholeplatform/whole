package org.whole.lang.swift.tabularui.figures;

import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.TableLayout;
import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.SquareBracketsBorder;

public class DictionaryExprTableFigure extends TableFigure {

    public DictionaryExprTableFigure() {
        setLayoutManager(new TableLayout().withRowSpacing(5).withColumnSpacing(16).withMargin(5));
        setBorder(new SquareBracketsBorder());
    }

    @Override
    protected void paintFigure(Graphics graphics) {
        super.paintFigure(graphics);
        TableLayout l = getLayoutManager();
        if (l.rows() == 0)
            return ;
        graphics.setForegroundColor(FigureConstants.lightGray);
        drawColumnSeparators(graphics);
    }
}
