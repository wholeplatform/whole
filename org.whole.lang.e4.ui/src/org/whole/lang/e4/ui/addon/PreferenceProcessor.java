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
package org.whole.lang.e4.ui.addon;

import static org.whole.lang.ui.PreferenceConstants.CLASS;
import static org.whole.lang.ui.PreferenceConstants.CONTENT_CATEGORY;
import static org.whole.lang.ui.PreferenceConstants.CONTENT_DARK_CATEGORY;
import static org.whole.lang.ui.PreferenceConstants.CONTENT_LIGHTER_CATEGORY;
import static org.whole.lang.ui.PreferenceConstants.CONTENT_LIGHT_CATEGORY;
import static org.whole.lang.ui.PreferenceConstants.DECLARATIONS_CATEGORY;
import static org.whole.lang.ui.PreferenceConstants.ERRORS_CATEGORY;
import static org.whole.lang.ui.PreferenceConstants.HOST_LANGUAGE_CATEGORY;
import static org.whole.lang.ui.PreferenceConstants.IDENTIFIERS_CATEGORY;
import static org.whole.lang.ui.PreferenceConstants.KEYWORDS_CATEGORY;
import static org.whole.lang.ui.PreferenceConstants.LITERALS_CATEGORY;
import static org.whole.lang.ui.PreferenceConstants.MATCHING_SELECTION_CATEGORY;
import static org.whole.lang.ui.PreferenceConstants.MODULES_CATEGORY;
import static org.whole.lang.ui.PreferenceConstants.MONOSPACE_FONT;
import static org.whole.lang.ui.PreferenceConstants.RELATIONS_CATEGORY;
import static org.whole.lang.ui.PreferenceConstants.SANSERIF_FONT;
import static org.whole.lang.ui.PreferenceConstants.SELECTION_CATEGORY;
import static org.whole.lang.ui.PreferenceConstants.SERIF_FONT;
import static org.whole.lang.ui.PreferenceConstants.SIZE;
import static org.whole.lang.ui.PreferenceConstants.STYLE;
import static org.whole.lang.ui.PreferenceConstants.TEMPLATE_LANGUAGE_CATEGORY;
import static org.whole.lang.ui.util.UIUtils.createColor;
import static org.whole.lang.ui.util.UIUtils.createFont;
import static org.whole.lang.ui.util.UIUtils.createStyledFont;
import static org.whole.lang.ui.util.UIUtils.replaceResource;
import static org.whole.lang.ui.util.UIUtils.scaleFont;

import java.net.URL;

import javax.inject.Inject;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.ui.PreferenceConstants.FontClass;
import org.whole.lang.ui.PreferenceConstants.FontSize;
import org.whole.lang.ui.PreferenceConstants.FontStyle;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.util.IUIConstants;
import org.whole.lang.ui.util.UIUtils;

/**
 * @author Enrico Persiani
 */
public class PreferenceProcessor {
	public static final float OPEN_SYMBOL_RATIO = 12f/11f;

	@Inject
	protected IEventBroker eventBroker;
	
	@Inject
	protected UISynchronize uiSynchronize;

