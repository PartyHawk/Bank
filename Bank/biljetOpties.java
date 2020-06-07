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

        if(bedrag > 0 && bedrag / 10 <= tien){
            opties[2][0] = bedrag / 10;
        } else if(bedrag > 0){
            return null;
        }

        int count = 1;
        while(count < 10){
            if(opties[0][count-1] > 0 && ((twintig > 1 && tien > 0) || (twintig > 0 && tien > 2) || tien > 4)){ //als er een vijftigje is die gesplitst kan worden
                opties[0][count] = opties[0][count-1] - 1;
                if(twintig > 1){
                    opties[1][count] = opties[1][count-1] + 2;
                    opties[2][count] = opties[2][count-1] + 1;
                } else if (twintig > 0){
                    opties[1][count] = opties[1][count-1] + 1;
                    opties[2][count] = opties[2][count-1] + 3;
                } else {
                    opties[2][count] = opties[2][count-1] + 5;
                }
            } else if(opties[1][count-1] > 0 && tien > 1){ //als 20 gesplitst kan
                opties[1][count] = opties[1][count-1] - 1;
                opties[2][count] = opties[2][count-1] + 2;

            } else break; 
            count++;
        }

        return opties;
    }
}