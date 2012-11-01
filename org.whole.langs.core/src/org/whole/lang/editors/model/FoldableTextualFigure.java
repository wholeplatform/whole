package org.whole.lang.editors.model;

/** 
 * @generator Whole
 */
public interface FoldableTextualFigure extends IEditorsEntity, FigureBody {
	public TextualFigure getExpandedFigure();

	public void setExpandedFigure(TextualFigure expandedFigure);

	public TextualFigure getCollapsedFigure();

	public void setCollapsedFigure(TextualFigure collapsedFigure);
}
