/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ButtonModel;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.Toggle;
import org.whole.lang.ui.layout.ITabularLayoutClient;
import org.whole.lang.ui.layout.ITabularLayoutServer;
import org.whole.lang.ui.layout.MonoLayout;
import org.whole.lang.ui.layout.StackLayout;
import org.whole.lang.ui.layout.ViewportTracking;
import org.whole.lang.ui.util.AnimableRunnable;
import org.whole.lang.util.CompositeUtils;

/**
 * @author Riccardo Solmi
 */
public class ContentPaneFigure extends EntityFigure implements IFoldableFigure {
	public static final int[] EMPTY_INT_ARRAY = new int[0];

	protected IEntityFigure[] contentPanes = null;
	protected int[] toggleIndexOfContentPane = EMPTY_INT_ARRAY;
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

		int paneIndex = ancestorOrSelfContentPaneIndexOf(figure);
		if (paneIndex == -1)
			return result;

		int toggleIndex = toggleIndexOf(paneIndex);
		if (toggleIndex == -1)
			return result;

		result.add(getFoldingToggle(toggleIndex));
		return result;
	}

	protected int toggleIndexOf(int paneIndex) {
		return paneIndex >= toggleIndexOfContentPane.length ? -1 : toggleIndexOfContentPane[paneIndex];
	}
	protected void bindFoldingToggle(int toggleIndex, int... paneIndexes) {
		int maxIndex = contentPanes.length-1;
		for (int i = 0; i < paneIndexes.length; i++)
			if (paneIndexes[i] > maxIndex)
				maxIndex = paneIndexes[i];

		toggleIndexOfContentPane = CompositeUtils.grow(toggleIndexOfContentPane, maxIndex+1, -1);

		for (int paneIndex : paneIndexes)
			if (paneIndex >= 0 && paneIndex < toggleIndexOfContentPane.length)
				toggleIndexOfContentPane[paneIndex] = toggleIndex;
	}

	protected int ancestorOrSelfContentPaneIndexOf(IFigure figure) {
		if (contentPanes == null)
			return -1;
		do {
			int index = contentPaneIndexOf(figure);
			if (index >= 0)
				return index;
			
			figure = figure.getParent();
		} while (figure != this);
		return -1;
	}
	protected int contentPaneIndexOf(IFigure contentPane) {
		for (int i=0; i<contentPanes.length; i++)
			if (contentPanes[i] == contentPane)
				return i;
		return -1;
	}

	public void clickFoldingToggle(final int toggleIndex) {
		ButtonModel model = getFoldingToggle(toggleIndex).getModel();
		model.setSelected(!model.isSelected());
		for (int i = toggleIndexOfContentPane.length-1; i >= 0; i--)
			if (toggleIndexOfContentPane[i] == toggleIndex) {
				toggleVisibility(i);
				break;
			}
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

	public Toggle createFoldingToggle(int paneIndexOrTag, int... paneIndexes) {
		return createFoldingToggle(new EntityToggle(), paneIndexOrTag, paneIndexes);
	}
	public Toggle createFoldingToggle(Toggle toggle, final int paneIndexOrTag, int... paneIndexes) {
		toggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new AnimableRunnable() {
					public void doRun() {
						toggleVisibility(paneIndexOrTag);
					}
				}.syncExec();
			}
        });

		createActionableFoldingToggle(toggle, paneIndexes);
		bindFoldingToggle(foldingToggles.size()-1, paneIndexOrTag);

		return toggle;
	}
	public Toggle createActionableFoldingToggle(Toggle toggle, int... paneIndexes) {
		if (foldingToggles == Collections.EMPTY_LIST) {
			foldingToggles = new ArrayList<Toggle>();
			addLayoutListener(LayoutAnimator.getDefault());
		}
		foldingToggles.add(toggle);
		bindFoldingToggle(foldingToggles.size()-1, paneIndexes);

		return toggle;
	}
	protected void toggleVisibility(int paneIndexOrTag) {
		IFigure contentPane = getContentPane(paneIndexOrTag);
		contentPane.setVisible(!contentPane.isVisible());
	}

	public void initContentPanes(int size) {
		contentPanes = new IEntityFigure[size];
	}
	public IEntityFigure createContentPane(int paneIndex) {
		return createContentPane(paneIndex, ViewportTracking.NONE);
	}
	public IEntityFigure createContentPane(int paneIndex, Border border) {
		IEntityFigure contentPane = createContentPane(paneIndex);
		contentPane.setBorder(border);
		return contentPane;
	}
	public IEntityFigure createContentPane(int paneIndex, ViewportTracking viewportTracking) {
		MonoLayout monoLayout = new MonoLayout().withInheritedAlignment();
		if (viewportTracking.isHorizontal())
			monoLayout.withMajorAutoresizeWeight(1.0f);
		if (viewportTracking.isVertical())
			monoLayout.withMinorAutoresizeWeight(1.0f);

		return createContentPane(paneIndex, new EntityFigure(monoLayout) {
			public ITabularLayoutServer getTabularLayoutServer() {
				return getParent() instanceof IEntityFigure ? ((IEntityFigure) getParent()).getTabularLayoutServer() : null;
			}
			public ITabularLayoutClient getTabularLayoutClient() {
				return ((IEntityFigure) getChildren().get(0)).getTabularLayoutClient();
			}
		}.withViewportTracking(viewportTracking));
	}
	public IEntityFigure createContentPane(int paneIndex, IEntityFigure figure) {
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
	public IEntityFigure getContentPane(int paneIndex) {
		return contentPanes != null ? contentPanes[paneIndex] : this;
	}

	public <F extends IEntityFigure> F addWithPlaceHolder(F child) {
		IEntityFigure stackedFigure = new EntityFigure(new StackLayout());
        stackedFigure.add(LabelFactory.createEmptyLabel());
        stackedFigure.add(child);
        add(stackedFigure);

        return child;
	}
}
