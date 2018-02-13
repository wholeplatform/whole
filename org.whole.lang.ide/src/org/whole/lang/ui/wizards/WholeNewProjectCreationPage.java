/**
 * 
 */
package org.whole.lang.ui.wizards;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class WholeNewProjectCreationPage extends WizardNewProjectCreationPage {
	protected Text pluginIdControl;
	protected Text pluginVersionControl;
	protected Text pluginNameControl;
	protected Text pluginProviderControl;
	protected Listener modifyListener;

	public WholeNewProjectCreationPage(String pageName) {
		super(pageName);
		modifyListener = new Listener() {
			public void handleEvent(Event e) {
				setPageComplete(validatePage());     
			}
		};
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		Composite control = (Composite)getControl();
		createPluginDetailsGroup(control);
	}

	protected void createPluginDetailsGroup(Composite container) {
		Group group = new Group(container, SWT.NONE);
		group.setText("Plug-in properties");
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label labelControl;

		labelControl = new Label(group, SWT.LEFT);
		labelControl.setText("Plug-in ID:");
		labelControl.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

		pluginIdControl = new Text(group, SWT.LEFT | SWT.BORDER);
		pluginIdControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		pluginIdControl.addListener(SWT.Modify, modifyListener);

		labelControl = new Label(group, SWT.LEFT);
		labelControl.setText("Plug-in Version:");
		labelControl.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

		pluginVersionControl = new Text(group, SWT.LEFT | SWT.BORDER);
		pluginVersionControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		pluginVersionControl.addListener(SWT.Modify, modifyListener);
		pluginVersionControl.setText("1.0.0");

		labelControl = new Label(group, SWT.LEFT);
		labelControl.setText("Plug-in Name:");
		labelControl.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

		pluginNameControl = new Text(group, SWT.LEFT | SWT.BORDER);
		pluginNameControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		pluginNameControl.addListener(SWT.Modify, modifyListener);

		labelControl = new Label(group, SWT.LEFT);
		labelControl.setText("Plug-in Provider:");
		labelControl.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

		pluginProviderControl = new Text(group, SWT.LEFT | SWT.BORDER);
		pluginProviderControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		pluginProviderControl.addListener(SWT.Modify, modifyListener);
	}

	protected boolean validatePage() {
		boolean isValid = super.validatePage();
		String pluginId = getPluginId();
		if (!pluginId.matches("[_a-zA-Z0-9][\\._a-zA-Z0-9]*")) {
			setErrorMessage("Invalid ID.  Legal characters are A-Z a-z 0-9 . _");
			setMessage(null);
			isValid = false;
		}
		String pluginVersion = getPluginVersion();
		if (!pluginVersion.matches("[0-9]\\.[0-9]\\.[0-9](\\..*)?")) {
			setErrorMessage("Version must be in the format \"major.minor.service\"");
			setMessage(null);
			isValid = false;
		}
		return isValid;
	}

	public String getPluginId() {
		return pluginIdControl != null ? pluginIdControl.getText() : "";
	}

	public String getPluginVersion() {
		return pluginVersionControl != null ? pluginVersionControl.getText() : "";
	}

	public String getPluginName() {
		return pluginNameControl != null ? pluginNameControl.getText() : "";
	}

	public String getPluginProvider() {
		return pluginProviderControl != null ? pluginProviderControl.getText() : "";
	}
}
