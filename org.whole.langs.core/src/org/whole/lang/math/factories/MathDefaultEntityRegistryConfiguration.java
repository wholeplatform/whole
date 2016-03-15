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
package org.whole.lang.math.factories;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.whole.lang.factories.DefaultEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;

/**
 * @author Riccardo Solmi
 */
public class MathDefaultEntityRegistryConfiguration extends DefaultEntityRegistryConfiguration {
	public void apply(IEntityRegistry er) {
		super.apply(er);
		MathEntityFactory ef = MathEntityFactory.instance(er);

		er.put(ef.createAddition(2));
		er.put(ef.createMultiplication(2));
		er.put(ef.createGreatestCommonDivisor(2));
		er.put(ef.createLowestCommonMultiple(2));
		er.put(ef.createMaximum(2));
		er.put(ef.createMinimum(2));
		er.put(ef.createAnd(2));
		er.put(ef.createOr(2));
		er.put(ef.createExclusiveOr(2));
		er.put(ef.createBitwiseAnd(2));
		er.put(ef.createBitwiseOr(2));
		er.put(ef.createBitwiseExclusiveOr(2));
		er.put(ef.createEquals(2));
		er.put(ef.createGreaterThan(2));
		er.put(ef.createLessThan(2));
		er.put(ef.createGreaterOrEqual(2));
		er.put(ef.createLessOrEqual(2));
		er.put(ef.createTuple(2));
		er.put(ef.createEnumeration(2));
		er.put(ef.createUnion(2));
		er.put(ef.createIntersection(2));
		er.put(ef.createSubset(2));
		er.put(ef.createProperSubset(2));
		er.put(ef.createBigInteger(BigInteger.valueOf(0)));
		er.put(ef.createBigDecimal(BigDecimal.valueOf(0)));
	}
}
