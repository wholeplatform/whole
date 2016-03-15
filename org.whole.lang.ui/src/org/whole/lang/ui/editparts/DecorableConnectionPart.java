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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;

/**
 * @author Riccardo Solmi
 */
public class DecorableConnectionPart extends SimpleConnectionPart {
	protected int sourceDecorationType;
	protected int targetDecorationType;
	
	public DecorableConnectionPart() {
		this(DecoratedConnectionPartFactory.NONE, DecoratedConnectionPartFactory.NONE);
	}
	public DecorableConnectionPart(int targetDecorationType) {
		this(DecoratedConnectionPartFactory.NONE, targetDecorationType);
	}
	public DecorableConnectionPart(int sourceDecorationType, int targetDecorationType) {
		this.sourceDecorationType = sourceDecorationType;
		this.targetDecorationType = targetDecorationType;
	}
	
	protected IFigure createFigure() {
		PolylineConnection connection = (PolylineConnection) super.createFigure();
		connection.setSourceDecoration(DecoratedConnectionPartFactory.instance().createDecoration(sourceDecorationType));
		connection.setTargetDecoration(DecoratedConnectionPartFactory.instance().createDecoration(targetDecorationType));
		return connection;
	}
	
	//TODO refresh code
}
