import java.util.*;
import edu.duke.*;
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester {
    public void testGetFollows(){
        MarkovOne markov=new MarkovOne();
        markov.setTraining("this is a test yes this is a test.");
        ArrayList<String> al=markov.getFollows("es");
        System.out.println(al);
        System.out.println(al.size());
    }
    
    public void testGetFollowsWithFile(){
        MarkovOne markov=new MarkovOne();
        FileResource fr=new FileResource();
        String st=fr.asString();
        st=st.replace('\n',' ');
        markov.setTraining(st);
        ArrayList<String> al=markov.getFollows("he");
        System.out.println(al);
        System.out.println(al.size());
    }
}
