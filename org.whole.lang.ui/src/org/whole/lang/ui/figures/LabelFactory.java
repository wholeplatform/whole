/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.ui.util.UIUtils;

public class LabelFactory {
	public static EntityLabel createModuleName() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.modulesColor;
			}
			public Font getLocalFont() {
				return JFaceResources.getHeaderFont();
			}
		};
	}
	public static EntityLabel createModuleName(String name) {
		EntityLabel label = createModuleName();
		label.setText(name);
		return label;
	}

	public static EntityLabel createModuleNamespace() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.modulesColor;
			}	
			public Font getLocalFont() {
				return JFaceResources.getBannerFont();
			}
		};
	}
	public static EntityLabel createModuleNamespace(String name) {
		EntityLabel label = createModuleNamespace();
		label.setText(name);
		return label;
	}

	public static EntityLabel createModule() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.modulesColor;
			}	
			public Font getLocalFont() {
				if (super.getLocalFont() != null)
					return super.getLocalFont();
				return super.getLocalFont();//FIXME init FigurePrefs.modulesFont with super defined font;
			}
		};
	}
	public static EntityLabel createModule(String name) {
		EntityLabel label = createModule();
		label.setText(name);
		return label;
	}

	public static EntityLabel createDeclaration() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.declarationsColor;
			}	
			public Font getLocalFont() {
				return FigurePrefs.declarationsFont;
			}
		};
	}
	public static EntityLabel createDeclaration(String name) {
		EntityLabel label = createDeclaration();
		label.setText(name);
		return label;
	}

	public static EntityLabel createRelation() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.relationsColor;
			}
			public Font getLocalFont() {
				return FigurePrefs.relationsFont;
			}
		};
	}
	public static EntityLabel createRelation(String name) {
		EntityLabel label = createRelation();
		label.setText(name);
		return label;
	}

	public static EntityLabel createKeyword() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.keywordsColor;
			}	
			public Font getLocalFont() {
				return FigurePrefs.keywordsFont;
			}
		};
	}
	public static EntityLabel createKeyword(String name) {
		EntityLabel label = createKeyword();
		label.setText(name);
		return label;
	}

	public static EntityLabel createIdentifier() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.identifiersColor;
			}	
			public Font getLocalFont() {
				return FigurePrefs.identifiersFont;
			}
		};
	}
	public static EntityLabel createIdentifier(String name) {
		EntityLabel label = createIdentifier();
		label.setText(name);
		return label;
	}

	public static EntityLabel createLiteral() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.literalsColor;
			}	
			public Font getLocalFont() {
				return FigurePrefs.literalsFont;
			}
		};
	}
	public static EntityLabel createLiteral(String name) {
		EntityLabel label = createLiteral();
		label.setText(name);
		return label;
	}

	public static EntityLabel createContent() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.contentColor;
			}	
			public Font getLocalFont() {
				return FigurePrefs.contentFont;
			}
		};
	}
	public static EntityLabel createContentDark(String name) {
		EntityLabel label = createContentDark();
		label.setText(name);
		return label;
	}

	public static EntityLabel createContentDark() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.contentDarkColor;
			}	
			public Font getLocalFont() {
				return FigurePrefs.contentDarkFont;
			}
		};
	}
	public static EntityLabel createContent(String name) {
		EntityLabel label = createContent();
		label.setText(name);
		return label;
	}

	public static EntityLabel createContentLight() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.contentLightColor;
			}	
			public Font getLocalFont() {
				return FigurePrefs.contentLightFont;
			}
		};
	}
	public static EntityLabel createContentLight(String name) {
		EntityLabel label = createContentLight();
		label.setText(name);
		return label;
	}

	public static EntityLabel createContentLighter() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.contentLighterColor;
			}	
			public Font getLocalFont() {
				return FigurePrefs.contentLighterFont;
			}
		};
	}
	public static EntityLabel createContentLighter(String name) {
		EntityLabel label = createContentLighter();
		label.setText(name);
		return label;
	}

	public static EntityLabel createContentSmallMath() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.contentColor;
			}	
			public Font getLocalFont() {
				return UIUtils.getOpenSymbolSmallFont();
			}
		};
	}
	public static EntityLabel createContentSmallMath(String name) {
		EntityLabel label = createContentSmallMath();
		label.setText(name);
		return label;
	}

	public static EntityLabel createContentMath() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.contentColor;
			}	
			public Font getLocalFont() {
				return UIUtils.getOpenSymbolFont();
			}
		};
	}
	public static EntityLabel createContentMath(String name) {
		EntityLabel label = createContentMath();
		label.setText(name);
		return label;
	}

	public static EntityLabel createContentMediumMath() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.contentColor;
			}	
			public Font getLocalFont() {
				return UIUtils.getOpenSymbolMediumFont();
			}
		};
	}
	public static EntityLabel createContentMediumMath(String name) {
		EntityLabel label = createContentMediumMath();
		label.setText(name);
		return label;
	}

	public static EntityLabel createContentLargeMath() {
		return new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigurePrefs.contentColor;
			}	
			public Font getLocalFont() {
				return UIUtils.getOpenSymbolLargeFont();
			}
		};
	}
	public static EntityLabel createContentLargeMath(String name) {
		EntityLabel label = createContentLargeMath();
		label.setText(name);
		return label;
	}

	public static EntityLabel createContentLabel(String text) {
		return new EntityLabel(text) {
			public Color getLocalForegroundColor() {
				return FigurePrefs.contentColor;
			}	
//			public Font getLocalFont() {
//				return FigurePrefs.contentFont;
//			}
		};
	}
	public static EntityLabel createContentLabel(String text, Image image) {
		EntityLabel label = createContentLabel(text);
		label.setIcon(image);
		return label;
	}
}
