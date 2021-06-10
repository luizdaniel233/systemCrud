
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;

class aluno{

    private int num_mat;
    private String nome;
    private String endereco;
    
   
      
      public int getNum_mat(){
         return this.num_mat;
      }
    
     public String getNome(){
         return this.nome;
      }
    
     public String getEndereco(){
         return this.endereco;
      }
    
     public void setNum_mat(int num_mat){
          this.num_mat = num_mat;
      }
    
     public void setNome(String nome){
          this.nome = nome;
      }
    
     public void setEndereco(String endereco){
          this.endereco = endereco;
      }
    
            
    }



class opAluno{
   
   public void save(aluno registro){
      
      String sql = "INSERT INTO aluno_javano(num_mat,nome,endereco)" +
      " VALUES(?,?,?)";
      
      Connection conn = null;
      PreparedStatement pstm = null;
      String url = "jdbc:mysql://localhost:3306/aluno_java?autoReconnect=true&useSSL=false";
      String login = "root";
      String senha = "21092001";
      try {
      //Cria uma conexão com o banco
      conn = DriverManager.getConnection(url, login, senha);;
      
      //Cria um PreparedStatment, classe usada para executar a query
      pstm = conn.prepareStatement(sql);
      
      //Adiciona o valor do primeiro parâmetro da sql
      pstm.setInt(1,registro.getNum_mat());
      //Adicionar o valor do segundo parâmetro da sql
      pstm.setString(2,registro.getNome());
      //Adiciona o valor do terceiro parâmetro da sql
      pstm.setString(3,registro.getEndereco());
      
      //Executa a sql para inserção dos dados
      pstm.execute();
      
      } catch (Exception e) {
      
      e.printStackTrace();
      }finally{
      
      //Fecha as conexões
      
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
      
      public void removeById(int num_mat){
      
      String sql = "DELETE FROM aluno_javano WHERE num_mat = ?";
      
      Connection conn = null;
      PreparedStatement pstm = null;
      String url = "jdbc:mysql://localhost:3306/aluno_java?autoReconnect=true&useSSL=false";
      String login = "root";
      String senha = "21092001";
      try {
      conn = DriverManager.getConnection(url, login, senha);
      
      pstm = conn.prepareStatement(sql);
      
      pstm.setInt(1,num_mat);
      
      pstm.execute();
      
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
      
      public void update( aluno registro){
         
      
      String sql = "UPDATE aluno_javano SET nome = ?, endereco = ?" +
      " WHERE num_mat = ?";
      
      Connection conn = null;
      PreparedStatement pstm = null;
      String url = "jdbc:mysql://localhost:3306/aluno_java?autoReconnect=true&useSSL=false";
      String login = "root";
      String senha = "21092001";
      try {
      //Cria uma conexão com o banco
      conn = DriverManager.getConnection(url, login, senha);
      
      //Cria um PreparedStatment, classe usada para executar a query
      pstm = conn.prepareStatement(sql);
      
      //Adiciona o valor do primeiro parâmetro da sql
      pstm.setString(1,registro.getNome());
      //Adicionar o valor do segundo parâmetro da sql
      pstm.setString(2,registro.getEndereco());
      //Adiciona o valor do terceiro parâmetro da sql
      pstm.setInt(3,registro.getNum_mat());
      
      //Executa a sql para inserção dos dados
      pstm.execute();
      
      } catch (Exception e) {
      
      e.printStackTrace();
      }finally{
      
      //Fecha as conexões
      
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
      
      
      public List<aluno> getaluno_javano(){
      
      String sql = "SELECT * FROM aluno_javano";
      
      List<aluno> aluno_javano = new ArrayList<aluno>();
      
      Connection conn = null;
      PreparedStatement pstm = null;
      String url = "jdbc:mysql://localhost:3306/aluno_java?autoReconnect=true&useSSL=false";
      String login = "root";
      String senha = "21092001";
      //Classe que vai recuperar os dados do banco de dados
      ResultSet rset = null;
      
      try {
      conn = DriverManager.getConnection(url, login, senha);
      
      pstm = conn.prepareStatement(sql);
      
      rset = pstm.executeQuery();
      
      //Enquanto existir dados no banco de dados, faça
      while(rset.next()){
      
      aluno registro = new aluno();
      
      //Recupera o id do banco e atribui ele ao objeto
      registro.setNum_mat(rset.getInt("num_mat"));
      
      //Recupera o nome do banco e atribui ele ao objeto
      registro.setNome(rset.getString("nome"));
      
      //Recupera o endereço do banco e atribui ele ao objeto
      registro.setEndereco(rset.getString("endereco"));
      
      //Adiciono o contato recuperado, a lista de contatos
    
      }
      } catch (Exception e) {
      
      e.printStackTrace();
      }finally{
      
      try{
      
      if(rset != null){
      
      rset.close();
      }
      
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
      
      return aluno_javano;
      }
     }

