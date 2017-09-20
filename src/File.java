import com.company.CharacterReader;

/**
 * Created by nezife on 12/19/15.
 */
public class File extends Thread {
    private Map<Character, Long> histogram;
    private CharacterReader cr;

    public File(Map<Character, Long> histogram, CharacterReader cr){
        this.histogram = histogram;
        this.cr = cr
    }

    public void run(){
        Character c;
        try{
            while ((c == cr.getNextChar()) != null){
                if (!Character.isLetter(c)){
                    continue;
                }
                c = Character.toLowerCase(c);
                Long count = this.histogram.get(c);
                if(count == 0) {
                    this.histogram.put(c, 1L);
                } else{
                    this.histogram.put(c, count + 1);
                }
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
