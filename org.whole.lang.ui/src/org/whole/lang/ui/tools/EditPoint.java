/**
 * 
 */
package org.whole.lang.ui.tools;

import org.whole.lang.ui.editparts.IEntityPart;

public class EditPoint {
	public IEntityPart focus;
	public int caret;

	public EditPoint() {
	}
	public EditPoint(IEntityPart focus, int caret) {
		this.focus = focus;
		this.caret = caret;
	}
	
	
	public EditPoint caret(int caret) {
		this.caret = caret;
		return this;
	}
	public EditPoint focus(IEntityPart focus) {
		this.focus = focus;
		return this;
	}
}