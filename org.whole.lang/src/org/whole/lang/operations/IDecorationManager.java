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
package org.whole.lang.operations;

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public interface IDecorationManager {
	public static enum DecorationKind {
		INFO, WARNING, WARNING_ASSIST, ERROR, ERROR_ASSIST, ASSIST;
		
		public boolean isInfo() {
			return equals(INFO);
		}
		public boolean isWarning() {
			return equals(WARNING) || equals(WARNING_ASSIST);
		}
		public boolean isError() {
			return equals(ERROR) || equals(ERROR_ASSIST);
		}
	}

	public void addInfo(IEntity entity, String message, String location);
	public void addWarning(IEntity entity, String message, String location);
	public void addError(IEntity entity, String message, String location);
	public void addDecoration(DecorationKind kind, IEntity entity, String message, String location);
	public void deleteDecorations(IEntity entity, boolean deep);
}
