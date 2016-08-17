package com.webdev.testing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.webdev.utilities.IndexDirFiles;

public class TestIndexing {


    public static void main(String args[])
        throws IOException, SQLException
    {
        String destname = "D:\\ByLaws";
        String nam ="D:\\ByLaws";
        FileWriter fstream = new FileWriter((new StringBuilder(String.valueOf(destname))).append("//index.csv").toString());
        PrintWriter outb = new PrintWriter(fstream);
        File aFile = new File(nam);
       // String StatusMssg = "Your Index file is being generated.......";
        //JOptionPane.showMessageDialog(null, StatusMssg);
       new IndexDirFiles().Process(aFile, outb);
        outb.close();
        //String st = (new StringBuilder("Your Index File (Index.csv) is Ready in the following path: ")).append(destname).toString();
       // JOptionPane.showMessageDialog(null, st);
    }
}
