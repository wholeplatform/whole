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
package org.whole.lang.ui.commands;

import org.eclipse.gef.EditPartViewer;

/**
 * @author Enrico Persiani
 */
public interface ITextCommand {
	public enum TextCommandTypes {
		UNKNOWN, INSERT, OVERWRITE, DELETE
	}

	public void setViewer(EditPartViewer viewer);
	public EditPartViewer getViewer();

	public boolean sameType(ITextCommand command);
	public void merge(ITextCommand command);

	public void restoreInitialSelection();
	public void restoreFinalSelection();
	
	public void execute();
	public String getLabel();

	public class Range {
		public int start;
		public int end;
		public Range(int start, int end) {
			this.start = start;
			this.end = end;
		}
		public void merge(Range range) {
			if (start == end && range.start == range.end) {
				// the caret can move backward on backspace edits
				if (start > range.start) {
					start = range.start;
					end = range.end;
				}
			} else {
				if (start <= range.start)
					end += range.end - range.start; // expand on the right
				else
					start -= range.end - range.start; // expand on the left
			}
		}
		public String toString() {
			return "["+start+","+end+"]";
		}
	}
}
