/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.texteditoraccio;

/**
 *
 * @author ashis
 */
import java.awt.BorderLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class TextEditorACCIO implements ActionListener {
     //declaring properties of texteditor
    JFrame frame;
    JMenuBar menubar;
    JMenu file, edit;
    JMenuItem newFile, openFile, saveFile;
    JMenuItem cut, copy, paste, selectAll, close;
    JTextArea textArea;
    TextEditorACCIO(){
       
        frame = new JFrame();
        //initialised the frame
        menubar = new JMenuBar();
        //initialised menubar
        //create content pane
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10,10,10,10));
        panel.setLayout(new BorderLayout(10,10));
        //add text area to panel
        JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //add scroll pane to panel
        panel.add(scrollPane);
        //add panel to frame
        frame.add(panel);
        
        //initialised textarea
        textArea = new JTextArea();
        
        //Initialised menu
        file = new JMenu("File");
        edit = new JMenu("Edit");
        
        //initialised file menu item
        newFile = new JMenuItem("New Window");
        openFile = new JMenuItem("Open File");
        saveFile = new JMenuItem("Save File");
        //addadd action listeners to file menu items
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        //add menu items to file menu
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        //initialised edit menu items
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        close = new JMenuItem("Close");
        //add action listenerr to edit menu items
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);
        //adding to edit menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);
        
        
        
        
        // add menu to menubar
        menubar.add(file);
        menubar.add(edit);
        frame.setJMenuBar(menubar);
        //set menubar to frame
        //add textArea to frame
        frame.add(textArea);
        //set dimensions poping of window from top 100 down right and size 400,400
        frame.setBounds(100, 100, 400, 400);
        frame.setVisible(true);
        frame.setLayout(null);
    }

    /**
     *
     * @param ationEvent
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == cut){
            //perform cut operation
            textArea.cut();
        }
        if(actionEvent.getSource() == copy){
            //perform copy operation
            textArea.copy();
        }
        if(actionEvent.getSource() == paste){
            //perform paste operation
            textArea.paste();
        }
        if(actionEvent.getSource() == selectAll){
            //perform selectAll operation
            textArea.selectAll();
        }
        if(actionEvent.getSource() == close){
            //perform close operation
            System.exit(0);
        }
        if(actionEvent.getSource() == openFile){
            //open a file chooser
           JFileChooser fileChooser = new JFileChooser("C:");
           int chooseOption = fileChooser.showOpenDialog(null);
           //if we have click open button
           if(chooseOption == JFileChooser.APPROVE_OPTION){
               // getting slected file
               File file = fileChooser.getSelectedFile();
               //get the path of the selected file
               String filePath = file.getPath();
               try{
                   //Initialized file reader
                   FileReader fileReader = new FileReader(filePath);
                   //initialised buffer reader
                   BufferedReader bufferedReader = new  BufferedReader(fileReader);
                   
                   String intermediate = "", output = "";
                   // read contents of file line by line
                   
                   while((intermediate = bufferedReader.readLine()) != null){
                       output += intermediate +"\n";
                   }
                   // set the output string to tex area
                   textArea.setText(output);
               }
               catch(FileNotFoundException fileNotFoundException){
                   fileNotFoundException.printStackTrace();
               }
               catch(IOException ioException){
                   ioException.printStackTrace();
               }
           }
        }
        if(actionEvent.getSource() == saveFile){
            //initialised file picker
            JFileChooser fileChooser = new JFileChooser("C:");
            //get choose from file chooser
            int chooseOption = fileChooser.showSaveDialog(null);
            //check if we clicked on save button
            if(chooseOption == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
                try{
                    //initialised file writer
                    FileWriter fileWriter = new FileWriter(file);
                    //initialised bufferwriter
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    //weite contents of text area to file
                    textArea.write(bufferedWriter);
                    bufferedWriter.close();
                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                }
            }
            
        }
        if(actionEvent.getSource() == newFile){
            TextEditorACCIO textEditor = new TextEditorACCIO();
        }
        
    }
    public static void main(String[] args) {
        //calling constructor
        TextEditorACCIO text = new TextEditorACCIO();
    }
}
