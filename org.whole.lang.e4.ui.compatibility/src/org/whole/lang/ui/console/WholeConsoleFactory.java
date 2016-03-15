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
package org.whole.lang.ui.console;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.MessageConsole;

/**
 * @author Riccardo Solmi
 */
public class WholeConsoleFactory implements IConsoleFactory {
	public static final String WHOLE_CONSOLE_TYPE = "org.whole.lang.ui.WholeConsole";
	private static String title = "Whole console";

	private static MessageConsole messageConsole = null;
	public static MessageConsole getMessageConsole() {
		if (messageConsole == null) {
			messageConsole = new MessageConsole(title, null);
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(
					new IConsole[] { messageConsole });
		}
		return messageConsole;
	}

	private static IOConsole ioConsole = null;
	public static IOConsole getIOConsole() {
		if (ioConsole == null) {
			ioConsole = new IOConsole(title, WHOLE_CONSOLE_TYPE, null);
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(
					new IConsole[] { ioConsole });
		}
		return ioConsole;
	}

	public void openConsole() {
		ConsolePlugin.getDefault().getConsoleManager().showConsoleView(
				getIOConsole());
    }
}
