package sqlrelationaldivisionjava;
/**
 *
 * @author Matheus Ladislau
 */
public class RelationalDivision{
    //SQLRelationalDivisionJava
    //SQL Relational Division in Java using Matrices
    
    /**
     * 
     * @param venda 
     * @param itemVenda 
     * @param position a vetor with the position of the primary keys from venda and itemvenda
     * @return the result of SQL Relational Division
     */
    public double[][] relationalDivision(double[][] venda,double[][] itemVenda,int[] position){
        int pos1=position[0];
        int pos2=position[1];   
        int keyIndex=0;
        //create and auxiliar vetor with unique keys
        //cria vetor auxiliar para que contem as chaves sem repetição de chave
        double[] auxChave=new double[venda.length];
        for(int i=0; i<venda.length; i++){
            boolean exist=false;
            for(int j=0; j<=i; j++){
                //verify if the element exists to remove repetition
                //verifica se elemento existe para eliminar repetição
                if(venda[i][pos1]==auxChave[j])
                    exist=true;
                if((!exist)&&(j==i)){
                    auxChave[keyIndex]=venda[i][pos1];
                    keyIndex++;                        
                }
            }
        }
        //create a vector that copy
        //cria vetor venda unica que copia item venda com tamanho correto (sem repetição de valores)
        double[] chaveUnica=new double[keyIndex];
        for(int i=0; i<chaveUnica.length; i++){
            chaveUnica[i]=auxChave[i];
        }
        
        //create a copy of matrix without repetition
        //Cria uma cópia da matriz itemVenda sem repetição 
        double[][] copiaItemVenda=itemVenda.clone();
        for(int i=0; i<copiaItemVenda.length; i++){
            for (int j=i+1; j<copiaItemVenda.length; j++){
                int counter=0;
                for (int k=0; k<copiaItemVenda[0].length; k++){
                    if(copiaItemVenda[i][k]==copiaItemVenda[j][k]){
                        counter++;
                        if(counter==copiaItemVenda[0].length){
                            for(int l=0; l<copiaItemVenda[0].length; l++){
                                copiaItemVenda[j][l]=666; //aponta que linha não existe
                            }
                        }
                    }
               }            
            }
        }
        //get index of new matrix without repetition
        //pega indice da nova matriz sem repetição
        int copiaLength=copiaItemVenda.length;
        for(int i=0; i<copiaItemVenda.length; i++){
            if(copiaItemVenda[i][0]==-666)
                copiaLength--; //caso não exista, decrescer
        }
        //new matrix without repetition of values
        //nova matriz sem repetição de valores
        double[][] itemVendaUnico=new double[copiaLength][copiaItemVenda[0].length];
        for (int i=0,j=0; i<copiaItemVenda.length; i++) {
            if(copiaItemVenda[i][0]!=-1){
                itemVendaUnico[j]=copiaItemVenda[i];
                j++;
            }
        }
        
        //new auxiliar matrix without key's column 
        //nova matriz auxiliar que não possui a coluna com chave
        double[][] aux=new double[itemVendaUnico.length][itemVendaUnico[0].length-1];
        //remove the column key's column
        //retira a coluna que possui chave 
        for(int i=0; i<itemVendaUnico.length; i++){
            int k=0;
            for(int j=0; j<itemVendaUnico[i].length-1; k++,j++){
                if(k==pos2){
                    k++;
                }
                aux[i][j]=itemVendaUnico[i][k];
            }
        }
        //new result matrix. Don't has 'null' data
        //nova matriz resposta, porém possui campos em branco 
        double[][] resp=new double[aux.length][aux[0].length];
        int resultLength=0;
        
        for(int i=0; i<aux.length; i++){
            int contadorPartic=0;//numero de vezes de repetições de linha
            for(int j=i; j<aux.length; j++){
                int contadorColunas=0;
                    for(int k=0; k<aux[i].length; k++){
                        if(aux[i][k]==aux[j][k]){
                            contadorColunas++;//numero de colunas da linha que são semelhantes
                        }
                        if(contadorColunas==aux[0].length){//verifica se todas linhas são iguais, acresce repetições
                            contadorPartic++;
                        }
                        if(contadorPartic==chaveUnica.length){
                            resp[resultLength]=aux[i];
                            resultLength++;
                            j=aux.length;
                        }
                }
            }
        }
        //copy result matrix in correct lenght
        //copia matriz resposta no tamanho correto
        double[][] result=new double[resultLength][aux[0].length];
        for(int i=0; i<result.length; i++) {
            result[i]=resp[i];
        }
        return result;
    }
}
