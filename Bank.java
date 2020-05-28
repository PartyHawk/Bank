//https://git-scm.com/downloads

// git config --global user.name "Pim"
// git config --global user.email "Je@oma.nl"

// git init             deze twee in een folder zonder git
// git clone [link]

// git status
// git log
// git add .                . = alles
// git commit -m "hoi"

// git checkout [hash] 
// git checkout -b [name]   checkout to an new branch
// git branch <name>        geen naam geeft lijst, -d voor delete


// git remote -v            alleremotes
// git remote add [naam] [link]
// git push -u [naam remote] [naam branch]    -u geeft aan vanaf nu altijd naar origin master

// git pull [naam remote] [naam branch]

public class Bank{
    public static void main(String[] args) {
        SQLCon sql = new SQLCon();
        sql.test();

        // biljetOpties bO = new biljetOpties(10, 10, 20);
        // 
        // int[][] opties = bO.getOpties(120);
        // int i = 0;
        // while(opties[0][i] != 0 || opties[1][i] != 0 || opties[2][i] != 0){
        //     System.out.println("Optie " + (i +1));
        //     System.out.println("\t50: " + opties[0][i]);
        //     System.out.println("\t20: " + opties[1][i]);
        //     System.out.println("\t10: " + opties[2][i]);
        //     i++;
        // }
    }
}
