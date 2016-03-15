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
package org.whole.lang.visitors;

import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.IGrammarsEntity;
import org.whole.lang.grammars.model.TargetLanguage;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.grammars.visitors.GrammarsIdentityDefaultVisitor;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.models.model.Model;

/**
 * @author Riccardo Solmi
 */
public class GrammarsJavaModelGeneratorVisitor extends GrammarsIdentityDefaultVisitor {
	@Override
	public void visit(IGrammarsEntity entity) {
		Grammar g = Matcher.findAncestor(GrammarsEntityDescriptorEnum.Grammar, entity);
		if (g != null)
			visit(g);
		
		throw new VisitException();
	}

	@Override
	public void visit(Grammar entity) {
		TargetLanguage targetLanguage = entity.getTargetLanguage();
		if (Matcher.match(GrammarsEntityDescriptorEnum.LanguageDescriptor, targetLanguage)) {
			Model targetModel = GrammarsUtils.deriveModel(entity, true);
			stagedVisit(targetModel);
		}
	}
}
