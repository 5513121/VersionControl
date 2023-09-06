/*
 * Created by JFormDesigner on Sat Sep 02 16:56:14 CST 2023
 */

package versionControlTool;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.io.File;

//import org.dom4j.Document;


/**
 * @author Brainrain
 */
public class MyJframe extends JFrame {
    public MyJframe() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        String repositoryValue;
        String branchValue;


        String text = textArea1.getText();
        String text1 = text + "\\package_define.xml";
        File file = new File(text1);


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;


        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException a) {
            // TODO Auto-generated catch block
            System.out.println("无法获取该 对象");
        }


        //加载xml文件
        try {
            Document document = db.parse(text1);
            NodeList nodelist = document.getElementsByTagName("package_res");


            for (int i = 0; i < nodelist.getLength(); i++) {
                System.out.println(i);
//                System.out.println(nodelist.getLength());

                Node node = nodelist.item(i);
                String nodeName = node.getNodeName();
//                System.out.println(nodeName);
                String textContent = node.getTextContent();
                String trim = textContent.trim();
//                System.out.println(trim);
                String[] split = trim.split("\n");
//                System.out.println(Arrays.toString(split));
                String trim1 = split[0].trim();
                String trim2 = split[1].trim();

                textField1.setText(trim1);
                textField2.setText(trim2);

            }


        } catch (Exception c) {
            // TODO Auto-generated catch block
            c.printStackTrace();
        }
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        StringSelection stringSelection = new StringSelection(textField1.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        StringSelection stringSelection = new StringSelection(textField2.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        StringSelection stringSelection = new StringSelection(textArea3.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

    }

    private void button5(ActionEvent e) {
        // TODO add your code here
        StringSelection stringSelection = new StringSelection(textArea2.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    private void button7(ActionEvent e) {
        // TODO add your code here
        String gitclone = "git push origin " + textField2.getText() + ":refs/for/" + textField2.getText();
        StringSelection stringSelection = new StringSelection(gitclone);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

    }

    private void button6(ActionEvent e) {
        // TODO add your code here
        String gitclone = "git clone " + textField1.getText() + " -b " + textField2.getText();
        StringSelection stringSelection = new StringSelection(gitclone);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }


//        SAXReader saxReader = new SAXReader();
//        try {
//            Document doc = saxReader.read(file);
//            Element rootElement = doc.getRootElement();
//
//            doc.get
//        } catch (DocumentException e1) {
//            e1.printStackTrace();
//        }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        frame1 = new JFrame();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        textField1 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        textArea2 = new JTextArea();
        textArea3 = new JTextArea();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();

        //======== frame1 ========
        {
            frame1.setForeground(Color.black);
            frame1.setBackground(new Color(200, 221, 212));
            frame1.setTitle("\u7248\u672c\u7ba1\u63a7");
            frame1.setVisible(true);
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(null);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setLayout(null);

                //======== scrollPane1 ========
                {

                    //---- textArea1 ----
                    textArea1.setForeground(Color.black);
                    textArea1.setBackground(Color.white);
                    textArea1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
                    textArea1.setLineWrap(true);
                    textArea1.setMargin(new Insets(10, 10, 10, 10));
                    scrollPane1.setViewportView(textArea1);
                }
                panel1.add(scrollPane1);
                scrollPane1.setBounds(45, 395, 855, 60);

                //---- button1 ----
                button1.setText("\u83b7\u53d6\u7248\u672c\u7ba1\u63a7");
                button1.setForeground(Color.black);
                button1.setBackground(new Color(200, 221, 212));
                button1.addActionListener(e -> button1(e));
                panel1.add(button1);
                button1.setBounds(new Rectangle(new Point(925, 410), button1.getPreferredSize()));

                //---- textField1 ----
                textField1.setBackground(Color.white);
                textField1.setForeground(Color.black);
                textField1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                textField1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                textField1.setToolTipText("d");
                textField1.setMargin(new Insets(10, 10, 10, 10));
                panel1.add(textField1);
                textField1.setBounds(45, 480, 855, 70);

                //---- label1 ----
                label1.setText("\u4ed3");
                label1.setBackground(Color.white);
                label1.setForeground(Color.black);
                label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                panel1.add(label1);
                label1.setBounds(new Rectangle(new Point(10, 505), label1.getPreferredSize()));

                //---- label2 ----
                label2.setText("\u5206\u652f");
                label2.setBackground(Color.white);
                label2.setForeground(Color.black);
                label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                panel1.add(label2);
                label2.setBounds(5, 575, 45, 40);

                //---- textField2 ----
                textField2.setBackground(Color.white);
                textField2.setForeground(Color.black);
                textField2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                textField2.setMargin(new Insets(10, 10, 10, 10));
                panel1.add(textField2);
                textField2.setBounds(45, 575, 855, 40);

                //---- label3 ----
                label3.setText("\u8f93\u5165package_define.xml\u8def\u5f84");
                label3.setBackground(Color.white);
                label3.setForeground(Color.black);
                label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                panel1.add(label3);
                label3.setBounds(45, 360, 365, 24);

                //---- button2 ----
                button2.setText("\u590d\u5236\u4ed3");
                button2.setForeground(Color.black);
                button2.setBackground(new Color(200, 221, 212));
                button2.addActionListener(e -> button2(e));
                panel1.add(button2);
                button2.setBounds(925, 505, 102, 33);

                //---- button3 ----
                button3.setText("\u590d\u5236\u5206\u652f");
                button3.setForeground(Color.black);
                button3.setBackground(new Color(200, 221, 212));
                button3.addActionListener(e -> button3(e));
                panel1.add(button3);
                button3.setBounds(925, 575, 102, 33);

                //---- button4 ----
                button4.setText("\u590d\u5236");
                button4.setForeground(Color.black);
                button4.setBackground(new Color(200, 221, 212));
                button4.addActionListener(e -> button4(e));
                panel1.add(button4);
                button4.setBounds(150, 30, 102, 33);

                //---- textArea2 ----
                textArea2.setForeground(Color.black);
                textArea2.setBackground(new Color(249, 249, 249, 249));
                textArea2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
                textArea2.setLineWrap(true);
                textArea2.setMargin(new Insets(10, 10, 10, 10));
                textArea2.setText("git commit -m \"\nTickeNo:DTS2015562722607\nDhdhhdjsisj:modijy version No.\nTeam:hskss\nFeature\nBin\nPri");
                panel1.add(textArea2);
                textArea2.setBounds(10, 100, 265, 245);

                //---- textArea3 ----
                textArea3.setForeground(Color.black);
                textArea3.setBackground(new Color(249, 249, 249, 249));
                textArea3.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
                textArea3.setLineWrap(true);
                textArea3.setMargin(new Insets(10, 10, 10, 10));
                textArea3.setText("git add .");
                panel1.add(textArea3);
                textArea3.setBounds(10, 15, 120, 55);

                //---- button5 ----
                button5.setText("\u590d\u5236");
                button5.setForeground(Color.black);
                button5.setBackground(new Color(200, 221, 212));
                button5.addActionListener(e -> button5(e));
                panel1.add(button5);
                button5.setBounds(285, 215, 102, 33);

                //---- button6 ----
                button6.setText("\u590d\u5236clone\u547d\u4ee4");
                button6.setForeground(Color.black);
                button6.setBackground(new Color(200, 221, 212));
                button6.addActionListener(e -> button6(e));
                panel1.add(button6);
                button6.setBounds(265, 660, 130, 33);

                //---- button7 ----
                button7.setText("\u590d\u5236push\u547d\u4ee4");
                button7.setForeground(Color.black);
                button7.setBackground(new Color(200, 221, 212));
                button7.addActionListener(e -> button7(e));
                panel1.add(button7);
                button7.setBounds(50, 660, 125, 33);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                        Rectangle bounds = panel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel1.setMinimumSize(preferredSize);
                    panel1.setPreferredSize(preferredSize);
                }
            }
            frame1ContentPane.add(panel1);
            panel1.setBounds(0, 0, 1100, 765);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < frame1ContentPane.getComponentCount(); i++) {
                    Rectangle bounds = frame1ContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = frame1ContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                frame1ContentPane.setMinimumSize(preferredSize);
                frame1ContentPane.setPreferredSize(preferredSize);
            }
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame frame1;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
