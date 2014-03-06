/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.dialogs;

import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Enrico Persiani
 */
public class ImportAsModelDialogFactory implements IImportAsModelDialogFactory {
	protected static final String[] STAGES_LABELS = { "Same", "Down", "Up" };
	protected static final EntityDescriptor<?>[] STAGES_EDS = { SameStageFragment, StageDownFragment, StageUpFragment };

	private static ImportAsModelDialogFactory instance = new ImportAsModelDialogFactory();
	public static ImportAsModelDialogFactory instance() {
		return instance;
	}

	protected IPersistenceKit defaultPersistenceKit;
	protected EntityDescriptor<?> defaultStage;

	private ImportAsModelDialogFactory() {
		defaultPersistenceKit = ReflectionFactory.getDefaultPersistenceKit();
		defaultStage = CommonsEntityDescriptorEnum.SameStageFragment;
	}

	public IPersistenceKit getDefaultPersistenceKit() {
		return defaultPersistenceKit;
	}
	public void setDefaultPersistenceKit(IPersistenceKit defaultPersistenceKit) {
		this.defaultPersistenceKit = defaultPersistenceKit;
	}
	public EntityDescriptor<?> getDefaultStage() {
		return defaultStage;
	}
	public void setDefaultStage(EntityDescriptor<?> defaultStage) {
		this.defaultStage = defaultStage;
	}
	public void setDefaults(IPersistenceKit defaultPersistenceKit, EntityDescriptor<?> defaultStage) {
		this.defaultPersistenceKit = defaultPersistenceKit;
		this.defaultStage = defaultStage;
	}

	protected IImportAsModelDialog configureDialog(IImportAsModelDialog dialog) {
		dialog.setPersistenceKit(defaultPersistenceKit);
		dialog.setStage(defaultStage);
		return dialog;
	}

	public IImportAsModelDialog createImportAsModelDialog(Shell shell, String title) {
		return createImportAsModelDialog(shell, title, false);
	}
	public IImportAsModelDialog createImportAsModelDialog(Shell shell, String title, boolean enableForceAdding) {
		return configureDialog(new ImportAsModelDialog(shell, title, enableForceAdding));
	}
	public IImportAsModelDialog createElementListImportAsModelDialog(Shell shell, String title) {
		return createElementListImportAsModelDialog(shell, title, false);
	}
	public IImportAsModelDialog createElementListImportAsModelDialog(Shell shell, String title, boolean enableForceAdding) {
		return configureDialog(new ElementListImportAsModelDialog(shell, title, enableForceAdding));
	}
	public IImportAsModelDialog createImplicitElementImportAsModelDialog(Shell shell, String title) {
		return createImplicitElementImportAsModelDialog(shell, title, false);
	}
	public IImportAsModelDialog createImplicitElementImportAsModelDialog(Shell shell, String title, boolean enableForceAdding) {
		return configureDialog(new ImplicitElementImportAsModelDialog(shell, title, enableForceAdding));
	}

	public static Combo addStageCombo(final IImportAsModelDialog dialog, Composite group, String label) {
		new Label(group, SWT.NONE).setText(label);
		final Combo stageCombo = new Combo(group, SWT.DROP_DOWN | SWT.READ_ONLY);
		stageCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		EntityDescriptor<?> stage = dialog.getStage();
		stageCombo.setItems(STAGES_LABELS);
		for (int i = 0; i < STAGES_EDS.length; i++)
			if (STAGES_EDS[i].equals(stage))
				stageCombo.select(i);

		stageCombo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				dialog.setStage(STAGES_EDS[stageCombo.getSelectionIndex()]);
				dialog.validate();
			}
		});
		return stageCombo;
	}

	public static Combo addPersistenceCombo(final IImportAsModelDialog dialog, Composite group, String label) {
		new Label(group, SWT.NONE).setText(label);
		final Combo persistenceCombo = new Combo(group, SWT.DROP_DOWN | SWT.READ_ONLY);
		persistenceCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		final List<IPersistenceKit> persistenceKits = new ArrayList<IPersistenceKit>(ReflectionFactory.getPersistenceKits());
		Iterator<IPersistenceKit> i = persistenceKits.iterator();
		persistenceCombo.setItems(new String[0]);
		while (i.hasNext())
			persistenceCombo.add(i.next().getDescription());

		persistenceCombo.select(persistenceKits.indexOf(dialog.getPersistenceKit()));
		
		persistenceCombo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				dialog.setPersistenceKit(persistenceKits.get(persistenceCombo.getSelectionIndex()));
				dialog.validate();
			}
		});
		return persistenceCombo;
	}

	public static Button addForceAdditionButton(final IImportAsModelDialog dialog, Composite group, String label) {
		final Button operationTypeButton = new Button(group, SWT.CHECK);
		operationTypeButton.setText(label);
		operationTypeButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		operationTypeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				dialog.setForceAdding(operationTypeButton.getSelection());
				dialog.validate();
			}
		});
		return operationTypeButton;
	}
}
