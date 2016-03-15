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
package org.whole.product.lw.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.pde.ui.launcher.AbstractLauncherTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractBlock {
	protected AbstractLauncherTab tab;
	protected String blockName;

	public AbstractBlock(String blockName, WholeOperationMainTab tab) {
		this.blockName = blockName;
		this.tab = tab;
	}

	public String validate() {
		return null;
	}

	public void createControl(Composite composite) {
		Group group = new Group(composite, SWT.NONE);
		group.setText(blockName); 
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		group.setLayout(layout);
		createContents(group);
	}
	
	protected AbstractLauncherTab getTab() {
		return tab;
	}

	protected void updateLaunchConfiguration() {
		tab.updateLaunchConfigurationDialog();
	}

	protected abstract void createContents(Composite composite);

	public abstract void initializeFrom(ILaunchConfiguration configuration) throws CoreException;
	public abstract void setDefaults(ILaunchConfigurationWorkingCopy configuration);
	public abstract void performApply(ILaunchConfigurationWorkingCopy configuration);
}
