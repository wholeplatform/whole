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
package org.whole.lang.properties.visitors;

import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.properties.model.Comment;
import org.whole.lang.properties.model.Properties;
import org.whole.lang.properties.model.Property;
import org.whole.lang.properties.model.PropertyName;
import org.whole.lang.properties.model.PropertyValue;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class PropertiesPrettyPrinterVisitor extends PropertiesTraverseAllVisitor {
	protected final IPrettyPrintWriter out;
	protected String separator = " ";
	protected boolean newSeparator;

	public PropertiesPrettyPrinterVisitor(PrettyPrinterOperation operation) {
    	out = operation.getPrettyPrintWriter();
	}

	protected void printSeparator() {
		out.printRaw(separator);
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false));
		return false;
	}

	@Override
	public void visit(Properties entity) {
//		try {
//			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//			PropertiesUtils.translate(entity).store(outputStream,
//					EntityUtils.safeGet(entity.getComment(), "").wStringValue());
//			out.print(outputStream.toString("8859_1"));
//		} catch (IOException e) {
//		}
		entity.getDefaults().accept(this);
		entity.getComment().accept(this);
		entity.getEntries().accept(this);
	}
	
	@Override
	public void visit(Comment entity) {
		out.printRaw("# ");
		out.printRaw(entity.wStringValue());
		out.println();
	}

	@Override
	public void visit(Property entity) {
		entity.getName().accept(this);
		out.printRaw(" = ");
		entity.getValue().accept(this);
		out.println();
	}

	@Override
	public void visit(PropertyName entity) {
		out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}

	@Override
	public void visit(PropertyValue entity) {
		out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}
}
