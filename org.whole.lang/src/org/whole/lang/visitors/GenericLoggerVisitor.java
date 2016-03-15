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

import java.util.logging.Logger;

import org.whole.lang.model.IEntity;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class GenericLoggerVisitor extends GenericIdentityVisitor {
	private static class SingletonHolder {
		private static final Logger logger = Logger.getLogger("org.whole.lang.visitors");
		private static final GenericLoggerVisitor instance = new GenericLoggerVisitor();
	}
	public static final Logger logger() {
		return SingletonHolder.logger;
	}
	public static final GenericLoggerVisitor instance() {
		return SingletonHolder.instance;
	}
	private GenericLoggerVisitor() {
	}
	
    public void visit(IEntity entity) {
    	logger().info(StringUtils.transientId(entity));
    }
}
