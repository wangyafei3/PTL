/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Manager.java
 *
 * Created on 2012-5-15, 10:28:06
 */
package main;

import fileio.ImageAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;
import sonjpanel.LogInforJPanel;
import sonjpanel.datacontrol.InsertDataPD;
import http.PostJavaCookie;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.TreeSelectionListener;
import sonjpanel.AutoPaper;
import sonjpanel.datacontrol.InsertDataDDX;
import sonjpanel.datacontrol.InsertDataDX;
import sonjpanel.datacontrol.InsertDataJD;
import sonjpanel.datacontrol.InsertDataTK;
import sonjpanel.datacontrol.RightAnswer;
import sonjpanel.datacontrol.WrongAnswer;
import sonjpanel.show.ShowDDX;
import sonjpanel.show.ShowDX;
import sonjpanel.show.ShowJD;
import sonjpanel.show.ShowPD;
import sonjpanel.show.ShowTK;
import xml.GetDataXml;
import xml.getLogXml;

/**
 *
 * @author dell
 */
public class Manager extends javax.swing.JFrame {

    /** Creates new form Manager */
    public Manager() throws MalformedURLException, IOException, Exception {
        initComponents();
        this.cookie.setVisible(false);
        this.setLocation(200, 50);
        jTree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                String path = e.getNewLeadSelectionPath().toString();
                if (path.equals("[JTree, 添加题目, 填空]")) {
                    addTK();
                } else if (path.equals("[JTree, 添加题目, 判断]")) {
                    addPD();
                } else if (path.equals("[JTree, 添加题目, 单选]")) {
                    addDX();
                } else if (path.equals("[JTree, 添加题目, 多选]")) {
                    addDDX();
                } else if (path.equals("[JTree, 添加题目, 简答]")) {
                    addJD();
                }else if(path.equals("[JTree, 搜索题目, 填空]")){
                    try {
                        searchTK();
                    } catch (JDOMException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SAXException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                else if(path.equals("[JTree, 搜索题目, 判断]")){
                    try {
                        searchPD();
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SAXException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JDOMException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                else if(path.equals("[JTree, 搜索题目, 单选]")){
                    try {
                        searchDX();
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SAXException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JDOMException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                else if(path.equals("[JTree, 搜索题目, 多选]")){
                    try {
                        searchDDX();
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SAXException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JDOMException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                else if(path.equals("[JTree, 搜索题目, 简答]")){
                    try {
                        searchJD();
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SAXException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JDOMException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                else if(path.equals("[JTree, 生成试卷, 自动生成]")){
                    addAutoPaper();
                }
                
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        loginfor = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cookie = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("欢迎使用PTL试题管理系统！");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/b.PNG")).getImage());

        jTree.setBackground(new java.awt.Color(240, 240, 240));
        jTree.setFont(new java.awt.Font("宋体", 0, 14));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("JTree");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("添加题目");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("填空");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("判断");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("单选");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("多选");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("简答");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("搜索题目");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("填空");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("判断");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("单选");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("多选");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("简答");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("生成试卷");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("自动生成");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree.setRootVisible(false);
        jScrollPane1.setViewportView(jTree);

        loginfor.setText("登录日志");
        loginfor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginforActionPerformed(evt);
            }
        });

        jButton1.setText("个人信息");

        logout.setText("退出");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel1.setText("欢迎您：");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(cookie, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(loginfor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(loginfor, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cookie, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void loginforActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginforActionPerformed
    JPanel loginforj = new JPanel();
    loginforj.setLayout(new BoxLayout(loginforj, BoxLayout.Y_AXIS));
    jScrollPane2.setLayout(new ScrollPaneLayout());
    jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    //准备参数
    //cookie
    String mycookie = cookie.getText();
    //url
    String url = "http://ptltest-bxshi.dotcloud.com/logcheck/";
    //准备表
    String table = "log";
    //准备属性
    List<String> list = new ArrayList<String>();
    list.add("year");
    list.add("month");
    list.add("day");
    list.add("hour");
    list.add("minute");
    list.add("second");
    list.add("ip");
    list.add("login");

    //获取数据类
    getLogXml ml = new getLogXml();
    //接收返回数据
    List<Map<String, ?>> items = new ArrayList<Map<String, ?>>();
    items = ml.getXML(mycookie, url, table, list);
    //控件数组
    LogInforJPanel[] lij = new LogInforJPanel[items.size()];

    for (int i = 0; i < items.size(); i++) {
        //每次创建一个新的控件
        lij[i] = new LogInforJPanel();
        //向控件中相应属性赋值
        lij[i].year.setText(items.get(i).get("year").toString());
        lij[i].month.setText(items.get(i).get("month").toString());
        lij[i].day.setText(items.get(i).get("day").toString());
        lij[i].hour.setText(items.get(i).get("hour").toString());
        lij[i].minu.setText(items.get(i).get("minute").toString());
        lij[i].sec.setText(items.get(i).get("second").toString());
        lij[i].ipaddr.setText(items.get(i).get("ip").toString());
        String s = items.get(i).get("login").toString();
        lij[i].state.setText(s);
        
        if("True".equals(s)){
            lij[i].statelogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/right.PNG")));
        }else{
            lij[i].statelogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wrong.PNG")));
        }

        lij[i].setBorder(LineBorder.createBlackLineBorder());
        //添加该控件
        loginforj.add(lij[i]);
    }
    jScrollPane2.getViewport().add(loginforj, null);
}//GEN-LAST:event_loginforActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_logoutActionPerformed

    public void addTK() {
        final InsertDataTK dataTK = new InsertDataTK();
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jScrollPane2.setLayout(new ScrollPaneLayout());
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        dataTK.submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String type = "1";
                String description = dataTK.description.getText();
                String path = "";
                path = dataTK.attachment.getText();
                ImageAction ia = new ImageAction();
                String file = null;
                if (!"".equals(path)) {
                    try {
                        file = ia.codeBase64(path);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                String right_answer = dataTK.right_answer.getText();
                String manual_difficulty = dataTK.difficulty.getText();

                String con = null;
                con = "xml=" + "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>"
                        + "<quiz>"
                        + "<quiz_info>"
                        + "<type>"+type+"</type>"
                        + "</quiz_info>"
                        + "<description>"+description+"</description>";

                if (!"".equals(path)) {
                    con = con + "<attachments>"
                            + "<attachment>"
                            + "<description>"+path+"</description>"
                            + "<file>"+file+"</file>"
                            + "</attachment>"
                            + "</attachments>";
                }
                con = con + "<correct_answer>"
                        + "<answer>"
                        + "<string>"+right_answer+"</string>"
                        + "</answer>"
                        + "</correct_answer>"
                        + "<manual_difficulty>"+manual_difficulty+"</manual_difficulty>"
                        + "</quiz>"
                        + "</root>";
                
                if(!"".equals(description) && !"".equals(right_answer)){
                    PostJavaCookie pj = new PostJavaCookie();
                    String url = "http://ptltest-bxshi.dotcloud.com/quiz/insert/";
                    try {
                        pj.post(url, con, cookie.getText());
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                    JOptionPane.showConfirmDialog(null, "您已成功添加！", "确认添加", JOptionPane.CLOSED_OPTION);
                }else{
                    JOptionPane.showConfirmDialog(null, "题干和答案不可为空", "确定", JOptionPane.CLOSED_OPTION);
                }
            }
        });

        jp.add(dataTK);
        jScrollPane2.getViewport().add(jp, null);

    }

    public void addPD() {
        final InsertDataPD dataPD = new InsertDataPD();

        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jScrollPane2.setLayout(new ScrollPaneLayout());
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        dataPD.submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String type = "2";
                String description = dataPD.tigan.getText();
                String correct_answer = null;
                String wrong_answer = null;
                dataPD.trueselect.setSelected(true);
                if (dataPD.trueselect.isSelected()) {
                    correct_answer = "true";
                    wrong_answer = "false";
                } else if (dataPD.falseselect.isSelected()) {
                    correct_answer = "true";
                    wrong_answer = "false";
                }
                ImageAction ia = new ImageAction();
                String path = dataPD.attachment.getText();
                String file = null;
                if (!"".equals(path)) {
                    try {
                        file = ia.codeBase64(path);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                String manual_difficulty = dataPD.difficulty.getText();
                String con = null;
                con = "xml=" + "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>"
                        + "<quiz>"
                        + "<quiz_info>"
                        + "<type>"+type+"</type>"
                        + "</quiz_info>"
                        + "<description>"+description+"</description>";
                if (!"".equals(path)) {
                    con = con + "<attachments>"
                            + "<attachment>"
                            + "<description>"+path+"</description>"
                            + "<file>"+file+"</file>"
                            + "</attachment>"
                            + "</attachments>";
                }
                con = con + "<correct_answer>"
                        + "<answer>"
                        + "<string>"+correct_answer+"</string>"
                        + "</answer>"
                        + "</correct_answer>"
                        + "<wrong_answer>"
                        + "<answer>"
                        + "<string>"+wrong_answer+"</string>"
                        + "</answer>"
                        + "</wrong_answer>"
                        + "<manual_difficulty>"+manual_difficulty+"</manual_difficulty>"
                        + "</quiz>"
                        + "</root>";
                if(!"".equals(description)){
                    PostJavaCookie pj = new PostJavaCookie();
                    String url = "http://ptltest-bxshi.dotcloud.com/quiz/insert/";
                    try {
                        pj.post(url, con, cookie.getText());
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }    
                    JOptionPane.showConfirmDialog(null, "您已成功添加！", "确认", JOptionPane.CLOSED_OPTION);
                }else{
                    JOptionPane.showConfirmDialog(null, "题干不可为空!", "确定", JOptionPane.CLOSED_OPTION);
                }
                
            }
        });

        jp.add(dataPD);
        jScrollPane2.getViewport().add(jp, null);
    }

    public void addDX() {
        final InsertDataDX dataDX = new InsertDataDX();

        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jScrollPane2.setLayout(new ScrollPaneLayout());
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        dataDX.submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String type = "3";
                String description = dataDX.description.getText();

                String path = dataDX.attachment.getText();
                ImageAction ia = new ImageAction();
                String file = null;
                if(!"".equals(path)){
                    try {
                        file = ia.codeBase64(path);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                String manual_difficulty = dataDX.manual_difficulty.getText();
                String correct_answer = dataDX.correct_answer.getText();
                List<WrongAnswer> comps = dataDX.components;

                String con = null;
                con = "xml=" + "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>"
                        + "<quiz>"
                        + "<quiz_info>"
                        + "<type>"+type+"</type>"
                        + "</quiz_info>"
                        + "<description>"+description+"</description>";
                        
                if(!"".equals(path)){
                    con=con + "<attachments>"
                        + "<attachment>"
                        + "<description>"+path+"</description>"
                        + "<file>"+file+"</file>"
                        + "</attachment>"
                        + "</attachments>";
                }
                       
                 con=con+ "<correct_answer>"
                        + "<answer>"
                        + "<string>"+correct_answer+"</string>"
                        + "</answer>"
                        + "</correct_answer>"
                        + "<wrong_answer>";
                for (WrongAnswer wa : comps) {
                    if(!"".equals(wa.wrong_answer.getText())){
                        con = con + "<answer>" + "<string>" + wa.wrong_answer.getText() + "</string>" + "</answer>";
                    }  
                }
                con = con
                        + "</wrong_answer>"
                        + "<manual_difficulty>" + manual_difficulty + "</manual_difficulty>"
                        + "</quiz>"
                        + "</root>";
                if(!"".equals(description) && !"".equals(correct_answer) && !comps.isEmpty()){
                    PostJavaCookie pj = new PostJavaCookie();
                    String url = "http://ptltest-bxshi.dotcloud.com/quiz/insert/";
                    try {
                        pj.post(url, con, cookie.getText());
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }    
                    JOptionPane.showConfirmDialog(null, "您已成功添加！", "确认", JOptionPane.CLOSED_OPTION);
                }else{
                    JOptionPane.showConfirmDialog(null, "题干、答案不可为空!", "确定", JOptionPane.CLOSED_OPTION);
                }
            }
        });

        jp.add(dataDX);
        jScrollPane2.getViewport().add(jp, null);
    }

    public void addDDX() {
        final InsertDataDDX dataDDX = new InsertDataDDX();

        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jScrollPane2.setLayout(new ScrollPaneLayout());
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        dataDDX.submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String type = "4";
                String description = dataDDX.description.getText();

                String path = dataDDX.attachment.getText();
                ImageAction ia = new ImageAction();
                String file = null;
                if(!"".equals(path)){
                    try {
                        file = ia.codeBase64(path);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                String manual_difficulty = dataDDX.manual_difficulty.getText();
                List<RightAnswer> rightcomps = dataDDX.components_right;
                List<WrongAnswer> wrongcomps = dataDDX.components_wrong;

                String con = null;
                con = "xml=" + "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>"
                        + "<quiz>"
                        + "<quiz_info>"
                        + "<type>" + type + "</type>"
                        + "</quiz_info>"
                        + "<description>" + description + "</description>";
                if(!"".equals(path)){
                    con=con+ "<attachments>"
                        + "<attachment>"
                        + "<description>" + path + "</description>"
                        + "<file>" + file + "</file>"
                        + "</attachment>"
                        + "</attachments>";
                }    
                con=con+ "<correct_answer>";
                for (RightAnswer ra : rightcomps) {
                    if(!"".equals(ra.right_answer.getText())){
                        con = con + "<answer>" + "<string>" + ra.right_answer.getText() + "</string>" + "</answer>";
                    } 
                }
                con = con
                        + "</correct_answer>"
                        + "<wrong_answer>";
                for (WrongAnswer wa : wrongcomps) {
                    if(!"".equals(wa.wrong_answer.getText())){
                        con = con + "<answer>" + "<string>" + wa.wrong_answer.getText() + "</string>" + "</answer>";
                    }
                }
                con = con
                        + "</wrong_answer>"
                        + "<manual_difficulty>" + manual_difficulty + "</manual_difficulty>"
                        + "</quiz>"
                        + "</root>";
                if(!"".equals(description) && !wrongcomps.isEmpty() && !rightcomps.isEmpty()){
                    PostJavaCookie pj = new PostJavaCookie();
                    String url = "http://ptltest-bxshi.dotcloud.com/quiz/insert/";
                    try {
                        pj.post(url, con, cookie.getText());
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }    
                    JOptionPane.showConfirmDialog(null, "您已成功添加！", "确认", JOptionPane.CLOSED_OPTION);
                }else{
                    JOptionPane.showConfirmDialog(null, "题干、答案不可为空!", "确定", JOptionPane.CLOSED_OPTION);
                }
            }
        });

        jp.add(dataDDX);
        jScrollPane2.getViewport().add(jp, null);
    }

    public void addJD() {
        final InsertDataJD dataJD = new InsertDataJD();

        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jScrollPane2.setLayout(new ScrollPaneLayout());
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        dataJD.submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String type = "5";
                String description = dataJD.description.getText();

                String path = dataJD.attachment.getText();
                ImageAction ia = new ImageAction();
                String file = null;
                if(!"".equals(path)){
                    try {
                        file = ia.codeBase64(path);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                String correct_answer = dataJD.right_answer.getText();
                String answer_path = dataJD.answer_attachment.getText();
                String answer_file = null;
                if(!"".equals(answer_path)){
                    try {
                        answer_file = ia.codeBase64(answer_path);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                String manual_difficulty = dataJD.manual_difficulty.getText();


                String con = null;
                con = "xml=" + "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>"
                        + "<quiz>"
                        + "<quiz_info>"
                        + "<type>" + type + "</type>"
                        + "</quiz_info>"
                        + "<description>" + description + "</description>";
                if(!"".equals(path)){
                    con=con+ "<attachments>"
                        + "<attachment>"
                        + "<description>" + path + "</description>"
                        + "<file>" + file + "</file>"
                        + "</attachment>"
                        + "</attachments>";
                }
                        
                 con=con+ "<correct_answer>"
                        + "<answer>"
                        + "<string>" + correct_answer + "</string>";
                if(!"".equals(answer_path)){
                    con=con+ "<attach>" + answer_file + "</attach>";
                }      
                 con=con+ "</answer>"
                        + "</correct_answer>"
                        + "<manual_difficulty>" + manual_difficulty + "</manual_difficulty>"
                        + "</quiz>"
                        + "</root>";
                if(!"".equals(description) && !"".equals(correct_answer)){
                    PostJavaCookie pj = new PostJavaCookie();
                    String url = "http://ptltest-bxshi.dotcloud.com/quiz/insert/";
                    try {
                        pj.post(url, con, cookie.getText());
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }    
                    JOptionPane.showConfirmDialog(null, "您已成功添加！", "确认", JOptionPane.CLOSED_OPTION);
                }else{
                    JOptionPane.showConfirmDialog(null, "题干、答案不可为空!", "确定", JOptionPane.CLOSED_OPTION);
                }
            }
        });
        jp.add(dataJD);
        jScrollPane2.getViewport().add(jp, null);
    }

    public void addAutoPaper(){
        final AutoPaper ap = new AutoPaper();
        
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jScrollPane2.setLayout(new ScrollPaneLayout());
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        jp.removeAll();
        ap.submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File(ap.pathOut.getText());
                    URL u = new URL("http://ptltest-bxshi.dotcloud.com/static/test.pdf");
                    org.apache.commons.io.FileUtils.copyURLToFile(u , file);
                } catch (IOException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jp.add(ap);
        jScrollPane2.getViewport().add(jp, null);
    }
    
    public void searchTK() throws JDOMException, MalformedURLException, ParserConfigurationException, IOException, SAXException {
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jScrollPane2.setLayout(new ScrollPaneLayout());
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        jp.removeAll();
        List<Map<String, ?>> quizs = new ArrayList<Map<String, ?>>();
        String url = "http://ptltest-bxshi.dotcloud.com/quiz/getbytype/1/";
        GetDataXml gdx = new GetDataXml();
        String coo = cookie.getText();
        System.out.println(coo);
        quizs = gdx.getDataXml(coo, url);
        for(int i=0;i<quizs.size();i++){
            Map<String , Object> quiz = new HashMap<String, Object>();
            quiz = (Map<String, Object>) quizs.get(i);
            
            ShowTK stk = new ShowTK();
            stk.id.setText(quiz.get("id").toString());
            
            stk.description.setText(quiz.get("description").toString());
            stk.image.setVisible(false);
            List<Map<String ,Object>> attachments = new ArrayList<Map<String, Object>>();
            attachments = (List<Map<String, Object>>) quiz.get("attachments");
            if(!attachments.isEmpty()){
                for(int j=0;j<attachments.size();j++){
                    Map<String , Object> attachment = new HashMap<String, Object>();
                    attachment = (Map<String, Object>) attachments.get(j);
                    String file = attachment.get("file").toString();
                    ImageAction ia = new ImageAction();

                    Image image = ia.decodeBase64(file);
                    ImageIcon icon = new ImageIcon(image);
                    stk.image.setIcon(icon);
                    stk.image.setVisible(true);
                }   
            }
            List<Map<String ,?>> correct_answer = new ArrayList<Map<String, ?>>();
            correct_answer = (List<Map<String, ?>>) quiz.get("correct_answer");
            for(int j=0;j<correct_answer.size();j++){
                Map<String , Object> answer = new HashMap<String, Object>();
                answer = (Map<String, Object>) correct_answer.get(j);
                stk.right_answer.setText(answer.get("string").toString());
            }
            
            stk.diff.setText(quiz.get("manual_difficulty").toString());
            stk.delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String url = "http://ptltest-bxshi.dotcloud.com/quiz/del/";
                    String con = "qid=" + ((ShowTK)(((JButton) e.getSource()).getParent())).id.getText();
                    String coo = cookie.getText();
                    PostJavaCookie pjc = new PostJavaCookie();
                    try {
                        pjc.post(url, con, coo);
                        ((ShowTK)(((JButton) e.getSource()).getParent())).setVisible(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            jp.add(stk);
        }
        jScrollPane2.getViewport().add(jp, null);
    }

    public void searchPD() throws MalformedURLException, ParserConfigurationException, IOException, SAXException, JDOMException {
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jScrollPane2.setLayout(new ScrollPaneLayout());
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        jp.removeAll();
        List<Map<String, ?>> quizs = new ArrayList<Map<String, ?>>();
        String url = "http://ptltest-bxshi.dotcloud.com/quiz/getbytype/2/";
        GetDataXml gdx = new GetDataXml();
        String coo = cookie.getText();
        quizs = gdx.getDataXml(coo, url);
        for(int i=0;i<quizs.size();i++){
            Map<String , Object> quiz = new HashMap<String, Object>();
            quiz = (Map<String, Object>) quizs.get(i);
            
            ShowPD spd = new ShowPD();
            spd.id.setText(quiz.get("id").toString());
            
            spd.description.setText(quiz.get("description").toString());
            spd.image.setVisible(false);
            List<Map<String ,?>> attachments = new ArrayList<Map<String, ?>>();
            attachments = (List<Map<String, ?>>) quiz.get("attachments");
            if(!attachments.isEmpty()){
                for(int j=0;j<attachments.size();j++){
                    Map<String , Object> attachment = new HashMap<String, Object>();
                    attachment = (Map<String, Object>) attachments.get(j);
                    String file = attachment.get("file").toString();
                    ImageAction ia = new ImageAction();
                    Image image = ia.decodeBase64(file);
                    ImageIcon icon = new ImageIcon(image);
                    spd.image.setIcon(icon);
                    spd.image.setVisible(true);
                }    
            }
            List<Map<String ,?>> correct_answer = new ArrayList<Map<String, ?>>();
            correct_answer = (List<Map<String, ?>>) quiz.get("correct_answer");
            for(int j=0;j<correct_answer.size();j++){
                Map<String , Object> answer = new HashMap<String, Object>();
                answer = (Map<String, Object>) correct_answer.get(j);
                spd.right_answer.setText(answer.get("string").toString());
            }
            
            spd.diff.setText(quiz.get("manual_difficulty").toString());
            
            spd.delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String url = "http://ptltest-bxshi.dotcloud.com/quiz/del/";
                    String con = "qid=" + ((ShowPD)(((JButton) e.getSource()).getParent())).id.getText();
                    String coo = cookie.getText();
                    PostJavaCookie pjc = new PostJavaCookie();
                    try {
                        pjc.post(url, con, coo);
                        ((ShowPD)(((JButton) e.getSource()).getParent())).setVisible(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            jp.add(spd);
        }
        jScrollPane2.getViewport().add(jp, null);
    }

    public void searchDX() throws IOException, MalformedURLException, ParserConfigurationException, SAXException, JDOMException {
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jScrollPane2.setLayout(new ScrollPaneLayout());
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        jp.removeAll();
        List<Map<String, ?>> quizs = new ArrayList<Map<String, ?>>();
        String url = "http://ptltest-bxshi.dotcloud.com/quiz/getbytype/3/";
        GetDataXml gdx = new GetDataXml();
        String coo = cookie.getText();
        quizs = gdx.getDataXml(coo, url);
        for(int i=0;i<quizs.size();i++){
            Map<String , Object> quiz = new HashMap<String, Object>();
            quiz = (Map<String, Object>) quizs.get(i);
            
            List<Map<String ,?>> Wrong_answer = new ArrayList<Map<String, ?>>();
            Wrong_answer = (List<Map<String, ?>>) quiz.get("wrong_answer");
            List<String> wrong_answers = new ArrayList<String>();
            for(int j=0;j<Wrong_answer.size();j++){
                Map<String , Object> answer = new HashMap<String, Object>();
                answer = (Map<String, Object>) Wrong_answer.get(j);
                wrong_answers.add(answer.get("string").toString());
            }
            
            ShowDX spd = new ShowDX(wrong_answers);
            spd.id = quiz.get("id").toString();
            
            spd.description.setText(quiz.get("description").toString());
            spd.image.setVisible(false);
            List<Map<String ,?>> attachments = new ArrayList<Map<String, ?>>();
            attachments = (List<Map<String, ?>>) quiz.get("attachments");
            if(!attachments.isEmpty()){
                for(int j=0;j<attachments.size();j++){
                    Map<String , Object> attachment = new HashMap<String, Object>();
                    attachment = (Map<String, Object>) attachments.get(j);
                    String file = attachment.get("file").toString();
                    ImageAction ia = new ImageAction();
                    Image image = ia.decodeBase64(file);
                    ImageIcon icon = new ImageIcon(image);
                    spd.image.setIcon(icon);
                    spd.image.setVisible(true);
                }    
            }
            List<Map<String ,?>> correct_answer = new ArrayList<Map<String, ?>>();
            correct_answer = (List<Map<String, ?>>) quiz.get("correct_answer");
            for(int j=0;j<correct_answer.size();j++){
                Map<String , Object> answer = new HashMap<String, Object>();
                answer = (Map<String, Object>) correct_answer.get(j);
                spd.right_answer.setText(answer.get("string").toString());
            }
            spd.diff.setText(quiz.get("manual_difficulty").toString());
            
            spd.delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String url = "http://ptltest-bxshi.dotcloud.com/quiz/del/";
                    String con = "qid=" + ((ShowDX)(((JButton) e.getSource()).getParent())).id;
                    String coo = cookie.getText();
                    PostJavaCookie pjc = new PostJavaCookie();
                    try {
                        pjc.post(url, con, coo);
                        ((ShowDX)(((JButton) e.getSource()).getParent())).setVisible(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            jp.add(spd);
        }
        jScrollPane2.getViewport().add(jp, null);
    }

    public void searchDDX() throws IOException, MalformedURLException, ParserConfigurationException, SAXException, JDOMException {
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jScrollPane2.setLayout(new ScrollPaneLayout());
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        jp.removeAll();
        List<Map<String, ?>> quizs = new ArrayList<Map<String, ?>>();
        String url = "http://ptltest-bxshi.dotcloud.com/quiz/getbytype/4/";
        GetDataXml gdx = new GetDataXml();
        String coo = cookie.getText();
        quizs = gdx.getDataXml(coo, url);
        for(int i=0;i<quizs.size();i++){
            Map<String , Object> quiz = new HashMap<String, Object>();
            quiz = (Map<String, Object>) quizs.get(i);
            
            List<Map<String ,?>> correct_answer = new ArrayList<Map<String, ?>>();
            correct_answer = (List<Map<String, ?>>) quiz.get("correct_answer");
            List<String> right_answers = new ArrayList<String>();
            for(int j=0;j<correct_answer.size();j++){
                Map<String , Object> answer = new HashMap<String, Object>();
                answer = (Map<String, Object>) correct_answer.get(j);
                right_answers.add(answer.get("string").toString());
            }
            
            List<Map<String ,?>> Wrong_answer = new ArrayList<Map<String, ?>>();
            Wrong_answer = (List<Map<String, ?>>) quiz.get("wrong_answer");
            List<String> wrong_answers = new ArrayList<String>();
            for(int j=0;j<Wrong_answer.size();j++){
                Map<String , Object> answer = new HashMap<String, Object>();
                answer = (Map<String, Object>) Wrong_answer.get(j);
                wrong_answers.add(answer.get("string").toString());
            }
            
            ShowDDX sddx = new ShowDDX(right_answers , wrong_answers);
            sddx.id = quiz.get("id").toString();
            
            sddx.description.setText(quiz.get("description").toString());
            sddx.image.setVisible(false);
            List<Map<String ,?>> attachments = new ArrayList<Map<String, ?>>();
            attachments = (List<Map<String, ?>>) quiz.get("attachments");
            if(!attachments.isEmpty()){
                for(int j=0;j<attachments.size();j++){
                    Map<String , Object> attachment = new HashMap<String, Object>();
                    attachment = (Map<String, Object>) attachments.get(j);
                    String file = attachment.get("file").toString();
                    ImageAction ia = new ImageAction();
                    Image image = ia.decodeBase64(file);
                    ImageIcon icon = new ImageIcon(image);
                    sddx.image.setIcon(icon);
                    sddx.image.setVisible(true);
                }    
            }
            
            sddx.diff.setText(quiz.get("manual_difficulty").toString());
            
            sddx.delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String url = "http://ptltest-bxshi.dotcloud.com/quiz/del/";
                    String con = "qid=" + ((ShowDDX)(((JButton) e.getSource()).getParent())).id;
                    String coo = cookie.getText();
                    PostJavaCookie pjc = new PostJavaCookie();
                    try {
                        pjc.post(url, con, coo);
                        ((ShowDDX)(((JButton) e.getSource()).getParent())).setVisible(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            jp.add(sddx);
        }
        jScrollPane2.getViewport().add(jp, null);

    }

    public void searchJD() throws IOException, MalformedURLException, ParserConfigurationException, SAXException, JDOMException {
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jScrollPane2.setLayout(new ScrollPaneLayout());
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        jp.removeAll();
        List<Map<String, ?>> quizs = new ArrayList<Map<String, ?>>();
        String url = "http://ptltest-bxshi.dotcloud.com/quiz/getbytype/5/";
        GetDataXml gdx = new GetDataXml();
        String coo = cookie.getText();
        System.out.println(coo);
        quizs = gdx.getDataXml(coo, url);
        for(int i=0;i<quizs.size();i++){
            Map<String , Object> quiz = new HashMap<String, Object>();
            quiz = (Map<String, Object>) quizs.get(i);
            
            ShowJD sjd = new ShowJD();
            sjd.id = quiz.get("id").toString();
            
            sjd.description.setText(quiz.get("description").toString());
            
            sjd.image.setVisible(false);
            List<Map<String ,Object>> attachments = new ArrayList<Map<String, Object>>();
            attachments = (List<Map<String, Object>>) quiz.get("attachments");
            if(!attachments.isEmpty()){
                for(int j=0;j<attachments.size();j++){
                    Map<String , Object> attachment = new HashMap<String, Object>();
                    attachment = (Map<String, Object>) attachments.get(j);
                    String file = attachment.get("file").toString();
                    ImageAction ia = new ImageAction();

                    Image image = ia.decodeBase64(file);
                    ImageIcon icon = new ImageIcon(image);
                    sjd.image.setIcon(icon);
                    sjd.image.setVisible(true);
                }   
            }
            
            List<Map<String ,?>> correct_answer = new ArrayList<Map<String, ?>>();
            correct_answer = (List<Map<String, ?>>) quiz.get("correct_answer");
            sjd.right_image.setVisible(false);
            for(int j=0;j<correct_answer.size();j++){
                Map<String , Object> answer = new HashMap<String, Object>();
                answer = (Map<String, Object>) correct_answer.get(j);
                sjd.right_answer.setText(answer.get("string").toString());
                if(answer.containsKey("attach")){
                    String right_attachment = answer.get("attach").toString();
                    if(!"".equals(right_attachment)){
                        ImageAction ia = new ImageAction();
                        Image image = ia.decodeBase64(right_attachment);
                        ImageIcon icon = new ImageIcon(image);
                        sjd.right_image.setIcon(icon);
                        sjd.right_image.setVisible(true);
                    }   
                } 
            }
            sjd.diff.setText(quiz.get("manual_difficulty").toString());
            
            sjd.delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String url = "http://ptltest-bxshi.dotcloud.com/quiz/del/";
                    String con = "qid=" + ((ShowJD)(((JButton) e.getSource()).getParent())).id;
                    String coo = cookie.getText();
                    PostJavaCookie pjc = new PostJavaCookie();
                    try {
                        pjc.post(url, con, coo);
                        ((ShowJD)(((JButton) e.getSource()).getParent())).setVisible(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            jp.add(sjd);
        }
        jScrollPane2.getViewport().add(jp, null);
    }

    
    public static byte[] getBytes(InputStream is)
    throws Exception
    {
        byte[] data = null;
        
        Collection chunks = new ArrayList();
        byte[] buffer = new byte[1024*1000];
        int read = -1;
        int size = 0;
        
        while((read=is.read(buffer))!=-1)
        {
            if(read>0)
            {
                byte[] chunk = new byte[read];
                System.arraycopy(buffer,0,chunk,0,read);
                chunks.add(chunk);
                size += chunk.length;
            }
        }       
        
        if(size>0)
        {
            ByteArrayOutputStream bos = null;
            try
            {
                bos = new ByteArrayOutputStream(size);
                for(Iterator itr=chunks.iterator();itr.hasNext();)
                {
                    byte[] chunk = (byte[])itr.next();
                    bos.write(chunk);
                }
                data = bos.toByteArray();
            }
            finally
            {
                if(bos!=null)
                {
                    bos.close();
                }
            }
        }
        return data;
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new Manager().setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    //从登录页面拿回登陆后的信息
    public void getInfor(Map<String, String> map) {
        String coo = map.get("cookie");
        this.cookie.setText(coo);
        this.username.setText(map.get("username")); 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cookie;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree;
    private javax.swing.JButton loginfor;
    private javax.swing.JButton logout;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
