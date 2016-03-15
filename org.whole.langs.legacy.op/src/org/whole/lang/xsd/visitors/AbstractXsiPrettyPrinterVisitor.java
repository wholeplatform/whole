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

import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.templates.ITemplate;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.GenericIdentityVisitor;
import org.whole.lang.xml.codebase.XmlPrettyPrinterBuilderOperation;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractXsiPrettyPrinterVisitor extends GenericIdentityVisitor {
	@Override
	public PrettyPrinterOperation getOperation() {
		return (PrettyPrinterOperation) super.getOperation();
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		if (!EntityUtils.isResolver(entity))
			stagedVisit(entity.wGetAdaptee(false));
		return false;
	}

	@Override
	public void visit(IEntity entity) {
		getXsiModelTemplate(entity).apply(new XmlPrettyPrinterBuilderOperation(
				getOperation().getPrettyPrintWriter()));
	}

	protected abstract ITemplate getXsiModelTemplate(IEntity model);
}
