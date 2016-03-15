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
package org.whole.lang;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.FindDeclarationOperation;
import org.whole.lang.operations.FindDeclarationsOperation;
import org.whole.lang.reflect.AbstractFunctionLibraryDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.IRunnable;

/**
 * @author Enrico Persiani
 */
public class ViewDerivationLibraryDeployer extends AbstractFunctionLibraryDeployer {
	public static final String URI = "whole:org.whole.lang:ViewDerivationLibrary";

	public void deploy(ReflectionFactory platform) {
		putFunctionLibrary(URI);

		putFunctionCode("deriveIndexViewContents", deriveIndexViewContentsIterator());
		putFunctionCode("deriveMapViewContents", deriveMapViewContentsIterator());
	}

	public static IEntityIterator<IEntity> deriveIndexViewContentsIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResult(FindDeclarationsOperation.findDeclarations(selfEntity));
			}
		});
	}
	public static IEntityIterator<IEntity> deriveMapViewContentsIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;
				if (bm.wIsSet("primarySelectedEntity"))
					result = FindDeclarationOperation.findDeclaration(bm.wGet("primarySelectedEntity"));
				bm.setResult(result);
			}
		});
	}
}
