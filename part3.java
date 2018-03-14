
/**
 * Write a description of part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part3 {
    public int findStopCodon(int startIndex, String dna){
        int taaIndex = dna.indexOf("TAA", startIndex+1);
        if (taaIndex == -1 
            || (taaIndex - startIndex) % 3 != 0) taaIndex = dna.length();
        int tagIndex = dna.indexOf("TAG", startIndex+1);
        if(tagIndex == -1
            || (tagIndex - startIndex) % 3 != 0) tagIndex = dna.length();
        int tgaIndex = dna.indexOf("TGA", startIndex+1);
        if(tgaIndex == -1
            || (tgaIndex - startIndex) % 3 != 0) tgaIndex = dna.length();
        
        int minIndex = Math.min(taaIndex, tagIndex);
        minIndex = Math.min(minIndex, tgaIndex);
        if (minIndex == dna.length()) return -1;
        else return minIndex;
    }

    public String findGene(String dna, int startIndex){
        int endCodon = findStopCodon(startIndex, dna);
        if (endCodon != -1){
            return dna.substring(startIndex, endCodon + 3);
        }
        else return "";          
    }
    
    public int countGenes(String dna){
        int startIndex = dna.indexOf("ATG");
        int currIndex = startIndex;
        int count = 0;
        while(true){
            if (currIndex == -1){
                return count;
            }
            else {
                count = count + 1;
                //System.out.println(findGene(dna, currIndex));
                currIndex = findStopCodon(currIndex, dna);               
            }          
        
    }
}

    public void testCoutGenes(){
        String dna1 = "ATGTAAGATGCCCTAGT";
        System.out.println(countGenes(dna1));
    }
}
