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
package org.whole.lang.ui.figures;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

public class LabelFactory {
	public static EntityLabel createMonospaceRegular() {
		return new EntityLabel() {
			public Font getLocalFont() {
				return FigureConstants.monospaceFontRegular;
			}
		};
	}
	public static EntityLabel createMonospaceRegular(String text) {
		EntityLabel label = createMonospaceRegular();
		label.setText(text);
		return label;
	}
	public static EntityLabel createMonospaceRegular(String text, Color color) {
		EntityLabel label = createMonospaceRegular();
		label.setText(text);
		label.setForegroundColor(color);
		return label;
	}

	public static EntityLabel createMonospaceSmall() {
		return new EntityLabel() {
			public Font getLocalFont() {
				return FigureConstants.monospaceFontSmall;
			}
		};
	}
	public static EntityLabel createMonospaceSmall(String text) {
		EntityLabel label = createMonospaceSmall();
		label.setText(text);
		return label;
	}
	public static EntityLabel createMonospaceSmall(String text, Color color) {
		EntityLabel label = createMonospaceSmall();
		label.setText(text);
		label.setForegroundColor(color);
		return label;
	}

	public static EntityLabel createMonospaceMedium() {
		return new EntityLabel() {
			public Font getLocalFont() {
				return FigureConstants.monospaceFontMedium;
			}
		};
	}
	public static EntityLabel createMonospaceMedium(String text) {
		EntityLabel label = createMonospaceMedium();
		label.setText(text);
		return label;
	}
	public static EntityLabel createMonospaceMedium(String text, Color color) {
		EntityLabel label = createMonospaceMedium();
		label.setText(text);
		label.setForegroundColor(color);
		return label;
	}

	public static EntityLabel createMonospaceLarge() {
		return new EntityLabel() {
			public Font getLocalFont() {
				return FigureConstants.monospaceFontLarge;
			}
		};
	}
	public static EntityLabel createMonospaceLarge(String text) {
		EntityLabel label = createMonospaceLarge();
		label.setText(text);
		return label;
	}
	public static EntityLabel createMonospaceLarge(String text, Color color) {
		EntityLabel label = createMonospaceLarge();
		label.setText(text);
		label.setForegroundColor(color);
		return label;
	}

	public static EntityLabel createSymbolSmall() {
		return new EntityLabel() {
			public Font getLocalFont() {
				return FigureConstants.symbolFontSmall;
			}
		};
	}
	public static EntityLabel createSymbolSmall(String text) {
		EntityLabel label = createSymbolSmall();
		label.setText(text);
		return label;
	}
	public static EntityLabel createSymbolSmall(String text, Color color) {
		EntityLabel label = createSymbolSmall();
		label.setText(text);
		label.setForegroundColor(color);
		return label;
	}

	public static EntityLabel createSymbolMedium() {
		return new EntityLabel() {
			public Font getLocalFont() {
				return FigureConstants.symbolFontMedium;
			}
		};
	}
	public static EntityLabel createSymbolMedium(String text) {
		EntityLabel label = createSymbolMedium();
		label.setText(text);
		return label;
	}
	public static EntityLabel createSymbolMedium(String text, Color color) {
		EntityLabel label = createSymbolMedium();
		label.setText(text);
		label.setForegroundColor(color);
		return label;
	}

	public static EntityLabel createSymbolLarge() {
		return new EntityLabel() {
			public Font getLocalFont() {
				return FigureConstants.symbolFontLarge;
			}
		};
	}
	public static EntityLabel createSymbolLarge(String text) {
		EntityLabel label = createSymbolLarge();
		label.setText(text);
		return label;
	}
	public static EntityLabel createSymbolLarge(String text, Color color) {
		EntityLabel label = createSymbolLarge();
		label.setText(text);
		label.setForegroundColor(color);
		return label;
	}

