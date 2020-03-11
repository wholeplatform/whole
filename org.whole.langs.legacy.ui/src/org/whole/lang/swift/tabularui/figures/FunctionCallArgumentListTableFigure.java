package org.whole.lang.swift.tabularui.figures;

import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.TableLayout;
import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.FigureConstants;

public class FunctionCallArgumentListTableFigure extends TableFigure {

    public FunctionCallArgumentListTableFigure() {
        setLayoutManager(new TableLayout().withRowSpacing(5).withColumnSpacing(10).withMargin(5));
    }

    @Override
    protected void paintFigure(Graphics graphics) {
        super.paintFigure(graphics);
        TableLayout l = getLayoutManager();
        if (l.rows() == 0)
            return ;
        graphics.setBackgroundColor(FigureConstants.templateLanguageColor);
        graphics.setForegroundColor(FigureConstants.templateLanguageColor);
        drawColumnSeparators(graphics);
        drawAlternateColumnsBackground(graphics, 0, FigureConstants.templateLanguageAlpha - 80);
    }
}
