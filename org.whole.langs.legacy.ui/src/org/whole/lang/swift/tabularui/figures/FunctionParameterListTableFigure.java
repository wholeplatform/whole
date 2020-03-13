package org.whole.lang.swift.tabularui.figures;

import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.TableLayout;

public class FunctionParameterListTableFigure extends TableFigure {

    public FunctionParameterListTableFigure() {
        setLayoutManager(new TableLayout() {
        	@Override
        	protected int getAscent(int height) {
        		int size = childSize.length;
        		return size > 0 && childSize[size-1] != null ? height - descent(size-1) : super.getAscent(height);
        	}
        }.withRowSpacing(5).withColumnSpacing(10).withMargin(5));
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
    }
}
