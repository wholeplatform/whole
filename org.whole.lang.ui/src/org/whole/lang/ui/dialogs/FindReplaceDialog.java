/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.iterators.MatcherIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.controls.ResourceLabelProvider;
import org.whole.lang.ui.controls.ResourceRegistryContentProvider;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.views.WholeGraphicalViewer;
import org.whole.lang.util.EntityUtils;

public class FindReplaceDialog extends TrayDialog {

	private static final int MINIMUM_HEIGHT = 200;
	private static final int FIND_ID = IDialogConstants.CLIENT_ID + 1;
	private static final int REPLACE_ID = IDialogConstants.CLIENT_ID + 2;
	private static final int REPLACE_FIND_ID = IDialogConstants.CLIENT_ID + 3;
	private static final int REPLACE_ALL_ID = IDialogConstants.CLIENT_ID + 4;
	private static final String EMPTY_MESSAGE = "";
	
	private IEntity selectedEntity;
	private IEntity lastSelectedEntity; 
	private WholeGraphicalViewer findViewer;
	private WholeGraphicalViewer replaceViewer;
	private ComboViewer replaceLanguage;
	private ComboViewer findLanguage;
	private ShellListener activationListener;
	private IPartListener partServiceListener;
	private IWorkbenchPart lastWorkbenchPart;
	private MatcherIterator<IEntity> matchIterator;
	private IEntity currentMatchingEntity;
	private ISelectionChangedListener editorSelectionListener;
	private IPartService partService;
	private Label statusLabel;
	private EditPartListener editPartListener;

