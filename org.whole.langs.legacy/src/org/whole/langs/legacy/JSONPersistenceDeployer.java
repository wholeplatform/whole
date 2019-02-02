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
package org.whole.langs.legacy;

import org.whole.lang.json.codebase.JSONLDPersistenceKit;
import org.whole.lang.json.codebase.JSONSourcePersistenceKit;
import org.whole.lang.json.reflect.JSONLanguageKit;
import org.whole.lang.json.visitors.JSONPrettyPrinterVisitor;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

public class JSONPersistenceDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addOperationFactory(JSONLanguageKit.URI, PrettyPrinterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new JSONPrettyPrinterVisitor((PrettyPrinterOperation) operation);
			}
		});

		platform.addPersistenceKit("org.whole.lang.json.JSONSourceEditor", JSONSourcePersistenceKit.instance());
		platform.addPersistenceKit("org.whole.lang.json.JSONLDEditor", JSONLDPersistenceKit.instance());
	}
}
