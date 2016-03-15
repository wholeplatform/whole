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
package org.whole.lang.tests.visitors;

import org.eclipse.core.resources.IFile;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IPatternMatchListener;
import org.whole.lang.tests.model.TestSuite;
import org.whole.lang.ui.console.EntityLocationPatternMatchListener;
import org.whole.lang.ui.console.WholeConsoleFactory;

/**
 * @author Enrico Persiani
 */
public class TestsIDELearningInterpreterVisitor extends TestsLearningInterpreterVisitor {
	@Override
	public void visit(TestSuite entity) {
		IPatternMatchListener listener = registerAssertionListener();
		super.visit(entity);
		unregisterAssertionListener(listener);
	}
	
	protected IPatternMatchListener registerAssertionListener() {
		IOConsole console = WholeConsoleFactory.getIOConsole();
		int skipTo = console.getDocument().getLength();
		IPatternMatchListener listener = new EntityLocationPatternMatchListener((IFile) getBindings().wGetValue("file"), skipTo);
		console.addPatternMatchListener(listener);
		return listener;
	}

	protected void unregisterAssertionListener(final IPatternMatchListener listener) {
		// ensure all data has been sent to the console
		printWriter().flush();

		// delay listener removal to ensure all events are processed
		IEclipseContext context = (IEclipseContext) getBindings().wGetValue("eclipseContext");
		context.get(UISynchronize.class).syncExec(new Runnable() {
			public void run() {
				Display.getCurrent().timerExec(1000, new Runnable() {
					public void run() {
						IOConsole console = WholeConsoleFactory.getIOConsole();
						console.removePatternMatchListener(listener);
					}
				});
			}
		});
	}
}
