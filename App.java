import javax.swing.*;
import javax.swing.event.*;
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
    
    private JTabbedPane tabPane;
    
    private void addChannel(String name) {
        name = name.toLowerCase();
        
        JScrollPane pPane = new JScrollPane();
        pPane.getVerticalScrollBar().setUnitIncrement(15);
        tabPane.addTab("#" + name, pPane);
        
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        pPane.setViewportView(p);
        
        for (int i = 0; i < 20; i++) {
            HTMLButton l = new HTMLButton("Hi guoys " + i);
            l.setHorizontalAlignment(SwingConstants.LEFT);
            
            l.setIcon(new ImageIcon(IdenticonGenerator.create("127.0.0.1", 20)));
            p.add(l);
        }
        
        if (tabPane.indexOfTab("+") != -1) {
            tabPane.removeTabAt(tabPane.indexOfTab("+"));
        }
        tabPane.addTab("+", null);
    }
    
    public App() {
        setTitle("NetChat");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(Resources.getAsImage("res/icon.png"));
        setLayout(new BorderLayout());
        
        tabPane = new JTabbedPane();
        add(tabPane, BorderLayout.CENTER);
        tabPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int i = tabPane.getSelectedIndex();
                
                if (tabPane.getTitleAt(i) == "+") {
                    tabPane.setSelectedIndex(0);
                }
            }
        });
        
        addChannel("general");
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        add(bottomPanel, BorderLayout.PAGE_END);
        
        JButton meButton = new JButton();
        meButton.setIcon(new ImageIcon(IdenticonGenerator.create("127.0.0.1", 20)));
        bottomPanel.add(meButton, BorderLayout.LINE_START);
        
        JTextField msgField = new JTextField();
        bottomPanel.add(msgField, BorderLayout.CENTER);
        
        JButton sendButton = new JButton("Send");
        bottomPanel.add(sendButton, BorderLayout.LINE_END);
        
        setVisible(true);
    }
}