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
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.pde.launching.IPDELauncherConstants;
import org.eclipse.pde.ui.launcher.AbstractLauncherTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.whole.lang.WholePlugin;

/**
 * @author Enrico Persiani
 */
public class WholeOperationMainTab extends AbstractLauncherTab implements IPDELauncherConstants {
	protected TargetModelBlock targetModelBlock;
	protected OperationBlock operationBlock;
	protected EnvironmentBlock environmentBlock;
	private Image tabImage;

	public WholeOperationMainTab() {
		targetModelBlock = new TargetModelBlock(this);
		operationBlock = new OperationBlock(this);
		environmentBlock = new EnvironmentBlock(this);
		tabImage = ImageDescriptor.createFromURL(Platform.getBundle("org.whole.product.lw")
				.getEntry("icons/launching/whole_operation.gif")).createImage();
	}

	@Override
	public void dispose() {
		tabImage.dispose();
	}

	public String getName() {
		return "&Operation";
	}

	@Override
	public Image getImage() {
		return tabImage;
	}
	
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.verticalSpacing = 15;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		targetModelBlock.createControl(composite);
		operationBlock.createControl(composite);		
		environmentBlock.createControl(composite);

		setControl(composite);
		Dialog.applyDialogFont(composite);
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			targetModelBlock.initializeFrom(configuration);
			operationBlock.initializeFrom(configuration);		
			environmentBlock.initializeFrom(configuration);
		} catch (CoreException e) {
			WholePlugin.log(e);
		} finally {
		}
		updateLaunchConfigurationDialog();
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		targetModelBlock.performApply(configuration);
		operationBlock.performApply(configuration);		
		environmentBlock.performApply(configuration);
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		targetModelBlock.setDefaults(configuration);
		operationBlock.setDefaults(configuration);		
		environmentBlock.setDefaults(configuration);
	}

	@Override
	public void validateTab() {
		String operationMessage = operationBlock.validate();
		if (operationMessage != null)
			setErrorMessage(operationMessage);
		else
			setErrorMessage(targetModelBlock.validate());
	}
}
