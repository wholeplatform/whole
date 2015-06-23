package org.whole.lang.ui.editpolicies;

import org.eclipse.draw2d.geometry.Dimension;

public class FitToMemoryStrategy implements IConstraintDimensionStrategy {
	private static final IConstraintDimensionStrategy instance = new FitToMemoryStrategy();
	public static IConstraintDimensionStrategy instance() {
		return instance;
	}
	protected FitToMemoryStrategy() {
	}

	@Override
	public Dimension constraintDimensions(Dimension dimension) {
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		long freeMemory = runtime.freeMemory();
		if (freeMemory < dimension.height * dimension.width * 16l) {
			double constrainedArea = freeMemory / 32.0;
			return constraintToArea(dimension, constrainedArea);
		} else
			return dimension;
	}

	protected Dimension constraintToArea(Dimension dimension, double constrainedArea) {
		if (dimension.height > dimension.width)
			dimension.height = Double.valueOf(constrainedArea/dimension.width).intValue();
		else
			dimension.width = Double.valueOf(constrainedArea/dimension.height).intValue();
		return dimension;
	}
}
