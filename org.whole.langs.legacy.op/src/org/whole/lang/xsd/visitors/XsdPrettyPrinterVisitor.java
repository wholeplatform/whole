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
package org.whole.lang.xsd.visitors;

import java.nio.charset.Charset;

import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.templates.ITemplate;
import org.whole.lang.xsd.model.NamespaceDecl;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.templates.XsdModelTemplate;

/**
 * @author Enrico Persiani
 */
public class XsdPrettyPrinterVisitor extends AbstractXsiPrettyPrinterVisitor {
	@Override
	public void visit(IEntity entity) {
		if (Matcher.match(XsdEntityDescriptorEnum.NamespaceDecl, entity)) {
			NamespaceDecl nsDecl = (NamespaceDecl) entity;
			IPrettyPrintWriter prettyPrintWriter = getOperation().getPrettyPrintWriter();
			prettyPrintWriter.printRaw(nsDecl.getPrefix().getValue());
			prettyPrintWriter.printRaw("=");
			prettyPrintWriter.printRaw(nsDecl.getUri().getValue());
		} else
			super.visit(entity);
	}

	@Override
	protected ITemplate getXsiModelTemplate(IEntity model) {
		IBindingScope args = getBindings();
		if (args.wIsSet("encoding"))
			return new XsdModelTemplate(model, args.wStringValue("encoding"));
		else
			return new XsdModelTemplate(model, Charset.defaultCharset().name());
	}
}
