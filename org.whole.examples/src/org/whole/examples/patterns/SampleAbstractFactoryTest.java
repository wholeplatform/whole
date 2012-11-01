package org.whole.examples.patterns;


import org.junit.Test;
import org.whole.examples.patterns.source.Expression;
import org.whole.examples.patterns.source.SampleAbstractFactory;
import org.whole.examples.patterns.source.Statement;

public class SampleAbstractFactoryTest {
	private static SampleAbstractFactory createSampleAbstractFactory() {
		try {
			Class<?> factoryClass = Class.forName("org.whole.examples.patterns.source.impl.SampleAbstractFactoryImpl");
			return (SampleAbstractFactory) factoryClass.getMethod("instance", new Class<?>[0]).invoke(null, new Object[0]);
		} catch (Exception e) {
			throw new IllegalStateException("cannot istantiate factory", e);
		}
	}
	
	@Test
	public void testSampleAbstractFactory() {
		SampleAbstractFactory lf = createSampleAbstractFactory();

		fact(lf);
	}

	public static void fact(SampleAbstractFactory lf) {
		Expression n = lf.createVariable("n");
		Expression result = lf.createVariable("result");

		@SuppressWarnings("unused")
		Statement fatt = lf.createBlock(new Statement[] {
				lf.createAssignment(n, lf.createIntLiteral(4)),
				lf.createAssignment(result, lf.createIntLiteral(1)),
				lf.createWhile(lf.createGreaterThan(n, lf.createIntLiteral(0)), lf.createBlock(new Statement[] {
						lf.createAssignment(result, lf.createMultiplication(result, n)),
						lf.createAssignment(n,lf.createSubtraction(n, lf.createIntLiteral(1)))
				}))
		});
	}
}
