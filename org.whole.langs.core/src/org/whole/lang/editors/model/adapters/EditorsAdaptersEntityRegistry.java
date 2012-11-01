package org.whole.lang.editors.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class EditorsAdaptersEntityRegistry extends AbstractEntityRegistry {
	public EditorsAdaptersEntityRegistry() {
		super(EditorsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new EditorAdapter());
		put(new ModelComponentAdapter());
		put(new ControllerComponentAdapter());
		put(new ControllerDeclarationsAdapter());
		put(new PartDeclarationAdapter());
		put(new JavaPartDeclarationAdapter());
		put(new GenericPartDeclarationAdapter());
		put(new EntityFeaturesAdapter());
		put(new GenericPartNameAdapter());
		put(new ViewComponentAdapter());
		put(new ViewDeclarationsAdapter());
		put(new SimpleFigureDeclarationAdapter());
		put(new FoldableTextualFigureAdapter());
		put(new TextualFigureAdapter());
		put(new RowAdapter());
		put(new ChildPlaceAdapter());
		put(new IndentAdapter());
		put(new FoldingToggleAdapter());
		put(new KeywordTokenAdapter());
		put(new LiteralTokenAdapter());
		put(new IdentifierTokenAdapter());
		put(new OperatorTokenAdapter());
		put(new DelimiterTokenAdapter());
		put(new ParenthesisTokenAdapter());
		put(new EntityNamesAdapter());
		put(new IdentifierAdapter());
		put(new EntityNameAdapter());
		put(new EditorNameAdapter());
		put(new FigureNameAdapter());
		put(new ViewDeclarationAdapter());
		put(new ModelNameAdapter());
		put(new ControllerDeclarationAdapter());
		put(new FeatureNameAdapter());
		put(new PartNameAdapter());
		put(new FigureBodyAdapter());
		put(new RowElementAdapter());
	}
}
