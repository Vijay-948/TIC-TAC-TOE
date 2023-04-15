import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title = new JPanel();
    JPanel button = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1;


    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);
        frame.getContentPane().setBackground(new Color(45,50,250, 20));
        frame.setVisible(true);

        textField.setBackground(new Color(25,25,25));
        textField.setForeground((new Color(245,250,20)));
        textField.setFont(new Font("Times-Bold", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("TIC-TAC-TOE");
        textField.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0,0,800,100);

        button.setLayout(new GridLayout(3,3));
        button.setBackground(new Color(25,45,90,205));

        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            button.add(buttons[i]);
            buttons[i].setFont(new Font("Calligrapher", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        title.add(textField);
        frame.add(title, BorderLayout.NORTH);
        frame.add(button);


        firstPlayerTurn();

        

    }


    @Override
    public void actionPerformed(ActionEvent e) {
          for(int i = 0; i < 9; i++){
              if(e.getSource() == buttons[i]){
                  if(player1){
                      if(buttons[i].getText()==""){
                          buttons[i].setForeground(new Color(200, 100, 105));
                          buttons[i].setText("X");
                          player1=false;
                          textField.setText("O Turn");
                          check();

                      }
                  }else{
                      if(buttons[i].getText()==""){
                          buttons[i].setForeground(new Color(90,190,90));
                          buttons[i].setText("O");
                          player1=true;
                          textField.setText("X Turn");
                          check();
                      }

                  }
              }
          }

    }

    public void firstPlayerTurn(){

        try{
            Thread.sleep(1000);

        }catch (InterruptedException exception){
            exception.printStackTrace();
        }
        if(random.nextInt(2) == 0){
            player1=true;
            textField.setText("X Turn");
        }else{
            player1=false;
            textField.setText("O Turn");
        }

    }

    public void check(){
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")){
            XPlayerWins(0,1,2);
        }
        if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")){
            XPlayerWins(3,4,5);
        }
        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")){
            XPlayerWins(6,7,8);
        }

        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[8].getText()=="X")){
            XPlayerWins(0,3,8);
        }
        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")){
            XPlayerWins(1,4,7);
        }
        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")){
            XPlayerWins(2,5,8);
        }
        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")){
            XPlayerWins(0,4,8);
        }
        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")){
            XPlayerWins(2,4,6);
        }


        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")){
            OPlayerWins(0,1,2);
        }
        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")){
            OPlayerWins(3,4,5);
        }
        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")){
            OPlayerWins(6,7,8);
        }

        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[8].getText()=="O")){
            OPlayerWins(0,3,8);
        }
        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")){
            OPlayerWins(1,4,7);
        }
        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")){
            OPlayerWins(2,5,8);
        }
        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")){
            OPlayerWins(0,4,8);
        }
        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")){
            OPlayerWins(2,4,6);
        }



    }

    public void XPlayerWins(int a, int b, int c){
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);
        buttons[c].setBackground(Color.RED);

        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled((false));
        }

        textField.setText("X Player Won");

    }

    public void OPlayerWins(int a, int b, int c){
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);
        buttons[c].setBackground(Color.RED);

        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled((false));
        }

        textField.setText("O Player Won");

    }
}
