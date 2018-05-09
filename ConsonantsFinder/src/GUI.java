
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import sun.misc.IOUtils;
//import org.json.*;
import com.google.gson.*;



public class GUI extends javax.swing.JFrame {

    boolean isImported = false;
    String textIdeal = "";
    String json = "";
    boolean isDictImported = false;
    
    public static ArrayList<word> words = new ArrayList<word>();
    public GUI() {
        Ref.RefInit();
        initComponents();
        
             
    }
    
    public void importDict() throws Exception{
        if(isDictImported){
            return;
        }
        CodeSource codeSource = GUI.class.getProtectionDomain().getCodeSource();
        File jarFile = new File("");
        try {
            jarFile = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        String jarDir = jarFile.getParentFile().getPath();
        
        System.out.println(jarDir);
        double initTime = System.currentTimeMillis();
        String os = System.getProperty("os.name").toLowerCase();
        Path path = Paths.get(jarDir + "src/dictionary.json");
        if(os.indexOf("win") >= 0){
            path = Paths.get(jarDir + "\\src\\dictionary.json");
        }else if(os.indexOf("mac") >= 0){
            path = Paths.get(jarDir + "/src/dictionary.json");
        }else if(os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0){
            path = Paths.get(jarDir + "/src/dictionary.json");
        }else if(os.indexOf("sunos") >= 0){
            path = Paths.get(jarDir + "/src/dictionary.json");
        }
        try (Scanner scanner =  new Scanner(path)){
              System.out.println("Scanning definitions...");
              while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                json += line;
              }
              System.out.write(("\nIMPORT COMPLETE [100%]\n").getBytes());
              //scanner.close();
            }
        isDictImported = true;
        
    }
    
    public String getDefinition(String word){
        try{
            importDict();
        }catch(Exception e){e.printStackTrace();}
	JsonObject entireJSON = new JsonParser().parse(json).getAsJsonObject();  
        String definition = "";   
        try{
            definition = entireJSON.get(word.toUpperCase()).getAsString();
            
        }catch(Exception e){
            e.printStackTrace();
            definition = "\"" + word + "\" does not exist.";
        }
        return definition;
    }
    
