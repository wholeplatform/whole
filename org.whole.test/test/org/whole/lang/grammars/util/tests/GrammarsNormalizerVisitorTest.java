package org.whole.lang.grammars.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class GrammarsNormalizerVisitorTest extends TestCase {

    protected static IEntity create(String templateName) {
        return GrammarsNormalizerVisitorTestTemplateManager.instance().create(templateName);
    }

    protected static IEntity evaluate(String templateName) {
        return evaluate(create(templateName));
    }

    /**
     *
     */
    @Test
    public void testNormalizationRules() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment");
        assertThat("at /testCases/0/tests/0/body/0", subject, matches(create("fragment1")));
        subject = evaluate("fragment2");
        assertThat("at /testCases/0/tests/0/body/1", subject, matches(create("fragment3")));
        subject = evaluate("fragment4");
        assertThat("at /testCases/0/tests/0/body/2", subject, matches(create("fragment5")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testNormalizeTestGrammar1() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment6");
        assertThat("at /testCases/0/tests/1/body/0", subject, matches(create("fragment7")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testNormalizeDataTypesGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment8");
        assertThat("at /testCases/0/tests/2/body/0", subject, matches(create("fragment9")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testNormalizeMessagesGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment10");
        assertThat("at /testCases/0/tests/3/body/0", subject, matches(create("fragment11")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testNormalizeStateMachineGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment12");
        assertThat("at /testCases/0/tests/4/body/0", subject, matches(create("fragment13")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testNormalizeStateMachine2Grammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment14");
        assertThat("at /testCases/0/tests/5/body/0", subject, matches(create("fragment15")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testNormalizeFamilyGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment16");
        assertThat("at /testCases/0/tests/6/body/0", subject, matches(create("fragment17")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testNormalizeMT3Grammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment18");
        assertThat("at /testCases/0/tests/7/body/0", subject, matches(create("fragment19")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testNormalizeXmlGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment20");
        assertThat("at /testCases/0/tests/8/body/0", subject, matches(create("fragment21")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testNormalizeDTAUSGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment22");
        assertThat("at /testCases/0/tests/9/body/0", subject, matches(create("fragment23")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testNormalizeMotoGPCSVGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment24");
        assertThat("at /testCases/0/tests/10/body/0", subject, matches(create("fragment25")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testNormalizeMotoGPFLFGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment26");
        assertThat("at /testCases/0/tests/11/body/0", subject, matches(create("fragment27")));
        bindings().wExitScope();
    }
}
