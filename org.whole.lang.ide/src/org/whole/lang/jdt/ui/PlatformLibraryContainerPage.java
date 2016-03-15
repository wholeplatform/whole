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
package org.whole.lang.jdt.ui;

import static org.whole.lang.jdt.PlatformLibraryContainerInitializer.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPage;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.osgi.framework.Bundle;
import org.whole.lang.jdt.PlatformLibraryClasspathContainer;

/**
 * @author Enrico Persiani
 */
public class PlatformLibraryContainerPage extends WizardPage implements IClasspathContainerPage {
	protected Image jarImage;
	protected CheckboxTableViewer jarsViewer;
	protected IClasspathEntry containerEntry;

	public PlatformLibraryContainerPage() {
		super("wholePlatformLibraryContainerPage");
		setTitle("Whole Platform Library"); 
		setDescription("This read-only container provides Whole Platform Library Jar Files"); 
		setImageDescriptor(ImageDescriptor.createFromURL(Platform.getBundle("org.whole.lang.ide").getEntry("icons/wizards/whole_classpath_container.png")));
		jarImage = JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_EXTERNAL_ARCHIVE);
	}

	public boolean finish() {
		Set<String> bundles = new HashSet<String>(PlatformLibraryClasspathContainer.BUNDLE_IDS);
		Object[] checkedElements = jarsViewer.getCheckedElements();
		for (Object checkedElement : checkedElements)
			bundles.remove(((Bundle) checkedElement).getSymbolicName());
		containerEntry = JavaCore.newContainerEntry(calculatePath(bundles), false);
		return true;
	}

	public IClasspathEntry getSelection() {
		return containerEntry;
	}

	public void setSelection(IClasspathEntry containerEntry) {
		this.containerEntry = containerEntry == null ?
				JavaCore.newContainerEntry(PlatformLibraryClasspathContainer.getBasePath(), false) :
					containerEntry;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		Table table = new Table(container, SWT.CHECK | SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn column = new TableColumn(table, SWT.NONE);
		column.setText("Bundle ID");
		column = new TableColumn(table, SWT.NONE);
		column.setText("Version");

		TableLayout layout = new TableLayout();
		layout.addColumnData(new ColumnWeightData(60));
		layout.addColumnData(new ColumnWeightData(40));
		table.setLayout(layout);

		//		PluginRegistry.findModel(bundleId)
		container.setLayout(new GridLayout());
		Label label = new Label(container, SWT.NULL);
		label.setText("Included Jar Files:"); 
		jarsViewer = new CheckboxTableViewer(table);
		jarsViewer.setContentProvider(new ArrayContentProvider());
		jarsViewer.setLabelProvider(new ClasspathLabelProvider());
		jarsViewer.setSorter(new ViewerSorter() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				return super.compare(viewer, ((Bundle) e1).getSymbolicName(), ((Bundle) e2).getSymbolicName());
			}
		});
		jarsViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));

		Set<String> excludedBundleIDs = getExclusions(containerEntry.getPath());
		
		List<Bundle> bundles = new ArrayList<Bundle>();
		List<Bundle> checkedElements = new ArrayList<Bundle>();
		for (String bundleId : PlatformLibraryClasspathContainer.BUNDLE_IDS) {
			Bundle bundle = Platform.getBundle(bundleId);
			if (bundle == null)
				continue;
			bundles.add(bundle);
			if (!excludedBundleIDs.contains(bundleId))
				checkedElements.add(bundle);
		}
		jarsViewer.setInput(bundles);
		jarsViewer.setCheckedElements(checkedElements.toArray());

		setControl(container);
		Dialog.applyDialogFont(container);
	}

	private class ClasspathLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return columnIndex == 0 ? jarImage : null;
		}
		public String getColumnText(Object element, int columnIndex) {
			Bundle pluginBase = (Bundle) element;
			return columnIndex == 0 ? pluginBase.getSymbolicName() : pluginBase.getVersion().toString();
		}
	}
}
