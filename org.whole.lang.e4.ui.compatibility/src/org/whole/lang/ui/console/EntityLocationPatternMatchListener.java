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

import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.ui.console.IPatternMatchListener;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.TextConsole;
import org.whole.lang.e4.ui.E4CompatibilityPlugin;

/**
 * @author Enrico Persiani
 */
public class EntityLocationPatternMatchListener implements IPatternMatchListener {
	private static final String LOCATION_PREFIX = "[at ";
	private static final String LOCATION_SUFFIX = "]";

	private static final String LOCATION_REGEXP = "/(?:(?:(?:\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*)|(?:\\d+))/)*(?:(?:\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*)|(?:\\d+))?";

	private final IFile file;
	private final int skipTo;
	private final String lineQualifier;
	private final String regExp;
	private TextConsole console;

	public EntityLocationPatternMatchListener(IFile file, int skipTo) {
		this.file = file;
		this.skipTo = skipTo;
		this.lineQualifier = Pattern.quote(LOCATION_PREFIX);
		this.regExp = lineQualifier + LOCATION_REGEXP + Pattern.quote(LOCATION_SUFFIX);
	}
	
	public void connect(TextConsole console) {
		this.console = console;
	}
	public void disconnect() {
	}

	public int getCompilerFlags() {
		return 0;
	}
	public String getLineQualifier() {
		return lineQualifier;
	}
	public String getPattern() {
		return regExp;
	}
	public void matchFound(PatternMatchEvent event) {
		int prefixLength = LOCATION_PREFIX.length();
		int suffixLength = LOCATION_SUFFIX.length();
		int offset = event.getOffset() + prefixLength;
		if (offset >= skipTo)
			addHyperlink(offset, event.getLength() - prefixLength - suffixLength);
	}

	protected void addHyperlink(int offset, int length) {
		try {
			String location = console.getDocument().get(offset, length);
			EntityLocationHyperlink hyperlink = new EntityLocationHyperlink(file, location);
			console.addHyperlink(hyperlink, offset, length);
		} catch (BadLocationException e) {
			E4CompatibilityPlugin.log(e);
		}
	}
}
