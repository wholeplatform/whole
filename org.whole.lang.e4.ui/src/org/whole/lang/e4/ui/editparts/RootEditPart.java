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
package org.whole.lang.e4.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.ScalableLayeredPane;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.AutoexposeHelper;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.whole.lang.ui.editparts.WholeViewportAutoexposeHelper;

/**
 * @author Enrico Persiani
 */
public class RootEditPart extends ScalableRootEditPart implements IScalableRootEditPart {
	@Override
	protected Viewport createViewport() {
		Viewport viewport = super.createViewport();
		viewport.setContentsTracksWidth(true);
		viewport.setContentsTracksHeight(true);
		return viewport;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key == AutoexposeHelper.class)
			return new WholeViewportAutoexposeHelper(this);
		return super.getAdapter(key);
	}

	protected ScalableLayeredPane createScaledLayers() {
		ScalableLayeredPane layers = new ScalableLayeredPane() {
			public Dimension superGetMinimumSize(int wHint, int hHint) {
				if (minSize != null)
					return minSize;
				if (getLayoutManager() != null) {
					Dimension d = getLayoutManager().getMinimumSize(this, wHint, hHint);
					if (d != null)
						return d;
				}
				return getPreferredSize(wHint, hHint);
			}
			public Dimension superGetPreferredSize(int wHint, int hHint) {
				if (prefSize != null)
					return prefSize;
				if (getLayoutManager() != null) {
					Dimension d = getLayoutManager().getPreferredSize(this, wHint, hHint);
					if (d != null)
						return d;
				}
				return getSize();
			}

			@Override
			public Dimension getMinimumSize(int wHint, int hHint) {
				Dimension d = superGetMinimumSize(
						wHint == -1 ? -1 : (int) (wHint / getScale()),
						hHint == -1 ? -1 : (int) (hHint / getScale()));
				int w = getInsets().getWidth();
				int h = getInsets().getHeight();
				return d.getExpanded(-w, -h).scale(getScale()).expand(w, h);
			}
			@Override
			public Dimension getPreferredSize(int wHint, int hHint) {
				Dimension d = superGetPreferredSize(
						wHint == -1 ? -1 : (int) (wHint / getScale()),
						hHint == -1 ? -1 : (int) (hHint / getScale()));
				int w = getInsets().getWidth();
				int h = getInsets().getHeight();
				return d.getExpanded(-w, -h).scale(getScale()).expand(w, h);
			}
		};
		layers.add(createGridLayer(), GRID_LAYER);
		layers.add(getPrintableLayers(), PRINTABLE_LAYERS);
		layers.add(new FeedbackLayer(), SCALED_FEEDBACK_LAYER);
		return layers;
	}

	class FeedbackLayer extends Layer {
		FeedbackLayer() {
			setEnabled(false);
		}
		public Dimension getPreferredSize(int wHint, int hHint) {
			Rectangle rect = new Rectangle();
			for (int i = 0; i < getChildren().size(); i++)
				rect.union(((IFigure)getChildren().get(i)).getBounds());
			return rect.getSize();
		}
	}
}
