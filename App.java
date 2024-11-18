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
        
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        tabPane.addTab("#p", p);
        
        JButton l = new JButton("<html><b>Julian (9:25 AM)</b> Hi guoys</html>");
        l.setHorizontalAlignment(SwingConstants.LEFT);
        
        l.setIcon(new ImageIcon(IdenticonGenerator.create("Julian", 20)));
        p.add(l);
        
        add(tabPane, BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        add(bottomPanel, BorderLayout.PAGE_END);
        
        JButton meButton = new JButton();
        meButton.setIcon(new ImageIcon(IdenticonGenerator.create("Julian", 20)));
        bottomPanel.add(meButton, BorderLayout.LINE_START);
        
        JTextField msgField = new JTextField();
        bottomPanel.add(msgField, BorderLayout.CENTER);
        
        
        
        JLabel statusLabel = new JLabel("Connecting...");
        statusLabel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        bottomPanel.add(statusLabel, BorderLayout.PAGE_END);
        
        setVisible(true);
    }
}