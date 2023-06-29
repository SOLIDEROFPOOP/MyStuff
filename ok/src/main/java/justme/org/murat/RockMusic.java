package justme.org.murat;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

/*@Component*/
public class RockMusic implements Music{
    Random random = new Random();
    ArrayList<String> RockMusicList = new ArrayList<>(){{
       add("Smoke on the Water");
       add("Creep");
       add("Paranoid");
    }};
    @Override
    public String getSong() {
        return RockMusicList.get(random.nextInt(RockMusicList.size()));
    }
}
