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
package org.whole.lang.reflect;

import java.io.IOException;

import org.whole.lang.model.EnumType;


/**
 * @author Riccardo Solmi
 */
public class FeatureDescriptorEnum extends EnumType<FeatureDescriptor> {
	private static final long serialVersionUID = 1L;

	transient private ILanguageKit languageKit;
	
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		languageKit = ReflectionFactory.getLanguageKit(in.readUTF(), true, null);
		in.defaultReadObject();
	}
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.writeUTF(languageKit.getURI());
		out.defaultWriteObject();
	}

    public final boolean equals(Object o) {
    	if (!(o instanceof FeatureDescriptorEnum))
        	return false;

    	return getLanguageKit().equals(((FeatureDescriptorEnum) o).getLanguageKit());
    }

	public ILanguageKit getLanguageKit() {
		return languageKit;
	}
	public void setLanguageKit(ILanguageKit languageKit) {
		this.languageKit = languageKit;
	}

    protected void putFeatureDescriptor(int ordinal, String name) {
//		assert (valueOf(name) == null);
		putEnumValue(new FeatureDescriptorImpl(ordinal, name));
	}

	protected void putFeatureDescriptor(int ordinal, String name, String implName) {
//        assert (valueOf(name) == null);
        putEnumValue(new FeatureDescriptorImpl(ordinal, name, implName));
    }

	public FeatureDescriptor addFeatureDescriptor(String name, String implName) {
		FeatureDescriptor fd = valueOf(name);
		if (fd != null)
			return fd;

		int ordinal = size();
		putFeatureDescriptor(ordinal, name, implName);
		return valueOf(ordinal);
	}

	public FeatureDescriptor addFeatureDescriptor(String name) {
		return addFeatureDescriptor(name, name);//FIXME ?
	}
	public void addFeatureDescriptors(String... names) {
		for (String name : names)
			addFeatureDescriptor(name);
	}
}
