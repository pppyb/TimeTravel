package com.mygdx.game.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.*;


public class Repairman extends NPC {
    private float stateTime;
    private Animation repairmanRightRun;
    private Animation turnAround;
    private Animation repairmanLeftRun;
    private Animation repairmanUpRun;
    private Animation repairmanDownRun;
    private Array<TextureRegion> frames;
    private boolean Stop=true;
    public BodyDef bdef;
    public Repairman(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,98,48,49));
            repairmanRightRun=new Animation(0.1f,frames);
            frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,49,48,49));
            repairmanLeftRun=new Animation(0.1f,frames);
            frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,147,48,49));
            repairmanUpRun=new Animation(0.1f,frames);
            frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,0,48,49));
            repairmanDownRun=new Animation(0.1f,frames);
            frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,0,48,49));
            turnAround=new Animation(0.1f,frames);
            frames.clear();
            stateTime=0;
            setBounds(getX(),getY(),24,24);
    }
    public Repairman(OutsidegambleRoomScreen screen, float x, float y) {
        super(screen, x, y);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,98,48,49));
        repairmanRightRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,49,48,49));
        repairmanLeftRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,147,48,49));
        repairmanUpRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,0,48,49));
        repairmanDownRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,0,48,49));
        turnAround=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),24,24);
    }
    public Repairman(OutsideweaponRoomScreen screen, float x, float y) {
        super(screen, x, y);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,98,48,49));
        repairmanRightRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,49,48,49));
        repairmanLeftRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,147,48,49));
        repairmanUpRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,0,48,49));
        repairmanDownRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,0,48,49));
        turnAround=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),24,24);
    }
    public Repairman(OutsidepowerRoomScreen screen, float x, float y) {
        super(screen, x, y);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,98,48,49));
        repairmanRightRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,49,48,49));
        repairmanLeftRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,147,48,49));
        repairmanUpRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,0,48,49));
        repairmanDownRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,0,48,49));
        turnAround=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),24,24);
    }
    public Repairman(OutsiderepairmanHomeScreen screen, float x, float y) {
        super(screen, x, y);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,98,48,49));
        repairmanRightRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,49,48,49));
        repairmanLeftRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,147,48,49));
        repairmanUpRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,0,48,49));
        repairmanDownRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,0,48,49));
        turnAround=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),24,24);
    }
    public Repairman(gambleRoomScreen screen, float x, float y) {
        super(screen, x, y);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,98,48,49));
        repairmanRightRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,0,48,49));
        turnAround=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),24,24);
    }
    public void update(float dt){
        stateTime+=dt;
        if(b2body.getPosition().x<730&&b2body.getPosition().y<=200&&Stop&&PlayScreen.PlayScreenFlag==0){
            b2body.setLinearVelocity(20,0);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) repairmanRightRun.getKeyFrame(stateTime, true));
        }
        else if(b2body.getPosition().x>730&&b2body.getPosition().y<446&&Stop&&PlayScreen.PlayScreenFlag==0){
            b2body.setLinearVelocity(0,20);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) repairmanUpRun.getKeyFrame(stateTime, true));
        }
        else if(b2body.getPosition().x>470&&b2body.getPosition().y>446&&Stop&&PlayScreen.PlayScreenFlag==0){
            b2body.setLinearVelocity(-20,0);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) repairmanLeftRun.getKeyFrame(stateTime, true));
        }
        else if(b2body.getPosition().x<470&&b2body.getPosition().y>200&&Stop&&PlayScreen.PlayScreenFlag==0){
            b2body.setLinearVelocity(0,-20);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) repairmanDownRun.getKeyFrame(stateTime, true));
        }

        if(PlayScreen.collisionFlag==1) {
            b2body.setLinearVelocity(0,0);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) turnAround.getKeyFrame(stateTime, true));
            if(npcCommunication.Count==4)
            b2body.setLinearVelocity(0,100);
            //setBounds(0,0,0,0);
            //b2body.setLinearVelocity(0,10000);
            Stop=false;
        }

    }
    @Override
    protected void defineNPC(int x, int y) {
        bdef=new BodyDef();
        //NPC初始位置
        bdef.position.set(x,y);
        bdef.type=BodyDef.BodyType.KinematicBody;
        bdef.linearVelocity.set(20,0);//731,199,731,446
        b2body=world.createBody(bdef);
        
        FixtureDef fdef=new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(5/MyGdxGame.PPM);
        //NPC分类
        fdef.filter.categoryBits=MyGdxGame.NPC_BIT;
        //NPC可以交互的对象
        fdef.filter.maskBits=MyGdxGame.DOOR_BIT | MyGdxGame.DEFAULT_BIT | MyGdxGame.NPC_BIT | MyGdxGame.Brick_BIT | MyGdxGame.MARIO_BIT;
        fdef.shape=shape;
        fdef.filter.categoryBits=MyGdxGame.NPC_OBJECT_BIT;
        b2body.createFixture(fdef).setUserData(this);
    }

    @Override
    public void hitOnNPC() {
        Gdx.app.log("Repairman","Collision");
        PlayScreen.collisionFlag=1;

    }
}
