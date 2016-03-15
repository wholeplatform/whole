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
package org.whole.lang.ui.ruler;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.rulers.RulerChangeListener;
import org.eclipse.gef.rulers.RulerProvider;
import org.whole.lang.ui.commands.CreateGuideCommand;
import org.whole.lang.ui.commands.DeleteGuideCommand;
import org.whole.lang.ui.commands.MoveGuideCommand;

/**
 * @author Riccardo Solmi
 */
public class WholeRulerProvider extends RulerProvider {
	WholeRuler ruler;
	
	private PropertyChangeListener rulerListener = new PropertyChangeListener() {
		public void propertyChange(PropertyChangeEvent evt) {
			if (evt.getPropertyName().equals(WholeRuler.PROPERTY_CHILDREN)) {
				WholeGuide guide = (WholeGuide) evt.getNewValue();
				if (getGuides().contains(guide)) {
					guide.addPropertyChangeListener(guideListener);
				} else {
					guide.removePropertyChangeListener(guideListener);
				}
				for (int i = 0; i < listeners.size(); i++) {
					((RulerChangeListener)listeners.get(i))
							.notifyGuideReparented(guide);
				}
			} else {
				for (int i = 0; i < listeners.size(); i++) {
					((RulerChangeListener) listeners.get(i))
							.notifyUnitsChanged(ruler.getUnit());
				}
			}
		}
	};
	private PropertyChangeListener guideListener = new PropertyChangeListener() {
		public void propertyChange(PropertyChangeEvent evt) {
			if (evt.getPropertyName().equals(WholeGuide.PROPERTY_CHILDREN)) {
				for (int i = 0; i < listeners.size(); i++) {
					((RulerChangeListener)listeners.get(i))
							.notifyPartAttachmentChanged(evt.getNewValue(), evt.getSource());
				}
			} else {
				for (int i = 0; i < listeners.size(); i++) {
					((RulerChangeListener)listeners.get(i))
							.notifyGuideMoved(evt.getSource());
				}
			}
		}
	};

	public WholeRulerProvider(WholeRuler ruler) {
		this.ruler = ruler;
		this.ruler.addPropertyChangeListener(rulerListener);
		List<?> guides = getGuides();
		for (int i = 0; i < guides.size(); i++) {
			((WholeGuide) guides.get(i)).addPropertyChangeListener(guideListener);
		}
	}

	public Object getRuler() {
		return ruler;
	}

	public int getUnit() {
		return ruler.getUnit();
	}
	public void setUnit(int newUnit) {
		ruler.setUnit(newUnit);
	}

	@SuppressWarnings("unchecked")
	public List getGuides() {
		return ruler.getGuides();
	}
	public int[] getGuidePositions() {
		List<?> guides = getGuides();
		int[] result = new int[guides.size()];
		for (int i = 0; i < guides.size(); i++)
			result[i] = getGuidePosition(guides.get(i));
		return result;
	}
	public int getGuidePosition(Object guide) {
		return ((WholeGuide) guide).getPosition();
	}
	public Object getGuideAt(int position) {
		List<?> guides = getGuides();
		for (int i = 0; i < guides.size(); i++) {
			Object guide = guides.get(i);
			if (position >= (getGuidePosition(guide)-2) &&
					position <= (getGuidePosition(guide)+2) ) {
				return guide;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List getAttachedModelObjects(Object guide) {
		return new ArrayList(((WholeGuide) guide).getParts());
	}

	public Command getCreateGuideCommand(int position) {
		return new CreateGuideCommand(ruler, position);
	}

	public Command getDeleteGuideCommand(Object guide) {
		return new DeleteGuideCommand((WholeGuide) guide, ruler);
	}

	public Command getMoveGuideCommand(Object guide, int pDelta) {
		return new MoveGuideCommand((WholeGuide) guide, pDelta);
	}
}
