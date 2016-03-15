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
package org.whole.lang.ui.editors;


import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Enrico Persiani
 */
public class MultilineTextCellEditor extends TextCellEditor {
    private static final int defaultStyle = SWT.MULTI;

    public MultilineTextCellEditor() {
		setStyle(defaultStyle);
	}
    public MultilineTextCellEditor(Composite parent) {
    	super(parent, defaultStyle);
    }
	public MultilineTextCellEditor(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void keyReleaseOccured(KeyEvent keyEvent) {
        if (keyEvent.character == '\r') {
        	// threat Ctrl+Enter as edit events
        	if ((keyEvent.stateMask & SWT.CTRL) != 0)
        		return;
        	// while Enter key alone applies edits
        	else if (keyEvent.stateMask == 0)
        		fireApplyEditorValue();
        }
        super.keyReleaseOccured(keyEvent);
	}
}