	@Execute
	public void execute() {
		final String bundleId = IUIConstants.BUNDLE_ID;
		final String[] fontNames = new String[] {
				"OpenSans-Regular", "OpenSans-Italic", "OpenSans-Bold", "OpenSans-BoldItalic",
				"Cousine-Regular", "Cousine-Italic", "Cousine-Bold", "Cousine-BoldItalic",
				"Tinos-Regular", "Tinos-Italic", "Tinos-Bold", "Tinos-BoldItalic",
				"OpenSymbol"
		};

		try {
			for (String fontName : fontNames) {
				URL url = Platform.getBundle(bundleId).getEntry("/fonts/"+fontName+".ttf");
				IPath fontPath = new Path(FileLocator.toFileURL(url).getPath());
				if (!Display.getCurrent().loadFont(fontPath.toOSString()))
					throw new IllegalArgumentException("Display.loadFont(...) failed on "+fontName);
				}
		} catch (Exception e) {
			throw new IllegalStateException("Unable to load font. ", e);
		}

		initializeDefaultValues(bundleId);

		FigureConstants.monospaceFontRegular = createFont(bundleId, MONOSPACE_FONT);
		FigureConstants.monospaceFontSmall = scaleFont(FigureConstants.monospaceFontRegular, FontSize.Small);
		FigureConstants.monospaceFontMedium = scaleFont(FigureConstants.monospaceFontRegular, FontSize.Medium);
		FigureConstants.monospaceFontLarge = scaleFont(FigureConstants.monospaceFontRegular, FontSize.Large);

		FigureConstants.sanserifFontRegular = createFont(bundleId, SANSERIF_FONT);
		FigureConstants.sanserifFontSmall = scaleFont(FigureConstants.sanserifFontRegular, FontSize.Small);
		FigureConstants.sanserifFontMedium = scaleFont(FigureConstants.sanserifFontRegular, FontSize.Medium);
		FigureConstants.sanserifFontLarge = scaleFont(FigureConstants.sanserifFontRegular, FontSize.Large);

		FigureConstants.serifFontRegular = createFont(bundleId, SERIF_FONT);
		FigureConstants.serifFontSmall = scaleFont(FigureConstants.serifFontRegular, FontSize.Small);
		FigureConstants.serifFontMedium = scaleFont(FigureConstants.serifFontRegular, FontSize.Medium);
		FigureConstants.serifFontLarge = scaleFont(FigureConstants.serifFontRegular, FontSize.Large);

		int height = Math.round(FigureConstants.monospaceFontRegular.getFontData()[0].getHeight()*OPEN_SYMBOL_RATIO);
		FigureConstants.symbolFontRegular = createFont(FontDescriptor.createFrom("OpenSymbol", height, SWT.NONE));
		FigureConstants.symbolFontSmall = scaleFont(FigureConstants.symbolFontRegular, FontSize.Small);
		FigureConstants.symbolFontMedium = scaleFont(FigureConstants.symbolFontRegular, FontSize.Medium);
		FigureConstants.symbolFontLarge = scaleFont(FigureConstants.symbolFontRegular, FontSize.Large);

		FigureConstants.selectionColor = createColor(bundleId, SELECTION_CATEGORY);
		FigureConstants.matchingSelectionColor = createColor(bundleId, MATCHING_SELECTION_CATEGORY);
		FigureConstants.hostLanguageColor = createColor(bundleId, HOST_LANGUAGE_CATEGORY);
		FigureConstants.templateLanguageColor = createColor(bundleId, TEMPLATE_LANGUAGE_CATEGORY);

		FigureConstants.modulesColor = createColor(bundleId, MODULES_CATEGORY);
		FigureConstants.modulesFont = createStyledFont(bundleId, MODULES_CATEGORY);
		FigureConstants.declarationsColor = createColor(bundleId, DECLARATIONS_CATEGORY);
		FigureConstants.declarationsFont = createStyledFont(bundleId, DECLARATIONS_CATEGORY);
		FigureConstants.relationsColor = createColor(bundleId, RELATIONS_CATEGORY);
		FigureConstants.relationsFont = createStyledFont(bundleId, RELATIONS_CATEGORY);
		FigureConstants.keywordsColor = createColor(bundleId, KEYWORDS_CATEGORY);
		FigureConstants.keywordsFont = createStyledFont(bundleId, KEYWORDS_CATEGORY);
		FigureConstants.identifiersColor = createColor(bundleId, IDENTIFIERS_CATEGORY);
		FigureConstants.identifiersFont = createStyledFont(bundleId, IDENTIFIERS_CATEGORY);
		FigureConstants.literalsColor = createColor(bundleId, LITERALS_CATEGORY);
		FigureConstants.literalsFont = createStyledFont(bundleId, LITERALS_CATEGORY);
		FigureConstants.errorsColor = createColor(bundleId, ERRORS_CATEGORY);
		FigureConstants.errorsFont = createStyledFont(bundleId, ERRORS_CATEGORY);
		FigureConstants.contentColor = createColor(bundleId, CONTENT_CATEGORY);
		FigureConstants.contentFont = createStyledFont(bundleId, CONTENT_CATEGORY);
		FigureConstants.contentDarkColor = createColor(bundleId, CONTENT_DARK_CATEGORY);
		FigureConstants.contentDarkFont = createStyledFont(bundleId, CONTENT_DARK_CATEGORY);
		FigureConstants.contentLightColor = createColor(bundleId, CONTENT_LIGHT_CATEGORY);
		FigureConstants.contentLightFont = createStyledFont(bundleId, CONTENT_LIGHT_CATEGORY);
		FigureConstants.contentLighterColor = createColor(bundleId, CONTENT_LIGHTER_CATEGORY);
		FigureConstants.contentLighterFont = createStyledFont(bundleId, CONTENT_LIGHTER_CATEGORY);

		InstanceScope.INSTANCE.getNode(bundleId).addPreferenceChangeListener(new IEclipsePreferences.IPreferenceChangeListener() {
			public void preferenceChange(PreferenceChangeEvent event) {
				final String prop = event.getKey();

				// ensure execution in UI thread
				uiSynchronize.asyncExec(new Runnable() {
					@Override
					public void run() {
						if (prop.equals(MONOSPACE_FONT)) {
							FigureConstants.monospaceFontRegular = replaceResource(FigureConstants.monospaceFontRegular, createFont(bundleId, MONOSPACE_FONT));
							FigureConstants.monospaceFontSmall = replaceResource(FigureConstants.monospaceFontSmall, scaleFont(FigureConstants.monospaceFontRegular, FontSize.Small));
							FigureConstants.monospaceFontMedium = replaceResource(FigureConstants.monospaceFontMedium, scaleFont(FigureConstants.monospaceFontRegular, FontSize.Medium));
							FigureConstants.monospaceFontLarge = replaceResource(FigureConstants.monospaceFontLarge, scaleFont(FigureConstants.monospaceFontRegular, FontSize.Large));

							int height = Math.round(FigureConstants.monospaceFontRegular.getFontData()[0].getHeight()*OPEN_SYMBOL_RATIO);
							FigureConstants.symbolFontRegular = replaceResource(FigureConstants.symbolFontRegular, createFont(FontDescriptor.createFrom("OpenSymbol", height, SWT.NONE)));
							FigureConstants.symbolFontSmall = replaceResource(FigureConstants.symbolFontSmall, scaleFont(FigureConstants.symbolFontRegular, FontSize.Small));
							FigureConstants.symbolFontMedium = replaceResource(FigureConstants.symbolFontMedium, scaleFont(FigureConstants.symbolFontRegular, FontSize.Medium));
							FigureConstants.symbolFontLarge = replaceResource(FigureConstants.symbolFontLarge, scaleFont(FigureConstants.symbolFontRegular, FontSize.Large));

						} else if (prop.equals(SANSERIF_FONT)) {
							FigureConstants.sanserifFontRegular = replaceResource(FigureConstants.sanserifFontRegular, createFont(bundleId, SANSERIF_FONT));
							FigureConstants.sanserifFontSmall = replaceResource(FigureConstants.sanserifFontSmall, scaleFont(FigureConstants.sanserifFontRegular, FontSize.Small));
							FigureConstants.sanserifFontMedium = replaceResource(FigureConstants.sanserifFontMedium, scaleFont(FigureConstants.sanserifFontRegular, FontSize.Medium));
							FigureConstants.sanserifFontLarge = replaceResource(FigureConstants.sanserifFontLarge, scaleFont(FigureConstants.sanserifFontRegular, FontSize.Large));

						} else if (prop.equals(SERIF_FONT)) {
							FigureConstants.serifFontRegular = replaceResource(FigureConstants.serifFontRegular, createFont(bundleId, SERIF_FONT));
							FigureConstants.serifFontSmall = replaceResource(FigureConstants.serifFontSmall, scaleFont(FigureConstants.serifFontRegular, FontSize.Small));
							FigureConstants.serifFontMedium = replaceResource(FigureConstants.serifFontMedium, scaleFont(FigureConstants.serifFontRegular, FontSize.Medium));
							FigureConstants.serifFontLarge = replaceResource(FigureConstants.serifFontLarge, scaleFont(FigureConstants.serifFontRegular, FontSize.Large));

						} else if (prop.equals(SELECTION_CATEGORY))
							FigureConstants.selectionColor = replaceResource(FigureConstants.selectionColor, createColor(bundleId, SELECTION_CATEGORY));
						else if (prop.equals(MATCHING_SELECTION_CATEGORY))
							FigureConstants.matchingSelectionColor = replaceResource(FigureConstants.matchingSelectionColor, createColor(bundleId, MATCHING_SELECTION_CATEGORY));
						else if (prop.equals(HOST_LANGUAGE_CATEGORY))
							FigureConstants.hostLanguageColor = replaceResource(FigureConstants.hostLanguageColor, createColor(bundleId, HOST_LANGUAGE_CATEGORY));
						else if (prop.equals(TEMPLATE_LANGUAGE_CATEGORY))
							FigureConstants.templateLanguageColor = replaceResource(FigureConstants.templateLanguageColor, createColor(bundleId, TEMPLATE_LANGUAGE_CATEGORY));
	
						else if (prop.equals(MODULES_CATEGORY))
							FigureConstants.modulesColor = replaceResource(FigureConstants.modulesColor, createColor(bundleId, MODULES_CATEGORY));
						else if (prop.startsWith(MODULES_CATEGORY))
							FigureConstants.modulesFont = replaceResource(FigureConstants.modulesFont, createStyledFont(bundleId, MODULES_CATEGORY));
						
						else if (prop.equals(DECLARATIONS_CATEGORY))
							FigureConstants.declarationsColor = replaceResource(FigureConstants.declarationsColor, createColor(bundleId, DECLARATIONS_CATEGORY));
						else if (prop.startsWith(DECLARATIONS_CATEGORY))
							FigureConstants.declarationsFont = replaceResource(FigureConstants.declarationsFont, createStyledFont(bundleId, DECLARATIONS_CATEGORY));
						
						else if (prop.equals(RELATIONS_CATEGORY))
							FigureConstants.relationsColor = replaceResource(FigureConstants.relationsColor, createColor(bundleId, RELATIONS_CATEGORY));
						else if (prop.startsWith(RELATIONS_CATEGORY))
							FigureConstants.relationsFont = replaceResource(FigureConstants.relationsFont, createStyledFont(bundleId, RELATIONS_CATEGORY));
						
						else if (prop.equals(KEYWORDS_CATEGORY))
							FigureConstants.keywordsColor = replaceResource(FigureConstants.keywordsColor, createColor(bundleId, KEYWORDS_CATEGORY));
						else if (prop.startsWith(KEYWORDS_CATEGORY))
							FigureConstants.keywordsFont = replaceResource(FigureConstants.keywordsFont, createStyledFont(bundleId, KEYWORDS_CATEGORY));
						
						else if (prop.equals(IDENTIFIERS_CATEGORY))
							FigureConstants.identifiersColor = replaceResource(FigureConstants.identifiersColor, createColor(bundleId, IDENTIFIERS_CATEGORY));
						else if (prop.startsWith(IDENTIFIERS_CATEGORY))
							FigureConstants.identifiersFont = replaceResource(FigureConstants.identifiersFont, createStyledFont(bundleId, IDENTIFIERS_CATEGORY));
						
						else if (prop.equals(LITERALS_CATEGORY))
							FigureConstants.literalsColor = replaceResource(FigureConstants.literalsColor, createColor(bundleId, LITERALS_CATEGORY));
						else if (prop.startsWith(LITERALS_CATEGORY))
							FigureConstants.literalsFont = replaceResource(FigureConstants.literalsFont, createStyledFont(bundleId, LITERALS_CATEGORY));
						
						else if (prop.equals(ERRORS_CATEGORY))
							FigureConstants.errorsColor = replaceResource(FigureConstants.errorsColor, createColor(bundleId, ERRORS_CATEGORY));
						else if (prop.startsWith(ERRORS_CATEGORY))
							FigureConstants.errorsFont = replaceResource(FigureConstants.errorsFont, createStyledFont(bundleId, ERRORS_CATEGORY));
						
						else if (prop.equals(CONTENT_CATEGORY))
							FigureConstants.contentColor = replaceResource(FigureConstants.contentColor, createColor(bundleId, CONTENT_CATEGORY));
						else if (prop.startsWith(CONTENT_CATEGORY))
							FigureConstants.contentFont = replaceResource(FigureConstants.contentFont, createStyledFont(bundleId, CONTENT_CATEGORY));
						
						else if (prop.equals(CONTENT_DARK_CATEGORY))
							FigureConstants.contentDarkColor = replaceResource(FigureConstants.contentDarkColor, createColor(bundleId, CONTENT_DARK_CATEGORY));
						else if (prop.startsWith(CONTENT_DARK_CATEGORY))
							FigureConstants.contentDarkFont = replaceResource(FigureConstants.contentDarkFont, createStyledFont(bundleId, CONTENT_DARK_CATEGORY));

						else if (prop.equals(CONTENT_LIGHT_CATEGORY))
							FigureConstants.contentLightColor = replaceResource(FigureConstants.contentLightColor, createColor(bundleId, CONTENT_LIGHT_CATEGORY));
						else if (prop.startsWith(CONTENT_LIGHT_CATEGORY))
							FigureConstants.contentLightFont = replaceResource(FigureConstants.contentLightFont, createStyledFont(bundleId, CONTENT_LIGHT_CATEGORY));
						
						else if (prop.equals(CONTENT_LIGHTER_CATEGORY))
							FigureConstants.contentLighterColor = replaceResource(FigureConstants.contentLighterColor, createColor(bundleId, CONTENT_LIGHTER_CATEGORY));
						else if (prop.startsWith(CONTENT_LIGHTER_CATEGORY))
							FigureConstants.contentLighterFont = replaceResource(FigureConstants.contentLighterFont, createStyledFont(bundleId, CONTENT_LIGHTER_CATEGORY));

						if (prop.equals(MONOSPACE_FONT) || prop.equals(SANSERIF_FONT) || prop.equals(SERIF_FONT)) {
							FigureConstants.modulesFont = replaceResource(FigureConstants.modulesFont, createStyledFont(bundleId, MODULES_CATEGORY));
							FigureConstants.declarationsFont = replaceResource(FigureConstants.declarationsFont, createStyledFont(bundleId, DECLARATIONS_CATEGORY));
							FigureConstants.relationsFont = replaceResource(FigureConstants.relationsFont, createStyledFont(bundleId, RELATIONS_CATEGORY));
							FigureConstants.keywordsFont = replaceResource(FigureConstants.keywordsFont, createStyledFont(bundleId, KEYWORDS_CATEGORY));
							FigureConstants.identifiersFont = replaceResource(FigureConstants.identifiersFont, createStyledFont(bundleId, IDENTIFIERS_CATEGORY));
							FigureConstants.literalsFont = replaceResource(FigureConstants.literalsFont, createStyledFont(bundleId, LITERALS_CATEGORY));
							FigureConstants.errorsFont = replaceResource(FigureConstants.errorsFont, createStyledFont(bundleId, ERRORS_CATEGORY));
							FigureConstants.contentFont = replaceResource(FigureConstants.contentFont, createStyledFont(bundleId, CONTENT_CATEGORY));
							FigureConstants.contentDarkFont = replaceResource(FigureConstants.contentDarkFont, createStyledFont(bundleId, CONTENT_DARK_CATEGORY));
							FigureConstants.contentLightFont = replaceResource(FigureConstants.contentLightFont, createStyledFont(bundleId, CONTENT_LIGHT_CATEGORY));
							FigureConstants.contentLighterFont = replaceResource(FigureConstants.contentLighterFont, createStyledFont(bundleId, CONTENT_LIGHTER_CATEGORY));
						}

						eventBroker.post(IE4UIConstants.TOPIC_REBUILD_VIEWER, null);
						eventBroker.post(IE4UIConstants.TOPIC_REFRESH_VIEWER, null);
					}
				});
			}
		});
	}

