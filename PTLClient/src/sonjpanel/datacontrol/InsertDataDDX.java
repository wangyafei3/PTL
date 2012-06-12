/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InsertDataDDX.java
 *
 * Created on 2012-5-30, 19:12:23
 */
package sonjpanel.datacontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dell
 */
public class InsertDataDDX extends javax.swing.JPanel {

    /** Creates new form InsertDataDDX */
    
    public List<RightAnswer> components_right = new ArrayList<RightAnswer>();
    public List<WrongAnswer> components_wrong = new ArrayList<WrongAnswer>();
    
    public InsertDataDDX() {
        initComponents();
        
        
        WrongAnswer wa = new WrongAnswer();
        wrong_answer_jpanel.setLayout(new BoxLayout(wrong_answer_jpanel, BoxLayout.Y_AXIS));
        wrong_answer_jpanel.add(wa);
        components_wrong.add(wa);
        wa.add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                WrongAnswer wa = new WrongAnswer();
                wrong_answer_jpanel.add(wa);
                wrong_answer_jpanel.revalidate();
                wrong_answer_jpanel.validate();
                wrong_answer_jpanel.repaint();
                components_wrong.add(wa);
                
                System.out.println("+"+components_wrong.size());

                wa.add.addActionListener(this);
                wa.delete.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        if(components_wrong.size()>1){
                            components_wrong.remove(((JButton)e.getSource()).getParent());
                            ((JButton)e.getSource()).getParent().getParent().remove(((JButton)e.getSource()).getParent());
                            wrong_answer_jpanel.revalidate();
                            wrong_answer_jpanel.validate();
                            wrong_answer_jpanel.repaint();
                        }   
                    }
                });
            }
        });
        
        wa.delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(components_wrong.size()>1){
                    components_wrong.remove(((JButton)e.getSource()).getParent());
                    ((JButton)e.getSource()).getParent().getParent().remove(((JButton)e.getSource()).getParent());
                    wrong_answer_jpanel.revalidate();
                    wrong_answer_jpanel.validate();
                    wrong_answer_jpanel.repaint();
                }
            }
        });
        
        
        RightAnswer ra = new RightAnswer();
        right_answer_jpanel.setLayout(new BoxLayout(right_answer_jpanel, BoxLayout.Y_AXIS));
        right_answer_jpanel.add(ra);
        components_right.add(ra);
        ra.add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                RightAnswer ra = new RightAnswer();
                right_answer_jpanel.add(ra);
                right_answer_jpanel.revalidate();
                right_answer_jpanel.validate();
                right_answer_jpanel.repaint();
                components_right.add(ra);
                
                System.out.println("+"+components_right.size());

                ra.add.addActionListener(this);
                ra.delete.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        if(components_right.size()>1){
                            components_right.remove(((JButton)e.getSource()).getParent());
                            ((JButton)e.getSource()).getParent().getParent().remove(((JButton)e.getSource()).getParent());
                            right_answer_jpanel.revalidate();
                            right_answer_jpanel.validate();
                            right_answer_jpanel.repaint();
                        }   
                    }
                });
            }
        });
        
        ra.delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(components_right.size()>1){
                    components_right.remove(((JButton)e.getSource()).getParent());
                    ((JButton)e.getSource()).getParent().getParent().remove(((JButton)e.getSource()).getParent());
                    right_answer_jpanel.revalidate();
                    right_answer_jpanel.validate();
                    right_answer_jpanel.repaint();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        attachment = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        right_answer_jpanel = new javax.swing.JPanel();
        wrong_answer_jpanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        manual_difficulty = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("多选");

        jLabel2.setText("题干");

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        attachment.setEditable(false);

        jLabel6.setText("附件");

        javax.swing.GroupLayout right_answer_jpanelLayout = new javax.swing.GroupLayout(right_answer_jpanel);
        right_answer_jpanel.setLayout(right_answer_jpanelLayout);
        right_answer_jpanelLayout.setHorizontalGroup(
            right_answer_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        right_answer_jpanelLayout.setVerticalGroup(
            right_answer_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout wrong_answer_jpanelLayout = new javax.swing.GroupLayout(wrong_answer_jpanel);
        wrong_answer_jpanel.setLayout(wrong_answer_jpanelLayout);
        wrong_answer_jpanelLayout.setHorizontalGroup(
            wrong_answer_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        wrong_answer_jpanelLayout.setVerticalGroup(
            wrong_answer_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        jLabel3.setText("难度系数");

        manual_difficulty.setText("0.8");

        jButton1.setText("预览");

        submit.setText("提交");

        jButton3.setText("浏览");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel1)
                .addContainerGap(215, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(attachment, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)))
                    .addComponent(right_answer_jpanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wrong_answer_jpanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manual_difficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submit)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attachment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(right_answer_jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(wrong_answer_jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manual_difficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(submit)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF &PNG Images", "jpg", "gif", "png");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("选择图片");
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.attachment.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField attachment;
    public javax.swing.JTextArea description;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField manual_difficulty;
    private javax.swing.JPanel right_answer_jpanel;
    public javax.swing.JButton submit;
    private javax.swing.JPanel wrong_answer_jpanel;
    // End of variables declaration//GEN-END:variables
}
