package com.mygdx.BigMap.otherActor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.BigMap.Screen.*;

public abstract class NPC extends Sprite {
    protected World world;
    protected PlayScreen screen;
    protected OutsidegambleRoomScreen screen1;
    protected OutsideweaponRoomScreen screen2;
    protected OutsidepowerRoomScreen screen3;
    protected OutsiderepairmanHomeScreen screen4;
    protected gambleRoomScreen screen5;
    protected repairmanHomeScreen screen6;
    protected weaponRoomScreen screen7;
    protected FireMapScreen screen8;
    protected PortalScreen screen9;
    protected SnowMapScreen screen10;
    protected SnowMapRoomScreen screen11;
    protected GrassMapScreen screen12;
    protected powerRoomScreen screen13;
    protected GrassMapRoomScreen screen14;
    public Body b2body;
    public NPC(PlayScreen screen, float x, float y){
        this.world=screen.getWorld();
        this.screen=screen;
        setPosition(x,y);
        defineNPC(x,y);
    }
    public NPC(OutsidegambleRoomScreen screen1, float x, float y){
        this.world=screen1.getWorld();
        this.screen1=screen1;
        setPosition(x,y);
        defineNPC(900,200);
    }
    public NPC(OutsideweaponRoomScreen screen2, float x, float y){
        this.world=screen2.getWorld();
        this.screen2=screen2;
        setPosition(x,y);
        defineNPC(600,200);
    }
    public NPC(OutsidepowerRoomScreen screen3, float x, float y){
        this.world=screen3.getWorld();
        this.screen3=screen3;
        setPosition(x,y);
        defineNPC(600,200);
    }
    public NPC(OutsiderepairmanHomeScreen screen4, float x, float y){
        this.world=screen4.getWorld();
        this.screen4=screen4;
        setPosition(x,y);
        defineNPC(600,200);
    }
    public NPC(gambleRoomScreen screen5, float x, float y){
        this.world=screen5.getWorld();
        this.screen5=screen5;
        setPosition(x,y);
        defineNPC(x,y);
    }
    public NPC(repairmanHomeScreen screen6, float x, float y){
        this.world=screen6.getWorld();
        this.screen6=screen6;
        setPosition(x,y);
        defineNPC(226,100);
    }
    public NPC(weaponRoomScreen screen7, float x, float y){
        this.world=screen7.getWorld();
        this.screen7=screen7;
        setPosition(x,y);
        defineNPC(226,160);
    }
    public NPC(FireMapScreen screen8, float x, float y){
        this.world=screen8.getWorld();
        this.screen8=screen8;
        setPosition(x,y);
        defineNPC(x,y);
    }
    public NPC(PortalScreen screen9, float x, float y){
        this.world=screen9.getWorld();
        this.screen9=screen9;
        setPosition(x,y);
        defineNPC(x,y);
    }
    public NPC(SnowMapScreen screen10, float x, float y){
        this.world=screen10.getWorld();
        this.screen10=screen10;
        setPosition(x,y);
        defineNPC(x,y);
    }
    public NPC(SnowMapRoomScreen screen11, float x, float y){
        this.world=screen11.getWorld();
        this.screen11=screen11;
        setPosition(x,y);
        defineNPC(x,y);
    }
    public NPC(GrassMapScreen screen12, float x, float y){
        this.world=screen12.getWorld();
        this.screen12=screen12;
        setPosition(x,y);
        defineNPC(x,y);
    }
    public NPC(powerRoomScreen screen13, float x, float y){
        this.world=screen13.getWorld();
        this.screen13=screen13;
        setPosition(x,y);
        defineNPC(x,y);
    }
    public NPC(GrassMapRoomScreen screen14, float x, float y){
        this.world=screen14.getWorld();
        this.screen14=screen14;
        setPosition(x,y);
        defineNPC(x,y);
    }

    protected abstract void defineNPC(float x,float y);
    public abstract void hitOnNPC();
}
