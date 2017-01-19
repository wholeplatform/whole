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

import static org.whole.lang.ui.PreferenceConstants.*;
import static org.whole.lang.ui.util.UIUtils.*;

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
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.util.IUIConstants;
import org.whole.lang.ui.util.UIUtils;

/**
 * @author Enrico Persiani
 */
public class PreferenceProcessor {
	private static final float SMALL_RATIO = 8f/12f;
	private static final float MEDIUM_RATIO = 14f/12f;
	private static final float LARGE_RATIO = 21f/12f;
	private static final float OPEN_SYMBOL_RATIO = 12f/11f;

	@Inject
	protected IEventBroker eventBroker;
	
	@Inject
	protected UISynchronize uiSynchronize;

	@Execute
	public void execute() {
		final String bundleId = IUIConstants.BUNDLE_ID;

		try {
			URL url = Platform.getBundle(bundleId).getEntry("/fonts/opensymbol.ttf");
			IPath fontPath = new Path(FileLocator.toFileURL(url).getPath());
			if (!Display.getCurrent().loadFont(fontPath.toOSString()))
				throw new IllegalArgumentException("Display.loadFont(...) failed");
		} catch (Exception e) {
			throw new IllegalStateException("Unable to load OpenSymbol font", e);
		}
		
		initializeDefaultValues(bundleId);

		FigureConstants.monospaceFontRegular = createFont(bundleId, MONOSPACE_FONT);
		FigureConstants.monospaceFontSmall = scaleFont(FigureConstants.monospaceFontRegular, SMALL_RATIO);
		FigureConstants.monospaceFontMedium = scaleFont(FigureConstants.monospaceFontRegular, MEDIUM_RATIO);
		FigureConstants.monospaceFontLarge = scaleFont(FigureConstants.monospaceFontRegular, LARGE_RATIO);

		int height = Math.round(FigureConstants.monospaceFontRegular.getFontData()[0].getHeight()*OPEN_SYMBOL_RATIO);
		FigureConstants.symbolFontRegular = createFont(FontDescriptor.createFrom("OpenSymbol", height, SWT.NONE));
		FigureConstants.symbolFontSmall = scaleFont(FigureConstants.symbolFontRegular, SMALL_RATIO);
		FigureConstants.symbolFontMedium = scaleFont(FigureConstants.symbolFontRegular, MEDIUM_RATIO);
		FigureConstants.symbolFontLarge = scaleFont(FigureConstants.symbolFontRegular, LARGE_RATIO);

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
							FigureConstants.monospaceFontSmall = replaceResource(FigureConstants.monospaceFontSmall, scaleFont(FigureConstants.monospaceFontRegular, SMALL_RATIO));
							FigureConstants.monospaceFontMedium = replaceResource(FigureConstants.monospaceFontMedium, scaleFont(FigureConstants.monospaceFontRegular, MEDIUM_RATIO));
							FigureConstants.monospaceFontLarge = replaceResource(FigureConstants.monospaceFontLarge, scaleFont(FigureConstants.monospaceFontRegular, LARGE_RATIO));
							
							int height = Math.round(FigureConstants.monospaceFontRegular.getFontData()[0].getHeight()*OPEN_SYMBOL_RATIO);
							FigureConstants.symbolFontRegular = replaceResource(FigureConstants.symbolFontRegular, createFont(FontDescriptor.createFrom("OpenSymbol", height, SWT.NONE)));
							FigureConstants.symbolFontSmall = replaceResource(FigureConstants.symbolFontSmall, scaleFont(FigureConstants.symbolFontRegular, SMALL_RATIO));
							FigureConstants.symbolFontMedium = replaceResource(FigureConstants.symbolFontMedium, scaleFont(FigureConstants.symbolFontRegular, MEDIUM_RATIO));
							FigureConstants.symbolFontLarge = replaceResource(FigureConstants.symbolFontLarge, scaleFont(FigureConstants.symbolFontRegular, LARGE_RATIO));
							
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
							
						} else if (prop.equals(SELECTION_CATEGORY))
							FigureConstants.selectionColor = replaceResource(FigureConstants.selectionColor, createColor(bundleId, SELECTION_CATEGORY));
						else if (prop.equals(MATCHING_SELECTION_CATEGORY))
							FigureConstants.matchingSelectionColor = replaceResource(FigureConstants.matchingSelectionColor, createColor(bundleId, MATCHING_SELECTION_CATEGORY));
						else if (prop.equals(HOST_LANGUAGE_CATEGORY)) {
							FigureConstants.hostLanguageColor = replaceResource(FigureConstants.hostLanguageColor, createColor(bundleId, HOST_LANGUAGE_CATEGORY));
						} else if (prop.equals(TEMPLATE_LANGUAGE_CATEGORY)) {
							FigureConstants.templateLanguageColor = replaceResource(FigureConstants.templateLanguageColor, createColor(bundleId, TEMPLATE_LANGUAGE_CATEGORY));
						}
						
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
						