	public FindReplaceDialog() {
		super((Shell) null);
		setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.RESIZE | SWT.TITLE);
		setBlockOnOpen(false);
		editorSelectionListener = new FindReplaceSelectionChangedListener();
		editPartListener = new FindReplaceEditPartListener();
	}

	@Override
	public void create() {
		super.create();
		Shell shell = getShell();
		shell.setText("Find/Replace...");
		if(activationListener == null)
			activationListener = new FindReplaceActivationListener();
		shell.addShellListener(activationListener);
		// add part service listener
		IWorkbenchPart activePart = getActivePart();
		if (activePart != null) {
			// lazy creation
			if (partServiceListener == null) {
				partServiceListener = new FindReplacePartListener();
			}
			partService = activePart.getSite().getWorkbenchWindow().getPartService();
			partService.addPartListener(partServiceListener);
			GraphicalViewer viewer = (GraphicalViewer) activePart.getAdapter(GraphicalViewer.class);
			viewer.setSelection(StructuredSelection.EMPTY);
		}
	}

	@Override
	public boolean close() {
		// remove all listeners as needed
		Shell shell = getShell();
		if (shell != null && !shell.isDisposed()) {
			if (activationListener != null) {
				shell.removeShellListener(activationListener);
			}
			if (lastWorkbenchPart != null) {
				detachEditorListeners(lastWorkbenchPart);
				lastWorkbenchPart = null;
			}
			// remove part service listener
			if (partService != null) {
				partService.removePartListener(partServiceListener);
				partService = null;
			}
		}
		return super.close();
	}


	@Override
	protected Button createButton(Composite parent, int id,
			String label, boolean defaultButton) {
		return super.createButton(parent, id, label, false);
	}

	@Override
	protected Control createContents(Composite parent) {
		Control control =  super.createContents(parent);
		// set dialog minimum size
		Point dialogMinimum = getShell().getMinimumSize();
		Point dialogCurrent = getButtonBar().computeSize(SWT.DEFAULT, SWT.DEFAULT);
		dialogMinimum.x = dialogCurrent.x;
		dialogMinimum.y = MINIMUM_HEIGHT;
		getShell().setMinimumSize(dialogMinimum);
		return control;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		SashForm container = new SashForm(parent, SWT.HORIZONTAL | SWT.SMOOTH);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		// create left part
		createFindPart(container);
		
		// create right part
		createReplacePart(container);
		
		Composite labelContainer = new Composite (parent, SWT.NONE);
		labelContainer.setLayout(new GridLayout());
		labelContainer.setLayoutData(new GridData(SWT.FILL, SWT.END, true, false));
		statusLabel = new Label(labelContainer, SWT.NONE);
		statusLabel.setLayoutData(new GridData(SWT.FILL, SWT.END, true, false));

		return container;
	}

	private void setStatusMessage(String message) {
		statusLabel.setText(message);
	}
	
	private void createReplacePart(SashForm parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginRight = gridLayout.marginWidth;
		gridLayout.marginLeft = 1;
		gridLayout.marginWidth = 0;
		container.setLayout(gridLayout);
		
		new Label(container, SWT.NONE).setText("Replace with:");

		IResourceRegistry<ILanguageKit> registry = ReflectionFactory.getLanguageKitRegistry();
		replaceLanguage = new ComboViewer(new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY));
		replaceLanguage.setContentProvider(new ResourceRegistryContentProvider());
		replaceLanguage.setLabelProvider(new ResourceLabelProvider<ILanguageKit>(registry));
		replaceLanguage.setInput(registry);
		replaceLanguage.getControl().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		replaceLanguage.setSelection(new StructuredSelection(getInitialReplaceModel().wGetLanguageKit()), true);

		IEntity replacePattern =  EntityUtils.clone(getInitialReplaceModel());
		replaceViewer = new WholeGraphicalViewer(container, replacePattern);
		replaceViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		replaceLanguage.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) replaceLanguage.getSelection();
				ILanguageKit languageKit = (ILanguageKit) selection.getFirstElement();
				replaceViewer.setContents(languageKit.getTemplateManager().createEmpty());
			}
		});
	}

	private void createFindPart(SashForm parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginLeft = gridLayout.marginWidth;
		gridLayout.marginRight = 1;
		gridLayout.marginWidth = 0;
		container.setLayout(gridLayout);

		new Label(container, SWT.NONE).setText("Find:");

		IResourceRegistry<ILanguageKit> registry = ReflectionFactory.getLanguageKitRegistry();
		findLanguage = new ComboViewer(new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY));
		findLanguage.setContentProvider(new ResourceRegistryContentProvider());
		findLanguage.setLabelProvider(new ResourceLabelProvider<ILanguageKit>(registry));
		findLanguage.setInput(registry);
		findLanguage.getControl().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		findLanguage.setSelection(new StructuredSelection(getInitialFindModel().wGetLanguageKit()), true);

		IEntity findPattern = EntityUtils.clone(getInitialFindModel());
		findViewer = new WholeGraphicalViewer(container, findPattern);
		findViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		findLanguage.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) findLanguage.getSelection();
				ILanguageKit languageKit = (ILanguageKit) selection.getFirstElement();
				findViewer.setContents(languageKit.getTemplateManager().createEmpty());
				restartMatching();
			}

		});
	}

	private void restartMatching() {
		matchIterator = null;
		updateEnabledControls();
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, FIND_ID, "Find", true);
		createButton(parent, REPLACE_ID, "Replace", false);
		createButton(parent, REPLACE_FIND_ID, "Replace/Find", false);
		createButton(parent, REPLACE_ALL_ID, "Replace All", false);
		createButton(parent, IDialogConstants.CANCEL_ID, "Close", false);
	}

	protected void buttonPressed(int buttonId) {
		setStatusMessage(EMPTY_MESSAGE);

		if (isValidPart(getActivePart())) {
			// collect active editor root editpart and entity
			IWorkbenchPart editor = getActivePart();
			GraphicalViewer viewer = (GraphicalViewer) editor.getAdapter(GraphicalViewer.class);
			EditPart rootPart = viewer.getContents();
			IEntity rootModel = (IEntity) rootPart.getModel();

			if (buttonId == REPLACE_ID || buttonId == REPLACE_FIND_ID) {
				// replace action
				if(currentMatchingEntity == selectedEntity) {
					try {
						IEntity replacedEntity = selectedEntity;
						// add an editpart listener to update selection on simple replace
						if (buttonId == REPLACE_ID) {
							EditPart replacedPart = (EditPart) viewer.getEditPartRegistry().get(selectedEntity);
							replacedPart.getParent().addEditPartListener(editPartListener);
						}
						currentMatchingEntity = null;
						IEntity replaceEntity = EntityUtils.clone(getCurrentReplacePattern());

						// execute command
						ModelTransactionCommand mtc = new ModelTransactionCommand(replacedEntity, "replace");
						try {
							mtc.begin();
							matchIterator.set(replaceEntity);
							mtc.commit();
							if (mtc.canUndo()) {
								CommandStack commandStack = viewer.getEditDomain().getCommandStack();
								commandStack.execute(mtc);
							}
						} catch (Exception e) {
							mtc.rollback();
							throw e;
						}
					} catch (Exception e) {
						setStatusMessage("Cannot perform replace");
					}
				}
			}
			
			if (buttonId == FIND_ID || buttonId == REPLACE_FIND_ID) {
				// create a new match iteretor if selection changed from last match
				if (matchIterator == null
						|| (currentMatchingEntity != selectedEntity && buttonId == FIND_ID)) {
					currentMatchingEntity = null;
					matchIterator = IteratorFactory.descendantOrSelfMatcherIterator();
					matchIterator.withPattern(getCurrentFindPattern());
					matchIterator.reset(rootModel);
					matchIterator.skipToSame(selectedEntity);
				}
				// get next match
				if (matchIterator.hasNext()) {
					GraphicalEditPart matchPart = (GraphicalEditPart) viewer.getEditPartRegistry().get(matchIterator.next());
					currentMatchingEntity = (IEntity) matchPart.getModel();
					viewer.reveal(matchPart);
					viewer.select(matchPart);
				} else {
					setStatusMessage("Pattern not found");
				}
			}
			
			if (buttonId == REPLACE_ALL_ID) {
				// replace all action
				int numberOfReplaces = 0;
				int numberOfFailures = 0;
				boolean hasMatchedEntity = true;
				if (matchIterator == null || currentMatchingEntity != selectedEntity) {
					matchIterator = IteratorFactory.descendantOrSelfMatcherIterator();
					matchIterator.withPattern(getCurrentFindPattern());
					matchIterator.reset(rootModel);
					matchIterator.skipToSame(selectedEntity);
					if (matchIterator.hasNext()) {
						matchIterator.next();
					} else {
						hasMatchedEntity = false;
					}
				}
				if (hasMatchedEntity) {
					EditPart replacedPart = null;
					ModelTransactionCommand mtc = new ModelTransactionCommand(selectedEntity, "replace all");
					mtc.begin();
					do {
						try {
							// add an editpart listener to update selection
							replacedPart = (EditPart) viewer.getEditPartRegistry().get(selectedEntity);
							replacedPart.getParent().addEditPartListener(editPartListener);
							
							currentMatchingEntity = null;
							IEntity replaceEntity = EntityUtils.clone(getCurrentReplacePattern());

							matchIterator.set(replaceEntity);
							numberOfReplaces++;
						} catch (Exception e) {
							numberOfFailures++;
						}
					} while (matchIterator.hasNext()
							&& ((selectedEntity = matchIterator.next()) != null));

					mtc.commit();
					if (mtc.canUndo()) {
						CommandStack commandStack = viewer.getEditDomain().getCommandStack();
						commandStack.execute(mtc);
						if (replacedPart != null)
							viewer.reveal(replacedPart);
					}
				}
				String message;
				if (numberOfReplaces == 1)
					message = numberOfReplaces + " match replaced";
				else
					message = numberOfReplaces + " matches replaced";
				if (numberOfFailures > 0)
					message += " (with " + numberOfFailures + " failures)";
				setStatusMessage(message);
			}

			// no update on close
			if(buttonId != IDialogConstants.CANCEL_ID)
				updateEnabledControls();
		}
		super.buttonPressed(buttonId);
	}

	private IEntity getCurrentFindPattern() {
		IEntity findViewerRootEntity = (IEntity) findViewer.getContents().getModel();
		return findViewerRootEntity.wGet(0);
	}

	private IEntity getCurrentReplacePattern() {
		IEntity replaceViewerRootEntity = (IEntity) replaceViewer.getContents().getModel();
		return replaceViewerRootEntity.wGet(0);
	}

	public void setSelectedEntity(IEntity selectedEntity) {
		this.selectedEntity = selectedEntity; 
	}

	public IEntity getSelectedEntity() {
		return this.selectedEntity; 
	}

	private IEntity getInitialReplaceModel() {
		return CommonsEntityFactory.instance.createResolver();
	}

	private IEntity getInitialFindModel() {
		if (CommonsEntityDescriptorEnum.RootFragment.equals(getSelectedEntity().wGetEntityDescriptor())) {
			return getLastSelectedEntity();
		} else {
			IEntity entity = getSelectedEntity();
			setLastSelectedEntity(entity);
			return entity;
		}
	}

	private void setLastSelectedEntity(IEntity entity) {
		lastSelectedEntity = entity;
	}

	private IEntity getLastSelectedEntity() {
		if (lastSelectedEntity == null)
			lastSelectedEntity = ReflectionFactory.getLanguageKit(CommonsLanguageKit.URI, true, null).getTemplateManager().createEmpty();
		return lastSelectedEntity;
	}

	private boolean isValidPart(IWorkbenchPart part) {
		GraphicalViewer viewer = (GraphicalViewer) part.getAdapter(GraphicalViewer.class);
		return viewer != null && viewer.getContents() instanceof IEntityPart;
	}

	private void updateEnabledControls() {
		IWorkbenchPart activePart = getActivePart();
		boolean enabled = isValidPart(activePart);
		boolean hasMatch = matchIterator != null && currentMatchingEntity == selectedEntity;
		boolean hasNextMatch = hasMatch ? matchIterator.hasNext(): true;

		getButton(FIND_ID).setEnabled(enabled);
		getButton(REPLACE_ID).setEnabled(enabled && hasMatch);
		getButton(REPLACE_FIND_ID).setEnabled(enabled && hasMatch && hasNextMatch);
		getButton(REPLACE_ALL_ID).setEnabled(enabled);
	}

	@Override
	public void setParentShell(Shell newParentShell) {
		updateEditorListeners();
		super.setParentShell(newParentShell);
	}

	private void updateEditorListeners() {
		// remove old listener if needed
		if(lastWorkbenchPart != null) {
			// remove editor listeners
			detachEditorListeners(lastWorkbenchPart);
			lastWorkbenchPart = null;
		}
		// setup new part listener
		if(isValidPart(getActivePart())) {
			lastWorkbenchPart = getActivePart();
			// add editor listeners
			attachEditorListeners(lastWorkbenchPart);
			if (matchIterator != null) {
				GraphicalViewer viewer = (GraphicalViewer) getActivePart().getAdapter(GraphicalViewer.class);
				matchIterator.reset((IEntity) viewer.getContents().getModel());
			}
		}
	}

	private void detachEditorListeners(IWorkbenchPart lastEditorPart) {
		// remove selection change listener
		IWorkbenchPart editor = lastEditorPart;
		GraphicalViewer viewer = (GraphicalViewer) editor.getAdapter(GraphicalViewer.class);
		viewer.removeSelectionChangedListener(editorSelectionListener);
	}

	private void attachEditorListeners(IWorkbenchPart lastEditorPart) {
		// add selection change listener
		IWorkbenchPart editor = lastEditorPart;
		GraphicalViewer viewer = (GraphicalViewer) editor.getAdapter(GraphicalViewer.class);
		viewer.addSelectionChangedListener(editorSelectionListener);
	}

	private IWorkbenchPart getActivePart() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(window == null)
			return null;
		
		IWorkbenchPage page = window.getActivePage();
		if(page == null)
			return null;
		
		return page.getActivePart();
	}

	private final class FindReplaceEditPartListener implements EditPartListener {
		public void childAdded(EditPart child, int index) {
			// remove from parent
			child.getParent().removeEditPartListener(this);
			child.getViewer().select(child);
		}

		public void partActivated(EditPart editpart) { }

		public void partDeactivated(EditPart editpart) { }

		public void removingChild(EditPart child, int index) { }

		public void selectedStateChanged(EditPart editpart) { }
	}

	private class FindReplaceSelectionChangedListener implements ISelectionChangedListener {
		public void selectionChanged(SelectionChangedEvent event) {
			// clear current match if needed
			if(event.getSelection() instanceof IStructuredSelection) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				IEntity selectedEntity = (IEntity) ((EditPart)selection.getFirstElement()).getModel();
				if(selection.size() > 1 || selectedEntity != currentMatchingEntity)
					currentMatchingEntity = null;
				// update current selection
				setSelectedEntity(selectedEntity);
			}
			updateEnabledControls();
		}
	}

	private class FindReplacePartListener implements IPartListener {
		public void partActivated(IWorkbenchPart part) {
			updateEditorListeners();
			updateEnabledControls();
		}

		public void partBroughtToTop(IWorkbenchPart part) { }
		public void partClosed(IWorkbenchPart part) { }
		public void partDeactivated(IWorkbenchPart part) { }
		public void partOpened(IWorkbenchPart part) { }
	}

	class FindReplaceActivationListener extends ShellAdapter {
		public void shellActivated(ShellEvent e) {
			updateEnabledControls();
		}
		public void shellDeactivated(ShellEvent e) { }
	}
}
