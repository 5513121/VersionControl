import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Oct 18 09:41:23 CST 2023
 */



/**
 * @author lWX1091923
 */
public class DownloadProgress {
    public DownloadProgress() {
        initComponents();
    }

    private void buttonExitDownloadMouseClicked(MouseEvent e) {
        // TODO add your code here
        //取消下载按钮
        downloadProgres.dispose();
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        int i = threadGroup.activeCount();
        Thread[] threads = new Thread[i];
        threadGroup.enumerate(threads);
        System.out.println("线程总个数："+i);
        for (int j = 0; j < i; j++) {
            String name = threads[j].getName();
            System.out.println("第"+j+"个线程名为："+name);

            if("DownloadThread".equals(name)){
                if(threads[j].isAlive()){
                    threads[j].interrupt();
                    System.out.println("线程-"+threads[j].getName()+"  已中断");
                }
            }
        }
    }

    private void downloadProgresWindowClosed(WindowEvent e) {
        // TODO add your code here
        //下载窗口关闭时结束下载
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        int i = threadGroup.activeCount();
        Thread[] threads = new Thread[i];
        threadGroup.enumerate(threads);
        System.out.println("线程总个数："+i);
        for (int j = 0; j < i; j++) {
            String name = threads[j].getName();
            System.out.println("第"+j+"个线程名为："+name);

            if("DownloadThread".equals(name)){
                if(threads[j].isAlive()){
                    try {
                        threads[j].interrupt();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
//                    System.exit(0);
                    System.out.println("线程-"+threads[j].getName()+"  已中断");
                }
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        downloadProgres = new JFrame();
        progressBar1 = new JProgressBar();
        label1 = new JLabel();
        buttonExitDownload = new JButton();
        panel1 = new JPanel();
        labelShowDownInfo = new JLabel();

        //======== downloadProgres ========
        {
            downloadProgres.setTitle("\u8fdb\u5ea6...");
            downloadProgres.setResizable(false);
            downloadProgres.setVisible(true);
            downloadProgres.setBackground(Color.white);
            downloadProgres.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            downloadProgres.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    downloadProgresWindowClosed(e);
                }
            });
            Container downloadProgresContentPane = downloadProgres.getContentPane();
            downloadProgresContentPane.setLayout(null);

            //---- progressBar1 ----
            progressBar1.setIndeterminate(true);
            progressBar1.setStringPainted(true);
            progressBar1.setString("  ");
            downloadProgresContentPane.add(progressBar1);
            progressBar1.setBounds(105, 55, 265, 40);

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/prompt.png")));
            downloadProgresContentPane.add(label1);
            label1.setBounds(40, 50, 40, 45);

            //---- buttonExitDownload ----
            buttonExitDownload.setText("\u53d6\u6d88");
            buttonExitDownload.setBackground(new Color(0xcccccc));
            buttonExitDownload.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buttonExitDownloadMouseClicked(e);
                }
            });
            downloadProgresContentPane.add(buttonExitDownload);
            buttonExitDownload.setBounds(190, 115, 85, 35);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setLayout(null);

                //---- labelShowDownInfo ----
                labelShowDownInfo.setBorder(null);
                panel1.add(labelShowDownInfo);
                labelShowDownInfo.setBounds(105, 20, 265, 30);

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
            downloadProgresContentPane.add(panel1);
            panel1.setBounds(0, 0, 445, 170);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < downloadProgresContentPane.getComponentCount(); i++) {
                    Rectangle bounds = downloadProgresContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = downloadProgresContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                downloadProgresContentPane.setMinimumSize(preferredSize);
                downloadProgresContentPane.setPreferredSize(preferredSize);
            }
            downloadProgres.pack();
            downloadProgres.setLocationRelativeTo(downloadProgres.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame downloadProgres;
    private JProgressBar progressBar1;
    private JLabel label1;
    private JButton buttonExitDownload;
    private JPanel panel1;
    private JLabel labelShowDownInfo;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


    public JProgressBar getProgressBar1() {
        return progressBar1;
    }


    public void setProgressBar1(JProgressBar progressBar1) {
        this.progressBar1 = progressBar1;
    }
}
