package org.whole.lang.editors.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class EditorsImplEntityRegistry extends AbstractEntityRegistry {
	public EditorsImplEntityRegistry() {
		super(EditorsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new EditorImpl());
		put(new ModelComponentImpl());
		put(new ControllerComponentImpl());
		put(new ControllerDeclarationsImpl());
		put(new PartDeclarationImpl());
		put(new JavaPartDeclarationImpl());
		put(new GenericPartDeclarationImpl());
		put(new EntityFeaturesImpl());
		put(new GenericPartNameImpl());
		put(new ViewComponentImpl());
		put(new ViewDeclarationsImpl());
		put(new SimpleFigureDeclarationImpl());
		put(new FoldableTextualFigureImpl());
		put(new TextualFigureImpl());
		put(new RowImpl());
		put(new ChildPlaceImpl());
		put(new IndentImpl());
		put(new FoldingToggleImpl());
		put(new KeywordTokenImpl());
		put(new LiteralTokenImpl());
		put(new IdentifierTokenImpl());
		put(new OperatorTokenImpl());
		put(new DelimiterTokenImpl());
		put(new ParenthesisTokenImpl());
		put(new EntityNamesImpl());
		put(new IdentifierImpl());
	}
}
