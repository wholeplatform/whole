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
package org.whole.lang.text.visitors;

import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.text.model.Document;
import org.whole.lang.text.model.IRow;
import org.whole.lang.text.model.Indent;
import org.whole.lang.text.model.Row;
import org.whole.lang.text.model.RowSeparator;
import org.whole.lang.text.model.Text;
import org.whole.lang.text.model.TextSeparator;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class TextPrettyPrinterVisitor extends TextTraverseAllVisitor {
	protected final IPrettyPrintWriter out;
	protected String rowSeparator;
	protected String textSeparator = " ";
	protected boolean newSeparator, nestedDocument, nestedRow;

	public TextPrettyPrinterVisitor(PrettyPrinterOperation operation) {
    	out = operation.getPrettyPrintWriter();
	}

	protected void printSeparator() {
		out.printRaw(textSeparator);
	}
	protected void println() {
	    if (!out.isInlined()) {
	    	if (rowSeparator == null)
	    		out.println();
	    	else
	    		out.printRaw(rowSeparator);
	    }
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false));
		return false;
	}

	public void visit(Indent entity) {
		out.setRelativeIndentation(entity.getValue());
	}

	public void visit(RowSeparator entity) {
		rowSeparator = entity.getValue();
	}

	public void visit(TextSeparator entity) {
		textSeparator = entity.getValue();
		newSeparator = true;
	}

	protected int rowIndex;
	public void visit(Document entity) {
		if (!nestedDocument)
			rowIndex = 0;
		
		boolean oldNestedDocument = nestedDocument;
		nestedDocument = true;

		for (int i=0, size=entity.size(); i < size; i++) {
			IRow row = entity.get(i);
			row.accept(this);
			if (Matcher.match(TextEntityDescriptorEnum.Row, row))
				rowIndex++;
		}

		nestedDocument = oldNestedDocument;
	}

	public void visit(Row entity) {
		if (!nestedRow && rowIndex>0)
			println();

		boolean inlined = out.setInlined(true);
		String oldSeparator = textSeparator;

		boolean oldNestedRow = nestedRow;
		nestedRow = true;

		newSeparator = true;
		for (int i=0, size=entity.size(); i<size; i++) {
			if (newSeparator)
				newSeparator = false;
			else
				printSeparator();
			entity.get(i).accept(this);
		}

		nestedRow = oldNestedRow;

		textSeparator = oldSeparator;
		out.setInlined(inlined);
	}

	public void visit(Text entity) {
		out.printRaw(entity.getValue());
	}
}
