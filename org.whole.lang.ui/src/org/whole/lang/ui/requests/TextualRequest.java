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
package org.whole.lang.ui.requests;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.requests.LocationRequest;

public class TextualRequest extends LocationRequest {
	public static final Object REQ_INSERT = "text insert";
	public static final Object REQ_OVERWRITE = "text overwrite";
	public static final Object REQ_BACKSPACE = "text backspace";
	public static final Object REQ_DELETE = "text delete";

	protected String content;

	protected TextualRequest(Object type) {
		setType(type);
	}

	protected TextualRequest(Object type, Point location) {
		this(type);
		setLocation(location);
	}

	protected TextualRequest(Object type, String content) {
		this(type);
		setContent(content);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static TextualRequest createDeleteRequest() {
		return new TextualRequest(TextualRequest.REQ_DELETE);
	}
	public static TextualRequest createBackspaceRequest() {
		return new TextualRequest(TextualRequest.REQ_BACKSPACE);
	}
	public static TextualRequest createInsertRequest(String content) {
		return new TextualRequest(TextualRequest.REQ_INSERT, content);
	}
	public static TextualRequest createOverwriteRequest(String content) {
		return new TextualRequest(TextualRequest.REQ_OVERWRITE, content);
	}
}
