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
package org.whole.lang.e4.ui.preferences;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.preference.FontFieldEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.whole.lang.ui.PreferenceConstants;
import org.whole.lang.ui.util.IUIConstants;

/**
 * @author Riccardo Solmi
 */
public class EditorPreferencePage extends PreferencePage {
	private static final String[][] bgCategoryListModel= new String[][] {
			{ "Selection", PreferenceConstants.SELECTION_CATEGORY },
			{ "Matching selection", PreferenceConstants.MATCHING_SELECTION_CATEGORY },
			{ "Host stage", PreferenceConstants.HOST_LANGUAGE_CATEGORY },
			{ "Template stage", PreferenceConstants.TEMPLATE_LANGUAGE_CATEGORY },
	};

	private static final String[][] fgCategoryListModel= new String[][] {
			{ "Modules", PreferenceConstants.MODULES_CATEGORY },
			{ "Declarations", PreferenceConstants.DECLARATIONS_CATEGORY },
			{ "Relations", PreferenceConstants.RELATIONS_CATEGORY },
			{ "Keywords", PreferenceConstants.KEYWORDS_CATEGORY },
			{ "Identifiers", PreferenceConstants.IDENTIFIERS_CATEGORY },
			{ "Literals", PreferenceConstants.LITERALS_CATEGORY },
			{ "Errors", PreferenceConstants.ERRORS_CATEGORY },
			{ "Content", PreferenceConstants.CONTENT_CATEGORY },
			{ "Content Dark", PreferenceConstants.CONTENT_DARK_CATEGORY },
			{ "Content Light", PreferenceConstants.CONTENT_LIGHT_CATEGORY },
			{ "Content Lighter", PreferenceConstants.CONTENT_LIGHTER_CATEGORY },
	};

	private PreferenceStoreAdapter store;
	private FontFieldEditor font;

	private TableViewer bgCategoryTable;
	private TableColumn bgColumn;
	private ColorSelector bgColorSelector;

	private TableViewer fgCategoryTable;
	private TableColumn fgColumn;
	private ColorSelector fgColorSelector;
	private Button fgBoldCheckBox;
	private Button fgItalicCheckBox;

	public EditorPreferencePage() {
		setPreferenceStore(store = new PreferenceStoreAdapter(IUIConstants.BUNDLE_ID));
		setTitle("Whole Languages");
		setDescription("Colors and Fonts");
	}

	protected Control createContents(Composite parent) {
		Label label;
		GridData gd;

		Composite topComposite = new Composite(parent, SWT.NONE);
		topComposite.setLayout(new GridLayout(1, false));
		topComposite.setFont(parent.getFont());
    	gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 1;
		topComposite.setLayoutData(gd);

		Composite fontComposite = new Composite(topComposite, SWT.NONE);
		GridLayout fontLayout = new GridLayout(3, false);
		fontLayout.marginHeight=0;
		fontLayout.marginWidth=0;
		fontComposite.setLayout(fontLayout);
		fontComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		font = new FontFieldEditor(PreferenceConstants.MONOSPACE_FONT, "Monospace Font:", fontComposite);

		GridLayout bgLayout = new GridLayout(2, false);
		bgLayout.marginHeight=5;
		bgLayout.marginWidth=10;
		topComposite.setLayout(bgLayout);

		Label bgLabel = new Label(topComposite, SWT.LEFT);
		bgLabel.setText("Hilight category:");
    	gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		bgLabel.setLayoutData(gd);
		
		bgCategoryTable = new TableViewer(topComposite, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
		bgCategoryTable.setContentProvider(new ArrayContentProvider());
		bgCategoryTable.setLabelProvider(new PresentationLabelProvider(bgCategoryTable));
		bgCategoryTable.setComparator(new ViewerComparator());
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
		gd.widthHint = convertWidthInCharsToPixels(25);
		gd.heightHint = 90;//convertHeightInCharsToPixels(5);
		bgCategoryTable.getControl().setLayoutData(gd);
		bgColumn = new TableColumn(bgCategoryTable.getTable(), SWT.LEFT);

		Composite bgStylesComposite= new Composite(topComposite, SWT.NONE);
		GridLayout bgStylesLayout= new GridLayout(2, false);
		bgStylesLayout.marginHeight= 0;
		bgStylesLayout.marginWidth= 0;
		bgStylesComposite.setLayout(bgStylesLayout);
		bgStylesComposite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));

