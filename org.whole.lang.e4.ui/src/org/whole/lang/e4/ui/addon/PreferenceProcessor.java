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
import org.whole.lang.ui.figures.FigurePrefs;
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

		FigurePrefs.font = createFont(bundleId, FONT);
		FigurePrefs.fontSmall = scaleFont(FigurePrefs.font, SMALL_RATIO);
		FigurePrefs.fontMedium = scaleFont(FigurePrefs.font, MEDIUM_RATIO);
		FigurePrefs.fontLarge = scaleFont(FigurePrefs.font, LARGE_RATIO);

		int height = Math.round(FigurePrefs.font.getFontData()[0].getHeight()*OPEN_SYMBOL_RATIO);
		FigurePrefs.openSymbol = createFont(FontDescriptor.createFrom("OpenSymbol", height, SWT.NONE));
		FigurePrefs.openSymbolSmall = scaleFont(FigurePrefs.openSymbol, SMALL_RATIO);
		FigurePrefs.openSymbolMedium = scaleFont(FigurePrefs.openSymbol, MEDIUM_RATIO);
		FigurePrefs.openSymbolLarge = scaleFont(FigurePrefs.openSymbol, LARGE_RATIO);

		FigurePrefs.selectionColor = createColor(bundleId, SELECTION_COLOR);
		FigurePrefs.matchingSelectionColor = createColor(bundleId, MATCHING_SELECTION_COLOR);
		FigurePrefs.hostLanguageColor = createColor(bundleId, HOST_LANGUAGE_COLOR);
		FigurePrefs.templateLanguageColor = createColor(bundleId, TEMPLATE_LANGUAGE_COLOR);

		FigurePrefs.modulesColor = createColor(bundleId, MODULES_COLOR);
		FigurePrefs.modulesFont = createStyledFont(bundleId, MODULES_COLOR);
		FigurePrefs.declarationsColor = createColor(bundleId, DECLARATIONS_COLOR);
		FigurePrefs.declarationsFont = createStyledFont(bundleId, DECLARATIONS_COLOR);
		FigurePrefs.relationsColor = createColor(bundleId, RELATIONS_COLOR);
		FigurePrefs.relationsFont = createStyledFont(bundleId, RELATIONS_COLOR);
		FigurePrefs.keywordsColor = createColor(bundleId, KEYWORDS_COLOR);
		FigurePrefs.keywordsFont = createStyledFont(bundleId, KEYWORDS_COLOR);
		FigurePrefs.identifiersColor = createColor(bundleId, IDENTIFIERS_COLOR);
		FigurePrefs.identifiersFont = createStyledFont(bundleId, IDENTIFIERS_COLOR);
		FigurePrefs.literalsColor = createColor(bundleId, LITERALS_COLOR);
		FigurePrefs.literalsFont = createStyledFont(bundleId, LITERALS_COLOR);
		FigurePrefs.errorsColor = createColor(bundleId, ERRORS_COLOR);
		FigurePrefs.errorsFont = createStyledFont(bundleId, ERRORS_COLOR);
		FigurePrefs.contentColor = createColor(bundleId, CONTENT_COLOR);
		FigurePrefs.contentFont = createStyledFont(bundleId, CONTENT_COLOR);
		FigurePrefs.contentDarkColor = createColor(bundleId, CONTENT_DARK_COLOR);
		FigurePrefs.contentDarkFont = createStyledFont(bundleId, CONTENT_DARK_COLOR);
		FigurePrefs.contentLightColor = createColor(bundleId, CONTENT_LIGHT_COLOR);
		FigurePrefs.contentLightFont = createStyledFont(bundleId, CONTENT_LIGHT_COLOR);
		FigurePrefs.contentLighterColor = createColor(bundleId, CONTENT_LIGHTER_COLOR);
		FigurePrefs.contentLighterFont = createStyledFont(bundleId, CONTENT_LIGHTER_COLOR);

		InstanceScope.INSTANCE.getNode(bundleId).addPreferenceChangeListener(new IEclipsePreferences.IPreferenceChangeListener() {
			public void preferenceChange(PreferenceChangeEvent event) {
				final String prop = event.getKey();

				// ensure execution in UI thread
				uiSynchronize.asyncExec(new Runnable() {
					@Override
					public void run() {
						if (prop.equals(FONT)) {
							FigurePrefs.font = replaceResource(FigurePrefs.font, createFont(bundleId, FONT));
							FigurePrefs.fontSmall = replaceResource(FigurePrefs.fontSmall, scaleFont(FigurePrefs.font, SMALL_RATIO));
							FigurePrefs.fontMedium = replaceResource(FigurePrefs.fontMedium, scaleFont(FigurePrefs.font, MEDIUM_RATIO));
							FigurePrefs.fontLarge = replaceResource(FigurePrefs.fontLarge, scaleFont(FigurePrefs.font, LARGE_RATIO));
							
							int height = Math.round(FigurePrefs.font.getFontData()[0].getHeight()*OPEN_SYMBOL_RATIO);
							FigurePrefs.openSymbol = replaceResource(FigurePrefs.openSymbol, createFont(FontDescriptor.createFrom("OpenSymbol", height, SWT.NONE)));
							FigurePrefs.openSymbolSmall = replaceResource(FigurePrefs.openSymbolSmall, scaleFont(FigurePrefs.openSymbol, SMALL_RATIO));
							FigurePrefs.openSymbolMedium = replaceResource(FigurePrefs.openSymbolMedium, scaleFont(FigurePrefs.openSymbol, MEDIUM_RATIO));
							FigurePrefs.openSymbolLarge = replaceResource(FigurePrefs.openSymbolLarge, scaleFont(FigurePrefs.openSymbol, LARGE_RATIO));
							
							FigurePrefs.modulesFont = replaceResource(FigurePrefs.modulesFont, createStyledFont(bundleId, MODULES_COLOR));
							FigurePrefs.declarationsFont = replaceResource(FigurePrefs.declarationsFont, createStyledFont(bundleId, DECLARATIONS_COLOR));
							FigurePrefs.relationsFont = replaceResource(FigurePrefs.relationsFont, createStyledFont(bundleId, RELATIONS_COLOR));
							FigurePrefs.keywordsFont = replaceResource(FigurePrefs.keywordsFont, createStyledFont(bundleId, KEYWORDS_COLOR));
							FigurePrefs.identifiersFont = replaceResource(FigurePrefs.identifiersFont, createStyledFont(bundleId, IDENTIFIERS_COLOR));
							FigurePrefs.literalsFont = replaceResource(FigurePrefs.literalsFont, createStyledFont(bundleId, LITERALS_COLOR));
							FigurePrefs.errorsFont = replaceResource(FigurePrefs.errorsFont, createStyledFont(bundleId, ERRORS_COLOR));
							FigurePrefs.contentFont = replaceResource(FigurePrefs.contentFont, createStyledFont(bundleId, CONTENT_COLOR));
							FigurePrefs.contentDarkFont = replaceResource(FigurePrefs.contentDarkFont, createStyledFont(bundleId, CONTENT_DARK_COLOR));
							FigurePrefs.contentLightFont = replaceResource(FigurePrefs.contentLightFont, createStyledFont(bundleId, CONTENT_LIGHT_COLOR));
							FigurePrefs.contentLighterFont = replaceResource(FigurePrefs.contentLighterFont, createStyledFont(bundleId, CONTENT_LIGHTER_COLOR));
							
						} else if (prop.equals(SELECTION_COLOR))
							FigurePrefs.selectionColor = replaceResource(FigurePrefs.selectionColor, createColor(bundleId, SELECTION_COLOR));
						else if (prop.equals(MATCHING_SELECTION_COLOR))
							FigurePrefs.matchingSelectionColor = replaceResource(FigurePrefs.matchingSelectionColor, createColor(bundleId, MATCHING_SELECTION_COLOR));
						else if (prop.equals(HOST_LANGUAGE_COLOR)) {
							FigurePrefs.hostLanguageColor = replaceResource(FigurePrefs.hostLanguageColor, createColor(bundleId, HOST_LANGUAGE_COLOR));
						} else if (prop.equals(TEMPLATE_LANGUAGE_COLOR)) {
							FigurePrefs.templateLanguageColor = replaceResource(FigurePrefs.templateLanguageColor, createColor(bundleId, TEMPLATE_LANGUAGE_COLOR));
						}
						
						else if (prop.equals(MODULES_COLOR))
							FigurePrefs.modulesColor = replaceResource(FigurePrefs.modulesColor, createColor(bundleId, MODULES_COLOR));
						else if (prop.startsWith(MODULES_COLOR))
							FigurePrefs.modulesFont = replaceResource(FigurePrefs.modulesFont, createStyledFont(bundleId, MODULES_COLOR));
						
						else if (prop.equals(DECLARATIONS_COLOR))
							FigurePrefs.declarationsColor = replaceResource(FigurePrefs.declarationsColor, createColor(bundleId, DECLARATIONS_COLOR));
						else if (prop.startsWith(DECLARATIONS_COLOR))
							FigurePrefs.declarationsFont = replaceResource(FigurePrefs.declarationsFont, createStyledFont(bundleId, DECLARATIONS_COLOR));
						
						else if (prop.equals(RELATIONS_COLOR))
							FigurePrefs.relationsColor = replaceResource(FigurePrefs.relationsColor, createColor(bundleId, RELATIONS_COLOR));
						else if (prop.startsWith(RELATIONS_COLOR))
							FigurePrefs.relationsFont = replaceResource(FigurePrefs.relationsFont, createStyledFont(bundleId, RELATIONS_COLOR));
						
						else if (prop.equals(KEYWORDS_COLOR))
							FigurePrefs.keywordsColor = replaceResource(FigurePrefs.keywordsColor, createColor(bundleId, KEYWORDS_COLOR));
						else if (prop.startsWith(KEYWORDS_COLOR))
							FigurePrefs.keywordsFont = replaceResource(FigurePrefs.keywordsFont, createStyledFont(bundleId, KEYWORDS_COLOR));
						
						else if (prop.equals(IDENTIFIERS_COLOR))
							FigurePrefs.identifiersColor = replaceResource(FigurePrefs.identifiersColor, createColor(bundleId, IDENTIFIERS_COLOR));
						else if (prop.startsWith(IDENTIFIERS_COLOR))
							FigurePrefs.identifiersFont = replaceResource(FigurePrefs.identifiersFont, createStyledFont(bundleId, IDENTIFIERS_COLOR));
						
						else if (prop.equals(LITERALS_COLOR))
							FigurePrefs.literalsColor = replaceResource(FigurePrefs.literalsColor, createColor(bundleId, LITERALS_COLOR));
						else if (prop.startsWith(LITERALS_COLOR))
							FigurePrefs.literalsFont = replaceResource(FigurePrefs.literalsFont, createStyledFont(bundleId, LITERALS_COLOR));
						
						else if (prop.equals(ERRORS_COLOR))
							FigurePrefs.errorsColor = replaceResource(FigurePrefs.errorsColor, createColor(bundleId, ERRORS_COLOR));
						else if (prop.startsWith(ERRORS_COLOR))
							FigurePrefs.errorsFont = replaceResource(FigurePrefs.errorsFont, createStyledFont(bundleId, ERRORS_COLOR));
						
						else if (prop.equals(CONTENT_COLOR))
							FigurePrefs.contentColor = replaceResource(FigurePrefs.contentColor, createColor(bundleId, CONTENT_COLOR));
						else if (prop.startsWith(CONTENT_COLOR))
							FigurePrefs.contentFont = replaceResource(FigurePrefs.contentFont, createStyledFont(bundleId, CONTENT_COLOR));
						
						else if (prop.equals(CONTENT_DARK_COLOR))
							FigurePrefs.contentDarkColor = replaceResource(FigurePrefs.contentDarkColor, createColor(bundleId, CONTENT_DARK_COLOR));
						else if (prop.startsWith(CONTENT_DARK_COLOR))
							FigurePrefs.contentDarkFont = replaceResource(FigurePrefs.contentDarkFont, createStyledFont(bundleId, CONTENT_DARK_COLOR));

						else if (prop.equals(CONTENT_LIGHT_COLOR))
							FigurePrefs.contentLightColor = replaceResource(FigurePrefs.contentLightColor, createColor(bundleId, CONTENT_LIGHT_COLOR));
						else if (prop.startsWith(CONTENT_LIGHT_COLOR))
							FigurePrefs.contentLightFont = replaceResource(FigurePrefs.contentLightFont, createStyledFont(bundleId, CONTENT_LIGHT_COLOR));
						
						else if (prop.equals(CONTENT_LIGHTER_COLOR))
							FigurePrefs.contentLighterColor = replaceResource(FigurePrefs.contentLighterColor, createColor(bundleId, CONTENT_LIGHTER_COLOR));
						else if (prop.startsWith(CONTENT_LIGHTER_COLOR))
							FigurePrefs.contentLighterFont = replaceResource(FigurePrefs.contentLighterFont, createStyledFont(bundleId, CONTENT_LIGHTER_COLOR));
						
						eventBroker.post(IE4UIConstants.TOPIC_REFRESH_VIEWER, null);
					}
				});
			}
		});
	}

	public static void initializeDefaultValues(String bundleId) {
		IEclipsePreferences preferences = DefaultScope.INSTANCE.getNode(bundleId);

		preferences.put(FONT, PreferenceConverter.getStoredRepresentation(JFaceResources.getTextFont().getFontData()));

		RGB lightGreen = new RGB(225, 235, 224);
		preferences.put(SELECTION_COLOR, StringConverter.asString(lightGreen));
		preferences.put(MATCHING_SELECTION_COLOR, StringConverter.asString(UIUtils.darker(lightGreen)));
		preferences.put(HOST_LANGUAGE_COLOR, StringConverter.asString(new RGB(255, 255, 255)));
		preferences.put(TEMPLATE_LANGUAGE_COLOR, StringConverter.asString(new RGB(238, 232, 213)));

		preferences.put(MODULES_COLOR, StringConverter.asString(new RGB(115, 153, 0)));
		preferences.putBoolean(MODULES_COLOR+BOLD, false);
		preferences.putBoolean(MODULES_COLOR+ITALIC, false);

		preferences.put(DECLARATIONS_COLOR, StringConverter.asString(new RGB(0, 0, 0)));
		preferences.putBoolean(DECLARATIONS_COLOR+BOLD, true);
		preferences.putBoolean(DECLARATIONS_COLOR+ITALIC, false);

		preferences.put(RELATIONS_COLOR, StringConverter.asString(new RGB(230, 123, 0)));
		preferences.putBoolean(RELATIONS_COLOR+BOLD, true);
		preferences.putBoolean(RELATIONS_COLOR+ITALIC, false);

		preferences.put(KEYWORDS_COLOR, StringConverter.asString(new RGB(127, 0, 85)));
		preferences.putBoolean(KEYWORDS_COLOR+BOLD, true);
		preferences.putBoolean(KEYWORDS_COLOR+ITALIC, false);

		preferences.put(IDENTIFIERS_COLOR, StringConverter.asString(new RGB(0, 112, 191)));
		preferences.putBoolean(IDENTIFIERS_COLOR+BOLD, false);
		preferences.putBoolean(IDENTIFIERS_COLOR+ITALIC, false);

		preferences.put(LITERALS_COLOR, StringConverter.asString(new RGB(128, 63, 0)));
		preferences.putBoolean(LITERALS_COLOR+BOLD, false);
		preferences.putBoolean(LITERALS_COLOR+ITALIC, false);

		preferences.put(ERRORS_COLOR, StringConverter.asString(new RGB(255, 0, 0)));
		preferences.putBoolean(ERRORS_COLOR+BOLD, false);
		preferences.putBoolean(ERRORS_COLOR+ITALIC, false);

		preferences.put(CONTENT_COLOR, StringConverter.asString(new RGB(0, 0, 0)));
		preferences.putBoolean(CONTENT_COLOR+BOLD, false);
		preferences.putBoolean(CONTENT_COLOR+ITALIC, false);

		preferences.put(CONTENT_DARK_COLOR, StringConverter.asString(new RGB(7, 54, 66)));
		preferences.putBoolean(CONTENT_DARK_COLOR+BOLD, false);
		preferences.putBoolean(CONTENT_DARK_COLOR+ITALIC, false);

		preferences.put(CONTENT_LIGHT_COLOR, StringConverter.asString(new RGB(88, 110, 117)));
		preferences.putBoolean(CONTENT_LIGHT_COLOR+BOLD, false);
		preferences.putBoolean(CONTENT_LIGHT_COLOR+ITALIC, false);

		preferences.put(CONTENT_LIGHTER_COLOR, StringConverter.asString(new RGB(147, 161, 161)));
		preferences.putBoolean(CONTENT_LIGHTER_COLOR+BOLD, false);
		preferences.putBoolean(CONTENT_LIGHTER_COLOR+ITALIC, false);
	}
}
