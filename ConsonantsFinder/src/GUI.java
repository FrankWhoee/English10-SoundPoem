
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;



public class GUI extends javax.swing.JFrame {

    public static ArrayList<word> words = new ArrayList<word>();
    public GUI() {
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
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonStart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        textConsole = new javax.swing.JTextField();

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

        jScrollPane1.setViewportView(jList1);

        textConsole.setEditable(false);
        textConsole.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textConsole.setText("Welcome to Consonants Matcher v1.0.0. Click Start to begin.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(textInput, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textConsole, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGap(48, 48, 48)
                        .addComponent(textConsole, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textInputActionPerformed

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        System.out.println("Calculating...");
        
        
        for(word Word : words){
            Word.calcScore(textInput.getText());
        }
        word[] listWords = new word[words.size()];
        for(int i = 0; i < listWords.length; i++){
            listWords[i] = words.get(i);
        }
        quicksort sort = new quicksort();
        sort.sort(listWords);
        for(word Words : sort.numbers){
            if(Words.score > 0){
                System.out.println("[SCORE]: \"" + Words.word + "\"" + ", score: " + Words.score);
            }
        }
    }//GEN-LAST:event_buttonStartActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textConsole;
    private javax.swing.JTextField textInput;
    // End of variables declaration//GEN-END:variables
}
