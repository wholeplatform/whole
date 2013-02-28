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
package org.whole.lang.ui.preferences;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.preference.FontFieldEditor;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontRegistry;
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
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.PreferenceConstants;
import org.whole.lang.ui.WholeUIPlugin;

/**
 * @author Riccardo Solmi
 */
public class EditorPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	public final OverlayPreferenceStore.OverlayKey[] fKeys;
	private OverlayPreferenceStore fOverlayStore;

	private final String[][] bgCategoryListModel= new String[][] {
			{ "Selection", PreferenceConstants.SELECTION_COLOR },
			{ "Matching selection", PreferenceConstants.MATCHING_SELECTION_COLOR },
			{ "Host stage", PreferenceConstants.HOST_LANGUAGE_COLOR },
			{ "Template stage", PreferenceConstants.TEMPLATE_LANGUAGE_COLOR },
	};

	private final String[][] fgCategoryListModel= new String[][] {
			{ "Modules", PreferenceConstants.MODULES_COLOR },
			{ "Declarations", PreferenceConstants.DECLARATIONS_COLOR },
			{ "Relations", PreferenceConstants.RELATIONS_COLOR },
			{ "Keywords", PreferenceConstants.KEYWORDS_COLOR },
			{ "Identifiers", PreferenceConstants.IDENTIFIERS_COLOR },
			{ "Literals", PreferenceConstants.LITERALS_COLOR },
			{ "Errors", PreferenceConstants.ERRORS_COLOR },
			{ "Content", PreferenceConstants.CONTENT_COLOR },
			{ "Content Dark", PreferenceConstants.CONTENT_DARK_COLOR },
			{ "Content Light", PreferenceConstants.CONTENT_LIGHT_COLOR },
			{ "Content Lighter", PreferenceConstants.CONTENT_LIGHTER_COLOR },
	};

	private FontFieldEditor font;

	private TableViewer bgCategoryTable;
	private TableColumn bgColumn;
	private ColorSelector bgColorSelector;

	private Combo langCombo;

	private TableViewer fgCategoryTable;
	private TableColumn fgColumn;
	private ColorSelector fgColorSelector;
	private Button fgBoldCheckBox;
	private Button fgItalicCheckBox;

	public EditorPreferencePage() {
		setPreferenceStore(WholeUIPlugin.getDefault().getPreferenceStore());
		setDescription("Colors and Fonts");

		fKeys = createOverlayStoreKeys();
		fOverlayStore = new OverlayPreferenceStore(getPreferenceStore(), fKeys);
		fOverlayStore.load();
		fOverlayStore.start();
	}
	private ColorRegistry colorRegistry;
	private FontRegistry fontRegistry;
	public void init(IWorkbench workbench) {
		colorRegistry = WholeUIPlugin.getDefault().getColorRegistry();
		fontRegistry = WholeUIPlugin.getDefault().getFontRegistry();
	}

	private OverlayPreferenceStore.OverlayKey[] createOverlayStoreKeys() {
		return new OverlayPreferenceStore.OverlayKey[] {
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.FONT), 

				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.SELECTION_COLOR), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.MATCHING_SELECTION_COLOR), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.HOST_LANGUAGE_COLOR), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.TEMPLATE_LANGUAGE_COLOR), 

				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.MODULES_COLOR), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.MODULES_COLOR+PreferenceConstants.BOLD), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.MODULES_COLOR+PreferenceConstants.ITALIC), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.DECLARATIONS_COLOR), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.DECLARATIONS_COLOR+PreferenceConstants.BOLD), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.DECLARATIONS_COLOR+PreferenceConstants.ITALIC), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.RELATIONS_COLOR), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.RELATIONS_COLOR+PreferenceConstants.BOLD), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.RELATIONS_COLOR+PreferenceConstants.ITALIC), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.KEYWORDS_COLOR), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.KEYWORDS_COLOR+PreferenceConstants.BOLD), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.KEYWORDS_COLOR+PreferenceConstants.ITALIC), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.IDENTIFIERS_COLOR), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.IDENTIFIERS_COLOR+PreferenceConstants.BOLD), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.IDENTIFIERS_COLOR+PreferenceConstants.ITALIC), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.LITERALS_COLOR), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.LITERALS_COLOR+PreferenceConstants.BOLD), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.LITERALS_COLOR+PreferenceConstants.ITALIC), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.ERRORS_COLOR), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.ERRORS_COLOR+PreferenceConstants.BOLD), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.ERRORS_COLOR+PreferenceConstants.ITALIC), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.CONTENT_COLOR), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.CONTENT_COLOR+PreferenceConstants.BOLD), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.CONTENT_COLOR+PreferenceConstants.ITALIC), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.CONTENT_DARK_COLOR), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.CONTENT_DARK_COLOR+PreferenceConstants.BOLD), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.CONTENT_DARK_COLOR+PreferenceConstants.ITALIC), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.CONTENT_LIGHT_COLOR), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.CONTENT_LIGHT_COLOR+PreferenceConstants.BOLD), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.CONTENT_LIGHT_COLOR+PreferenceConstants.ITALIC), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, PreferenceConstants.CONTENT_LIGHTER_COLOR), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.CONTENT_LIGHTER_COLOR+PreferenceConstants.BOLD), 
				new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.CONTENT_LIGHTER_COLOR+PreferenceConstants.ITALIC), 
		};
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
		font = new FontFieldEditor(PreferenceConstants.FONT, "Font:", fontComposite);


		Group bgGroup = new Group(topComposite, SWT.NULL);
		bgGroup.setText("Background");
		bgGroup.setLayoutData(new GridData(GridData.FILL_BOTH));

		GridLayout bgLayout = new GridLayout(2, false);
		bgLayout.marginHeight=5;
		bgLayout.marginWidth=10;
		bgGroup.setLayout(bgLayout);

		Label bgLabel = new Label(bgGroup, SWT.LEFT);
		bgLabel.setText("Hilight category:");
    	gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		bgLabel.setLayoutData(gd);
		
		bgCategoryTable = new TableViewer(bgGroup, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
		bgCategoryTable.setContentProvider(new ArrayContentProvider());
		bgCategoryTable.setLabelProvider(new PresentationLabelProvider(bgCategoryTable));
		bgCategoryTable.setSorter(new ViewerSorter());
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
		gd.widthHint = convertWidthInCharsToPixels(25);
		gd.heightHint = 90;//convertHeightInCharsToPixels(5);
		bgCategoryTable.getControl().setLayoutData(gd);
		bgColumn = new TableColumn(bgCategoryTable.getTable(), SWT.LEFT);

		Composite bgStylesComposite= new Composite(bgGroup, SWT.NONE);
		GridLayout bgStylesLayout= new GridLayout(2, false);
		bgStylesLayout.marginHeight= 0;
		bgStylesLayout.marginWidth= 0;
		bgStylesComposite.setLayout(bgStylesLayout);
		bgStylesComposite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));

		label = new Label(bgStylesComposite, SWT.LEFT);
		label.setText("Color:");
		label.setLayoutData(new GridData());
		bgColorSelector = new ColorSelector(bgStylesComposite);


		Group fgGroup= new Group(topComposite, SWT.NULL);
		fgGroup.setText("Foreground");
		fgGroup.setLayoutData(new GridData(GridData.FILL_BOTH));

		GridLayout fgLayout = new GridLayout(2, false);
		fgLayout.marginHeight=5;
		fgLayout.marginWidth=10;
		fgGroup.setLayout(fgLayout);

		Composite langComposite = new Composite(fgGroup, SWT.NONE);
    	gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		langComposite.setLayoutData(gd);
		RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
		rowLayout.center = true;
		langComposite.setLayout(rowLayout);
		
		label = new Label(langComposite, SWT.NONE);
		label.setText("Notation:");
		langCombo = new Combo(langComposite, SWT.DROP_DOWN | SWT.READ_ONLY);

		Label fgLabel = new Label(fgGroup, SWT.NONE);
		fgLabel.setText("Syntax category:");
    	gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		fgLabel.setLayoutData(gd);

		fgCategoryTable = new TableViewer(fgGroup, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
		fgCategoryTable.setContentProvider(new ArrayContentProvider());
		fgCategoryTable.setLabelProvider(new PresentationLabelProvider(fgCategoryTable));
		fgCategoryTable.setSorter(new ViewerSorter());
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
		gd.widthHint = convertWidthInCharsToPixels(25);
		gd.heightHint = 52;//convertHeightInCharsToPixels(4);
		fgCategoryTable.getControl().setLayoutData(gd);
		fgColumn = new TableColumn(fgCategoryTable.getTable(), SWT.LEFT);

		Composite fgStylesComposite= new Composite(fgGroup, SWT.NONE);
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
					PreferenceConverter.setValue(fOverlayStore, key, newRGB);
					colorRegistry.put(key, newRGB);
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
					PreferenceConverter.setValue(fOverlayStore, key, newRGB);
					colorRegistry.put(key, newRGB);
				}
			}
		});
		fgBoldCheckBox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			public void widgetSelected(SelectionEvent e) {
				String key = getSelectedKey(fgCategoryTable);
				fOverlayStore.setValue(key + PreferenceConstants.BOLD, fgBoldCheckBox.getSelection());
			}
		});
		fgItalicCheckBox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			public void widgetSelected(SelectionEvent e) {
				String key = getSelectedKey(fgCategoryTable);
				fOverlayStore.setValue(key + PreferenceConstants.ITALIC, fgItalicCheckBox.getSelection());
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
		RGB rgb = PreferenceConverter.getColor(fOverlayStore, key);
		bgColorSelector.setColorValue(rgb);		
	}
	private void handleFgCategoryListSelection() {	
		String key = getSelectedKey(fgCategoryTable);
		RGB rgb = PreferenceConverter.getColor(fOverlayStore, key);
		fgColorSelector.setColorValue(rgb);		
		fgBoldCheckBox.setSelection(fOverlayStore.getBoolean(key + PreferenceConstants.BOLD));
		fgItalicCheckBox.setSelection(fOverlayStore.getBoolean(key + PreferenceConstants.ITALIC));
	}

	protected void initialize() {
		font.setPage(this);
		font.setPreferenceStore(fOverlayStore);
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


		for (IEditorKit editorKit : ReflectionFactory.getEditorKits())
			langCombo.add(editorKit.getName());
		langCombo.select(0);
	}

	protected void performDefaults() {
		font.loadDefault();

		fOverlayStore.loadDefaults();
		PreferenceConstants.restoreRegistries(fOverlayStore);
		handleBgCategoryListSelection();
		handleFgCategoryListSelection();

		super.performDefaults();
	}

	public boolean performOk() {
		font.store();
		fOverlayStore.propagate();

		return super.performOk();
	}

	public void dispose() {
		if (font != null) {
			font.setPreferenceStore(null);
			font.setPage(null);
		}
		this.setPreferenceStore(null);
		super.dispose();
	}

	protected class PresentationLabelProvider extends LabelProvider {//implements IFontProvider {
		private TableViewer table;
		private Map<Font, Font> fonts = new HashMap<Font, Font>();
		private Map<Color, Image> images = new HashMap<Color, Image>();

		private int imageSize = -1;
		private int usableImageSize = -1;

		private IPropertyChangeListener listener = new IPropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				fireLabelProviderChanged(new LabelProviderChangedEvent(PresentationLabelProvider.this));                
			}            
		};

		private Image emptyImage;        

		public PresentationLabelProvider(TableViewer table) {
			this.table = table;
			hookListeners();
		}

		public void hookListeners() {
			colorRegistry.addListener(listener);        
			fontRegistry.addListener(listener);
		}

		public void dispose() {
			super.dispose();
			colorRegistry.removeListener(listener);
			fontRegistry.removeListener(listener);

			for (Iterator<Image> i = images.values().iterator(); i.hasNext();)
				i.next().dispose();

			images.clear();

			for (Iterator<Font> i = fonts.values().iterator(); i.hasNext();)
				i.next().dispose();

			fonts.clear();

			if (emptyImage != null) {
				emptyImage.dispose();
				emptyImage = null;
			}
		}

		public Font getFont(Object element) {
			int parentHeight = table.getControl().getFont().getFontData()[0].getHeight();

			Display display = table.getControl().getDisplay();

			Font baseFont = fontRegistry.get(PreferenceConstants.FONT);
			Font font = fonts.get(baseFont);
			if (font == null) {
				FontData[] data = baseFont.getFontData();
				for (int i = 0; i < data.length; i++) {
					data[i].setHeight(parentHeight);
				}
				font = new Font(display, data);

				fonts.put(baseFont, font);
			}
			return font;
		}

		public Image getImage(Object element) {
			Color c = colorRegistry.get(((String[])element)[1]);
			Image image = images.get(c);
			if (image == null) {
				Display display = table.getControl().getDisplay();
				ensureImageSize(display);
				//int size = presentationList.getControl().getFont().getFontData()[0].getHeight();
				image = new Image(display, imageSize, imageSize);

				GC gc = new GC(image);
				gc.setBackground(table.getControl().getBackground());
				gc.setForeground(table.getControl().getBackground());
				gc.drawRectangle(0, 0, imageSize - 1, imageSize - 1);

				gc.setForeground(table.getControl().getForeground());
				gc.setBackground(c);

				int offset = (imageSize - usableImageSize) / 2;
				gc.drawRectangle(offset, offset, usableImageSize - offset, usableImageSize - offset);
				gc.fillRectangle(offset + 1, offset + 1, usableImageSize - offset - 1, usableImageSize - offset - 1);		    			    	
				gc.dispose();

				images.put(c, image);
			}
			return image;
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
	}
}
