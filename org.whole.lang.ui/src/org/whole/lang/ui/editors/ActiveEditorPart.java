/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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

import static org.whole.lang.ui.util.UIUtils.getActiveEditor;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPartSite;

/**
 * @author Enrico Persiani
 */
public class ActiveEditorPart extends NullEditorPart {
	public IWorkbenchPartSite getSite() {
		return getActiveEditor().getSite();
	}
	public String getTitle() {
		return getActiveEditor().getTitle();
	}
	public Image getTitleImage() {
		return getActiveEditor().getTitleImage();
	}
	public String getTitleToolTip() {
		return getActiveEditor().getTitleToolTip();
	}
	public IEditorInput getEditorInput() {
		return getActiveEditor().getEditorInput();
	}
	public IEditorSite getEditorSite() {
		return getActiveEditor().getEditorSite();
	}
}
