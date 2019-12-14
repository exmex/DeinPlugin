package gemestates;


import countodwn.LobbyCountdown;

/**
 * Created by regnatrix on 10/23/16.
 */
public class LobbyState extends GameState{


    public static final int MIN_PLAYERS = 2,
                            MAX_PLAERS = 2;


    private LobbyCountdown countdown;



    @Override
    public void init() {

        countdown = new LobbyCountdown();

    }

    @Override
    public void end() {

    }

    public LobbyCountdown getCountdown() {
        return countdown;
    }


}
