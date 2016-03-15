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
package org.whole.lang.rdb.ui;

import org.eclipse.swt.graphics.Image;

/**
 * @author Riccardo Solmi
 */
public class RDBImages {
	public static final Image SCHEMA = new Image(null, RDBImages.class.getResourceAsStream("images/schema.gif"));
	public static final Image TABLE = new Image(null, RDBImages.class.getResourceAsStream("images/table.gif"));
	public static final Image COLUMN = new Image(null, RDBImages.class.getResourceAsStream("images/column.gif"));	

	public static final Image EMPTY16 = new Image(null, RDBImages.class.getResourceAsStream("images/empty16.gif"));	
	public static final Image PRIMARY_KEY = new Image(null, RDBImages.class.getResourceAsStream("images/ER_PrimaryKey.gif"));	
	public static final Image FOREIGN_KEY = new Image(null, RDBImages.class.getResourceAsStream("images/ER_ForeignKey.gif"));	
}

