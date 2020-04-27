/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import static App.TeamInfo.teamInfo;
import static App.TeamInfo.teamSquad;
import Model.CentreForward;
import Model.Defender;
import Model.FootballPlayer;
import Model.Goalkeeper;
import Model.Midfielder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vu Dai Duong
 */
public class TeamSquad extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    private static ArrayList<FootballPlayer> listPlayers;
    public static TeamSquad teamSquad = new TeamSquad();
    
    public void savePlayerInFile(ArrayList<FootballPlayer> listFootballPlayers) {
        try {
            File file = new File("D:\\Codegym\\Netbean\\Case_Study\\FootballManager\\src\\App\\listPlayer.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(FootballPlayer footballPlayer : listFootballPlayers) {
                printWriter.println(footballPlayer.getName() + "," + footballPlayer.getPosition()
                        + "," + footballPlayer.getIndex()+ "," + footballPlayer.getBirthYear());
            }
            printWriter.close();
        }catch(IOException e) {
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void readPlayerFromFile(ArrayList<FootballPlayer> listFootballPlayers){
        try {
            File file = new File("D:\\Codegym\\Netbean\\Case_Study\\FootballManager\\src\\App\\listPlayer.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(null, "Danh sách cầu thủ không tồn tại.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!file.canRead()) {
                JOptionPane.showMessageDialog(null, "Không thể đọc danh sách cầu thủ.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string = new String();
            while ((string = bufferedReader.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                String name = stringTokenizer.nextToken();
                String position = stringTokenizer.nextToken();
                int index = Integer.parseInt(stringTokenizer.nextToken());
                int birthYear = Integer.parseInt(stringTokenizer.nextToken());
                listFootballPlayers.add(new FootballPlayer(name, birthYear, index, position));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
  
    public void showList(ArrayList<FootballPlayer> list){
        
        tableModel = (DefaultTableModel) tablePlayer.getModel();
        int i = 1;
        tableModel.setRowCount(0);
        for (FootballPlayer footballPlayer : list) {
            tableModel.addRow(new Object[]{
                i++, footballPlayer.getName(), footballPlayer.getPosition(), footballPlayer.getIndex(), (2020 - footballPlayer.getBirthYear())
            });
        }
        tablePlayer.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

    /**
     * Creates new form TeamSquad
     */
    public TeamSquad() {
        initComponents();
        this.setTitle("Chỉnh sửa đội hình");
        listPlayers = new ArrayList<>();
        readPlayerFromFile(listPlayers);
        showList(listPlayers);
        tablePlayer.setAutoCreateRowSorter(true);
        tablePlayer.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablePlayer.getColumnModel().getColumn(0).setPreferredWidth(30);
        tablePlayer.getColumnModel().getColumn(1).setPreferredWidth(140);
        tablePlayer.getColumnModel().getColumn(2).setPreferredWidth(70);
        tablePlayer.getColumnModel().getColumn(3).setPreferredWidth(50);
        tablePlayer.getColumnModel().getColumn(4).setPreferredWidth(48);
        showComboCFData();
        showComboGKData();
        showComboDFData();
        showComboMFData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        infoTeamBtn = new javax.swing.JButton();
        teamSquadBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        centreForwardCbx2 = new javax.swing.JComboBox<>();
        centreForwardCbx1 = new javax.swing.JComboBox<>();
        midfielderCbx2 = new javax.swing.JComboBox<>();
        midfielderCbx1 = new javax.swing.JComboBox<>();
        defenderCbx1 = new javax.swing.JComboBox<>();
        defenderCbx2 = new javax.swing.JComboBox<>();
        goalkeeperCbx = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePlayer = new javax.swing.JTable();
        bestLineUpBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("ỨNG DỤNG QUẢN LÝ ĐỘI BÓNG");

        infoTeamBtn.setText("THÔNG TIN ĐỘI BÓNG");
        infoTeamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoTeamBtnActionPerformed(evt);
            }
        });

        teamSquadBtn.setText("CHỈNH SỬA ĐỘI HÌNH");
        teamSquadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamSquadBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("@author Vu Dai Duong");

        jLabel1.setText("Tiền đạo");

        jLabel2.setText("Tiền đạo");

        jLabel3.setText("Tiền vệ");

        jLabel4.setText("Tiền vệ");

        jLabel7.setText("Hậu vệ");

        jLabel8.setText("Hậu vệ");

        jLabel9.setText("Thủ môn");

        tablePlayer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Họ và tên", "Vị trí", "Chỉ số", "Tuổi"
            }
        ));
        jScrollPane1.setViewportView(tablePlayer);

        bestLineUpBtn.setText("Đội hình tối ưu");
        bestLineUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bestLineUpBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                            .addComponent(infoTeamBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(teamSquadBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(129, 129, 129)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(23, 23, 23)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(midfielderCbx2, 0, 130, Short.MAX_VALUE)
                                        .addComponent(midfielderCbx1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(goalkeeperCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(defenderCbx1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(centreForwardCbx1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(defenderCbx2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(centreForwardCbx2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bestLineUpBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(centreForwardCbx2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(centreForwardCbx1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(infoTeamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(midfielderCbx2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(teamSquadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(defenderCbx1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(defenderCbx2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(midfielderCbx1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(132, 132, 132)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(goalkeeperCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(bestLineUpBtn)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void teamSquadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamSquadBtnActionPerformed
        JOptionPane.showMessageDialog(null, "Bạn đang ở trang Chỉnh sửa đội hình");
    }//GEN-LAST:event_teamSquadBtnActionPerformed

    private void bestLineUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bestLineUpBtnActionPerformed
        ArrayList<FootballPlayer> listCFPlayers = new ArrayList<>();
        ArrayList<FootballPlayer> listMFPlayers = new ArrayList<>();
        ArrayList<FootballPlayer> listDFPlayers = new ArrayList<>();
        ArrayList<FootballPlayer> listGKPlayers = new ArrayList<>();
        for (FootballPlayer footballPlayer : listPlayers) {
            switch (footballPlayer.getPosition()){
                case "Tiền đạo":
                    listCFPlayers.add(footballPlayer);
                    break;
                case "Tiền vệ":
                    listMFPlayers.add(footballPlayer);
                    break;
                case "Hậu vệ":
                    listDFPlayers.add(footballPlayer);
                    break;
                case "Thủ môn":
                    listGKPlayers.add(footballPlayer);
                    break;
            }
        }
        int indexOfPlayer = 0;
        String nameOfPlayer = null;
        for(FootballPlayer footballPlayer : listCFPlayers){
            if (footballPlayer.getIndex()> indexOfPlayer){
                indexOfPlayer = footballPlayer.getIndex();
                nameOfPlayer = footballPlayer.getName();
            }    
        }
        centreForwardCbx1.setSelectedItem(nameOfPlayer);
        for(FootballPlayer footballPlayer : listDFPlayers){
            if (footballPlayer.getIndex()> indexOfPlayer){
                indexOfPlayer = footballPlayer.getIndex();
                nameOfPlayer = footballPlayer.getName();
            }    
        }
        defenderCbx1.setSelectedItem(nameOfPlayer);
        for(FootballPlayer footballPlayer : listMFPlayers){
            if (footballPlayer.getIndex()> indexOfPlayer){
                indexOfPlayer = footballPlayer.getIndex();
                nameOfPlayer = footballPlayer.getName();
            }    
        }
        midfielderCbx1.setSelectedItem(nameOfPlayer);
        for(FootballPlayer footballPlayer : listGKPlayers){
            if (footballPlayer.getIndex()> indexOfPlayer){
                indexOfPlayer = footballPlayer.getIndex();
                nameOfPlayer = footballPlayer.getName();
            }    
        }
        goalkeeperCbx.setSelectedItem(nameOfPlayer);
    }//GEN-LAST:event_bestLineUpBtnActionPerformed
    
    
    private void infoTeamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoTeamBtnActionPerformed
        teamSquad.setVisible(false);
        teamInfo.setVisible(true);
        
    }//GEN-LAST:event_infoTeamBtnActionPerformed

    private void showComboCFData(){
        List<String> listCentreForward = CentreForward.getDataCF();
        for (String string : listCentreForward) {
            centreForwardCbx1.addItem(string);
            centreForwardCbx2.addItem(string);
        }
    }
    private void showComboGKData(){
        List<String> listGoalkeeper = Goalkeeper.getDataGK();
        for (String string : listGoalkeeper) {
            goalkeeperCbx.addItem(string);
        }
    }
    private void showComboMFData(){
        List<String> listMidfielder = Midfielder.getDataMF();
        for (String string : listMidfielder) {
            midfielderCbx1.addItem(string);
            midfielderCbx2.addItem(string);
        }
    }
    private void showComboDFData(){
        List<String> listDefender = Defender.getDataDF();
        for (String string : listDefender) {
            defenderCbx1.addItem(string);
            defenderCbx2.addItem(string);
        }
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
            java.util.logging.Logger.getLogger(TeamSquad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeamSquad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeamSquad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeamSquad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeamSquad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bestLineUpBtn;
    private javax.swing.JComboBox<String> centreForwardCbx1;
    private javax.swing.JComboBox<String> centreForwardCbx2;
    private javax.swing.JComboBox<String> defenderCbx1;
    private javax.swing.JComboBox<String> defenderCbx2;
    private javax.swing.JComboBox<String> goalkeeperCbx;
    private javax.swing.JButton infoTeamBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> midfielderCbx1;
    private javax.swing.JComboBox<String> midfielderCbx2;
    private javax.swing.JTable tablePlayer;
    private javax.swing.JButton teamSquadBtn;
    // End of variables declaration//GEN-END:variables
}
