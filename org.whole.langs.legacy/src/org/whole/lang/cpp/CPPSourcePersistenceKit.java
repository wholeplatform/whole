package org.whole.lang.cpp;

import org.whole.lang.codebase.AbstractSpecificPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.model.IEntity;

public class CPPSourcePersistenceKit extends AbstractSpecificPersistenceKit{
	private static class SingletonHolder {
		private static final CPPSourcePersistenceKit instance = new CPPSourcePersistenceKit();
	}
	public static CPPSourcePersistenceKit instance() {
		return SingletonHolder.instance;
	}
	protected CPPSourcePersistenceKit() {
		super("C++", "cpp", "FIXME");//FIXME CPPLanguageKit.URI);
	}

	@Override
	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
//		String source = StringUtils.readAsString(pp.getInputStream(), pp.getEncoding());
//		FileContent fileContent = FileContent.create("my.ideological,.path", contents)
//
//		Map<String, String> definedSymbols = new HashMap<String, String>();
//		String[] includePaths = new String[0];
//
//		IExtendedScannerInfo scannerInfo = new ExtendedScannerInfo(definedSymbols, includePaths);
//		IParserLogService log = new DefaultLogService();
//
//		IncludeFileContentProvider emptyIncludes = IncludeFileContentProvider.getEmptyFilesProvider();
//
//		int opts = 8;
//		IASTTranslationUnit translationUnit = GPPLanguage.getDefault().getASTTranslationUnit(fileContent, scannerInfo, emptyIncludes, null, opts, log);
//
//		IASTPreprocessorIncludeStatement[] includes = translationUnit.getIncludeDirectives();
//		for (IASTPreprocessorIncludeStatement include : includes) {
//			System.out.println("include - " + include.getName());
//		}
//		
//		return super.doReadModel(pp);
		return null;
	}
}
