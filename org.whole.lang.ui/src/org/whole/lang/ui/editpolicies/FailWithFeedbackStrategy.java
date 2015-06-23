package org.whole.lang.ui.editpolicies;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class FailWithFeedbackStrategy extends FitToMemoryStrategy {
	private static final IConstraintDimensionStrategy instance = new FailWithFeedbackStrategy();
	public static IConstraintDimensionStrategy instance() {
		return instance;
	}
	protected FailWithFeedbackStrategy() {
	}

	@Override
	protected Dimension constraintToArea(Dimension dimension, double constrainedArea) {
		Shell parent = null;
		try {
			parent = Display.getCurrent().getActiveShell();
		} finally{
			MessageDialog.openInformation(parent, "Image rendering error", "Not enough memory to render the selected entity.\nTry to reduce the selected entity size.");
		}
		return null;
	}
}
