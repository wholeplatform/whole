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
package org.whole.lang.ui.dnd;

import org.eclipse.gef.dnd.SimpleObjectTransfer;

/**
 * @author Enrico Persiani
 */
public class EditPartsTransfer extends SimpleObjectTransfer {
	public static final String PROPERTY_FORCE_DND_COPY = "forceDNDCopy";

	private static class SingletonHolder {
		private static final EditPartsTransfer instance = new EditPartsTransfer();
	}
	public static EditPartsTransfer instance() {
		return SingletonHolder.instance;
	}

	private EditPartsTransfer() {
	}

	private final String TRANSFER_TYPE_NAME = "org.whole.lang.ui.editparts.transfer"+System.currentTimeMillis();

	private int registeredTypeUID;
	private int[] registeredTypes;

	protected int[] getTypeIds() {
		if (registeredTypes == null) {
			registeredTypeUID = registerType(TRANSFER_TYPE_NAME);
			registeredTypes = new int[] { registeredTypeUID };
		}
		return registeredTypes;
	}

	protected String[] getTypeNames() {
		return new String[] { TRANSFER_TYPE_NAME };
	}
}
