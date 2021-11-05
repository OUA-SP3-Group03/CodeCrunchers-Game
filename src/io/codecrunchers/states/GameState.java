package io.codecrunchers.states;

import io.codecrunchers.engine.ASCII;
import io.codecrunchers.engine.core.State;
import io.codecrunchers.engine.entity.Entity;
import io.codecrunchers.entities.creatures.Player;
import io.codecrunchers.engine.facades.App;

import java.awt.*;

public class GameState extends State {

    private App app;
    Entity player;

    @Override
    public void boot(App app) {
        this.app = app;
        int[] World;
        String worldRaw="00000222000000000000" +
                        "00000000000000000000" +
                        "00000000000000000000" +
                        "00000000000000000000" +
                        "00000000000222200000" +
                        "00000000000000000000" +
                        "00022222200000000000" +
                        "00000000000220220220" +
                        "00000022220000000000" +
                        "00000000000000000000" +
                        "11111111111111111111";
        int worldWidth=20;
        int worldHeight=11;
        World=new int[worldRaw.length()];

        for(int i=0;i<worldRaw.length();i++){
            World[i]=worldRaw.charAt(i)-'0';
        }

        this.app.setWorldWidth(worldWidth);
        this.app.setWorldHeight(worldHeight);
        this.app.setWorld(World);

        player = new Player(0, 0, 64, 64, this.app);
        this.app.registerEntity(player);
    }

    public void tick() {
        if(this.app.keyPressed().containsKey(ASCII.escape)){
            this.app.keyPressed().remove(ASCII.escape);
            this.app.setCurrentState("pause");
        }

        this.app.getCamera().centerOnEntity(player);
    }
    public void render(Graphics g) {

    }
}