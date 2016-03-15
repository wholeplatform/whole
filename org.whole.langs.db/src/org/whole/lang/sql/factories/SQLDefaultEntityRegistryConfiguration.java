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
package org.whole.lang.sql.factories;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import org.whole.lang.factories.DefaultEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;

/**
 * @author Riccardo Solmi
 */
public class SQLDefaultEntityRegistryConfiguration extends DefaultEntityRegistryConfiguration {
	public void apply(IEntityRegistry er) {
		super.apply(er);
		SQLEntityFactory ef = SQLEntityFactory.instance(er);
		
		er.put(ef.createArrayValue(new int[] {0}));
		er.put(ef.createBinaryValue(new byte[] {0}));
		er.put(ef.createRawValue(new Object()));
		er.put(ef.createDecimalValue(new BigDecimal(0)));
		er.put(ef.createDateValue(new Date(0l)));
		er.put(ef.createTimeValue(new Time(0l)));
		er.put(ef.createTimestampValue(new Timestamp(0l)));
	}
}
