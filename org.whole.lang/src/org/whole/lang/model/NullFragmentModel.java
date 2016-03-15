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

import java.io.ObjectStreamException;
import java.io.Serializable;

import org.whole.lang.commons.model.Fragment;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.util.WholeMessages;


/**
 * @author Riccardo Solmi
 */
public class NullFragmentModel implements IFragmentModel, Serializable {
	private static final long serialVersionUID = 1L;
	public static final NullFragmentModel instance = new NullFragmentModel();
	public NullFragmentModel() {
	}
    public Object readResolve() throws ObjectStreamException {
    	return NullFragmentModel.instance;
    }

    public Object clone() {
        return this;
	}

//    public IRequestEventHandler getRequestEventHandler() {
//    	return IdentityRequestEventHandler.instance;
//    }
//
//    public IChangeEventHandler getChangeEventHandler() {
//        return IdentityChangeEventHandler.instance;
//    }
//    public void addChangeEventHandler(IChangeEventHandler eventHandler) {
//		throw new IllegalStateException(WholeMessages.null_model);
//    }

	public ILanguageKit getLanguageKit() {
		throw new IllegalStateException(WholeMessages.null_model);	}
	public IEditorKit getEditorKit() {
		throw new IllegalStateException(WholeMessages.null_model);	}
	public void setEditorKit(IEditorKit fragmentOrd) {
		throw new IllegalStateException(WholeMessages.null_model);	}

	public Fragment getFragment() {
		throw new IllegalStateException(WholeMessages.null_model);
	}
	public void setFragment(Fragment root) {
	}

	public ICompoundModel getCompoundModel() {
		return NullCompoundModel.instance;
	}
	public void setCompoundModel(ICompoundModel model) {
		throw new IllegalAccessError();
	}

//	public void addModelListener(PropertyChangeListener l) {
//		throw new IllegalStateException(WholeMessages.null_model);
//	}
//	public void removeModelListener(PropertyChangeListener l) {
//		throw new IllegalStateException(WholeMessages.null_model);
//	}
//
//	public void notifyChanged(IEntity source, String propertyName, boolean oldValue, boolean newValue) {
//	}
//	public void notifyChanged(IEntity source, String propertyName, int oldValue, int newValue) {
//	}
//	public void notifyChanged(IEntity source, String propertyName, Object oldValue, Object newValue) {
//	}
}
