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
package org.whole.lang.models.visitors;

import org.whole.lang.matchers.Matcher;
import org.whole.lang.models.model.IModelsEntity;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.util.ModelInfo;

/**
 * @author Riccardo Solmi
 */
public class ModelsNormalizerVisitor extends ModelsIdentityDefaultVisitor {

	@Override
	public void visit(IModelsEntity entity) {
		Model m = Matcher.findAncestor(ModelsEntityDescriptorEnum.Model, entity);
		if (m != null)
			visit(m);
	}

	@Override
	public void visit(Model entity) {
		ModelInfo modelInfo = new ModelInfo(entity);
		modelInfo.addInheritedFeatures(entity);
		modelInfo.addUndeclaredTypes(entity);
		modelInfo.sortFeatures(entity);
	}
}
