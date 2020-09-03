package popMusicPackage;


import general.*;
import org.springframework.stereotype.Component;

@Component("TestComponent")
public class PopMusic implements Music {

    @Override
    public String getSong() {
        return "Pop music";
    }
}
