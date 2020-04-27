/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


/**
 *
 * @author Vu Dai Duong
 */
public class CentreForward {
    
    private static List<String> listCentreForward = new ArrayList<>();
    public static List<String> getDataCF(){
        try {
            File file = new File("D:\\Codegym\\Netbean\\Case_Study\\FootballManager\\src\\App\\listPlayer.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(null, "Danh sách cầu thủ không tồn tại.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (!file.canRead()) {
                JOptionPane.showMessageDialog(null, "Không thể đọc danh sách cầu thủ.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return null;
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
                if ("Tiền đạo".equals(position)){
                    FootballPlayer footballPlayer = new FootballPlayer(name, birthYear, index, position);
                    listCentreForward.add(footballPlayer.getName());
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return listCentreForward;
    }
}
