public class biljetOpties {
    private int vijftig;
    private int twintig;
    private int tien;

    private int[][] opties = new int[3][10]; //[0][] = vijftigjes, [1][] = twintigjes, [2][] = tientjes

    public biljetOpties(int vijftig, int twintig, int tien){
        this.vijftig = vijftig;
        this.twintig = twintig;
        this.tien = tien;
    }

    public int[][] getOpties(int bedrag){
        if(bedrag % 10 != 0) return null; //Bij een ongeldig bedrag null returnen

        if(bedrag >= 50 && bedrag / 50 <= vijftig){
            opties[0][0] = bedrag / 50;
            bedrag%= 50;
        } else if(bedrag  >= 50){
            opties[0][0] = vijftig;
            bedrag-= vijftig*50;
        }
        
        if(bedrag >= 20 && bedrag / 20 <= twintig){
            opties[1][0] = bedrag / 20;
            bedrag%= 20;
        } else if(bedrag  >= 20){
            opties[1][0] = twintig;
            bedrag-= twintig*20;
        }

        if(bedrag >= 10 && bedrag / 10 <= tien){
            opties[2][0] = bedrag / 10;
            bedrag%= 10;
        } else if(bedrag  >= 10){
            opties[2][0] = tien;
            bedrag-= tien*10;
        }

        // while(true){
            
        // }

        return opties;
    }
}