/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.model.IEntity;
import org.whole.lang.templates.ITemplate;
import org.whole.lang.xsd.templates.XsiModelTemplate;

/**
 * @author Enrico Persiani
 */
public class XsiPrettyPrinterVisitor extends AbstractXsiPrettyPrinterVisitor {
	@Override
	protected ITemplate getXsiModelTemplate(IEntity model) {
		IBindingScope args = getBindings();
		if (args.wIsSet("encoding"))
			return new XsiModelTemplate(model, args.wStringValue("encoding"));
		else
			return new XsiModelTemplate(model, Charset.defaultCharset().name());
	}
}
