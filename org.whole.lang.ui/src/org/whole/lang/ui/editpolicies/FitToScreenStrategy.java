package org.whole.lang.ui.editpolicies;

import org.eclipse.draw2d.geometry.Dimension;
import org.whole.lang.ui.util.UIUtils;

public class FitToScreenStrategy implements IConstraintDimensionStrategy {
	private static final IConstraintDimensionStrategy instance = new FitToScreenStrategy();
	public static IConstraintDimensionStrategy instance() {
		return instance;
	}
	protected FitToScreenStrategy() {
	}

	@Override
	public Dimension constraintDimensions(Dimension dimension) {
		org.eclipse.swt.graphics.Rectangle monitorBounds = UIUtils.getActiveMonitor().getBounds();
		Dimension maxDimension = new Dimension(monitorBounds.width/3, monitorBounds.height/3);
		if (dimension.getArea() > maxDimension.getArea())
			dimension.intersect(maxDimension);
		return dimension;
	}
}
