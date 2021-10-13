package io.codecrunchers.core;

import io.codecrunchers.facades.App;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Application {

    private final App app;

    public Application(App app){

        //set this app equal to the app facade
        this.app = app;

        if(this.app.booted()){
            this.app.startLoop();
        }else{
            System.out.println("Application failed to boot");
        }
    }

    public void tick(){
        this.app.tick();
    }

    public void render(){
        //create buffered strategy for the app canvas
        BufferStrategy bs = this.app.canvas().getBufferStrategy();
            if(bs == null){
                this.app.canvas().createBufferStrategy(3);
                return;
            }

       //create the graphics object to draw to that buffered strategy
       Graphics g = bs.getDrawGraphics();
       g.clearRect(0,0,this.app.config().interfaceWidth(),this.app.config().interfaceHeight());

       //__ START RENDER

           //PLACEHOLDER TESTING
           g.drawString("Hello World!",20,20);
           g.setColor(Color.red);
           g.drawRect(50,50,100,100);

           //render providers
           this.app.render(g);


       //__ END RENDER

       //finally show the buffered strategy and dispose of the old graphics
       bs.show();
       g.dispose();
    }

}