    public void importWords(){
        if(isImported){
            return;
        }
        CodeSource codeSource = GUI.class.getProtectionDomain().getCodeSource();
        File jarFile = new File("");
        try {
            jarFile = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        String jarDir = jarFile.getParentFile().getPath();
        
        System.out.println(jarDir);
        double initTime = System.currentTimeMillis();
        try{
            String os = System.getProperty("os.name").toLowerCase();
            Path path = Paths.get(jarDir + "src/words.txt");
            System.out.println("RUNNING " + os.toUpperCase());
            if(os.indexOf("win") >= 0){
                path = Paths.get(jarDir + "\\src\\words.txt");
            }else if(os.indexOf("mac") >= 0){
                path = Paths.get(jarDir + "/src/words.txt");
            }else if(os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0){
                path = Paths.get(jarDir + "/src/words.txt");
            }else if(os.indexOf("sunos") >= 0){
                path = Paths.get(jarDir + "/src/words.txt");
            }
            textPath.setText("" + path.toAbsolutePath());
            try (Scanner scanner =  new Scanner(path)){
              System.out.println("Scanning dictionary...");
              double wordNum = 0;
              double size = 466544;
              double prevProg = 0;
              while (scanner.hasNextLine()){
                String word = scanner.nextLine();
                words.add(new word(word,0));
                wordNum++;
                int progress = (int)(wordNum * 100/size);
                String bar = "";
                
                if(progress != prevProg){    
                    for(int i =0; i < (wordNum/40000) - 1; i++){
                        bar += "=";
                    }
                    for(int i =0; i < ((size - wordNum)/40000) - 1; i++){
                        bar += "-";
                    }
                    System.out.write(("[IMPORT] PROGRESS " + progress + "%[" + bar + "]" + (int)wordNum + "/" + (int)size + "\r").getBytes()); 
                    Thread.sleep(10);
                }
                prevProg = progress;
              }
              System.out.write(("\nIMPORT COMPLETE [100%]\n").getBytes());
              //scanner.close();
            }
           
        }catch(Exception e){
            
        }
        double endTime = System.currentTimeMillis();
        labelImportTime.setText("Import Time: " + ((endTime - initTime)/1000) + "s");
        isImported = true;
        
        textConsole1.setText("Words imported.");
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
        labelImportTime = new javax.swing.JLabel();
        labelCalcTime = new javax.swing.JLabel();
        labelAverageScore = new javax.swing.JLabel();
        labelHighestScore = new javax.swing.JLabel();
        labelViableWords = new javax.swing.JLabel();
        textScore = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        labelIdeal = new javax.swing.JLabel();
        textScoreWord = new javax.swing.JLabel();
        buttonPath = new javax.swing.JButton();
        textPath = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textTest = new javax.swing.JTextField();
        buttonTest = new javax.swing.JButton();
        textTestResult = new javax.swing.JTextField();
        buttonSetIdeal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textDict = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        textDef = new javax.swing.JTextField();
        buttonDef = new javax.swing.JButton();

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
        textInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textInputMouseClicked(evt);
            }
        });
        textInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textInputActionPerformed(evt);
            }
        });

        displayList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayListMouseClicked(evt);
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

        labelImportTime.setText("Import Time:");

        labelCalcTime.setText("Calculation Time:");

        labelAverageScore.setText("Average Score:");

        labelHighestScore.setText("Highest Score:");

        labelViableWords.setText("Number of Viable Words: ");

        textScore.setText("0");
        textScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textScoreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Scoring:");

        labelIdeal.setText("Ideal String:");

        textScoreWord.setText("Word:");

        buttonPath.setText("Get Path");
        buttonPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPathActionPerformed(evt);
            }
        });

        textPath.setText(".");

        jLabel5.setText("Calculate a word's score:");

        textTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTestActionPerformed(evt);
            }
        });

        buttonTest.setText("Calculate");
        buttonTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTestActionPerformed(evt);
            }
        });

        textTestResult.setText("0");

        buttonSetIdeal.setText("Set Ideal String");
        buttonSetIdeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSetIdealActionPerformed(evt);
            }
        });

        textDict.setColumns(20);
        textDict.setRows(5);
        jScrollPane2.setViewportView(textDict);

        jLabel6.setText("Define a word:");

        textDef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDefActionPerformed(evt);
            }
        });

        buttonDef.setText("Define");
        buttonDef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDefActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textConsole1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textInput, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buttonSetIdeal)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(59, 59, 59))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textTest, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(buttonTest)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textTestResult, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel5))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textScore, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textScoreWord)))))
                        .addComponent(labelViableWords)
                        .addComponent(labelHighestScore)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelImportTime)
                                .addComponent(labelCalcTime)
                                .addComponent(labelAverageScore)
                                .addComponent(labelIdeal)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textDef)
                                .addComponent(buttonDef, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(textPath, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textScoreWord)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textInput, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonSetIdeal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(buttonTest)
                                    .addComponent(textTestResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPath, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(buttonPath)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelIdeal)
                                .addGap(3, 3, 3)
                                .addComponent(labelImportTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCalcTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelAverageScore))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDef)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelHighestScore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelViableWords)
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textConsole1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textInputActionPerformed
        
    }//GEN-LAST:event_textInputActionPerformed

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        textIdeal = textInput.getText();
        labelIdeal.setText(textIdeal);
        importWords();
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
        String[] convert = new String[sort.numbers.length];
        
        double average = 0;
        double highestScore = 0;
        int viableWords = 0;
        for(int i = 0; i < sort.numbers.length; i++){
            convert[i] = sort.numbers[i].word;
            if(sort.numbers[i].score > highestScore){
                highestScore = sort.numbers[i].score;
            }
            if(sort.numbers[i].score > 0){
                viableWords++;
            }
            average += sort.numbers[i].score;
        }
        List<String> display = Arrays.asList(convert);
        Collections.reverse(display);
        average = average/sort.numbers.length;
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < display.size(); i++)
        {
            listModel.addElement(display.get(i));
        }
        displayList.setModel(listModel);
        
        double endTime = System.currentTimeMillis();
        System.out.println("CALCULATION COMPLETE.");
        System.out.println("--------------------PRINTING STATISTICS--------------------");
        System.out.println("CALCULATION TIME: " + (endTime - initTime)/1000 + "s");
        System.out.println("AVG SCORE: " + average);
        System.out.println("HI-SCORE: " + highestScore);
        System.out.println("NUM OF VIABLE WORDS: " + viableWords);
        
        labelCalcTime.setText("Calculation Time: " + ((endTime - initTime)/1000) + "s");
        labelAverageScore.setText("Average Score: " + Double.toString(average).substring(0,5));  
        labelHighestScore.setText("Highest Score: " + highestScore);
        labelViableWords.setText("Number of Viable Words: " + viableWords);  
    }//GEN-LAST:event_buttonStartActionPerformed

    private void textConsole1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textConsole1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textConsole1ActionPerformed

    private void textInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textInputMouseClicked
        textInput.setText("");
    }//GEN-LAST:event_textInputMouseClicked

    private void displayListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayListMouseClicked
        String selected = displayList.getSelectedValue();
        String definition = getDefinition(selected);
        definition = fitString(definition);
        word W = new word(selected,0);
        W.calcScore(textIdeal);
        textScore.setText("" + W.score);
        textScoreWord.setText("Word: " + W.word);
        textDict.setText(definition);
    }//GEN-LAST:event_displayListMouseClicked

    private void textScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textScoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textScoreActionPerformed

    private void buttonPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPathActionPerformed
        CodeSource codeSource = GUI.class.getProtectionDomain().getCodeSource();
        File jarFile = new File("");
        try {
            jarFile = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        String jarDir = jarFile.getParentFile().getPath();
        textPath.setText(jarDir);
    }//GEN-LAST:event_buttonPathActionPerformed

    private void textTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTestActionPerformed

    private void buttonTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTestActionPerformed
        if(textIdeal.equals("")){
            textConsole1.setText("Ideal string not set. Type in word in input box and click \"Set Ideal String\"");
            return;
        } 
        String input = textTest.getText();
        word w = new word(input,0);
        w.calcScore(textIdeal);
        textTestResult.setText("" + (int)w.score);
        
    }//GEN-LAST:event_buttonTestActionPerformed

    private void buttonSetIdealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSetIdealActionPerformed
        textIdeal = textInput.getText();
        labelIdeal.setText("Ideal String: " + textIdeal);
    }//GEN-LAST:event_buttonSetIdealActionPerformed

    private void textDefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDefActionPerformed

    private void buttonDefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDefActionPerformed
        String definition = getDefinition(textDef.getText());
        definition = fitString(definition);
        textDict.setText(definition);
    }//GEN-LAST:event_buttonDefActionPerformed

    public String fitString(String input){
        String output = input;
        for(int i = 0; i < output.length(); i++){
            if(i % 110 == 0 && i != 0){
                output = output.substring(0,i) + "\n " + output.substring(i);
            }
        } 
        return output;
    }
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDef;
    private javax.swing.JButton buttonPath;
    private javax.swing.JButton buttonSetIdeal;
    private javax.swing.JButton buttonStart;
    private javax.swing.JButton buttonTest;
    private javax.swing.JList<String> displayList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAverageScore;
    private javax.swing.JLabel labelCalcTime;
    private javax.swing.JLabel labelHighestScore;
    private javax.swing.JLabel labelIdeal;
    private javax.swing.JLabel labelImportTime;
    private javax.swing.JLabel labelViableWords;
    private javax.swing.JTextField textConsole1;
    private javax.swing.JTextField textDef;
    private javax.swing.JTextArea textDict;
    private javax.swing.JTextField textInput;
    private javax.swing.JTextField textPath;
    private javax.swing.JTextField textScore;
    private javax.swing.JLabel textScoreWord;
    private javax.swing.JTextField textTest;
    private javax.swing.JTextField textTestResult;
    // End of variables declaration//GEN-END:variables
}
