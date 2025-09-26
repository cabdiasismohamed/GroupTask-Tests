import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class MenuPanelAppIT {

    private static MenuPanelApp app;

    @BeforeAll
    public static void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> app = new MenuPanelApp());
    }

    @Test
    public void testFrameInitialization() {
        assertNotNull(app.frame, "Frame should not be null");
        assertEquals("Swing Application with Panels & Menu", app.frame.getTitle());
        assertTrue(app.frame.isVisible(), "Frame should be visible");
    }

    @Test
    public void testMenuInitialization() {
        JMenuBar menuBar = app.frame.getJMenuBar();
        assertNotNull(menuBar, "Menu bar should not be null");
        assertEquals(2, menuBar.getMenuCount(), "There should be 2 menus (Navigate, File)");

        JMenu navigateMenu = menuBar.getMenu(0);
        assertEquals("Navigate", navigateMenu.getText());
        assertEquals(3, navigateMenu.getItemCount(), "Navigate should have 3 items");

        JMenu fileMenu = menuBar.getMenu(1);
        assertEquals("File", fileMenu.getText());
        assertEquals(1, fileMenu.getItemCount(), "File should have 1 item");
    }

    @Test
    public void testCardLayoutInitialization() {
        assertNotNull(app.card, "CardLayout should not be null");
        assertNotNull(app.main, "Main panel should not be null");
        assertEquals(3, app.main.getComponentCount(), "Main should contain 3 panels");
    }

    @Test
    public void testHomePanelSwitch() throws Exception {
        SwingUtilities.invokeAndWait(() -> app.card.show(app.main, "Home"));
        assertEquals("Home", getVisibleCard());
    }

    @Test
    public void testProfileAndSettingsPanelSwitch() throws Exception {
        SwingUtilities.invokeAndWait(() -> app.card.show(app.main, "Profile"));
        assertEquals("Profile", getVisibleCard());

        SwingUtilities.invokeAndWait(() -> app.card.show(app.main, "Settings"));
        assertEquals("Settings", getVisibleCard());
    }

    private String getVisibleCard() {
        Component[] components = app.main.getComponents();
        if (components[0].isVisible()) return "Home";
        if (components[1].isVisible()) return "Profile";
        if (components[2].isVisible()) return "Settings";
        return null;
    }

    @AfterAll
    public static void tearDown() {
        if (app.frame != null) {
            app.frame.dispose();
        }
    }
}
