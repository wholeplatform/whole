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
package org.whole.lang.model;

import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.events.IPropertyChangeObserver;
import org.whole.lang.events.IRequestEventHandler;
import org.whole.lang.lifecycle.IHistoryManager;

/**
 * @author Riccardo Solmi
 */
public interface ICompoundModel {
	public ICompoundModel merge(ICompoundModel compoundModel, boolean mergeHistory);

	public IRequestEventHandler getRequestEventHandler();
	public IRequestEventHandler addRequestEventHandler(IRequestEventHandler eventHandler);
    public IChangeEventHandler getChangeEventHandler();
	public IChangeEventHandler addChangeEventHandler(IChangeEventHandler eventHandler);

	public IHistoryManager getHistoryManager();
	public void setHistoryManager(IHistoryManager historyManager, boolean mergeHistory);
	public boolean isHistoryEvent();
	public boolean isHistoryEnabled();

    public boolean isObserved(IEntity entity);
	public IChangeEventHandler getPropertyChangeEventHandler();
	public void fireNotationEvent(IEntity source, String name, Object data);
    public void addEventListener(IPropertyChangeObserver l);
    public void removeEventListener(IPropertyChangeObserver l);
}
