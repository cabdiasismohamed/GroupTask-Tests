import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuPanelAppTest {

    private MenuPanelApp app;

    @BeforeEach
    void setUp() {
        app = new MenuPanelApp();
    }

    @Test
    void testAppInitialization() {
        assertNotNull(app.frame, "Frame should not be null");
        assertEquals("Swing Application with Panels & Menu", app.frame.getTitle(), "Frame title should match");

        assertNotNull(app.main, "Main panel should not be null");
        assertTrue(app.main.getLayout() instanceof java.awt.CardLayout, "Main panel should use CardLayout");

        assertEquals(3, app.main.getComponentCount(), "Main panel should contain 3 cards");
    }
}
