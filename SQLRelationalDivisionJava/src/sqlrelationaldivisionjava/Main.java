/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlrelationaldivisionjava;
/**
 *
 * @author Matheus Ladislau
 */
public class Main{
    public static void main(String[] args){
        RelationalDivision d=new RelationalDivision();
//
        double[][] venda=new double[4][2];
        for(int i=0; i<venda.length; i++){
            venda[i][0]=(i+1);
        }       
        double[][] produto=new double[9][2];
        for(int i=0; i<produto.length; i++){
            produto[i][0]=(i+1);
        }
        double[][]itemVenda={
            {1,1,7},
            {1,9,2},
            {2,3,2},
            {2,9,2},
            {2,1,7},
            {3,4,2},
            {3,5,2},
            {3,5,2},
            {3,1,7},
            {3,9,7},
            {4,1,7},
            {4,2,7},
            {4,2,2},
            {4,2,3},
            {4,2,4},
            {4,2,5},
            {4,2,6},
        };
        
//FIM POPULA
        System.out.println("PRODUTO");
        print(produto);
        System.out.println("");       
        System.out.println("VENDA");
        print(venda);          
        System.out.println("");
        System.out.println("ITEMVENDA");
        print(itemVenda);      
        System.out.println("=================");

        System.out.println("VENDA/ITEMVENDA:");
        System.out.println("RESULTADO DIVISÃO: ");
        print(d.relationalDivision(venda,itemVenda,new int[]{0,0}));
        System.out.println("=============");
//TESTES
        
        double[][]teste={
            {1,1},
            {1,2},
            {2,3},
            {3,3},
            {1,3},
        };
        double[][]teste1={
            {0,1},
            {0,2},
            {0,3},
        };
        System.out.println("DIVISAO TESTE 1"); 
        print(d.relationalDivision(teste1,teste,new int[]{1,0}));
        System.out.println("=============");
        
        double[][]testeCF={
            {1,1},
            {1,2},
            {1,3},
            {1,4},
            {1,5},
            {1,6},
            {2,5},
            {2,6},
        };
        double[][]testeF={
            {1,},
            {2,},
            {3,},
            {4,},
            {5,},
            {6,},
        };
        System.out.println("DIVISAO TESTE CF"); 
        print(d.relationalDivision(testeF,testeCF,new int[]{0,1}));
        System.out.println("=============");
        
        
        double[][]inscr={
            {1090,1},
            {1090,2},
            {1080,1},
            {1070,1},
            {1060,1},
            {1060,2},
        };
        double[][]disciplina={
            {1,100},
            {2,200},
        };
        System.out.println("DIVISAO INSC/DISC"); 
        print(d.relationalDivision(disciplina,inscr,new int[]{0,1}));
        System.out.println("=============");      
    }

    public static void print(double[][] x){
        for (int i = 0; i <x.length; i++) {
            for (int j = 0; j <x[i].length; j++) {
                System.out.print(x[i][j]+"   ");
            }
            System.out.println("");
        }
    }
}