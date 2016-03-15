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
package org.whole.lang.reflect;

import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneable;
import org.whole.lang.resources.FunctionLibraryRegistry;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractFunctionLibraryDeployer extends AbstractLanguageExtensionDeployer {
	protected String libraryUri;

	protected void putFunctionLibrary(String libraryUri) {
		this.libraryUri = libraryUri;
		FunctionLibraryRegistry.instance().getFunctionLibrary(libraryUri, true, null);
	}
	protected void putFunctionCode(String functionName, ICloneable functionCode) {
		String functionUri = libraryUri+"#"+functionName;
		IEntity functionModel = FunctionLibraryRegistry.instance().getFunctionModel(functionUri, false, null);
		if (functionModel != null && functionCode instanceof ISourceable)
			((ISourceable) functionCode).withSourceEntity(functionModel);
		FunctionLibraryRegistry.instance().putFunctionCode(functionUri, functionCode);
	}
}
