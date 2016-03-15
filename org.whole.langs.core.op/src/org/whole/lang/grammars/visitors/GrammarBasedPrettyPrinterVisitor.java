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
package org.whole.lang.grammars.visitors;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class GrammarBasedPrettyPrinterVisitor extends GrammarBasedUnparserVisitor {
	public GrammarBasedPrettyPrinterVisitor(IEntity model, Appendable appendable, IBindingManager bindingManager) {
		super(model, appendable, bindingManager);
	}
	public GrammarBasedPrettyPrinterVisitor(IEntity model, IBindingManager bindingManager) {
		super(model, bindingManager);
	}

	protected String getAsString(IEntity entity) {
		return DataTypeUtils.getAsPresentationString(entity);
	}
	protected boolean appendModelEntityAsFragment() {
		if (!EntityUtils.isFragment(model))
			return false;

		append(PrettyPrinterOperation.toPrettyPrintString(EntityUtils.getFragmentRoot(model)));
		return true;
	}
}
