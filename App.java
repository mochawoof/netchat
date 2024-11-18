import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class App extends JFrame {
    static {
        JFrame.setDefaultLookAndFeelDecorated(true);
                
        // Set Nimbus look and feel
        try {
            for (UIManager.LookAndFeelInfo lafInfo : UIManager.getInstalledLookAndFeels()) {
                if (lafInfo.getName().contains("Nimbus")) {
                    UIManager.setLookAndFeel(lafInfo.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public App() {
        setTitle("NetChat");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JTabbedPane tabPane = new JTabbedPane();
        
        add(tabPane, BorderLayout.CENTER);
        
        JLabel statusLabel = new JLabel("Connecting...");
        statusLabel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        add(statusLabel, BorderLayout.PAGE_END);
        
        setVisible(true);
    }
}