package io.codecrunchers.providers;

import io.codecrunchers.core.Provider;
import io.codecrunchers.facades.App;
import io.codecrunchers.service.DisplayService;

import java.awt.*;

public class DisplayServiceProvider extends Provider {

    private Canvas displayCanvas;

    public DisplayService display;

    @Override
    public void boot(App app) {
       //create a new instance of the display service
       this.display = new DisplayService(app.config().interfaceTitle(), app.config().interfaceWidth(), app.config().interfaceHeight(),app);
       //set the canvas from the new display service
       this.displayCanvas = display.createDisplay();

        this.display.frame.addKeyListener(((KeyboardServiceProvider)app.getProvider("keyboard")));

        this.booted = true;
    }

    @Override
    public boolean performTick() {
        return false;
    }

    @Override
    public boolean performRender() {
        return false;
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void tick() {

    }

    public Canvas getCanvas(){
        return this.displayCanvas;
    }

}
