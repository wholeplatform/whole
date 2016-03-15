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
package org.whole.lang.commands;

import java.util.Formatter;

/**
 * @author Riccardo Solmi
 */
public class CompoundCommand extends NullCommand {
	private static final long serialVersionUID = 1L;
	public int executionTime;
	public final ICommand[] commands;

	public CompoundCommand(int executionTime, ICommand[] commands) {
		this.executionTime = executionTime;
		this.commands = commands;
		for (int i=0, length=commands.length; i<length; i++)
			commands[i].setExecutionTime(executionTime);
	}

    public CommandKind getKind() {
    	return CommandKind.COMPOUND;
    }

    public final int getExecutionTime() {
    	return executionTime;
    }
    public void setExecutionTime(int executionTime) {
    	this.executionTime = executionTime;
    }

    public void undo() {
		for (int i=commands.length-1; i>=0; i--)
			commands[i].undo();
	}
	public void redo() {
		for (int i=0, length=commands.length; i<length; i++)
			commands[i].redo();
	}

	public void dispose() {
		for (int i=commands.length-1; i>=0; i--)
			commands[i].dispose();
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		toString(builder);
		return builder.toString();
	}
	public void toString(StringBuilder builder) {
		builder.append("at ");
		new Formatter(builder).format("%8x %8s ", getExecutionTime(), getKind());
		builder.append('[');
		for (int i=0, length=commands.length; i<length; i++) {
			builder.append("\n");
			builder.append(commands[i].toString());
		}
		builder.append("\n]");
	}
}
