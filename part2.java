
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part2 {
    public int howMany(String stringa, String stringb){
        int occurence = 0;
        //int startIndex = 0;
        int currIndex = 0;
        while(true){
            currIndex = stringb.indexOf(stringa, currIndex);
            if (currIndex == -1 || occurence > 10) break;
            else {
                occurence = occurence + 1;
                //currIndex = currIndex + stringa.length();
            }
        }
        return occurence;
    }
    
    public void testHowMany(){
        String a = "GAA";
        String b = "ATGAACGAATTGAATC";
        String c = "AA";
        String d = "ATAAAA";
        System.out.println(howMany(a,b));
        System.out.println(howMany(c,d));
    }

}
