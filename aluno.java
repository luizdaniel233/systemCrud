
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.sql.*;
class aluno{

private int num_mat;
private String nome;
private String endereco;

aluno(int num_mat,String nome,String endereco){
    this.setNum_mat(num_mat);
    this.setNome(nome);
    this.setEndereco(endereco);
}
aluno(){
    this.setNum_mat(1);
    this.setNome("l");
    this.setEndereco("r");
}
  
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