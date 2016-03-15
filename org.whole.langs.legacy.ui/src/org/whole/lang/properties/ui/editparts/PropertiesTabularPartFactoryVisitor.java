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
package org.whole.lang.properties.ui.editparts;

import org.whole.lang.properties.model.Entries;
import org.whole.lang.properties.model.Properties;
import org.whole.lang.properties.model.Property;

/** 
 * @author Riccardo Solmi
 */
public class PropertiesTabularPartFactoryVisitor extends PropertiesTextualPartFactoryVisitor {
	public void visit(Properties entity) {
		part = new PropertiesTabularPart();
	}

	public void visit(Entries entity) {
		part = new EntriesTablePart();
	}

	public void visit(Property entity) {
		part = new PropertyRowPart();
	}
}