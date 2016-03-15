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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.gef.commands.Command;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.ruler.WholeGuide;
import org.whole.lang.ui.ruler.WholeRuler;

/**
 * @author Riccardo Solmi
 */
public class DeleteGuideCommand extends Command implements ILegacyCommand {
	private WholeRuler parent;
	private WholeGuide guide;
	private Map oldParts;

	public DeleteGuideCommand(WholeGuide guide, WholeRuler parent) {
		super("Delete guide");
		this.guide = guide;
		this.parent = parent;
	}

	public boolean canUndo() {
		return true;
	}

	public void execute() {
		oldParts = new HashMap(guide.getMap());
		Iterator iter = oldParts.keySet().iterator();
		while (iter.hasNext()) {
			guide.detachPart((IEntity) iter.next());
		}
		parent.removeGuide(guide);
	}

	public void undo() {
		parent.addGuide(guide);
		Iterator iter = oldParts.keySet().iterator();
		while (iter.hasNext()) {
			IEntity part = (IEntity) iter.next();
			guide.attachPart(part, ((Integer) oldParts.get(part)).intValue());
		}
	}
}
