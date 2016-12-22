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

import static org.whole.lang.ui.util.UIUtils.getColor;
import static org.whole.lang.ui.util.UIUtils.getFont;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.swt.graphics.FontData;
import org.whole.lang.e4.ui.actions.IUIConstants;
import org.whole.lang.ui.PreferenceConstants;
import org.whole.lang.ui.figures.FigurePrefs;
import org.whole.lang.ui.util.UIUtils;

/**
 * @author Enrico Persiani
 */
public class PreferenceProcessor {
	@Inject
	protected IEventBroker eventBroker;

	@Execute
	public void execute() {
		final String bundleId = IUIConstants.BUNDLE_ID;

		PreferenceConstants.initializeDefaultValues(bundleId,
				UIUtils.getColorRegistry(), UIUtils.getFontRegistry());

		FigurePrefs.selectionColor = getColor(bundleId, PreferenceConstants.SELECTION_COLOR);
		FigurePrefs.matchingSelectionColor = getColor(bundleId, PreferenceConstants.MATCHING_SELECTION_COLOR);
		FigurePrefs.hostLanguageColor = getColor(bundleId, PreferenceConstants.HOST_LANGUAGE_COLOR);
		FigurePrefs.templateLanguageColor = getColor(bundleId, PreferenceConstants.TEMPLATE_LANGUAGE_COLOR);

		FigurePrefs.modulesColor = getColor(bundleId, PreferenceConstants.MODULES_COLOR);
		FigurePrefs.modulesFont = getFont(bundleId, PreferenceConstants.MODULES_COLOR);
		FigurePrefs.declarationsColor = getColor(bundleId, PreferenceConstants.DECLARATIONS_COLOR);
		FigurePrefs.declarationsFont = getFont(bundleId, PreferenceConstants.DECLARATIONS_COLOR);
		FigurePrefs.relationsColor = getColor(bundleId, PreferenceConstants.RELATIONS_COLOR);
		FigurePrefs.relationsFont = getFont(bundleId, PreferenceConstants.RELATIONS_COLOR);
		FigurePrefs.keywordsColor = getColor(bundleId, PreferenceConstants.KEYWORDS_COLOR);
		FigurePrefs.keywordsFont = getFont(bundleId, PreferenceConstants.KEYWORDS_COLOR);
		FigurePrefs.identifiersColor = getColor(bundleId, PreferenceConstants.IDENTIFIERS_COLOR);
		FigurePrefs.identifiersFont = getFont(bundleId, PreferenceConstants.IDENTIFIERS_COLOR);
		FigurePrefs.literalsColor = getColor(bundleId, PreferenceConstants.LITERALS_COLOR);
		FigurePrefs.literalsFont = getFont(bundleId, PreferenceConstants.LITERALS_COLOR);
		FigurePrefs.errorsColor = getColor(bundleId, PreferenceConstants.ERRORS_COLOR);
		FigurePrefs.errorsFont = getFont(bundleId, PreferenceConstants.ERRORS_COLOR);
		FigurePrefs.contentColor = getColor(bundleId, PreferenceConstants.CONTENT_COLOR);
		FigurePrefs.contentFont = getFont(bundleId, PreferenceConstants.CONTENT_COLOR);
		FigurePrefs.contentLightColor = getColor(bundleId, PreferenceConstants.CONTENT_LIGHT_COLOR);
		FigurePrefs.contentLightFont = getFont(bundleId, PreferenceConstants.CONTENT_LIGHT_COLOR);
		FigurePrefs.contentLighterColor = getColor(bundleId, PreferenceConstants.CONTENT_LIGHTER_COLOR);
		FigurePrefs.contentLighterFont = getFont(bundleId, PreferenceConstants.CONTENT_LIGHTER_COLOR);

		InstanceScope.INSTANCE.getNode(bundleId).addPreferenceChangeListener(new IEclipsePreferences.IPreferenceChangeListener() {
			public void preferenceChange(PreferenceChangeEvent event) {
				final String prop = event.getKey();

				if (prop.equals(PreferenceConstants.FONT)) {
					FigurePrefs.modulesFont = getFont(bundleId, PreferenceConstants.MODULES_COLOR);
					FigurePrefs.declarationsFont = getFont(bundleId, PreferenceConstants.DECLARATIONS_COLOR);
					FontData[] fontData = FigurePrefs.declarationsFont.getFontData();
					fontData.toString();
					FigurePrefs.relationsFont = getFont(bundleId, PreferenceConstants.RELATIONS_COLOR);
					FigurePrefs.keywordsFont = getFont(bundleId, PreferenceConstants.KEYWORDS_COLOR);
					FigurePrefs.identifiersFont = getFont(bundleId, PreferenceConstants.IDENTIFIERS_COLOR);
					FigurePrefs.literalsFont = getFont(bundleId, PreferenceConstants.LITERALS_COLOR);
					FigurePrefs.errorsFont = getFont(bundleId, PreferenceConstants.ERRORS_COLOR);
					FigurePrefs.contentFont = getFont(bundleId, PreferenceConstants.CONTENT_COLOR);
					FigurePrefs.contentDarkFont = getFont(bundleId, PreferenceConstants.CONTENT_DARK_COLOR);
					FigurePrefs.contentLightFont = getFont(bundleId, PreferenceConstants.CONTENT_LIGHT_COLOR);
					FigurePrefs.contentLighterFont = getFont(bundleId, PreferenceConstants.CONTENT_LIGHTER_COLOR);

				} else if (prop.equals(PreferenceConstants.SELECTION_COLOR))
					FigurePrefs.selectionColor = getColor(bundleId, PreferenceConstants.SELECTION_COLOR);
				else if (prop.equals(PreferenceConstants.MATCHING_SELECTION_COLOR))
					FigurePrefs.matchingSelectionColor = getColor(bundleId, PreferenceConstants.MATCHING_SELECTION_COLOR);
				else if (prop.equals(PreferenceConstants.HOST_LANGUAGE_COLOR)) {
					FigurePrefs.hostLanguageColor = getColor(bundleId, PreferenceConstants.HOST_LANGUAGE_COLOR);
				} else if (prop.equals(PreferenceConstants.TEMPLATE_LANGUAGE_COLOR)) {
					FigurePrefs.templateLanguageColor = getColor(bundleId, PreferenceConstants.TEMPLATE_LANGUAGE_COLOR);
				}

				else if (prop.equals(PreferenceConstants.MODULES_COLOR))
					FigurePrefs.modulesColor = getColor(bundleId, PreferenceConstants.MODULES_COLOR);
				else if (prop.startsWith(PreferenceConstants.MODULES_COLOR))
					FigurePrefs.modulesFont = getFont(bundleId, PreferenceConstants.MODULES_COLOR);

				else if (prop.equals(PreferenceConstants.DECLARATIONS_COLOR))
					FigurePrefs.declarationsColor = getColor(bundleId, PreferenceConstants.DECLARATIONS_COLOR);
				else if (prop.startsWith(PreferenceConstants.DECLARATIONS_COLOR)) {
					FigurePrefs.declarationsFont = getFont(bundleId, PreferenceConstants.DECLARATIONS_COLOR);
					FontData[] fontData = FigurePrefs.declarationsFont.getFontData();
					fontData.toString();
				}

				else if (prop.equals(PreferenceConstants.RELATIONS_COLOR))
					FigurePrefs.relationsColor = getColor(bundleId, PreferenceConstants.RELATIONS_COLOR);
				else if (prop.startsWith(PreferenceConstants.RELATIONS_COLOR))
					FigurePrefs.relationsFont = getFont(bundleId, PreferenceConstants.RELATIONS_COLOR);

				else if (prop.equals(PreferenceConstants.KEYWORDS_COLOR))
					FigurePrefs.keywordsColor = getColor(bundleId, PreferenceConstants.KEYWORDS_COLOR);
				else if (prop.startsWith(PreferenceConstants.KEYWORDS_COLOR))
					FigurePrefs.keywordsFont = getFont(bundleId, PreferenceConstants.KEYWORDS_COLOR);

				else if (prop.equals(PreferenceConstants.IDENTIFIERS_COLOR))
					FigurePrefs.identifiersColor = getColor(bundleId, PreferenceConstants.IDENTIFIERS_COLOR);
				else if (prop.startsWith(PreferenceConstants.IDENTIFIERS_COLOR))
					FigurePrefs.identifiersFont = getFont(bundleId, PreferenceConstants.IDENTIFIERS_COLOR);

				else if (prop.equals(PreferenceConstants.LITERALS_COLOR))
					FigurePrefs.literalsColor = getColor(bundleId, PreferenceConstants.LITERALS_COLOR);
				else if (prop.startsWith(PreferenceConstants.LITERALS_COLOR))
					FigurePrefs.literalsFont = getFont(bundleId, PreferenceConstants.LITERALS_COLOR);

				else if (prop.equals(PreferenceConstants.ERRORS_COLOR))
					FigurePrefs.errorsColor = getColor(bundleId, PreferenceConstants.ERRORS_COLOR);
				else if (prop.startsWith(PreferenceConstants.ERRORS_COLOR))
					FigurePrefs.errorsFont = getFont(bundleId, PreferenceConstants.ERRORS_COLOR);

				else if (prop.equals(PreferenceConstants.CONTENT_COLOR))
					FigurePrefs.contentColor = getColor(bundleId, PreferenceConstants.CONTENT_COLOR);
				else if (prop.startsWith(PreferenceConstants.CONTENT_COLOR))
					FigurePrefs.contentFont = getFont(bundleId, PreferenceConstants.CONTENT_COLOR);

				else if (prop.equals(PreferenceConstants.CONTENT_LIGHT_COLOR))
					FigurePrefs.contentLightColor = getColor(bundleId, PreferenceConstants.CONTENT_LIGHT_COLOR);
				else if (prop.startsWith(PreferenceConstants.CONTENT_LIGHT_COLOR))
					FigurePrefs.contentLightFont = getFont(bundleId, PreferenceConstants.CONTENT_LIGHT_COLOR);

				else if (prop.equals(PreferenceConstants.CONTENT_LIGHTER_COLOR))
					FigurePrefs.contentLighterColor = getColor(bundleId, PreferenceConstants.CONTENT_LIGHTER_COLOR);
				else if (prop.startsWith(PreferenceConstants.CONTENT_LIGHTER_COLOR))
					FigurePrefs.contentLighterFont = getFont(bundleId, PreferenceConstants.CONTENT_LIGHTER_COLOR);
				
				eventBroker.post(IUIConstants.TOPIC_REFRESH_VIEWER, null);
			}
		});
	}
}
