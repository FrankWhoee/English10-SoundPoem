
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
    String wordImport = "common.txt";
    
    public static ArrayList<word> words = new ArrayList<word>();
    public GUI() {
        Ref.RefInit();
        initComponents();
        
             
    }

    
    public void importWords(){
        if(isImported){
            return;
        }
        words.clear();
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
            Path path = Paths.get(jarDir + "src/" + wordImport);
            System.out.println("RUNNING " + os.toUpperCase());
            if(os.indexOf("win") >= 0){
                path = Paths.get(jarDir + "\\lib\\" + wordImport);
            }else{
                path = Paths.get(jarDir + "/lib/" + wordImport);
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
        labelWordImport.setText("Word Import: " + wordImport);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        buttonStart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayList = new javax.swing.JList<>();
        textConsole = new javax.swing.JTextField();
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
        buttonRefresh = new javax.swing.JButton();
        buttonImportCommon = new javax.swing.JButton();
        buttonImportAll = new javax.swing.JButton();
        labelWordImport = new javax.swing.JLabel();
        buttonCustomDictionary = new javax.swing.JButton();
        textCustomDict = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        textConsole.setEditable(false);
        textConsole.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textConsole.setText("Welcome to Consonants Matcher v2.0.0. Enter your name and click start to begin.");
        textConsole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textConsoleActionPerformed(evt);
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
        textDict.setText("Now with a dictionary. Click a word, or type a word into \"Define a word:\" to find out the \ndefinition of a word");
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

        buttonRefresh.setText("Refresh");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });

        buttonImportCommon.setText("Import Common Words");
        buttonImportCommon.setToolTipText("");
        buttonImportCommon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImportCommonActionPerformed(evt);
            }
        });

        buttonImportAll.setText("Import All Words");
        buttonImportAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImportAllActionPerformed(evt);
            }
        });

        labelWordImport.setText("Word Import:");

        buttonCustomDictionary.setText("Save");
        buttonCustomDictionary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCustomDictionaryActionPerformed(evt);
            }
        });

        jLabel7.setText("Use a custom dictionary:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textPath)
                    .addComponent(textConsole, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelImportTime)
                            .addComponent(labelWordImport)
                            .addComponent(labelIdeal)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textCustomDict, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCustomDictionary, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textDef)
                            .addComponent(buttonDef, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonImportCommon, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonImportAll))
                    .addComponent(labelCalcTime)
                    .addComponent(labelHighestScore)
                    .addComponent(labelAverageScore)
                    .addComponent(labelViableWords))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
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
                                .addGap(0, 0, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonPath, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonImportCommon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonImportAll, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelIdeal)
                                .addGap(9, 9, 9)
                                .addComponent(labelImportTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelWordImport))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textCustomDict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(buttonDef)
                                    .addComponent(buttonCustomDictionary, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCalcTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAverageScore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelHighestScore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelViableWords)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textConsole, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    public void calculate(){
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
    }
    
    private void textConsoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textConsoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textConsoleActionPerformed

    private void textInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textInputMouseClicked
        textInput.setText("");
    }//GEN-LAST:event_textInputMouseClicked

    private void displayListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayListMouseClicked
        String selected = displayList.getSelectedValue();
        String definition = "";
        try{
            definition = DictionaryAPI.define(selected);
        }catch(Exception e){
            definition = "Error: Not connected to internet, or word does not exist.";
        }
        //definition = fitString(definition);
        if(definition.equals("")){
            definition = "Definition for \"" + displayList.getSelectedValue() + "\"does not exist in dictionary.";
        }
        textDict.setText(definition);
        word W = new word(selected,0);
        W.calcScore(textIdeal);
        textScore.setText("" + W.score);
        textScoreWord.setText("Word: " + W.word);
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
            textConsole.setText("Ideal string not set. Type in word in input box and click \"Set Ideal String\"");
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
        String definition = "";
        try{
            definition = DictionaryAPI.define(textDef.getText());
        }catch(Exception e){
            definition = "Error: Not connected to internet, or word does not exist.";
        }
        if(definition.equals("")){
            definition = "Definition for \"" + textDef.getText() + "\"does not exist in dictionary.";
        }
        //definition = fitString(definition);
        textDict.setText(definition);
    }//GEN-LAST:event_buttonDefActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        isImported = false;
        try{
            importWords();
        }catch(Exception e){
            textConsole.setText("Error occured while importing words.");
        }
        calculate();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void buttonImportCommonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImportCommonActionPerformed
        wordImport = "common.txt";
        
        isImported = false;
        importWords();
    }//GEN-LAST:event_buttonImportCommonActionPerformed

    private void buttonImportAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImportAllActionPerformed
        wordImport = "all.txt";
        
        isImported = false;
        importWords();
    }//GEN-LAST:event_buttonImportAllActionPerformed

    private void buttonCustomDictionaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCustomDictionaryActionPerformed
        wordImport = textCustomDict.getText();
        
        isImported = false;
        importWords();
    }//GEN-LAST:event_buttonCustomDictionaryActionPerformed

    public String fitString(String input){
        String output = input;
        for(int i = 0; i < output.length(); i++){
            if(i % 113 == 0 && i != 0 && !output.substring(i,i+2).equals("\n")){
                
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
    private javax.swing.JButton buttonCustomDictionary;
    private javax.swing.JButton buttonDef;
    private javax.swing.JButton buttonImportAll;
    private javax.swing.JButton buttonImportCommon;
    private javax.swing.JButton buttonPath;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonSetIdeal;
    private javax.swing.JButton buttonStart;
    private javax.swing.JButton buttonTest;
    private javax.swing.JList<String> displayList;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAverageScore;
    private javax.swing.JLabel labelCalcTime;
    private javax.swing.JLabel labelHighestScore;
    private javax.swing.JLabel labelIdeal;
    private javax.swing.JLabel labelImportTime;
    private javax.swing.JLabel labelViableWords;
    private javax.swing.JLabel labelWordImport;
    private javax.swing.JTextField textConsole;
    private javax.swing.JTextField textCustomDict;
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