						eventBroker.post(IE4UIConstants.TOPIC_REBUILD_VIEWER, null);
						eventBroker.post(IE4UIConstants.TOPIC_REFRESH_VIEWER, null);
					}
				});
			}
		});
	}

	public static void initializeDefaultValues(String bundleId) {
		IEclipsePreferences preferences = DefaultScope.INSTANCE.getNode(bundleId);

		preferences.put(MONOSPACE_FONT, PreferenceConverter.getStoredRepresentation(JFaceResources.getTextFont().getFontData()));

		RGB lightGreen = new RGB(225, 235, 224);
		preferences.put(SELECTION_CATEGORY, StringConverter.asString(lightGreen));
		preferences.put(MATCHING_SELECTION_CATEGORY, StringConverter.asString(UIUtils.darker(lightGreen)));
		preferences.put(HOST_LANGUAGE_CATEGORY, StringConverter.asString(new RGB(255, 255, 255)));
		preferences.put(TEMPLATE_LANGUAGE_CATEGORY, StringConverter.asString(new RGB(238, 232, 213)));

		preferences.put(MODULES_CATEGORY, StringConverter.asString(new RGB(115, 153, 0)));
		preferences.putBoolean(MODULES_CATEGORY+BOLD, false);
		preferences.putBoolean(MODULES_CATEGORY+ITALIC, false);

		preferences.put(DECLARATIONS_CATEGORY, StringConverter.asString(new RGB(0, 0, 0)));
		preferences.putBoolean(DECLARATIONS_CATEGORY+BOLD, true);
		preferences.putBoolean(DECLARATIONS_CATEGORY+ITALIC, false);

		preferences.put(RELATIONS_CATEGORY, StringConverter.asString(new RGB(230, 123, 0)));
		preferences.putBoolean(RELATIONS_CATEGORY+BOLD, true);
		preferences.putBoolean(RELATIONS_CATEGORY+ITALIC, false);

		preferences.put(KEYWORDS_CATEGORY, StringConverter.asString(new RGB(127, 0, 85)));
		preferences.putBoolean(KEYWORDS_CATEGORY+BOLD, true);
		preferences.putBoolean(KEYWORDS_CATEGORY+ITALIC, false);

		preferences.put(IDENTIFIERS_CATEGORY, StringConverter.asString(new RGB(0, 112, 191)));
		preferences.putBoolean(IDENTIFIERS_CATEGORY+BOLD, false);
		preferences.putBoolean(IDENTIFIERS_CATEGORY+ITALIC, false);

		preferences.put(LITERALS_CATEGORY, StringConverter.asString(new RGB(128, 63, 0)));
		preferences.putBoolean(LITERALS_CATEGORY+BOLD, false);
		preferences.putBoolean(LITERALS_CATEGORY+ITALIC, false);

		preferences.put(ERRORS_CATEGORY, StringConverter.asString(new RGB(255, 0, 0)));
		preferences.putBoolean(ERRORS_CATEGORY+BOLD, false);
		preferences.putBoolean(ERRORS_CATEGORY+ITALIC, false);

		preferences.put(CONTENT_CATEGORY, StringConverter.asString(new RGB(0, 0, 0)));
		preferences.putBoolean(CONTENT_CATEGORY+BOLD, false);
		preferences.putBoolean(CONTENT_CATEGORY+ITALIC, false);

		preferences.put(CONTENT_DARK_CATEGORY, StringConverter.asString(new RGB(7, 54, 66)));
		preferences.putBoolean(CONTENT_DARK_CATEGORY+BOLD, false);
		preferences.putBoolean(CONTENT_DARK_CATEGORY+ITALIC, false);

		preferences.put(CONTENT_LIGHT_CATEGORY, StringConverter.asString(new RGB(88, 110, 117)));
		preferences.putBoolean(CONTENT_LIGHT_CATEGORY+BOLD, false);
		preferences.putBoolean(CONTENT_LIGHT_CATEGORY+ITALIC, false);

		preferences.put(CONTENT_LIGHTER_CATEGORY, StringConverter.asString(new RGB(147, 161, 161)));
		preferences.putBoolean(CONTENT_LIGHTER_CATEGORY+BOLD, false);
		preferences.putBoolean(CONTENT_LIGHTER_CATEGORY+ITALIC, false);
	}
}
