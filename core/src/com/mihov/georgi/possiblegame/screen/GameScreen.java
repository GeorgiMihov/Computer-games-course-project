package com.mihov.georgi.possiblegame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mihov.georgi.possiblegame.PossibleGame;
import com.mihov.georgi.possiblegame.game.GameWorld;

public class GameScreen implements Screen {

    private PossibleGame possibleGame;
    private GameWorld gameWorld;
    private SpriteBatch batch;
    private OrthographicCamera camera;//ui elements and hud,etc.
    private Texture img;


    public GameScreen(PossibleGame possibleGame) {
        this.possibleGame = possibleGame;
    }

    @Override
    public void show() {
        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, PossibleGame.WIDTH, PossibleGame.HEIGHT);
        this.gameWorld = new GameWorld(this.possibleGame);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(39/255f, 39/255f, 39/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        //batch.draw(img, 0, 0);
        batch.end();
        gameWorld.render();

        this.gameWorld.update();
        this.camera.update();
    }

    @Override
    public void resize(int width, int height) {

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
        batch.dispose();
    }


    //this.img = new Texture("img/badlogic.jpg");
    // this.img = possibleGame.assets.manager.get(Assets.badlogic, Texture.class);
    // the assets need to be loaded first (in the Splashscreen) this was part of show()
}
