package com.mygdx.BigMap.NPC;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Array;
import com.mygdx.BigMap.otherActor.NPC;
import com.mygdx.BigMap.MyGdxGame;
import com.mygdx.BigMap.Screen.powerRoomScreen;

public class powerRoomOwner extends NPC {
    private float stateTime;
    private Animation PowerRoomOwnerStand;
    private Array<TextureRegion> frames;
    public BodyDef bdef;
    public powerRoomOwner(powerRoomScreen screen, float x, float y) {
        super(screen, 187, 236);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getPowerRoomOwnerAtlas().findRegion("GambleRoomOwner"),48*i,0,48,49));
        PowerRoomOwnerStand=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),24,24);
    }
    @Override
    protected void defineNPC(float x, float y) {
        bdef=new BodyDef();
        //NPC初始位置
        bdef.position.set(x,y);
        bdef.type=BodyDef.BodyType.StaticBody;
        b2body=world.createBody(bdef);

        FixtureDef fdef=new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(5/ MyGdxGame.PPM);
        //NPC分类
        fdef.filter.categoryBits=MyGdxGame.NPC_BIT;
        //NPC可以交互的对象
        fdef.filter.maskBits=MyGdxGame.DOOR_BIT | MyGdxGame.DEFAULT_BIT | MyGdxGame.NPC_BIT | MyGdxGame.Brick_BIT | MyGdxGame.MARIO_BIT;
        fdef.shape=shape;
        fdef.filter.categoryBits=MyGdxGame.NPC_OBJECT_BIT;
        b2body.createFixture(fdef).setUserData(this);
    }
    public void update(float dt) {
        stateTime += dt;
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
        setRegion((TextureRegion) PowerRoomOwnerStand.getKeyFrame(stateTime, true));
    }

    @Override
    public void hitOnNPC() {
        powerRoomScreen.powerRoomCollisionFlag=1;
    }
}
