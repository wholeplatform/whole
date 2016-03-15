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
package org.whole.lang.e4.ui.compatibility;

import org.eclipse.gef.editparts.ZoomListener;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

/**
 * @author Enrico Persiani
 */
public class ZoomControlContribution extends WorkbenchWindowControlContribution implements IPartListener, FocusListener, SelectionListener, ZoomListener {
	private IWorkbenchPage activePage;
	private ZoomManager zoomManager;
	private Combo combo;

	public ZoomControlContribution() {
	}

	@Override
	protected Control createControl(Composite parent) {
		GridLayout layout = new GridLayout(1, false);
		layout.marginTop = SWT.DEFAULT;
		layout.marginHeight = layout.marginWidth = 0;
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(layout);

		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		layoutData.widthHint = 100;
		combo = new Combo(container, SWT.DROP_DOWN);
		combo.setLayoutData(layoutData);
		combo.addSelectionListener(this);
		combo.addFocusListener(this);

		try {
			activePage = getWorkbenchWindow().getActivePage();
			activePage.addPartListener(this);
			
			setZoomManager((ZoomManager) activePage.getActivePart().getAdapter(ZoomManager.class));
		} catch (Exception e) {
		}

		return container;
	}

	@Override
	protected int computeWidth(Control control) {
		return combo.computeSize(SWT.DEFAULT, SWT.DEFAULT, true).x;
	} 

	@Override
	public void dispose() {
		if (activePage != null)
			activePage.removePartListener(this);
		if (zoomManager != null)
			zoomManager.removeZoomListener(this);
		if (combo != null) {
			combo.removeFocusListener(this);
			combo.removeSelectionListener(this);
		}
	}

	@Override
	public void partActivated(IWorkbenchPart part) {
		setZoomManager((ZoomManager) part.getAdapter(ZoomManager.class));
	}
	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
	}
	@Override
	public void partClosed(IWorkbenchPart part) {
	}
	@Override
	public void partDeactivated(IWorkbenchPart part) {
	}
	@Override
	public void partOpened(IWorkbenchPart part) {
	}

	public void widgetSelected(SelectionEvent event) {
		setZoomAndUpdate(event);
	}
	public void widgetDefaultSelected(SelectionEvent event) {
		setZoomAndUpdate(event);
	}

	@Override
	public void focusGained(FocusEvent event) {
	}
	@Override
	public void focusLost(FocusEvent event) {
		update(false);
	}
	@Override
	public void zoomChanged(double zoom) {
		update(false);
	}

	protected void setZoomAndUpdate(SelectionEvent event) {
		if (zoomManager == null)
			return;
		
		zoomManager.setZoomAsText(combo.getSelectionIndex() >= 0 ? 
				combo.getItem(combo.getSelectionIndex()) : combo.getText());
		
		update(false);
	}
	protected void setZoomManager(ZoomManager zoomManager) {
		if (this.zoomManager == zoomManager)
			return;

		if (this.zoomManager != null)
			this.zoomManager.removeZoomListener(this);

		if ((this.zoomManager = zoomManager) != null)
			this.zoomManager.addZoomListener(this);

		update(true);
	}

	protected void update(boolean repopulate) {
		if (combo.isDisposed())
			return;

		boolean hasUpdateManager = zoomManager != null;
		if (hasUpdateManager) {
			if (repopulate)
				combo.setItems(zoomManager.getZoomLevelsAsText());

			String zoom = zoomManager.getZoomAsText();
			int index = combo.indexOf(zoom);

			combo.setText(zoom);
			if (index != -1)
				combo.select(index);
		} else
			combo.setText("");

		combo.setEnabled(hasUpdateManager);
	}
}
