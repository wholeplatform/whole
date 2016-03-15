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
package org.whole.lang.java;

import org.eclipse.jdt.core.IJavaProject;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.java.codebase.JavaSourceTemplateFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.AbstractFunctionLibraryDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.IRunnable;

/**
 * @author Riccardo Solmi
 */
public class JavaReflectLibraryDeployer extends AbstractFunctionLibraryDeployer {
	public static final String URI = "whole:org.whole.lang.java:JavaReflectLibrary";

	public void deploy(ReflectionFactory platform) {
		putFunctionLibrary(URI);

		putFunctionCode("compilationUnit", compilationUnitIterator());
	}

	public static IEntityIterator<IEntity> compilationUnitIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				try {
					String className = selfEntity.wStringValue();
					IJavaProject javaProject = (IJavaProject) bm.wGetValue("javaProject");
					bm.setResult(new JavaSourceTemplateFactory(className, javaProject).create());
				} catch (Exception e) {
					bm.setResult(null);
				}
			}
		});
	}
}
