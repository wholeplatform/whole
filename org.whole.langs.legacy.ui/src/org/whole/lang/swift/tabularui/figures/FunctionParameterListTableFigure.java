package org.whole.lang.swift.tabularui.figures;

import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.TableLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.FigureConstants;

public class FunctionParameterListTableFigure extends TableFigure {

    public FunctionParameterListTableFigure() {
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
        drawColumnBackground(graphics, 0, FigureConstants.templateLanguageAlpha - 80);
        drawColumnBackground(graphics, 1, FigureConstants.templateLanguageAlpha - 80);
        graphics.setBackgroundColor(ColorConstants.gray);
        drawHeadersRowBackground(graphics);
        graphics.setForegroundColor(ColorConstants.lightGray);
        drawHeadersRowSeparator(graphics);
    }
}
