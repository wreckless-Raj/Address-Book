import java.awt.event.ActionEvent;              //Name: Raj Shekhar Karmaker
import java.awt.event.ActionListener;          //ID: 011 193 149
import java.nio.Buffer;                                                         //file.txt && out.txt for reference
import java.util.*;
import javax.swing.*;
import java.io.*;
//class //WriteOrAppendString{




//}

public class AddressBook{
    public static void write(String s, File f) throws IOException {
        FileWriter fw = new FileWriter(f, true);
        fw.write(s);
        fw.close();
    }
    public static void main(String[] args) throws IOException {
        JFrame f= new JFrame("Address Book");
        f.setSize(600,500);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        //1  User can input the info of a particular person
        JPanel p= new JPanel();                    //Follow the format below to write input
        JLabel l1= new JLabel("Input:");      //name sex phone email street address
        JTextArea t1= new JTextArea(5,15);
        t1.setEditable(true);
        JTextArea t2= new JTextArea(5,40);





        ActionListener obj= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //t2.setText(t1.getText());



                try{
                    File f= new File("C:\\Users\\ASUS\\IdeaProjects\\LabFinalAssignment\\file1.txt");
                    write(t1.getText()+"\n",f);
                    //write("\n",f);


                    //BufferedReader r= new BufferedReader(new FileReader(file));
                    //PrintWriter pw= new PrintWriter(new File("C:\\Users\\ASUS\\IdeaProjects\\LabFinalAssignment\\file1.txt"));
                    //FileWriter fw = null;
                    //pw.println();
                   // String s= r.readLine();
                   // while(s!=null){
                        //String str[]=s.split(" ");
                        //String o= t1.getText();
                        //String id1= str[0];
                        //String id2=str[1];
                        //String id3=str[2];
                        //String id4=str[3];
                        //String id5=str[4];
                        //String id6=str[5];
                        //String id7=str[6];
                        //s=r.readLine();
                        //Civilian c= new Civilian(t1.getText());
                        //pw.println(id1+" "+id2+" "+id3+" "+id4+" "+id5+" "+id6+" "+id7);

                   // }

                    //fw = new FileWriter("file.txt", true);
                    //fw.write(t1.getText());
                    //pw.println(t1.getText());

                    //FileReader reader= new FileReader(filename);


                    //pw.println();

                    //t2.setText("out.txt");
                    //r.close();
                    //pw.close();
                    //fw.close();

                }catch(FileNotFoundException ex){
                    ex.printStackTrace();
                }catch(IOException ex){
                }
            }
        };

        ActionListener obj1= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser= new JFileChooser();
                chooser.showOpenDialog(null);
                File f1=chooser.getSelectedFile();
                String filename=f1.getAbsolutePath();
                try {
                    FileReader reader= new FileReader(filename);
                    BufferedReader br = new BufferedReader(reader);


                    t2.read(br, null);

                    br.close();
                    t2.requestFocus();
                }catch(FileNotFoundException ex){

                }catch(IOException ex){

                }
                }
        };
        //2
        //a file where all the info is stored. You will have to append new info to the file. Otherwise the previous
        //info will be lost.
        //3 Info of everyone

        //Result
        JLabel l2= new JLabel("Result: ");
        JTextArea t4= new JTextArea(5,20);
        //4 Search a person using name
        //Search by name
        JTextArea t3= new JTextArea(0,20);
        ActionListener obj2= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String searchWord=t3.getText();
                //File output= new File("C:\\Users\\ASUS\\IdeaProjects\\LabFinalAssignment\\file1.txt");
                //FileReader fr= null;
                //if(t3.getText()==t2.requestFocus())

                try{
                    FileReader fr = new FileReader("file1.txt");
                    //fr=new FileReader("C:\\Users\\ASUS\\IdeaProjects\\LabFinalAssignment\\out.txt");
                    BufferedReader br= new BufferedReader(fr);
                    String s= br.readLine();
                    //if(s.contains(searchWord))
                        //t4.setText(s);
                    //String s= br.readLine();
                    int count=0;
                    int i;
                    while(s!=null) {


                            if (s.contains(searchWord)){
                                t4.setText(s);
                                //count++;
                            }



                        s= br.readLine();



                    }

                    /*for(i=count; i<0; i--) {
                        String textArray[]= new String[i];

                        t4.setText(textArray[i]);
                    }*/
                    br.close();
                    fr.close();
                }catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                }
            };

        JButton b1= new JButton("Add");
        b1.addActionListener(obj);
        JButton b2= new JButton("Show");
        b2.addActionListener(obj1);
        JButton b3= new JButton("Search");
        b3.addActionListener(obj2);



        p.add(l1); p.add(t1); p.add(b1); p.add(b2); p.add(t2); p.add(t2);  p.add(t3); p.add(b3);
        p.add(l2); p.add(t4);
        f.setContentPane(p);
        f.setVisible(true);
    }
}
