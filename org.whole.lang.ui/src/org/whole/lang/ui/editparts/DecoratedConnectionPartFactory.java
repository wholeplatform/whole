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
package org.whole.lang.ui.editparts;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gef.ConnectionEditPart;
import org.whole.lang.ui.figures.ArrowFactory;

/**
 * @author Riccardo Solmi
 */
public class DecoratedConnectionPartFactory {
	public static final int NONE = 0;
	public static final int ARROW = 1;
	public static final int FILLED_ARROW = 2;
	public static final int RHOMB = 3;
	public static final int FILLED_RHOMB = 4;

	private static class SingletonHolder {
		private static final DecoratedConnectionPartFactory instance = new DecoratedConnectionPartFactory();
	}
	public static DecoratedConnectionPartFactory instance() {
		return SingletonHolder.instance;
	}
	protected DecoratedConnectionPartFactory() {
	}

	public RotatableDecoration createDecoration(final int type) {
		switch (type) {
		case ARROW:
			return new PolylineDecoration();
		case FILLED_ARROW:
			return new PolygonDecoration();
		case RHOMB:
			PolygonDecoration p = new PolygonDecoration();
			p.setTemplate(ArrowFactory.RHOMB_TIP);
			p.setFill(false);
			return p;
		case FILLED_RHOMB:
			p = new PolygonDecoration();
			p.setTemplate(ArrowFactory.RHOMB_TIP);
			p.setFill(true);
			return p;
		default:
			return null;
		}
	}
	public PolylineConnection createConnection(final int targetDecorationType) {
		return createConnection(NONE, targetDecorationType);
	}
	public PolylineConnection createConnection(final int sourceDecorationType, final int targetDecorationType) {
		PolylineConnection connection = new PolylineConnection();
		connection.setSourceDecoration(createDecoration(sourceDecorationType));
		connection.setTargetDecoration(createDecoration(targetDecorationType));
		return connection;
	}

	public ConnectionEditPart createConnectionPart(final int targetDecorationType) {
		return createConnectionPart(NONE, targetDecorationType);
	}
	public ConnectionEditPart createConnectionPart(final int sourceDecorationType, final int targetDecorationType) {
		return new SimpleConnectionPart() {
			protected IFigure createFigure() {
				PolylineConnection connection = new PolylineConnection() {
					public void paintFigure(Graphics graphics) {
						// workaround to eliminate initial painting using default coordinates
						if (getSource() != null && getTarget() != null)
							super.paintFigure(graphics);
					};
					@Override
					protected void paintClientArea(Graphics graphics) {
						// workaround to eliminate initial painting using default coordinates
						if (getSource() != null && getTarget() != null)
							super.paintClientArea(graphics);
					}
				};
				connection.setSourceDecoration(createDecoration(sourceDecorationType));
				connection.setTargetDecoration(createDecoration(targetDecorationType));
				return connection;
			}
		};
	}
}
