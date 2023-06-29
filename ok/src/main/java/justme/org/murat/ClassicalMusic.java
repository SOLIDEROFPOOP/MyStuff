package justme.org.murat;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

/*@Component*/
public class ClassicalMusic implements Music{
    Random random = new Random();
    public ClassicalMusic(){};
    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }
    public ArrayList<String> ClassicalSongs = new ArrayList<>(){{
        add("Hungarian Rhapsody");
        add("Moonlight Sonata");
        add("Fur Elise");
    }};
    @Override
    public String getSong(){
        return ClassicalSongs.get(random.nextInt(ClassicalSongs.size()));
    }

}
