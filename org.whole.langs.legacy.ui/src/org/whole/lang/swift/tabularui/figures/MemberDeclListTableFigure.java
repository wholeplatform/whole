package org.whole.lang.swift.tabularui.figures;

import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.TableLayout;

public class MemberDeclListTableFigure extends TableFigure {

    public MemberDeclListTableFigure() {
        setLayoutManager(new TableLayout().withRowSpacing(5).withColumnSpacing(10).withMargin(5));
    }
}
