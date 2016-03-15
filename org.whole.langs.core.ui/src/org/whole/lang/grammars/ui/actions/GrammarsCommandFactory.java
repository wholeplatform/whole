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
package org.whole.lang.grammars.ui.actions;

import org.whole.lang.grammars.factories.GrammarsEntityFactory;
import org.whole.lang.grammars.model.As;
import org.whole.lang.grammars.model.Rule;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.requests.CommandFactory;
import org.whole.lang.ui.requests.IFeatureTransformer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class GrammarsCommandFactory extends CommandFactory {
	private static class SingletonHolder {
		private static final GrammarsCommandFactory instance = new GrammarsCommandFactory();
	}
	public static GrammarsCommandFactory instance() {
		return SingletonHolder.instance;
	}

	private GrammarsCommandFactory() {
//		addOverCompositeConstraints(new Object[][] {
//				{ GrammarsEntityDescriptorEnum.Rule , GrammarsEntityDescriptorEnum.Productions, new Rule2ProductionTransformer(), true }
//		});
	}

	@SuppressWarnings("unused")
	private class Rule2ProductionTransformer implements IFeatureTransformer {
		public IEntity transform(IEntity newFeature) {
			if (newFeature.wGetEntityDescriptor().equals(GrammarsEntityDescriptorEnum.Production))
				return newFeature;

			Rule rule = (Rule) EntityUtils.clone(newFeature);
			String name = "NT";

			if (rule.wGetEntityDescriptor().equals(GrammarsEntityDescriptorEnum.As)) {
				As asRule = (As) rule;
				rule = asRule.getRule();
				name = asRule.getName().getValue();
			}
			GrammarsEntityFactory gf = GrammarsEntityFactory.instance;
			IEntity entity = gf.create(GrammarsEntityDescriptorEnum.Production,
					gf.createNonTerminal(name), rule);
			return entity;
		}
	}
}
