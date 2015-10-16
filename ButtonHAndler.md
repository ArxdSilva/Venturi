import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.lang.*;

public class ButtonHandler implements ActionListener {
    private JButton iniciar, parar, resetar;
    
    ScheduledFuture<?> result;
    
    int counter = 0;
    
    boolean isAlive = false;
    
    public ButtonHandler(JButton iniciar, JButton parar, JButton resetar){
        this.iniciar = iniciar;
        this.parar = parar;
        this.resetar = resetar;
    }

    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == iniciar) {
               
               if (isAlive != true ){
                   initCounter();
               isAlive = true;
            }
            else {System.out.println("Ele já está rodando");
        }   
    }
        
        if (evento.getSource() == parar) {
            if (isAlive == true) {
                stopCounter();
                isAlive = false;            }
        }

        if (evento.getSource() == resetar) {
             if (isAlive == true) {
             resetCounter();
            }
            else {
            resetCounter2();
            }
                    }
    }
    
    public void initCounter() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                incrementCounter();
                System.out.println(counter);
            }
          };
          
          ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
          result = service.scheduleWithFixedDelay(runnable, 0, 1, TimeUnit.SECONDS);
    }
    
    public void stopCounter() {
        result.cancel(true);
        System.out.println("Contador parado em " + counter);
    }
    
    public void resetCounter() {
        result.cancel(true);
        System.out.println("Contador resetado em " + counter);
        counter = 0;
        
        initCounter();
    }
    
    public void resetCounter2() {
        result.cancel(true);
        System.out.println("Contador resetado em " + counter);
        counter = 0;
           }
    
    public void incrementCounter() {
        counter++;
    }
}
