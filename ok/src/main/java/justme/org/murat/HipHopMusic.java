package justme.org.murat;

import java.util.ArrayList;
import java.util.Random;

public class HipHopMusic implements Music{
    Random random = new Random();
    ArrayList<String> hipHopSongs = new ArrayList<>(){{
        add("ALL OF THE LIGHTS!!!");
        add("POWER");
        add("WOLVES");
    }};
    @Override
    public String getSong(){
        return hipHopSongs.get(random.nextInt(hipHopSongs.size()));
    }

}
