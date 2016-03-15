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
package org.whole.lang.ui.keys;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.tools.EditPoint;
import org.whole.lang.ui.tools.IWholeSelection;
import org.whole.lang.ui.tools.SelectionRange;

/** 
 * @author Enrico Persiani
 */
public class TextualKeyHandler extends DefaultKeyHandler {
	public static final TextualKeyHandler instance = new TextualKeyHandler();
	public static DefaultKeyHandler instance() {
		return instance;
	}

	protected Set<EntityDescriptor<?>> edSet;
	protected Pattern RIGHT_PATTERN = Pattern.compile("(\\A[^\\p{Alnum}])|(\\A[\\p{Alnum}]+)"); // matches always
	protected Pattern LEFT_PATTERN = Pattern.compile("([^\\p{Alnum}]\\z)|([\\p{Alnum}]+\\z)"); // matches always

	public TextualKeyHandler() {
		this.edSet = Collections.emptySet();
	}
	public TextualKeyHandler(EntityDescriptor<?>... eds) {
		this.edSet = new HashSet<>(Arrays.asList(eds));
	}

	protected boolean enableSmartSelection(IEntity e) {
		return edSet.isEmpty() || edSet.contains(e.wGetEntityDescriptor());
	}

	public IWholeSelection calculateDoubleClickSelection(EditPoint editPoint) {
		ITextualEntityPart targetPart = (ITextualEntityPart) editPoint.focus;
		IEntity targetEntity = targetPart.getModelEntity();

		int endPosition = -1, startPosition = -1;
		if (enableSmartSelection(targetEntity)) {
			String text = targetEntity.wStringValue();
			int position = targetPart.getCaretPosition();
			int positions = targetPart.getCaretPositions();
			Matcher matcher;

			if (position == 0) {
				matcher = RIGHT_PATTERN.matcher(text);
				if (matcher.find()) {
					startPosition = 0;
					endPosition = matcher.end();
				}
			} else if (position == positions) {
				matcher = LEFT_PATTERN.matcher(text);
				if (matcher.find()) {
					startPosition = matcher.start();
					endPosition = positions;
				}
			} else {
				if (Character.isLetterOrDigit(text.charAt(position))) {
					if (Character.isLetterOrDigit(text.charAt(position-1))) {
						// XX
						String substring = text.substring(0, position);
						matcher = LEFT_PATTERN.matcher(substring);
						if (matcher.find())
							startPosition = matcher.start();
						matcher = RIGHT_PATTERN.matcher(text.substring(position));
						if (matcher.find())
							endPosition = position+matcher.end();
					} else {
						// .X
						matcher = RIGHT_PATTERN.matcher(text.substring(position));
						if (matcher.find()) {
							startPosition = position+matcher.start();
							endPosition = position+matcher.end();
						}
					}
				} else {
					if (Character.isLetterOrDigit(text.charAt(position-1))) {
						// X.
						matcher = LEFT_PATTERN.matcher(text.substring(0, position));
						if (matcher.find()) {
							startPosition = matcher.start();
							endPosition = position;
						}
					} else {
						// ..
						startPosition = position -1;
						endPosition = position;
					}
				}
			}
		}
		if (endPosition >= 0 && startPosition >= 0)
			return new SelectionRange(editPoint.focus, startPosition, endPosition);
		else
			return super.calculateDoubleClickSelection(editPoint);
	}

	public IWholeSelection calculateTripleClickSelection(EditPoint editPoint) {
		return super.calculateDoubleClickSelection(editPoint);
	}
}
