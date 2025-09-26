import org.testng.annotations.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class MenuPanelAppIT {

    private static MenuPanelApp app;

    @BeforeClass
    public static void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> app = new MenuPanelApp());
    }

    @Test
    public void testFrameInitialization() {
        assertNotNull("Frame should not be null", app.frame);
        assertEquals("Swing Application with Panels & Menu", app.frame.getTitle());
        assertTrue("Frame should be visible", app.frame.isVisible());
    }

    @Test
    public void testMenuInitialization() {
        JMenuBar menuBar = app.frame.getJMenuBar();
        assertNotNull("Menu bar should not be null", menuBar);
        assertEquals("There should be 2 menus (Navigate, File)", 2, menuBar.getMenuCount());

        JMenu navigateMenu = menuBar.getMenu(0);
        assertEquals("Navigate", navigateMenu.getText());
        assertEquals("Navigate should have 3 items", 3, navigateMenu.getItemCount());

        JMenu fileMenu = menuBar.getMenu(1);
        assertEquals("File", fileMenu.getText());
        assertEquals("File should have 1 item", 1, fileMenu.getItemCount());
    }

    @Test
    public void testCardLayoutInitialization() {
        assertNotNull("CardLayout should not be null", app.card);
        assertNotNull("Main panel should not be null", app.main);
        assertEquals("Main should contain 3 panels", 3, app.main.getComponentCount());
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

    @AfterClass
    public static void tearDown() {
        if (app.frame != null) {
            app.frame.dispose();
        }
    }
}