		label = new Label(bgStylesComposite, SWT.LEFT);
		label.setText("Color:");
		label.setLayoutData(new GridData());
		bgColorSelector = new ColorSelector(bgStylesComposite);

		Label fgLabel = new Label(topComposite, SWT.NONE);
		fgLabel.setText("Syntax category:");
    	gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		fgLabel.setLayoutData(gd);

		fgCategoryTable = new TableViewer(topComposite, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
		fgCategoryTable.setContentProvider(new ArrayContentProvider());
		fgCategoryTable.setLabelProvider(new PresentationLabelProvider(fgCategoryTable));
		fgCategoryTable.setComparator(new ViewerComparator());
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
		gd.widthHint = convertWidthInCharsToPixels(25);
		gd.heightHint = 52;//convertHeightInCharsToPixels(4);
		fgCategoryTable.getControl().setLayoutData(gd);
		fgColumn = new TableColumn(fgCategoryTable.getTable(), SWT.LEFT);

		Composite fgStylesComposite= new Composite(topComposite, SWT.NONE);
		GridLayout fgStylesLayout= new GridLayout(2, false);
		fgStylesLayout.marginHeight= 0;
		fgStylesLayout.marginWidth= 0;
		fgStylesComposite.setLayout(fgStylesLayout);
		fgStylesComposite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));

		label = new Label(fgStylesComposite, SWT.LEFT);
		label.setText("Color:");
		label.setLayoutData(new GridData());
		fgColorSelector = new ColorSelector(fgStylesComposite);

		fgBoldCheckBox = new Button(fgStylesComposite, SWT.CHECK);
		fgBoldCheckBox.setText("Bold");
		gd= new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalAlignment= GridData.BEGINNING;
		gd.horizontalSpan= 2;
		fgBoldCheckBox.setLayoutData(gd);

		fgItalicCheckBox = new Button(fgStylesComposite, SWT.CHECK);
		fgItalicCheckBox.setText("Italic");
		gd= new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalAlignment= GridData.BEGINNING;
		gd.horizontalSpan= 2;
		fgItalicCheckBox.setLayoutData(gd);


		bgCategoryTable.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if (!event.getSelection().isEmpty()) {
					handleBgCategoryListSelection();
				}
			}
		});
		bgCategoryTable.getControl().addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				bgColumn.setWidth(bgCategoryTable.getControl().getSize().x - 4);
			}});
		bgColorSelector.addListener(new IPropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				RGB newRGB = (RGB)event.getNewValue();
				String key = getSelectedKey(bgCategoryTable);
				if (key != null && newRGB != null && !newRGB.equals(event.getOldValue())) {
					store.putValue(key, StringConverter.asString(newRGB));
				}
			}
		});


		fgCategoryTable.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if (!event.getSelection().isEmpty()) {
					handleFgCategoryListSelection();
				}
			}
		});
		fgCategoryTable.getControl().addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				fgColumn.setWidth(fgCategoryTable.getControl().getSize().x - 24);
			}});
		fgColorSelector.addListener(new IPropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				RGB newRGB = (RGB)event.getNewValue();
				String key = getSelectedKey(fgCategoryTable);
				if (key != null && newRGB != null && !newRGB.equals(event.getOldValue())) {
					store.putValue(key, StringConverter.asString(newRGB));
				}
			}
		});
		fgBoldCheckBox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			public void widgetSelected(SelectionEvent e) {
				String key = getSelectedKey(fgCategoryTable);
				store.putValue(key + PreferenceConstants.BOLD, Boolean.toString(fgBoldCheckBox.getSelection()));
			}
		});
		fgItalicCheckBox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			public void widgetSelected(SelectionEvent e) {
				String key = getSelectedKey(fgCategoryTable);
				store.putValue(key + PreferenceConstants.ITALIC, Boolean.toString(fgItalicCheckBox.getSelection()));
			}
		});

		initialize();
		return topComposite;
	}

	private String getSelectedKey(TableViewer table) {
		return ((String[])((IStructuredSelection)table.getSelection()).getFirstElement())[1];
	}

	private void handleBgCategoryListSelection() {	
		String key = getSelectedKey(bgCategoryTable);
		RGB rgb = StringConverter.asRGB(store.getString(key));
		bgColorSelector.setColorValue(rgb);		
	}
	private void handleFgCategoryListSelection() {	
		String key = getSelectedKey(fgCategoryTable);
		RGB rgb = StringConverter.asRGB(store.getString(key));
		fgColorSelector.setColorValue(rgb);		
		fgBoldCheckBox.setSelection(store.getBoolean(key + PreferenceConstants.BOLD));
		fgItalicCheckBox.setSelection(store.getBoolean(key + PreferenceConstants.ITALIC));
	}

	protected void initialize() {
		font.setPage(this);
		font.setPreferenceStore(getPreferenceStore());
		font.load();

		bgCategoryTable.setInput(bgCategoryListModel);
		bgCategoryTable.getControl().getDisplay().asyncExec(new Runnable() {
			public void run() {
				if (bgCategoryTable != null && !bgCategoryTable.getControl().isDisposed())
					bgCategoryTable.setSelection(new StructuredSelection(new Object[] {bgCategoryListModel[0]}));
			}
		});

		fgCategoryTable.setInput(fgCategoryListModel);
		fgCategoryTable.getControl().getDisplay().asyncExec(new Runnable() {
			public void run() {
				if (fgCategoryTable != null && !fgCategoryTable.getControl().isDisposed())
					fgCategoryTable.setSelection(new StructuredSelection(new Object[] {fgCategoryListModel[0]}));
			}
		});
	}

	protected void performDefaults() {
		store.resetToDefaults();
		font.load();

		initialize();

		super.performDefaults();
	}

	public boolean performOk() {
		font.store();
		store.applyChanges();

		return super.performOk();
	}

	protected class PresentationLabelProvider extends LabelProvider {//implements IFontProvider {
		private TableViewer table;
		private Map<String, Image> images = new HashMap<String, Image>();

		private int imageSize = -1;
		private int usableImageSize = -1;

		private PreferencesChangeListener listener = new PreferencesChangeListener();

		private Image emptyImage;        

		public PresentationLabelProvider(TableViewer table) {
			this.table = table;

			store.addChangeListener(listener);
			InstanceScope.INSTANCE.getNode(IUIConstants.BUNDLE_ID).addPreferenceChangeListener(listener);
		}

		public void dispose() {
			InstanceScope.INSTANCE.getNode(IUIConstants.BUNDLE_ID).removePreferenceChangeListener(listener);
			store.removeChangeListener(listener);

			for (Image image : images.values())
				image.dispose();
			images.clear();

			if (emptyImage != null) {
				emptyImage.dispose();
				emptyImage = null;
			}

			super.dispose();
		}

		public Image getImage(Object element) {
			String symbolicName = ((String[]) element)[1];
			String color = store.getString(symbolicName);

			Image image = images.get(color);
			if (image == null)
				images.put(color, image = createImage(color));
			return image;
		}

		protected Image createImage(String c) {
			Display display = table.getControl().getDisplay();
			Color color = new Color(display, StringConverter.asRGB(c));
			GC gc = null;
			try {
				ensureImageSize(display);
				//int size = presentationList.getControl().getFont().getFontData()[0].getHeight();
				Image image = new Image(display, imageSize, imageSize);

				gc = new GC(image);
				gc.setBackground(table.getControl().getBackground());
				gc.setForeground(table.getControl().getBackground());
				gc.drawRectangle(0, 0, imageSize - 1, imageSize - 1);
	
				gc.setForeground(table.getControl().getForeground());
				gc.setBackground(color);

				int offset = (imageSize - usableImageSize) / 2;
				gc.drawRectangle(offset, offset, usableImageSize - offset, usableImageSize - offset);
				gc.fillRectangle(offset + 1, offset + 1, usableImageSize - offset - 1, usableImageSize - offset - 1);		    			    	

				return image;
			} finally {
				if (gc != null)
					gc.dispose();
				if (color != null)
					color.dispose();
			}
		}

		private void ensureImageSize(Display display) {
			if (imageSize == -1) {    	        
				imageSize = table.getTable().getItemHeight();    
				usableImageSize = Math.max(1, imageSize - 4);
			}
		}

		public String getText(Object element) {
			return ((String[])element)[0];
		}

		protected class PreferencesChangeListener implements IChangeListener, IEclipsePreferences.IPreferenceChangeListener {
			protected void handleEvent() {
				fireLabelProviderChanged(new LabelProviderChangedEvent(PresentationLabelProvider.this));
			}
			@Override
			public void handleChange(ChangeEvent event) {
				handleEvent();
			}
			@Override
			public void preferenceChange(PreferenceChangeEvent event) {
				handleEvent();
			}
		}
	}
}
