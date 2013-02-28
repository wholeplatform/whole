/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.ui.figures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.Toggle;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ITabularLayoutClient;
import org.whole.lang.ui.layout.ITabularLayoutServer;
import org.whole.lang.ui.layout.MonoLayout;
import org.whole.lang.ui.util.AnimableRunnable;

/**
 * @author Riccardo Solmi
 */
public class ContentPaneFigure extends EntityFigure implements IFoldableFigure {
	protected IFigure[] contentPanes = null;
	protected int[] toggleIndexOfContentPane;
	private List<Toggle> foldingToggles = Collections.emptyList();

	protected ContentPaneFigure() {
	}
	public ContentPaneFigure(LayoutManager layout) {
		super(layout);
	}

	public List<Toggle> getFoldingToggles() {
		return foldingToggles;
	}

	public Toggle getFoldingToggle(int toggleIndex) {
		return getFoldingToggles().get(toggleIndex);
	}

	public List<Toggle> getFoldingToggles(IFigure figure) {
		List<Toggle> result = new ArrayList<Toggle>(2);

		int paneIndex = containingContentPaneIndex(figure);
		if (paneIndex == -1)
			return result;

		int toggleIndex = toggleIndex(paneIndex);
		if (toggleIndex == -1)
			return result;

		result.add(getFoldingToggle(toggleIndex));
		return result;
	}
	
	protected int toggleIndex(int paneIndex) {
		return toggleIndexOfContentPane == null ? -1 : toggleIndexOfContentPane[paneIndex];
	}
	protected void setToggleIndex(int paneIndex, int toggleIndex) {
		if (toggleIndexOfContentPane == null) {
			toggleIndexOfContentPane = new int[contentPanes.length];
			Arrays.fill(toggleIndexOfContentPane, -1);
		}
		if (paneIndex >= 0 && paneIndex < toggleIndexOfContentPane.length)
			toggleIndexOfContentPane[paneIndex] = toggleIndex;
	}

	protected int containingContentPaneIndex(IFigure figure) {
		if (contentPanes == null)
			return -1;
		do {
			int index = contentPaneIndex(figure);
			if (index >= 0)
				return index;
			
			figure = figure.getParent();
		} while (figure != this);
		return -1;
	}
	protected int contentPaneIndex(IFigure contentPane) {
		for (int i=0; i<contentPanes.length; i++)
			if (contentPanes[i] == contentPane)
				return i;
		return -1;
	}

	public void clickFoldingToggle(final int toggleIndex) {
		getFoldingToggle(toggleIndex).doClick();
	}

//	public void add(IFigure figure, Object constraint, int index) {
//		super.add(figure, constraint, index);
//		for (IFigure f : contentPanes)
//			if (f == null)
//				return;
//		
//		for (int toggleIndex=0; toggleIndex<foldingToggles.size(); toggleIndex++) {
//			ButtonModel model = getFoldingToggle(toggleIndex).getModel();
//			if (!model.isSelected())
//				toggleLayout(toggleIndex);
//		}
//	}

	public Toggle createToggleFigure(final int paneIndex) {
		return createToggleFigure(paneIndex, new EntityToggle());
	}
	public Toggle createToggleFigure(final int paneIndex, Toggle toggle) {
		Toggle toggleFigure = toggle;
		toggleFigure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new AnimableRunnable() {
					public void doRun() {
						toggleVisibility(paneIndex);
					}
				}.syncExec();
			}
        });

		if (foldingToggles == Collections.EMPTY_LIST) {
			foldingToggles = new ArrayList<Toggle>();
			addLayoutListener(LayoutAnimator.getDefault());
		}
		setToggleIndex(paneIndex, foldingToggles.size());
		foldingToggles.add(toggleFigure);

		return toggleFigure;
	}
	protected void toggleVisibility(int paneIndex) {
		IFigure contentPane = getContentPane(paneIndex);
		contentPane.setVisible(!contentPane.isVisible());
	}

	public void initContentPanes(int size) {
		contentPanes = new IFigure[size];
	}
	public IFigure createContentPane(int paneIndex, Border border) {
		IFigure contentPane = createContentPane(paneIndex);
		contentPane.setBorder(border);
		return contentPane;
	}
	public IFigure createContentPane(int paneIndex) {
		return createContentPane(paneIndex, new EntityFigure(new MonoLayout().withMinorAlignment(Alignment.LEADING)) {
			public ITabularLayoutServer getTabularLayoutServer() {
				return getParent() instanceof IEntityFigure ? ((IEntityFigure) getParent()).getTabularLayoutServer() : null;
			}
			public ITabularLayoutClient getTabularLayoutClient() {
				return ((IEntityFigure) getChildren().get(0)).getTabularLayoutClient();
			}
		});
	}
	public IFigure createContentPane(int paneIndex, IFigure figure) {
		return contentPanes[paneIndex] = figure;
	}
	public IFigure createNestedContentPanes(int firstPaneIndex, IEntityFigure figure) {
		for (int i=0; i<figure.getContentPanesSize(); i++)
			contentPanes[firstPaneIndex+i] = figure.getContentPane(i);

		if (figure instanceof IFoldableFigure) {
			if (foldingToggles == Collections.EMPTY_LIST)
				foldingToggles = new ArrayList<Toggle>();
			foldingToggles.addAll(((IFoldableFigure) figure).getFoldingToggles());
		}
		return figure;
	}

	public int getContentPanesSize() {
		return contentPanes != null ? contentPanes.length : 1;
	}
	public IFigure getContentPane(int paneIndex) {
		return contentPanes != null ? contentPanes[paneIndex] : this;
	}
}