	public static void initializeDefaultValues(String bundleId) {
		IEclipsePreferences preferences = DefaultScope.INSTANCE.getNode(bundleId);

		boolean IS_WIN = "win32".equals(SWT.getPlatform());
		int height = IS_WIN ? 9 : 11;

		preferences.put(MONOSPACE_FONT, PreferenceConverter.getStoredRepresentation(createFont(FontDescriptor.createFrom("Cousine", height, SWT.NONE)).getFontData()));
		preferences.put(SANSERIF_FONT, PreferenceConverter.getStoredRepresentation(createFont(FontDescriptor.createFrom("Open Sans", height, SWT.NONE)).getFontData()));
		preferences.put(SERIF_FONT, PreferenceConverter.getStoredRepresentation(createFont(FontDescriptor.createFrom("Tinos", height, SWT.NONE)).getFontData()));

		RGB lightGreen = new RGB(225, 235, 224);
		preferences.put(SELECTION_CATEGORY, StringConverter.asString(lightGreen));
		preferences.put(MATCHING_SELECTION_CATEGORY, StringConverter.asString(UIUtils.darker(lightGreen)));
		preferences.put(HOST_LANGUAGE_CATEGORY, StringConverter.asString(new RGB(255, 255, 255)));
		preferences.put(TEMPLATE_LANGUAGE_CATEGORY, StringConverter.asString(new RGB(238, 232, 213)));

		preferences.put(MODULES_CATEGORY, StringConverter.asString(new RGB(115, 153, 0)));
		preferences.put(MODULES_CATEGORY+CLASS, FontClass.Sanserif.name());
		preferences.put(MODULES_CATEGORY+STYLE, FontStyle.Regular.name());
		preferences.put(MODULES_CATEGORY+SIZE, FontSize.Regular.name());

		preferences.put(DECLARATIONS_CATEGORY, StringConverter.asString(new RGB(0, 0, 0)));
		preferences.put(DECLARATIONS_CATEGORY+CLASS, FontClass.Sanserif.name());
		preferences.put(DECLARATIONS_CATEGORY+STYLE, FontStyle.Regular.name());
		preferences.put(DECLARATIONS_CATEGORY+SIZE, FontSize.Regular.name());

		preferences.put(RELATIONS_CATEGORY, StringConverter.asString(new RGB(230, 123, 0)));
		preferences.put(RELATIONS_CATEGORY+CLASS, FontClass.Sanserif.name());
		preferences.put(RELATIONS_CATEGORY+STYLE, FontStyle.Regular.name());
		preferences.put(RELATIONS_CATEGORY+SIZE, FontSize.Regular.name());

		preferences.put(KEYWORDS_CATEGORY, StringConverter.asString(new RGB(127, 0, 85)));
		preferences.put(KEYWORDS_CATEGORY+CLASS, FontClass.Sanserif.name());
		preferences.put(KEYWORDS_CATEGORY+STYLE, FontStyle.Regular.name());
		preferences.put(KEYWORDS_CATEGORY+SIZE, FontSize.Regular.name());

		preferences.put(IDENTIFIERS_CATEGORY, StringConverter.asString(new RGB(0, 112, 191)));
		preferences.put(IDENTIFIERS_CATEGORY+CLASS, FontClass.Sanserif.name());
		preferences.put(IDENTIFIERS_CATEGORY+STYLE, FontStyle.Regular.name());
		preferences.put(IDENTIFIERS_CATEGORY+SIZE, FontSize.Regular.name());

		preferences.put(LITERALS_CATEGORY, StringConverter.asString(new RGB(128, 63, 0)));
		preferences.put(LITERALS_CATEGORY+CLASS, FontClass.Sanserif.name());
		preferences.put(LITERALS_CATEGORY+STYLE, FontStyle.Regular.name());
		preferences.put(LITERALS_CATEGORY+SIZE, FontSize.Regular.name());

		preferences.put(ERRORS_CATEGORY, StringConverter.asString(new RGB(255, 0, 0)));
		preferences.put(ERRORS_CATEGORY+CLASS, FontClass.Sanserif.name());
		preferences.put(ERRORS_CATEGORY+STYLE, FontStyle.Regular.name());
		preferences.put(ERRORS_CATEGORY+SIZE, FontSize.Regular.name());

		preferences.put(CONTENT_CATEGORY, StringConverter.asString(new RGB(0, 0, 0)));
		preferences.put(CONTENT_CATEGORY+CLASS, FontClass.Sanserif.name());
		preferences.put(CONTENT_CATEGORY+STYLE, FontStyle.Regular.name());
		preferences.put(CONTENT_CATEGORY+SIZE, FontSize.Regular.name());

		preferences.put(CONTENT_DARK_CATEGORY, StringConverter.asString(new RGB(7, 54, 66)));
		preferences.put(CONTENT_DARK_CATEGORY+CLASS, FontClass.Sanserif.name());
		preferences.put(CONTENT_DARK_CATEGORY+STYLE, FontStyle.Regular.name());
		preferences.put(CONTENT_DARK_CATEGORY+SIZE, FontSize.Regular.name());

		preferences.put(CONTENT_LIGHT_CATEGORY, StringConverter.asString(new RGB(88, 110, 117)));
		preferences.put(CONTENT_LIGHT_CATEGORY+CLASS, FontClass.Sanserif.name());
		preferences.put(CONTENT_LIGHT_CATEGORY+STYLE, FontStyle.Regular.name());
		preferences.put(CONTENT_LIGHT_CATEGORY+SIZE, FontSize.Regular.name());

		preferences.put(CONTENT_LIGHTER_CATEGORY, StringConverter.asString(new RGB(147, 161, 161)));
		preferences.put(CONTENT_LIGHTER_CATEGORY+CLASS, FontClass.Sanserif.name());
		preferences.put(CONTENT_LIGHTER_CATEGORY+STYLE, FontStyle.Regular.name());
		preferences.put(CONTENT_LIGHTER_CATEGORY+SIZE, FontSize.Regular.name());
	}
}
