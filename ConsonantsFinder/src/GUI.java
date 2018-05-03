
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.DefaultListModel;



public class GUI extends javax.swing.JFrame {

    public static ArrayList<word> words = new ArrayList<word>();
    public GUI() {
        double initTime = System.currentTimeMillis();
        initComponents();
        try{
            String os = System.getProperty("os.name").toLowerCase();
            Path path = Paths.get("src/words.txt");
            System.out.println(path.toAbsolutePath());
            System.out.println(os);
            if(os.indexOf("win") >= 0){
                path = Paths.get("\\src\\words.txt");
            }else if(os.indexOf("mac") >= 0){
                path = Paths.get("src/words.txt");
            }else if(os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0){
                path = Paths.get("src/words.txt");
            }else if(os.indexOf("sunos") >= 0){
                path = Paths.get("src/words.txt");
            }

            try (Scanner scanner =  new Scanner(path)){
              System.out.println("Scanning dictionary...");
              double wordNum = 0;
              double size = 466544;
              while (scanner.hasNextLine()){
                String word = scanner.nextLine();
                words.add(new word(word,0));
                wordNum++;
                int progress = (int)(wordNum * 100/size);
                System.out.println("[IMPORT] PROGRESS [" + progress + "%] " + (int)wordNum + "/" + (int)size);
              }
              //scanner.close();
            }
           
        }catch(Exception e){
            
        }
        double endTime = System.currentTimeMillis();
        labelBootTime.setText("Boot Time: " + ((endTime - initTime)/1000) + "s");     
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonStart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayList = new javax.swing.JList<>();
        textConsole1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        labelBootTime = new javax.swing.JLabel();
        labelCalcTime = new javax.swing.JLabel();
        labelAverageScore = new javax.swing.JLabel();
        labelHighestScore = new javax.swing.JLabel();
        labelViableWords = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("English 10H - Consonants Matcher");

        buttonStart.setText("Start");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        jLabel2.setText("Enter your word/name here:");

        textInput.setText("Your word/name...");
        textInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textInputActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(displayList);

        textConsole1.setEditable(false);
        textConsole1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textConsole1.setText("Welcome to Consonants Matcher v1.0.0. Enter your name and click start to begin.");
        textConsole1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textConsole1ActionPerformed(evt);
            }
        });

        jLabel3.setText("STATISTICS:");

        labelBootTime.setText("Boot Time:");

        labelCalcTime.setText("Calculation Time:");

        labelAverageScore.setText("Average Score:");

        labelHighestScore.setText("Highest Score:");

        labelViableWords.setText("Number of Viable Words: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textConsole1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(textInput, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(labelBootTime)
                            .addComponent(labelCalcTime)
                            .addComponent(labelAverageScore)
                            .addComponent(labelHighestScore)
                            .addComponent(labelViableWords))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textInput, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelBootTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCalcTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAverageScore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelHighestScore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelViableWords)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(textConsole1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textInputActionPerformed
        textInput.setText("");
    }//GEN-LAST:event_textInputActionPerformed

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        System.out.println("Calculating...");
        double initTime = System.currentTimeMillis();
        for(word Word : words){
            Word.calcScore(textInput.getText());
        }
        word[] listWords = new word[words.size()];
        for(int i = 0; i < listWords.length; i++){
            listWords[i] = words.get(i);
        }
        quicksort sort = new quicksort();
        sort.sort(listWords);
        //for(word Words : sort.numbers){
            //if(Words.score > 0){
                //System.out.println("[SCORE]: \"" + Words.word + "\"" + ", score: " + Words.score);
            //}
        //}
        
        String[] convert = new String[sort.numbers.length];
        double average = 0;
        
        for(int i = 0; i < sort.numbers.length; i++){
            convert[i] = sort.numbers[i].word;
            average += sort.numbers[i].score;
        }
        List<String> display = Arrays.asList(convert);
        //Collections.reverse(display);
        average = average/sort.numbers.length;
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < display.size(); i++)
        {
            listModel.addElement(display.get(i));
        }
        displayList.setModel(listModel);
        
        double endTime = System.currentTimeMillis();
        labelCalcTime.setText("Calculation Time: " + ((endTime - initTime)/1000) + "s");
        labelAverageScore.setText("Average Score: " + average);  
    }//GEN-LAST:event_buttonStartActionPerformed

    private void textConsole1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textConsole1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textConsole1ActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStart;
    private javax.swing.JList<String> displayList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAverageScore;
    private javax.swing.JLabel labelBootTime;
    private javax.swing.JLabel labelCalcTime;
    private javax.swing.JLabel labelHighestScore;
    private javax.swing.JLabel labelViableWords;
    private javax.swing.JTextField textConsole1;
    private javax.swing.JTextField textInput;
    // End of variables declaration//GEN-END:variables
}
