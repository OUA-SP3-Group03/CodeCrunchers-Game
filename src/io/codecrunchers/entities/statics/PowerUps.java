package io.codecrunchers.entities.statics;

import io.codecrunchers.engine.entity.StaticEntity;

import java.awt.*;

public class PowerUps extends StaticEntity {

    public PowerUps(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public void die() {

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }


}