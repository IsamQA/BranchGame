import com.example.GameLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLogicTest {

    private GameLogic gameLogic;

    @BeforeEach
    void setUp() {
        gameLogic = new GameLogic();
    }

    @Test
    void testInitialStateIsIntro() {
        // Si el estado actual es null o se elige "restart", debe devolver "intro"
        String result = gameLogic.processChoice(null, "restart");
        assertEquals("intro", result);
    }

    @Test
    void testChoosePathA() {
        // Verifica que al elegir 'pathA', el estado cambie a 'pathA'
        String result = gameLogic.processChoice("intro", "pathA");
        assertEquals("pathA", result);
    }

    @Test
    void testChooseGoodEndingA() {
        // Verifica que al elegir 'GoodEndingA', el estado cambie a 'GoodEndingA'
        String result = gameLogic.processChoice("pathA", "GoodEndingA");
        assertEquals("GoodEndingA", result);
    }

    @Test
    void testChooseBadEndingA() {
        // Verifica que al elegir 'BadEndingA', el estado cambie a 'BadEndingA'
        String result = gameLogic.processChoice("pathA", "BadEndingA");
        assertEquals("BadEndingA", result);
    }

    @Test
    void testChoosePathB() {
        // Verifica que al elegir 'pathB', el estado cambie a 'pathB'
        String result = gameLogic.processChoice("intro", "pathB");
        assertEquals("pathB", result);
    }

    @Test
    void testContinuePathBA() {
        // Verifica que al elegir 'continuePathBA', el estado cambie a 'continuePathBA'
        String result = gameLogic.processChoice("pathB", "continuePathBA");
        assertEquals("continuePathBA", result);
    }

    @Test
    void testNeutralEndingBAA() {
        // Verifica que al elegir 'NeutralEndingBAA', el estado cambie a 'NeutralEndingBAA'
        String result = gameLogic.processChoice("continuePathBA", "NeutralEndingBAA");
        assertEquals("NeutralEndingBAA", result);
    }

    @Test
    void testBadEndingBAB() {
        // Verifica que al elegir 'BadEndingBAB', el estado cambie a 'BadEndingBAB'
        String result = gameLogic.processChoice("continuePathBA", "BadEndingBAB");
        assertEquals("BadEndingBAB", result);
    }

    @Test
    void testContinuePathBB() {
        // Verifica que al elegir 'continuePathBB', el estado cambie a 'continuePathBB'
        String result = gameLogic.processChoice("pathB", "continuePathBB");
        assertEquals("continuePathBB", result);
    }

    @Test
    void testGoodEndingBB() {
        // Verifica que al elegir 'GoodEndingBB', el estado cambie a 'GoodEndingBB'
        String result = gameLogic.processChoice("continuePathBB", "GoodEndingBB");
        assertEquals("GoodEndingBB", result);
    }

    @Test
    void testRestart() {
        // Verifica que al elegir "restart", el estado vuelva a 'intro'
        String result = gameLogic.processChoice("pathA", "restart");
        assertEquals("intro", result);
    }

    @Test
    void testInvalidChoice() {
        // Verifica que al elegir una opción inválida, el estado no cambie
        String result = gameLogic.processChoice("pathA", "invalidChoice");
        assertEquals("pathA", result);
    }

    @Test
    void testNullChoiceDoesNotChangeState() {
        // Verifica que si la elección es null, el estado no cambie
        String result = gameLogic.processChoice("pathB", null);
        assertEquals("pathB", result);
    }

    @Test
    void testNullCurrentState() {
        // Verifica que si el estado actual es null y no se elige "restart", el juego vuelva a 'intro'
        String result = gameLogic.processChoice(null, "pathA");
        assertEquals("intro", result);
    }
}