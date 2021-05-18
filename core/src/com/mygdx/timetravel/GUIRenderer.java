package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GUIRenderer {
    Level level;
    public GUIRenderer(Level level)
    {
        this.level = level;
    }
    public void render(Batch batch)
    {
        drawPlayerState(batch);
    }
    public void drawPlayerState(Batch batch)
    {
        TextureRegion imgHP = new TextureRegion(new Texture(Gdx.files.internal("GUI/HP.png")));
        TextureRegion imgMP = new TextureRegion(new Texture(Gdx.files.internal("GUI/MP.png")));
        TextureRegion imgJP = new TextureRegion(new Texture(Gdx.files.internal("GUI/JP.png")));
        TextureRegion imgDP = new TextureRegion(new Texture(Gdx.files.internal("GUI/DP.png")));
        //
        if(!level.curPlayer.isAlive)
            batch.setColor(1,0,0,1);
        batch.draw(level.curPlayer.imgHead,0,Constants.WINDOWS_HEIGHT-Constants.HPRECHEIGHT*4,4*Constants.HPRECHEIGHT,4*Constants.HPRECHEIGHT);
        //
        batch.setColor(0.5f,0.5f,0.5f,0.75f);
        batch.draw(imgHP,4*Constants.HPRECHEIGHT,Constants.WINDOWS_HEIGHT-Constants.HPRECHEIGHT,Constants.HPRECWIDTHRATE*level.curPlayer.maxHP,Constants.HPRECHEIGHT);
        batch.draw(imgMP,4*Constants.HPRECHEIGHT,Constants.WINDOWS_HEIGHT-Constants.HPRECHEIGHT*2,Constants.HPRECWIDTHRATE*level.curPlayer.maxMP,Constants.HPRECHEIGHT);
        batch.draw(imgJP,4*Constants.HPRECHEIGHT,Constants.WINDOWS_HEIGHT-Constants.HPRECHEIGHT*3,Constants.HPRECWIDTHRATE*level.curPlayer.maxJumpPoint,Constants.HPRECHEIGHT);
        batch.draw(imgDP,4*Constants.HPRECHEIGHT,Constants.WINDOWS_HEIGHT-Constants.HPRECHEIGHT*4,Constants.HPRECWIDTHRATE*level.curPlayer.maxDashPoint,Constants.HPRECHEIGHT);
        //
        batch.setColor(1,1,1,1);
        batch.draw(imgHP,4*Constants.HPRECHEIGHT,Constants.WINDOWS_HEIGHT-Constants.HPRECHEIGHT,Constants.HPRECWIDTHRATE*level.curPlayer.curHP,Constants.HPRECHEIGHT);
        batch.draw(imgMP,4*Constants.HPRECHEIGHT,Constants.WINDOWS_HEIGHT-Constants.HPRECHEIGHT*2,Constants.HPRECWIDTHRATE*level.curPlayer.curMP,Constants.HPRECHEIGHT);
        batch.draw(imgJP,4*Constants.HPRECHEIGHT,Constants.WINDOWS_HEIGHT-Constants.HPRECHEIGHT*3,Constants.HPRECWIDTHRATE*level.curPlayer.curJumpPoint,Constants.HPRECHEIGHT);
        batch.draw(imgDP,4*Constants.HPRECHEIGHT,Constants.WINDOWS_HEIGHT-Constants.HPRECHEIGHT*4,Constants.HPRECWIDTHRATE*level.curPlayer.curDashPoint,Constants.HPRECHEIGHT);
    }
}