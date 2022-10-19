import javax.swing.*;
public class Contador extends Thread{
    JLabel lastPrice;

    public void refrescarPrice(JLabel lastPrice, int lastPremio){

        this.lastPrice = lastPrice;

        for (int i = 0; i < lastPremio; i++){
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.lastPrice.setText(String.valueOf(Integer.parseInt(this.lastPrice.getText())+1));
        }
    }
}