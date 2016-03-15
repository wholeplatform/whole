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

import java.util.Arrays;

import org.whole.lang.exceptions.WholeRuntimeException;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class MissingVariableException extends WholeRuntimeException {
	private static final long serialVersionUID = 1L;
	protected final String[] variableName;

	public MissingVariableException(String variableName) {
		this(WholeMessages.undefined_variable_reference, null, variableName);
	}

	public MissingVariableException(String message, Throwable cause, String... variableNames) {
		super(message+Arrays.deepToString(variableNames), cause);
		this.variableName = variableNames;
	}

	public String[] getVariableNames() {
		return variableName;
	}
}
