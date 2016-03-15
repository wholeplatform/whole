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
package org.whole.lang.queries.factories;

import org.whole.lang.factories.DefaultEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class QueriesDefaultEntityRegistryConfiguration extends DefaultEntityRegistryConfiguration {
	public void apply(IEntityRegistry er) {
		super.apply(er);
		QueriesEntityFactory ef = QueriesEntityFactory.instance(er);
		
		er.put(ef.createNames(1));
		er.put(ef.createExpressions(1));
		er.put(ef.createCartesianProduct(2));
		er.put(ef.createPointwiseProduct(2));
		er.put(ef.createChoose(2));
		er.put(ef.createPath(2));
		er.put(ef.createBlock(2));
		er.put(ef.createSequence(2));
		er.put(ef.createTuple(2));
		er.put(ef.createAnd(2));
		er.put(ef.createOr(2));
		er.put(ef.createCharLiteral('a'));
		er.put(ef.buildSelect().set(QueriesFeatureDescriptorEnum.clearClause, ef.createTemplateNames()).getResult());
	}
}
