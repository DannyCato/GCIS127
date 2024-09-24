package unit13.haunted;

import java.util.Random;

public class EvilPresenceUtil {
    private final static String[] PRESENCES = {"Ghost","Werewolf","Vampire",
    "Chainsaw-wielding Clown","Demon","Specter","Phantom","Wraith",
    "Apparition","Evil Spirit","Slimer","Zuul",
    "Stay Puft Marshmallow Man","Gozer"};

    private final static int PRESENCE_PROBABILITY = 40;
    private final static Random RNG = new Random();

    public static String getRandomPresence() {
        if (RNG.nextInt(100) < PRESENCE_PROBABILITY) {
            return PRESENCES[RNG.nextInt(PRESENCES.length)];

        } else 
            return null;
    }
}
