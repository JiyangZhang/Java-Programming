
/**
 * Write a description of part1 here.
 * 
 * @author Jiyang Zhang 
 * @version (a2018.03.13)
 */
public class part1 {
    private class innerPart1 {
        /** test for inner class.
         *  Test method
         */
        private void testInner() {
            System.out.println("Test the parser.");
        }
    }
    
    /** This is findStopCodon method */
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
    
    public void printAllGenes(String dna){
        int startIndex = dna.indexOf("ATG");
        int currIndex = startIndex;
        while(true){
            if (currIndex == -1){
                System.out.println("");
                break;
            }
            else {
               System.out.println(findGene(dna, currIndex));
               currIndex = findStopCodon(currIndex, dna);               
            }            
        }
    }
    public void test(){
        String dna = "AATGCTAACTAGCTGACTAAT";
        printAllGenes(dna);
    }
}
