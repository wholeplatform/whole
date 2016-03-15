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
package org.whole.lang.pojo.visitors;

import org.whole.lang.artifacts.util.ArtifactsUtils;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.grammars.templates.ModelsArtifactsTemplateManager;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.model.Model;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.pojo.model.IPojoEntity;
import org.whole.lang.pojo.model.Library;
import org.whole.lang.pojo.model.Name;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.util.PojoMappingUtils;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.VisitException;

/**
 * @author Enrico Persiani
 */
public class PojoArtifactsGeneratorVisitor extends PojoIdentityDefaultVisitor {

	public PojoArtifactsGeneratorVisitor(ArtifactsGeneratorOperation operation) {
		setOperation(operation);
	}

	public final IBindingManager env() {
		return ((ArtifactsGeneratorOperation) getOperation()).getArtifactsEnvironment();
	}

	@Override
	public void visit(IPojoEntity entity) {
		Library p = Matcher.findAncestor(PojoEntityDescriptorEnum.Library, entity);
		if (p != null)
			visit(p);
	}

	@Override
	public void visit(Library library) {
		Name libraryName = library.getName();
		if (!EntityUtils.isNotResolver(libraryName))
			throw new VisitException("No library name");

		String modelFileName = DataTypeUtils.getAsPersistenceString(libraryName)+"Model";
		Model model = PojoMappingUtils.getModel(library);

		env().wDefValue("modelFileName", modelFileName);
		env().wDef("modelFileContent", model);

		IEntity ws = ModelsArtifactsTemplateManager.instance().create("ModelFileArtifact");
		Matcher.substitute(ws, env(), false);

		ArtifactsUtils.moveArtifactsIntoWorkspace(ws, env());
	}
}
