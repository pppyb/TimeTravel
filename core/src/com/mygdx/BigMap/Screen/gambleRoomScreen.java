package com.mygdx.BigMap.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.BigMap.*;
import com.mygdx.BigMap.Communication.Hud;
import com.mygdx.BigMap.Communication.NpcCommunication;
import com.mygdx.BigMap.Interface.gambleGameInterface;
import com.mygdx.BigMap.NPC.GambleRoomOwner;
import com.mygdx.BigMap.otherActor.Mario;
import com.mygdx.BigMap.NPC.Repairman;
import com.mygdx.BigMap.tools.B2WorldCreator;
import com.mygdx.BigMap.tools.WorldContactListener;

public class gambleRoomScreen implements Screen {
    public static MyGdxGame game;
    private Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;
    private static NpcCommunication npcCommunication;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private TiledMap map1;
    private OrthogonalTiledMapRenderer renderer;
    private World world;
    private Box2DDebugRenderer b2dr;
    private Mario mario;
    private TextureAtlas atlas;
    private Music music;
    private Repairman repairman;
    private GambleRoomOwner gambleRoomOwner;
    private TextureAtlas atlasRepairman;
    private TextureAtlas atlasGambleRoomOwner;
    private com.mygdx.BigMap.Interface.shopInterface shopInterface;
    public static int gambleRoomFlag=1;
    public static int gambleRoomCollisionFlag=0;
    public com.mygdx.BigMap.Interface.gambleGameInterface gambleGameInterface;

    public gambleRoomScreen(MyGdxGame game){
        atlas = new TextureAtlas("character/zhy.pack");
        atlasRepairman=new TextureAtlas("character/repairman.pack");
        atlasGambleRoomOwner=new TextureAtlas("character/gambleNPC.pack");
        this.game=game;
        gamecam=new OrthographicCamera();
        gamePort=new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam);
        //texture=new Texture("5.png");
        hud=new Hud(game.batch);
        npcCommunication=new NpcCommunication(game.batch);
        mapLoader=new TmxMapLoader();
        map=mapLoader.load("maps/gambleRoom.tmx");
        renderer=new OrthogonalTiledMapRenderer(map,1/MyGdxGame.PPM);
        gamecam.position.set(gamePort.getWorldWidth()/2,gamePort.getWorldHeight()/2,0);
        world=new World(new Vector2(0,0),true);
        b2dr=new Box2DDebugRenderer();
        new B2WorldCreator(world,map);
        mario=new Mario(world,this);
        world.setContactListener(new WorldContactListener());
        repairman=new Repairman(this,32f,32f);
        gambleRoomOwner=new GambleRoomOwner(this,32f,32f);
        gambleGameInterface=new gambleGameInterface();

        //music=MyGdxGame.manager.get("music/backgroundMusic.mp3",Music.class);
        //music.setLooping(true);
        // music.play();
    }
    public TextureAtlas getRepairmanAtlas(){
        return  atlasRepairman;
    }
    public TextureAtlas getGambleRoomOwnerAtlas(){
        return atlasGambleRoomOwner;
    }
    public TextureAtlas getAtlas(){
        return  atlas;
    }
    @Override
    public void show() {

    }
    public void handleInput(float dt){
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            mario.b2body.applyLinearImpulse(new Vector2(0,20f),mario.b2body.getWorldCenter(),true);
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            mario.b2body.applyLinearImpulse(new Vector2(0,-40f),mario.b2body.getWorldCenter(),true);
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) ) {
            mario.b2body.applyLinearImpulse(new Vector2(50f,0), mario.b2body.getWorldCenter(),true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) ) {
            mario.b2body.applyLinearImpulse(new Vector2(-100f,0), mario.b2body.getWorldCenter(),true);
        }
    }
    public void update(float dt){
        handleInput(dt);
        world.step(1/60f,6,2);
        mario.update(dt);
        repairman.update(dt);
        gambleRoomOwner.update(dt);
        npcCommunication.update();
        //System.out.println(mario.b2body.getPosition().x);
        //System.out.println(mario.b2body.getPosition().y);
        gamecam.position.x =mario.b2body.getPosition().x;
        gamecam.position.y =mario.b2body.getPosition().y;
        gamecam.update();
        renderer.setView(gamecam);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //renderer.render();
        b2dr.render(world, gamecam.combined);
        renderer.render();
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        mario.draw(game.batch);
        repairman.draw(game.batch);
        gambleRoomOwner.draw(game.batch);
        game.batch.end();
        if(gambleRoomCollisionFlag==1 && gambleGameInterface.gamble_flag==0) {
            Gdx.input.setInputProcessor(gambleGameInterface.stage);
            gambleGameInterface.render();
        }
        if(PlayScreen.collisionFlag==1) {
            npcCommunication.render();
            npcCommunication.stage.draw();
        }
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        map.dispose();
        world.dispose();
        renderer.dispose();
        b2dr.dispose();
        hud.dispose();
    }
    public static void changeToMainScreen(){
        game.setScreen(new PlayScreen(game,253,368));
    }

    public World getWorld() {
        return this.world;
    }
}

