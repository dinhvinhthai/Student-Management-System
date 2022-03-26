/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysinhvien;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User 28820
 */
public class clsConnection {
     

    public static Connection con;
    public static void Open()    {
    try{            
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String URL = "jdbc:sqlserver://DESKTOP-OQN7VQL\\SQLEXPRESS:1433;databaseName=QuanLySinhVien;user=admin;password=123456";
                con=DriverManager.getConnection(URL);
            }catch(Exception E)
            {
                System.out.println("Ket noi that bai");
                E.printStackTrace();
            }
        }

        public static void Close(){
     try
           {
                con.close();;
            }
    catch(Exception e)
            {
                e.printStackTrace();
            }
       }


    
}
