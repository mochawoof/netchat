import javax.swing.JButton;

class HTMLButton extends JButton {
    public HTMLButton(String text) {
        setText(text);
    }
    
    public HTMLButton() {
        this("");
    }
    
    @Override
    public void setText(String text) {
        super.setText("<html>" + text + "</html>");
    }
}