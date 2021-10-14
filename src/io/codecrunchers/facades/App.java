package io.codecrunchers.facades;

import io.codecrunchers.classes.gui.InterfaceObject;
import io.codecrunchers.classes.states.State;
import io.codecrunchers.core.Application;
import io.codecrunchers.core.Kernel;
import io.codecrunchers.providers.*;

import java.awt.*;

public class App {

    private final Kernel kernel;
    private final Config config;
    private final Callback callback;

    public App(Kernel kernel){
        this.kernel = kernel;
        this.config = new Config(this.kernel);
        this.callback = new Callback(this.kernel);
    }

    //**** GET INSTANCE OF THE APPLICATION ****\\
    public Application self(){
        return this.kernel.getApplication();
    }

    //**** GET CONFIG ****\\
    public Config config(){
        return this.config;
    }

    public Callback callback() {
        return this.callback;
    }

    public boolean booted(){
        return this.kernel.getBootedStatus();
    }

    //**** GET INSTANCE OF THE CANVAS ****\\
    public Canvas canvas(){
        return ((DisplayServiceProvider) this.kernel.getServiceProvider("display")).getCanvas();
    }

    //**** RENDER PROVIDERS FACADE ****\\
    public void render(Graphics g){
       this.kernel.render(g);
    }

    //**** TICK PROVIDERS FACADE ****\\
    public void tick(){
        this.kernel.tick();
    }

    //**** START LOOP CALL ****\\
    public void startLoop(){
        ((LoopServiceProvider)this.kernel.getServiceProvider("loop")).startLoop();
    }

    //**** LOGIN HTTP CALL ****\\
    public String authLogin(String email, String password){
        return ((HttpServiceProvider) this.kernel.getServiceProvider("http")).login(email, password);
    }

    //**** CHECK LOGIN HTTP CALL ****\\
    public String authCheck(String token){
        return ((HttpServiceProvider) this.kernel.getServiceProvider("http")).check(token);
    }

    //**** LOGOUT HTTP CALL ****\\
    public String authLogout(String token){
        return ((HttpServiceProvider) this.kernel.getServiceProvider("http")).logout(token);
    }

    //**** CURRENT STATE ****\\
    public State state(){
        //returns the current state
        return new State();
    }

    //**** ADD GUI OBJECT ****\\
    public void addInterfaceObject(InterfaceObject newObject){
        ((InterfaceServiceProvider) this.kernel.getServiceProvider("interface")).addInterfaceObject(newObject);
    }

    //**** INPUTS ****\\
    public Boolean keyPressed(char key) {
        return ((KeyboardServiceProvider) this.kernel.getServiceProvider("keyboard")).keyCodes.containsKey((int) key);


    public Boolean mousePressed() {
        return ((MouseServiceProvider) this.kernel.getServiceProvider("mouse")).isMousePressed();
    }

    public int mouseX() {
        return ((MouseServiceProvider) this.kernel.getServiceProvider("mouse")).getMouseX();
    }

    public int mouseY() {
        return ((MouseServiceProvider) this.kernel.getServiceProvider("mouse")).getMouseY();
    }

}