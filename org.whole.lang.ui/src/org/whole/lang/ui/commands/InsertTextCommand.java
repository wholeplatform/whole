/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.util.CaretUpdater;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Enrico Persiani
 */
public class InsertTextCommand extends AbstractTextCommand {
	private String data;
	private int length = -1;

	public InsertTextCommand() {
		super(TextCommandTypes.INSERT);
	}

	@Override
	public boolean canExecute() {
		return length > 0;
	}

	public void execute() {
		ITextualEntityPart caretPart = getSourcePart();
		int start = caretPart.getCaretPosition();
		int end = start+length;
		this.initialRange = new Range(start, start);

		String value = DataTypeUtils.getAsPresentationString(entity);
		value = value.substring(0, start) + data + value.substring(start);

		this.finalRange = new Range(start, end);
		setNewValue(DataTypeUtils.getDataTypeParser(entity, DataTypeParsers.PRESENTATION).parse(entity.wGetEntityDescriptor(), value));
		CaretUpdater.createCU(getViewer(), entity, end).sheduleSyncUpdate();
		
		super.execute();
	}

	public void setData(String data) {
		this.data = data;
		length = data.length();
	}
}
