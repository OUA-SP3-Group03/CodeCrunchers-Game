package io.codecrunchers.providers;

import io.codecrunchers.core.Application;
import io.codecrunchers.core.Provider;
import io.codecrunchers.facades.App;
import io.codecrunchers.service.LoopService;

import java.awt.*;

public class LoopServiceProvider extends Provider {

    private boolean running;
    private App app;
    private LoopService loopService;


    @Override
    public void boot(App app) {
        this.app = app;
        this.running = false;
        this.loopService = new LoopService(this, app);

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

    public boolean getRunningStatus(){
        return this.running;
    }

    public void setRunningStatus(boolean status){
        this.running = status;
    }

    public Application getApplication(){
        return this.app.self();
    }

    public int getFPSTarget(){
        return this.app.config().targetFPS();
    }

    public int getTPSTarget(){
        return this.app.config().targetTPS();
    }

    public int getCurrentFPS(){
        return this.loopService.getCurrentFPS();
    }

    public int getCurrentTPS(){
        return this.loopService.getCurrentTPS();
    }

    public int getUsedMemory(){
        return this.loopService.getUsedMemory();
    }

    public void startLoop(){
        this.loopService.start();
    }

}
