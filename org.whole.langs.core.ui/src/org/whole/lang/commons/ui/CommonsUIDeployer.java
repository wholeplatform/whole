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
package org.whole.lang.commons.ui;

import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.commons.ui.visitors.CommonsUIContentAssistVisitor;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.reflect.AbstractLanguageExtensionDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/** 
 * @author Riccardo Solmi
 */
public class CommonsUIDeployer extends AbstractLanguageExtensionDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addEditorKit(CommonsEditorKit.ID);

		platform.addOperationFactory(CommonsLanguageKit.URI,
				ContentAssistOperation.ID, new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new CommonsUIContentAssistVisitor();
			}
		});

	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeEditorKit(CommonsEditorKit.ID);
	}
}