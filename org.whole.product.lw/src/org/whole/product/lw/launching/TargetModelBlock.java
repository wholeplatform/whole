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

import static org.whole.product.lw.launching.IWholeOperationLauncherConstants.TARGET_MODEL_PATH;
import static org.whole.product.lw.launching.IWholeOperationLauncherConstants.TARGET_MODEL_PERSISTENCE;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.controls.WholeModelBrowseChooser;
import org.whole.lang.ui.util.UIUtils;

/**
 * @author Enrico Persiani
 */
public class TargetModelBlock extends AbstractBlock {
	WholeModelBrowseChooser browseChooser;

	String modelPath;
	String persistenceKitId;

	public TargetModelBlock(WholeOperationMainTab tab) {
		super("Target Model", tab);
	}

	@Override
	protected void createContents(Composite composite) {
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		int widthHint = UIUtils.getButtonWidthHint(composite);
		browseChooser = new WholeModelBrowseChooser(composite, SWT.NONE, widthHint);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.widthHint = 300;
		browseChooser.setLayoutData(gd);
		browseChooser.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				IFile file = browseChooser.getFile();
				if (file != null)
					modelPath = file.getFullPath().toPortableString();
				IPersistenceKit persistenceKit = browseChooser.getPersistenceKit();
				if (persistenceKit != null)
					persistenceKitId = persistenceKit.getId();
				updateLaunchConfiguration();
			}
		});
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) throws CoreException {
		modelPath = configuration.getAttribute(TARGET_MODEL_PATH, "");
		persistenceKitId = configuration.getAttribute(TARGET_MODEL_PERSISTENCE, "");
		browseChooser.setText(modelPath);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(TARGET_MODEL_PATH, modelPath);
		configuration.setAttribute(TARGET_MODEL_PERSISTENCE, persistenceKitId);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(TARGET_MODEL_PATH, "");
		configuration.setAttribute(TARGET_MODEL_PERSISTENCE, "");
	}

	@Override
	public String validate() {
		if (modelPath.length() == 0)
			return "Choose a target model";

		IPath path = Path.fromPortableString(modelPath);
		if (!ResourcesPlugin.getWorkspace().getRoot().getFile(path).exists())
			return "Missing target model";
		
		if (!ReflectionFactory.hasPersistenceKit(persistenceKitId))
			return "Invalid persistence kit id"+persistenceKitId;

		return null;
	}
}
