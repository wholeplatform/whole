package org.whole.lang.tests.ui.figures;

import org.eclipse.draw2d.ActionListener;
import org.whole.lang.tests.model.Result;

/**
 * @author Enrico Persiani
 */
public class TestFigure extends TestStepFigure {

	public TestFigure(ActionListener linkListener) {
		super("Test");
		headerFigure.add(resultsFigure = new TestResultsFigure(linkListener));
	}

	public void updateResult(Result expected, Result actual) {
		resultsFigure.update(expected, actual);
	}
}
