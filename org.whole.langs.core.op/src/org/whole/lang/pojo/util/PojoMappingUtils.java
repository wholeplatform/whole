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
package org.whole.lang.pojo.util;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.misc.model.Misc;
import org.whole.lang.models.model.Model;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.pojo.model.Library;
import org.whole.lang.pojo.templates.JavaModelToPojoModelQuery;
import org.whole.lang.pojo.templates.PojoModelToModelsQuery;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class PojoMappingUtils {

	public static String calculateLibraryURI(String libraryName) {
		return AbstractLanguageKit.defaultURI(libraryName);
	}

	public static Library getLibrary(Misc compilationUnits, String libraryName) {
		return getLibrary(compilationUnits, libraryName, calculateLibraryURI(libraryName));
	}
	public static Library getLibrary(Misc compilationUnits, String libraryName, String libraryLanguageURI) {
		return getLibrary(compilationUnits, libraryName, libraryLanguageURI, true);
	}
	public static Library getLibrary(Misc compilationUnits, String libraryName, String libraryLanguageURI, boolean generatePropertyTemplates) {
		IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
		bindings.wDefValue("libraryName", libraryName);
		bindings.wDefValue("libraryLanguageURI", libraryLanguageURI);
		if (generatePropertyTemplates)
			bindings.wDefValue("generatePropertyTemplates", true);
		Library library = getLibrary(compilationUnits, bindings);
		return library;
	}
	public static Library getLibrary(Misc compilationUnits, IBindingManager bindings) {
		PathExpression javaModelToPojoModel = new JavaModelToPojoModelQuery().create();
		Library library = BehaviorUtils.<Library>evaluateFirstResult(javaModelToPojoModel, compilationUnits, bindings);
		Matcher.removeVars(library, true);
		return library;
	}

	public static Model getModel(Library library) {
		IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
		PathExpression pojoModelToModels = new PojoModelToModelsQuery().create();
		Library normalizedLibrary = NormalizerOperation.normalize(EntityUtils.clone(library));
		Model model = BehaviorUtils.<Model>evaluateFirstResult(pojoModelToModels, normalizedLibrary, bindings);
		Matcher.removeVars(model, true);
		return model;
	}
}
