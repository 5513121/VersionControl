import com.sun.jndi.toolkit.url.UrlUtil;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Aug 26 18:13:41 CST 2023
 */

/**
 * @Auther lmy
 * @Description 批量打开超链接
 */

/**
 * @author Brainrain
 */
public class OpenLinks {
    public OpenLinks() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        String text = textArea1.getText();
        String[] split = text.split("\n");
//        System.out.println(Arrays.toString(split));
        for(String s: split){
            Desktop desktop = Desktop.getDesktop();
            try {
                URI url = new URI(s);
                desktop.browse(url);
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }



    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Frame = new JFrame();
        panel1 = new JPanel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== Frame ========
        {
            Frame.setTitle("OpenLinks");
            Frame.setBackground(new Color(153, 153, 153));
            Frame.setForeground(Color.gray);
            Frame.setVisible(true);
            Frame.setResizable(false);
            Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container FrameContentPane = Frame.getContentPane();
            FrameContentPane.setLayout(null);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setLayout(null);

                //---- button1 ----
                button1.setText("\u6253\u5f00\u8d85\u94fe\u63a5");
                button1.addActionListener(e -> button1(e));
                panel1.add(button1);
                button1.setBounds(new Rectangle(new Point(365, 370), button1.getPreferredSize()));

                //======== scrollPane1 ========
                {

                    //---- textArea1 ----
                    textArea1.setForeground(Color.black);
                    textArea1.setBackground(Color.white);
                    textArea1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 18));
                    textArea1.setTabSize(12);
                    scrollPane1.setViewportView(textArea1);
                }
                panel1.add(scrollPane1);
                scrollPane1.setBounds(40, 20, 660, 295);

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
            FrameContentPane.add(panel1);
            panel1.setBounds(0, 0, 880, 500);

            FrameContentPane.setPreferredSize(new Dimension(880, 530));
            Frame.setSize(880, 530);
            Frame.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame Frame;
    private JPanel panel1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
