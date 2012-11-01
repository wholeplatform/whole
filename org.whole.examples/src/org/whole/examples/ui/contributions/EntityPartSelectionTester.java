package org.whole.examples.ui.contributions;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEntityPart;

public class EntityPartSelectionTester extends PropertyTester {
	public static final String PROPERTY_HAS_LANGUAGE_URI = "hasLanguageURI";

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (args.length != 1 || !(args[0] instanceof String))
			return false;
		String languageURI = (String) args[0];

		Object element;
		if (!PROPERTY_HAS_LANGUAGE_URI.equals(property) ||
				!(receiver instanceof IStructuredSelection) ||
				!((element = ((IStructuredSelection) receiver).getFirstElement()) instanceof IEntityPart))
			return false;

		IEntity model = ((IEntityPart) element).getModelEntity();
		return languageURI.equals(model.wGetLanguageKit().getURI());
	}
}
