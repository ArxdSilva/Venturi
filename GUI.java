import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
Botao botao1 = new Botao();

public GUI(){
        botao1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        botao1.setSize(350,80);
        botao1.setVisible(true);
}

public static void main(String[] args) {
        new GUI();
}
}
