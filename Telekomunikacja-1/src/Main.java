import java.util.Vector;

public class Main {
    private int [][]H={ {0,1,1,1,1,1,1,1, 1,0,0,0,0,0,0,0},
                        {1,0,1,1,1,1,1,1, 0,1,0,0,0,0,0,0},
                        {1,1,0,1,1,1,1,1, 0,0,1,0,0,0,0,0},
                        {1,1,1,0,1,1,1,1, 0,0,0,1,0,0,0,0},
                        {1,1,1,1,0,1,1,1, 0,0,0,0,1,0,0,0},
                        {1,1,1,1,1,0,1,1, 0,0,0,0,0,1,0,0},
                        {1,1,1,1,1,1,0,1, 0,0,0,0,0,0,1,0},
                        {1,1,1,1,1,1,1,0, 0,0,0,0,0,0,0,1}};

    public int[] koduj(int[] msg){
       int[] slowo=new int[16];
       for(int i=0; i<8; i++){
           slowo[i]=msg[i];
       }
       int suma;
       for(int i=0;i<8;i++){
           suma=0;
           for(int j=0; j<8; j++){
               suma=(suma+H[i][j]*msg[j])%2;
           }
           slowo[i+8]=suma;
       }
       return slowo;
    }

    public int[] mnozonko(int[] W){
        int[] E=new int[8];
        for(int i=0; i<8;i++){
            int suma=0;
            for(int j=0; j<16; j++){
                suma+=W[j]*H[i][j];
            }
            E[i]=suma%2;
        }
        return E;
    }

    public void poprawianko(int [] msg, int j){
        if(msg[j]==0) msg[j]=1;
        else msg[j]=0;
    }

    public int [] odkoduj(int[] slowo){
        int[] msg=new int[8];
        for(int i=0; i<8; i++){
            msg[i]=slowo[i];
        }
        int[] E=mnozonko(slowo);
        E=mnozonko(E);

        for(int j=0; j<16; j++ ){
            //Tu sprawdzamy czy wystepuje pojedynczy blad
            boolean wart=true;
            for(int i=0; i<8; i++){
                if(H[i][j]!=E[i]) {
                    wart=false;
                    break;
                }
            }
            if(wart==true) {
                poprawianko(msg,j);
                break;
            }
            //A tu czy podwojny
            wart=true;
            for(int k=1; k+j<16; k++){
                for(int i=0; i<8; i++){
                    if((H[i][j]+H[i][j+k])%2!=E[i]){
                        wart=false;
                        break;
                    }
                }
                if(wart==true){
                    poprawianko(msg,j);
                    poprawianko(msg,j+k);
                    break;
                }
            }
        }
        /*for(int j=0;j<16;j++){
            boolean wart=true;
            for(int k=1; k+j<16; k++){
                for(int i=0; i<8; i++){
                    if((H[i][j]+H[i][j+k])%2!=E[i]){
                        wart=false;
                        break;
                    }
                }
                if(wart==true){
                    poprawianko(msg,j);
                    poprawianko(msg,j+k);
                    break;
                }
            }
        }*/


    }
    public static void main(String args[]){

    }
}