	public static EntityLabel createModuleName() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigureConstants.modulesColor;
			}
			public Font getLocalFont() {
				return JFaceResources.getHeaderFont();
			}
		};
	}
	public static EntityLabel createModuleName(String text) {
		EntityLabel label = createModuleName();
		label.setText(text);
		return label;
	}

	public static EntityLabel createModuleNamespace() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigureConstants.modulesColor;
			}	
			public Font getLocalFont() {
				return JFaceResources.getBannerFont();
			}
		};
	}
	public static EntityLabel createModuleNamespace(String text) {
		EntityLabel label = createModuleNamespace();
		label.setText(text);
		return label;
	}

	public static EntityLabel createModule() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigureConstants.modulesColor;
			}	
			public Font getLocalFont() {
				if (super.getLocalFont() != null)
					return super.getLocalFont();
				return super.getLocalFont();//FIXME init FigureConstants.modulesFont with super defined font;
			}
		};
	}
	public static EntityLabel createModule(String text) {
		EntityLabel label = createModule();
		label.setText(text);
		return label;
	}

	public static EntityLabel createDeclaration() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigureConstants.declarationsColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.declarationsFont;
			}
		};
	}
	public static EntityLabel createDeclaration(String text) {
		EntityLabel label = createDeclaration();
		label.setText(text);
		return label;
	}

	public static EntityLabel createRelation() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigureConstants.relationsColor;
			}
			public Font getLocalFont() {
				return FigureConstants.relationsFont;
			}
		};
	}
	public static EntityLabel createRelation(String text) {
		EntityLabel label = createRelation();
		label.setText(text);
		return label;
	}

	public static EntityLabel createKeyword() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigureConstants.keywordsColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.keywordsFont;
			}
		};
	}
	public static EntityLabel createKeyword(String text) {
		EntityLabel label = createKeyword();
		label.setText(text);
		return label;
	}

	public static EntityLabel createIdentifier() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigureConstants.identifiersColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.identifiersFont;
			}
		};
	}
	public static EntityLabel createIdentifier(String text) {
		EntityLabel label = createIdentifier();
		label.setText(text);
		return label;
	}

	public static EntityLabel createLiteral() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigureConstants.literalsColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.literalsFont;
			}
		};
	}
	public static EntityLabel createLiteral(String text) {
		EntityLabel label = createLiteral();
		label.setText(text);
		return label;
	}

	public static EntityLabel createContent() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigureConstants.contentColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.contentFont;
			}
		};
	}
	public static EntityLabel createContentDark(String text) {
		EntityLabel label = createContentDark();
		label.setText(text);
		return label;
	}

	public static EntityLabel createContentDark() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigureConstants.contentDarkColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.contentDarkFont;
			}
		};
	}
	public static EntityLabel createContent(String text) {
		EntityLabel label = createContent();
		label.setText(text);
		return label;
	}

	public static EntityLabel createContentLight() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigureConstants.contentLightColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.contentLightFont;
			}
		};
	}
	public static EntityLabel createContentLight(String text) {
		EntityLabel label = createContentLight();
		label.setText(text);
		return label;
	}

	public static EntityLabel createContentLighter() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigureConstants.contentLighterColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.contentLighterFont;
			}
		};
	}
	public static EntityLabel createContentLighter(String text) {
		EntityLabel label = createContentLighter();
		label.setText(text);
		return label;
	}

	public static EntityLabel createSymbolSmallContent(String text) {
		return new EntityLabel(text) {
			public Color getLocalForegroundColor() {
				return FigureConstants.contentColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.symbolFontSmall;
			}
		};
	}

	public static EntityLabel createSymbolRegularContent(String text) {
		return new EntityLabel(text) {
			public Color getLocalForegroundColor() {
				return FigureConstants.contentColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.symbolFontRegular;
			}
		};
	}

	public static EntityLabel createSymbolMediumContent(String text) {
		return new EntityLabel(text) {
			public Color getLocalForegroundColor() {
				return FigureConstants.contentColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.symbolFontMedium;
			}
		};
	}
	public static EntityLabel createSymbolMediumContentLighter(String text) {
		return new EntityLabel(text) {
			public Color getLocalForegroundColor() {
				return FigureConstants.contentLighterColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.symbolFontMedium;
			}
		};
	}

	public static EntityLabel createSymbolLargeContent(String text) {
		return new EntityLabel(text) {
			public Color getLocalForegroundColor() {
				return FigureConstants.contentColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.symbolFontLarge;
			}
		};
	}

	public static EntityLabel createContentLabel(String text) {
		return new EntityLabel(text) {
			public Color getLocalForegroundColor() {
				return FigureConstants.contentColor;
			}	
//			public Font getLocalFont() {
//				return FigureConstants.contentFont;
//			}
		};
	}
	public static EntityLabel createContentLabel(String text, Image image) {
		EntityLabel label = createContentLabel(text);
		label.setIcon(image);
		return label;
	}

	public static EntityLabel createEmptyLabel() {
		return new EntityLabel();
	}
}
