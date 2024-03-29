package com.mygdx.SmallMap.LevelFrame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;

public class BulletTest extends Bullets{

    ParticleEffect rainbowEffect;
    public BulletTest(float x, float y, Level level)
    {
        super(x,y,level);
        curFrame = MyTextrue.ball;
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        damage = 200;
        MPConsume = 5f;
        speed = 600;
        bounceAble = true;
        bounceMax = 3;
        rainbowEffect = new ParticleEffect();
        rainbowEffect.load(Gdx.files.internal("particle/rainbow.particle"),Gdx.files.internal("particle"));
        rainbowEffect.start();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        rainbowEffect.setPosition(getX()+width/2,getY()+height/2);
        rainbowEffect.update(deltaTime);
        collideEnemy();
    }

    @Override
    public void draw(Batch batch) {
        //super.draw(batch);
        rainbowEffect.draw(batch);
    }

    @Override
    public void dispose() {
        super.dispose();
        rainbowEffect.dispose();
    }
}
