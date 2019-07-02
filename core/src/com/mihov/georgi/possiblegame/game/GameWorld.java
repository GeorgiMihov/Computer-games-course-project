package com.mihov.georgi.possiblegame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mihov.georgi.possiblegame.PossibleGame;
import com.mihov.georgi.possiblegame.assets.Assets;
import com.mihov.georgi.possiblegame.listener.B2dContactListener;
import com.mihov.georgi.possiblegame.model.Ground;
import com.mihov.georgi.possiblegame.model.Player;
import com.mihov.georgi.possiblegame.screen.MenuScreen;

public class GameWorld {
    //main game logic
    private PossibleGame possibleGame;
    private World physicsWorld;
    private Stage stage;
    private float worldWidth;
    private int score;//to be used later
    //insert game objects here
    private Player player;
    private Texture playerTex;
    private Ground ground;
    private Box2DDebugRenderer debugRenderer;
    private SpriteBatch batch;


    public GameWorld(PossibleGame possibleGame) {
        this.possibleGame = possibleGame;

        this.physicsWorld = new World(new Vector2(0.00f,-11f),false);
        this.physicsWorld.setContactListener(new B2dContactListener());

        float ratio = (float) Gdx.graphics.getHeight() / (float)Gdx.graphics.getWidth() ;
        this.worldWidth = PossibleGame.WORLD_HEIGHT / ratio;
        this.stage = new Stage(new StretchViewport(worldWidth,PossibleGame.WORLD_HEIGHT));

        this.playerTex = possibleGame.assets.manager.get(Assets.player, Texture.class);
        this.player = new Player(possibleGame, physicsWorld, playerTex, 0.25f,PossibleGame.WORLD_HEIGHT / 2,1,1);
        this.stage.addActor(player);

        ground = new Ground(possibleGame,physicsWorld,stage,0);

        batch = new SpriteBatch();
        debugRenderer = new Box2DDebugRenderer();


    }

    public void render() {
        this.stage.draw();
        physicsWorld.step(Gdx.graphics.getDeltaTime(), 6, 2);
    }

    public void update() {
        this.stage.act();
        this.stage.getCamera().position.x = player.getX() + 2;
        //test
        if (Gdx.input.justTouched() && player.getJumpCounter() > 0) {
            this.player.jump();
        }

        if(possibleGame.gameState == PossibleGame.GAME_STATE.MENU) {
            possibleGame.setScreen(new MenuScreen(possibleGame));
        }
        ground.regenrate();

        batch.setProjectionMatrix(stage.getCamera().combined);
        batch.begin();
        debugRenderer.render(physicsWorld, stage.getCamera().combined);
        batch.end();
        //more
    }
}
