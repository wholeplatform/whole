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

import java.io.IOException;
import java.io.Serializable;

import org.whole.lang.commons.model.Fragment;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Riccardo Solmi
 */
public class FragmentModel implements IFragmentModel, Serializable {
	private static final long serialVersionUID = 1L;
	private ICompoundModel compoundModel = NullCompoundModel.instance;

	transient private ILanguageKit languageKit;
	transient private IEditorKit editorKit;
	private Fragment fragment;

	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		languageKit = ReflectionFactory.getLanguageKit(in.readUTF(), true, null);
		String editorKitName = in.readUTF();
		if (editorKitName.length() > 0)
			editorKit = ReflectionFactory.hasEditorKit(editorKitName) ? ReflectionFactory.getEditorKit(editorKitName) : null;
	}
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeUTF(languageKit.getURI());
		out.writeUTF(editorKit != null ? editorKit.getId() : "");		
	}

	// used by standard serialization
	public FragmentModel() {
		this(null, null);
	}
	// called from RootFragment
	public FragmentModel(Fragment fragment) {
		this(fragment.wGetLanguageKit(), fragment.wGetEditorKit());
		setFragment(fragment);
	}
	// called from AbstractLanguageKit.createFragmentModel
	public FragmentModel(ILanguageKit languageKit, IEditorKit editorKit) {
		compoundModel = new CompoundModel(); // TODO NullCompoundModel is not enough

		setLanguageKit(languageKit);
		setEditorKit(editorKit);
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	public ILanguageKit getLanguageKit() {
		return languageKit;
	}
	public void setLanguageKit(ILanguageKit languageKit) {
		this.languageKit = languageKit;
	}

	public IEditorKit getEditorKit() {
		if (editorKit == null)
			editorKit = getLanguageKit().getDefaultEditorKit();
		return editorKit;
	}
	public void setEditorKit(IEditorKit editorKit) {
		this.editorKit = editorKit;// TODO notifyChanged root
	}

	public Fragment getFragment() {
		return fragment;
	}
	public void setFragment(Fragment fragment) {
		this.fragment = fragment;
	}

	public ICompoundModel getCompoundModel() {
		return compoundModel;
	}
	public void setCompoundModel(ICompoundModel compoundModel) {
		this.compoundModel = compoundModel.merge(this.compoundModel, false);
	}
}
