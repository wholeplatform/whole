/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.changes.ui.editparts;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.whole.lang.changes.model.ChangeSides;
import org.whole.lang.changes.model.Revision;
import org.whole.lang.changes.model.RevisionChange;
import org.whole.lang.changes.model.RevisionTrack;
import org.whole.lang.changes.model.Revisions;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.figures.FigurePrefs;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractComparePart extends AbstractContentPanePart {

    public class CompareMapper {
    	public Map<IEntity, IEntity> map = new HashMap<IEntity, IEntity>();

    	public void rebuildRevisionMap(Revision revision) {
    		map = new HashMap<IEntity, IEntity>();
			try {
				revision.getChanges().forEach(rc -> {
					if (EntityUtils.isResolver(rc))
						return;
					ChangeSides sides = rc.getSides();
					map.put(sides.wGet(0), sides.wGet(1));
				});
			} catch (IllegalArgumentException e) {
			}
		}

    	public void rebuildRevisionMap(IEntity content, int index) {
    		map = new HashMap<IEntity, IEntity>();
    		if (content.wGetParent().wGetEntityDescriptor().equals(ChangesEntityDescriptorEnum.RevisionTrack)) {
    			RevisionTrack revisionTrack = (RevisionTrack) content.wGetParent();
    			Revisions revisions = revisionTrack.getRevisions();

    			try {
				if (revisions.size() > index) {
					Revision revision = revisions.get(index);
					for (RevisionChange rc : revision.getChanges()) {
						if (EntityUtils.isResolver(rc))
							continue;
						ChangeSides sides = rc.getSides();
						if (index == 0) //left mapping
							map.put(sides.wGet(1), sides.wGet(0));
						else
							map.put(sides.wGet(0), sides.wGet(1));
					}

//    				revisions.get(index)
//    					.getChanges().stream()
//    					.map(rc -> rc.getSides())
//    					.filter(cs -> cs.size() == 2)
//    					.forEach(s -> map.put(s.wGet(0), s.wGet(1)));
				}
    			} catch (IllegalArgumentException e) {
    			}
    		}
    	}

    	public void paintMapping(Graphics g, int x0, int x1) {
    		Map<IEntity, IEntityPart> editPartRegistry = getViewer().getEditPartRegistry();
    		for (Map.Entry<IEntity, IEntity> entry : map.entrySet()) {
            	IEntity le = entry.getKey();
            	IEntity re = entry.getValue();
				IEntityPart lePart = ModelObserver.getObserver(le, editPartRegistry);
            	IEntityPart rePart = ModelObserver.getObserver(re, editPartRegistry);

            	//TODO function arg
            	if (lePart != null && rePart != null) {
            		Rectangle leBounds = ((IGraphicalEntityPart) lePart).getFigure().getBounds();
            		Rectangle reBounds = ((IGraphicalEntityPart) rePart).getFigure().getBounds();
            		int y0Center = leBounds.y + leBounds.height / 2;
            		int y1Center = reBounds.y + reBounds.height / 2;

            		g.setBackgroundColor(le.wGetEntityDescriptor().equals(ChangesEntityDescriptorEnum.Insert) ?
            				FigurePrefs.addBackgroundColor : FigurePrefs.deleteBackgroundColor);
            		g.setForegroundColor(FigurePrefs.collapseColor);

            		if (leBounds.height > 6) {
	            		g.fillRectangle(x0, leBounds.y, 4, leBounds.height);
	            		g.drawPolyline(new int[] {
	            				x0, leBounds.y, x0 + 4, leBounds.y,
	            				x0 + 4, leBounds.bottom(), x0, leBounds.bottom()
	            		});
            		} else
            			g.drawLine(x0, y0Center, x0 + 4, y0Center);

            		g.setBackgroundColor(re.wGetEntityDescriptor().equals(ChangesEntityDescriptorEnum.Insert) ?
            				FigurePrefs.addBackgroundColor : FigurePrefs.deleteBackgroundColor);
            		g.setForegroundColor(FigurePrefs.collapseColor);

            		if (reBounds.height > 6) {
	            		g.fillRectangle(x1 - 5, reBounds.y, 5, reBounds.height);
	            		g.drawPolyline(new int[] {
	            				x1, reBounds.y, x1 - 5, reBounds.y,
	            				x1 - 5, reBounds.bottom(), x1, reBounds.bottom()
	            		});
            		} else
            			g.drawLine(x1, y1Center, x1 - 5, y1Center);

            		g.setForegroundColor(FigurePrefs.collapseColor);
            		g.drawLine(x0 + 4, y0Center, x1 - 5, y1Center);

            		g.pushState();
            		g.setLineStyle(SWT.LINE_CUSTOM);
            		g.setLineDash(new int[] {1,3});
            		
            		if (leBounds.height > 6) {
            			g.drawLine(x0, leBounds.y, leBounds.x, leBounds.y);
            			g.drawLine(x0, leBounds.bottom(), leBounds.x, leBounds.bottom());
            		} else
            			g.drawLine(x0, y0Center, leBounds.x, y0Center);

            		if (reBounds.height > 6) {
            			g.drawLine(x1, reBounds.y, reBounds.x, reBounds.y);
            			g.drawLine(x1, reBounds.bottom(), reBounds.x, reBounds.bottom());
            		} else
            			g.drawLine(x1, y1Center, reBounds.x, y1Center);

            		g.popState();
            	}
    		}
    	}
    }
}