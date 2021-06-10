
import java.sql.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class dba_Teste{
   public void imprime(){
      String url = "jdbc:mysql://localhost:3306/aluno_java?autoReconnect=true&useSSL=false";
      String login = "root";
      String senha = "21092001";

        try 
        {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("\nDriver carregado com sucesso!\n");
         try
         {
                 Connection conn = DriverManager.getConnection(url, login, senha);
                 try
                 {
                    String sql = "SELECT * FROM aluno_javano";
                    Statement stm = conn.createStatement();
                    try
                    {
                     ResultSet rs = stm.executeQuery(sql);
                      
                     while (rs.next()) 
                     {
                      
                        int num_mat = rs.getInt("num_mat");
                        String nome = rs.getString("nome");
                        String endereço = rs.getString("endereco");      
                        
                        System.out.println("4-Lista de Alunos\nnum_mat: " + num_mat + "\nnome: " +nome + "\nendereço: " +endereço);
                        System.out.println("---------------------------------------");
                        
                     }
                  
                  System.out.println("\nConsulta realizada com sucesso!!!\n"); 
                                       
                    }
               catch (Exception ex) 
               {
                  System.out.println("\nErro no resultset!");
               }
                 }
                  catch (Exception ex) 
            {
               System.out.println("\nErro no statement!");
            }
         }
         catch (Exception ex) 
         {
            System.out.println("\nErro no connection!");
         }   
        }
        catch (Exception ex) 
        {
            System.out.println("\nDriver nao pode ser carregado!");
        }
   }
   
   public void consult(int num_mat){
      String sql = ("SELECT * FROM aluno_javano WHERE num_mat = ?");
      
      Connection conn = null;
      PreparedStatement pstm = null;
      String url = "jdbc:mysql://localhost:3306/aluno_java?autoReconnect=true&useSSL=false";
      String login = "root";
      String senha = "21092001";
      ResultSet rs = null;
      try {
      conn = DriverManager.getConnection(url, login, senha);
      
      pstm = conn.prepareStatement(sql);
      
      pstm.setInt(1,num_mat);
      rs = pstm.executeQuery();
      
      while (rs.next()){
       
         num_mat = rs.getInt("num_mat");
         String nome = rs.getString("nome");
         String endereço = rs.getString("endereco");      
         
         JOptionPane.showMessageDialog(null,"num_mat: " + num_mat + "\nnome: " +nome + "\nendereço: " +endereço);
         //System.out.println("---------------------------------------");
         
      }

      } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      }finally{
      
      try{
      if(pstm != null){
      
      pstm.close();
      }
      
      if(conn != null){
      conn.close();
      }
      
      }catch(Exception e){
      
      e.printStackTrace();
      }
      }
}

}