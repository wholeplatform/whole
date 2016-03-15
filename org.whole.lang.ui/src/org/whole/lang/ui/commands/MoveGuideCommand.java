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
package org.whole.lang.ui.commands;

import java.util.Iterator;

import org.eclipse.gef.commands.Command;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.ruler.WholeGuide;

/**
 * @author Riccardo Solmi
 */
public class MoveGuideCommand extends Command implements ILegacyCommand {
	private WholeGuide guide;
	private int pDelta;

	public MoveGuideCommand(WholeGuide guide, int positionDelta) {
		super("Move guide");
		this.guide = guide;
		pDelta = positionDelta;
	}

	public void execute() {
		guide.setPosition(guide.getPosition() + pDelta);
		Iterator iter = guide.getParts().iterator();
		while (iter.hasNext()) {
			IEntity part = (IEntity) iter.next();
//			Point location = part.getLocation().getCopy();
//			if (guide.isHorizontal()) {
//				location.y += pDelta;
//			} else {
//				location.x += pDelta;
//			}
//			part.setLocation(location);
		}
	}

	public void undo() {
		guide.setPosition(guide.getPosition() - pDelta);
		Iterator iter = guide.getParts().iterator();
		while (iter.hasNext()) {
			IEntity part = (IEntity) iter.next();
//			Point location = part.getLocation().getCopy();
//			if (guide.isHorizontal()) {
//				location.y -= pDelta;
//			} else {
//				location.x -= pDelta;
//			}
//			part.setLocation(location);
		}
	}

}
