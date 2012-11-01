/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.xml.codebase;

import java.io.PrintWriter;

import org.whole.lang.builders.AbstractBuilderOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrintWriter;
import org.whole.lang.xml.builders.XmlPrettyPrinterBuilder;
import org.whole.lang.xml.reflect.XmlLanguageKit;

/**
 * @author Riccardo Solmi
 */
public class XmlPrettyPrinterBuilderOperation extends AbstractBuilderOperation {
	public static final String ID = "PrettyPrinterBuilder";
	private IPrettyPrintWriter printWriter;

	public XmlPrettyPrinterBuilderOperation(PrintWriter out) {
		this(new PrettyPrintWriter(out));
	}
	public XmlPrettyPrinterBuilderOperation(IPrettyPrintWriter out) {
		this.printWriter = out;
	}
	public String wGetOperationId() {
		return ID;
	}

	protected IBuilder createGenericBuilder() {
		return createGenericBuilderAdapter(XmlLanguageKit.URI, false);
	}

	protected IBuilder createSpecificBuilder(String languageURI) {
		if (languageURI.equals(XmlLanguageKit.URI))
			return new XmlPrettyPrinterBuilder(printWriter);
		return null;
	}
}
