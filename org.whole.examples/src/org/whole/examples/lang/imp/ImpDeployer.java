package org.whole.examples.lang.imp;

import org.whole.examples.lang.imp.reflect.ImpLanguageDeployer;
import org.whole.examples.lang.imp.ui.ImpUIDeployer;
import org.whole.lang.reflect.AbstractSuiteDeployer;
import org.whole.lang.reflect.IDeployer;

public class ImpDeployer extends AbstractSuiteDeployer {
	public int getDeployLevel() {
		return IDeployer.LEVEL_LANGUAGE_EXTENSION;
	}

	@SuppressWarnings("unchecked")
	public ImpDeployer() {
		super(
			ImpLanguageDeployer.class,
			ImpUIDeployer.class
		);
	}
}
