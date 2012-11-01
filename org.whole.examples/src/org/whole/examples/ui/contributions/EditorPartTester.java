package org.whole.examples.ui.contributions;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.whole.lang.ui.util.ResourceUtils;

public class EditorPartTester extends PropertyTester {
	public static final String PROPERTY_FILE_EDITOR_INPUT = "fileEditorInput";

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (!PROPERTY_FILE_EDITOR_INPUT.equals(property) || !(receiver instanceof IEditorPart))
			return false;

		IEditorInput editorInput = ((IEditorPart) receiver).getEditorInput();
		return ResourceUtils.getFile(editorInput) != null;
	}
}
