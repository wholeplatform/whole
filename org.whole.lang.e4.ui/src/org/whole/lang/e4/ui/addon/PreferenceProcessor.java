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

		FigureConstants.font = createFont(bundleId, FONT);
		FigureConstants.fontSmall = scaleFont(FigureConstants.font, SMALL_RATIO);
		FigureConstants.fontMedium = scaleFont(FigureConstants.font, MEDIUM_RATIO);
		FigureConstants.fontLarge = scaleFont(FigureConstants.font, LARGE_RATIO);

		int height = Math.round(FigureConstants.font.getFontData()[0].getHeight()*OPEN_SYMBOL_RATIO);
		FigureConstants.openSymbol = createFont(FontDescriptor.createFrom("OpenSymbol", height, SWT.NONE));
		FigureConstants.openSymbolSmall = scaleFont(FigureConstants.openSymbol, SMALL_RATIO);
		FigureConstants.openSymbolMedium = scaleFont(FigureConstants.openSymbol, MEDIUM_RATIO);
		FigureConstants.openSymbolLarge = scaleFont(FigureConstants.openSymbol, LARGE_RATIO);

		FigureConstants.selectionColor = createColor(bundleId, SELECTION_COLOR);
		FigureConstants.matchingSelectionColor = createColor(bundleId, MATCHING_SELECTION_COLOR);
		FigureConstants.hostLanguageColor = createColor(bundleId, HOST_LANGUAGE_COLOR);
		FigureConstants.templateLanguageColor = createColor(bundleId, TEMPLATE_LANGUAGE_COLOR);

		FigureConstants.modulesColor = createColor(bundleId, MODULES_COLOR);
		FigureConstants.modulesFont = createStyledFont(bundleId, MODULES_COLOR);
		FigureConstants.declarationsColor = createColor(bundleId, DECLARATIONS_COLOR);
		FigureConstants.declarationsFont = createStyledFont(bundleId, DECLARATIONS_COLOR);
		FigureConstants.relationsColor = createColor(bundleId, RELATIONS_COLOR);
		FigureConstants.relationsFont = createStyledFont(bundleId, RELATIONS_COLOR);
		FigureConstants.keywordsColor = createColor(bundleId, KEYWORDS_COLOR);
		FigureConstants.keywordsFont = createStyledFont(bundleId, KEYWORDS_COLOR);
		FigureConstants.identifiersColor = createColor(bundleId, IDENTIFIERS_COLOR);
		FigureConstants.identifiersFont = createStyledFont(bundleId, IDENTIFIERS_COLOR);
		FigureConstants.literalsColor = createColor(bundleId, LITERALS_COLOR);
		FigureConstants.literalsFont = createStyledFont(bundleId, LITERALS_COLOR);
		FigureConstants.errorsColor = createColor(bundleId, ERRORS_COLOR);
		FigureConstants.errorsFont = createStyledFont(bundleId, ERRORS_COLOR);
		FigureConstants.contentColor = createColor(bundleId, CONTENT_COLOR);
		FigureConstants.contentFont = createStyledFont(bundleId, CONTENT_COLOR);
		FigureConstants.contentDarkColor = createColor(bundleId, CONTENT_DARK_COLOR);
		FigureConstants.contentDarkFont = createStyledFont(bundleId, CONTENT_DARK_COLOR);
		FigureConstants.contentLightColor = createColor(bundleId, CONTENT_LIGHT_COLOR);
		FigureConstants.contentLightFont = createStyledFont(bundleId, CONTENT_LIGHT_COLOR);
		FigureConstants.contentLighterColor = createColor(bundleId, CONTENT_LIGHTER_COLOR);
		FigureConstants.contentLighterFont = createStyledFont(bundleId, CONTENT_LIGHTER_COLOR);

		InstanceScope.INSTANCE.getNode(bundleId).addPreferenceChangeListener(new IEclipsePreferences.IPreferenceChangeListener() {
			public void preferenceChange(PreferenceChangeEvent event) {
				final String prop = event.getKey();

				// ensure execution in UI thread
				uiSynchronize.asyncExec(new Runnable() {
					@Override
					public void run() {
						if (prop.equals(FONT)) {
							FigureConstants.font = replaceResource(FigureConstants.font, createFont(bundleId, FONT));
							FigureConstants.fontSmall = replaceResource(FigureConstants.fontSmall, scaleFont(FigureConstants.font, SMALL_RATIO));
							FigureConstants.fontMedium = replaceResource(FigureConstants.fontMedium, scaleFont(FigureConstants.font, MEDIUM_RATIO));
							FigureConstants.fontLarge = replaceResource(FigureConstants.fontLarge, scaleFont(FigureConstants.font, LARGE_RATIO));
							
							int height = Math.round(FigureConstants.font.getFontData()[0].getHeight()*OPEN_SYMBOL_RATIO);
							FigureConstants.openSymbol = replaceResource(FigureConstants.openSymbol, createFont(FontDescriptor.createFrom("OpenSymbol", height, SWT.NONE)));
							FigureConstants.openSymbolSmall = replaceResource(FigureConstants.openSymbolSmall, scaleFont(FigureConstants.openSymbol, SMALL_RATIO));
							FigureConstants.openSymbolMedium = replaceResource(FigureConstants.openSymbolMedium, scaleFont(FigureConstants.openSymbol, MEDIUM_RATIO));
							FigureConstants.openSymbolLarge = replaceResource(FigureConstants.openSymbolLarge, scaleFont(FigureConstants.openSymbol, LARGE_RATIO));
							
							FigureConstants.modulesFont = replaceResource(FigureConstants.modulesFont, createStyledFont(bundleId, MODULES_COLOR));
							FigureConstants.declarationsFont = replaceResource(FigureConstants.declarationsFont, createStyledFont(bundleId, DECLARATIONS_COLOR));
							FigureConstants.relationsFont = replaceResource(FigureConstants.relationsFont, createStyledFont(bundleId, RELATIONS_COLOR));
							FigureConstants.keywordsFont = replaceResource(FigureConstants.keywordsFont, createStyledFont(bundleId, KEYWORDS_COLOR));
							FigureConstants.identifiersFont = replaceResource(FigureConstants.identifiersFont, createStyledFont(bundleId, IDENTIFIERS_COLOR));
							FigureConstants.literalsFont = replaceResource(FigureConstants.literalsFont, createStyledFont(bundleId, LITERALS_COLOR));
							FigureConstants.errorsFont = replaceResource(FigureConstants.errorsFont, createStyledFont(bundleId, ERRORS_COLOR));
							FigureConstants.contentFont = replaceResource(FigureConstants.contentFont, createStyledFont(bundleId, CONTENT_COLOR));
							FigureConstants.contentDarkFont = replaceResource(FigureConstants.contentDarkFont, createStyledFont(bundleId, CONTENT_DARK_COLOR));
							FigureConstants.contentLightFont = replaceResource(FigureConstants.contentLightFont, createStyledFont(bundleId, CONTENT_LIGHT_COLOR));
							FigureConstants.contentLighterFont = replaceResource(FigureConstants.contentLighterFont, createStyledFont(bundleId, CONTENT_LIGHTER_COLOR));
							
						} else if (prop.equals(SELECTION_COLOR))
							FigureConstants.selectionColor = replaceResource(FigureConstants.selectionColor, createColor(bundleId, SELECTION_COLOR));
						else if (prop.equals(MATCHING_SELECTION_COLOR))
							FigureConstants.matchingSelectionColor = replaceResource(FigureConstants.matchingSelectionColor, createColor(bundleId, MATCHING_SELECTION_COLOR));
						else if (prop.equals(HOST_LANGUAGE_COLOR)) {
							FigureConstants.hostLanguageColor = replaceResource(FigureConstants.hostLanguageColor, createColor(bundleId, HOST_LANGUAGE_COLOR));
						} else if (prop.equals(TEMPLATE_LANGUAGE_COLOR)) {
							FigureConstants.templateLanguageColor = replaceResource(FigureConstants.templateLanguageColor, createColor(bundleId, TEMPLATE_LANGUAGE_COLOR));
						}
						
						else if (prop.equals(MODULES_COLOR))
							FigureConstants.modulesColor = replaceResource(FigureConstants.modulesColor, createColor(bundleId, MODULES_COLOR));
						else if (prop.startsWith(MODULES_COLOR))
							FigureConstants.modulesFont = replaceResource(FigureConstants.modulesFont, createStyledFont(bundleId, MODULES_COLOR));
						
						else if (prop.equals(DECLARATIONS_COLOR))
							FigureConstants.declarationsColor = replaceResource(FigureConstants.declarationsColor, createColor(bundleId, DECLARATIONS_COLOR));
						else if (prop.startsWith(DECLARATIONS_COLOR))
							FigureConstants.declarationsFont = replaceResource(FigureConstants.declarationsFont, createStyledFont(bundleId, DECLARATIONS_COLOR));
						
						else if (prop.equals(RELATIONS_COLOR))
							FigureConstants.relationsColor = replaceResource(FigureConstants.relationsColor, createColor(bundleId, RELATIONS_COLOR));
						else if (prop.startsWith(RELATIONS_COLOR))
							FigureConstants.relationsFont = replaceResource(FigureConstants.relationsFont, createStyledFont(bundleId, RELATIONS_COLOR));
						
						else if (prop.equals(KEYWORDS_COLOR))
							FigureConstants.keywordsColor = replaceResource(FigureConstants.keywordsColor, createColor(bundleId, KEYWORDS_COLOR));
						else if (prop.startsWith(KEYWORDS_COLOR))
							FigureConstants.keywordsFont = replaceResource(FigureConstants.keywordsFont, createStyledFont(bundleId, KEYWORDS_COLOR));
						
						else if (prop.equals(IDENTIFIERS_COLOR))
							FigureConstants.identifiersColor = replaceResource(FigureConstants.identifiersColor, createColor(bundleId, IDENTIFIERS_COLOR));
						else if (prop.startsWith(IDENTIFIERS_COLOR))
							FigureConstants.identifiersFont = replaceResource(FigureConstants.identifiersFont, createStyledFont(bundleId, IDENTIFIERS_COLOR));
						
						else if (prop.equals(LITERALS_COLOR))
							FigureConstants.literalsColor = replaceResource(FigureConstants.literalsColor, createColor(bundleId, LITERALS_COLOR));
						else if (prop.startsWith(LITERALS_COLOR))
							FigureConstants.literalsFont = replaceResource(FigureConstants.literalsFont, createStyledFont(bundleId, LITERALS_COLOR));
						
						else if (prop.equals(ERRORS_COLOR))
							FigureConstants.errorsColor = replaceResource(FigureConstants.errorsColor, createColor(bundleId, ERRORS_COLOR));
						else if (prop.startsWith(ERRORS_COLOR))
							FigureConstants.errorsFont = replaceResource(FigureConstants.errorsFont, createStyledFont(bundleId, ERRORS_COLOR));
						
						else if (prop.equals(CONTENT_COLOR))
							FigureConstants.contentColor = replaceResource(FigureConstants.contentColor, createColor(bundleId, CONTENT_COLOR));
						else if (prop.startsWith(CONTENT_COLOR))
							FigureConstants.contentFont = replaceResource(FigureConstants.contentFont, createStyledFont(bundleId, CONTENT_COLOR));
						
						else if (prop.equals(CONTENT_DARK_COLOR))
							FigureConstants.contentDarkColor = replaceResource(FigureConstants.contentDarkColor, createColor(bundleId, CONTENT_DARK_COLOR));
						else if (prop.startsWith(CONTENT_DARK_COLOR))
							FigureConstants.contentDarkFont = replaceResource(FigureConstants.contentDarkFont, createStyledFont(bundleId, CONTENT_DARK_COLOR));

						else if (prop.equals(CONTENT_LIGHT_COLOR))
							FigureConstants.contentLightColor = replaceResource(FigureConstants.contentLightColor, createColor(bundleId, CONTENT_LIGHT_COLOR));
						else if (prop.startsWith(CONTENT_LIGHT_COLOR))
							FigureConstants.contentLightFont = replaceResource(FigureConstants.contentLightFont, createStyledFont(bundleId, CONTENT_LIGHT_COLOR));
						
						else if (prop.equals(CONTENT_LIGHTER_COLOR))
							FigureConstants.contentLighterColor = replaceResource(FigureConstants.contentLighterColor, createColor(bundleId, CONTENT_LIGHTER_COLOR));
						else if (prop.startsWith(CONTENT_LIGHTER_COLOR))
							FigureConstants.contentLighterFont = replaceResource(FigureConstants.contentLighterFont, createStyledFont(bundleId, CONTENT_LIGHTER_COLOR));
						
						eventBroker.post(IE4UIConstants.TOPIC_REBUILD_VIEWER, null);
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
