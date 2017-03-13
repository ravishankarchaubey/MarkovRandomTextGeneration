import java.util.*;
/**
 * Write a description of MarkovFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarkovFour {
    private String myText;
    private Random myRandom;
    
    public MarkovFour() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index=myRandom.nextInt(myText.length()-4);
        String key=myText.substring(index,index+4);
        sb.append(key);
        for(int k=0;k <numChars-4;k++){
            ArrayList<String> follows=getFollows(key);
            if(follows.size()==0){
                break;
            }
            index=myRandom.nextInt(follows.size());
            String next=follows.get(index);
            sb.append(next);
            key=key.substring(1)+next;
        }
        return sb.toString();
    }
    
    public ArrayList<String> getFollows(String key){
        ArrayList<String> follow=new ArrayList<String>();
        for(int i=0;i<myText.length()-key.length();++i){
            if(key.equals(myText.substring(i,i+key.length()))){
                follow.add(myText.substring(i+key.length(),i+key.length()+1));
            }
        }
        /*int pos=0;
        while(pos<myText.length()){
            int idx=myText.indexOf(key);
            if(idx!=-1){
                follow.add(myText.substring(idx+key.length(),idx+key.length()+1));
            }
            pos=idx+key.length()+1;
        }*/
        return follow;
    }
}
