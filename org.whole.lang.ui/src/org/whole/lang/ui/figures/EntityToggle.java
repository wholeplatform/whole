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

import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.ButtonModel;
import org.eclipse.draw2d.ChangeEvent;
import org.eclipse.draw2d.ChangeListener;
import org.eclipse.draw2d.Clickable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.Toggle;
import org.eclipse.draw2d.ToggleModel;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.layout.EntityLayoutAdapter;
import org.whole.lang.ui.layout.IEntityLayout;
import org.whole.lang.ui.layout.ITabularLayoutClient;
import org.whole.lang.ui.layout.ITabularLayoutServer;
import org.whole.lang.ui.treesearch.DelegatingInteractiveTreeSearch;
import org.whole.lang.ui.treesearch.ITreeSearch;


/**
 * @author Riccardo Solmi
 */
public class EntityToggle extends Toggle implements IEntityFigure {
	protected final IEntityFigure contents;
	
	{
		setRequestFocusEnabled(false);
		setFocusTraversable(false);
	}

	public EntityToggle() {
		this(WholeImages.COLLAPSE, WholeImages.EXPAND);
	}
	public EntityToggle(final Image image1, final Image image2) {
		this(image1, image2, null);
	}
	public EntityToggle(final Image image1, final Image image2, ActionListener action) {
		super();
		final EntityLabel label = createLabel(image1);
		
		setContents(contents = label);

		/*getModel().*/addChangeListener(new ChangeListener() {
			public void handleStateChanged(ChangeEvent event) {
				if (ButtonModel.SELECTED_PROPERTY.equals(event.getPropertyName()))
					label.setIcon(label.getIcon() == image1 ? image2 : image1);
			}
        });
		if (action != null)
			/*getModel().*/addActionListener(action);
	}
	public EntityToggle(final String text1, final String text2) {
		this(text1, text2, null);
	}
	public EntityToggle(final String text1, final String text2, ActionListener action) {
		super();
		final EntityLabel label = createLabel(text1);

		setContents(contents = label);

		/*getModel().*/addChangeListener(new ChangeListener() {
			public void handleStateChanged(ChangeEvent event) {
				if (ButtonModel.SELECTED_PROPERTY.equals(event.getPropertyName()))
					label.setText(label.getText().equals(text1) ? text2 : text1);
			}
        });
		if (action != null)
			/*getModel().*/addActionListener(action);
	}
	public EntityToggle(IEntityFigure contents, ActionListener action) {
		super(contents);
		this.contents = contents;

		if (action != null)
			/*getModel().*/addActionListener(action);
	}


//TODO begin code duplicated in EntityRectangleFigure, EntityFigure, EntityButton, EntityToggle, EntityLabel
//NB use Clickable.MAX_FLAG instead of Figure.MAX_FLAG
	public static final int
	FLAG_INTERACTIVE_EDIT = Clickable.MAX_FLAG << 1, //enables selection, dnD, delete
	FLAG_INTERACTIVE_BROWSE = Clickable.MAX_FLAG << 2, //enables text editing and clickables
	FLAG_INTERACTIVE_INHERITED = Clickable.MAX_FLAG << 3; //overrides both target and edit flags
	public static int MAX_FLAG = FLAG_INTERACTIVE_INHERITED;
//	FLAG_AUTORESIZE_CHILDREN = Figure.MAX_FLAG << 1,
//	FLAG_FLEXIBLE_WIDTH = Figure.MAX_FLAG << 2,
//	FLAG_FLEXIBLE_HEIGHT = Figure.MAX_FLAG << 3,
//	FLAG_FLEXIBLE_TOP = Figure.MAX_FLAG << 4,
//	FLAG_FLEXIBLE_LEFT = Figure.MAX_FLAG << 5,
//	FLAG_FLEXIBLE_BOTTOM = Figure.MAX_FLAG << 6,
//	FLAG_FLEXIBLE_RIGHT = Figure.MAX_FLAG << 7;

	{
		setInteractiveEdit(true);
		setInteractiveBrowse(true);
		setInteractiveInherited(true);
	}

	public boolean isInteractiveEdit() {
		return (flags & FLAG_INTERACTIVE_EDIT) != 0;
	}
	public void setInteractiveEdit(boolean interactiveEdit) {
		if (isInteractiveEdit() == interactiveEdit)
			return;
		setFlag(FLAG_INTERACTIVE_EDIT, interactiveEdit);
	}
	public boolean isInteractiveBrowse() {
		return (flags & FLAG_INTERACTIVE_BROWSE) != 0;
	}
	public void setInteractiveBrowse(boolean interactiveBrowse) {
		if (isInteractiveBrowse() == interactiveBrowse)
			return;
		setFlag(FLAG_INTERACTIVE_BROWSE, interactiveBrowse);
	}
	public boolean isInteractiveInherited() {
		return (flags & FLAG_INTERACTIVE_INHERITED) != 0;
	}
	public void setInteractiveInherited(boolean interactiveInherited) {
		if (isInteractiveInherited() == interactiveInherited)
			return;
		setFlag(FLAG_INTERACTIVE_INHERITED, interactiveInherited);
	}

//	@Override
//	protected boolean isMouseEventTarget() {
//		return super.isMouseEventTarget() && InteractiveTreeSearch.calculateInteractiveBrowse(this);
//	}

	@Override
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		return super.findFigureAt(x, y,
				search instanceof ITreeSearch ? search : new DelegatingInteractiveTreeSearch(search));
	}
//TODO end


	protected EntityLabel createLabel(Image image) {
		return new EntityLabel(image);
	}
	protected EntityLabel createLabel(String text) {
		return new EntityLabel(text);
	}

	@Override
	public void doClick() {
		((ToggleModel) getModel()).fireActionPerformed();
	}

	public int getIndent() {
		return contents.getIndent();
	}
	public int getAscent() {
		return contents.getAscent();
	}

	@Override
	public IEntityLayout getLayoutManager() {
		return (IEntityLayout) super.getLayoutManager();
	}
	@Override
	public void setLayoutManager(LayoutManager manager) {
		if (!(manager instanceof IEntityLayout))
			manager = new EntityLayoutAdapter(manager) {
				public int getIndent(IFigure container) {
					return ((IEntityFigure) container).getIndent();
				}
				public int getAscent(IFigure container) {
					return ((IEntityFigure) container).getAscent();
				}
			};

		super.setLayoutManager(manager);
	}
	public ITabularLayoutServer getTabularLayoutServer() {
		return null;
	}
	public ITabularLayoutClient getTabularLayoutClient() {
		return ITabularLayoutClient.NULL_TABULAR_LAYOUT_CLIENT;
	}

//TODO begin AbstractContentPaneFigure
	public int getContentPanesSize() {
		return 1;
	}
	public IEntityFigure getContentPane(int paneIndex) {
		return paneIndex == 0 ? this : null;
	}
	public void setContentPaneVisible(int paneIndex, boolean visible) {
		getContentPane(paneIndex).setVisible(visible);
	}
//TODO end
}
