import java.util.Scanner;
import javax.swing.JOptionPane;
class main{
    public static void main(String[]args){
        opAluno venko = new opAluno();
        aluno contato = new aluno();
        int num_mat = 0;
        String nome = "";
        String Endereco = "";
        int op = 0;
        JOptionPane.showMessageDialog(null,"\n1-Cadastro\n2-Atualizar dados\n3-Deletar Matrícula\n4-Lista de Alunos\n5-Consulta\n6-Sair\n\t\t"); 
        op = Integer.parseInt(JOptionPane.showInputDialog("Digite sua Opção:"));
            while(op > 0){
                if (op == 1){
                    num_mat = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro\nMatrícula:"));
                    contato.setNum_mat(num_mat);
                    nome = JOptionPane.showInputDialog("1-Cadastro\nDigite o Nome do Aluno:");
                    contato.setNome(nome);
                    Endereco = JOptionPane.showInputDialog("1-Cadastro\nDigite o Endereco:");
                    contato.setEndereco(Endereco);
                    venko.save(contato);
                }else{
                    if(op == 2){
                        ///lembrar de expor dados para facilitar alteração
                        aluno contatoUP = new aluno();
                        num_mat = Integer.parseInt(JOptionPane.showInputDialog("2-Atualizar dados\nMatrícula que deseja alterar os dados:"));
                        contatoUP.setNum_mat(num_mat);
                        nome = JOptionPane.showInputDialog("2-Atualizar dados\nAlterando:\nDigite o Nome do Aluno:");
                        contatoUP.setNome(nome);
                        Endereco = JOptionPane.showInputDialog("2-Atualizar dados\nAlterando:\nDigite o Endereco:");
                        contatoUP.setEndereco(Endereco);      
                        venko.update(contatoUP);
                    }if(op == 3){
                        num_mat = Integer.parseInt(JOptionPane.showInputDialog("3-Deletar Matrícula\nMatrícula que deseja Deletar:"));
                        String conf = "";
                        conf = JOptionPane.showInputDialog("Você tem certeza?");
                            if((conf.equals("sim"))||(conf.equals("s")) ||(conf.equals("Sim")) || (conf.equals("S")) || (conf.equals("SIm")) || (conf.equals("SiM")) || (conf.equals("sIM")) || (conf.equals("siM")) || (conf.equals("sIm")) || (conf.equals("SIM"))){
                                venko.removeById(num_mat);
                            }
                    }if (op == 4){
                        dba_Teste imp = new dba_Teste();
                        imp.imprime();
                    }if (op == 5){
                        num_mat = Integer.parseInt(JOptionPane.showInputDialog("5-Consulta de Matrícula\nMatrícula que deseja Consultar:"));
                        dba_Teste imp = new dba_Teste();
                        imp.consult(num_mat);
                    
                    }if (op == 6){
                        JOptionPane.showMessageDialog(null,"6-Sair\nSaindo...");
                        break;
                    }
                        
                    }
                    JOptionPane.showMessageDialog(null,"\n1-Cadastro\n2-Atualizar dados\n3-Deletar Matrícula\n4-Lista de Alunos\n5-Consulta \n6-Sair\n\t\t");
                    op = Integer.parseInt(JOptionPane.showInputDialog("Digite sua Opção:"));
                }
            }
   }
