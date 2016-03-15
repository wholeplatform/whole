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

import org.whole.lang.commons.model.Fragment;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;

/**
 * Invariants:
 *   1) The same CompoundModel instance for all entities of a program (composition of models)
 *      Responsible for notification mechanism (listeners and notification)
 *      Mantained by IEntity.setModel: copy down all the hierarchy
 *      Structural setters indirectly updates CompoundModel 
 *   2) The same FragmentId (immutable) value for all entities of a model
 *      Used to map to an editorKit
 *      Initialized by IEntity.setModel: copy down the hierarchy if unsetted(TODO replace behavior)
 *      ...called by PrototypeManager.clone
 *      ...called by makeRootEntity during JavaStore model building and prototype initialization
 *      ...called by notifyChanged on a setter call (must not change fragmentId!)
 *   3) The same FragmentRoot entity for all entities of a fragment
 *      Used to navigate upward (with fragment granularity)
 *      Used also to grant alternating fragment types
 *      Mantained by IEntity.setModel: copy down the hierarchy,
 *      AbstractFragments set itself as fragmentRoot for children model
 * 
 * @author Riccardo Solmi
 */
public interface IFragmentModel extends Cloneable {
    public Object clone();

	public ILanguageKit getLanguageKit();
	public IEditorKit getEditorKit();
	public void setEditorKit(IEditorKit editorKit);

	public Fragment getFragment();
	public void setFragment(Fragment fragment);

	public ICompoundModel getCompoundModel();
	public void setCompoundModel(ICompoundModel model);
}