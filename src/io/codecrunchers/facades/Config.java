package io.codecrunchers.facades;

import io.codecrunchers.core.Kernel;

public class Config {

    public final Kernel kernel;

    public Config(Kernel kernel){
        this.kernel = kernel;
    }

    //*** GET INTERFACE WIDTH ****\\
    public int interfaceWidth(){
        return this.kernel.getConfig().interfaceWidth;
    }

    //*** GET INTERFACE HEIGHT ****\\
    public int interfaceHeight(){
        return this.kernel.getConfig().interfaceHeight;
    }

    //*** GET INTERFACE TITLE ****\\
    public String interfaceTitle(){
        return this.kernel.getConfig().title;
    }

    //**** GET TARGET FPS & TPS ****\\
    public int targetFPS(){
        return this.kernel.getConfig().targetFPS;
    }

    //**** GET SHOW FPS ****\\
    public boolean showFPS(){
        return this.kernel.getConfig().showFPS;
    }

    //**** GET API URL ****\\
    public String apiUrl(){
        return this.kernel.getConfig().apiUrl;
    }
}