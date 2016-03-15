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
package org.whole.lang.util;

/**
 * @author Riccardo Solmi
 */
public interface WholeMessages {
	public String null_model = "Null Model object";
	public String null_implementor = "Null Adapter implementor";
	public String no_composite = "This entity is not a composite";
	public String no_data = "This entity is not a data";
	public String no_data_type = "The data entity type is incompatible";
	public String command_illegal_method = "The method is illegal for this command";
	public String illegal_data_conversion = "Illegal data conversion";
	public String undefined_variable_reference = "Undefined variable reference: ";
	public String null_value_argument = "Mandatory argument is without value";
}
